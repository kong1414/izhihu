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
    <el-aside width="300px" style="min-height:200px">
      <aside-topic></aside-topic>
    </el-aside>
  </el-container>
</template>

<script>
import AsideTopic from '../../components/aside/AsideTopic'
export default {
  name: 'topic',
  components: {
    AsideTopic
  },
  data () {

    return {

    }
  },
  methods: {

  }
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
