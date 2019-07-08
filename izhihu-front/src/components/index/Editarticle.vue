<template>
  <div class="editIndex">
    <el-card style="width:800px;"
             :body-style="{ padding: '0px 20px 20px' }">
      <div slot="header">
        写文章
      </div>
      <div class="head">
        <div class="leftArea">
          <el-button icon="el-icon-back"
                     @click="returntoIndex"
                     type="text">
            <span>返回</span>
          </el-button>
        </div>
        <div class="rightArea">
          <span class="noname">匿名发布</span>
          <el-radio v-model="radio"
                    label="0">否</el-radio>
          <el-radio v-model="radio"
                    label="1">是</el-radio>
        </div>

      </div>
      <div class="body">
        <el-input class="titlearea"
                  resize="none"
                  type="textarea"
                  :autosize="{ minRows: 1, maxRows: 2}"
                  placeholder="请输入标题"
                  v-model="texttitle"
                  maxlength="50"
                  show-word-limit>
        </el-input>
        <div class="content">
          <quill-editor v-model="content"
                        ref="myTextEditor"
                        :options="editorOption"
                        @blur="onEditorBlur($event)"
                        @focus="onEditorFocus($event)"
                        @change="onEditorChange($event)">
          </quill-editor>
        </div>
      </div>
      <div style="margin-top:20px;">
        话题：
        <el-select v-model="topicSelect"
                   multiple
                   filterable
                   default-first-option
                   remote
                   reserve-keyword
                   placeholder="请输入关键词"
                   :remote-method="remoteMethod"
                   :loading="loading">
          <el-option v-for="item in options"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
          </el-option>
        </el-select>
        <el-input style="width:100px;margin-left:10px;"
                  v-if="inputVisible"
                  v-model="inputValue"
                  ref="saveTagInput"
                  size="small"
                  @keyup.enter.native="handleInputConfirm"
                  @blur="handleInputConfirm">
        </el-input>
        <el-button v-else
                   style="margin-left:10px"
                   size="medium"
                   @click="showInput">+ New Tag</el-button>
      </div>
      <div class="footer">
        <el-button class="push"
                   type="primary"
                   @click="handleUp">发布</el-button>
      </div>
    </el-card>

  </div>
</template>

<script>
import { reqFindTopic } from '../../api/topic'
import { reqTopicCreate } from '../../api/topic'
import { reqCreateArticle } from '../../api/article'
export default {
  name: 'editarticle',
  data () {
    return {
      texttitle: '',
      radio: '0',
      content: 'I am Example',
      editorOption: {},
      topicSelect: [],
      options: [],
      loading: false,
      list: [],
      dynamicTags: [], //关联的话题
      inputVisible: false,
      inputValue: '',
    }
  },
  mounted () {
    this._loadSelectData()
  },
  methods: {
    _loadSelectData (keyword) {
      let params = 'keyword=' + keyword;
      console.info(params)
      reqFindTopic(params).then(res => {
        if (res.resultCode == 200) {
          console.info(res.data)
          let arr = []
          res.data.map(i => {
            let obj = {
              label: i.topicName,
              value: i.topicId
            }
            arr.push(obj)
          })
          this.options = arr
          this.loading = false
        }
      })
    },
    returntoIndex () { //返回首页
      this.$router.push({ path: '/home/index' });
    },
    remoteMethod (query) {
      if (query !== '') {
        this.loading = true;
        this._loadSelectData(query)
      } else {
        this.options = [];
      }
    },
    onEditorBlur () {//失去焦点事件
    },
    onEditorFocus () {//获得焦点事件
    },
    onEditorChange () {//内容改变事件
    },
    handleUp () {
      if (this.texttitle == '') {
        this.$message("标题不能为空")
        return
      }
      if (this.content == '') {
        this.$message("内容不能为空")
        return
      }

      // console.info()
      let params = {
        anonymity: Number(this.radio),
        content: this.content,
        title: this.texttitle,
        topicList: this.topicSelect,
        newTopicList: [],
        type: Number(2),
        userId: this.$store.state.user.userId,
      }
      console.info(params)
      reqCreateArticle(params).then(res => {
        if (res.resultCode == 200) {
          this.$message("发布成功")
          this.$router.go(-1)
        }
      })

    },
    handleInputConfirm () {
      let inputValue = this.inputValue;
      if (inputValue) {
        let paramscreate = {
          topicName: inputValue
        }
        reqTopicCreate(paramscreate).then(res => {
          if (res.resultCode == 200) {
            console.info(res.data)
            let obj = {
              label: inputValue,
              value: res.data
            }
            this.options.push(obj)
            this.topicSelect.push(res.data)
          }
        })
        console.info(this.topicSelect)
      }
      this.inputVisible = false;
      this.inputValue = '';
    },
    showInput () {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    }
  }
}
</script>

<style lang="scss">
.editIndex {
  margin: 2px auto 0;
  width: 660px;
  .head {
    .leftArea {
      float: left;
    }
    .rightArea {
      float: right;
      line-height: 40px;
    }
    .noname {
      margin-right: 20px;
    }
  }
  .body {
    // margin-top: 20px;
    .titlearea {
      margin-top: 5px;
      margin-bottom: 5px;
      font-size: 40px;
    }
    .quill-editor {
      .ql-container {
        min-height: 300px;
      }
    }
  }
  .footer {
    margin-top: 20px;
  }
}
</style>
