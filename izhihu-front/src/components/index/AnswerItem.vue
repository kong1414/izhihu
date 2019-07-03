<template>
  <!-- 回答内容的组件 -->
  <div class="text item">
    <el-button type="text">
            <div class="disDetName">{{disDet.queName}}</div>
          </el-button>
          <div style="margin-top:10px;">
            <el-image
              class="avaImag"
              :src="disDet.topName"
              ></el-image>
            <span class="disDetAuthor">{{disDet.author}}</span>
            <span style="font-size:14px;">,    {{disDet.authorDet}}</span>
          </div>
          <div class="disDetque">{{disDet.queDet}}</div>
          <div class="ope">
            <span>
              <el-button class="apprBut" v-if="disDet.attiStat!=1" @click="disDet.attiStat=1">
                <i class="el-icon-caret-top"></i>
                <span>赞同 {{disDet.apprN}}</span>
              </el-button>
              <el-button class="apprBut" style="background:#0084ff;" v-if="disDet.attiStat==1" @click="disDet.attiStat=0;apprAddN();">
                <i class="el-icon-caret-top" style="color:white;"></i>
                <span style="color:white;">已赞同  {{disDet.apprN}}</span>
              </el-button>
              <el-button class="oppBut" v-if="disDet.attiStat!=2" @click="disDet.attiStat=2">
                <i class="el-icon-caret-bottom"></i>
              </el-button>
              <el-button class="oppBut" style="background:#0084ff;" v-if="disDet.attiStat==2" @click="disDet.attiStat=0">
                <i class="el-icon-caret-bottom" style="color:white;"></i>
              </el-button>
            </span>
            <el-button type="text" class="shareBut">
              <i class="el-icon-chat-line-round shareI"/>
              <span>{{disDet.evalN}}   条评论</span>
            </el-button>
            <el-button type="text" class="shareBut">
              <i class="el-icon-s-promotion shareI"/>
              <span>分享</span>
            </el-button>
            <el-button type="text" class="shareBut">
              <i class="el-icon-star-on shareI"/>
              <span>收藏</span>
            </el-button>
            <el-button type="text" class="shareBut">
              <i class="el-icon-s-flag shareI"/>
              <span>感谢</span>
            </el-button>
          </div>
          <el-divider></el-divider>
  </div>
</template>

<script>
export default {
  name: 'AnswerItem',
  components: {
  },
  data () {
    return {
    }
  },
  methods: {
    handleClick () {
    }
  }
}
</script>
<style lang="scss">
  .text {
    font-size: 14px;
    .disDetName{
      font-size: 18px;
      font-weight: 600;
      color: black;
    }
    .disDetAuthor{
      font-size: 15px;
      font-weight: 600;
      margin-left: 10px;
    }
    .disDetque{
      margin-top: 15px;
      font-size: 15px;
      color: #1a1a1a;
      overflow: hidden;
      max-height: 100px;
      line-height: 1.6;
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 3; //行数
      -webkit-box-orient: vertical;
      
    }
    .ope{
      margin-top: 8px;
      i{
        font-size: 18px;
        color: #0084ff;
      }
      .apprBut{
        height: 35px;
        width: 110px;
        background: #0084ff1a;
        line-height: 30px;
        text-align: center;
        font-size: 14px;
        border-radius: 3px;
        padding: 0px 10px;
        border-width: 0px;
        span{
          color: #0084ff;
        }
      }
      .oppBut{
        height: 35px;
        line-height: 30px;
        text-align: center;
        font-size: 14px;
        border-radius: 3px;
        padding: 0px 10px;
        background: #0084ff1a;
        border-width: 0px;
      }
    }
  }

  .item {
    margin-bottom: 18px;
    .avaImag{
      float:left;
      width:24px;
      height:24px;
    }
  }
</style>
