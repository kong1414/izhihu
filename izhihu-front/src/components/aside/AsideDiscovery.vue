<template>
  <div class="aside-discovery">
    <el-card class="hot-table">

    </el-card>
    <el-card class="hot-topic">
    <div slot="header">
          热门话题
    </div>
    </el-card>
    <el-card class="hot-collect"> 

    </el-card>
    <aside-footer></aside-footer>
  </div>
</template>
<script>
import AsideFooter from '../../components/aside/AsideFooter'
export default {
  name: 'asideDiscovery',
  components: {
    AsideFooter
  },
  data () {
    list [
      {message:'topName'},
      {message:'topName'},
      {message:'topName'}
    ]
  },
  methods: {

  }
}
</script>
<style lang="scss">
.aside-discovery {
  .hot-table {

  }
  .hot-topic {

  }
  .hot-collect {
    
  }
}
</style>

