<template>
  <div>
    <div class="title">
      <el-breadcrumb class="titleFont">
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house" />图书管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="BookBorrow">
      <el-card>
        <!-- <div class="creaBook"><el-button>新增图书</el-button></div> -->
        <div class="createBook">
          <el-button type="primary" class="createBut" @click="dialogFormVisible = true">新增图书</el-button>
        </div>
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
          <el-table-column prop="stock"
                           label="库存">
          </el-table-column>
          <el-table-column prop="opera"
                           label="操作">
                           <el-button type="text">编辑</el-button>
                            <el-divider direction="vertical"></el-divider>
                           <el-button type="text">删除</el-button>
          </el-table-column>
        </el-table>
        <div class="Pagination">
          <el-pagination
                          @size-change="handleSizeChange"
                          @current-change="handleCurrentChange"
                          :current-page="currentPage4"
                          :page-sizes="[10, 20, 30, 40]"
                          :page-size="10"
                          :data="tableData.slice((pageIndex-1)*pageSize,pageIndex*pageSize)"
                          layout="total, sizes, prev, pager, next, jumper"
                          :total="40">
          </el-pagination>
        </div>
      </el-card>
    </div>
    <div class="footer">Copyright ©2016-2019 厦门理工学院 版权所有</div>
    <el-dialog title="编辑图书" width="450px" :visible.sync="dialogFormVisible">
              <el-form  label-width="80px" style="width:100%;padding:20px;">
                <el-form-item label="图书名称" >
                  <el-input
                    id="BookName"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入图书名称"
                  ></el-input>
                </el-form-item>
                <el-form-item label="出版社" >
                  <el-input
                    id="Publisher"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入出版社"
                  ></el-input>
                </el-form-item>
                <el-form-item label="作者" >
                  <el-input
                    id="Author"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入作者"
                  ></el-input>
                </el-form-item>
                <el-form-item label="库存" >
                  <el-input
                    id="Stock"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入库存"
                  ></el-input>
                </el-form-item><el-divider></el-divider>
              </el-form>
              
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">保 存</el-button>
              </div>
            </el-dialog>
  </div>
</template>

<script>
import {reqBookInfo} from '../api/home'
export default {
  name: 'BookManage',
  data () {
    return {
      input: '',
      tableData: [],
      currentPage4: 4,
      dialogFormVisible: true
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
    },
    
  },
}
</script>

<style lang="scss">
.BookBorrow {
  min-width: 1000px;
  margin: 20px 20px;
  .createBook{
    height: 40px;
    float: left;
    .createBut{
      padding: 5px 10px;
      margin-left: 10px;
      float: left;
    }
  }
  .searchBook{
    height: 40px;
    float: right;
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
    margin-bottom: 15px;
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
.dialog-footer{
  margin-top: -30px;
}
</style>
