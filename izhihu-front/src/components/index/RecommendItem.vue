<template>
  <!-- contentItem内容的组件 -->
  <div class="recommend-item">
    <h1>{{title}}</h1>
    <div class="item-main">
      <p class="detail">{{content}}</p>
    </div>
    <div class="item-opp">
      <el-button size="mini" type="primary"><i class="el-icon-caret-top"/>赞同123</el-button>
      <el-button size="mini" type="info"><i class="el-icon-caret-bottom"/></el-button>
      <div class="right">
        <el-button  type="text"><i class="el-icon-s-comment"/>添加评论</el-button>
        <el-button  type="text"><i class="el-icon-s-promotion"/>分享</el-button>
        <el-button  type="text"><i class="el-icon-star-on"/>收藏</el-button>
        <el-button  type="text"><i class="el-icon-warning"/>举报</el-button>
      </div>
      
    </div>
  </div>
</template>

<script>
export default {
  name: 'contentItem',
  props: {
    title: String,
    content: String,
    articleId: String,
    quesId: String,
    type: String,
    heatNum: String
  },
  data () {
    return {
      data: {
      }
    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss">
.recommend-item {
  width: 710px;
  // background-color: aquamarine;
  // height: 170px;
  padding: 10px 0;
  border-bottom: 1px solid #F0F2F7; 
  h1 {
    font-size: 18px;
    font-weight: 600;
  }
  .item-main {
    max-height: 80px;
    width: 100%;
    .detail {
      // word-break: break-word;
      line-height: 1.6;
      font-size: 15px;
      color: #1a1a1a;
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 3; //行数
      -webkit-box-orient: vertical;
    }
  }
  .item-opp {
    .right {
      margin-left: 20px;
      display: inline;
      .el-button {
        color: #8590a6;
      }
      .el-button + .el-button {
        margin-left: 15px;
      }
    }
  }
}
</style>

