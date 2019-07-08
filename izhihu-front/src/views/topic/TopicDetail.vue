<template>
  <!-- 话题详情页-->
  <el-container class="topicDetail-container">
    <el-main class="topDet">
      <el-card>
        <el-image class="topImag" :src="url"></el-image>
        <div class="firCard">
          <div class="firCardName">
            <span>{{topDet.topicName}}</span>
          </div>
          <div class="firCardDet" @click="dialogVisible = true">
            <span>{{topDet.topicDesc}}</span>
          </div>
        </div>
        <el-button type="primary" class="subsBut" v-if="!isFollow" @click="isFollow=!isFollow">
          <span>关注话题</span>
        </el-button>
        <el-button type="info" class="subsBut2" v-if="isFollow" @click="isFollow=!isFollow">取消关注</el-button>
        <el-button type="text" class="shareBut">
          <i class="el-icon-s-promotion" />
          <span>分享</span>
        </el-button>
      </el-card>
      <el-card class="secCard">
        <div slot="header" class="clearfix">
          <span class="dis">讨论</span>
          <el-button class="moreCon" type="text">更多内容</el-button>
        </div>
        <div v-if="disDetCon==false">暂无数据</div>
        <div v-if="disDetCon==true">
          <div  v-for="disDet in disDets" :key="disDet.topicId" class="text item" >
            <!-- 给answerItem传值   :topicid="topicId"-->
            <answer-item
              :attiStat="disDet.attiStat"
              :apprN="disDet.apprN"
              :evalN="disDet.comment_num"
              :queName="disDet.ques_name"
              :author="disDet.name"
              :queDet="disDet.content"
              :articleId="disDet.article_id"
              :queId="disDet.ques_id"
              :type="disDet.type"
            />
          </div>
        </div>
      </el-card>
    </el-main>
    <el-aside width="300px" style="background-color:#ecf5ff;min-height:200px">
      <aside-Subs :topicId="topicId"
                  :quenum="queNumber"
      ></aside-Subs>
      <aside-Footer></aside-Footer>
    </el-aside>
    <el-dialog :title="topDet.topicName" :visible.sync="dialogVisible" width="600px">
      <div class="dialog-body">
        <span>{{topDet.topicDesc}}</span>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">关 闭</el-button>
      </span>
    </el-dialog>
  </el-container>
</template>
<script>
import AsideFooter from "../../components/aside/AsideFooter";
import AsideSubs from "../../components/aside/AsideSubs";
import AnswerItem from "../../components/index/AnswerItem";
import  {reqGetTopicArticle} from "../../api/topicArticle";
import { reqGetTopicDet } from "../../api/topicArticle";
export default {
  name: "topicDetail",
  components: {
    AsideSubs,
    AnswerItem,
    AsideFooter
  },
  data() {
    return {
      topicId: this.$route.params.topicid,
      url: "",
      isFollow: false,
      apprButView: false,
      oppButView: false,
      dialogVisible: false,
      topDet: "",
      disDetCon: '',
      // topName: "高考",
      // topDet:
      //   "普通高等学校招生全国统一考试（The National College Entrance Examination），简称“高考”，是中华人民共和国（不包括香港特别行政区、澳门特别行政区和台湾省）合格的高中毕业生或具有同等学历的考生参加的选拔性考试。 2018年8月，北京市新高考方案公布。",
      disDets: [
        // {
        //   attiStat: "0",
        //   apprN: "100",
        //   evalN: "100",
        //   queName: "你是如何填写高考志愿的，为什么选择了所填报的学校和专业？",
        //   author: "Yuhang",
        //   authorDet: "数学领域优秀答题者",
        //   queDet:
        //     "对这个问题感触还是很深，哈哈哈，因为我应该是知乎大佬们口中所说的“寒门子弟”，是家族里第一个过了一本线的大学生，所以没有人可以指导我，七年前的我，不知道知乎、没有微博、不知道什么微信公众号，直到大学第一天，我才有我自己的第一部手机，电脑也是为了填志愿而买的一部配置非常感人的老古董，偶尔百度百度。出分数之后，我是湖北省文科1022名，按名次来说，我可以填一个一般的985，然而，我们整个家族都不知道该怎么填志愿。正好一个远房亲戚的孩子也高考，刚过一本线，非常难填，要去市里面找一个什么大师去填志愿，我爸妈也是为数不多的一次为了我蹭人家的便车，连夜赶到他家做客尬聊，然后一起去“大师”家里问志愿怎么填，其实大师的逻辑非常之简单，看“录取分数波动”，其实后来我就知道这种方法很偏颇，应该要以“名次”为准，可是，当年，其实也没有什么更好的办法。"
        // },
        // {
        //   attiStat: "1",
        //   apprN: "123",
        //   evalN: "123",
        //   queName: "当你知道高考成绩以后的感受？",
        //   author: "Seddie",
        //   authorDet: "教育领域优秀答题者",
        //   queDet:
        //     "知乎处女答！高考前一天晚上，我在背古诗词的时候突然感到空虚寂寞冷。于是，我就把我爸妈喊来玩汉字听写游戏，我报他俩写。我报宠爱的“宠”，我妈写了个“庞”，我爸嘲笑她。我妈放出狂言：要是他写对了我就把纸吃了。我爸写对，我妈遂吃纸。我报暧昧的“暧”，我爸写了个“暖”，我妈嘲笑他。我爸放出狂言：要是她写对了我就把纸吃了。我妈写对，我爸遂吃纸。于是这天晚上，我爸妈一边嚼着纸屑一边互骂对方不是中国人，房间内外充满了快活的空气。"
        // },
        // {
        //   attiStat: "2",
        //   apprN: "234",
        //   evalN: "311",
        //   queName: "高考完的那个晚上你去干嘛了？",
        //   author: "Chen Wen",
        //   authorDet: "一个在修飞机，其实想开飞机的老司机",
        //   queDet:
        //     "典型的拉不出屎还要怪到地心引力。短短的几句问题描述，我来告诉你都有哪些槽点。1、兼容并包北大的兼容并包是什么？指的是任何思想都可以在这里碰撞，不是说任何人都可以在园子里嘚瑟。你有思想，哪怕今天在扫地，明天说不定也能和大师们坐而论道；你没思想，就算今天堂而皇之地坐在教学楼里，说不定明天就被扫地出门。这才叫兼容并包，实现它的前提是平等。所以，一个高考“状元”从北大退学，恰恰证明北大坚持了传统，不以高考成绩考察学生，高考状元也没有特权，真正做到了兼容并包。2、天才如果按照IQ140的标准，那么主人公很可能是天才，这没什么说的。但是你要知道，IQ140在人群中的概率比上清华北大还要高，也就不难知道，这样的天才在北大绝对不稀奇。如果换一个标准，以人才作为人间之才，那么天才指的就是此才只应天上有。一个地级市状元，再考是省状元，这也远远达不到“天选之才”的程度。全国每年几百个市状元，大几十个省状元，是必然会出现的一个群体。"
        // }
      ],
      queNumber: 0,
    };
  },
  created() {
    this._loadData();
  },
  methods: {
    handleClick() {},
    _loadData() {
      let params = "topicId=" + this.topicId;
      // console.info(this.topicId);
      reqGetTopicDet(params).then(res => {
        if (res.resultCode === 200) {
          // console.info(res.data);
          this.topDet = res.data;
          //console.info(this.Ftop);
        }
      });
      reqGetTopicArticle(params).then(res =>{
        if (res.resultCode === 200) {
          // console.info(res.data);
          this.disDets = res.data;
          this.disDetCon = false;
          this.disDets.forEach(element => {
            // 给答案数据创一些新的值(点赞状态、评论数、点赞数)
            element.attiStat = 0;
            element.comment_num = 4;
            element.apprN = 201;
            if(element.ques_name!=null) this.disDetCon = true;
            this.queNumber ++;
          });
          //console.info(this.Ftop);
          // console.info(this.disDets.ques_name)
        }   
      }
      )
    }
  }
};
</script>
<style lang="scss">
.topicDetail-container {
  .topDet {
    .secCard {
      margin-top: 20px;
      .moreCon {
        float: right;
        padding: 3px 0px;
      }
    }
    .topImag {
      width: 100px;
      height: 100px;
      float: left;
    }
    .dis {
      font-weight: bold;
      font-size: 20px;
    }
    .firCard {
      width: 580px;
      height: 100px;
      float: left;
      margin-left: 30px;
    }
    .firCardName {
      font-weight: bold;
      font-size: 25px;
      height: 30px;
    }
    .firCardDet {
      margin-top: 10px;
      font-size: 15px;
      color: #646464;
      height: 50px;
      line-height: 1.6;
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 2; //行数
      -webkit-box-orient: vertical;
    }
    .subsBut {
      margin-top: 30px;
      width: 100px;
      height: 40px;
      background: #0084ff;
    }
    .subsBut2 {
      margin-top: 30px;
      width: 100px;
      height: 40px;
    }
    .shareBut {
      color: #76839b;
      font-size: 15px;
      margin-left: 20px;
      i {
        font-size: 18px;
      }
      .shareI {
        color: #8590a6;
        padding: 0px 5px;
      }
    }
  }

  .text {
    font-size: 14px;
    .disDetName {
      font-size: 18px;
      font-weight: 600;
      color: black;
    }
    .disDetAuthor {
      font-size: 15px;
      font-weight: 600;
      margin-left: 10px;
    }
    .disDetque {
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
    .ope {
      margin-top: 8px;
      i {
        font-size: 18px;
        color: #0084ff;
      }
      .apprBut {
        height: 35px;
        width: 110px;
        background: #0084ff1a;
        line-height: 30px;
        text-align: center;
        font-size: 14px;
        border-radius: 3px;
        padding: 0px 10px;
        border-width: 0px;
        span {
          color: #0084ff;
        }
      }
      .oppBut {
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
    .avaImag {
      float: left;
      width: 24px;
      height: 24px;
    }
  }

  .dialog-body {
    padding: 22px;
    margin-top: -5px;
    font-size: 15px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both;
  }
}
</style>
