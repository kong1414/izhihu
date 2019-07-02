<template>
<!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="topicDetail-container">
    <el-main class="topDet">
      <el-card>
        <el-image
          style="width: 100px; height: 100px;float:left;"
          :src="url"
          ></el-image>
        <div class="firCard">
          <div class="firCardName">
            <span>{{topName}}</span>
          </div>
          <div class="firCardDet">
            <span>{{topDet}}</span>
          </div>
        </div>  
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
      topDet:'普通高等学校招生全国统一考试，简称“高考”，是中华人民共和国（不包括香港特别行政区、澳门特别行政区和台湾省）合'
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
    .firCard{
      width: 580px;
      height: 100px;
      float:left;
      margin-left:30px;
    }
    .firCardName{
      font-weight: bold;
      font-size: 25px;
      height: 30px;
    }
    .firCardDet{
      margin-top: 10px;
      font-size: 15px;
      color: #646464;
      height: 50px;
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
