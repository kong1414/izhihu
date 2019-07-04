<template>
<!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="favorite-container">
    <el-main>
      <el-card class="favorite">

      </el-card>
    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <el-card class="creator" :body-style="{ padding: '20px 0px 10px 20px' }">
        <div>
          <span style=" font-size:15px; ">关于创建者</span>
        </div>
        <div class="creator-message">
          <el-avatar class="img" shape="square" :fit="cover" :src="photoUrl"></el-avatar>
          <el-button type="text" class="btn-creator-name">昵称</el-button>
        </div>
      </el-card>
      <el-card class="favorite-status" :body-style="{ padding: '18px 0px 5px 20px'}">
        <div>
          <span style="font-size:15px; ">收藏夹状态</span>
        </div>
        <div class="time">
          <span style="font-size:12px; ">最近活动于 09:14</span>
        </div>
        <div class="count-attention">
          <el-button type="text">0</el-button>
          <span style="font-size:12px; "> 人关注了该收藏夹</span>
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
  .favorite-status{
     margin-top: 10px;
     .time{
       margin-top:14px; 
     }
    //  .count-attention{  
    //  }
  }
}
</style>
