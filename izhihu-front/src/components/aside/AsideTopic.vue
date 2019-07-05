<template>
  <el-aside class="aside-topic">
    <el-card class="aside-top">
      <el-button type="primary" class="btn-Topic-square">进入话题广场</el-button>
      <el-button type="text" class="btn-find">来这里发现更多有趣话题</el-button>
    </el-card>
    <el-card class="aside-attention" :body-style="{ padding: '0px 0px 20px 5px' }">
      <div slot="header" class="clearfix">
        <span>其他人关注的话题</span>
        <el-button
          type="text"
          style=" padding: 3px 0"
          @click="_loadData()"
          icon="el-icon-refresh"
          class="change"
        >换一换</el-button>
      </div>
      <div v-for="i in list" :key="i.topicId" class="text-item" >
        <el-avatar class="img" shape="square" :src="i.photoUrl"></el-avatar>
        <el-button
          type="text"
          @click="toTopicDetail(i.topicId)"
          class="btn-topic-name"
        >{{i.topicName}}</el-button>
        <el-button
          type="text"
          icon="el-icon-plus"
          class="btn-attention"
          v-if="!i.isFollow"
          @click="handleFollow(i)"
        >关注</el-button>
        <el-button type="text" class="btn-attention" v-else @click="handleFollow(i)">已关注</el-button>
      </div>
    </el-card>
  </el-aside>
</template>


<script>
import { reqGetAsideTopic } from "../../api/topic";
import { reqUnFollow, reqInFollow } from "../../api/follow";
export default {
  name: "asidetopic",
  components: {},
  data() {
    return {
      list: []
    };
  },
  created() {
    this._loadData();
  },
  methods: {
    _loadData() {
      reqGetAsideTopic().then(res => {
        if (res.resultCode === 200) {
          res.data.forEach(element => {
            // 增加一个属性isfollow
            element.isFollow = false;
          });
          this.list = res.data;
        }
      });
    },
    handleFollow(obj) {
      // 点击可以取消关注和关注他
      console.info(obj);
      if (obj.isFollow == true) {
        // 取消关注进这里
        let params = {
          contentId: obj.topicId,
          userId: this.$store.state.user.userId
        };
        reqUnFollow(params).then(res => {
          if (res.resultCode == 200) {
            this.$message(res.resultMessage);
            obj.isFollow = false;
          }
        });
      } else {
        // 重新关注进这里
        console.info("重新关注进这里");
        let params = {
          contentId: obj.topicId,
          userId: this.$store.state.user.userId,
          type: 5
        };
        reqInFollow(params).then(res => {
          if (res.resultCode == 200) {
            this.$message(res.resultMessage);
            obj.isFollow = true;
          }
        });
      }
      console.info(obj);
    },
    toTopicDetail(id) {
      this.$router.push({ path: "/home/topicDetail/" + id });
    }
  }
};
</script>

<style lang="scss">
.aside-topic {
  margin-top: 20px;
  .aside-top {
    text-decoration: none;
    height: 145px;
    width: 280px;
    // border: 1px solid rgba(70, 130, 180, 0.41);
    padding: 13px;
    border-radius: 4px;
    text-align: center;
    background-color: #eff6fa;
    .btn-find {
      height: auto;
      width: 100%;
      display: inline-block;
      color: #5488b4;
      cursor: pointer;
      font-size: 13px;
      color: #5488b4;
      //float: left;
      margin: 10px auto 0;
    }
    .btn-find:hover {
      color: #345570;
    }
  }
  .aside-attention {
    margin-top: 18px;
    width: 280px;
    //.clearfix{
    //}
    .change {
      margin-left: 62px;
    }
    .text-item {
      margin-top: 12px;
      width: 100%;
      .img {
        float: left;
        margin-left: 10px;
        width: 45px;
        height: 45px;
        background-color: blanchedalmond;
      }
      .btn-topic-name {
        margin-left: 15px;
      }
      .btn-attention {
        float:right;
        margin-right: 20px;
      }
    }
  }
}
</style>
