<template>
  <el-container class="collection-container">
    <el-main>
      <el-card class="collection-card">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="我关注的收藏夹" name="att-collection">
            <div id="collectionList" v-for="collection in collections" :key="collection.id">
              <div class="collectionName">{{collection.cname}}</div>
              <div class="collectiionDetail">
                由 {{collection.author}} 创建 · {{collection.content}} 条内容 · {{collection.subs}} 人关注 · 取消关注
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="我创建的收藏夹" name="cteate-collection">
            我创建的收藏夹
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <aside-collection></aside-collection>
    </el-aside>
  </el-container>

</template>
<script>
import { reqGetHotTopic } from '../../api/topic.js'
import AsideCollection from '../../components/aside/AsideCollection'
export default {
  name: 'collection',
  components: {
    AsideCollection
  },
  data () {
    return {
      activeName: 'att-collection',
      collections:[
        {cname:"搞机",author:"港真",content:"1",subs:"2"},
        {cname:"穿搭",author:"快乐",content:"3",subs:"4"}]
    }
  },
  methods: {
    handleClick () {
      reqGetHotTopic().then(res => {
        if (res.resultCode == 200) {
          console.info(res.data)
        }
      })
    }
  }
}

</script>
<style lang="scss">
.collection-container {
  .collection-card {
    .collectionName{
      margin-top: 5px;
      margin-bottom: 5px;
      font-size: 15px;
      color: #259;
      font-weight: bold;
    }
    .collectiionDetail{
      color: #999;
    }
  }
}
</style>


