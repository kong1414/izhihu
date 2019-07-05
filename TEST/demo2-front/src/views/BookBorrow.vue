<template>
  <div>
    <div >
      <el-breadcrumb>
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house"/>图书管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="BookBorrow">
      <el-card>
        <div>
          <div class="creaBook"><el-button>新增图书</el-button></div>
          <div class="searchBook">
            <div><span>图书名称:</span></div>
            <div><el-input></el-input></div>
            <div><el-button>查询</el-button></div>
          </div>
        </div>
        <div>
          <el-table
            :data="tableData"
            style="width: 100%">
            <el-table-column
              prop="date"
              label="日期"
              width="180">
            </el-table-column>
            <el-table-column
              prop="name"
              label="姓名"
              width="180">
            </el-table-column>
            <el-table-column
              prop="address"
              label="地址">
            </el-table-column>
          </el-table>
        </div>
        <div>
          <el-pagination
            background
            layout="prev, pager, next"
            :total="1000">
          </el-pagination>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookBorrow',
  data () {
    return {
          tableData: [{
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1517 弄'
          }, {
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄'
          }, {
            date: '2016-05-03',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1516 弄'
          }]
        }
      }
    }
</script>

<style lang="scss">
.BookBorrow{
  .creaBook{
    float: left;
  }
  .searchBook{
    float: right;
  }
}
  

</style>
