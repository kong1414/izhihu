<template>
  <el-container class="topic-container">
    <el-main>
      <el-card class="att-topic-crad">
        <div slot="header">
          <span>已关注的话题动态</span>
          <span style="float:right">共关注了{{i}}个话题</span>
        </div>
        <div class="label">
          <TopicLabel v-for="(i, index) in items" :key="index" :list="i" @selectLabel="selectLabel"></TopicLabel>
        </div>
      </el-card>
      <el-card class="topic-item">
        <div class="introduction-head">
          <img class="img" src="" alt="">
          <el-button type="text" class="btn-tname" >话题</el-button>
          <el-button type="text" icon="el-icon-plus" class="btn-att" v-if="isFollow" @click="isFollow=!isFollow">关注</el-button>
          <el-button type="text"  class="btn-att" v-if="!isFollow" @click="isFollow=!isFollow">已关注</el-button>
        </div>
        <hr style="margin-top:20px; border:1px solid #CCCCCC; width:100%;">
        <div class="introduction">
          <div class="firCardName">
            <span>{{topName}}</span>
          </div>
          <div class="firCardDet">
            <span>{{topDet}}</span>
          </div>
        </div>
      </el-card>
    </el-main>
    <el-aside width="300px" style="min-height:200px">
      <aside-topic></aside-topic>
    </el-aside>
  </el-container>
</template>

<script>
import AsideTopic from '../../components/aside/AsideTopic'
import TopicLabel from '../../views/topic/TopicLabel'
export default {
  name: 'topic',
  components: {
    AsideTopic,
    TopicLabel
  },
  data () {
    return {
      items: [
        { id: 1, type: '', label: '高考', isSelect: false },
        { id: 2, type: '', label: '游戏', isSelect: false },
        { id: 3, type: '', label: '理财', isSelect: false },
        { id: 4, type: '', label: '摄影', isSelect: false },
        { id: 5, type: '', label: '美食', isSelect: false },
        { id: 6, type: '', label: '篮球', isSelect: false },
        { id: 7, type: '', label: '旅游', isSelect: false },
        { id: 8, type: '', label: '物理', isSelect: false },
        { id: 9, type: '', label: '数学', isSelect: false },
        { id: 10, type: '', label: '时尚', isSelect: false },
        { id: 11, type: '', label: '计算机', isSelect: false }
      ],
      i: '3000',
      labelcount: 31,
      isFollow: false,
      topName: '高考',
      topDet: '普通高等学校招生全国统一考试（The National College Entrance Examination），简称“高考”，是中华人民共和国（不包括香港特别行政区、澳门特别行政区和台湾省）合格的高中毕业生或具有同等学历的考生参加的选拔性考试。 2018年8月，北京市新高考方案公布。'
    }
  },
  methods: {
    selectLabel (data) {
      for (let i of this.items) {
        i.isSelect = false
        if (i.id === data) {
          i.isSelect = true
        }
      }
    }
  }
}
</script>

<style lang="scss">
.topic-container {
  // .att-topic-crad {
  // }
  .topic-item {
    margin-top: 15px;
  }
  .label{
    height: auto;
    width: 100%;
    .tag-group{
      float: left;
      margin-left: 12px;
      margin-bottom: 10px;
    }
  }
  .topic-item{
    .introduction-head{
      margin-right: 28px;
      .img{
        float: left;
        margin-left: 10px;
        width: 55px;
        height: 55px;
      }
      .btn-tname{
        margin-left: 18px;
        margin-top: 8px;
      }
      .btn-att{
        margin-top: 8px;
        float:right;
      }
    }
    .introduction{
      .firCardName{
        font-size: 28px;
        font-weight:bold;
      }
      .firCardDet{
        text-indent:50;
      }
    }
  }
}

</style>
