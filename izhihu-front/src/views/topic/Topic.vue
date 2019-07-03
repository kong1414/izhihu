<template>
  <el-container class="topic-container">
    <el-main>
      <el-card class="att-topic-crad">
        <div slot="header">
          <span>已关注的话题动态</span>
          <span style="float:right">共关注了{{attTopicNum}}个话题</span>
        </div>
        <div class="label">
          <el-radio v-for="i in attedTopicList"
                    :key="i.topicId"
                    v-model="topicSelect"
                    :label="i.topicId"
                    border
                    size="mini"
                    @change="selectLabel">{{i.topicName}}
          </el-radio>
        </div>
      </el-card>
      <el-card class="topic-item">
        <div v-if="topicObj.topicId==null">
          暂未选择话题
        </div>
        <div v-else
             class="topic-detail">
          <div class="topic-name">
            <el-button type="text"
                       @click="toTopicDetail">{{topicObj.topicName}}</el-button>
          </div>
          <div>
            {{topicObj.topicDesc}}
          </div>
          <el-button icon="el-icon-plus"
                     class="attButton"
                     size="mini"
                     v-show="!topicObj.isFollow"
                     @click="handleFollow(topicObj)">关注</el-button>
          <el-button v-show="topicObj.isFollow"
                     class="attButton"
                     size="mini"
                     @click="handleFollow(topicObj)">已关注</el-button>
        </div>
        <div class="introduction-head">

        </div>
        <!-- <hr style="margin-top:20px; border:1px solid #CCCCCC; width:100%;">
        <div class="introduction">
          <div class="firCardName">
            <span>{{topicObj.topicName}}</span>
          </div>
          <div class="firCardDet">
            <span>{{topicObj.topicDesc}}</span>
          </div>
        </div> -->
      </el-card>
    </el-main>
    <el-aside width="300px"
              style="min-height:200px">
      <aside-topic></aside-topic>
    </el-aside>
  </el-container>
</template>

<script>
import { reqAttedTopic, reqTopicDetial } from '../../api/topic'
import { reqUnFollow, reqInFollow } from '../../api/follow'
import AsideTopic from '../../components/aside/AsideTopic'
import { truncate } from 'fs';
export default {
  name: 'topic',
  components: {
    AsideTopic,
  },
  data () {
    return {
      attedTopicList: [], // 已关注的列表
      attTopicNum: 0,
      topicObj: {},
      topicSelect: '', // 单选框
    }
  },
  mounted () {
    this._loadData()
  },
  methods: {
    _loadData () {
      this._loadAttedTopic()
    },
    _loadAttedTopic () {
      let params = 'userId=' + this.$store.state.user.userId
      reqAttedTopic(params).then(res => {
        if (res.resultCode == 200) {
          this.attedTopicList = res.data
          this.attTopicNum = res.data.length
        }
      })

    },
    selectLabel (v) {
      console.info(v)
      let params = 'topicId=' + v
      reqTopicDetial(params).then(res => {
        if (res.resultCode == 200) {
          res.data.isFollow = true // 这里查的默认是已关注的所以直接设置为true
          console.info(res.data)
          this.topicObj = res.data
        }
      })
    },
    handleFollow (obj) { // 点击可以取消关注和关注他
      console.info(obj)

      if (obj.isFollow == true) { // 取消关注进这里
        let params = {
          contentId: obj.topicId,
          userId: this.$store.state.user.userId
        }
        reqUnFollow(params).then(res => {
          if (res.resultCode == 200) {
            this.$message(res.resultMessage)
            obj.isFollow = false
          }
        })
      } else { // 重新关注进这里
        console.info('重新关注进这里')
        let params = {
          contentId: obj.topicId,
          userId: this.$store.state.user.userId,
          type: 5
        }
        reqInFollow(params).then(res => {
          if (res.resultCode == 200) {
            this.$message(res.resultMessage)
            obj.isFollow = true
          }
        })
      }
      console.info(obj)
    },
    toTopicDetail () {
      this.$router.push({ path: '/home/topicDetail/' + this.topicObj.topicId })
    }
  }
}
</script>

<style lang="scss">
.topic-container {
  .label {
    height: auto;
    width: 100%;
    .el-radio {
      margin-right: 0px;
    }
  }
  .topic-item {
    margin-top: 15px;
    .topic-detail {
      .attButton {
        display: block;
        margin-top: 10px;
      }
      .attButton + .attButton {
        margin-left: 0px;
      }
      .topic-name {
        .el-button {
          font-size: 20px;
          font-weight: 600;
        }
      }
    }
    .introduction-head {
      margin-right: 28px;
      .img {
        float: left;
        margin-left: 10px;
        width: 55px;
        height: 55px;
      }
      .btn-tname {
        margin-left: 18px;
        margin-top: 8px;
      }
      .btn-att {
        margin-top: 8px;
        float: right;
      }
    }
    .introduction {
      .firCardName {
        font-size: 28px;
        font-weight: bold;
      }
      .firCardDet {
        text-indent: 50;
      }
    }
  }
}
</style>
