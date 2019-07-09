<template>
  <div class="message-box">
    <el-dialog title="私信" lock-scroll :visible.sync="visible" width="600px" @close="handleClose">
      <div style="height: 400px;margin:10px;padding:10px;border: 1px solid #b1b1b1; overflow:auto;">
        <div v-for="(item,index) in contentList" :key="index" style="border-bottom: 1px solid #b1b1b1;padding: 5px;">
          <div>发送者： {{item.name}}</div>
          <div>私信内容：{{item.content}}</div>
          <el-button type="text" size="mini" @click="del()">删除</el-button>
        </div>
      </div>
      <div style="text-align: center;padding: 0 10px 20px">
        选择用户
        <el-select v-model="toUser" style="padding: 0 10px 10px;width:350px;" placeholder="请选择发送对象">
          <el-option label="123" value="123"></el-option>
        </el-select>
        <el-input v-model="content" style="width:400px;" placeholder="请输入私信内容"> </el-input>
        <el-button @click="handleUp" style="margin-left:20px">发送</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  name: 'message',
  props: {
    show: {
      type: Boolean,
      default: false,
    }
  },
  watch: {
    show () {
      if (this.show == true) {
        this.visible = true
      }
    } 
  },
  data () {
    return {
      visible: false,
      contentList: [
        {name:'name',content:'1234355'},
        {name:'name',content:'1234355'}
      ],
      userId: this.$store.state.user.userId,
      toUser: '',//私信对象id
      content: '', // 私信内容
    }
  },
  mounted () {
    this.userId= this.$store.state.user.userId,
    this._loadData()
  },
  methods: {
    _loadData () {

    },
    handleUp () {
      
    },
    handleClose () {
      this.$emit("close")
    }
  }
}
</script>
<style lang="scss">
.message-box {

}
</style>


