<template>
  <el-container class="question-container">
    <el-header class="header">
      <el-card class="question-header-card">
        <div class="quesTopic">
          <span class="title">相关话题：</span>
          <el-tag v-for="i in topicList" :key="i">
            {{i.topicName}}
            </el-tag>
        </div>
        <div class="quesName">
          {{quesName}}
        </div>
        <div class="quesdesc">
          {{quesdesc}}
        </div>
        <div class="button-group">
          <el-button type="primary" size="mini">关注问题</el-button>
          <el-button type="primary" plain size="mini">写回答</el-button>
          <el-button type="info" plain size="mini">邀请回答</el-button>
          <el-button type="text"><i class="el-icon-s-comment"/>评论</el-button>
          <el-button type="text"><i class="el-icon-s-promotion"/>分享</el-button>
          <el-button type="text"><i class="el-icon-warning"/>举报</el-button>
        </div>
      </el-card>
    </el-header>

    <el-container>
      <el-main>
        <el-card>
          <div slot="header">
            全部回答
          </div>
          <div>
            <answer-item></answer-item>
          </div>
        </el-card>
      </el-main>
      <el-aside width="300px" class="ques-aside">
        <el-card class="att-right">
          <el-row>
            <el-col :span="12">
              <div class="att-title">关注者</div>
              <div class="att-title-N">{{attNum}}</div>
            </el-col>
            <el-col :span="12">
              <div class="att-title" >浏览量</div>
              <div class="att-title-N">0</div>
            </el-col>
          </el-row>
        </el-card>
        <aside-discovery style="margin-top: 20px;"/>
      </el-aside>
    </el-container>
    
  </el-container>

</template>

<script>
import AnswerItem from '../../components/index/AnswerItem'
import AsideFooter from '../../components/aside/AsideFooter'
import AsideDiscovery from '../../components/aside/AsideDiscovery'
export default {
  name: 'question',
  components: {
    AsideFooter,
    AnswerItem,
    AsideDiscovery
  },
  data () {
    return {
      quesName: '怎样才能见到小罗伯特唐尼？',
      quesdesc: '现在很多人已经不会在饥寒交迫中死去了，古人有很多追求永生，现在的小说也体现出了对永生的憧憬，生存是生物的第一需求，乃是人类本性，但我问，在文本分类任务中，fastText（浅层网络）往往能取得和深度网络相媲美的精度，却在训练时间上比深度网络快许多数量级。在标准的多核CPU上， 能够训练10亿词级别语料库的词向量在10分钟之内，能够分类有着30万多类别的50多万句子在1分钟之内。', 
      topicList: [{topicName: '123'}],
      attNum: 0,
    }
  },
  methods: {

  }
}
</script>

<style lang="scss">
.question-container {
  .header {
    background-color: initial;
    height: auto !important;
    .question-header-card {
      margin-top: 20px;
      .quesTopic {
        .title {
          font-size: 15px;
          line-height: 1.5px;
          margin-right: 20px;
        }
      }
      .quesName {
        font-size: 22px;
        font-weight: 600;
        margin-top: 10px;
      }
      .quesdesc {
        word-break: break-word;
        line-height: 1.6;
        margin-top: 5px;
      }
      .button-group {
        margin-top: 5px;
      }
    }
    
  }
  .ques-aside {
    padding-right: 20px;
    padding-top: 20px;
  }
  .att-right {
    text-align: center;
    .att-title {
      font-size: 14px;
      color: #8590a6;
    }
    .att-title-N {
      font-size: 18px;
      color: #1a1a1a;
      font-weight: 600;
    }
  }
}
</style>
