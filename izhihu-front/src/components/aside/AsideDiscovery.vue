<template>
  <div class="aside-discovery">
    <!-- <el-card class="hot-table">
    </el-card> -->

    <el-card class="hot-topic " :body-style="{ padding: '0px' }">
      <div slot="header" class="topHeader">
          <span class="topicLeft">热门话题</span>
          <el-button type="text" class="topicRight">
            更多话题
            <i class="el-icon-d-arrow-right"></i>
          </el-button>
      </div>
      <div v-for="i in list" :key="i" class="topiclist">
        <div class="img" :src="photoUrl"></div>
        <el-button class="name" type="text">{{i.topicName}}</el-button>
        <span class="number">{{i.attNum}}</span>
      </div>
    </el-card>

    <aside-footer></aside-footer>
  </div>
</template>
<script>
import { reqGetHotTopic } from '../../api/topic'
import AsideFooter from '../../components/aside/AsideFooter'
export default {
  name: 'asideDiscovery',
  components: {
    AsideFooter
  },
  data () {
    return {
      list: []
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
  .hot-table {
  }
  .hot-topic {
    padding: 0px, 0px, 0px, 0px;
    .topHeader{
      margin: -10px;
      .topicLeft{
        font-weight:bold;
      }
      .topicRight{
        float:right;
        padding:3px 0px;
        color:rgb(133, 144, 166);
      }
    }
    .topiclist{

      margin: 10px 10px;
      .img{
        background-color: chartreuse;
        width: 50px; height: 50px;
      }
      .name{
        color:#303133;
        padding:0px 0px;
      }
    }
  }
  .hot-collect {
    background-color: green;
  }
}
</style>
