<template>
<!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="favorite-container">
    <el-main>

    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <el-card class="creator" :body-style="{ padding: '10px 0px 10px 20px' }">
        <div>
          <span>关于创建者</span>
        </div>
        <div class="creator-message">
          <el-avatar class="img" shape="square" :fit="cover" :src="photoUrl"></el-avatar>
          <el-button type="text" class="btn-creator-name">昵称</el-button>
        </div>
      </el-card>
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
  .creator{
    .creator-message{
      padding: 10px 0px 0px 6px;
      margin-bottom: 65px;
      .img {
          float: left;
          width: 60px; 
          height: 60px;
      }
      .btn-creator-name{
          float: left;
          margin-left: 16px;
          padding-top: 20px;
      }
    }
  }
  
}
</style>
