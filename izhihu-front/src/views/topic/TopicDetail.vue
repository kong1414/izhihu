<template>
  <!-- 话题详情页-->
  <el-container class="topicDetail-container">
    <el-main class="topDet">
      <el-card>
        <el-image class="topImag" :src="topDet.photoUrl"></el-image>
        <div class="firCard">
          <div class="firCardName">
            <span>{{topDet.topicName}}</span>
          </div>
          <div class="firCardDet" @click="dialogVisible = true">
            <span>{{topDet.topicDesc}}</span>
          </div>
        </div>
        <el-button
          type="primary"
          class="subsBut"
          v-if="!topicFollow"
          @click="topicFollow=!topicFollow;topinfollow()"
        >
          <span>关注话题</span>
        </el-button>
        <el-button
          type="info"
          class="subsBut2"
          v-if="topicFollow"
          @click="topicFollow=!topicFollow;topunfollow()"
        >取消关注</el-button>
        <el-button type="text" class="shareBut">
          <i class="el-icon-s-promotion" />
          <span>分享</span>
        </el-button>
      </el-card>
      <el-card class="secCard">
        <div slot="header" class="clearfix">
          <span class="dis">讨论</span>
          <el-button class="moreCon" type="text">更多内容</el-button>
        </div>
        <div v-if="disDets.length<=0">暂无数据</div>
        <div v-else>
          <div v-for="disDet in disDets" :key="disDet.topicId" class="text item">
            <!-- 给answerItem传值   :topicid="topicId"-->
            <!-- {{disDets}} -->
            <answer-item
              :apprN="disDet.report_num"
              :evalN="disDet.comment_num"
              :queName="disDet.title"
              :author="disDet.name"
              :queDet="disDet.content"
              :articleId="disDet.article_id"
              :queId="disDet.ques_id"
              :type="disDet.type"
              :authorId="disDet.author_id"
              :photoUrl="disDet.photo_url"
            />
          </div>
        </div>
      </el-card>
    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <aside-Subs :topicId="topicId" :quenum="queNumber"></aside-Subs>
      <aside-Footer></aside-Footer>
    </el-aside>
    <el-dialog :title="topDet.topicName" :visible.sync="dialogVisible" width="600px">
      <div class="dialog-body">
        <span>{{topDet.topicDesc}}</span>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">关 闭</el-button>
      </span>
    </el-dialog>
  </el-container>
</template>
<script>
import AsideFooter from "../../components/aside/AsideFooter";
import AsideSubs from "../../components/aside/AsideSubs";
import AnswerItem from "../../components/index/AnswerItem";
import { reqGetTopicArticle } from "../../api/topicArticle";
import { reqGetTopicDet } from "../../api/topicArticle";

import { reqCheckFollow, reqInFollow, reqUnFollow } from "../../api/follow";
export default {
  name: "topicDetail",
  components: {
    AsideSubs,
    AnswerItem,
    AsideFooter
  },
  data() {
    return {
      userId: this.$store.state.user.userId,
      topicId: this.$route.params.topicid,
      //话题图标地址、话题详情、暂无数据可视、话题问题数
      url: "",
      topDet: "",
      disDetCon: "",
      queNumber: 0,
      //话题详细内容弹窗、用户话题关注情况、问题详细内容
      dialogVisible: false,
      topicFollow: false,
      disDets: []
    };
  },
  mounted() {
    this._loadData()
  },
  methods: {
    _loadData() {
      let params = "topicId=" + this.topicId;
      let followparams = {
        additionalProp1: this.userId,
        additionalProp2: this.topicId
      }
      //检查关注状态
      reqCheckFollow(followparams).then(res => {
        if (res.resultCode === 200) {
          this.topicFollow = res.data
        }
      });
      //获取话题简介详情
      reqGetTopicDet(params).then(res => {
        if (res.resultCode === 200) {
          this.topDet = res.data
        }
      });
      //获取话题下文章、问题详情
      reqGetTopicArticle(params).then(res => {
        if (res.resultCode === 200) {
          this.disDets = res.data;
          this.queNumber = res.data.length
          // this.disDetCon = false;
          // this.queNumber = 0;
          // this.disDets.forEach(element => {
          //   // 给答案数据创一些新的值(点赞状态、评论数、点赞数)
          //   if (element.ques_name != null) this.disDetCon = true;
          //   this.queNumber++;
          // });
        }
      })
    },
    //取关话题
    topunfollow() {
      let followparams = {
        userId: this.userId,
        contentId: this.topicId,
        type: 5
      };
      reqUnFollow(followparams).then(res => {
        if (res.resultCode == 200) {
          this.$message("取关成功");
        } else this.$message("取关失败");
      });
    },
    //关注话题
    topinfollow() {
      let followparams = {
        userId: this.userId,
        contentId: this.topicId,
        type: 5
      };
      reqInFollow(followparams).then(res => {
        if (res.resultCode == 200) {
          this.$message("关注成功");
        } else this.$message("关注失败");
      });
    }
  }
};
</script>
<style lang="scss">
.topicDetail-container {
  .topDet {
    .secCard {
      margin-top: 20px;
      .moreCon {
        float: right;
        padding: 3px 0px;
      }
    }
    .topImag {
      width: 100px;
      height: 100px;
      float: left;
    }
    .dis {
      font-weight: bold;
      font-size: 20px;
    }
    .firCard {
      width: 580px;
      height: 100px;
      float: left;
      margin-left: 30px;
    }
    .firCardName {
      font-weight: bold;
      font-size: 25px;
      height: 30px;
    }
    .firCardDet {
      margin-top: 10px;
      font-size: 15px;
      color: #646464;
      height: 50px;
      line-height: 1.6;
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 2; //行数
      -webkit-box-orient: vertical;
    }
    .subsBut {
      margin-top: 30px;
      width: 100px;
      height: 40px;
      background: #0084ff;
    }
    .subsBut2 {
      margin-top: 30px;
      width: 100px;
      height: 40px;
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
      -webkit-box-orient: vertical;
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
  }

  .dialog-body {
    padding: 22px;
    margin-top: -5px;
    font-size: 15px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both;
  }
}
</style>
