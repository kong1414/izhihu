<template>
  <div class="base-container user-page">
    <div class="header">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
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
          <el-input style="width: 250px;"
                    v-model.trim.lazy="searchContent"
                    placeholder="请输入内容搜索">
            <i style="margin: 12px 5px 0 0;font-size:16px"
               class="el-icon-search"
               slot="suffix"></i>
          </el-input>
        </div>
      </div>
      <el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="loading"
                style="width: 100%;margin: 10px 0">
        <el-table-column label="用户UUID"
                         min-width="100px">
          <template slot-scope="scope">
            <span>{{scope.row.user_id}}</span>
          </template>
        </el-table-column>
        <el-table-column label="姓名">
          <template slot-scope="scope">
            <span>{{scope.row.name}}</span>
          </template>
        </el-table-column>
        <el-table-column label="邮箱">
          <template slot-scope="scope">
            <span>{{scope.row.email}}</span>
          </template>
        </el-table-column>
        <el-table-column label="手机">
          <template slot-scope="scope">
            <span>{{scope.row.phone}}</span>
          </template>
        </el-table-column>
        <el-table-column label="创建时间"
                         sortable
                         prop="gmt_create">
          <!-- <template slot-scope="scope">
            <span>{{scope.row.create_time}}</span>
          </template> -->
        </el-table-column>
        <el-table-column label="封禁状态">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.forbidden==1"
                    type="danger">已封禁</el-tag>
            <el-tag v-else
                    type="success">正常</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="封禁时间">
          <template slot-scope="scope">
            <span>{{scope.row.forbidden_time ? scope.row.forbidden_time : ""}}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作"
                         width="100px"
                         fixed="right">
          <template slot-scope="scope">
            <el-button v-if="scope.row.forbidden==0"
                       size="mini"
                       type="danger"
                       @click="handleDelete(scope.$index, scope.row)">封禁</el-button>
            <el-button v-else
                       size="mini"
                       type="danger"
                       @click="handleDelete(scope.$index, scope.row)">解封</el-button>
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
import { reqFindUser, reqBanUser, reqUnBanUser } from '../../api/sysManager'
import dataUtil from '../../util/dataUtil';
export default {
  name: 'UserManage',
  data () {
    return {
      searchContent: '',
      tableData: [],
      pagesize: 10,
      currentPage: 1,
      loading: true
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
      let params = 'keyword=' + this.searchContent
      reqFindUser(params).then(res => {
        if (res.resultCode == 200) {
          this.tableData = res.data.map(i => {
            i.gmt_create = dataUtil.getStrData(i.gmt_create)
            i.last_login_time = dataUtil.getStrData(i.last_login_time)
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
      if (row.forbidden == 0) { // 进行封禁操作
        let params = 'userId=' + row.user_id;
        reqBanUser(params).then(res => {
          if (res.resultCode == 200) {
            this.$message({
              type: 'success',
              message: res.resultMessage
            })
            this._loadData()
          }
        })
      } else if (row.forbidden == 1) { // 进行解封操作
        let params = 'userId=' + row.user_id;
        reqUnBanUser(params).then(res => {
          if (res.resultCode == 200) {
            this.$message({
              type: 'success',
              message: res.resultMessage
            })
            this._loadData()
          }
        })
      }
    }
  }
}
</script>

<style lang="scss">
.user-page {
  .main {
    .main-header {
      display: flex;
      justify-content: space-between;
    }
  }
}
</style>
