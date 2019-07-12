<template>
  <el-container class="people-container">
    <el-header class="people-header">
      <el-card :body-style="{ padding: '0px' }" class="header-card">
        <img src="../../assets/img/people-bg.jpg" alt="背景图" width="1100px" />
        <div class="content">
          <!-- <el-image class="avatar"
                    :src="userInfo.photo_url">
          </el-image>-->
          <img :src="userInfo.photo_url" class="avatar" />
          <div class="introduce">
            <span class="name">{{userInfo.name}}</span>
            <span class="autograph">{{userInfo.autograph}}</span>
            <el-form label-width="80px" size="mini" class="userinfo">
              <el-form-item label="性别">
                <span v-if="userInfo.gender==0">未知</span>
                <span v-else-if="userInfo.gender==1">男</span>
                <span v-else-if="userInfo.gender==2">女</span>
              </el-form-item>
              <el-form-item label="个人简介">
                <el-button type="text">点击查看个人简介</el-button>
              </el-form-item>
              <el-form-item label="行业">{{userInfo.industry}}</el-form-item>
              <el-form-item label="个性网址">{{userInfo.personality_url}}</el-form-item>
              <el-form-item label="公司">{{userInfo.company}}</el-form-item>
              <el-form-item label="职位">{{userInfo.position}}</el-form-item>
              <el-form-item label="学校">{{userInfo.school}}</el-form-item>
              <el-form-item label="专业">{{userInfo.major}}</el-form-item>
            </el-form>
          </div>
          <div class="operation">
            <el-button
              v-if="this.currentUserId===this.$store.state.user.userId"
              size="medium"
              type="primary"
              @click="userInfodialogVisible = true"
            >编辑资料</el-button>
            <span v-else style="margin-right: 10px">
              <el-button
                v-if="!attType"
                size="medium"
                icon="el-icon-plus"
                type="primary"
                @click="attPeople"
              >关注</el-button>
              <el-button v-else size="medium" type="primary" @click="unAttPeople">已关注</el-button>
            </span>

            <!-- <el-button size="medium"
            icon="el-icon-chat-round" @click="showMessageVisible = true">发私信</el-button>-->
          </div>
        </div>
      </el-card>
    </el-header>
    <el-container class="people-content">
      <el-main class="people-main">
        <el-card>
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <!-- <el-tab-pane label="动态"
                         name="dynamic">
              动态1
            </el-tab-pane>-->
            <el-tab-pane label="回答" name="answer">
              <div v-if="articleList.length <= 0">暂无回答</div>
              <div v-else>
                <!-- {{articleList}} -->
                <div v-for="(item, index) in articleList" :key="index">
                  <!-- {{item}} -->
                  <answer-item
                    :apprN="item.report_num"
                    :evalN="item.comment_num"
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
              </div>
            </el-tab-pane>
            <el-tab-pane label="提问" name="question">
              <div v-if="quesList.length <= 0">暂无提问</div>
              <div v-else>
                <!-- {{quesList}} -->
                <div class="recommend" v-for="(i,index) in quesList" :key="index" >
                  <el-button class="title" type="text" @click="toQueDet(i.quesId)"><span><b>{{i.quesName}}</b></span></el-button>
                  <div class="message">
                    <span>回答人数：{{i.answerNum}}      浏览人数：{{i.browseNum}}   更新时间：{{i.updateTime}}</span>
                  </div>
                  <div class="hl-line"></div>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="文章" name="article">
              <div v-if="articleList.length <= 0">暂无文章</div>
              <div v-else>
                <!-- {{articleList}} -->
                <div v-for="(item, index) in articleList" :key="index">
                  <!-- {{item}} -->
                  <answer-item
                    :apprN="item.report_num"
                    :evalN="item.comment_num"
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
              </div>
            </el-tab-pane>
            <el-tab-pane label="想法" name="idea">
              <div v-if="articleList.length <= 0">暂无想法</div>
              <div v-else>
                <!-- {{articleList}} -->
                <div v-for="(item, index) in articleList" :key="index">
                  <!-- {{item}} -->
                  <answer-item
                    :apprN="item.report_num"
                    :evalN="item.comment_num"
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
              </div>
            </el-tab-pane>
            <el-tab-pane label="收藏夹" name="favorite">
              <div v-if="faveList.length <= 0">暂无收藏夹</div>
              <div v-else>
                <!-- {{faveList}} -->
                <div class="recommend" v-for="(i,index) in faveList" :key="index" >
                  <el-button class="title" type="text" @click="toFavorite"><span><b>{{i.favorite.favoriteName}}</b></span></el-button>
                  <div class="message">
                    <span>{{i.contentNum}}  条内容   {{i.attNum}} 人关注   更新时间：{{i.favorite.createTime}}</span>
                  </div>
                  <div class="hl-line"></div>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="关注的话题" name="attTopic">
              <div v-if="topicList.length <= 0">暂未关注</div>
              <div v-else>
                <div v-for="(item, index) in topicList" :key="index" class="topName">
                  <el-avatar shape="square" :size="40" :src="item.photoUrl"></el-avatar>
                  <el-button type="text">
                    <span @click="toTopicDet(item.topicId)">{{item.topicName}}</span>
                  </el-button>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="关注的问题" name="attQues">
              <div v-if="attQuesList.length <= 0">暂未关注</div>
              <div v-else>
                <!-- {{attQuesList}} -->
                <div class="recommend" v-for="(i,index) in attQuesList" :key="index" >
                  <el-button class="title" type="text" @click="toQueDet(i.quesId)"><span><b>{{i.quesName}}</b></span></el-button>
                  <div class="message">
                    <span>回答人数：{{i.answerNum}}      浏览人数：{{i.browseNum}}   更新时间：{{i.updateTime}}</span>
                  </div>
                  <div class="hl-line"></div>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="关注的用户" name="attPeople">
              <div v-if="attUserList.length <= 0">暂未关注</div>
              <div v-else>
                <!-- {{attUserList}} -->
                <div class="recommend" v-for="(i,index) in attUserList" :key="index" >
                  <el-button class="title" type="text" @click="toUser(i.user_id)"><span><b>{{i.name}}</b></span></el-button>
                  <div class="message">
                    <span>个人简介：{{i.introduce}}       位置：{{i.position}}    公司：{{i.company}}</span>
                  </div>
                  <div class="hl-line"></div>
                </div>
              </div>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-main>
      <el-aside class="people-aside">
        <el-card style="text-align: center;margin-top:20px">
          <el-row>
            <el-col :span="12">
              关注了
              <div>{{attNum}}</div>
            </el-col>
            <el-col :span="12">
              关注者
              <div>{{attedNum}}</div>
            </el-col>
          </el-row>
        </el-card>
        <aside-footer></aside-footer>
      </el-aside>
    </el-container>

    <el-dialog
      title="编辑个人资料"
      :visible.sync="userInfodialogVisible"
      width="600px"
      custom-class="updata-dialog"
      :before-close="handleClose"
    >
      <el-form label-width="80px" size="medium" class="update">
        <el-upload
          class="avatar-uploader"
          action="http://120.78.136.84:8090/api/user/uploadImage"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
        >
          <img v-if="imageUrl" :src="imageUrl" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-form-item label="姓名">
          <el-input v-model="userInfo.name"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <!-- <el-input v-model="userInfo.gender"></el-input> -->
          <el-select v-model="userInfo.gender" placeholder="请选择">
            <el-option label="未知" value="0"></el-option>
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="个性签名">
          <el-input v-model="userInfo.autograph"></el-input>
        </el-form-item>
        <el-form-item label="个人简介">
          <el-input v-model="userInfo.introduce"></el-input>
        </el-form-item>
        <el-form-item label="个性网址">
          <el-input v-model="userInfo.personality_url"></el-input>
        </el-form-item>
        <el-form-item label="行业">
          <el-input v-model="userInfo.industry"></el-input>
        </el-form-item>
        <el-form-item label="公司">
          <el-input v-model="userInfo.company"></el-input>
        </el-form-item>
        <el-form-item label="职位">
          <el-input v-model="userInfo.position"></el-input>
        </el-form-item>
        <el-form-item label="学校">
          <el-input v-model="userInfo.school"></el-input>
        </el-form-item>
        <el-form-item label="专业">
          <el-input v-model="userInfo.major"></el-input>
        </el-form-item>
      </el-form>

      <span slot="footer" class="dialog-footer">
        <el-button @click="userInfodialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleUpdate">更 新</el-button>
      </span>
    </el-dialog>
  </el-container>
</template>

<script>
import { reqUserInfo, reqUpdateUserInfo } from "../../api/home";
import { reqGetArticleByUser } from "../../api/article";
import { reqMyFavDetail } from "../../api/favorite";
import { reqFindQuesByUser } from "../../api/question";
import { reqAttedTopic } from "../../api/topic";
import {
  reqCountAtted,
  reqGetAttByUser,
  reqInFollow,
  reqUnFollow,
  reqCheckFollow
} from "../../api/follow";
import AsideFooter from "../../components/aside/AsideFooter";
import recommendItem from "../../components/index/RecommendItem";
import AnswerItem from "../../components/index/AnswerItem";
import dataUtil from "../../util/dataUtil";

export default {
  name: "people",
  components: {
    AsideFooter,
    recommendItem,
    AnswerItem
  },
  data() {
    return {
      activeName: "answer",
      userId: this.$store.state.user.userId, // 登录账号的id
      currentUserId: this.$route.params.userid, // 当前页面的id
      userInfo: {
        name: "",
        photo_url: "",
        gender: "", // 性别0未知1男2女
        autograph: "", // 个性签名
        introduce: "", // 简介
        industry: "", // 行业
        personality_url: "", // 个性网址
        company: "", // 公司
        position: "", // 职位
        school: "", // 学校
        major: "" // 行业
      },
      userInfodialogVisible: false,
      imageUrl: "",
      type: "", // 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
      articleList: [], //文章相关的 回答文章想法
      quesList: [], // 问题
      topicList: [], // 话题
      attUserList: [], // 用户
      attQuesList: [], // 关注的问题
      faveList: [], // 收藏夹
      attType: false, // 对该用户关注状态
      attNum: 0, // 关注了的人数
      attedNum: 0 // 被关注的人数
    };
  },
  mounted() {
    // console.info('userid')
    this._loadData(this.currentUserId);
  },
  methods: {
    _loadData(userId) {
      let params = "userId=" + userId;
      reqUserInfo(params).then(res => {
        if (res.resultCode === 200) {
          console.info(res.data);
          this.userInfo = res.data;
          this.userInfo.gender = String(res.data.gender);
          this.imageUrl = res.data.photo_url;
        }
      });
      let params2 = {
        userId: this.userId,
        contentId: this.currentUserId
      };
      reqCheckFollow(params2).then(res => {
        if (res.resultCode === 200) {
          this.attType = res.data;
          console.info(res.data);
        }
      });
      // 首选项卡 渲染
      this.handleClick({ name: this.activeName });

      // 关注了的人数
      let params3 = {
        userId: this.currentUserId,
        type: 6
      };
      reqGetAttByUser(params3).then(res => {
        if (res.resultCode == 200) {
          this.attNum = res.data.length;
        }
      });
      // 被关注的人数
      // let params4 = {
      //   userId: this.currentUserId,
      //   test: "1", // 占位置的 没用
      // }
      let params4 = "userId=" + this.currentUserId;
      reqCountAtted(params).then(res => {
        if (res.resultCode == 200) {
          this.attedNum = res.data;
        }
      });
    },
    handleUpdate() {
      // 更新个人信息
      let params = {
        userId: this.userId,
        name: this.userInfo.name,
        photoUrl: this.imageUrl,
        gender: Number(this.userInfo.gender),
        autograph: this.userInfo.autograph,
        introduce: this.userInfo.introduce,
        industry: this.userInfo.industry,
        personalityUrl: this.userInfo.personality_url,
        company: this.userInfo.company,
        position: this.userInfo.position,
        school: this.userInfo.school,
        major: this.userInfo.major
      };
      reqUpdateUserInfo(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: "success",
            message: res.resultMessage
          });
          this._loadData(this.userId);
          this.userInfodialogVisible = false;
        }
      });

      // 发送请求
      this.userInfodialogVisible = false;
    },
    handleClose() {
      // 关闭弹窗
      this.userInfodialogVisible = false;
    },
    handleClick(v) {
      // 下面的tabs
      console.info(v.name);
      if (v.name === "dynamic") {
        // 动态
        // this.articleList = v.name
      } else if (v.name === "answer") {
        // 回答
        let params = {
          userId: this.currentUserId,
          type: 1
        };
        reqGetArticleByUser(params).then(res => {
          if (res.resultCode == 200) {
            this.articleList = res.data;
          }
        });
      } else if (v.name === "question") {
        // 提问

        let params = "userId=" + this.currentUserId;

        reqFindQuesByUser(params).then(res => {
          if (res.resultCode == 200) {
            res.data.forEach(element => {
              element.updateTime = dataUtil.getStrData(element.updateTime)
            });

            this.quesList = res.data;
          }
        });
      } else if (v.name === "article") {
        // 文章
        let params = {
          userId: this.currentUserId,
          type: 2
        };
        reqGetArticleByUser(params).then(res => {
          if (res.resultCode == 200) {
            this.articleList = res.data;
          }
        });
      } else if (v.name === "idea") {
        // 想法
        let params = {
          userId: this.currentUserId,
          type: 3
        };
        reqGetArticleByUser(params).then(res => {
          if (res.resultCode == 200) {
            this.articleList = res.data;
          }
        });
      } else if (v.name === "favorite") {
        // 收藏夹
        let params = "userId=" + this.currentUserId;
        reqMyFavDetail(params).then(res => {
          if (res.resultCode == 200) {
            res.data.forEach(element => {
              element.favorite.createTime = dataUtil.getStrData(element.favorite.createTime)
            });
            this.faveList = res.data;
          }
        });
      } else if (v.name === "attTopic") {
        // 关注话题
        let params = "userId=" + this.currentUserId;
        reqAttedTopic(params).then(res => {
          if (res.resultCode == 200) {
            this.topicList = res.data;
          }
        });
      } else if (v.name === "attQues") {
        // 关注的问题
        let params = {
          userId: this.currentUserId,
          type: 4
        };
        reqGetAttByUser(params).then(res => {
          if (res.resultCode == 200) {
            res.data.forEach(element => {
              element.updateTime = dataUtil.getStrData(element.updateTime)
            });
            this.attQuesList = res.data;
          }
        });
      } else if (v.name === "attPeople") {
        // 关注的人
        let params = {
          userId: this.currentUserId,
          type: 6
        };
        reqGetAttByUser(params).then(res => {
          if (res.resultCode == 200) {
            this.attUserList = res.data;
          }
        });
      }
    },
    handleAvatarSuccess(res, file) {
      // 上传图片回调
      // console.info('res', res)
      // console.info('file', file)
      // this.imageUrl = URL.createObjectURL(file.raw)
      this.imageUrl = res.data;
    },
    beforeAvatarUpload(file) {
      // 上传图片前
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;
// const isJPG = true
      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isJPG && isLt2M;
    },
    attPeople() {
      // 关注该用户
      let params = {
        userId: this.userId,
        contentId: this.currentUserId,
        type: 6
      };
      reqInFollow(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: "success",
            message: res.resultMessage
          });
          this.attType = true;
        }
      });
    },
    unAttPeople() {
      // 取消关注该用户
      let params = {
        userId: this.userId,
        contentId: this.currentUserId
      };
      reqUnFollow(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: "success",
            message: res.resultMessage
          });
          this.attType = false;
        }
      });
    },
    toFavorite() {
      //跳转favorite页面
      this.$router.push({ path: "/home/favorite" });
    },
    toTopicDet(topId) {
      //跳转话题详情页
      this.$router.push({ path: "/home/topicDetail/" + topId });
    },
    toQueDet(queId) {
      //跳转话题详情页
      this.$router.push({ path: "/home/question/" + queId });
    },
    toUser(userId) {
      //跳转话题详情页
      this.$router.push({ path: "/home/people/" + userId });
      this._loadData(userId);
    }
  }
};
</script>

<style lang="scss">
.people-container {
  .people-header {
    height: auto !important;
    padding: 0;
    // background-color: #F6F6F6;
    .header-card {
      // height: 440px;
      .content {
        min-height: 220px;
        .avatar {
          border-radius: 8px;
          display: inline-block;
          overflow: hidden;
          vertical-align: top;
          background-color: #fff;
          border: 4px solid #fff;
          width: 160px;
          height: 160px;
          position: relative;
          z-index: 1;
          top: -25px;
          margin-left: 20px;
          // float: left;
        }
        .introduce {
          margin-left: 10px;
          // float: left;
          display: inline-block;
          width: 650px;
          .name {
            height: 38px;
            font-size: 26px;
            font-weight: 600;
            display: inline-block;
            margin: 10px 10px 0;
          }
          .autograph {
            height: 26px;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 1; //行数
            -webkit-box-orient: vertical;
            margin-left: 12px;
            font-size: 18px;
            white-space: nowrap;
            width: 630px;
            display: block;
            margin: 5px 10px 5px 10px;
          }

          .userinfo {
            // display: flex;
            // justify-content: space-between;
            .el-form-item {
              margin-bottom: 0px;
              float: left;
              width: 320px;
              .el-form-item__content {
                overflow: hidden;
                text-overflow: ellipsis;
                display: -webkit-box;
                -webkit-line-clamp: 2; //行数
                -webkit-box-orient: vertical;
              }
            }
          }
        }
        .operation {
          display: inline-block;
          padding-left: 25px;
          position: relative;
          top: -30px;
          .el-button {
            margin-top: -40px;
          }
        }
      }
    }
  }
  .people-content {
    .people-main {
      padding-left: 0px;
      float: left;
      .topName {
        min-height: 50px;
        .el-avatar {
          margin-top: 5px;
        }
        span {
          float: left;
          font-size: 18px;
          font-weight: 600;
          line-height: 1.6;
          color: #1a1a1a;
          margin-left: 10px;
          // margin-top: 10px;
        }
        p {
          float: right;
          margin-top: 18px;
          margin-right: 10px;
        }
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
    .people-aside {
    }
  }
  .updata-dialog {
    padding: 20px;
    margin-top: 5vh !important;
    .avatar-uploader {
      text-align: center;
      margin-bottom: 15px;
    }
    .el-dialog__body {
      padding: 20px;
      .update {
      }
      .avatar-uploader {
        .el-upload {
          border: 1px dashed #d9d9d9;
          border-radius: 6px;
          cursor: pointer;
          position: relative;
          overflow: hidden;
        }
        .el-upload:hover {
          border-color: #409eff;
        }
      }
      .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
      }
      .avatar {
        width: 178px;
        height: 178px;
        display: block;
      }
    }
  }
}
</style>
