<template>
  <el-container class="home-container">
    <header></header>
    <el-aside width="200px">
      <div>
        <el-button type="text" style="color:black;">菜单项</el-button>
      </div>
      <div>
        <el-button type="text">图书借阅</el-button>
      </div>
      <div>
        <el-button type="text">我的借阅</el-button>
      </div>
    </el-aside>
    <el-main>
      
      <router-view/>
    </el-main>
  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import index from './Index'
import Header from '../components/Header'

export default {
  name: 'home',
  components: {
    HelloWorld,
    index,
    Header
  }
}
</script>
