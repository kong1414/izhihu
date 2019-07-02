<template>
  <el-container class="people-container">
    <el-header class="people-header">
      <el-card :body-style="{ padding: '0px' }"
               class="header-card">
        <img src="../../assets/img/people-bg.jpg"
             alt="背景图"
             width="1100px">
        <div class="content">
          <el-image class="avatar"
                    :src="userInfo.photo_url">
          </el-image>
          <div class="introduce">
            <span class="name">{{userInfo.name}}</span>
            <span class="autograph">{{userInfo.autograph}}</span>
            <el-form label-width="80px"
                     size="mini"
                     class="userinfo">
              <el-form-item label="性别">
                <span v-if="userInfo.gender===0">未知</span>
                <span v-else-if="userInfo.gender===1">男</span>
                <span v-else-if="userInfo.gender===2">女</span>
              </el-form-item>
              <!-- <el-form-item label="个性签名">
                {{userInfo.autograph}}
              </el-form-item> -->
              <!-- <el-form-item label="个人简介">
                {{userInfo.introduce}}
              </el-form-item> -->
              <el-form-item label="个人简介">
                <el-button type="text"> 点击查看个人简介</el-button>
              </el-form-item>
              <el-form-item label="行业">
                {{userInfo.industry}}
              </el-form-item>
              <el-form-item label="个性网址">
                {{userInfo.personality_url}}
              </el-form-item>
              <el-form-item label="公司">
                {{userInfo.company}}
              </el-form-item>
              <el-form-item label="职位">
                {{userInfo.position}}
              </el-form-item>
              <el-form-item label="学校">
                {{userInfo.school}}
              </el-form-item>
              <el-form-item label="行业">
                {{userInfo.major}}
              </el-form-item>

            </el-form>
          </div>
          <div class="operation">

            <el-button v-if="this.userId===this.$store.state.user.userId"
                       size="medium"
                       type="primary"
                       @click="userInfodialogVisible = true">
              编辑资料
            </el-button>
            <el-button v-else
                       size="medium"
                       icon="el-icon-plus"
                       type="primary">关注</el-button>
            <el-button size="medium"
                       icon="el-icon-chat-round">发私信</el-button>
          </div>
        </div>

      </el-card>
    </el-header>
    <el-container class="people-content">
      <el-main class="people-main">
        <el-tabs v-model="activeName"
                 @tab-click="handleClick">
          <el-tab-pane label="动态"
                       name="dynamic">
            <recommend-item title="5G的到来会造成编程语言大灭绝进而JS一统应用前端吗?"
                            content="5G的到来会造成编程语言大灭绝进而JS一统应用前端吗?"
                            articleId="123123"
                            quesId="123123"
                            type=1
                            heatNum=123 />
          </el-tab-pane>
          <el-tab-pane label="回答"
                       name="answer">
            关注
          </el-tab-pane>
          <el-tab-pane label="提问"
                       name="question">
            关注
          </el-tab-pane>
          <el-tab-pane label="文章"
                       name="article">
            关注
          </el-tab-pane>
          <el-tab-pane label="专栏"
                       name="column">
            关注
          </el-tab-pane>
          <el-tab-pane label="想法"
                       name="idea">
            关注
          </el-tab-pane>
          <el-tab-pane label="收藏"
                       name="favorite">
            关注
          </el-tab-pane>
          <el-tab-pane label="关注"
                       name="att">
            关注
          </el-tab-pane>
        </el-tabs>
      </el-main>
      <el-aside class="people-aside">
        aside
        <aside-footer></aside-footer>
      </el-aside>
    </el-container>
    
    
    <el-dialog title="编辑个人资料"
               :visible.sync="userInfodialogVisible"
               width="600px"
               :before-close="handleClose">
      <el-form label-width="80px"
               size="medium"
               class="update">
        <el-form-item label="姓名">
          <el-input v-model="userInfo.name"></el-input>
        </el-form-item>

        <el-form-item label="性别">
          <el-input v-model="userInfo.gender"></el-input>
        </el-form-item>

        <el-input v-model="userInfo.name"></el-input>
        <el-input v-model="userInfo.name"></el-input>
        <el-input v-model="userInfo.name"></el-input>
      </el-form>

      <span slot="footer"
            class="dialog-footer">
        <el-button @click="userInfodialogVisible = false">取 消</el-button>
        <el-button type="primary"
                   @click="handleUpdate">更 新</el-button>
      </span>
    </el-dialog>
  </el-container>
</template>

<script>
import { reqUserInfo } from '../../api/home'
import AsideFooter from '../../components/aside/AsideFooter'

export default {
  name: 'people',
  components: {
    AsideFooter
  },
  data () {
    return {
      activeName: 'dynamic',
      userId: this.$route.params.userid,
      avatarPhotoUrl: 'http://img3.imgtn.bdimg.com/it/u=4259300811,497831842&fm=26&gp=0.jpg',
      userInfo: {
        name: '',
        photo_url: '',
        gender: '', // 性别0未知1男2女
        autograph: '', // 个性签名
        introduce: '', // 简介
        industry: '', // 行业
        personality_url: '', // 个性网址
        company: '', // 公司
        position: '', // 职位
        school: '', // 学校
        major: ''// 行业
      },
      userInfodialogVisible: false
    }
  },
  created () {
    console.info('userid')
    this._loadData(this.userId)
  },
  methods: {
    _loadData (userId) {
      let params = 'userId=' + userId
      reqUserInfo(params).then(res => {
        if (res.resultCode === 200) {
          console.info(res.data)
          this.userInfo = res.data
        }
      })
    },
    handleUpdate () { // 更新个人信息
      // 发送请求
      this.userInfodialogVisible = false
    },
    handleClose () { // 关闭弹窗
      this.userInfodialogVisible = false
    },
    handleClick () { // 下面的tabs

    }
  }
}
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
    }
    .people-aside {
    }
  }
  .update {

  }
}
</style>
