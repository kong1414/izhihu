<template>
  <div class="base-container article-page">
    <div class="header">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>文章管理</el-breadcrumb-item>
      </el-breadcrumb>
      <h1>文章管理</h1>
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
        <el-table-column
          type="index"
          width="50">
        </el-table-column>
        <el-table-column label="类型">
          <template slot-scope="scope">
            <!-- <span>{{scope.row.type}}</span> -->
            <el-tag v-if="scope.row.type==1" size="mini">回答</el-tag>
            <el-tag v-if="scope.row.type==2" size="mini" type="success">文章</el-tag>
            <el-tag v-if="scope.row.type==3" size="mini" type="warning">想法</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="标题" min-width="100px">
          <template slot-scope="scope">
            <span>{{scope.row.title}}</span>
          </template>
        </el-table-column>
        <el-table-column label="内容" min-width="100px" show-overflow-tooltip>
          <template slot-scope="scope">
            <span v-html="scope.row.content"></span>
          </template>
        </el-table-column>
        <el-table-column label="作者">
          <template slot-scope="scope">
            <span>{{scope.row.name}}</span>
          </template>
        </el-table-column>
        <el-table-column label="匿名">
          <template slot-scope="scope">
            <!-- <span>{{scope.row.anonymity}}</span> -->
            <el-tag v-if="scope.row.anonymity==1" size="mini" type="info">匿名</el-tag>
            <el-tag v-if="scope.row.anonymity==0" size="mini">未匿名</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="评论数" sortable prop="comment_num">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.comment_num}}</span>
          </template> -->
        </el-table-column>
        <el-table-column label="点赞数" sortable prop="report_num">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.report_num}}</span>
          </template> -->
        </el-table-column>
        <el-table-column label="创建时间" sortable prop="create_time">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.create_time}}</span>
          </template> -->
        </el-table-column>
        <el-table-column label="删除" min-width="100px" >
          <template slot-scope="scope">
            <!-- <span>{{scope.row.del}}</span> -->
            <el-tag v-if="scope.row.del==0" size="mini">未删除</el-tag>
            <el-tag v-if="scope.row.del==1" size="mini" type="danger">已删除</el-tag>
          </template>
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
import {reqFindArticlev,reqDelArticle} from '../../api/sysManager'
import dataUtil from '../../util/dataUtil';
export default {
  name: 'ArticleManage',
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
      reqFindArticlev(params).then(res => {
        if (res.resultCode == 200) {
          this.tableData = res.data.map(i => {
            i.create_time = dataUtil.getStrData(i.create_time)
            i.update_time = dataUtil.getStrData(i.update_time)
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
      this.$confirm('此操作将永久删除文章且无法恢复，是否继续?，是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params = 'id=' + row.article_id
        reqDelArticle(params).then(res => {
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
.article-page {
  .main {
    .main-header {
      display: flex;
      justify-content: space-between;
    }
  }
}
</style>
