<template>
  <div id="app">
    <transition name="el-fade-in">
      <router-view/>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>
<style lang="scss">
#app {
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  min-width: 500px;
  min-height: 500px;
}
</style>
