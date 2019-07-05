<template>
  <!-- 我的收藏页 -->
  <div class="aside-colletcion">
    <el-card class="colletcion-card">
      <el-row>
        <div class="list">
          <div class="above" style="margin-left:-20px;">
            <div>
              <el-button type="text">
                <i class="el-icon-collection-tag" />
                <span>我的收藏</span>
              </el-button>
            </div>
            <div>
              <el-button type="text">
                <i class="el-icon-folder-checked" />
                <span>我关注的问题</span>
              </el-button>
            </div>
            <div>
              <el-button type="text">
                <i class="el-icon-document" />
                <span>邀请我回答的问题</span>
              </el-button>
            </div>
          </div>
        </div>
      </el-row>
    </el-card>
    <el-card class="colletcion-card">
      <el-row>
        <div class="list">
          <div class="above" style="margin-left:-20px;">
            <div>
              <el-button type="text">
                <i class="el-icon-s-home" />
                <span>社区服务中心</span>
              </el-button>
            </div>
            <div>
              <el-button type="text">
                <i class="el-icon-s-management" />
                <span>版权服务中心</span>
              </el-button>
            </div>
          </div>
        </div>
      </el-row>
    </el-card>
    <el-card class="colletcion-card">
      <el-row>
        <div class="list">
          <div>
            <!-- Form -->
            <div class="above">
              <div style="margin-left:-40px;">
                <el-button type="text" @click="dialogFormVisible = true">+创建收藏夹</el-button>
              </div>
            </div>
            <el-dialog title="创建收藏夹" width="600px" :visible.sync="dialogFormVisible">
              <el-form :model="form" label-width="60px" style="width:100%;padding:20px;">
                <el-form-item label="标题" style="margin-left:-35px;">
                  <el-input
                    v-model="form.name"
                    id="inTitle"
                    autocomplete="off"
                    placeholder="最多输入20字"
                  ></el-input>
                </el-form-item>
                <el-form-item label="描述" style="margin-left:-35px;">
                  <el-input
                    v-model="form.detail"
                    id="inDetail"
                    autocomplete="off"
                    placeholder="最多输入20字"
                  ></el-input>
                </el-form-item>
                <div class="choiArea">
                  <el-radio v-model="radioOC" label="1">
                    <span class="choiFont">公开</span>
                    <span class="detailFont">收藏夹关注者 > 0 时不能设置为私密</span>
                  </el-radio>
                </div>
                <div class="choiArea">
                  <el-radio v-model="radioOC" label="2">
                    <span class="choiFont">私密</span>
                    <span class="detailFont">只有你可以查看这个收藏夹</span>
                  </el-radio>
                </div>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
              </div>
            </el-dialog>
          </div>
        </div>
      </el-row>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "asideCollection",
  methods: {
    // 弹窗备选方法，只是不知道怎么改成两个输入框.....
    // open() {
    //   this.$prompt('标题', '创建新收藏夹', {
    //     confirmButtonText: '确定',
    //     cancelButtonText: '取消',
    //     // inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
    //     // inputErrorMessage: '收藏夹名称不正确'
    //   }).then(({ value }) => {
    //     this.$message({
    //       type: 'success',
    //       message: '你创建的收藏夹是: ' + value
    //     });
    //   }).catch(() => {
    //     this.$message({
    //       type: 'info',
    //       message: '取消输入'
    //     });
    //   });
    // }
  },
  data() {
    return {
      dialogFormVisible: false,
      form: {
        name: "",
        detail: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      },
      radioOC: "1"
    };
  }
};
</script>
<style lang="scss">
.aside-colletcion {
  margin-top: 20px;
  .colletcion-card {
    margin-top: 20px;
    text-align: center;
    .el-card__body {
      padding: 10px 0px;
    }
    .colletcion-button {
      text-align: center;
      i {
        margin: 6px;
        font-size: 30px;
      }
    }
    .el-divider {
      margin: 5px 0;
    }
    .list {
      text-align: left;
      span {
        color: #76839b;
      }
      i {
        font-size: 17px;
      }
      div {
        padding-left: 20px;
      }
      .above {
        div:hover {
          background: #f6f6f6;
          span {
            color: #7abce7;
          }
        }
      }
    }
    .choiFont {
      font-size: 15px;
      font-weight: bold;
    }
    .detailFont {
      font-size: 13px;
      margin-left: 5px;
    }
    .choiArea {
      margin-top: 10px;
      margin-left: 50px;
    }
  }
}
</style>
