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
    <div class="hot-list-content">
      <div v-for="i in [1]"
           :key="i"
           class="item">
        asd

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HotList',
  data () {
    return {
      // 类别（0全部1科学2数码3体育4时尚5影视）
      category: '0'
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData() {
      // 初始化发送请求
    },
    handleChange (v) {
      console.log(v)
      let params = {
        type: this.category
      }
      // 发送请求
    }
  }
}
</script>

<style lang="scss">
.hot-list {
  height: 1000px;
  // background-color: black;
  .button {
    padding: 5px;
    border-bottom: 2px solid #e4e7ed;
  }
}
</style>

