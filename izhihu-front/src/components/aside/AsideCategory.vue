<template>
<!-- 首页右侧第二栏 -->
<div class="aside-category">
  <el-card class="category-card" style="mag">
    <el-row>
      <el-col :span="8">
        <el-button type="text" class="category-button">
          <i class="el-icon-s-promotion"/>
          <p class="categoryLabel">live</p>
        </el-button>
      </el-col>
      <el-col :span="8">
        <el-button type="text" class="category-button">
          <i class="el-icon-notebook-1"/>
          <p class="categoryLabel">书店</p>
        </el-button>
      </el-col>
      <el-col :span="8">
        <el-button type="text" class="category-button">
          <i class="el-icon-bangzhu"/>
          <p class="categoryLabel">圆桌</p>
        </el-button>
      </el-col>
      <el-col :span="8">
        <el-button type="text" class="category-button">
          <i class="el-icon-edit"/>
          <p class="categoryLabel">专栏</p>
        </el-button>
      </el-col>
      <el-col :span="8">
        <el-button type="text" class="category-button">
          <i class="el-icon-chat-line-round"/>
          <p class="categoryLabel">收费咨询</p>
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
.aside-category {
  margin-top: 20px;
  .category-card {
  text-align: center;
  .el-card__body {
      padding: 15px;
  }
  .category-button {
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
  .categoryLabel {
      font-size: 15px;
      color: #8590a6;
  }
}
}
</style>
