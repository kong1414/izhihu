<template>
  <div>
    <div class="title">
      <el-breadcrumb class="titleFont">
        <el-breadcrumb-item :to="{ path: '/' }"><i class="el-icon-house" />图书管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="BookManage">
      <el-card>
        <!-- <div class="creaBook"><el-button>新增图书</el-button></div> -->
        <div class="createBook">
          <el-button type="primary"
                     class="createBut" @click="createbook">{{title}}</el-button>
        </div>
        <div class="searchBook">
          <span>图书名称：</span>
          <el-input v-model="input"
                    placeholder="输入图书名称查询"
                    class="searchInput"></el-input>
          <el-button type="primary"
                     class="searchBut" @click="search">搜索</el-button>
        </div>
        <el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  style="width: 100%;min-height:500px;">
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
            <template slot-scope="scope">
              <el-button type="text"
                       @click="updatebook(scope.$index, scope.row)">编辑</el-button>
              <el-divider direction="vertical"></el-divider>
              <el-button type="text" @click="delbook(scope.$index, scope.row)">删除</el-button>
            </template>
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
    <el-dialog title="编辑图书"
               width="450px"
               :visible.sync="dialogFormVisible">
      <el-form label-width="80px"
               style="width:100%;padding:20px;">
        <el-form-item label="图书名称">
          <el-input id="BookName"
                    v-model="from.name"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入图书名称"></el-input>
        </el-form-item>
        <el-form-item label="出版社">
          <el-input id="Publisher"
                    v-model="from.publisher"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入出版社"></el-input>
        </el-form-item>
        <el-form-item label="作者">
          <el-input id="Author"
                    v-model="from.author"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入作者"></el-input>
        </el-form-item>
        <el-form-item label="库存">
          <el-input id="Stock"
                    v-model="from.stock"
                    autocomplete="off"
                    style="width:300px;"
                    placeholder="请输入库存"></el-input>
        </el-form-item>
        <el-divider></el-divider>
      </el-form>

      <div slot="footer"
           class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary"
                   @click="updataCreate">保 存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { reqBookInfo,reqBookcreate, reqBookupdate, reqBookdel } from '../api/home'
import { Message } from '_element-ui@2.10.1@element-ui';
import { fips } from 'crypto';
export default {
  name: 'BookManage',
  data () {
    return {
      input: '',
      tableData: [],
      pagesize: 10,
      currentPage: 1,
      dialogFormVisible: false,
      from: {
        name: '',
        publisher: '',
        author: '',
        stock: 0
      },
      title: '新增图书'
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      let params = 'keyword=' + this.input
      reqBookInfo(params).then(res => {
        if (res.resultCode == 200) {
          console.info(res.data)
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
    updatebook (index, row) {
      this.from = row
      this.dialogFormVisible = true
      this.title='编辑图书'
    },
    delbook (index, row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let params = 'id=' + row.id
          reqBookdel(params).then(res =>{
            if (res.resultCode ==200) {
              this.$message({
                type:'success',
                message: res.resultMessage
              })
              this._loadData()
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      
    },
    createbook () {
      this.dialogFormVisible = true
      this.title='新增图书'
    },
    updataCreate () {
      if (this.title=='新增图书') {
        let params = {
          name: this.from.name,
          publisher: this.from.publisher,
          author: this.from.author,
          stock: this.from.stock
        }
        reqBookcreate(params).then(res => {
          if (res.resultCode ==200) {
            this.$message({
              type:'success',
              message: res.resultMessage
            })
            this.from = {}
            this.dialogFormVisible = false
            this._loadData()
          }
        })
      } else if (this.title=='编辑图书') {

        let params = {
          id: this.from.id,
          name: this.from.name,
          publisher: this.from.publisher,
          author: this.from.author,
          stock: this.from.stock
        }
        reqBookupdate(params).then(res => {
          if (res.resultCode ==200) {
            this.$message({
              type:'success',
              message: res.resultMessage
            })
            this.from = {}
            this.dialogFormVisible = false
            this._loadData()
          }
        })
      }
    }
  },
}
</script>

<style lang="scss">
.BookManage {
  min-width: 1000px;
  margin: 20px 20px;
  .createBook {
    height: 40px;
    float: left;
    .createBut {
      padding: 5px 10px;
      margin-left: 10px;
      float: left;
    }
  }
  .searchBook {
    height: 40px;
    float: right;
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
.dialog-footer {
  margin-top: -30px;
}
</style>
