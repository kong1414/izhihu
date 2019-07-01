<template>
  <div class="register-page">
    <div class="logo"><span>注册中心</span></div>
    <div class="login">
      <div class="login-tab-pane">
        <el-form ref="AccountFrom" :model="account" :rules="rules" label-position="left" label-width="0px" class="login-container">
          <el-form-item prop="name" class="login-input">
            <el-input type="text" v-model="account.name" auto-complete="off" placeholder="请输入账号" @blur="checkUsername"></el-input>
          </el-form-item>
          <el-form-item prop="password" class="login-input">
            <el-input type="password" v-model="account.password" auto-complete="off" placeholder="请输入密码" @keyup.enter.native="handleLogin"></el-input>
          </el-form-item>
          <el-form-item class="login-btn" >
            <el-button type="primary" @click="handleRegister" v-loading.fullscreen.lock="fullscreenLoading">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
    <div class="login-footer">&copy;2018</div>
  </div>
</template>

<script>
import { reqcheckName, reqRegister } from '../api/login.js'
import { ERR_OK } from '../api/config.js'
import md5 from 'js-md5'
// import axios from '../api/request'
// import { BASE_URL } from '../api/config'

export default {
  name: 'register',
  data () {
    var checknameValidatePass = (rule, value, callback) => {
      let params = 'keyword=' + this.account.name
      reqcheckName(params).then(res => {
        if (res.resultCode === 200) {
          console.info(res)
          if (res.data === false) {
            return callback(new Error('用户名重复'))
          }
        }
      })
      // if (value === 'qgl') {
      //   return callback(new Error('用户名重复'));
      // }
    }
    return {
      errPasswordCount: 0,
      timeout: null,
      autocompleteData: '',
      fullscreenLoading: false,
      account: {
        name: '',
        password: ''
      },
      checked: true, // 自动登录
      rules: {
        name: [
          { required: true, message: '请输入账号' },
          { validator: checknameValidatePass, trigger: 'blur' }
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
    handleRegister () {
      this.fullscreenLoading = true
      let params = {
        username: this.account.name,
        password: md5(this.account.password + this.account.password)
      }
      reqRegister(params).then(res => {
        console.info(res)
        if (res.resultCode === ERR_OK) {
          this.$message({
            message: '注册成功！',
            type: 'success'
          })
          this.fullscreenLoading = false
          this.$router.push({ path: '/login' })
        } else {
          this.fullscreenLoading = false
        }
      })
      console.info(this.account)
    },
    handleSelect () {
      console.info(this.autocompleteData)
    },
    checkUsername () {
      if (this.account.name === 'qgl') {
        //  this.$message.error('用户名重复');
      }
    }
  }
}
</script>

<style lang="scss">
@import "../assets/styles/variable.scss";
.register-page {
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
        padding: 40px;
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
