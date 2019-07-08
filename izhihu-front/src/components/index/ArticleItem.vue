<template>
  <div>
    <div class="item-content" v-for="(item,index) in list" :key="index">
      <div class="index">
        <div class="hot">{{index+1}}</div>
      </div>
      <div class="content">
        <h2 class="title" :title="item.quesName"  @click="toQues(item.quesId)">{{item.quesName}}</h2>
        <p class="excerpt" v-html="item.quesDescribe" @click="dialogVisible = true"></p>
        <div class="button-content">
          <i class="el-icon-trophy">{{item.browseNum}} 热度</i>
          <i class="el-icon-s-promotion">{{item.share}}</i>
        </div>
      </div>
      <el-dialog
        :title="item.title"
        :visible.sync="dialogVisible"
        width="600px">
        <div class="dialog-body">
          <span>{{item.excerpt}}</span>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="dialogVisible = false">关 闭</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {reqGetHostList} from '../../api/home'

export default {
  name: 'ArticleItem',
  data () {
    return {
      dialogVisible: false,
      list: []
    }
  },
  mounted () {
    this._loadData()
  },
  methods:{
    _loadData () {
      reqGetHostList().then(res => {
        if (res.resultCode == 200) {
          this.list = res.data
        }
      })
    },
    toQues(id) {
      this.$router.push({ path: "/home/question/" + id })
    }
  }
}
</script>

<style lang="scss">
.item-content{
  border-bottom: rgb(221, 213, 213) 1px solid;
  color: #000;
  display: flex;
  font-size: 15px;
  width: 718px;
  height: 137px;
  background: #fff;
  padding: 16px 16px 16px 0;
  .dialog-body{
    padding: 20px;
  }
  .index{
    text-align: center;
    width: 57px;
    .hot{
      color: #ff9607;
      line-height: 1.6;
      font-size: 18px;
      font-weight: 600;
    }
  }
  .content{
    width: 651px;
    height: 105px;
    .title{
      font-size: 18px;
      line-height: 28px;
      max-height: 56px;
      display: -webkit-box;
      text-overflow: ellipsis;
      overflow: hidden;
      -webkit-line-clamp: 1;
      -webkit-box-orient: vertical;
      font-weight: 600;
      cursor:pointer;
    }
    .excerpt{
      color: #444;
      line-height: 25px;
      margin-top: 0px;
      min-height: 25px;
      display: -webkit-box;
      text-overflow: ellipsis;
      overflow: hidden;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      cursor:pointer;
    }
    .button-content{
      -webkit-box-flex: 1;
      -ms-flex: 1 1;
      flex: 1 1;
      overflow: hidden;
      color: #8590a6;
      .el-icon-s-promotion{
        margin-left: 20px;
        color: #8590a6;
        cursor:pointer;
      }
    }
  }

}
</style>
