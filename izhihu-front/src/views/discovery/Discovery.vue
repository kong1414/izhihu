<template>
  <el-container class="discovery-container">
    <el-main>
      <el-card class="recommend-crad">
        <div slot="header">
          <i class="el-icon-s-unfold"></i>
          <span class="left">编辑推荐</span>
          <el-button class="right" type="text" @click="_loadData()">
            换一换  <i class="el-icon-refresh"></i>
          </el-button>
        </div>
        <div class="recommend" v-for="(i,index) in recommendList" :key="index" >
          <el-button class="title" type="text" @click="toQues(i.ques_id)"><span><b>{{i.ques_name}}</b></span></el-button>
          <div class="message">
            <span>回答人数：{{i.attention_num}}   作者：{{i.name}}    浏览人数：{{i.browse_num}}  更新时间：{{i.update_time}}</span>
          </div>
          <div class="hl-line"></div>
        </div>
      </el-card>
      <el-card class="recommend" style="margin-top:20px;">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="七日最热" name="today">
            <!-- {{todayList}} -->
            <div v-for="(item, index) in todayList" :key="index">
                  <!-- {{item}} -->
                  <answer-item
                    :queName="item.title"
                    :author="item.name"
                    :queDet="item.content"
                    :articleId="item.article_id"
                    :queId="item.ques_id"
                    :type="item.type"
                    :authorId="item.author_id"
                    :photoUrl="item.photo_url"
                  />
                </div>
          </el-tab-pane>
          <el-tab-pane label="本月最热" name="month">
            <!-- {{monthList}} -->
            <div v-for="(item, index) in monthList" :key="index"> 
                  <!-- {{item}} -->
                  <answer-item
                    :queName="item.title"
                    :author="item.name"
                    :queDet="item.content"
                    :articleId="item.article_id"
                    :queId="item.ques_id"
                    :type="item.type"
                    :authorId="item.author_id"
                    :photoUrl="item.photo_url"
                  />
                </div>
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-main>
    <el-aside width="300px" style="min-height:200px">
      <aside-discovery></aside-discovery>
    </el-aside>

  </el-container>
</template>
<script>
import dataUtil from "../../util/dataUtil";
import AsideDiscovery from '../../components/aside/AsideDiscovery'
import RecommendItem from '../../components/index/RecommendItem'
import AnswerItem from "../../components/index/AnswerItem";
import { reqEditorRecommend } from '../../api/question'
import { reqGetRecommend } from '../../api/topic'
import { reqTodayHot, reqMonthHot } from '../../api/home'
export default {
  name: 'discovery',
  components: {
    AsideDiscovery,
    RecommendItem,
    AnswerItem
  },
  data () {
    return {
      userId: this.$store.state.user.userId,
      activeName: 'today',
      recommendList: [],
      todayList: [],
      monthList: [],
    }
  },
  mounted () {
    this._loadData()
  },
  methods: {
    _loadData () {
      reqGetRecommend().then(res => { //编辑推荐内容
        if (res.resultCode === 200) {
          console.info(res.data)
          this.recommendList = res.data.map(i => {
            i.update_time = dataUtil.getStrData(i.update_time)
            if (i.anonymity == 1) {
              i.name = '匿名用户'
            }
            return i
          })
        }
      })

      reqTodayHot().then(res => {
        if (res.resultCode == 200) {
          res.data.forEach(element => {
            element.update_time = dataUtil.getStrData(element.update_time)
          });
          this.todayList = res.data
        }
      })

      reqMonthHot().then(res => {
        if (res.resultCode == 200) {
          res.data.forEach(element => {
            element.update_time = dataUtil.getStrData(element.update_time)
          });
          this.monthList = res.data
        }
      })
    },
    handleClick () { // 改变今日最热 和 本月最热
      
    },
    toQues (id) {
      this.$router.push({ path: "/home/question/" + id })
    }
  }
}
</script>

<style lang="scss">
.discovery-container {
  .recommend-crad {
    min-height: 200px;
    .left{
      padding-left: 5px;
    }
    .right{
      padding: 3px 0;
      float:right;
      color:rgb(133, 144, 166);
    }
    .recommend{
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
  }
  .today-hot {
    margin-top: 20px;
  }

}
</style>
