<template>
  <div>
    <div class="title">
      <el-breadcrumb class="titleFont">
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house" />借阅历史</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="BookBorrow">
      <el-card>
        <!-- <div class="creaBook"><el-button>新增图书</el-button></div> -->
        <div class="searchBook">
          <span>图书名称：</span>
          <el-input v-model="input" placeholder="输入图书名称查询" class="searchInput"></el-input>
          <el-button type="primary" class="searchBut">搜索</el-button>
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
          <el-table-column prop="user_id"
                           label="借阅人学号">
          </el-table-column>
          <el-table-column prop="name_0"
                           label="借阅人姓名">
          </el-table-column>
          <el-table-column prop="create_time"
                           label="借阅时间">
          </el-table-column>
          <el-table-column prop="return_time"
                           label="归还时间">
          </el-table-column>
        </el-table>
        <div class="Pagination">
          <el-pagination background
                         :data="tableData.slice((pageIndex-1)*pageSize,pageIndex*pageSize)"
                         layout="prev, pager, next"
                         :total="50">
          </el-pagination>
        </div>
      </el-card>
    </div>
    <div class="footer">Copyright ©2016-2019 厦门理工学院 版权所有</div>
  </div>
</template>

<script>
import {reqMyRecordList} from '../api/home'
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
      let params = 'userId=10001'
      reqMyRecordList(params).then(res=>{
        if (res.resultCode==200) {
          console.info(res.data)
          res.data.forEach(element => {
            element.create_time = element.create_time.substr(0,10);
            element.return_time = element.return_time.substr(0,10);
          });
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
    height: 40px;
    .searchBut{
      padding: 5px 10px;
      margin-left: 10px;
    }
    .el-input__inner{
      height: 25px;
    }
    .searchInput{
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
