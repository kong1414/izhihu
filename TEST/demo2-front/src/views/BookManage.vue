<template>
  <dir class="bookmanage-div">
    <div class="bookmanage-header">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/home/bookmanage' }"><i class="el-icon-s-home"></i></el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/home/bookmanage' }">图书管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-card>
      <div>
        <el-button>新增图书</el-button>
        <div>
          <span>图书名称</span>
          <el-input v-model="input"></el-input>
          <el-button>搜索</el-button>
        </div>
      </div>
      <el-table>
        <el-table-column>

        </el-table-column>
      </el-table>
    </el-card>
  </dir>
</template>

<script>
export default {
  name: 'bookmanage',
  data () {
    return {
      input: '',
    }
  }
}
</script>

<style lang="scss">
.bookmanage-div {
  .bookmanage-header {
    height: 60px;
    background-color: white;
  }
}
</style>


