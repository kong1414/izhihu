<template>
   <!-- 我的收藏页 -->
  <div class="aside-colletcion">
    <el-card class="colletcion-card">
      <el-row>
        <div class="list">
          <div>
            <el-button type="text">
              <i class="el-icon-collection-tag"/>
              <span>我的收藏</span>
            </el-button>
          </div>
          <div>
            <el-button type="text">
              <i class="el-icon-folder-checked"/>
              <span>我关注的问题</span>
            </el-button>
          </div>
          <div>
            <el-button type="text">
              <i class="el-icon-document"/>
              <span>邀请我回答的问题</span>
            </el-button>
          </div>
        </div>
      </el-row>
    </el-card>
    <el-card class="colletcion-card">
      <el-row>
        <div class="list">
          <div>
            <el-button type="text">
              <i class="el-icon-s-home"/>
              <span>社区服务中心</span>
            </el-button>
          </div>
          <div>
            <el-button type="text">
              <i class="el-icon-s-management"/>
              <span>版权服务中心</span>
            </el-button>
          </div>
        </div>
      </el-row>
    </el-card>
    <el-card class="colletcion-card">
      <el-row>
        <div class="list">
          <div>
            <el-button type="text">
              <span>+创建收藏夹</span>
            </el-button>
          </div>
        </div>
      </el-row>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'asideCollection'  
}
</script>
<style lang="scss">
.aside-colletcion {
  margin-top: 20px;
  .colletcion-card {  
    margin-top: 10px;
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
      i{
        font-size: 17px;
      }
      div {
        padding-left: 20px;
      }
      div:hover{
        background: #f6f6f6;
        span{color: #7abce7;}
      }

    }
  }
}
</style>

