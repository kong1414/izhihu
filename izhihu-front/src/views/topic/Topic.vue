<template>
  <el-container class="topic-container">
    <el-main>
      <el-card class="att-topic-crad">
        <div slot="header">
          <span>已关注的话题动态</span>
          <span style="float:right">共关注了{{i}}个话题</span>
        </div>
        <div class="label">
            <div v-for="i in labelcount" :key="i">
                <div class="tag-group">
                  <el-tag
                  v-for="item in items"
                  :key="item.label"
                  :type="item.type"
                  
                  >
                  {{ item.label }}
                   </el-tag>
                </div>
            </div>
        </div>
      </el-card>
      <el-card class="topic-item">
        <div v-for="i in [1,2,3]" :key="i">
          问题？
          回答
        </div>
      </el-card>
    </el-main>
    <el-aside width="300px" style="min-height:200px">
      <aside-topic></aside-topic>
    </el-aside>
  </el-container>
</template>

<script>
import AsideTopic from '../../components/aside/AsideTopic'
export default {
  name: 'topic',
  components: {
    AsideTopic
  },
  data () {
    return {
      items: [
          { type: '', label: '标签一' },
      ],
      i:'3000',
      labelcount:31
    }
  },
  methods: {

  }
}
</script>

<style lang="scss">
.topic-container {
  .att-topic-crad {
  }
  .topic-item {
    margin-top: 15px;
  }
  .label{
    
    .tag-group{
      float: left;
      margin-left: 12px;
      margin-bottom: 10px;
    }
  }
}

</style>
