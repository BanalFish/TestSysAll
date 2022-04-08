<template>
  <div class="sidebar">
    <div>
      <h1>
      资源

      </h1>
    </div>
    <el-menu
      class="sidebar-el-menu"
      :default-active="onRoutes"
      :collapse="collapse"
      background-color="#324157"
      text-color="#bfcbd9"
      active-text-color="#20a0ff"
      unique-opened
      router
    >
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template #title>
              <i :class="item.icon"></i>
              <span>{{ item.title }}</span>
            </template>
            <template v-for="subItem in item.subs">
              <el-submenu
                v-if="subItem.subs"
                :index="subItem.index"
                :key="subItem.index"
              >
                <template #title>{{ subItem.title }}</template>
                <el-menu-item
                  v-for="(threeItem, i) in subItem.subs"
                  :key="i"
                  :index="threeItem.index"
                >
                  {{ threeItem.title }}</el-menu-item
                >
              </el-submenu>
              <el-menu-item v-else :index="subItem.index" :key="subItem.index"
                >{{ subItem.title }}
              </el-menu-item>
            </template>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i>
            <template #title>{{ item.title }}</template>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
import { computed, watch ,onUpdated} from "vue";
import { useStore } from "vuex";
import { useRoute } from "vue-router";
export default {
  setup() {
    
  
    const  items= [
     
      
      {
        icon: "el-icon-pie-chart",
        index: "/ziyuan/shitiku",
        title: "试题库",
      },
     {
        icon: "el-icon-lx-emoji",
        index: "/ziyuan/exammanage",
        title: "考生管理",
      },
    ];
    const store = useStore();
    const route = useRoute();
   
    const onRoutes = computed(() => {
      // console.log(route.path,route.path.slice(1,5),150);
      return route.path;
    });

    const collapse = computed(() => store.state.collapse);

    return {
      items,
      onRoutes,
      collapse,
    };
  },
};
</script>

<style scoped lang='scss'>
.sidebar {
  display: block;
  position: absolute;
  left: 0;
  /* top: 70px; */
  top: 0px;
  bottom: 0;
  overflow-y: scroll;
  h1 {
    font-size: 16px;
    padding: 20px 20px;
    border-bottom: 1px solid #10141b;
    color: rgb(191, 203, 217);
  background-color: #324157;
  }
}
.sidebar::-webkit-scrollbar {
  width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
  width: 250px;
}
.sidebar > ul {
  height: 100%;
}
</style>
