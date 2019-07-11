<!-- index -->
<template>
  <div class="index">
    <el-row :gutter="20"
            class="index-header" v-loading="headerLoading">
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">浏览量</span>
          <span class="data-num">{{browNum}}</span>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">问题数</span>
          <span class="data-num">{{quesNum}}</span>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">文章数</span>
          <span class="data-num">{{artNum}}</span>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">评论数</span>
          <span class="data-num">{{commentNum}}</span>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20"
            class="index-header" v-loading="headerLoading">
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">点赞数</span>
          <span class="data-num">{{agreeNum}}</span>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">关注数</span>
          <span class="data-num">{{attNum}}</span>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">话题数</span>
          <span class="data-num">{{topicNum}}</span>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never"
                 class="header-data">
          <i class="el-icon-s-data"></i>
          <span class="data-text">用户数</span>
          <span class="data-num">{{userNum}}</span>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20"
            class="index-main">
      <el-col :span="12">
        <el-card shadow="hover"
                 class="chart" v-loading="dataLoading">
          <div slot="header">用户使用情况</div>
          <ve-funnel :data="funnelChartData" :settings="funnelChartSettings" :data-empty="dataEmpty" ref="funnelchart"/>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card shadow="hover"
                 class="chart" v-loading="dataLoading">
          <div slot="header">问题发表情况</div>
          <ve-line :data="quesChartData"></ve-line>
        </el-card>
      </el-col>
      
    </el-row>
    <el-row :gutter="20"
            class="index-main">
      <el-col :span="12">
        <el-card shadow="hover"
                 class="chart" v-loading="dataLoading">
          <div slot="header">文章发表情况</div>
          <ve-line :data="artChartData"></ve-line>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card shadow="hover"
                 class="chart" v-loading="dataLoading">
          <div slot="header">评论发表情况</div>
          <ve-line :data="comChartData"></ve-line>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import { reqIndexDataHeader,reqArtAna } from '../api/sysManager'
export default {
  name: 'index',
  data () {
    this.funnelChartSettings = {
        useDefaultOrder: true,
        filterZero: true
      }
    return {
      headerLoading: true,
      dataLoading: true,
      browNum: 0,
      artNum: 0,
      quesNum: 0,
      commentNum: 0,
      agreeNum: 0,
      attNum: 0,
      topicNum: 0,
      userNum: 0,
      funnelChartData: {},
      quesChartData: {},
      artChartData: {},
      comChartData: {},
      dataEmpty: true,
    }
  },
  watch: {
    funnelChartData (v) {
      this.$nextTick(_ => {
        this.$refs.funnelchart.echarts.resize()
      })
      console.info('v',v)

    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      reqIndexDataHeader().then(res => {
        if (res.resultCode == 200) {
          this.browNum = res.data.browNum
          this.artNum = res.data.artNum
          this.quesNum = res.data.quesNum
          this.commentNum = res.data.commentNum
          this.agreeNum = res.data.agreeNum
          this.attNum = res.data.attNum
          this.topicNum = res.data.topicNum
          this.userNum = res.data.userNum

          this.funnelChartData.columns= ['名称', '数值']
          this.funnelChartData.rows = [
            {'名称': '访问量', '数值': res.data.browNum},
            {'名称': '提问量', '数值': res.data.quesNum},
            {'名称': '文章量', '数值': res.data.artNum},
            // {'名称': '评论量', '数值': res.data.commentNum},
            // {'名称': '点赞量', '数值': res.data.agreeNum},
            // {'名称': '关注', '数值': res.data.attNum}
          ]
          this.funnelChartData = {
            columns: ['名称', '数值'],
            rows: [
              {'名称': '访问量', '数值': res.data.browNum},
              {'名称': '提问量', '数值': res.data.quesNum},
              {'名称': '文章量', '数值': res.data.artNum},
              {'名称': '评论量', '数值': res.data.commentNum},
              {'名称': '点赞量', '数值': res.data.agreeNum},
              {'名称': '关注', '数值': res.data.attNum}
            ]
          }
        }
        this.dataEmpty = false
        this.headerLoading = false
        this.$refs.funnelchart.echarts.resize()
      })

      reqArtAna().then(res => {
        if (res.resultCode == 200) {
          this.quesChartData = {
            columns: ['日期', '发布数量',],
            rows: []
          }
          this.quesChartData.rows = res.data.quesAna.map(i => {
            let obj = {
              '日期': i.dateString,
              '发布数量': i.count
            }
            return obj
          })
          this.artChartData = {
            columns: ['日期', '发布数量',],
            rows: []
          }
          this.artChartData.rows = res.data.artAna.map(i => {
            let obj = {
              '日期': i.dateString,
              '发布数量': i.count
            }
            return obj
          })
          this.comChartData = {
            columns: ['日期', '发布数量',],
            rows: []
          }
          this.comChartData.rows = res.data.comAna.map(i => {
            let obj = {
              '日期': i.dateString,
              '发布数量': i.count
            }
            return obj
          })

          this.dataLoading = false
        }


      })
    },
  }
}
</script>

<style lang="scss">
.index {
  min-width: 700px;
  height: 100%;
  padding: 0 20px;
  .index-header {
    margin-top: 20px;
    .header-data {
      color: #797979;
      i {
        font-size: 20px;
      }
      .data-text {
        font-size: 20px;
        margin-left: 5px;
      }
      .data-num {
        margin-left: 20px;
        font-size: 30px;
        color: rgba(0, 0, 0, 0.85);
      }
    }
  }
  .index-main {
    .chart {
      min-height: 300px;
      margin-top: 20px;
    }
  }
}
</style>
