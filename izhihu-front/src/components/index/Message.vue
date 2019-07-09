<template>
  <div class="message-box">
    <el-dialog title="私信" lock-scroll :visible.sync="visible" width="600px" @close="handleClose">
      <div v-loading="contentLoading" style="height: 400px;margin:10px;padding:10px;border: 1px solid #b1b1b1; overflow:auto;">
        <div v-for="(item,index) in contentList" :key="index" style="border-bottom: 1px solid #b1b1b1;padding: 5px;">
          <div>
            <el-button type="text" @click="toUser(item.send_user_id)">{{item.sendName}}</el-button> 
            <span> 发送给 </span>
            <el-button type="text" @click="toUser(item.takeIn_user_id)">{{item.takeInName}}</el-button> 
          </div>
          <div>内容：{{item.priv_mess_content}}</div>
          <el-button v-if="item.readed == 1" type="text" size="mini"><span style="color:#b5b5b5">已读</span></el-button>
          <el-button v-else type="text" size="mini" @click="handleRead(item.priv_mess_id)">未读</el-button>
          <el-button type="text" size="mini" @click="handleDel(item.priv_mess_id)">删除</el-button>
          <span style="margin-left:20px;font-size:12px;">发送时间： {{item.create_time}}</span>
        </div>
      </div>
      <div style="text-align: center;padding: 0 10px 20px">
        私信对象：
        <el-select v-model="toUser"
          filterable
          remote
          reserve-keyword
          :remote-method="remoteMethod"
          :loading="loading"
          style="width: 300px;margin-bottom: 10px;"
          placeholder="请输入发送用户的姓名">
          <el-option v-for="(item) in options" :key="item.value" :label="item.label" :value="item.value"> </el-option>
        </el-select>
        <el-input v-model="content" style="width:400px;" placeholder="请输入私信内容"> </el-input>
        <el-button @click="handleUp" style="margin-left:20px">发送</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import {reqMessList,reqMessRead,reqMessDel,reqMessSend,reqSearchUser } from '../../api/message'
import dataUtil from '../../util/dataUtil';

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
      contentLoading: false,
      visible: true,
      contentList: [
        {name:'name',content:'1234355'},
        {name:'name',content:'1234355'}
      ],
      options: [],
      userId: this.$store.state.user.userId,
      toUser: '', //私信对象id
      content: '', // 私信内容
      loading: false,
    }
  },
  mounted () {
    this.userId= this.$store.state.user.userId,
    this._loadData()
  },
  methods: {
    _loadData () {
      let params = 'userId=' + this.$store.state.user.userId
      reqMessList(params).then(res => {
        if(res.resultCode == 200) {
          this.contentList = res.data.map(i => {
            i.create_time = dataUtil.getStrData(i.create_time)
            return i
          })
        }
        this.contentLoading = false
      })

    },
    _loadOptions (keyword) {
      this.loading = true
      let params = 'keyword=' + keyword
      reqSearchUser(params).then(res => {
        if (res.resultCode == 200) {
          let arr = []
          res.data.forEach(i => {
            let obj={
              label: i.name,
              value: i.user_id
            }
            arr.push(obj)
          })
          this.options = arr
          this.loading = false
        }
      })
    },  
    handleUp () {
      let params = {
        takeinUserId: this.toUser,
        sendUserId: this.$store.state.user.userId,
        content: this.content
      }
      reqMessSend(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this._loadData()
        }
      })
      
    },
    handleRead (id) {
      let params = 'id=' + id
      reqMessRead(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this._loadData()
        }
      })
    },
    handleDel (id) {
      let params = 'id=' + id
      reqMessDel(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this._loadData()
        }
      })
    },
    handleClose () {
      this.$emit("close")
    },
    remoteMethod (query) {
      if (query !== '') {
        this._loadOptions(query)
      } else {
        this.options = []
      }
    }
  }
}
</script>
<style lang="scss">
.message-box {

}
</style>


