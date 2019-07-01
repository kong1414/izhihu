<!-- 数据字典 -->
<template>
  <div class="base-container dictionary-page">
    <div class="header">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>数据字典</el-breadcrumb-item>
      </el-breadcrumb>
      <h1>数据字典</h1>
    </div>
    <div class="main">
      <div style="margin-bottom:10px;">
        <el-button icon="el-icon-plus" size="small" @click="onAddDictionary" type="primary">新增</el-button>
        <!-- <el-button  size="small" icon="el-icon-upload2">导出</el-button> -->
      </div>
      <div class="item_box" v-for="(item,index) in itemsBox" :key="index">
        <div class="position">
          <btn><el-button type="text" size="small" @click="handleEdit(index,item)">编辑</el-button></btn>
          <el-button type="text" size="small" @click="handleDelete(index,item)">删除</el-button>
        </div>
        <header class="title" style="padding-bottom:15px;">{{item.name}}</header>
        <div style="padding-bottom:15px;">
          <el-tag style="margin-right:10px" v-for="tag in item.childrenList" :key="tag.id"  closable :disable-transitions='true'
          @close="handleClose(index,tag)">{{tag.name}}</el-tag>
          <el-button :plain="true" class="button-new-tag" size="small" @click="onAddMark(index, item)">+ 新增值</el-button>
        </div>
        <div>
            <btn><span class="iconfont icon-icon--"></span> {{item.tag}}</btn> <span class="iconfont icon-describe"></span> {{item.comment}}
        </div>
      </div>
    </div>
    <el-dialog :title="dictionarytitle" :visible.sync="dialogDictionary" width="520px" class="change-pwd-dialog">
      <div class="content">
        <el-form :model="dictionary" label-width="80px" ref="passwords" size="small">
          <el-form-item label="类别：" prop="name">
              <el-input size="small" v-model="dictionary.name" placeholder="请输入字典类型名称"></el-input>
          </el-form-item>
          <el-form-item label="标签：" prop="tag">
              <el-input size="small" v-model="dictionary.tag" placeholder="请输入标签"></el-input>
          </el-form-item>
          <el-form-item label="描述：" prop="comment">
              <el-input size="small" v-model="dictionary.comment" placeholder="请输入描述"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div slot="footer" class="footer">
        <el-button  size="small" @click="dialogDictionary = false">取消</el-button>
        <el-button  size="small" @click="handleAddDictionary" type="primary">确定</el-button>
      </div>
    </el-dialog>
    <el-dialog title="新增值" :visible.sync="dialogDictionaryChildren" width="520px" class="change-pwd-dialog">
      <div class="content">
        <el-form :model="children" label-width="80px" ref="passwords" size="small">
          <el-form-item label="名称：" prop="comment">
              <el-input size="small" v-model="children.name" placeholder="请输入名称"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div slot="footer" class="footer">
        <el-button  size="small" @click="dialogDictionaryChildren = false">取消</el-button>
        <el-button  size="small" @click="handleAddDictionaryChildren" type="primary">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import Btn from '../../components/Btn'
import { ERR_OK } from '../../api/config'
import { reqDictionaryList, reqBatchRemove, reqDictionaryUpdate, reqDictionarySave, reqDictionarysaveChildren } from '../../api/sysManager'
export default {
  name: 'dictionary',
  components: {
    Btn
  },
  data () {
    return {
      dialogDictionary: false,
      dialogDictionaryChildren: false,
      dictionarytitle: '',
      dictionary: {
        name: '',
        tag: '',
        comment: ''
      },
      children: {
        parentId: '',
        name: ''
      },
      itemsBox: []
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      reqDictionaryList().then(res => {
        if (res.resultCode === ERR_OK) {
          this.itemsBox = res.data
        }
      })
    },
    onAddDictionary () { // 点击新增
      this.dictionary = {}
      this.dialogDictionary = true
      this.dictionarytitle = '新增数字字典'
    },
    handleClose (index, tag) { // 删除标签
      this.$confirm('此操作将永久删除该类型, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params = {
          ids: []
        }
        params.ids.push(tag.id)
        reqBatchRemove(params).then(res => {
          if (res.resultCode === ERR_OK) {
            this.$message({
              type: 'success',
              message: '删除类型成功!',
              duration: 1500
            })
            this._loadData()
          }
        })
      })
      // this.itemsBox[index].splice(this.tags.indexOf(tag), 1)
    },
    handleEdit (index, item) { // 编辑字典
      this.dictionary.name = item.name
      this.dictionary.tag = item.tag
      this.dictionary.comment = item.comment
      this.dictionary.id = item.id
      this.dictionarytitle = '编辑数字字典'
      this.dialogDictionary = true
    },
    handleDelete (index, item) { // 删除字典
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params = {
          ids: []
        }
        params.ids.push(item.id)
        reqBatchRemove(params).then(res => {
          if (res.resultCode === ERR_OK) {
            this.$message({
              type: 'success',
              message: res.resultMessage,
              duration: 1500
            })
            this._loadData()
          }
        })
      })
    },
    handleAddDictionary () { // 确认新增数据字典
      if (!this.dictionary.id) {
        reqDictionarySave(this.dictionary).then(res => {
          if (res.resultCode === ERR_OK) {
            this.$message({
              type: 'success',
              message: '新增字典成功!',
              duration: 1500
            })
            this.dialogDictionary = false
            this._loadData()
          }
        })
      } else {
        reqDictionaryUpdate(this.dictionary).then(res => {
          if (res.resultCode === ERR_OK) {
            this.$message({
              type: 'success',
              message: '修改字典成功!',
              duration: 1500
            })
            this.dialogDictionary = false
            this._loadData()
          }
        })
      }
    },
    onAddMark (index, item) { // 新增值
      this.dialogDictionaryChildren = true
      this.children.parentId = item.id
      this.children.name = ''
    },
    handleAddDictionaryChildren () { // 新增值
      reqDictionarysaveChildren(this.children).then(res => {
        if (res.resultCode === ERR_OK) {
          this.$message({
            type: 'success',
            message: '新增值成功!',
            duration: 1500
          })
          this.dialogDictionaryChildren = false
          this._loadData()
        }
      })
    }
  }
}
</script>

<style lang="scss">
.dictionary-page {
  .main {
    .main-header {
      display: flex;
      justify-content: space-between;
    }
    .item_box {
      position: relative;
      padding: 15px 10px;
      border-bottom: 1px solid #ccc;
      .title {
        font-size: 16px;
        color: #000;
      }
      .position {
        position: absolute;
        right: 15px;
        top: 15px;
      }
    }
    .item_box .iconfont {
      font-size: 16px;
    }
  }
}
</style>
