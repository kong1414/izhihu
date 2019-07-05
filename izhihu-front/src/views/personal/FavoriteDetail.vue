<template>
  <!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="favorite-container">
    <el-main>
      <el-card class="favorite"
               :body-style="{ padding: '20px 0px 10px 20px' }">
        <div>
          <span style=" font-size:16px; ">收藏夹名称</span>
        </div>
        <div class="favorite-describe">
          <span>收藏夹描述</span>
        </div>
        <div class="favorite-function">
          <el-button type="text"
                     class="function"
                     @click="editor = true">
            <i class="el-icon-edit" />
            <span>编辑</span>
          </el-button>
          <el-button type="text"
                     class="function"
                     @click="del">
            <i class="el-icon-delete" />
            <span>删除</span>
          </el-button>
        </div>
      </el-card>
      <el-card class="favorite-content">
        <span>暂无收藏内容</span>
      </el-card>
    </el-main>
    <el-aside width="300px"
              style="min-height:200px">
      <el-card class="creator"
               :body-style="{ padding: '20px 0px 10px 20px' }">
        <div>
          <span style=" font-size:15px; ">关于创建者</span>
        </div>
        <div class="creator-message">
          <el-avatar class="img"
                     shape="square"
                     :src="photoUrl"></el-avatar>
          <el-button type="text"
                     class="btn-creator-name">昵称</el-button>
        </div>
      </el-card>
      <el-card class="favorite-status"
               :body-style="{ padding: '18px 0px 5px 20px'}">
        <div>
          <span style="font-size:15px; ">收藏夹状态</span>
        </div>
        <div class="time">
          <span style="font-size:12px; ">最近活动于 09:14</span>
        </div>
        <div class="count-attention">
          <el-button type="text">0</el-button>
          <span style="font-size:12px; "> 人关注了该收藏夹</span>
        </div>
      </el-card>
      <aside-collection></aside-collection>
      <aside-Footer></aside-Footer>
    </el-aside>

    <el-dialog title="编辑收藏夹"
               width="600px"
               :visible.sync="editor">
      <el-form :model="form"
               label-width="60px"
               style="width:100%;padding:20px;">
        <el-form-item label="标题">
          <el-input v-model="form.name"
                    id="inTitle"
                    autocomplete="off"
                    placeholder="最多输入20字"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="form.detail"
                    id="inDetail"
                    autocomplete="off"
                    placeholder="最多输入20字"></el-input>
        </el-form-item>
        <div class="choiArea">
          <el-radio v-model="radioOC"
                    label="1">
            <span class="choiFont">公开</span>
            <span class="detailFont">收藏夹关注者 > 0 时不能设置为私密</span>
          </el-radio>
        </div>
        <div class="choiArea">
          <el-radio v-model="radioOC"
                    label="2">
            <span class="choiFont">私密</span>
            <span class="detailFont">只有你可以查看这个收藏夹</span>
          </el-radio>
        </div>
      </el-form>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click="editor = false">取 消</el-button>
        <el-button type="primary"
                   @click="editor = false">确 定</el-button>
      </div>
    </el-dialog>
  </el-container>
</template>
<script>
import AsideFooter from '../../components/aside/AsideFooter'
import AsideCollection from '../../components/aside/AsideCollection'
export default {
  name: 'favorite',
  components: {
    AsideFooter,
    AsideCollection
  },
  data () {
    return {
      editor: false,
      photoUrl: '',
      form: {
        name: '',
        detail: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      radioOC: '1'
    }
  },
  methods: {
    del () {
      this.$confirm('此操作将永久删除该收藏夹, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }
    // handleClick () {
    // }
  }
}
</script>
<style lang="scss">
.favorite-container {
  margin-top: 20px;
  .favorite {
    margin-top: -20px;
    .favorite-describe {
      margin-top: 10px;
    }
    .function {
      margin-top: 2px;
      color: #76839b;
      font-size: 15px;
    }
  }
  .favorite-content {
    margin-top: 20px;
  }
  .creator {
    .creator-message {
      padding: 10px 0px 0px 6px;
      margin-bottom: 65px;
      .img {
        float: left;
        width: 60px;
        height: 60px;
      }
      .btn-creator-name {
        float: left;
        margin-left: 16px;
        padding-top: 20px;
      }
    }
  }
  .favorite-status {
    margin-top: 20px;
    .time {
      margin-top: 14px;
    }
    //  .count-attention{
    //  }
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
    margin-left: 60px;
  }
}
</style>
