<template>
  <el-container class="home">
    <el-header>
      header
    </el-header>
    <el-container>
      <el-main>
        Main
        </el-main>
      <el-aside width="200px" style="background-color:green;height:200px">
        Aside
      </el-aside>
    </el-container>
    <el-footer>
      Footer
    </el-footer>
  </el-container>
</template>

<script>
// @ is an alias to /src
export default {
  name: 'home',
  data () {
    return {
      searchBarFixed: true
    }
  },
  methods: {
  }
}
</script>

<style lang="scss">
.home {
  width: 100%;
  height: 100%;
}
</style>

