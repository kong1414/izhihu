<template>
  <div class="search-box">
    <!-- 123{{$route.params.input}} -->
    <el-card class="search-card" :body-style="{ padding: '0px' }">
      <div slot="header"><span>“ {{$route.params.input}} ”</span> 的搜索结果 <el-button size="mini" @click="_loadData()">再次搜索</el-button></div>

      <div class="search-content" v-loading="loading">
        <div v-if="list.length <= 0">非常抱歉，未能搜索到您想要的结果</div>
        <div v-else v-for="(item,index) in list" :key="index">
          {{item}}
        </div>
      </div>


    </el-card>
  </div>
</template>

<script>
import {reqFindQuesByName} from '../../api/question'

export default {
  name: 'search',
  data () {
    return {
      list: [],
      loading: true
    }
  },
  mounted () {
    this._loadData()
  },
  methods: {
    _loadData () {
      let params="keyword=" + this.$route.params.input
      reqFindQuesByName(params).then(res => {
        if (res.resultCode == 200) {
          this.list = res.data
        }
        this.loading = false
      })
    },
    toQues(id) {
      this.$router.push({ path: "/home/question/" + id })
    }
  }
}
</script>

<style lang="scss">
.search-box {
  width: 1100px;
  height: 100%;
  margin-top: 20px;
  .search-card {
    .search-content {
      min-height: 300px;
    }
  }
}
</style>
