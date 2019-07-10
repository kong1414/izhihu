<template>
  <div class="base-container topic-page">
    <div class="header">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>话题管理</el-breadcrumb-item>
      </el-breadcrumb>
      <h1>话题管理</h1>
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
        <el-table-column label="用户名" min-width="100px" fixed="left">
          <template slot-scope="scope">
            <span>{{scope.row.username}}</span>
          </template>
        </el-table-column>
        <el-table-column label="用户名" min-width="100px" fixed="left">
          <template slot-scope="scope">
            <span>{{scope.row.username}}</span>
          </template>
        </el-table-column>
        <el-table-column label="用户名" min-width="100px" fixed="left">
          <template slot-scope="scope">
            <span>{{scope.row.username}}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="220px" fixed="right">
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
export default {
  name: 'TopicManage',
  data () {
    return {
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

    },
    handleSizeChange (val) {
      this.pagesize = val
    },
    handleCurrentChange () {
      this.currentPage = val
    },
    handleDelete (index, row) {
      this.$confirm('此操作将永久删除该用户且无法恢复，是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // let params = 'id=' + row.id
        // reqDelUser(params).then(res => {
        //   if (res.resultCode === 200) {
        //     this.$message({
        //       type: 'success',
        //       message: res.resultMessage
        //     })
        //     this._loadData()
        //   }
        // })
        
      }).catch(() => {
      })
    }
  }
}
</script>

<style lang="scss">
.topic-page {
  .main {
    .main-header {
      display: flex;
      justify-content: space-between;
    }
    .pagination {
      float: right;
    }
  }
}
</style>
