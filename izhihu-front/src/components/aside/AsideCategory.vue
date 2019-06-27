<template>
  <!-- 首页右侧第二栏 -->
  <div class="aside-write">
    <el-card class="write-card">
      <el-row>
        <el-col :span="8">
          <el-button type="text" class="write-button">
            <i class="el-icon-s-order"/>
            <p>live</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text" class="write-button">
            <i class="el-icon-edit"/>
            <p>书店</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text" class="write-button">
            <i class="el-icon-paperclip"/>
            <p>圆桌</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text" class="write-button">
            <i class="el-icon-s-order"/>
            <p>专栏</p>
          </el-button>
        </el-col>
        <el-col :span="8">
          <el-button type="text" class="write-button">
            <i class="el-icon-s-order"/>
            <p>收费咨询</p>
          </el-button>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'asideCategory',
  data () {
    return {

    }
  },
  methods: {
   

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
