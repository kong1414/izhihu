<template>
<!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="favorite-container">
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
  name: 'favorite',
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
.favorite-container {
  .favorite-card {

  }
}
</style>
