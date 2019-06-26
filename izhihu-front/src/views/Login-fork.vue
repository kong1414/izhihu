<template>
  <div class="login-page">
    <div class="logo"><span>新一代库存管理系统</span></div>
    <div class="login">
      <el-tabs v-model="loginType" @tab-click="loginTypeHandle" class="login-tab-pane">
        <el-tab-pane label="用户登陆" name="account">
          <el-form ref="AccountFrom" :model="account" :rules="rules" label-position="left" label-width="0px" class="login-container">
            <el-form-item prop="name" class="login-input">
              <!-- <el-input type="text" v-model="account.name" auto-complete="off" placeholder="请输入账号"></el-input> -->
              <el-autocomplete
                v-model="account.name"
                :fetch-suggestions="querySearchAsync"
                placeholder="请输入账号/admin"
                @select="handleSelect"
              ></el-autocomplete>
            </el-form-item>
            <el-form-item prop="password" class="login-input">
              <el-input type="password" v-model="account.password" auto-complete="off" placeholder="请输入密码/123456" @keyup.enter.native="handleLogin"></el-input>
            </el-form-item>
            <el-row type="flex" class="row-bg" justify="space-between">
              <el-checkbox v-model="checked" checked class="remember">下次自动登录</el-checkbox>
              <el-button type="text" @click="toRegister">免费注册</el-button>
            </el-row>
            <el-form-item class="login-btn" >
              <el-button type="primary" @click="handleLogin" v-loading.fullscreen.lock="fullscreenLoading">登录</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="手机登陆" name="phone">
          <el-form ref="AccountFrom" :model="account" :rules="rules" label-position="left" label-width="0px" class="login-container">
            <el-form-item prop="name" class="login-input">
              <el-input type="text" v-model="account.name" auto-complete="off" placeholder="请输入手机"></el-input>
            </el-form-item>
            <el-form-item prop="password" class="login-input">
              <el-input type="password" v-model="account.password" auto-complete="off" placeholder="请输入验证码" @keyup.enter.native="handleLogin">
                <el-button slot="append" @click="sendVerificationCode">发送验证码</el-button>
              </el-input>
            </el-form-item>
            <el-form-item class="login-btn" >
              <el-button type="primary" @click="handleLogin" v-loading.fullscreen.lock="fullscreenLoading">登录</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
      </el-tabs>
      <!-- <el-form ref="AccountFrom" :model="account" :rules="rules" label-position="left" label-width="0px" class="login-container">
        <h3 class="title">用户登录</h3>
        <el-form-item prop="name" class="login-input">
          <el-input type="text" v-model="account.name" auto-complete="off" placeholder="请输入账号"></el-input>
        </el-form-item>
        <el-form-item prop="password" class="login-input">
          <el-input type="password" v-model="account.password" auto-complete="off" placeholder="请输入密码" @keyup.enter.native="handleLogin"></el-input>
        </el-form-item>
        <el-checkbox v-model="checked" checked class="remember">下次自动登录</el-checkbox>
        <el-form-item class="login-btn" >
          <el-button type="primary" @click="handleLogin" v-loading.fullscreen.lock="fullscreenLoading">登录</el-button>
        </el-form-item>
      </el-form> -->
    </div>
    <div class="login-footer">&copy;2018</div>
  </div>
</template>

<script>
import { reqLogin, reqQueryAccount } from '../api/login.js'
import { ERR_OK } from '../api/config.js'
import md5 from 'js-md5'
import { mapActions } from 'vuex'
export default {
  name: 'login',
  data () {
    return {
      errPasswordCount: 0,
      timeout: null,
      restaurants: [], // 远程搜索请求数据存放位置
      autocompleteData: '',
      fullscreenLoading: false,
      loginType: 'account',
      account: {
        name: '',
        password: ''
      },
      checked: true, // 自动登录
      rules: {
        name: [
          { required: true, message: '请输入账号' }
          // { validator: validaePass }
        ],
        password: [
          { required: true, message: '请输入密码' },
          { min: 6, max: 20, message: '密码长度在6-20个字符', trigger: 'blur' }
        ]
      }
    }
  },
  created () {
  },
  methods: {
    ...mapActions([
      'saveUser',
      'saveToken'
    ]),
    loginTypeHandle () {
      // console.info(this.loginType)
    },
    handleLogin () {
      if (this.errPasswordCount >= 3) {
        this.$message({
          message: '已记录IP，并限制登陆，请勿暴力破解',
          type: 'warning'
        })
        return
      }
      this.fullscreenLoading = true
      let params = {
        account: this.account.name,
        password: md5(this.account.password + this.account.password),
        loginType: 2
      }
      reqLogin(params).then(res => {
        console.info(res)
        if (res.resultCode === ERR_OK) {
          this.errPasswordCount = 0
          this.$message({
            message: '登录成功！',
            type: 'success'
          })
          this.saveUser(res.data)
          this.saveToken(res.data.token)
          this.fullscreenLoading = false
          this.$router.push({ path: '/home/index' })
          // this._loadMenus()
        } else {
          this.errPasswordCount++
          this.fullscreenLoading = false
        }
      })
      console.info(this.account)
    },
    querySearchAsync (queryString, cb) {
      if (queryString === '') { // 如果无输入 则返回空的数组
        let emlist = []
        cb(emlist)
      } else {
        let params = 'keyword=' + queryString
        reqQueryAccount(params).then(res => {
          if (res.resultCode === 200 && res.data != null) {
            console.info(res)
            let list = []
            res.data.map(e => {
              let item = { value: e }
              list.push(item)
            })
            cb(list)
          }
        })
      }
    },
    handleSelect () {
      console.info(this.autocompleteData)
    },
    toRegister () {
      this.$router.push({ path: '/register' })
    },
    sendVerificationCode () {
      this.$message({
        message: '尚未开发',
        type: 'info'
      })
    }
  }
}
</script>

<style lang="scss">
@import "../assets/styles/variable.scss";
.login-page {
  background: $color-background-d;
  .logo {
    padding-top: 100px;
    height: 80px;
    line-height: 80px;
    font-size: 26px;
    color: $color-text-d;
    font-weight: bold;
    width: 100%;
    span {
      width: 100%;
      display: block;
      text-align: center;
    }
  }
  .login {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    height: calc(100vh - 380px);
    width: 100%;
    position: relative;
    min-height: 404px;
    .el-autocomplete {
      width: 320px;
    }
    .login-input {
      width: 320px;
    }
    .el-tabs__header {
      padding: 5px 20px 5px;
    }
    .login-tab-pane {
      margin: 0 auto;
      margin-top: 100px;
      box-sizing: border-box;
      border-radius: 4px;
      max-width: 400px;
      background: #fff;
      border: 1px solid #eaeaea;
      box-shadow: 0px 0px 5px 0px rgba(199, 199, 199, 0.48);

      background: -ms-linear-gradient(top, #fff, #6495ed);
      /* IE 10 */
      background: -moz-linear-gradient(top, #b8c4cb, #f6f6f8);
      /*火狐*/
      background: -webkit-gradient(linear,0% 0%,0% 100%,from(#b8c4cb),to(#f6f6f8));
      /*谷歌*/
      background: -webkit-gradient(linear,0% 0%,0% 100%,from(#fff),to(#6495ed));
      /* Safari 4-5, Chrome 1-9*/
      background: -webkit-linear-gradient(top, #fff, #6495ed, #fff);
      /*Safari5.1 Chrome 10+*/
      background: -o-linear-gradient(top, #fff, #6495ed);
      /*Opera 11.10+*/

      .login-container {
        margin: 0 auto;
        padding: 15px 40px 40px 40px;
        .title {
          margin-top: 0px;
          margin-bottom: 20px;
          color: #505458;
          font-weight: normal;
          font-size: 18px;
        }
        .remember {
          margin: 0px 0px 22px 0px;
        }
      }
    }
    .login-btn {
      width: 100%;
      margin-bottom: 0px !important;
      button {
        width: 100%;
      }
    }
  }
  .login-footer {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    // background: #fff;
    height: 200px;
    text-align: center;
    padding-top: 40px;
  }
}
</style>
