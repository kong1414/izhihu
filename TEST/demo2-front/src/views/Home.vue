<template>
  <el-container class="home-container">
    <el-header height="60px"
               class="header">
      <header-item></header-item>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu :collapse="collapsed"
                 default-active="/home/index"
                 @open="handleOpen"
                 @close="handleClose"
                 background-color="#ffffff"
                 text-color="#000000"
                 active-text-color="blue"
                 router>
          <el-menu-item index="/home/index" class="menuItem">
            <span>菜单项</span>
            <span class="MENU">MENU</span>
            <span style="float:right;">>></span>
          </el-menu-item>
          <el-menu-item index="/home/bookborrow" class="menuItem">
            <i class="el-icon-s-management"></i>
            <span slot="title">图书管理</span>
          </el-menu-item>
          <el-menu-item index="/home/borrowhistory/10001"  class="menuItem">
            <i class="el-icon-s-order"></i>
            <span slot="title">借阅历史</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main class="main">
        <router-view />
      </el-main>
    </el-container>

    <el-aside width="200px">
    </el-aside>
    <!-- <el-main>
      <router-view />
    </el-main> -->
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
  }
}
</script>

<style lang="scss">
.home-container {
  .header {
    background-color: aqua;
  }
  .main {
    background-color: #eef5f9;
    padding: 0;
  }
  .menuItem{
    span{
      color: black;
    }
    .MENU{
      margin-left:10px;
      color: #b5b6ba;
      font-size: 13px;
    }
    i{
      color: #b5b6ba;
    }
  }
}
</style>
