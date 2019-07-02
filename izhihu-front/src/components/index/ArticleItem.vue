<template>
  <div>
    <div class="item-content" v-for="item in list" :key="item.id">
      <div class="index">
        <div class="hot">{{item.id}}</div>
      </div>
      <div class="content">
        <h2 class="title" :title="item.title" @click="doSubmit">{{item.title}}</h2>
        <p class="excerpt" :title="item.title" @click="doSubmit">{{item.excerpt}}</p>
        <div class="button-content">
          <span class="heat">{{item.heat}}万热度</span>
          <el-button type="text" class="share">{{item.share}}</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ArticleItem',
  data () {
    return {
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      list: [
        {
          id: '1',
          title: '为什么有很多人说百度全面降低了中国的互联网的良好体验?',
          excerpt: '今天说说不定华盛顿还会的文化啊是的话安徽的哈手动阿森纳大很多快乐按时扩大和阿斯顿你阿瑟东阿瑟东今天说说不定华盛顿还会的文化啊是的话安徽的哈手动阿森纳大很多快乐按时扩大和阿斯顿你阿瑟东阿瑟东',
          heat: '123',
          share: '分享'
        }
      ]
    }
  },
  methods: {
    doSubmit (){
      console.log(1);
    }
  }
}
</script>

<style lang="scss">
.item-content{
  border-bottom: rgb(221, 213, 213) 1px solid;
  color: #000;
  display: flex;
  font-size: 15px;
  width: 718px;
  height: 137px;
  background: #fff;
  padding: 16px 16px 16px 0;
  .index{
    text-align: center;
    width: 57px;
    .hot{
      color: #ff9607;
      line-height: 1.6;
      font-size: 18px;
      font-weight: 600;
    }
  }
  .content{
    width: 651px;
    height: 105px;
    .title{
      font-size: 18px;
      line-height: 28px;
      max-height: 56px;
      display: -webkit-box;
      text-overflow: ellipsis;
      overflow: hidden;
      -webkit-line-clamp: 1;
      -webkit-box-orient: vertical;
      font-weight: 600;
      cursor:pointer;
    }
    .excerpt{
      color: #444;
      line-height: 25px;
      margin-top: 0px;
      min-height: 25px;
      display: -webkit-box;
      text-overflow: ellipsis;
      overflow: hidden;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      cursor:pointer;
    }
    .button-content{
      -webkit-box-flex: 1;
      -ms-flex: 1 1;
      flex: 1 1;
      overflow: hidden;
      color: #8590a6;
      .share{
        margin-left: 20px;
        color: #8590a6;
      }
    }
  }
  
}
</style>

