<template>
  <el-container class="collection-container">
    <el-main>
      <el-card class="collection-card">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="我关注的收藏夹" name="att-collection">
            我关注的收藏夹
          </el-tab-pane>
          <el-tab-pane label="我创建的收藏夹" name="cteate-collection">
            我创建的收藏夹
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <aside-collection></aside-collection>
    </el-aside>
  </el-container>
</template>
<script>
import AsideCollection from '../../components/aside/AsideCollection'
export default {
  name: 'collection',
  components: {
    AsideCollection
  },
  data () {
    return {
      activeName: 'att-collection'
    }
  },
  methods: {
    handleClick () {

    }
  }
}
</script>
<style lang="scss">
.collection-container {
  .collection-card {
    
  }
}
</style>


