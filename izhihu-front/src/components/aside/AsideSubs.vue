<template>
<!-- 收藏页第一栏 -->
<div class="aside-subs">
  <el-card class="subs-card">
    <div>
      <div class="subsNum">
        <div class="subsM">关注者</div>
        <div class="subsN">{{subNum}}</div>
      </div>
      <el-divider direction="vertical"></el-divider>
      <div class="queNum">
        <div class="queM">问题数</div>
        <div class="queN">{{queNum}}</div>
      </div>
    </div>
  </el-card>
  <el-card class="F-S-card">
    <div>
      <div>
        <div class="dis">父话题</div>
        <div></div>
      </div>
      <div></div>
    </div>
  </el-card>
</div>
</template>

<script>
export default {
  name: 'asideSubs',
  data () {
    return {
      subNum:'26361',
      queNum:'31231'
    }
  },
  methods: {
  }
}
</script>

<style lang="scss">
.aside-subs {
  margin-top: 20px;
  .F-S-card{
    margin-top: 15px;
    .dis{
      font-weight: bold;
      font-size: 15px;
    }
  }
  .subs-card {
    text-align: center;
    .el-card__body {
        padding: 15px;
    }
    .category-button {
        text-align: center;
        i {
          margin: 6px;
          font-size: 30px;
        }
    }
    .el-divider {
      height: 3em;
      margin-left: -10px;
    }
    .subsNum{
      float: left;
      width: 100px;
      margin-left: 10px;
      .subsM{
        color: #8590a6;
      }
      .subsN{
        font-size: 18px;
        color: #1a1a1a;
        font-weight: 600;
        margin-top: 3px;
      }
    }
    .queNum{
      float: right;
      widows: 100px;
      margin-right: 30px;
      .queM{
        color: #8590a6;
      }
      .queN{
        font-size: 18px;
        color: #1a1a1a;
        font-weight: 600;
        margin-top: 3px;
      }
    }
}
}
</style>
