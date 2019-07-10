<template>
  <!-- 首页右侧写回答写文章写想法 -->
  <div class="aside-write">
    <el-card class="write-card">
      <el-row>
        <el-col :span="8">
          <el-button type="text"
                     class="write-button">
            <i class="el-icon-s-order" />
            <p>写回答</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text"
                     @click="toWriteArticle"
                     class="write-button">
            <i class="el-icon-edit-outline" />
            <p>写文章</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text"
                     @click="writerDialogVisible = true"
                     class="write-button">
            <i class="el-icon-paperclip" />
            <p>写想法</p>
          </el-button>
        </el-col>
      </el-row>
      <el-divider></el-divider>
      <div class="list">
        <div>
          <el-button type="text">
            <i class="el-icon-time" />
            <span>我的稍后答</span>
          </el-button>
        </div>
        <div>
          <el-button type="text">
            <i class="el-icon-files" />
            <span>我的草稿</span>
          </el-button>
        </div>
      </div>
    </el-card>
    <el-dialog title="写想法"
               :visible.sync="writerDialogVisible"
               width="540px"
               center>
      <div class="ideaContent">
        <el-input class="inputIdea"
                  type="textarea"
                  :autosize="{ minRows: 10, maxRows: 10}"
                  placeholder="请输入内容"
                  v-model="textarea">
        </el-input>
      </div>
      <span slot="footer"
            class="dialog-footer">
        <el-button @click="emptyWriteIdea">取 消</el-button>
        <el-button type="primary"
                   @click="writeIdea">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { reqCreateArticle } from '../../api/article'
import { reqTopicCreate } from '../../api/topic'
export default {
  name: 'asideWrite',
  data () {
    return {
      writerDialogVisible: false,
      textarea: '',
    }
  },
  methods: {
    toWriteArticle () { // 跳转写文章页面
      this.$router.push({ path: '/home/editarticle' });
    },
    emptyWriteIdea () { // 取消
      this.textarea = '';
      this.writerDialogVisible = false;
    },
    writeIdea () {  // 确定发送
      let Aparams = {
        userId: this.$store.state.user.userId,
        type: 3,
        anonymity: 0,
        title: '想法',
        content: this.textarea,
        topicList: []
      }

      reqCreateArticle(Aparams).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            message: '发布成功',
            type: 'success'
          })
          this.emptyWriteIdea()
        }
      })
    }
  }
}
</script>

<style lang="scss">
.aside-write {
  margin-top: 20px;
  .write-card {
    text-align: center;
    .el-card__body {
      padding: 15px;
    }
    .write-button {
      text-align: center;
      i {
        margin: 6px;
        font-size: 30px;
      }
    }
    .el-divider {
      margin: 5px 0;
    }
    .list {
      margin-left: 10px;
      text-align: left;
      span {
        color: #76839b;
      }
    }
  }
  .ideaContent {
    .inputIdea {
      font-size: 16px;
      padding: 20px 20px 0px 20px;
    }
  }
}
</style>
