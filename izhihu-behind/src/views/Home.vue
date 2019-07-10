<template>
  <el-container class="home-container">
    <el-header>
      <div class="logo-box">
        <i class="el-icon-star-on logo-font"></i>
        <span>IZhiHu后台</span>
      </div>
      <div class="topbar-title">
        <div @click.prevent="collapse" class="collapse-icon">
          <i class="iconfont icon-indent" style="font-size:24px;" v-if="collapsed"></i>
          <i class="iconfont icon-outdent" style="font-size:24px;" v-if="!collapsed"></i>
        </div>
      </div>
      <div class="topbar-account">
        <el-dropdown>
          <span class="el-dropdown-link userinfo-inner">
            {{this.$store.state.user.name}}
            <i style="padding-left:5px" class="el-icon-caret-bottom"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="changePasswords">修改密码</el-dropdown-item>
            <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container>
      <el-menu
        class="el-menu-vertical"
        :collapse="collapsed"
        default-active="/home/index"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        router>
        <el-menu-item index="/home/index">
          <i class="el-icon-document"></i>
          <span slot="title">首页</span>
        </el-menu-item>
        <el-menu-item index="/home/usermanage">
          <i class="el-icon-document"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
        <el-menu-item index="/home/articlemanage">
          <span slot="title">文章管理</span>
        </el-menu-item>
        <el-menu-item index="/home/quesmanage">
          <span slot="title">问题管理</span>
        </el-menu-item>
        <el-menu-item index="/home/topicmanage">
          <span slot="title">话题管理</span>
        </el-menu-item>
        <el-menu-item index="/home/commentmanage">
          <span slot="title">评论管理</span>
        </el-menu-item>
        <el-menu-item index="/home/favoritemanage">
          <span slot="title">收藏管理</span>
        </el-menu-item>
        <!-- <el-menu-item index="/home/index">
          <i class="el-icon-upload2"></i>
          <span slot="title">出库管理</span>
        </el-menu-item> -->
        <!-- <el-menu-item index="/home/stocklist">
          <i class="el-icon-download"></i>
          <span slot="title">入库管理</span>
        </el-menu-item> -->
        <!-- <el-menu-item index="/home/index">
          <i class="el-icon-goods"></i>
          <span slot="title">订单管理</span>
        </el-menu-item> -->
        <!-- <el-menu-item index="/home/warehouse">
          <i class="el-icon-news"></i>
          <span slot="title">库存管理</span>
        </el-menu-item>
        <el-menu-item index="/home/product">
          <i class="el-icon-goods"></i>
          <span slot="title">产品管理</span>
        </el-menu-item> -->
        <!-- <el-submenu index="">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">系统管理</span>
          </template>
          <el-menu-item index="/home/usermanage">
            <span slot="title">用户管理</span>
          </el-menu-item>
          <el-menu-item index="/home/rolemanage">
            <span slot="title">角色管理</span>
          </el-menu-item>
          <el-menu-item index="/home/aclmanage">
            <span slot="title">权限管理</span>
          </el-menu-item>
          <el-menu-item index="/home/dictionary">
            <span slot="title">数据字典</span>
          </el-menu-item>
        </el-submenu> -->
      </el-menu>
      <el-container>
        <el-main style="  min-width: 800px;">
          <transition name="fade" mode="out-in">
            <router-view></router-view>
          </transition>
        </el-main>
        <el-footer>
          <span>©2018</span>
        </el-footer>
      </el-container>
    </el-container>
    <el-dialog :close-on-click-modal="false" title="修改密码" :visible.sync="dialogChangePwd" width="28%" class="change-pwd-dialog">
      <div class="dialog-content">
        <el-form :model="passwords" :rules="rules" label-width="80px" ref="passForm" >
          <el-form-item label="原密码" prop="oldPass">
            <el-input v-model="passwords.oldPass" type="password" placeholder="请输入原密码"></el-input>
          </el-form-item>
          <el-form-item label="新密码" prop="newPass">
            <el-input v-model="passwords.newPass" type="password" placeholder="请输入至少6个字符"></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="againpwd" >
            <el-input v-model="passwords.againpwd" type="password" placeholder="请再次输入新密码"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div class="dialog-footer">
        <el-button size="small" @click="cancledialog('passForm')">取消</el-button>
        <el-button size="small" @click="changePwd('passForm')" type="primary">确定</el-button>
      </div>
    </el-dialog>
  </el-container>
</template>

<script>
import md5 from 'js-md5'
import { reqUpdatePwd } from '../api/login.js'
// @ is an alias to /src
export default {
  name: 'home',
  data () {
    var checkOldPass = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('旧密码不能为空'))
      } else {
        callback()
      }
    }
    var checkNewPass = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('新密码不能为空'))
      } else if (value.length < 6) {
        return callback(new Error('密码长度不能小于6个字符'))
      } else {
        callback()
      }
    }
    var checkNewPassAgain = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('再次输入密码不能为空'))
      } else if (value !== this.passwords.newPass) {
        return callback(new Error('两次输入的密码不一致'))
      } else {
        callback()
      }
    }
    return {
      collapsed: false,
      dialogChangePwd: false,
      passwords: {
        oldPass: '',
        newPass: '',
        againpwd: ''
      },
      rules: {
        oldPass: [
          { request: true, validator: checkOldPass, trigger: 'blur' }
        ],
        newPass: [
          { request: true, validator: checkNewPass, trigger: 'blur' }
        ],
        againpwd: [
          { request: true, validator: checkNewPassAgain, trigger: 'blur' }
        ]
      }
    }
  },
  computed: {
    asideWidth () {
      return this.collapsed ? '64px' : '200px'
    }
  },
  methods: {
    collapse () {
      this.collapsed = !this.collapsed
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    windowsChange () {
      // 监听窗口改变，当宽度小于768是隐藏侧边栏
      window.addEventListener('resize', () => {
        let width = document.body.clientWidth
        if (width <= 1024) {
          this.collapsed = true
        } else {
          this.collapsed = false
        }
      })
    },
    logout () {
      var _this = this
      this.$confirm('确认退出吗?', '提示', {
        // type: 'warning'
      }).then(() => {
        localStorage.removeItem('vuex')
        _this.$router.push('/login')
      }).catch(() => {})
    },
    changePasswords () {
      this.dialogChangePwd = true
    },
    changePwd (rules) { // 修改密码
      this.$refs.passForm.validate((value) => {
        if (value) {
          let params = {}
          params.oldPass = md5(this.passwords.oldPass + this.passwords.oldPass)
          params.newPass = md5(this.passwords.newPass + this.passwords.oldPass)
          console.info(params)
          reqUpdatePwd(params).then(res => {
            if (res.resultCode === 200) {
              this.$message({
                duration: 1500,
                message: '修改密码成功！',
                type: 'success'
              })
              this.passwords = {}
              this.$router.push('/login')
            }
          })
        } else {
          return false
        }
      })
    },
    cancledialog (rules) {
      this.dialogChangePwd = false
      this.passwords = {
        oldPass: '',
        newPass: '',
        againpwd: ''
      }
      this.$refs[rules].resetFields()
    }
  },
  mounted () {
    this.windowsChange()
  }
}
</script>

<style lang="scss">
.home-container {
  width: 100%;
  height: 100%;
  .el-header {
    padding-left: 0px;
    line-height: 60px;
    background: #3a8ee6;
    box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
    color: white;
    .logo-box { // 左侧logo位
      // background-color: #3a8ee6;
      box-sizing: border-box;
      align-items: center;
      height: 60px;
      line-height: 60px;
      padding-left: 22px;
      width: 200px;
      float: left;
      .logo-font {
        font-size: 22px;
      }
      span {
        margin-left: 20px;
        font-size: 22px;
      }
    }
    .topbar-title {
      margin-left: 20px;
      float: left;
      text-align: left;
      .collapse-icon {
        cursor: pointer;
      }
    }
    .topbar-account {
      float: right;
      .el-dropdown {
        color: #fff;
      }
    }
    .userinfo-inner {
      cursor: pointer;
      padding-left: 10px;
    }
  }
  .el-container {
    .el-menu-vertical:not(.el-menu--collapse) {
      width: 200px;
      min-height: 400px;
    }
    .el-menu {
      border-radius: 0px;
      border-right-width: 0px;
    }
    .el-container {
      background: #f0f2f5;
      overflow-y: auto;
      .el-main {
        // min-height: -moz-calc(100% - 64px);
        // min-height: -webkit-calc(100% - 64px);
        // min-height: calc(100% - 64px);
        // height: auto !important;
        min-width: -moz-calc(1280px - 200px);
        min-width: -webkit-calc(1280px - 200px);
        min-width: calc(1024px - 200px);
        box-sizing: border-box;
        padding: 0px;
      }
      .el-footer {
        text-align: center;
        line-height: 60px;
        span {
          color: #aaabab;
          font-size: 14px;
        }
      }
    }
  }
}
.change-pwd-dialog{
  .el-dialog__header {
    border-bottom: 1px solid #e8e8e8;
  }
  .dialog-footer {
    padding: 10px 20px;
    text-align: right;
    border-top: 1px solid #e8e8e8;
  }
  .el-dialog__header {
    border-bottom: 1px solid #e8e8e8;
  }
  .el-dialog__body {
    padding: 0;
    margin: 0;
    .dialog-content{
      padding: 22px 22px 0 22px;
      .el-form-item__content {
        height: 40px;
        line-height: 25px;
      }
    }
  }
}
</style>
