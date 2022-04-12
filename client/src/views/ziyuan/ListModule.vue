<template>
  <div>
    <el-table
      :data="tableData"
      border
      stripe
      height="500"
      style="width: 100%"
      ref="multipleTableRef"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column prop="date" label="Date" width="180" />
      <el-table-column prop="name" label="Name" width="180" />
      <el-table-column prop="address" label="Address" />
    </el-table>

    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="Tabletotal"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
export default {
  setup() {
    const multipleSelection = ref([]);
    const pageSize = ref(5);

    const currentPage = ref(1);

    const tableDataTotal = [
      {
        date: "2016-05-03",
        name: "Tom",
        address: "No. 189, Grove St, Los Angeles",
      },
      {
        date: "2016-05-02",
        name: "Tom",
        address: "No. 189, Grove St, Los Angeles",
      },
      {
        date: "2016-05-04",
        name: "Tom",
        address: "No. 189, Grove St, Los Angeles",
      },
      {
        date: "2016-05-01",
        name: "Tom",
        address: "No. 189, Grove St, Los Angeles",
      },
      {
        date: "2016-05-08",
        name: "Tom",
        address: "No. 189, Grove St, Los Angeles",
      },
      {
        date: "2016-05-06",
        name: "Tom",
        address: "No. 189, Grove St, Los Angeles",
      },
      {
        date: "2016-05-07",
        name: "Tom",
        address: "No. 189, Grove St, Los Angeles",
      },
    ];
    const Tabletotal = ref(tableDataTotal.length);

    // console.log((currentPage.value-1)*pageSize.value,currentPage.value+pageSize.value-1);
    const tableData = ref(tableDataTotal.slice(0, pageSize.value));

    const handleCurrentChange = (val) => {
      currentPage.value = val;
      // console.log(currentPage.value,val);
      console.log(  (currentPage.value - 1) * pageSize.value,
        (currentPage.value - 1) * pageSize.value + pageSize.value );
      tableData.value = tableDataTotal.slice(
        (currentPage.value - 1) * pageSize.value,
        (currentPage.value - 1) * pageSize.value + pageSize.value
      );
    };
    const handleSizeChange = (val) => {
        pageSize.value  = val;
      tableData.value = tableDataTotal.slice(0, pageSize.value);
        currentPage.value = 1;
      console.log(`每页 ${val} 条`);
    };
    const handleSelectionChange = (val) => {
      multipleSelection.value = val;
      console.log(multipleSelection, val);
    };

    return {
      pageSize,
      tableData,
      currentPage,
      Tabletotal,
      multipleSelection,
      handleSizeChange,
      handleSelectionChange,
      handleCurrentChange,
    };
  },
};
</script>

<style lang="scss" scoped>
div {
  //   height: 100%;
  //   background-color: aqua;
}
</style>
