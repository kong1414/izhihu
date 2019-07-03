<template>
  <el-container>
    <el-header>Header</el-header>
    <el-container>
      <el-main>
        Main
      </el-main>
      <el-aside width="300px">
        123
        <aside-collection></aside-collection>
        <aside-footer/>
      </el-aside>
    </el-container>
    
  </el-container>

</template>

<script>
import AsideFooter from '../../components/aside/AsideFooter'
export default {
  name: 'question',
  components: {
    AsideFooter,
  },
  data () {
    return {

    }
  },
  methods: {

  }
}
</script>

<style lang="scss">

</style>
