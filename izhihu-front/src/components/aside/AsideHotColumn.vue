<template>
<el-card class="hotcolumn" :body-style="{ padding: '0px' }">    
  <div slot="header" class="hotHeader">
    <span class="topicLeft">热门专栏</span>
  </div>

  <div v-for="i in hotlist" :key="i" class="hotColumnList"> 
    <el-button class="titleName" type="text">{{i.titlename}}</el-button>
    <span class="attenPeople">{{i.attpeople}} 人关注  •  {{i.connecttitle}} 篇文章</span>
  </div>
</el-card>
</template>


<script>
export default {
  name:'hotColunm',
  data(){
    return{
      hotlist:[
        {titlename:'一只猫·一只猫',attpeople:"18634",connecttitle:"10"},
        {titlename:'两只猫·两只猫',attpeople:"18634",connecttitle:"10"}
      ]
    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss">
.hotcolumn {
  .hotHeader {
    margin: -10px;

  }

  .hotColumnList {
    margin:5px 10px 10px;

    .titleName { 
      display: flex; 
    }
    .attenPeople {
      color:#999;
    }
  }
}
</style>
