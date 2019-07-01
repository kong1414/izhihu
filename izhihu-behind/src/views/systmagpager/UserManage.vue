<!-- 用户管理 -->
<template>
  <div class="base-container user-page">
    <div class="header">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      </el-breadcrumb>
      <h1>用户管理</h1>
    </div>
    <div class="main">
      <div class="main-header">
        <div>
          <el-button type="primary" @click="addDialogVisible = true">新增用户</el-button>
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
        <el-table-column type="selection" width="55" fixed="left">
        </el-table-column>
        <el-table-column label="用户名" min-width="100px" fixed="left">
          <template slot-scope="scope">
            <span>{{scope.row.username}}</span>
          </template>
        </el-table-column>
        <el-table-column label="手机" min-width="120px">
          <template slot-scope="scope">
            <span>{{scope.row.mobile}}</span>
          </template>
        </el-table-column>
        <el-table-column label="邮箱" min-width="180px">
          <template slot-scope="scope">
            <span>{{scope.row.email}}</span>
          </template>
        </el-table-column>
        <el-table-column label="备注" min-width="150px">
          <template slot-scope="scope">
            <span>{{scope.row.remark}}</span>
          </template>
        </el-table-column>
        <el-table-column label="上次登录时间" width="170px">
          <template slot-scope="scope">
            <span>{{scope.row.lastLoginTime}}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="220px" fixed="right">
          <template slot-scope="scope">
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
    <el-dialog
      title="新增用户"
      :visible.sync="addDialogVisible"
      width="50%">
      <div style="width: 400px;margin: 0 auto;padding-right:15px">
        <el-form ref="form" :model="addFormData" :rules="rules" label-width="80px" style="margin-top:20px">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="addFormData.username" placeholder="请输入账号" clearable></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="addFormData.password" type="password" placeholder="请输入密码" clearable></el-input>
          </el-form-item>
          <el-form-item label="手机" prop="mobile">
            <el-input v-model="addFormData.mobile" placeholder="请输入手机" clearable></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="addFormData.email" placeholder="请输入账号" clearable></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="remark">
            <el-input v-model="addFormData.remark" placeholder="请输入账号" clearable></el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleAddUser()">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="编辑用户"
      :visible.sync="updateDialogVisible"
      width="50%">
      <div style="width: 400px;margin: 0 auto;padding-right:15px">
        <el-form ref="form" :model="updateFormData" :rules="rules" label-width="80px" style="margin-top:20px">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="updateFormData.username" placeholder="请输入账号" clearable></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-button type="info" @click="resetPassword">重置密码</el-button>
          </el-form-item>
          <el-form-item label="手机" prop="mobile">
            <el-input v-model="updateFormData.mobile" placeholder="请输入手机" clearable></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="updateFormData.email" placeholder="请输入账号" clearable></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="remark">
            <el-input v-model="updateFormData.remark" placeholder="请输入账号" clearable></el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer">
        <el-button @click="updateDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleUppdateUser()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { reqUserList, reqUpdateUser, reqAddUser, reqDelUser, reqResetUser } from '../../api/sysManager.js'
import dataUtil from '../../util/dataUtil.js'
import md5 from 'js-md5'
export default {
  name: 'usermanager',
  data () {
    var createCheckMobile = (rule, value, callback) => {
      if (value.length > 0) {
        if (!/^[1]*[1-9][0-9]*$/.test(value)) {
          return callback(new Error('手机格式有误'))
        }
        if (value.length !== 11) {
          return callback(new Error('长度必须为11'))
        }
        // 检测手机号码是否重复
        // let params = 'mobilePhone=' + value + '&id=' + this.updateId
        // reqCheckMobilePhone(params).then(res => {
        //   if (res.resultCode === 200) {
        //     return callback()
        //   } else {
        //     return callback(new Error('手机号码重复'))
        //   }
        // })
      } else {
        return callback()
      }
    }
    var createCheckEmail = (rule, value, callback) => {
      if (value.length > 0) {
        if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value)) {
          return callback(new Error('邮箱格式有误'))
        }
        // 检测邮箱是否重复
        // let params = 'mobilePhone=' + value + '&id=' + this.updateId
        // reqCheckMobilePhone(params).then(res => {
        //   if (res.resultCode === 200) {
        //     return callback()
        //   } else {
        //     return callback(new Error('手机号码重复'))
        //   }
        // })
      } else {
        return callback()
      }
    }
    return {
      isShowDeleteButton: false,
      loading: true,
      ids: [],
      AclDialogVisible: false, // 权限配置弹窗是否显示的参数
      itemData: {}, // 编辑的暂存对象
      searchContent: '',
      tableData: [],
      updateFormData: [],
      updateDialogVisible: false,
      addDialogVisible: false,
      addFormData: {},
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 20, message: '长度在 3 到 5 个字符', trigger: 'blur'}
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ],
        mobile: [
          { validator: createCheckMobile, trigger: 'blur' }
        ],
        email: [
          { validator: createCheckEmail, trigger: 'blur' }
        ]
      }
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
      reqUserList(params).then(res => {
        if (res.resultCode === 200) {
          res.data.forEach(element => {
            element.show = false
          })
          this.tableData = res.data
          this.loading = false
        }
      })
    },
    handleAddUser () {
      let params = {
        username: this.addFormData.username,
        password: md5(this.addFormData.password + this.addFormData.password),
        mobile: this.addFormData.mobile,
        email: this.addFormData.email,
        remark: this.addFormData.remark,
      }
      reqAddUser(params).then(res => {
        if (res.resultCode === 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this.addDialogVisible = false
          this._loadData()
        }
      })
      this.addFormData = []
    },
    handleUppdateUser () {
      let params = 'id=' + this.updateFormData.id
                  + '&username=' + this.updateFormData.username
                  + '&mobile=' + this.updateFormData.mobile
                  + '&email=' + this.updateFormData.email
                  + '&remark=' + this.updateFormData.remark
      reqUpdateUser(params).then(res => {
        if (res.resultCode === 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this.updateDialogVisible = false
          this.updateFormData = []
          this._loadData()
        }
      })
      
    },
    resetPassword() {
      let params = 'id=' + this.updateFormData.id
      reqResetUser(params).then(res => {
        if (res.resultCode === 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
        }
      })
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
      this.updateFormData = {
        id: row.id,
        username: row.username,
        mobile: row.mobile,
        email: row.email,
        remark: row.remark
      }
      this.updateDialogVisible = true
    },
    handleDelete (index, row) {
      this.$confirm('此操作将永久删除该用户且无法恢复，是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params = 'id=' + row.id
        reqDelUser(params).then(res => {
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
    },
    handleSave (index, row) {
      if (row.id === '' || row.id === null) { // 新增角色的保存
        
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
        reqUpdateUser(params).then(res => {
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
.user-page {
  .main {
    .main-header {
      display: flex;
      justify-content: space-between;
    }
  }
}
</style>
