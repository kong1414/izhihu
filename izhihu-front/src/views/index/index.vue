<template>
  <div class="index">
    <el-container class="main">
      <el-main>
        Main
        </el-main>
      <el-aside width="300px" style="background-color:green;height:200px">
        Aside
        <aside-write></aside-write>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
import AsideWrite from '../../components/aside/AsideWrite.vue'
export default {
  name: 'index',
  components: {
    AsideWrite
  },
  data () {
    return {
    }
  },
  methods: {

  }
}
</script>

<style lang="scss">

</style>
