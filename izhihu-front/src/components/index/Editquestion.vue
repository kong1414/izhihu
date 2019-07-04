<template>
  <div class="editIndex">
    <div class="head">   
        <el-button class="returnIndex" @click="returntoIndex" type="text">
            <i class="el-icon-back"></i>
            <span>返回</span>
        </el-button>
        <dir class="rightArea">
            <span class="noname">匿名发布</span>
        <el-radio v-model="radio" label="1">否</el-radio>
        <el-radio v-model="radio" label="2">是</el-radio>
        </dir>
    </div>
    <div class="body">
      <el-input
        class="titlearea"
        resize="none"
        type="textarea"
        :autosize="{ minRows: 1, maxRows: 2}"
        placeholder="请输入标题"
        v-model="texttitle"
        maxlength="50"
        show-word-limit>
      </el-input>
      <div class="content">
        <quill-editor
          v-model="content" 
          ref="myTextEditor" 
          :options="editorOption" 
          @blur="onEditorBlur($event)"
          @focus="onEditorFocus($event)"
          @change="onEditorChange($event)">
        </quill-editor>
      </div>
    </div>
    <div class="footer">
      <el-button class="push">发布</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'editquestion',
  data () {
    return {
      texttitle : '',
      radio: '1',
      content:'<h2>I am Example</h2>',
      editorOption:{}
    }
  },
  methods: {
    returntoIndex(){//返回首页
        this.$router.push({ path:'/home/index'  });
    },
    onEditorBlur(){//失去焦点事件
    },
    onEditorFocus(){//获得焦点事件
    },
    onEditorChange(){//内容改变事件
    }

  }
}
</script>

<style lang="scss">
.editIndex{
  margin: 2px auto 0;
  width: 660px;
  .head{
    .rightArea{
        float: right;
        .noname{
            margin-right: 20px;
        }
    }
    .returnIndex{
        float: left;
        margin-top: 8px;
    }
  }
  .body{
    margin-top: 5px;
    .titlearea{
      margin-top: 5px;
      margin-bottom: 5px;
      font-size: 40px;
    }
    .quill-editor{
      .ql-container {
         min-height: 300px;
      }
     
    }
  }
  .footer{
    margin-top: 20px;
  }
}
</style>
