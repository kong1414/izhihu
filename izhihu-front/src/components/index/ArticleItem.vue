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
          <a class="title">标题.....................</a>
          <p class="abs">摘要....................</p>
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
    .title{
      font-size: 30px;
    }
    .abs{
      font-size: 20px;
    }
  }
  .photo{
    background:chartreuse;
    height: 160px;
  }
}
</style>

