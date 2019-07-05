<template>
  <el-container class="index">
    <el-main>
      <el-card class="index-crad"
               :body-style="{ padding: '0px 20px 20px' }">
        <el-tabs v-model="activeName"
                 @tab-click="handleClick">
          <el-tab-pane label="推荐"
                       name="first">
            <recommend-item title=5G的到来会造成编程语言大灭绝进而JS一统应用前端吗?
                            content="5G的到来会造成编程语言大灭绝进而JS一统应用前端吗?"
                            articleId="123123"
                            quesId="123123"
                            type=1
                            heatNum=123 />
          </el-tab-pane>
          <el-tab-pane label="关注"
                       name="second">
            关注
          </el-tab-pane>
          <el-tab-pane label="热榜"
                       name="third">
            <hot-list></hot-list>
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-main>
    <el-aside width="300px"
              style="min-height:200px">
      <aside-write></aside-write>
      <aside-category></aside-category>
      <aside-nav-list></aside-nav-list>
      <aside-footer></aside-footer>
    </el-aside>
  </el-container>
</template>

<script>
import AsideWrite from '../../components/aside/AsideWrite.vue'
import AsideCategory from '../../components/aside/AsideCategory.vue'
import AsideFooter from '../../components/aside/AsideFooter.vue'
import HotList from '../../components/index/HotList'
import AsideNavList from '../../components/aside/AsideNavList.vue'
import RecommendItem from '../../components/index/RecommendItem'
export default {
  name: 'index',
  components: {
    AsideWrite,
    AsideCategory,
    AsideFooter,
    HotList,
    AsideNavList,
    RecommendItem
  },
  data () {
    return {
      activeName: 'first'
    }
  },
  methods: {
    handleClick () {

    }
  }
}
</script>

<style lang="scss">
.index {
  .el-main {
    .index-crad {
      .el-tabs {
        padding-top: 0px;
        .el-tabs__item {
          font-weight: 500;
          font-size: 16px;
          height: 56px;
          line-height: 56px;
        }
        .el-tabs__item + .is-active {
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
