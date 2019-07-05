<template>
  <div>
    <div class="title">
      <el-breadcrumb class="titleFont">
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house" />图书借阅</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="BookBorrow">
      <el-card>
        <!-- <div class="creaBook"><el-button>新增图书</el-button></div> -->
        <div class="searchBook">
        </div>
        <el-table :data="tableData"
                  style="width: 100%">
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
          <el-table-column prop="stock"
                           label="库存">
          </el-table-column>
          <el-table-column prop="opera"
                           label="操作">
                           <el-button type="text">借阅</el-button>
          </el-table-column>
        </el-table>
        <div class="Pagination">
          <el-pagination background
                         layout="prev, pager, next"
                         :total="100">
          </el-pagination>
        </div>
      </el-card>
    </div>
    <div class="footer">Copyright ©2016-2019 厦门理工学院 版权所有</div>
  </div>
</template>

<script>
import {reqBookInfo} from '../api/home'
export default {
  name: 'BookBorrow',
  data () {
    return {
      input: '',
      tableData: []
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData() {
      let params = 'keyword=' + this.input
      reqBookInfo(params).then(res=>{
        if (res.resultCode==200) {
          console.info(res.data)
          this.tableData = res.data
        }
      })
    },
    search () {
      this._loadData()
    }
    
  },
}
</script>

<style lang="scss">
.BookBorrow {
  min-width: 1000px;
  margin: 20px 20px;
  .searchBook{
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
  margin-left: 450px;
}
</style>
