<template>
  <!-- 首页右侧第三栏 -->
  <div class="aside-navlist">
    <el-card class="navlist-card">
      <el-row>
      <div class="list">
        <div>
          <el-button type="text" @click="toFavorite">
            <i class="el-icon-star-off"/>
            <span>我的收藏</span>
          </el-button>
        </div>
        <div>
          <el-button type="text" @click="toUser">
            <i class="el-icon-question"/>
            <span>我关注的问题</span>
          </el-button>
        </div>
        <div>
          <el-button type="text">
            <i class="el-icon-plus"/>
            <span>我的邀请</span>
          </el-button>
        </div>
        <div>
          <el-button type="text">
            <i class="el-icon-tickets"/>
            <span>站务中心</span>
          </el-button>
        </div>
        <div>
          <el-button type="text">
            <i class="el-icon-s-management"/>
            <span>版权服务中心</span>
          </el-button>
        </div>
      </div>
      </el-row>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'asideNavlist',
  data () {
    return {
      userId: this.$store.state.user.userId
    }
  },
  methods: {
    toFavorite() {
      //跳转favorite页面
      this.$router.push({ path: "/home/favorite" });
    },
    toUser(){
      //跳转个人页面
      this.$router.push({ path: "/home/people/" +this.userId });
    }
  }
}
</script>

<style lang="scss">
.aside-navlist {
  margin-top: 20px;
  .navlist-card {
    text-align: center;
    .el-card__body {
      padding: 10px 0px;
    }
    .navlist-button {
      text-align: center;
      i {
        margin: 6px;
        font-size: 30px;
      }
    }
    .el-divider {
      margin: 5px 0;
    }
    .list {
      text-align: left;
      span {
        color: #76839b;
      }
      i{
        font-size: 17px;
      }
      div {
        padding-left: 20px;
      }
      div:hover
      {
        background: #f6f6f6;
      }
    }
  }
}
</style>
