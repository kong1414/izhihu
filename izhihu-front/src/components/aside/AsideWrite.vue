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
          <el-button type="text" class="write-button">
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
  </div>
</template>

<script>
export default {
  name: 'asideWrite',
  data () {
    return {

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
}
</style>
