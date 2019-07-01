<template>
  <div class="item-content">
    <el-row>
      <el-col :span="2">
        <div class="id">
          <el-button type="text">
            <p>1</p>
            <i class="el-icon-star-on"/>
          </el-button>
        </div>
      </el-col>
      <el-col :span="16">
        <div class="content">
          <a class="tit">标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题</a>
          <p class="abs">摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要</p>
          <a href="">点赞</a>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="photo">
          <el-image
          style="width: 177px; height: 160px"
          :src="url"></el-image>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'ArticleItem',
  data () {
    return {
    url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss">
.item-content{
  background: aqua;
  height: 160px;
  .id{
    background:black;
    text-align: center; 
    height: 160px;
  }
  .content{
    background:blue;
    height: 160px;
    .tit{
      font-size: 30px;
      display: -webkit-box;
      text-overflow: ellipsis;
      overflow: hidden;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
    }
    .abs{
      font-size: 20px;
      display: -webkit-box;
      text-overflow: ellipsis;
      overflow: hidden;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
    }
  }
  .photo{
    background:chartreuse;
    height: 160px;
  }
}
</style>

