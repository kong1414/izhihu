<template>
  <div>
    <div class="title">
      <el-breadcrumb class="titleFont">
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house" />我的借阅</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="myBorrow">
      <el-card style="  padding-bottom: 20px;">
        <!-- <div class="creaBook"><el-button>新增图书</el-button></div> -->
        <div class="searchBook">
          <span>图书名称：</span>
          <el-input v-model="input"
                    placeholder="输入图书名称查询"
                    class="searchInput"></el-input>
          <el-button type="primary"
                     class="searchBut">搜索</el-button>
        </div>
        <el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  style="width: 100%;min-height:500px">
          <el-table-column prop="name"
                           label="图书名称"
                           width="180">
          </el-table-column>
          <el-table-column prop="publisher"
                           label="出版社"
                           width="180">
          </el-table-column>
          <el-table-column prop="author"
                           label="作者">
          </el-table-column>
          <el-table-column prop="create_time"
                           label="借阅时间">
          </el-table-column>
          <el-table-column prop="return_time"
                           label="归还时间">
          </el-table-column>
          <el-table-column prop="opera"
                           label="操作">
            <el-button type="text">归还</el-button>
          </el-table-column>
        </el-table>
        <div class="Pagination">
          <el-pagination @size-change="handleSizeChange"
                         @current-change="handleCurrentChange"
                         :current-page="currentPage"
                         :page-sizes="[10, 20, 30, 40]"
                         :page-size="pagesize"
                         layout="total, sizes, prev, pager, next, jumper"
                         :total="parseInt(tableData.length)">
          </el-pagination>
        </div>
      </el-card>
    </div>
    <div class="footer">Copyright ©2016-2019 厦门理工学院 版权所有</div>
  </div>
</template>

<script>
import { reqMyRecordList } from '../api/home'
export default {
  name: 'myBorrow',
  data () {
    return {
      input: '',
      tableData: [],
      pagesize: 10,
      currentPage: 1
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      let params = 'userId=' + this.$store.state.user.id
      reqMyRecordList(params).then(res => {
        if (res.resultCode == 200) {
          console.info(res.data)
          res.data.forEach(element => {
            element.create_time = element.create_time.substr(0, 10);
            element.return_time = element.create_time.substr(0, 10);
          });
          this.tableData = res.data
        }
      })
    },
    search () {
      this._loadData()
    },
    handleSizeChange (val) {
      this.pagesize = val
    },
    handleCurrentChange () {
      this.currentPage = val
    },

  },
}
</script>

<style lang="scss">
.myBorrow {
  min-width: 1000px;
  margin: 20px 20px;
  .searchBook {
    height: 40px;
    float: left;
    .searchBut {
      padding: 5px 10px;
      margin-left: 10px;
    }
    .el-input__inner {
      height: 25px;
    }
    .searchInput {
      width: 250px;
    }
  }
  .Pagination {
    float: right;
    margin-top: 30px;
  }
}
.title {
  background: white;
  width: 1223px;
  height: 40px;
  .titleFont {
    padding-top: 13px;
    padding-left: 10px;
  }
}
.footer {
  text-align: center;
  margin-bottom: 10px;
}
</style>
