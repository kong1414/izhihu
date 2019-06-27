<template>
  <el-container class="index">
    <el-main>
      <el-card>
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="推荐" name="first">
            推荐
          </el-tab-pane>
          <el-tab-pane label="关注" name="second">
            关注
          </el-tab-pane>
          <el-tab-pane label="热榜" name="third">
            热榜
          </el-tab-pane>
        </el-tabs>
      </el-card>
      
      </el-main>
    <el-aside width="300px" style="background-color:green;height:200px">
      Aside
      <aside-write></aside-write>
    </el-aside>
  </el-container>
</template>

<script>
import AsideWrite from '../../components/aside/AsideWrite.vue'
export default {
  name: 'index',
  components: {
    AsideWrite
  },
  data () {
    return {
      activeName: 'first'
    }
  },
  methods: {

  }
}
</script>

<style lang="scss">
.index {
  .el-main {
    .el-card {
      .el-tabs {
        padding-top: 0px;
        width: 200px;
        .el-tabs__item {
          font-weight: 500;
          font-size: 16px;
          height: 56px;
          line-height: 56px;
        }
        .is-active {
          font-weight: 500;
          color: #0084ff;
          font-size: 16px;
        }
        .el-tabs__active-bar {
          border-bottom: none;
        }
      }
    }
  }
}
</style>
