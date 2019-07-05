<template>
  <div>
    <div >
      <el-breadcrumb>
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house"/>借阅历史</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="BorrowHistory">
      <el-card>
        <div>
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
              prop="bookname"
              label="图书名称"
              width="420">
            </el-table-column>
             <el-table-column
              prop="address"
              label="出版社"
              width="250">
            </el-table-column>
            <el-table-column
              prop="author"
              label="作者"
              width="190">
            </el-table-column>
            <el-table-column
              prop="number"
              label="借阅人学号"
              width="230">
            </el-table-column>
            <el-table-column
              prop="name"
              label="借阅人姓名"
              width="190">
            </el-table-column>
            <el-table-column
              prop="borrowdate"
              label="借阅时间"
              width="200">
            </el-table-column>
            <el-table-column
              prop="returndate"
              label="归还时间"
              width="200">
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
  name: 'BorrowHistory',
  data () {
    return {
          tableData: [{
            bookname: '图书名称1',
            address: '出版社1',
            author: '作者1',
            number: '1607052130',
            name: '王大大',
            borrowdate: '2019-06-18',
            returndate: '2020-06-18'
          },
          {
            bookname: '图书名称1',
            address: '出版社1',
            author: '作者1',
            number: '1607052130',
            name: '王大大',
            borrowdate: '2019-06-18',
            returndate: '2020-06-18'
          },
          {
            bookname: '图书名称1',
            address: '出版社1',
            author: '作者1',
            number: '1607052130',
            name: '王大大',
            borrowdate: '2019-06-18',
            returndate: '2020-06-18'
          }
          ]
        }
      }
    }
</script>

<style lang="scss">
.BorrowHistory{

  .searchBook{
    float: left;
  }
}
  

</style>
