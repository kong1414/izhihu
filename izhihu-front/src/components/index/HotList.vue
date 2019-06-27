<template>
  <div class="hot-list">
    <div>
      <el-radio-group v-model="labels" size="medium">
        <el-radio-button label="全站"></el-radio-button>
        <el-radio-button label="科学"></el-radio-button>
        <el-radio-button label="数码"></el-radio-button>
        <el-radio-button label="体育"></el-radio-button>
        <el-radio-button label="时尚"></el-radio-button>
        <el-radio-button label="影视"></el-radio-button>
      </el-radio-group>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HotList',
  data () {
    return {
      labels : '全站'
    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss">
.hot-list {
  height: 1000px;
  background-color: black;
}
</style>

