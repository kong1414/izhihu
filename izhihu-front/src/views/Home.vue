<template>
  <el-container class="home">
    <el-header height="52px">
      <div class="header-content">
        <img class="logo"
             src="../assets/img/logo-izhihu.png"
             alt="izhihu"
             height="40px">
        <div class="menu">
          <el-menu :default-active="activeIndex"
                   class="el-menu-top"
                   mode="horizontal"
                   text-color="#8590a6"
                   @select="handleSelect"
                   default-active="/home/index"
                   router>
            <el-menu-item index="/home/index">首页</el-menu-item>
            <el-menu-item index="/home/discovery">发现</el-menu-item>
            <el-menu-item index="/home/topic">话题</el-menu-item>
          </el-menu>
        </div>

        <div class="top-search">
          <el-input size="small"
                    v-model="input"
                    class="input"
                    placeholder="请输入内容"
                    suffix-icon="el-icon-search">
          </el-input>
          <el-button type="primary"
                     size="small"
                     @click="handleAsk">提问</el-button>

        </div>
        <div class="more">
          <span>
            <i class="el-icon-message-solid"
               style="margin-right: 30px;"></i>
            <i class="el-icon-chat-line-round"
               style="margin-right: 30px;"></i>
            <el-dropdown>
              <span class="el-dropdown-link userinfo-inner">
                <!-- {{this.$store.state.user.username}} -->
                <span class="username">kong1414</span>
                <i style="padding-left:5px"
                   class="el-icon-caret-bottom"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item @click.native="changePasswords">修改密码</el-dropdown-item>
                <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </span>
        </div>
      </div>

    </el-header>

    <el-container class="main">
      <transition name="el-fade-in">
        <router-view />
      </transition>
      <!-- <el-main>
        Main
        </el-main>
      <el-aside width="300px" style="background-color:green;height:200px">
        Aside
      </el-aside> -->
    </el-container>
  </el-container>
</template>

<script>
// @ is an alias to /src
export default {
  name: 'home',
  data () {
    return {
      activeIndex: '1',
      input: '',
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath);
    },
    handleAsk () {
      console.info('123')
    },
    changePasswords () {

    },
    logout () {

    }
  }
}
</script>

<style lang="scss">
.home {
  background-color: #f6f6f6;
  width: 100%;
  height: 100%;
  .el-header {
    background-color: #ffffff;
    .header-content {
      width: 1100px;
      margin: 0 auto;
      .logo {
        vertical-align: super;
      }
      .menu {
        display: inline-block;
        .el-menu-top {
          height: 51px;
          display: inline-block;
          margin-left: 50px;
          border-bottom-width: 0px;
          .el-menu-item {
            height: 52px;
            font-weight: 600;
            font-size: 15px;
            line-height: 52px;
          }
          // .is-active {
          //   color: #444;
          // }
        }
      }
      .top-search {
        display: inline-block;
        vertical-align: top;
        margin-top: 10px;
        margin-left: 20px;
        .el-input {
          height: 34px;
          width: 300px;
        }
        .el-button {
          display: inline-block;
          margin-left: 15px;
          font-size: 14px;
        }
      }
      .more {
        display: inline-block;
        margin-left: 100px;
        vertical-align: top;
        margin-top: 13px;
        float: right;
        span {
          i {
            font-size: 25px;
          }
        }
        .userinfo-inner {
          cursor: pointer;
        }
        .username {
          vertical-align: text-bottom;
          font-weight: 600;
          font-size: 16px;
        }
      }
    }
  }
  .main {
    width: 1100px;
    margin: 0 auto;
  }
}
</style>
