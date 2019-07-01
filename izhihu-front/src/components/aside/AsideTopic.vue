<template>
  <el-aside class="aside-topic">
      <el-card class="aside-top">
        <el-button type="primary" class="btn-Topic-square">进入话题广场</el-button>
        <el-button type="text" class="btn-find">来这里发现更多有趣话题</el-button>
      </el-card>
      <el-card class="aside-attention" :body-style="{ padding: '0px' }">
        <div slot="header" class="clearfix">
        <span>其他人关注的话题</span>
        <el-button style="margin-left:80px; padding: 3px 0" type="text" class="change">换一换</el-button>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
        {{'列表内容 ' + o }}
        </div>
      </el-card>
  </el-aside>
</template>

<script>
export default {
  name: 'asidetopic',
  el: '#test',
  components: {
  },
  data () {
    return {
    }
  },
  computed: {
  },
  methods: {
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
      border: 1px solid rgba(70, 130, 180, 0.41);
      padding: 13px;
      border-radius: 4px;
      text-align: center;
      background-color: #eff6fA;
      .btn-Topic-square{ 
      }
      .btn-find{
      height: auto;
      width: 100%;
      display: inline-block;
      color: #5488b4;
      cursor: pointer;
      font-size: 13px;
      color: #5488b4;
      float: left;
      margin: 10px auto 0;
      }
      .btn-find:hover{
      color: #345570;
      }
    }
    .aside-attention{
      margin-top: 18px;
      .clearfix{
        margin-left: 0px;
      }
    }
  }
</style>
