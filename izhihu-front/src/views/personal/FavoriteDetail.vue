<template>
  <!-- 收藏夹页，对于某个收藏夹而言的页面 -->
  <el-container class="favorite-container">
    <el-main>
      <el-card class="favorite"
               :body-style="{ padding: '20px 0px 10px 20px' }">
        <div>
          <span style=" font-size:16px; ">{{name}}</span>
        </div>
        <div class="favorite-describe">
          <span>{{describes}}</span>
        </div>
        <div class="favorite-function">
          <el-button type="text"
                     class="function"
                     @click="dialogFormVisible = true">
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
        <div v-if="articleList.length <= 0">暂无收藏内容</div>
        <div v-else
             v-for="(item, index) in articleList"
             :key="index">
          <!-- 给answerItem传值 -->
          <answer-item
                      :apprN="item.report_num"
                      :evalN="item.comment_num"
                      :queName="item.title"
                      :author="item.name"
                      :queDet="item.content"
                      :articleId="item.article_id"
                      :queId="item.ques_id"
                      :type="item.type"
                      :authorId="item.author_id"
                      :photoUrl="item.photo_url"
                    />
          <!-- {{item}} -->
        </div>
      </el-card>
    </el-main>
    <el-aside width="300px"
              style="min-height:200px">
      <el-card style="margin-top:20px" :body-style="{ padding: '20px 0' }">
        <div slot="header">
          收藏夹状态
        </div>
        <el-form label-width="100px">
          <el-form-item label="创建者： "
                        style="margin-bottom:0px">
            <el-button type="text"
                       @click="toUserDetail()">{{userName}}</el-button>
          </el-form-item>
          <el-form-item label="创建时间："
                        style="margin-bottom: 0px">
            <span>{{createTime}}</span>
          </el-form-item>
          <el-form-item label="关注人数："
                        style="margin-bottom:0px">
            <el-button type="text">{{attNum}}</el-button>人
          </el-form-item>
        </el-form>
      </el-card>

      <aside-collection></aside-collection>
      <aside-Footer></aside-Footer>
    </el-aside>

    <el-dialog title="编辑收藏夹"
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

  </el-container>
</template>
<script>
import AnswerItem from '../../components/index/AnswerItem'
import AsideFooter from '../../components/aside/AsideFooter'
import AsideCollection from '../../components/aside/AsideCollection'
import { reqDetail } from '../../api/favorite'
import dataUtil from '../../util/dataUtil'

export default {
  name: 'favorite',
  components: {
    AsideFooter,
    AsideCollection,
    AnswerItem
  },
  data () {
    return {
      userId: this.$store.state.user.userId,
      favoriteId: this.$route.params.favoriteid,
      name: '',
      describes: '',
      isPublic: '1',
      dialogFormVisible: false,
      photoUrl: '', // 收藏夹配图
      userName: '暂无数据',
      userNameId: '',
      createTime: '',
      attNum: 0,
      articleList: [],// 文章
    }
  },
  mounted () {
    this._loadData()
  },
  methods: {
    _loadData () {
      let params = 'id=' + this.favoriteId
      reqDetail(params).then(res => {
        if (res.resultCode == 200) {
          this.attNum = res.data.attNum
          this.userName = res.data.userName

          this.userNameId = res.data.favorite.userId
          this.name = res.data.favorite.favoriteName
          this.describes = res.data.favorite.describes
          this.isPublic = String(res.data.favorite.isPublic)
          this.createTime = dataUtil.getStrData(res.data.favorite.createTime)

          this.articleList = res.data.articleList
        }
      })
    },
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
    },
    toUserDetail () { // 跳转到用户主页
      this.$router.push({ path: '/home/people/'+ this.userNameId });
    },
    handleCreate () { // 编辑收藏夹页的

    }
  }
}
</script>
<style lang="scss">
.favorite-container {
  width: 100%;
  height: 100%;
  .favorite {
    .favorite-describe {
      margin-top: 10px;
      color: #5c5c5c;
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

  // 弹窗的内容
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
