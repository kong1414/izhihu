<template>
  <div class="login-page">
    <div class="content">
      <el-card class="login-card"
               :body-style="{ padding: '0px' }">
        <div class="head">
          <img class="logo"
               src="@/assets/img/logo-izhihu.png"
               alt="izhihu"
               width="200">
          <div class="logo-text">
            登录知乎，发现更多可信赖的解答
          </div>
        </div>
        <el-form ref="AccountFrom"
                 :model="login"
                 label-width="0px"
                 class="login-form"
                 status-icon>
          <el-form-item>
            <el-input v-model="login.account"
                      placeholder="手机号或邮箱"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="login.password"
                      placeholder="密码"
                      auto-complete="off"
                      @keyup.enter.native="handleLogin"></el-input>
          </el-form-item>
          <div class="other">
            <el-button type="text"
                       class="phonelogin">手机验证码登录</el-button>
            <el-button type="text"
                       class="forget">忘记密码？</el-button>
          </div>
          <el-form-item>
            <el-button type="primary"
                       class="login-button">登录</el-button>
          </el-form-item>

        </el-form>

        <div class="footer">
          没有账号？<el-button type="text"
                     class="reg">注册</el-button>
        </div>
      </el-card>

      <el-button class="download-button">
        下载i知乎App
      </el-button>
    </div>
  </div>
</template>

<script>
import { reqLogin, reqQueryAccount } from '../api/login.js'
import { ERR_OK } from '../api/config.js'
import md5 from 'js-md5'
import { mapActions } from 'vuex'
export default {
  name: 'login',
  components: {

  },
  data () {
    return {
      login: {
        account: '',
        password: ''
      },
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
  methods: {
    ...mapActions([
      'saveUser',
      'saveToken'
    ]),
    handleLogin () {

    }
  }
}
</script>

<style lang="scss">
.login-page {
  background-color: #b8e5f8;
  width: 100%;
  height: 100%;
  background-image: url("../assets/img/zhihu-login-bg.png");
  background-repeat: no-repeat;
  background-size: cover;
  overflow: auto;
  .content {
    margin: 0 auto;
    width: 440px;
    .login-card {
      background-color: #ffffff;
      margin-top: 80px;
      padding: 0;
      .head {
        text-align: center;
        margin-top: 20px;
        .logo {
        }
        .logo-text {
          margin-top: 5px;
          color: #0084ff;
          font-size: 22px;
          font-weight: 500;
        }
      }
      .login-form {
        margin-top: 20px;
        padding: 0 40px;
        text-align: center;
        .el-input__inner {
          border-top: none;
          border-left: none;
          border-right: none;
        }
        .other {
          display: flex;
          justify-content: space-between;
          .phonelogin {
            color: #175199;
          }
          .forget {
            color: #8590a6;
          }
        }
        .login-button {
          width: 350px;
          color: #fff;
          background-color: #0084ff;
          margin-top: 30px;
        }
      }
      .footer {
        height: 58px;
        line-height: 58px;
        border-top: 1px solid #ebebeb;
        font-size: 16px;
        text-align: center;
        background-color: #f6f6f6;
        .reg {
          color: #175199;
          font-size: 16px;
        }
      }
    }
    .download-button {
      margin-top: 30px;
      background: #8590a6;
      border: none;
      color: #fff;
      width: 432px;
      height: 42px;
      letter-spacing: 1px;
      font-size: 14px;
      border-radius: 3px;
      font-weight: 600;
    }
  }
}
</style>


