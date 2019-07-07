<template>
  <el-container class="people-container">
    <el-header class="people-header">
      <el-card :body-style="{ padding: '0px' }"
               class="header-card">
        <img src="../../assets/img/people-bg.jpg"
             alt="背景图"
             width="1100px">
        <div class="content">
          <!-- <el-image class="avatar"
                    :src="userInfo.photo_url">
          </el-image> -->
          <img :src="userInfo.photo_url" class="avatar" />
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
              <el-form-item label="专业">
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
        <el-card>
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
        </el-card>
        
      </el-main>
      <el-aside class="people-aside">
        aside
        <el-card>

        </el-card>
        <aside-footer></aside-footer>
      </el-aside>
    </el-container>

    <el-dialog title="编辑个人资料"
               :visible.sync="userInfodialogVisible"
               width="600px"
               custom-class="updata-dialog"
               :before-close="handleClose">
      <el-form label-width="80px"
               size="medium"
               class="update">
        <el-upload
          class="avatar-uploader"
          action="http://localhost:8090/api/user/uploadImage"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
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
import { reqUserInfo, reqUpdateUserInfo } from '../../api/home'
import AsideFooter from '../../components/aside/AsideFooter'
import recommendItem from '../../components/index/RecommendItem'
export default {
  name: 'people',
  components: {
    AsideFooter,
    recommendItem
  },
  data () {
    return {
      activeName: 'dynamic',
      userId: this.$route.params.userid,
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
      userInfodialogVisible: false,
      imageUrl: ''
    }
  },
  created () {
    // console.info('userid')
    this._loadData(this.userId)
  },
  methods: {
    _loadData (userId) {
      let params = 'userId=' + userId
      reqUserInfo(params).then(res => {
        if (res.resultCode === 200) {
          console.info(res.data)
          this.userInfo = res.data
          this.userInfo.gender = String(res.data.gender)
          this.imageUrl = res.data.photo_url
        }
      })
    },
    handleUpdate () { // 更新个人信息
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
        major: this.userInfo.major,
      }
      reqUpdateUserInfo(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type:'success',
            message: res.resultMessage
          })
          this._loadData(this.userId)
          this.userInfodialogVisible = false
        }
      })

      // 发送请求
      this.userInfodialogVisible = false
    },
    handleClose () { // 关闭弹窗
      this.userInfodialogVisible = false
    },
    handleClick () { // 下面的tabs

    },
    handleAvatarSuccess(res, file) {
      console.info('res', res)
      console.info('file', file)
      // this.imageUrl = URL.createObjectURL(file.raw)
      this.imageUrl = res.data
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
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
      padding-left: 0px;
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
          border-color: #409EFF;
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
