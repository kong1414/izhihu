<template>
  <!-- 回答内容的组件 -->
  <!-- 话题头部卡片 -->
  <div class="myanswer-item">
    <el-button type="text" size="mini" @click="toQueDetail()" class="disDetName">
      {{queName}}
    </el-button>
    <el-tag type="info" size="mini" v-if="type==1">问题</el-tag>
    <el-tag type="info" size="mini" v-else-if="type==2">文章</el-tag>
    <el-tag type="info" size="mini" v-else>想法</el-tag>
    
    <div style="margin:5px 0;" v-if="author!=null">
      <el-avatar shape="square" :size="20" :src="url"></el-avatar>    
      <span class="disDetAuthor">{{author}}</span>
    </div>
    <div class="disDetque" @click=" dialogVisible = true" v-html="queDet"></div>
    <!-- 文章、问答详情 -->
    <div class="ope">
      <span>
        <el-button class="apprBut" v-if="attiStat!=1" @click="attiStat=1;like()">
          <i class="el-icon-caret-top"></i>
          <span>赞同 {{likeNum}}</span>
        </el-button>
        <el-button
          class="apprBut"
          style="background:#0084ff;width:120px;"
          v-if="attiStat==1"
          @click="preAtti = attiStat;attiStat=-1;canclike()"
        >
          <i class="el-icon-caret-top" style="color:white;"></i>
          <span style="color:white;">已赞同 {{likeNum}}</span>
        </el-button>
        <el-button class="oppBut" v-if="attiStat!=0" @click="preAtti=attiStat;attiStat=0;unlike()">
          <i class="el-icon-caret-bottom"></i>
        </el-button>
        <el-button
          class="oppBut"
          style="background:#0084ff;"
          v-if="attiStat==0"
          @click="preAtti = attiStat;attiStat=-1;canclike()"
        >
          <i class="el-icon-caret-bottom" style="color:white;"></i>
        </el-button>
      </span>
      <el-button type="text" class="shareBut" @click="commentVisible = true">
        <i class="el-icon-chat-line-round shareI" />
        <span>{{comNum}} 条评论</span>
      </el-button>
      <el-button type="text" class="shareBut">
        <i class="el-icon-s-promotion shareI" />
        <span>分享</span>
      </el-button>
      <el-button type="text" class="shareBut" @click="comFavriVisible=true">
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
      <div class="dialog-body" v-html="queDet"></div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">关 闭</el-button>
      </span>
    </el-dialog>
    <!-- 评论内容 -->
    <el-dialog :title="comNum+'条评论'" :visible.sync="commentVisible" width="600px">
      <div class="dialog-body">
        <div v-for="(comDet, index) in comDets" :key="index" class="vforD">
          <div class="comName">
            {{comDet.name}}
            <span
              v-if="comDet.is_reply!=0"
              class="replyName"
            >回复了 {{comDet.replayname}}</span>
          </div>
          <div class="comContent">{{comDet.comment_content}}</div>
          <div class="comTime">{{comDet.create_time}}</div>
          <div class="operaBut">
            <el-button
              class="shareBut"
              v-if="comDet.stat!=1"
              @click="comDet.stat=1;comlike(comDet)"
              style="margin-left: 0px;"
              size="mini"
              type="text"
            >
              <i class="el-icon-caret-top"></i>
              <span>{{comDet.praise_num}}</span>
            </el-button>
            <el-button
              class="shareBut"
              size="mini"
              v-if="comDet.stat==1"
              @click="preAtti =comDet.stat; comDet.stat=-1;comcanclike(comDet)"
              style="color: #0084ff;margin-left: 0px;"
              type="text"
            >
              <i class="el-icon-caret-top"></i>
              <span>{{comDet.praise_num}}</span>
            </el-button>
            <el-button
              class="shareBut"
              size="mini"
              v-if="comDet.stat!=0"
              style="margin-left:10px;"
              @click="preAtti =comDet.stat;comDet.stat=0;comunlike(comDet)"
              type="text"
            >
              <i class="el-icon-caret-bottom"></i>
              <span>踩</span>
            </el-button>
            <el-button
              class="shareBut"
              v-if="comDet.stat==0"
              size="mini"
              @click="preAtti =comDet.stat;comDet.stat=-1;comcanclike(comDet)"
              style="color: #0084ff;margin-left:10px;"
              type="text"
            >
              <i class="el-icon-caret-bottom"></i>
              <span>踩</span>
            </el-button>
            <el-button
              type="text"
              size="mini"
              class="shareBut"
              @click="replayStat = !replayStat;replayCom(comDet.id);remarkId=comDet.id"
            >
              <i class="el-icon-s-comment" />
              <span>回复</span>
            </el-button>
            <el-button type="text" size="mini" class="shareBut">
              <i class="el-icon-warning" />
              <span>举报</span>
            </el-button>
            <el-button
              type="text"
              size="mini"
              class="shareBut"
              v-if="comDet.del"
              @click="delCom(comDet.id)"
            >
              <i class="el-icon-error" />
              <span>删除</span>
            </el-button>
            <el-divider></el-divider>
          </div>
        </div>
      </div>
      <span slot="footer">
        <div style="margin-top: -15px;" v-if="!replayStat">
          <el-input placeholder="请输入评论" v-model="input" autocomplete="off">
            <el-button slot="append" @click="remark()">发送</el-button>
          </el-input>
        </div>
        <div style="margin-top: -15px;" v-if="replayStat">
          <el-input placeholder="请输入评论" v-model="input" autocomplete="off">
            <template slot="prepend">回复 {{replaycom}}</template>
            <el-button slot="append" @click="remarkPeople(remarkId)">发送</el-button>
          </el-input>
        </div>
      </span>
    </el-dialog>
    <!-- 评论收藏弹窗 -->
    <el-dialog title="添加收藏" :visible.sync="comFavriVisible" width="600px">
      <div class="creaColl-body">
        <el-select v-model="v" placeholder="请选择">
          <el-option
            v-for="item in creaCollections"
            :key="item.favoriteId"
            :label="item.favoriteName"
            :value="item.favoriteId"
          ></el-option>
        </el-select>
        <el-button
          type="primary"
          @click="comFavriVisible = false;collArt(v);"
          style="float:right;"
        >提 交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { reqMyFavorite, reqCollect } from "../../api/favorite";
import { reqGetArticleCom, reqRemark, reqDelCom } from "../../api/comment";
import {
  reqCheckOpp,
  reqLike,
  reqUnLike,
  reqCancelLike
} from "../../api/follow";
import dataUtil from "../../util/dataUtil";
export default {
  name: "AnswerItem",
  components: {
    // CommentItem
  },
  props: {
    // 从topicDet取数据：点赞数、评论数、问题文章名称、作者、问题文章详情、回答id、问题id、类型
    apprN: Number,
    evalN: Number,
    queName: String,
    author: String,
    queDet: String,
    articleId: String,
    queId: String,
    type: Number
  },
  data() {
    return {
      // 评论详情、收藏夹
      comDets: [],
      creaCollections: [],
      // 问题答案弹窗、评论弹窗、删除评论按钮、评论收藏弹窗、回复框前面、回复某人姓名
      dialogVisible: false,
      commentVisible: false,
      delVisible: false,
      comFavriVisible: false,
      replayStat: false,
      replaycom: null,
      //获取当前页面用户名、用户id、回复输入框、选择器当前值、点赞状态、点赞数、先前的点赞状态、回复Id、评论数、头像路径
      username: "",
      userId: this.$store.state.user.userId,
      input: "",
      v: "",
      attiStat: -1,
      likeNum: this.apprN,
      preAtti: "",
      remarkId: "",
      comNum: 0,
      url:''
    };
  },
  mounted() {
    this._loadData();
    this.username = this.$store.state.user.name;
  },
  methods: {
    _loadData() {
      let params = "articleId=" + this.articleId;
      let userParams = "userId=" + this.userId;
      let userArtiParams = {
        userId: this.userId,
        contentId: this.articleId
      };
      reqGetArticleCom(params).then(res => {  //获取文章评价
        if (res.resultCode === 200) {
          res.data.forEach(element => {
            element.stat = -1;
          });
          //赋值回复了谁、计算评论数、显示删除评论按钮、评价时间戳
          this.comNum = 0;
          res.data.forEach(element => {
            if (element.name == this.username) element.del = true;
            else element.del = false;
            this.comNum++;
            element.create_time = dataUtil.getStrData(element.create_time)
            if (element.is_reply != 0) {
              res.data.forEach(element2 => {
                if (element.reply_id === element2.id)
                  element.replayname = element2.name;
              });
            }
          });
          this.comDets = res.data;
        }
      });
      reqMyFavorite(userParams).then(res => {//获取我的收藏夹
        if (res.resultCode == 200) {
          this.creaCollections = res.data;
        }
      });
      reqCheckOpp(userArtiParams).then(res => {  //获取点赞状态
        if (res.resultCode == 200) {
          this.attiStat = res.data;
        }
      });
    },
    replayCom(id) {  //根据id获取用户名
      this.comDets.forEach(element => {
        if (element.id === id) this.replaycom = element.name;
      });
    },
    toQueDetail() {
      // 跳转到问题主页
      if (this.type == 1)
        this.$router.push({ path: "/home/question/" + this.queId });
    },
    collArt(v) {  //收藏弹窗
      let params = {
        articleId: this.articleId,
        favoritesId: v
      };
      reqCollect(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: "success",
            message: res.resultMessage
          });
        } 
      });
    },
    like() { //回答点赞
      let params = {
        userId: this.userId,
        contentId: this.articleId
      };
      reqLike(params).then(res => {
        if (res.resultCode == 200) {
          this.likeNum++;
          this.$message({
            type: "success",
            message: res.resultMessage
          });
        }
      });
    },
    unlike() {  //回答踩
      let params = {
        userId: this.userId,
        contentId: this.articleId
      };
      if (this.preAtti == 1) {
        reqCancelLike(params).then(res => {
          if (res.resultCode == 200) {
            this.likeNum--;
          }
        });
        reqUnLike(params).then(res => {
          if (res.resultCode == 200) {
            this.attiStat = 0;
            this.$message({
              type: "success",
              message: res.resultMessage
            });
          }
        });
      } else {
        reqUnLike(params).then(res => {
          if (res.resultCode == 200) {
            this.attiStat = 0;
            this.$message({
              type: "success",
              message: res.resultMessage
            });
          }
        });
      }
    },
    canclike() {  //回答取消态度
      let params = {
        userId: this.userId,
        contentId: this.articleId
      };
      if (this.preAtti == 1) {
        reqCancelLike(params).then(res => {
          if (res.resultCode == 200) {
            this.attiStat = -1;
            this.likeNum--;
            this.$message({
              type: "success",
              message: res.resultMessage
            });
          }
        });
      } else {
        reqCancelLike(params).then(res => {
          if (res.resultCode == 200) {
            this.attiStat = -1;
            this.$message({
              type: "success",
              message: res.resultMessage
            });
          }
        });
      }
    },
    comlike(v) {  //评论点赞
      let params = {
        userId: this.userId,
        contentId: v.id
      };
      reqLike(params).then(res => {
        if (res.resultCode == 200) {
          v.praise_num++;
        }
      });
    },
    comunlike(v) { //评论踩
      let params = {
        userId: this.userId,
        contentId: v.id
      };
      if (this.preAtti == 1) {
        reqCancelLike(params).then(res => {
          if (res.resultCode == 200) {
            v.praise_num--;
          }
        });
        reqUnLike(params).then(res => {
          if (res.resultCode == 200) {
          }
        });
      } else {
        reqUnLike(params).then(res => {
          if (res.resultCode == 200) {
          }
        });
      }
    },
    comcanclike(v) {  //评论取消态度
      let params = {
        userId: this.userId,
        contentId: v.id
      };
      if (this.preAtti == 1) {
        reqCancelLike(params).then(res => {
          if (res.resultCode == 200) {
            v.praise_num--;
          }
        });
      } else {
        reqCancelLike(params).then(res => {
          if (res.resultCode == 200) {
          }
        });
      }
    },
    remark() {  //评论
      let params = {
        commentContent: this.input,
        commentId: this.articleId,
        commentatorId: this.userId,
        isReply: 0,
        replyId: 0
      };
      this.input = null;
      reqRemark(params).then(res => {
        if (res.resultCode == 200) {
          this._loadData();
          this.$message({
            type: "success",
            message: res.resultMessage
          });
        }
      });
    },

    remarkPeople(v) {
      // 回复某人
      let params = {
        commentContent: this.input,
        commentId: this.articleId,
        commentatorId: this.userId,
        isReply: 1,
        replyId: v
      };
      this.input = null;
      reqRemark(params).then(res => {
        if (res.resultCode == 200) {
          this._loadData();
          this.$message({
            type: "success",
            message: res.resultMessage
          });
        }
      });
    },
    delCom(v) {  //删除自己评论
      let params = {
        id: v,
        userId: this.$store.state.user.userId
      };
      reqDelCom(params).then(res => {
        if (res.resultCode == 200) {
          this._loadData();
          this.$message({
            type: "success",
            message: res.resultMessage
          });
        }
      });
    }
  }
};
</script>
<style lang="scss">
.myanswer-item {
    font-size: 14px;
    .disDetName {
      font-size: 18px;
      font-weight: 600;
      color: black;
      margin-right: 10px;
    }
    .disDetAuthor {
      font-size: 15px;
      font-weight: 600;
      margin-left: 10px;
      line-height: 20px;
      padding: 0px;
    }
    .disDetque {
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
      .shareBut {
        color: #76839b;
        font-size: 15px;
        margin-left: 20px;
        i {
          font-size: 18px;
        }
        .shareI {
          color: #8590a6;
          padding: 0px 5px;
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
  .creaColl-body {
    padding: 22px;
    margin-top: -5px;
    font-size: 15px;
    .creaCollName {
      font-weight: 700;
      line-height: 1.7;
      font-size: 15px;
      color: #1a1a1a;
    }
    .creaCollBut {
      float: right;
      border: 0px;
    }
    .creaCollBut2 {
      float: right;
      border: 0px;
      color: #fff;
      background-color: #8590a6;
    }
    .el-button {
      padding-left: 0;
      padding-right: 0;
      width: 76px;
    }
  }
  .dialog-body {
    padding: 22px;
    margin-top: -5px;
    font-size: 15px;
    max-height: 500px;
    overflow: auto;
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
      margin-top: 15px;
    }
    .comInput {
      width: 80%;
    }
  }
  .el-divider--horizontal {
    margin:12px 0;
  }
}
</style>
