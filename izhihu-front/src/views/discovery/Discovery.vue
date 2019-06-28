<template>
  <el-container class="discovery-container">
    <el-main>
      <el-card class="recommend-crad">
        <div slot="header">
          编辑推荐
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
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <aside-discovery></aside-discovery>
    </el-aside>
  </el-container>
</template>
<script>
import AsideDiscovery from '../../components/aside/AsideDiscovery'
export default {
  name: "discovery",
  components: {
    AsideDiscovery
  },
  data () {
    return {
      activeName: 'today',
    }
  },
  methods: {
    handleClick () {

    }
  },
}
</script>

<style lang="scss">
.discovery-container {
  .recommend-crad {
    min-height: 400px;
  }
  .today-hot {
    margin-top: 20px;

  }
}
</style>

