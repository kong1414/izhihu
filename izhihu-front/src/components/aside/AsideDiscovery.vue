<template>
  <div class="aside-discovery">
    <aside-hotcolumn></aside-hotcolumn>

    <el-card class="hot-topic" :body-style="{ padding: '0px' }">
      <div slot="header" class="topHeader">
          <span class="topicLeft">热门话题</span>
          <el-button type="text" class="topicRight">
            更多话题
            <i class="el-icon-d-arrow-right"></i>
          </el-button>
      </div>  
      <div v-for="i in list" :key="i" class="topiclist">
        <el-avatar class="img" shape="square" :fit="cover" :src="i.photoUrl"></el-avatar>
        <div class="nameNum" >
          <el-button class="name" type="text">{{i.topicName}}</el-button>
          <span class="number">{{i.attNum}} 人关注</span>
        </div>
      </div>
    </el-card>

    <el-card class="hot-collect" :body-style="{ padding: '0px' }">
      <div slot="header" class="cl-topHeader">
        <span class="cl-topicLeft">热门收藏</span>
        <el-button type="text" class="cl-topicRight">
          换一换
          <i class="el-icon-refresh"></i>
        </el-button>
      </div>

      <div v-for="k in cllist" :key="k" class="cllist">
        <el-button class="clbodyname" type="text">{{k.clName}}</el-button>
        <span class="clNumCon">{{k.clnum}} 人关注  •  {{k.clcont}} 条内容</span>
      </div>
    </el-card>

    <aside-footer></aside-footer>
  </div>
</template>
<script>
import { reqGetHotTopic } from '../../api/topic'
import AsideHotcolumn from '../../components/aside/AsideHotColumn'
import AsideFooter from '../../components/aside/AsideFooter'
export default {
  name: 'asideDiscovery',
  components: {
    AsideFooter,
    AsideHotcolumn
  },
  data () {
    return {
      list: [],
      cllist: [
        { clName: '吃很重要', clnum:'100', clcont:'123'},
        { clName: '吃很重要', clnum:'100', clcont:'123'},
        { clName: '吃很重要', clnum:'100', clcont:'123'}
      ],
      
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      reqGetHotTopic().then(res => {
        if (res.resultCode === 200) {
          console.info(res.data)
          this.list = res.data
        }
      })
    }
  }
}
</script>
<style lang="scss">
.aside-discovery {
  .hot-topic {
    padding: 0px;
    .topHeader{
      margin: -10px;
      .topicRight{
        float:right;
        padding:3px 0px;
        color:rgb(133, 144, 166);
      }
    }
    .topiclist{
      margin: 15px 10px;

      .img{
        background-color: blanchedalmond;
        float: left;
        width: 45px; height: 45px;
      }
      .nameNum{
        // width: 100px;
        height: 45px;
        .name{
          display: flex;
          height: 22px;
          margin-left: 55px;
          padding:0px;
        }
        .number{
          display: flex;
          height: 22px;
          margin-left: 55px;
          padding:0px;
          color:#999;
        }
      }
    }
  }
  .hot-collect {
    
    .cl-topHeader{
      margin: -10px;
      
      .cl-topicRight{
        float:right;
        padding:3px 0px;
        color:rgb(133, 144, 166);
      }
    }
    .cllist{
      margin:5px 10px;
        .clbodyname{
          display: flex;          
        }
        .clNumCon{
          color:#999;
        }
    }
  }

}
</style>
