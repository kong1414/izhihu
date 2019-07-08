<template>
  <div class="hot-list">
    <div class="button">
      <el-radio-group v-model="category"
                      size="medium"
                      text-color='#0084ff'
                      fill='#B0C4DE'
                      @change="handleChange">
        <!-- 类别（0全部1科学2数码3体育4时尚5影视） -->
        <el-radio-button label="0">全站</el-radio-button>
        <el-radio-button label="1">科学</el-radio-button>
        <el-radio-button label="2">数码</el-radio-button>
        <el-radio-button label="3">体育</el-radio-button>
        <el-radio-button label="4">时尚</el-radio-button>
        <el-radio-button label="5">影视</el-radio-button>
      </el-radio-group>
    </div>
    <article-item></article-item>
  </div>
</template>

<script>
import { reqGetHostList } from '../../api/home'
import ArticleItem from '../index/ArticleItem'
export default {
  name: 'HotList',
  components: {
    ArticleItem
  },
  data () {
    return {
      // 类别（0全部1科学2数码3体育4时尚5影视）
      category: '0'
    }
  },
  mounted () {
    // this._loadData()
  },
  methods: {
    _loadData () {
      let params = {
        categoryType: this.category
      }
      reqGetHostList(params).then(res => {
        if (res.resultCode === 200) {
          console.info(res)
        }
      })
    },
    handleChange (v) {
      console.log(v)
      this._loadData()
    }
  }
}
</script>

<style lang="scss">

</style>
