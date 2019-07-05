<template>
  <el-container class="home-container">
    <el-aside width="200px">
      123
    </el-aside>
    <el-main>
      <header></header>
      <router-view />
    </el-main>
  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Index from './Index'
import Header from '../components/Header'

export default {
  name: 'home',
  components: {
    HelloWorld,
    Index,
    Header
  }
}
</script>
