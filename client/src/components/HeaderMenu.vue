<template>
  <div class="horizontal-menu">
      <!-- <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
      >  -->
      <el-menu
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
      >
        <el-menu-item index="1">
          <i :class="`el-icon-lx-homefill`"></i
        ></el-menu-item>
        <el-menu-item index="2">考试</el-menu-item>
        <el-menu-item index="3">培训</el-menu-item>
        <el-menu-item index="4">资源</el-menu-item>
        <el-menu-item index="5">分析</el-menu-item>
        <el-menu-item index="6">
          <el-dropdown
            class="user-name"
            trigger="click"
            @command="handleCommand"
          >
            <span class="el-dropdown-link">
              <i :class="`el-icon-lx-sort`"></i>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <a
                  href="https://github.com/lin-xin/vue-manage-system"
                  target="_blank"
                >
                  <el-dropdown-item>项目仓库</el-dropdown-item>
                </a>
                <el-dropdown-item command="user">个人中心</el-dropdown-item>
                <el-dropdown-item divided command="loginout"
                  >退出登录</el-dropdown-item
                >
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </el-menu-item>
      </el-menu>
    </div>

</template>

<script>
import { computed, watch , onMounted} from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
export default {
  setup() {
  const activeIndex = 1;
   
  const router = useRouter();
  // 下拉菜单选择事件
  const handleCommand = (command)=>{
    console.log(command);
    //  router.push("/user");
  }
    const store = useStore();
    const handleSelect = (key, keyPath) => {
     
      switch (key) {
        case '1':
          store.commit("clearTags");
          router.push("/")
         break;
        case '2':
          store.commit("clearTags");
          router.push("/test")
         break;
          case '3':
            store.commit("clearTags");
          router.push("/peixun")
         break;
        default:
        console.log(key, keyPath)
          break;
      }
      // console.log(key,store.state.numberArray,80);
// console.log(store.state.tagsList);
  };
    return {
      activeIndex,
      handleSelect,
      handleCommand
    };
  },
};
</script>

<style scoped>
.user-name {
  margin-left: 10px;
}
.horizontal-menu {
  display: inline-block;
}
.horizontal-menu ul {
  border: 0px;
  height: 70px;
  background-color: transparent;
}
.horizontal-menu ul li {
  height: 100%;
  color: #fff;
  background-color: transparent;
}
.horizontal-menu li i {
  font-size: 28px;
}
.horizontal-menu .el-menu--horizontal > .el-menu-item.is-active {
  border: 0px;
  color: aliceblue;
  background-color: #334360;
}
</style>
