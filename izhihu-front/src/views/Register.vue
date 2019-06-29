<template>
  <div class="register-page">
    <div class="content">
      <el-card class="login-card"
               :body-style="{ padding: '0px' }">
        <div class="head">
          <img class="logo"
               src="@/assets/img/logo-izhihu.png"
               alt="izhihu"
               width="200">
          <div class="logo-text">
            注册知乎，发现更多可信赖的解答
          </div>
        </div>
        <el-form ref="AccountFrom"
                 :model="login"
                 :rules="rules"
                 label-width="0px"
                 class="login-form"
                 status-icon>
          <el-form-item prop="account">
            <el-input v-model="login.account"
                      prefix-icon="el-icon-user"
                      clearable
                      placeholder="手机号或邮箱"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="login.password"
                      prefix-icon="el-icon-user-solid"
                      type="password"
                      placeholder="密码"
                      auto-complete="off"
                      show-password
                      @keyup.enter.native="handleRegister"></el-input>
          </el-form-item>
          <div class="other">
            <el-button type="text"
                       class="phonelogin">手机验证码登录</el-button>
            <el-button type="text"
                       class="forget">忘记密码？</el-button>
          </div>
          <el-form-item>
            <el-button type="primary"
                       class="login-button"
                       @click="handleRegister"
                       v-loading.fullscreen.lock="fullscreenLoading">注册</el-button>
          </el-form-item>

        </el-form>

        <div class="footer">
          已有账号？<el-button type="text"
                     class="reg"
                     @click="toLogin">登录</el-button>
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
    var checkAccount = (rule, value, callback) => {
      const phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$/
      const emailReg = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/
      if (!value) {
        return callback(new Error('手机号或邮箱不能为空'));
      }
      setTimeout(() => {
        if (phoneReg.test(value)) {
          this.regType = 'phone'
          callback()
        } else if (emailReg.test(value)) {
          this.regType = 'email'
          callback()
        } else {
          return callback(new Error('手机号或邮箱格式不正确'));
        }
      }, 500)
    }

    return {
      login: {
        account: '',
        password: ''
      },
      fullscreenLoading: false,
      regType: 'phone',
      rules: {
        account: [
          // { required: true, message: '请输入邮箱或者手机号' },
          // { type: 'email', required: true, message: '邮箱地址不正确' },
          { validator: checkAccount, trigger: 'blur' }
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
    handleRegister () {
      let params = {
        account: this.login.account,
        password: md5(this.login.password + this.login.password),
        type: this.regType
      }
      console.info('注册还没做')
    },
    toLogin () {
      this.$router.push({ path: '/login' })
    },
  }
}
</script>

<style lang="scss">
.register-page {
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
          margin-top: 25px;
          .el-button--primary {
            background-color: #0084ff;
          }
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


