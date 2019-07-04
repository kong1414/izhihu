<template>
  <!-- 回答内容的组件 -->
  <div class="myanswer-item">
    <el-button type="text">
      <div class="disDetName">{{queName}}</div>
    </el-button>
    <div style="margin-top:10px;">
      <el-image class="avaImag" :src="null"></el-image>
      <span class="disDetAuthor">{{author}}</span>
      <span style="font-size:14px;">, {{authorDet}}</span>
    </div>
    <div class="disDetque" @click=" dialogVisible = true">{{queDet}}</div>
    <div class="ope">
      <span>
        <el-button class="apprBut" v-if="attiStat!=1" @click="attiStat=1">
          <i class="el-icon-caret-top"></i>
          <span>赞同 {{apprN}}</span>
        </el-button>
        <el-button
          class="apprBut"
          style="background:#0084ff;width:120px;"
          v-if="attiStat==1"
          @click="attiStat=0;"
        >
          <i class="el-icon-caret-top" style="color:white;"></i>
          <span style="color:white;">已赞同 {{apprN}}</span>
        </el-button>
        <el-button class="oppBut" v-if="attiStat!=2" @click="attiStat=2">
          <i class="el-icon-caret-bottom"></i>
        </el-button>
        <el-button
          class="oppBut"
          style="background:#0084ff;"
          v-if="attiStat==2"
          @click="attiStat=0"
        >
          <i class="el-icon-caret-bottom" style="color:white;"></i>
        </el-button>
      </span>
      <el-button type="text" class="shareBut" @click="commentVisible = true">
        <!-- <comment :commentVisible = "commentVisible"/> -->
        <i class="el-icon-chat-line-round shareI" />
        <span>{{evalN}} 条评论</span>
      </el-button>
      <el-button type="text" class="shareBut">
        <i class="el-icon-s-promotion shareI" />
        <span>分享</span>
      </el-button>
      <el-button type="text" class="shareBut">
        <i class="el-icon-star-on shareI" />
        <span>收藏</span>
      </el-button>
      <el-button type="text" class="shareBut">
        <i class="el-icon-s-flag shareI" />
        <span>感谢</span>
      </el-button>
    </div>
    <el-divider></el-divider>
    <!-- 问题答案内容 -->
    <el-dialog :title="queName" :visible.sync="dialogVisible" width="600px">
      <div class="dialog-body">
        <span>{{queDet}}</span>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">关 闭</el-button>
      </span>
    </el-dialog>
    <!-- 评论内容 -->
    <el-dialog :title="evalN+'条评论'" :visible.sync="commentVisible" width="600px">
      <div class="dialog-body">
        <!-- <CommetItem></CommetItem> -->
        <div v-for="comDet in comDets" :key="comDet.commentator_id" class="vforD">
          <div class="comName">
            {{comDet.name}}
            <span
              v-if="comDet.is_reply!=0"
              @click="showReply(comDet.is_reply)"
              class="replyName"
            >回复了{{replayname}}</span>
          </div>
          <div class="comContent">{{comDet.comment_content}}</div>
          <div class="comTime">{{comDet.create_time.substr(0,10)}}</div>
          <div>
            <el-button
              class="shareBut"
              v-if="comDet.stat!=1"
              @click="comDet.stat=1"
              style="margin-left: 0px;"
              size="mini"
              type="text"
            >
              <i class="el-icon-caret-top"></i>
              <span>{{apprN}}</span>
            </el-button>
            <el-button
              class="shareBut"
              size="mini"
              v-if="comDet.stat==1"
              @click="comDet.stat=0;"
              style="color: #0084ff;margin-left: 0px;"
              type="text"
            >
              <i class="el-icon-caret-top"></i>
              <span>{{apprN}}</span>
            </el-button>
            <el-button
              class="shareBut"
              size="mini"
              v-if="comDet.stat!=2"
              style="margin-left:10px;"
              @click="comDet.stat=2"
              type="text"
            >
              <i class="el-icon-caret-bottom"></i>
              <span>踩</span>
            </el-button>
            <el-button
              class="shareBut"
              v-if="comDet.stat==2"
              size="mini"
              @click="comDet.stat=0"
              type="text"
            >
              <i class="el-icon-caret-bottom"></i>
              <span>取消踩</span>
            </el-button>
            <el-button
              type="text"
              size="mini"
              class="shareBut"
              @click="replayStat = !replayStat;replayCom(comDet.id)"
            >
              <i class="el-icon-s-comment" />
              <span>回复</span>
            </el-button>
            <el-button type="text" size="mini" class="shareBut">
              <i class="el-icon-warning" />
              <span>举报</span>
            </el-button>
            <el-divider></el-divider>
          </div>
        </div>
      </div>
      <span slot="footer">
        <div style="margin-top: -15px;" v-if="!replayStat">
          <el-input placeholder="请输入评论" v-model="input2">
            <el-button slot="append">发送</el-button>
          </el-input>
        </div>
        <div style="margin-top: -15px;" v-if="replayStat">
          <el-input placeholder="回复" v-model="input2">
            <el-button slot="append">发送</el-button>
          </el-input>
        </div>
      </span>
    </el-dialog>
  </div>
</template>

<script>
// import CommentItem from './Comment'
export default {
  name: "AnswerItem",
  components: {
    // CommentItem
  },
  props: {
    topicId: String,
    attiStat: String,
    apprN: String,
    evalN: String,
    queName: String,
    author: String,
    authorDet: String,
    queDet: String
  },
  data() {
    return {
      comDets: [
        {
          create_time: "2019-07-02T13:49:03.000+0000",
          commentator_id: "c6c4cb00-9188-4722-9817-08b0c53aa182",
          praise_num: 0,
          name: "qwe",
          comment_content: "评论内容1",
          id: 1,
          comment_id: "0c593ec4-feea-4751-99bd-bfee1434961e",
          is_reply: 0,
          stat: "0"
        },
        {
          create_time: "2019-07-02T13:49:44.000+0000",
          commentator_id: "c6c4cb00-9188-4722-9817-08b0c53aa182",
          praise_num: 0,
          name: "wer",
          comment_content: "评论内容2",
          id: 2,
          comment_id: "0c593ec4-feea-4751-99bd-bfee1434961e",
          is_reply: 0,
          stat: "1"
        },
        {
          reply_id: 1,
          create_time: "2019-07-02T13:50:40.000+0000",
          commentator_id: "c6c4cb00-9188-4722-9817-08b0c53aa182",
          praise_num: 0,
          name: "ert",
          comment_content: "测试回复内容1: 回复内容1",
          id: 3,
          comment_id: "0c593ec4-feea-4751-99bd-bfee1434961e",
          is_reply: 1,
          stat: "2"
        },
        {
          create_time: "2019-07-04T04:03:04.000+0000",
          commentator_id: "c6c4cb00-9188-4722-9817-08b0c53aa182",
          praise_num: 0,
          name: "rty",
          comment_content: "评论内容3",
          id: 4,
          comment_id: "0c593ec4-feea-4751-99bd-bfee1434961e",
          is_reply: 0,
          stat: "2"
        }
      ],
      dialogVisible: false,
      commentVisible: true,
      replayname: null,
      replayStat: false,
      replaycom: null
    };
  },
  methods: {
    handleClick() {},
    showReply(id) {
      this.comDets.forEach(element => {
        console.info(element);
        if (element.id === id) this.replayname = element.name;
        console.info(this.replayname);
      });
    },
    replayCom(id) {
      this.comDets.forEach(element => {
        console.info(element);
        if (element.id === id) this.replaycom = element.name;
        console.info(this.replaycom);
      });
    }
  }
};
</script>
<style lang="scss">
.myanswer-item {
  .text {
    font-size: 14px;
    .disDetName {
      font-size: 18px;
      font-weight: 600;
      color: black;
    }
    .disDetAuthor {
      font-size: 15px;
      font-weight: 600;
      margin-left: 10px;
    }
    .disDetque {
      margin-top: 15px;
      font-size: 15px;
      color: #1a1a1a;
      overflow: hidden;
      max-height: 100px;
      line-height: 1.6;
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 3; //行数
      -webkit-box-orient: vertical；;
    }
    .ope {
      margin-top: 8px;
      i {
        font-size: 18px;
        color: #0084ff;
      }
      .apprBut {
        height: 35px;
        width: 110px;
        background: #0084ff1a;
        line-height: 30px;
        text-align: center;
        font-size: 14px;
        border-radius: 3px;
        padding: 0px 10px;
        border-width: 0px;
        span {
          color: #0084ff;
        }
      }
      .oppBut {
        height: 35px;
        line-height: 30px;
        text-align: center;
        font-size: 14px;
        border-radius: 3px;
        padding: 0px 10px;
        background: #0084ff1a;
        border-width: 0px;
      }
    }
  }
  .item {
    margin-bottom: 18px;
    .avaImag {
      float: left;
      width: 24px;
      height: 24px;
    }
  }
  .dialog-body {
    padding: 22px;
    margin-top: -5px;
    font-size: 15px;
    .replyName {
      color: #8590a6;
      margin-left: 5px;
    }
    .comName {
      font-weight: 500;
      line-height: 24px;
      color: #1a1a1a;
      // margin-left: -10px;
    }
    .comContent {
      line-height: 1.6;
      margin-top: 5px;
      color: #1a1a1a;
    }
    .comTime {
      font-size: 14px;
      color: #8590a6;
      margin-top: 5px;
      float: right;
    }
    .shareBut {
      font-size: 14px;
      color: #8590a6;
      text-align: center;
      // margin-left: 0px;
      // margin-bottom: 10px;
      // width: 70px;
    }
    .el-divider--horizontal {
      margin: 0px;
      margin-bottom: 15px;
      margin-top: 10px;
    }
    .comInput {
      width: 80%;
    }
  }
}
</style>
