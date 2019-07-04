<template>
  <div class="AsideHotColumn">
    <el-card class="hotcolumn" :body-style="{ padding: '0px' }">    
      <div slot="header" class="hotHeader">
        <span class="topicLeft">热门专栏</span>
      </div>
      <div v-for="i in hotlist" :key="i.id" class="hotColumnList"> 
        <el-button class="titleName" type="text">{{i.titlename}}</el-button>
        <span class="attenPeople">{{i.attpeople}} 人关注  •  {{i.connecttitle}} 篇文章</span>
      </div>
    </el-card>
  </div>
</template>


<script>
export default {
  name:'hotColunm',
  data () {
    return {
      hotlist:[
        {id:1, titlename:'一只猫·一只猫',attpeople:"18634",connecttitle:"10"},
        {id:2, titlename:'两只猫·两只猫',attpeople:"18634",connecttitle:"10"}
      ]
    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss">
.AsideHotColumn {
  .hotcolumn {
    margin-top:20px;
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
}

</style>
