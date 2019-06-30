<template>
<!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="topicDetail-container">
    <el-main>

    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <aside-collection></aside-collection>
      <aside-Footer></aside-Footer>
    </el-aside>
  </el-container>
</template>
<script>
import AsideFooter from '../../components/aside/AsideFooter'
import AsideCollection from '../../components/aside/AsideCollection'
export default {
  name: 'topicDetail',
  components: {
    AsideFooter,
    AsideCollection
  },
  data () {
    return {
    }
  },
  methods: {
    handleClick () {

    }
  }
}
</script>
<style lang="scss">
.topicDetail-container {

}
</style>
