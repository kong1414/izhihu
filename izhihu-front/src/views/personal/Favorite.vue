<template>
  <el-container class="collection-container">
    <el-main>
      <el-card class="collection-card"
               :body-style="{ padding: '20px 20px 0' }">
        <el-tabs v-model="activeName"
                 @tab-click="handleClick">
          <el-tab-pane label="我关注的收藏夹"
                       name="att-collection">
            <div v-if="subCollections.length == 0"
                 style="padding-bottom:20px;">
              暂无关注的收藏夹
            </div>
            <div v-else
                 class="collectionList"
                 v-for="(collection, index) in subCollections"
                 :key="index">
              <el-button type="text"
                         class="collectionName"
                         @click="toFavDetail(collection.favorite)">{{collection.favorite.favoriteName}}</el-button>
              <div class="collectiionDetail">由 {{collection.userName}} 创建 · {{collection.contentNum}} 条内容 · {{collection.attNum}} 人关注 ·
                <el-button type="text"
                           size="mini"
                           @click="unCollect(collection.favorite)">取消关注</el-button>
              </div>
              <el-divider></el-divider>
            </div>
          </el-tab-pane>
          <el-tab-pane label="我创建的收藏夹"
                       name="cteate-collection">
            <div v-if="creaCollections.length == 0"
                 style="padding-bottom:20px;">
              暂无创建的收藏夹
            </div>
            <div class="collectionList"
                 v-for="(collection, index) in creaCollections"
                 :key="index">
              <el-button type="text"
                      class="collectionName"
                      @click="toFavDetail(collection.favorite)">{{collection.favorite.favoriteName}}</el-button>
              <div class="collectiionDetail">{{collection.contentNum}} 条内容 · {{collection.attNum}} 人关注</div>
              <el-divider></el-divider>
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-main>
    <el-aside width="300px"
              style="min-height:200px">
      <aside-collection @loadData="_loadData"></aside-collection>
    </el-aside>
  </el-container>
</template>
<script>
import { reqMyAttFavorite, reqMyFavDetail } from '../../api/favorite'
import { reqInFollow, reqUnFollow } from '../../api/follow'

import AsideCollection from "../../components/aside/AsideCollection";
export default {
  name: "collection",
  components: {
    AsideCollection
  },
  data () {
    return {
      userId: this.$store.state.user.userId,
      // userId: '528576bf-a08b-4336-adb2-ad590ff9f277',
      activeName: "att-collection",
      subCollections: [],
      creaCollections: []
    };
  },
  mounted () {
    this._loadData()
  },
  methods: {
    _loadData () {
      let params = 'userId=' + this.userId
      reqMyAttFavorite(params).then(res => {
        if (res.resultCode == 200) {
          this.subCollections = res.data
        }
      })
      reqMyFavDetail(params).then(res => {
        if (res.resultCode == 200) {
          this.creaCollections = res.data
        }
      })

    },
    handleClick () { // 我关注的收藏夹 和我的收藏夹 切换
    },
    unCollect (favId) { // 取消关注
      let params = {
        userId: this.userId,
        contentId: favId
      }
      reqUnFollow(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this._loadData()
        }
      })
    },
    toFavDetail (v) {
      this.$router.push({ path: '/home/favoriteDetail/' + v.favoriteId })

    }
  }
};
</script>
<style lang="scss">
.collection-container {
  .collection-card {
    .collectionName {
      margin: 5px 0;
      padding: 0;
      font-size: 15px;
      color: #259;
      font-weight: bold;
    }
    .collectiionDetail {
      margin-top: 10px;
      color: #999;
    }
    .collectionList {
      .el-divider--horizontal {
        margin: 10px 0px 20px;
      }
    }
  }
}
</style>
