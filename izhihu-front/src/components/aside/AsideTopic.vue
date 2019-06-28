<template>
<div>
  <div class="border-top" >
   <el-card class="border-top">
      <div>
        <div>
            <el-button class="button-square">进入话题广场</el-button>
        </div>
        <div>
          <a href="" class="here" >来这里发现更多有趣话题</a>
        </div>
      </div>
    </el-card>
  </div>

  
</div>
</template>

<script>
export default {
  name: 'asidetopic',
  data () {
    return {

    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss">
.border-top{
  border: 1px solid steelblue;
  padding: 18px;
  border-radius: 4px;
  background-color: #eff6fA;
  
}
.button-square{
    margin-left: 22px;
    color: #fff;
    background: #1472cf;
    border: 1px solid #0D6EB8;
}
.here{
  margin-left: 8px;
  color: #5488b4;
  display: block;
  margin-top: 18px;
}
</style>

