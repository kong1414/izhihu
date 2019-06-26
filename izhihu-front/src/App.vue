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
  min-width: 1100px;
  min-height: 500px;
}
</style>
