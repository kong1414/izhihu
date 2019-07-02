<template>
<!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="topicDetail-container">
    <el-main class="topDet">
      <el-card>
        <el-image
          style="width: 100px; height: 100px;"
          :src="url"
          ></el-image>
        
            <span>{{topName}}</span>
          
      </el-card>
      <el-card class="secCard">
        <div slot="header" class="clearfix">
          <span class="dis">讨论</span>
          <el-button style="float: right; padding: 3px 0" type="text">更多内容</el-button>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
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
      url:'',
      topName:'高考',
      topDet:''
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
  .topDet{
    .secCard{
      margin-top: 20px;
    }
    .dis{
      font-weight: bold;
      font-size: 20px;
    }
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both;
  }
}
</style>
