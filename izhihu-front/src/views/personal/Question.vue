<template>
  <el-container class="question-container">
    <el-header class="header">
      <el-card class="question-header-card">
        <div class="quesTopic">
          <span class="title">相关话题：</span>
          <span v-if="topicList.length <= 0"> 暂无关联话题</span>
          <el-tag v-else v-for="i in topicList" :key="i.topic_id" @click="toTopic">
            <el-button size="mini" type="text">{{i.topic_name}}</el-button>
          </el-tag>
        </div>
        <div class="quesName">{{quesInfo.quesName}}</div>
        <div class="quesdesc">
          <div v-html="quesInfo.quesDescribe"></div>
        </div>
        <div class="button-group">
          <el-button v-if="attQuesType" type="primary" size="mini" @click="attQues">已关注</el-button>
          <el-button v-else type="primary" size="mini" @click="attQues">关注问题</el-button>
          <el-button type="primary" plain size="mini" @click="writeAnswerVisible = true">写回答</el-button>
          <el-button type="info" plain size="mini">邀请回答</el-button>
          <!-- <el-button type="text">
            <i class="el-icon-s-comment" />评论
          </el-button> -->
          <el-button type="text" @click="share">
            <i class="el-icon-s-promotion" />分享
          </el-button>
          <el-button type="text" @click="report">
            <i class="el-icon-warning" />举报
          </el-button>
        </div>
      </el-card>
    </el-header>

    <el-container>
      <el-main>
        <el-card>
          <div slot="header">全部回答</div>
          <div>
            <!-- <answer-item></answer-item> -->
          </div>
        </el-card>
      </el-main>
      <el-aside width="300px" class="ques-aside">
        <el-card class="att-right">
          <el-row>
            <el-col :span="12">
              <div class="att-title">关注者</div>
              <div class="att-title-N">{{quesInfo.attentionNum}}</div>
            </el-col>
            <el-col :span="12">
              <div class="att-title">浏览量</div>
              <div class="att-title-N">{{quesInfo.browseNum}}</div>
            </el-col>
          </el-row>
        </el-card>
        <aside-discovery style="margin-top: 20px;" />
      </el-aside>
    </el-container>
    <el-dialog title="写回答" width="600px" :visible.sync="writeAnswerVisible" class="wriAnsDia">
      <div class="wriAnsHead">
        <el-avatar shape="square" :size="40" :src="user.photoUrl" style="float: left;"></el-avatar>
        <span class="wriAnsAuthor">{{user.name}}</span>
        <div class="rightArea">
          <span class="noname">匿名发布</span>
          <el-radio v-model="radio" label="0">否</el-radio>
          <el-radio v-model="radio" label="1">是</el-radio>
        </div>
      </div>
      <div class="content">
        <quill-editor
          v-model="content"
          :options="editorOption"
        ></quill-editor>
      </div>
      <div class="diaFooter">
        <el-button type="primary" @click="handleUp()">提交回答</el-button>
        <!-- <i class="el-icon-s-tools"/>设置 -->
      </div>
    </el-dialog>
  </el-container>
</template>

<script>
import AnswerItem from "../../components/index/AnswerItem";
import AsideFooter from "../../components/aside/AsideFooter";
import AsideDiscovery from "../../components/aside/AsideDiscovery";
import { reqFindQuestionById, reqAnswer, reqFindTopicByQues } from "../../api/question";
import { reqInFollow,reqUnFollow } from '../../api/follow'

export default {
  name: "question",
  components: {
    AsideFooter,
    AnswerItem,
    AsideDiscovery
  },

  data() {
    return {
      quesId: this.$route.params.quesid,
      attQuesType: false, // 关注默认为未关注
      quesInfo: {
        anonymity: 0,
        answerNum: 0,
        attentionNum: 0,
        browseNum: 0,
        createTime: "2019-07-05T00:53:35.000+0000",
        del: 0,
        photoUrl: "",
        quesDescribe: "",
        quesId: "",
        quesName: "",
        questionerId: "",
        updateTime: ""
      },
      topicList: [],
      writeAnswerVisible: false,
      squareUrl: "",
      author: "123",
      radio: "0",
      content:'请输入您的回答',
      editorOption: {},
      user: this.$store.state.user
    }
  },
  created() {
    this._loadData();
  },
  methods: {
    _loadData() {
      let params = "quesId=" + this.$route.params.quesid;
      reqFindQuestionById(params).then(res => {
        if (res.resultCode == 200) {
          this.quesInfo = res.data;
          console.info(123, this.quesInfo);
        }
      });
      // 查询作者
      // TODO:
      // 查询相关联话题
      let params2 = 'quesId=' + this.quesId
      reqFindTopicByQues(params2).then(res => {
        if (res.resultCode ==200) {
          this.topicList = res.data
        }
      })
    },
    handleUp () {
      if(this.content == ''){
        this.$message("回答不能为空")
        return
      }
      let params = {
        anonymity: Number(this.radio),
        content: this.content,
        quesId: this.quesId,
        userId: this.$store.state.user.userId
      }
      reqAnswer(params).then(res=> {
        if (res.resultCode == 200) {
          this.$message({
            type:'success',
            message: res.resultMessage
          })
          this._loadData()
          this.writeAnswerVisible = false
          this.content = ''
        }
      })

    },
    attQues () {
      if (!this.attQuesType) { // 关注
        let params = {
          type: 4, // 问题是4
          userId: this.user.userId,
          contentId: this.quesId,
        }
       reqInFollow(params).then(res => {
         if (res.resultCode ==200) {
          this.$message({
            type:'success',
            message: res.resultMessage
          })
          this.attQuesType = true
         }
       })
      } else if (this.attQuesType) { // 取消关注
        let params = {
          userId: this.user.userId,
          contentId: this.quesId,
        }
       reqUnFollow(params).then(res => {
         if (res.resultCode ==200) {
          this.$message({
            type:'success',
            message: res.resultMessage
          })
          this.attQuesType = false
         }
       })
      }
      return
    },
    toTopic (id) {
      this.$router.push({ path: '/home/topicDetail/' + id})
    },
    invite () {
      this.$message("暂未实现")
    },
    share () {
      this.$message("暂未实现")
    },
    report () {
      this.$message("暂未实现")
    }
  }
};
</script>

<style lang="scss">
.question-container {
  .header {
    background-color: initial;
    height: auto !important;
    .question-header-card {
      margin-top: 20px;
      .quesTopic {
        .title {
          font-size: 15px;
          line-height: 1.5px;
          margin-right: 20px;
        }
      }
      .quesName {
        font-size: 22px;
        font-weight: 600;
        margin-top: 10px;
      }
      .quesdesc {
        word-break: break-word;
        line-height: 1.6;
        margin-top: 5px;
      }
      .button-group {
        margin-top: 5px;
      }
    }
  }
  .ques-aside {
    padding-right: 20px;
    padding-top: 20px;
  }
  .att-right {
    text-align: center;
    .att-title {
      font-size: 14px;
      color: #8590a6;
    }
    .att-title-N {
      font-size: 18px;
      color: #1a1a1a;
      font-weight: 600;
    }
  }
    .wriAnsHead {
      padding: 16px 22px;
      height: 56px;
      padding-bottom: 0px;
      .wriAnsAuthor {
        float: left;
        font-weight: 600;
        color: #444;
        font-size: 15px;
        margin: 10px 10px;
      }
      .rightArea {
        float: right;
        line-height: 40px;
      }
      .noname {
        margin-right: 20px;
      }
    }
    .content {
      min-height: 310px;
      .quill-editor {
        .ql-container {
          min-height: 200px;
        }
      }
    }
    .diaFooter{
      width: 100%;
      padding: 15px 22px;
      i{
        margin-left: 10px
      }
      .el-button{
        padding: 6px 10px;
        // margin-right: 20px;
        // margin-left: 10px;
        // margin-bottom: 15px;
      }
    }
  }
</style>
