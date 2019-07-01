<!-- 角色管理 -->
<template>
  <div class="base-container role-page">
    <div class="header">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>角色管理</el-breadcrumb-item>
      </el-breadcrumb>
      <h1>角色管理</h1>
    </div>
    <div class="main">
      <div class="main-header">
        <div>
          <el-button type="primary" @click="handleAddRole">新增角色</el-button>
          <!-- <el-button type="danger">批量删除</el-button> -->
        </div>
        <div>
          <el-input style="width: 250px;" v-model.trim.lazy="searchContent" placeholder="请输入内容搜索">
            <i style="margin: 12px 5px 0 0;font-size:16px" class="el-icon-search" slot="suffix"></i>
          </el-input>
        </div>
      </div>
      <el-table
        :data="tableData"
        @selection-change="handleSelectionChange"
        v-loading="loading"
        style="width: 100%;margin: 10px 0">
        <el-table-column type="selection" width="55">
        </el-table-column>
        <el-table-column label="名称">
          <template slot-scope="scope">
            <el-input v-show="scope.row.show" size="small" v-model="scope.row.name" placeholder="请输入名称" :maxlength="20"></el-input>
            <span v-show="!scope.row.show">{{scope.row.name}}</span>
          </template>
        </el-table-column>
        <el-table-column label="类型">
          <template slot-scope="scope">
            <span v-if="!scope.row.show">{{typeRoleName(scope.row.type)}}</span>
            <el-select v-if="scope.row.show" v-model="scope.row.type" placeholder="请选择角色">
              <el-option
                v-for="item in typeOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </template>
        </el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <div v-if="!scope.row.show">
              <el-button size="mini" type="success" v-if="scope.row.status === 1" :disable-transitions="false">启用</el-button>
              <el-button size="mini" type="info" v-if="scope.row.status === 0" :disable-transitions="false">禁用</el-button>
            </div>
            <div v-if="scope.row.show">
              <el-button size="mini" type="success" v-if="scope.row.status === 1" @click="handleStatus(scope.$index, scope.row)">启用</el-button>
              <el-button size="mini" type="success" v-if="scope.row.status === 0" @click="handleStatus(scope.$index, scope.row)">禁用</el-button>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="备注">
          <template slot-scope="scope">
            <el-input v-show="scope.row.show" size="small" v-model="scope.row.remark" placeholder="请输入备注" :maxlength="20"></el-input>
            <span v-show="!scope.row.show">{{scope.row.remark}}</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="userCteate"
          label="创建人"
          width="120px">
        </el-table-column>
        <el-table-column label="操作" width="220px" fixed="right">
          <template slot-scope="scope">
            <div v-if="scope.row.show">
              <el-button
                size="mini"
                @click="handleSave(scope.$index, scope.row)">保存</el-button>
              <el-button
              size="mini"
              @click="handleCancel(scope.$index, scope.row)">取消</el-button>
            </div>
            <div v-else>
              <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button
                size="mini"
                @click="handleAcl(scope.$index, scope.row)">权限</el-button>
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </div>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog
      title="权限配置"
      :visible.sync="AclDialogVisible"
      width="30%">
      <span>正在开发</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="AclDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="AclDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { reqRoleList, reqUpdateRole, reqAddRole, reqDelRole } from '../../api/sysManager.js'
export default {
  name: 'rolemanager',
  data () {
    return {
      isShowDeleteButton: false,
      loading: true,
      ids: [],
      AclDialogVisible: false, // 权限配置弹窗是否显示的参数
      itemData: {}, // 编辑的暂存对象
      searchContent: '',
      tableData: [],
      // 0，用户 1，超级管理员，2，普通管理员，3：销售管理员，4，仓库管理员
      typeOptions: [
        { value: 0, label: '用户' },
        { value: 1, label: '超级管理员' },
        { value: 2, label: '普通管理员' },
        { value: 3, label: '销售管理员' },
        { value: 4, label: '仓库管理员' }
      ]
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
  computed: {

  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      this.loading = true
      let params = 'keyword=' + this.searchContent
      reqRoleList(params).then(res => {
        if (res.resultCode === 200) {
          res.data.forEach(element => {
            element.show = false
          })
          this.tableData = res.data
          this.loading = false
        }
      })
    },
    typeRoleName (type) {
      switch (type) {
        case 0: return '用户'
        case 1: return '超级管理员'
        case 2: return '普通管理员'
        case 3: return '销售管理员'
        case 4: return '仓库管理员'
        default: return '用户'
      }
    },
    handleAddRole () {
      let item = { id: '', name: '', type: 0, status: 1, remark: '', show: true }
      this.tableData.splice(0, 0, item)
    },
    handleSelectionChange (checkList) { // 选中表格框时触发
      if (checkList.length === 0) {
        this.ids = []
      } else {
        let arr = []
        checkList.forEach(item => {
          arr.push(item.id)
        })
        this.ids = arr
      }
    },
    handleEdit (index, row) {
      // console.info(1232, row)
      row.show = !row.show
      this.itemData = JSON.parse(JSON.stringify(row))
      // console.info(index, row)
    },
    handleDelete (index, row) {
      let params = 'id=' + row.id
      reqDelRole(params).then(res => {
        if (res.resultCode === 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this._loadData()
          console.info(index, row)
        }
      })
    },
    handleSave (index, row) {
      if (row.id === '' || row.id === null) { // 新增角色的保存
        let params = {
          name: row.name,
          type: row.type,
          status: row.status,
          remark: row.remark
        }
        reqAddRole(params).then(res => {
          if (res.resultCode === 200) {
            row.show = false
            this.$message({
              type: 'success',
              message: res.resultMessage
            })
            this._loadData()
          }
        })
      } else { // 更新角色
        row.show = false
        // row = JSON.parse(JSON.stringify(this.itemData))
        // console.info(row)
        let params = {
          id: row.id,
          name: row.name,
          type: row.type,
          status: row.status,
          remark: row.remark
        }
        reqUpdateRole(params).then(res => {
          if (res.resultCode === 200) {
            this.$message({
              type: 'success',
              message: res.resultMessage
            })
            this._loadData()
          }
        })
      }
    },
    handleCancel (index, row) {
      // console.info(index, row)
      if (!row.id) {
        this.tableData.splice(index, 1)
      }
      Object(row, this.itemData)
      row.show = false
      this._loadData()
    },
    handleAcl (index, row) {
      this.AclDialogVisible = true
    },
    handleStatus (index, row) {
      if (row.status === 1) {
        row.status = 0
      } else if (row.status === 0) {
        row.status = 1
      }
    }
  }
}
</script>

<style lang="scss">
// 全局引用了基本布局.base-container 文件在base.scss
.role-page {
  .main {
    .main-header {
      display: flex;
      justify-content: space-between;
    }
  }
}
</style>
