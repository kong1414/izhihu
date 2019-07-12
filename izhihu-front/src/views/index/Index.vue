<template>
  <el-container class="index">
    <el-main>
      <el-card class="index-crad"
               :body-style="{ padding: '0px 20px 20px' }">
        <el-tabs v-model="activeName"
                 @tab-click="handleClick">
          <el-tab-pane label="推荐"
                       name="first">
            <ul v-infinite-scroll="load" infinite-scroll-delay="100" infinite-scroll-distance="-500">
              <li v-for="(item, index) in remList" :key="index">
                <!-- {{item}} -->
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
              </li>
            </ul>
            
          </el-tab-pane>
          <el-tab-pane label="关注"
                       name="second">
            <div v-if="attList.length<=0">暂无数据</div>
            <div v-else>
              <div  v-for="(item, index) in attList" :key="index">
                <!-- {{item}} -->
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
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="热榜"
                       name="third">
            <hot-list></hot-list>
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-main>
    <el-aside width="300px"
              style="min-height:200px">
      <aside-write></aside-write>
      <aside-category></aside-category>
      <aside-nav-list></aside-nav-list>
      <aside-footer></aside-footer>
    </el-aside>
  </el-container>
</template>

<script>
import { reqRecommend, reqAttContetn } from '../../api/home'
import AsideWrite from '../../components/aside/AsideWrite.vue'
import AsideCategory from '../../components/aside/AsideCategory.vue'
import AsideFooter from '../../components/aside/AsideFooter.vue'
import HotList from '../../components/index/HotList'
import AsideNavList from '../../components/aside/AsideNavList.vue'
import RecommendItem from '../../components/index/RecommendItem'
import AnswerItem from '../../components/index/AnswerItem'

export default {
  name: 'index',
  components: {
    AsideWrite,
    AsideCategory,
    AsideFooter,
    HotList,
    AsideNavList,
    RecommendItem,
    AnswerItem
  },
  data () {
    return {
      activeName: 'first',
      remList: [],
      attList: [],
    }
  },
  mounted () {
    this._loadData()
    this._loadReData()
  },
  methods: {
    _loadData() {
      let params = 'userId=' + this.$store.state.user.userId
      reqAttContetn(params).then(res => {
        if (res.resultCode == 200 ) {
          console.info(res.data)
          // this.attList = res.data

          // 去重
          let obj = {};
          this.attList = res.data.reduce((cur,next) => {
              obj[next.article_id] ? "" : obj[next.article_id] = true && cur.push(next);
              return cur;
          },[])
        }
      })
    },
    _loadReData () {
      reqRecommend().then(res => {
        if (res.resultCode == 200) {
          this.remList = res.data
        }
      })
    },
    handleClick (v) {
      console.info(v)
    },
    load () {
      // this._loadReData()
      console.info('load')
      reqRecommend().then(res => {
        if (res.resultCode == 200) {
          res.data.forEach(i => {
            this.remList.push(i)
          })
        }
      })
    }
  }  
}
</script>

<style lang="scss">
.index {
  .el-main {
    .index-crad {
      .el-tabs {
        padding-top: 0px;
        .el-tabs__item {
          font-weight: 500;
          font-size: 16px;
          height: 56px;
          line-height: 56px;
        }
        .el-tabs__item + .is-active {
          font-weight: 500;
          color: #0084ff;
          font-size: 16px;
        }
        .el-tabs__active-bar {
          border-bottom: none;
        }
      }
    }
  }
}
</style>
