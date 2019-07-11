<template>
  <div class="search-box">
    <!-- 123{{$route.params.input}} -->
    <el-card class="search-card" :body-style="{ padding: '0px' }">
      <div slot="header"><span>“ {{$route.params.input}} ”</span> 的搜索结果 <el-button size="mini" @click="_loadData()">再次搜索</el-button></div>

      <div class="search-content" v-loading="loading">
        <div v-if="list.length <= 0" class="nonSearch">非常抱歉，未能搜索到您想要的结果</div>
        <!-- <div v-else v-for="(item,index) in list" :key="index">
          {{item}}
        </div> -->
        <div v-else class="recommend" v-for="(i,index) in list" :key="index" >
          <el-button class="title" type="text" @click="toQues(i.quesId)"><span><b>{{i.quesName}}</b></span></el-button>
          <div v-html="i.quesDescribe"></div>
          <div class="message">
            <span>回答人数：{{i.attentionNum}}   关注人数：{{i.attentionNum}}    浏览人数：{{i.browseNum}}  更新时间：{{i.updateTime}}</span>
          </div>
          <div class="hl-line"></div>
        </div>
      </div>


    </el-card>
  </div>
</template>

<script>
import {reqFindQuesByName} from '../../api/question'
import dataUtil from '../../util/dataUtil';

export default {
  name: 'search',
  data () {
    return {
      list: [],
      loading: true
    }
  },
  mounted () {
    this._loadData()
  },
  methods: {
    _loadData () {
      let params="keyword=" + this.$route.params.input
      reqFindQuesByName(params).then(res => {
        if (res.resultCode == 200) {
          this.list = res.data.map(i => {
            i.updateTime = dataUtil.getStrData(i.updateTime)
            return i
          })
        }
        this.loading = false
      })
    },
    toQues(id) {
      this.$router.push({ path: "/home/question/" + id })
    }
  }
}
</script>

<style lang="scss">
.search-box {
  width: 1100px;
  height: 100%;
  margin-top: 20px;
  .search-card {
    .search-content {
      min-height: 300px;
      padding: 0px 10px;
      .recommend{
        padding:  0 20px;
        .title{
          color: #259;
        }
        .message{
          margin: 5px 0px;
          color: #999;
        }
        .hl-line{
          height: 1px;
          width: 110%;
          margin: 10px -50px 10px -20px;
          background-color: #ebeef5;
        }
      }
      .nonSearch{
        margin: 20px 20px;
      }
    }
  }
}
</style>
