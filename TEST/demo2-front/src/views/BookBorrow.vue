<template>
  <div>
    <div class="title">
      <el-breadcrumb class="titleFont">
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house"/>图书借阅</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="BookBorrow">
      <el-card>
        <div>
          <!-- <div class="creaBook"><el-button>新增图书</el-button></div> -->
          <div class="searchBook">
            <div><span>图书名称:</span></div>
            <div><el-input placeholder="请输入图书室名称查询" style="width:200px;" v-model="input"></el-input></div>
            <div><el-button type="primary">查询</el-button></div>
          </div>
        </div>
        <div>
          <el-table
            :data="tableData"
            style="width: 100%">
            <el-table-column
              prop="bookName"
              label="图书名称"
              width="180">
            </el-table-column>
            <el-table-column
              prop="published"
              label="出版社"
              width="180">
            </el-table-column>
            <el-table-column
              prop="author"
              label="作者">
            </el-table-column>
            <el-table-column
              prop="stoke"
              label="库存">
            </el-table-column>
            <el-table-column
              prop="opera"
              label="操作">
            </el-table-column>
          </el-table>
        </div>
        <div class="Pagination">
          <el-pagination
            background
            layout="prev, pager, next"
            :total="100">
          </el-pagination>
        </div>
      </el-card>
    </div>
    <div class="footer">厦门理工学院版权所有</div>
  </div>
</template>

<script>
export default {
  name: 'BookBorrow',
  data () {
    return {
      input:'',
      tableData: [{
            bookName: '2016-05-02',
            published: '王小虎',
            author: '上海市普陀区金沙江路 1518 弄',
            stoke:'123',
            opera:'123'
          },{
            bookName: '2016-05-02',
            published: '王小虎',
            author: '上海市普陀区金沙江路 1518 弄',
            stoke:'123',
            opera:'123'
          },{
            bookName: '2016-05-02',
            published: '王小虎',
            author: '上海市普陀区金沙江路 1518 弄',
            stoke:'123',
            opera:'123'
          },{
            bookName: '2016-05-02',
            published: '王小虎',
            author: '上海市普陀区金沙江路 1518 弄',
            stoke:'123',
            opera:'123'
          }]
        }
      }
    }
</script>

<style lang="scss">
.BookBorrow{
  margin: 40px 0px;
  .searchBook{
     display: inline;
     margin-bottom: 20px;
     div{
       display: inline;
     }
  }
  .Pagination{
    float:right;
    margin-top: 20px;
  }
}
.title{
  background: white;
  width: 1223px;
  height: 40px;
  margin: -20px -20px;
  .titleFont{
    padding-top: 13px;
    padding-left: 10px;
  }
}
.footer{
  margin-left: 450px;
}
  

</style>
