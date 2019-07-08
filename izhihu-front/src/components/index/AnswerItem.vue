<template>
  <!-- 回答内容的组件 -->
  <!-- 话题头部卡片 -->
  <div class="myanswer-item">
    <el-button type="text" @click="toQueDetail ()">
      <div class="disDetName">{{queName}}</div>
    </el-button>
    <div style="margin-top:10px;">
      <el-image class="avaImag" :src="null"></el-image>
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
          @click="attiStat=-1;unlike()"
        >
          <i class="el-icon-caret-top" style="color:white;"></i>
          <span style="color:white;">已赞同 {{likeNum}}</span>
        </el-button>
        <el-button class="oppBut" v-if="attiStat!=0" @click="attiStat=0;">
          <i class="el-icon-caret-bottom"></i>
        </el-button>
        <el-button
          class="oppBut"
          style="background:#0084ff;"
          v-if="attiStat==0"
          @click="attiStat=-1"
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
    <el-dialog :title="evalN+'条评论'" :visible.sync="commentVisible" width="600px">
      <div class="dialog-body">
        <!-- <CommetItem></CommetItem> -->
        <div v-for="(comDet, index) in comDets" :key="index" class="vforD">
          <div class="comName">
            {{comDet.name}}
            <span
              v-if="comDet.is_reply!=0"
              class="replyName"
            >回复了 {{comDet.replayname}}</span>
          </div>
          <div class="comContent">{{comDet.comment_content}}</div>
          <div class="comTime">{{comDet.create_time.substr(0,10)}}</div>
          <div class="operaBut">
            <el-button
              class="shareBut"
              v-if="comDet.stat!=1"
              @click="comDet.stat=1;praNadd(comDet)"
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
              @click="comDet.stat=0;praNsub(comDet)"
              style="color: #0084ff;margin-left: 0px;"
              type="text"
            >
              <i class="el-icon-caret-top"></i>
              <span>{{comDet.praise_num}}</span>
            </el-button>
            <el-button
              class="shareBut"
              size="mini"
              v-if="comDet.stat!=2"
              style="margin-left:10px;"
              @click="comDet.stat=2;"
              type="text"
            >
              <i class="el-icon-caret-bottom"></i>
              <span>踩</span>
            </el-button>
            <el-button
              class="shareBut"
              v-if="comDet.stat==2"
              size="mini"
              @click="comDet.stat=0;"
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
              @click="replayStat = !replayStat;replayCom(comDet.id)"
            >
              <i class="el-icon-s-comment" />
              <span>回复</span>
            </el-button>
            <el-button type="text" size="mini" class="shareBut">
              <i class="el-icon-warning" />
              <span>举报</span>
            </el-button>
            <el-button type="text" size="mini" class="shareBut" v-if="comDet.del">
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
            <el-button slot="append">发送</el-button>
          </el-input>
        </div>
        <div style="margin-top: -15px;" v-if="replayStat">
          <el-input placeholder="请输入评论" v-model="input" autocomplete="off">
            <template slot="prepend">回复 {{replaycom}}</template>
            <el-button slot="append">发送</el-button>
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
      <!-- <div class="creaColl-body" v-for="(creaCollection,index) in creaCollections" :key="index">
        <span class="creaCollName">{{creaCollection.favoriteName}}</span>
      <el-button class="creaCollBut" v-if="!creaCollBut" @click="creaCollBut=!creaCollBut">收藏</el-button>-->
      <!-- <el-button class="creaCollBut2" v-if="creaCollBut" @click="creaCollBut=!creaCollBut">已收藏</el-button>
      </div>-->
    </el-dialog>
  </div>
</template>

<script>
// import CommentItem from './Comment'
import { reqMyFavorite, reqCollect } from "../../api/favorite";
import { reqGetArticleCom } from "../../api/topicArticle";
import { reqCheckOpp,reqLike,reqUnLike } from "../../api/follow";
import dataUtil from "../../util/dataUtil";
export default {
  name: "AnswerItem",
  components: {
    // CommentItem
  },
  props: {
    // 从topicDet取数据
    // attiStat: Number,
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
      //获取当前页面用户名、用户id、回复输入框、选择器当前值、点赞状态
      username: "",
      userId: this.$store.state.user.userId,
      input: "",
      v: "",
      attiStat: "",
      likeNum: this.apprN
    };
  },
  mounted() {
    this._loadData();
    this.username = this.$store.state.user.name;
  },
  methods: {
    _loadData() {
      // console.info(this.userId);
      let params = "articleId=" + this.articleId;
      let userParams = "userId=" + this.userId;
      let userArtiParams ={
        userId: this.userId,
        contentId: this.topicId,
        type: 4
      }
      console.info(this.articleId);
      //获取文章评价
      reqGetArticleCom(params).then(res => {
        if (res.resultCode === 200) {
          // console.info(res.data);
          res.data.forEach(element => {
            element.stat = 0;
          });
          //赋值回复了谁
          res.data.forEach(element => {
            if (element.name == this.username) element.del = true;
            else element.del = false;
            // console.info(element.del);
            if (element.is_reply != 0) {
              res.data.forEach(element2 => {
                if (element.is_reply === element2.id)
                  element.replayname = element2.name;
                // console.info(element.replayname);
              });
            }
          });
          this.comDets = res.data;
          // console.info(this.comDets);
        }
      });
      //获取我的收藏夹
      reqMyFavorite(userParams).then(res => {
        if (res.resultCode == 200) {
          this.creaCollections = res.data;
          // console.info(this.creaCollections);
        }
      });
      //获取点赞状态
      reqCheckOpp(userArtiParams).then(res =>{
        if(res.resultCode == 200){
          console.info(res.data)
          this.attiStat = res.data
        }
      })
    },
    handleClick() {},
    //根据id获取用户名
    replayCom(id) {
      this.comDets.forEach(element => {
        // console.info(element);
        if (element.id === id) this.replaycom = element.name;
        // console.info(this.replaycom);
      });
    },
    apprNadd() {
      this.apprN++;
    },
    apprNsub() {
      this.apprN--;
    },
    praNadd(comDet) {
      comDet.praise_num++;
    },
    praNsub(comDet) {
      comDet.praise_num--;
    },
    toQueDetail() {
      // 跳转到问题主页
      if (this.type == 1)
        this.$router.push({ path: "/home/question/" + this.queId });
    },
    //收藏弹窗
    collArt(v) {
      let params = {
        articleId: this.articleId,
        favoritesId: v
      };
      // console.info(params);
      reqCollect(params).then(res => {
        if (res.resultCode == 200) {
          this.$message("收藏成功");
        } else this.$message("收藏失败");
      });
    },
    //点赞
    like(){
      let params = {
        userId: this.userId,
        contentId: this.articleId,
        type: 4
      }
      reqLike(params).then(res =>{
        // console.info(res)
        if(res.resultCode == 200){
          // console.info(this.likeNum)
          this.likeNum ++
          // console.info(this.likeNum)
        }
      })
    },
    //取消态度
    unlike(){
      let params = {
        userId: this.userId,
        contentId: this.articleId,
        type: 4
      }
      reqUnLike(params).then(res =>{
        if(res.resultCode == 200){
          this.likeNum --
        }
      })
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
}
</style>
