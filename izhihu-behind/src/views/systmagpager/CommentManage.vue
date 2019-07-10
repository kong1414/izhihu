<template>
  <div class="base-container comment-page">
    <div class="header">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>评论管理</el-breadcrumb-item>
      </el-breadcrumb>
      <h1>评论管理</h1>
    </div>
    <div class="main">
      <div class="main-header">
        <div>
          <!-- <el-button type="primary" @click="addDialogVisible = true">新增用户</el-button> -->
          <!-- <el-button type="danger">批量删除</el-button> -->
        </div>
        <div>
          <el-input style="width: 250px;" v-model.trim.lazy="searchContent" placeholder="请输入内容搜索">
            <i style="margin: 12px 5px 0 0;font-size:16px" class="el-icon-search" slot="suffix"></i>
          </el-input>
        </div>
      </div>
      <el-table
        :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        v-loading="loading"
        style="width: 100%;margin: 10px 0">
        <el-table-column label="评论id" width="60px">
          <template slot-scope="scope">
            <span>{{scope.row.id}}</span>
          </template>
        </el-table-column>
        <el-table-column label="评论的对象" min-width="100px">
          <template slot-scope="scope">
            <span>{{scope.row.comment_id}}</span>
          </template>
        </el-table-column>
        <el-table-column label="评论内容" min-width="100px" prop="comment_content">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.comment_content}}</span>
          </template> -->
        </el-table-column>
        <el-table-column label="评论人" min-width="100px" sortable prop="name">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.name}}</span>
          </template> -->
        </el-table-column>
        <el-table-column label="子评论">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.is_reply==1" size="mini">是</el-tag>
            <el-tag v-if="scope.row.is_reply==0" size="mini" type="success">不是</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="点赞数" sortable prop="praise_num">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.praise_num}}</span>
          </template> -->
        </el-table-column>
        <el-table-column label="创建时间" sortable prop="create_time">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.create_time}}</span>
          </template> -->
        </el-table-column>
        
        <el-table-column label="操作" width="100px" fixed="right">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="currentPage"
                        :page-sizes="[10, 20, 30, 40]"
                        :page-size="pagesize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="parseInt(tableData.length)">
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import {reqFindComment,reqDelComment} from '../../api/sysManager'
import dataUtil from '../../util/dataUtil';
export default {
  name: 'CommentManage',
  data () {
    return {
      loading: true,
      searchContent: '',
      tableData: [],
      pagesize: 10,
      currentPage: 1,
    }
  },
  watch: {
    searchContent () {
      let timer
      if (timer) { // 优化搜索请求
        clearTimeout(timer)
      }
      timer = setTimeout(() => {
        this._loadData()
      }, 500)
    }
  },
  mounted () {
    this._loadData()
  },
  methods: {
    _loadData () {
      this.loading = true
      let params = 'keyword='+ this.searchContent
      reqFindComment(params).then(res => {
        if (res.resultCode == 200) {
          this.tableData = res.data.map(i => {
            i.create_time = dataUtil.getStrData(i.create_time)
            return i
          })
          this.loading = false
        }
      })
    },
    handleSizeChange (val) {
      this.pagesize = val
      this._loadData()
    },
    handleCurrentChange (val) {
      this.currentPage = val
      this._loadData()
    },
    handleDelete (index, row) {
      this.$confirm('此操作将永久删除评论且无法恢复，是否继续?，是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params = 'id=' + row.id
        reqDelComment(params).then(res => {
          if (res.resultCode === 200) {
            this.$message({
              type: 'success',
              message: res.resultMessage
            })
            this._loadData()
          }
        })

      }).catch(() => {
      })
    }
  }
}
</script>

<style lang="scss">
.comment-page {
  .main {
    .main-header {
      display: flex;
      justify-content: space-between;
    }
  }
}
</style>
