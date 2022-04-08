<template>
  <div>
    <div class="resource-right-topbox">
      <h1>试题库</h1>
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="列表模式" name="first"><ListModule /> </el-tab-pane>
        <el-tab-pane label="预览模式" name="second"
          ><reviewModule
        /></el-tab-pane>
      </el-tabs>
      <div class="ziyuan-search">
        <div class="content">
          <div style="display: flex">
            <div class="ziyuan-input-left">
              <el-input
                placeholder="请输入内容"
                v-model="input3"
                class="input-with-select"
              >
                <!-- 
              vue3 slot写法报错
              解决思路：solt的新写法
              在外层包一层template -->

                <template v-slot:prepend>
                  <!-- <el-select v-model="select" slot="prepend" placeholder="请选择"> -->
                  <el-select v-model="select" placeholder="课程分类">
                    <el-option label="语文" value="1"></el-option>
                    <el-option label="数学" value="2"></el-option>
                    <el-option label="英语" value="3"></el-option>
                  </el-select>
                </template>
                <template v-slot:append>
                  <!-- <el-button slot="append" icon="el-icon-search"></el-button> -->
                  <el-button icon="el-icon-search"></el-button>
                </template>
              </el-input>
            </div>
            <div class="ziyuan-input-right">
              <div class="ziyyuan-input-title1">难度：</div>
              <el-select v-model="select2" placeholder="全部">
                <el-option label="容易" value="1"></el-option>
                <el-option label="中等" value="2"></el-option>
                <el-option label="困难" value="3"></el-option>
              </el-select>
            </div>
          </div>

          <div style="display: flex" class="daochu">
               <el-button type="primary" @click="handleAdd" >新增试卷</el-button>
                <el-select v-model="select3" placeholder="导出" @change="optionClick(select3)">
                <el-option label="导出" value="1"  ><div>导出（Word）</div> </el-option>
                <el-option label="导出" value="2"><div>导出（Excel</div> </el-option>
                <el-option label="导出" value="3" > <div>导出（记事本）</div> </el-option>
              </el-select>
               <el-button type="info" @click="handleDelMore">批量删除</el-button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, reactive } from "vue";
import ListModule from "./ListModule.vue";
import reviewModule from "./reviewModule.vue";
export default {
  name: "basecharts",
  components: {
    ListModule,
    reviewModule,
  },
  setup() {
    const activeName = ref("first");
    const input3 = ref("");
    const select = ref("");
    const select2 = ref("");
    const select3 = ref("");
    const optionClick = (value)=>{
        console.log(123,value);
    }
    const handleClick = (tab, event) => {
      // console.log(tab, event);
    };
     const handleAdd = () => {
      console.log('点击了handleAdd');
    };
     const handleDelMore = () => {
      console.log('点击了handleDelMore');
    };
    return {
      activeName,
      input3,
      select,
      select2,
      select3,
      handleClick,
      optionClick,
      handleAdd,
      handleDelMore
    };
  },
};
</script>

<style scoped lang='scss'>
.resource-right-topbox {
  height: 30px;
  box-sizing: content-box;
  border-bottom: 1px solid #83838378;
  overflow: hidden;
  padding: 10px 0;
  h1 {
    float: left;
    font-size: 16px;
    padding: 20px 0;
    line-height: 0px;
  }

  .ziyuan-search {
    position: absolute;
    z-index: 3;
    width: 98%;
    ::v-deep .el-input-group__prepend div.el-select .el-input__inner {
      width: 110px;
    }
    .content {
        display:flex;
        justify-content:space-between
    }
    .ziyyuan-input-title1 {
      font-size: 13px;
      color: #777777;
      display: inline-block;
      margin-left: 20px;
    }
  }

  .daochu {
      width: 300px;
    justify-content: space-between;
      ::v-deep .el-select {
    width: 75px;
}
  }
  //   解决:将/deep/ 替换成::v-deep

  ::v-deep .el-tabs__nav-wrap {
    overflow: hidden;
    margin-bottom: -1px;
    position: relative;
    right: -85%;
    width: 200px;
  }

  ::v-deep .el-tabs__content {
    position: absolute;
    width: 98%;
    height: 100%;
    margin-top: 60px;
  }

  ::v-deep .el-tab-pane {
    height: 100%;
  }
  ::v-deep .el-tabs__nav-wrap::after {
    width: 0px;
  }
}
</style>