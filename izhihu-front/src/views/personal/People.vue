<template>
  <el-container class="people-container">
    <el-header class="people-header"
               height="800px">
      <el-card :body-style="{ padding: '0px' }"
               class="header-card">
        <img src="../../assets/img/people-bg.jpg"
             alt="背景图"
             width="1100px">
        <div class="content">
          <el-image class="avatar"
                    :src="avatarPhotoUrl"
                    :fit="fit">
          </el-image>
          <div class="introduce">
            <p>
              <span>莫烦</span>
              <span>机器学习原来可以很简单</span>
            </p>
            <!-- <p>
              <span>高新科技</span>
              <span>高新科技</span>
              <span>高新科技</span>
            </p>
            <p>
              <span>格里菲斯大学（Griffith University）</span>
            </p> -->
          </div>
          <div class="operation">
            <el-button size="medium" icon="el-icon-plus" type="primary">关注</el-button>
            <el-button size="medium" icon="el-icon-chat-round">发私信</el-button>
          </div>
        </div>

      </el-card>
    </el-header>
    <el-container class="people-content">
      <el-main class="people-main">
        main
      </el-main>
      <el-aside class="people-aside">
        aside
        <aside-footer></aside-footer>
      </el-aside>
    </el-container>
  </el-container>
</template>

<script>
import AsideFooter from '../../components/aside/AsideFooter'
export default {
  name: 'people',
  components: {
    AsideFooter
  },
  data () {
    return {
      avatarPhotoUrl: 'http://img5q.duitang.com/uploads/item/201506/20/20150620081746_mPa3S.jpeg',
    }
  },
  mounted () {
    console.info('userid', this.$route.params.user)
  },
  methods: {

  }
}
</script>

<style lang="scss">
.people-container {
  .people-header {
    padding: 0;
    // background-color: #F6F6F6;
    .header-card {
      height: 440px;
      .content {
        .avatar {
          border-radius: 8px;
          display: inline-block;
          overflow: hidden;
          vertical-align: top;
          background-color: #fff;
          border: 4px solid #fff;
          width: 160px;
          height: 160px;
          position: relative;
          z-index: 1;
          top: -25px;
          margin-left: 20px;
          // float: left;
        }
        .introduce {
          // float: left;
          display: inline-block;
          width: 650px;
        }
        .operation {
          display: inline-block;
          padding-left: 20px;
        }
      }
    }
  }
  .people-content {
    .people-main {
    }
    .people-aside {
    }
  }
}
</style>

