<template>
  <!-- 我的收藏页 -->
  <div class="aside-colletcion">
    <el-card class="colletcion-card">
      <div class="list">
        <div class="above">
          <el-button type="text" @click="toUser">
            <i class="el-icon-collection-tag" />
            <span>我的收藏</span>
          </el-button>
        </div>
        <div class="above">
          <el-button type="text" @click="toUser">
            <i class="el-icon-folder-checked" />
            <span>我关注的问题</span>
          </el-button>
        </div>
        <div class="above">
          <el-button type="text" @click="toUser">
            <i class="el-icon-document" />
            <span>邀请我回答的问题</span>
          </el-button>
        </div>
        <el-divider></el-divider>
        <div class="above">
          <el-button type="text" @click="toCommunity">
            <i class="el-icon-s-home" />
            <span>社区服务中心</span>
          </el-button>
        </div>
        <div class="above">
          <el-button type="text">
            <i class="el-icon-s-management" />
            <span>版权服务中心1</span>
          </el-button>
        </div>
        <el-divider></el-divider>
        <div class="above">
          <el-button type="text"
                     @click="dialogFormVisible = true">
            <i class="el-icon-plus"></i>
            <span>创建收藏夹</span>
          </el-button>
        </div>
      </div>
    </el-card>

    <el-dialog title="创建收藏夹"
               width="600px"
               :visible.sync="dialogFormVisible">
      <el-form label-width="60px"
               style="width: 100%;padding: 20px;">
        <el-form-item label="名称"
                      style="">
          <el-input v-model="name"
                    placeholder="请输入收藏夹名称"></el-input>
        </el-form-item>
        <el-form-item label="描述"
                      style="">
          <el-input v-model="describes"
                    placeholder="请输入收藏夹描述"></el-input>
        </el-form-item>
        <div class="choiArea">
          <el-radio v-model="isPublic"
                    label="1">
            <span class="choiFont">公开</span>
            <span class="detailFont">收藏夹关注者 > 0 时不能设置为私密</span>
          </el-radio>
        </div>
        <div class="choiArea">
          <el-radio v-model="isPublic"
                    label="0">
            <span class="choiFont">私密</span>
            <span class="detailFont">只有你可以查看这个收藏夹</span>
          </el-radio>
        </div>
      </el-form>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary"
                   @click="handleCreate">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { reqCreateFav } from '../../api/favorite'

export default {
  name: "asideCollection",
  data () {
    return {
      userId: this.$store.state.user.userId,
      dialogFormVisible: false,
      name: '',
      describes: '',
      isPublic: '1'
    };
  },
  methods: {
    handleCreate () {
      let params = {
        userId: this.userId,
        name: this.name,
        describes: this.describes,
        isPublic: Number(this.isPublic)
      }
      reqCreateFav(params).then(res => {
        if (res.resultCode == 200) {
          this.$message({
            type: 'success',
            message: res.resultMessage
          })
          this.name = ''
          this.describes = ''
          this.dialogFormVisible = false
          this.$emit('loadData')
        }
      })

    },
    toFavorite() {
      //跳转favorite页面
      this.$router.push({ path: "/home/favorite" });
    },
    toUser(){
      //跳转个人页面
      this.$router.push({ path: "/home/people/" +this.userId });
    },
    toCommunity(){
      window.location.href = 'http://www.baidu.com'; 
    }
  }
}
</script>
<style lang="scss">
.aside-colletcion {
  margin-top: 20px;
  .colletcion-card {
    margin-top: 20px;
    text-align: center;
    .el-card__body {
      padding: 10px 0px;
    }
    .list {
      text-align: left;
      span {
        color: #76839b;
      }
      i {
        font-size: 17px;
      }
      .above {
        display: block;
        padding-left: 20px;
      }
      .above:hover {
        background: #f6f6f6;
        span {
          color: #7abce7;
        }
      }
      .el-divider--horizontal {
        margin: 6px 0;
      }
    }
  }
  .choiFont {
    font-size: 15px;
    font-weight: bold;
  }
  .detailFont {
    font-size: 13px;
    margin-left: 5px;
  }
  .choiArea {
    margin-top: 10px;
    margin-left: 50px;
  }
}
</style>
