<template>
  <el-container class="home-container">
    <el-header height="60px"
               class="header">
      <header-item></header-item>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu class="el-menu-vertical"
                 :collapse="collapsed"
                 default-active="/home/index"
                 @open="handleOpen"
                 @close="handleClose"s
                 background-color="#ffffff"
                 text-color="#000000"
                 active-text-color="blue"
                 router>
          <el-menu-item index="/home/index">
            <i class="el-icon-document"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-menu-item index="/home/index">
            <i class="el-icon-document"></i>
            <span slot="title">2</span>
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
    HeaderItem
  }
}
</script>

<style lang="scss">
.home-container {
  .header {
    background-color: aqua;
  }
  .main {
    background-color: bisque;
  }
}
</style>

