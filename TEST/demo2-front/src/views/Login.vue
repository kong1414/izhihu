<template>
  <div class="login-page">
    <div class="content">
      <div class="login-card"
               :body-style="{ padding: '0px' }">
        <div class="head">
          <img src="../img/loginTop.png" alt="" style="width: 360px; height: 180px">
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
                      placeholder="用户名"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="login.password"
            prefix-icon="el-icon-lock"
                      type="password"
                      placeholder="密码"
                      auto-complete="off"
                      show-password
                      @keyup.enter.native="handleLogin"></el-input>
          </el-form-item>
          <div class="other">
            <el-select v-model="value" placeholder="我是管理员" style="width:130px;">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>

            <el-button type="text"
                       class="forget">忘记密码？</el-button>
          </div>
          <el-form-item>
            <el-button type="primary"
                       class="login-button"
                       @click="handleLogin"
                       v-loading.fullscreen.lock="fullscreenLoading">登录</el-button>
          </el-form-item>

        </el-form>

      </div>
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
      options: [{
          value: '选项1',
          label: '我是管理员'
        }, {
          value: '选项2',
          label: '我是学生'
        }],
        value: '',
      fits: 'fill',
      url: '../img/loginTop.png',
      login: {
        account: '',
        password: ''
      },
      fullscreenLoading: false,
      rules: {
        account: [
          { required: true, message: '请输入用户名' }
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
      this.fullscreenLoading = true
      let params = {
        account: this.login.account,
        // password: md5(this.login.password + this.login.password),
        password: this.login.password,
      }
      reqLogin(params).then(res => {
        // console.info(res)
        if(res.resultCode === ERR_OK) {
          this.$message({
            message: '登录成功！',
            type: 'success'
          })
          this.saveUser(res.data)
          // this.saveToken(res.data.token)
          this.fullscreenLoading = false
          this.$router.push({ path: '/home/index' })
        } else {
          this.fullscreenLoading = false
        }
      })
    },
    toRegister () {
      this.$router.push({ path: '/register' })
    },
  }
}
</script>

<style lang="scss">
.login-page {
  background-color: #087DDA;
  width: 100%;
  height: 100%;
  // background-image: url("../assets/img/zhihu-login-bg.png");
  // background-repeat: no-repeat;
  // background-size: cover;
  overflow: auto;
  .content {
    margin: 0 auto;
    width: 440px;
    .login-card {
      border:none;
       background-color:Transparent;
      margin-top: 210px;
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
          .el-button--primary{
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


