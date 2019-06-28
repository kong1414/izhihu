<template>
  <el-container class="topic-container">
    <el-main>
      <el-card class="att-topic-crad">
        <div slot="header">
          已关注的话题动态
          共关注了xx个话题
        </div>
      </el-card>
      <el-card class="topic-item">
        <div v-for="i in [1,2,3]" :key="i">
          问题？
          回答
        </div>
      </el-card>
    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <aside-discovery></aside-discovery>
    </el-aside>
  </el-container>
</template>

<script>
export default {
}
</script>

<style lang="scss">
.topic-container {
  .att-topic-crad {
  }
  .topic-item {
    margin-top: 20px;
  }
}

</style>
