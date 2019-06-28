<template>
  <div class="hot-list">
    <div class="button">
      <el-radio-group v-model="labels" size="medium" text-color='#0084ff' fill='#B0C4DE'>
        <el-radio-button label="全站"></el-radio-button>
        <el-radio-button label="科学"></el-radio-button>
        <el-radio-button label="数码"></el-radio-button>
        <el-radio-button label="体育"></el-radio-button>
        <el-radio-button label="时尚"></el-radio-button>
        <el-radio-button label="影视"></el-radio-button>
      </el-radio-group>
    </div>
    <div class="hot-list-content">
      <div v-for="i in [1]" :key="i" class="item">
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
  // background-color: black;
  .button {
    padding: 5px;
    border-bottom:2px solid #E4E7ED
  }
}
</style>

