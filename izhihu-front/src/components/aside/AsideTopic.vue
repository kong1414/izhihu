<template>
  <el-aside class="aside-topic">
      <el-card class="aside-top">
        <el-button type="primary" class="btn-Topic-square">进入话题广场</el-button>
        <el-button type="text" class="btn-find">来这里发现更多有趣话题</el-button>
      </el-card>
      <el-card class="aside-attention" :body-style="{ padding: '0px' }">
        <div slot="header" class="clearfix">
        <span>其他人关注的话题</span>
        <el-button type="text" style=" padding: 3px 0" @click="_loadData()" icon="el-icon-refresh" class="change" >换一换</el-button>
        </div>
        <div v-for="o in list" :key="o" class="text-item">
          <el-avatar class="img" shape="square" :src="o.photoUrl"></el-avatar>
          <el-button type="text" class="btn-topic-name" >{{o.topicName}}</el-button>
          <el-button type="text" icon="el-icon-plus" class="btn-attention"
          v-if="!o.isFollow" @click="o.isFollow=!o.isFollow">关注</el-button>
          <el-button type="text"  class="btn-attention"
          v-if="o.isFollow" @click="o.isFollow=!o.isFollow">已关注</el-button>
        </div>
      </el-card>
  </el-aside>
</template>


<script>
import { reqGetAsideTopic } from '../../api/topic'
export default {
  name: 'asidetopic',
  components: {
  },
  data () {
    return {
      list: [
        { 'isFollow': false },
        { 'isFollow': false },
        { 'isFollow': false },
        { 'isFollow': false },
        { 'isFollow': false }
      ]
    }
  },
  created () {
    this._loadData()
  },
  methods: {
     _loadData () {
      reqGetAsideTopic().then(res => {
        if (res.resultCode == 200) {
          console.info(res.data)
          this.list = res.data

        }
      })
    }
  }
}
</script>

<style lang="scss">
  .aside-topic{
    margin-top: 20px;
    .aside-top{
      text-decoration: none;
      height: 145px;
      width: 280px;
      // border: 1px solid rgba(70, 130, 180, 0.41);
      padding: 13px;
      border-radius: 4px;
      text-align: center;
      background-color: #eff6fA;
      .btn-find{
        height: auto;
        width: 100%;
        display: inline-block;
        color: #5488b4;
        cursor: pointer;
        font-size: 13px;
        color: #5488b4;
        //float: left;
        margin: 10px auto 0;
      }
      .btn-find:hover{
        color: #345570;
      }
    }
    .aside-attention{
      margin-top: 18px;
      width: 280px;
      //.clearfix{
      //}
      .change{
        margin-left:62px;
      }
      .text-item{
        margin-top: 12px;
        .img{
          float: left;
          margin-left: 10px;
          width: 45px;
          height: 45px;
          background-color: blanchedalmond;
        }
        .btn-topic-name{
          margin-left: 16px;
        }
        .btn-attention{
          margin-left: 110px;
        }
      }
    }
  }
</style>
