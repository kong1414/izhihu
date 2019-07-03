<template>
  <!-- 首页右侧写回答写文章写想法 -->
  <div class="aside-write">
    <el-card class="write-card">
      <el-row>
        <el-col :span="8">
          <el-button type="text" class="write-button">
            <i class="el-icon-s-order"/>
            <p>写回答</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text" class="write-button">
            <i class="el-icon-edit-outline"/>
            <p>写文章</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text" @click="writerDialogVisible = true" class="write-button">
            <i class="el-icon-paperclip"/>
            <p>写想法</p>
          </el-button>
        </el-col>
      </el-row>
      <el-divider></el-divider>
      <div class="list">
        <div>
          <el-button type="text">
            <i class="el-icon-time"/>
            <span>我的稍后答</span>
          </el-button>
        </div>
        <div>
          <el-button type="text">
            <i class="el-icon-files"/>
            <span>我的草稿</span>
          </el-button>
        </div>
      </div>
    </el-card>
    <el-dialog
      title="写想法"
      :visible.sync="writerDialogVisible"
      width="540px"
      center>
      <div class="ideaContent">
        <span>需要注意的是内容是默认不居中的</span>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="writerDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="writerDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'asideWrite',
  data () {
    return {
      writerDialogVisible: false
    }
  },
  methods: {
    handleWriteAnswer () { // 处理写回答

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
  .ideaContent{
    height: 400px;
  }
}
</style>
