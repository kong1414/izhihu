<template>
  <el-container class="discovery-container">
    <el-main>
      <el-card class="recommend-crad">
        <div slot="header">
          <i class="el-icon-s-unfold"></i>
          <span class="left">编辑推荐</span>
          <el-button class="right" type="text">
            更多推荐
            <i class="el-icon-d-arrow-right"></i>
          </el-button>
        </div>
      </el-card>
      <el-card class="today-hot">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="今日最热" name="today">
            今日最热
          </el-tab-pane>
          <el-tab-pane label="关注" name="month">
            本月最热
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-main>

    <el-aside width="300px" style="min-height:200px">
      <aside-discovery></aside-discovery>
    </el-aside>

  </el-container>
</template>
<script>
import AsideDiscovery from '../../components/aside/AsideDiscovery'
import RecommendItem from '../../components/index/RecommendItem'
export default {
  name: 'discovery',
  components: {
    AsideDiscovery,
    RecommendItem
  },
  data () {
    return {
      userId: this.$store.state.user.userId,
      activeName: 'today'
    }
  },
  methods: {
    handleClick () { // 改变今日最热 和 本月最热

    }
  }
}
</script>

<style lang="scss">
.discovery-container {
  .recommend-crad {
    min-height: 400px;
    .left{
      padding-left: 5px;
    }
    .right{
      padding: 3px 0;
      float:right;
      color:rgb(133, 144, 166);
    }
  }
  .today-hot {
    margin-top: 20px;
  }

}
</style>
