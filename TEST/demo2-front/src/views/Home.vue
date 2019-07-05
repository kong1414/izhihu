<template>
  <el-container class="home-container">
    <header>123</header>
    <el-aside width="200px">
      123
    </el-aside>
    <el-main>
      
      <router-view />
    </el-main>
  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import index from './Index'
import header from '../components/Header'

export default {
  name: 'home',
  components: {
    HelloWorld,
    index,
    header
  }
}
</script>
