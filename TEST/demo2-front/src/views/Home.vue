<template>
  <el-container class="home-container">
    <el-header height="68px"
               class="home-header">

    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu class="menu"
                 default-active="/home/index"
                 @open="handleOpen"
                 @close="handleClose"
                 background-color="#ffffff"
                 text-color="#000000"
                 router>
          <el-menu-item>
            <span slot="title">
              <span style="font-size: 16px;color: #575a64;">菜单项</span>
              <span class="MENU">MENU</span>
            </span>

            <span style="float:right;font-size: 17px;color: #575a64;">>></span>
          </el-menu-item>
          <el-menu-item v-if="this.$store.state.user.type=='1'"
                        index="/home/bookmanage">
            <i class="el-icon-s-management"></i>
            <span slot="title">图书管理</span>
          </el-menu-item>
          <el-menu-item v-if="this.$store.state.user.type=='1'"
                        index="/home/borrowhistory"
                        class="menuItem">
            <i class="el-icon-s-order"></i>
            <span slot="title">借阅历史</span>
          </el-menu-item>
          <el-menu-item v-if="this.$store.state.user.type=='0'"
                        index="/home/bookborrow">
            <i class="el-icon-s-management"></i>
            <span slot="title">图书借阅</span>
          </el-menu-item>
          <el-menu-item v-if="this.$store.state.user.type=='0'"
                        index="/home/myborrow"
                        class="menuItem">
            <i class="el-icon-s-order"></i>
            <span slot="title">我的借阅</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main class="main">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import HeaderItem from '../components/Header'


export default {
  name: 'home',
  components: {
    HeaderItem,
    HelloWorld
  },
  methods: {
    handleOpen () {

    },
    handleClose () {

    },
  },
}
</script>

<style lang="scss">
.home-container {
  height: 100%;
  width: 100%;
  .home-header {
    background-image: url("../img/HeadLogo.png");
  }
  .main {
    background-color: #eef5f9;
    padding: 0;
  }
  .menu {
    .el-menu-item {
      .MENU {
        margin-left: 10px;
        color: #b5b6ba;
        font-size: 14px;
        color: #a3a4a9;
      }
      i {
        color: #b5b6ba;
      }
    }
    .el-menu-item:hover {
    }
  }
}
</style>
