<template>
  <div class="shouye">
    <el-row type="flex" justify="center">
      <el-col :span="23">
        <div class="grid-content tou">
          <div>
            <div
              style="
                display: inline-block;
                font-size: 14px;
                display: inline-block;
                margin: 0 15px;
              "
            >
              您好,{{ name }}
            </div>
            <el-button type="primary" plain size="mini" @click="handlethis"
              >免费版,永久有效</el-button
            >
            <el-button type="primary" size="mini">立即升级</el-button>
          </div>
          <div style="margin: 0 15px">
            <el-link icon="el-icon-edit">在线咨询</el-link>
          </div>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="30" type="flex" justify="center">
      <el-col :span="17"
        ><div class="grid-content box-fast">
          <div class="card">
            <a href="">
              <span class="bgimg"></span>
              <div class="info">
                <h1>创建考试</h1>
                <p>
                  快速创建并发布在线考试<br />
                  支持三种试题组卷模式
                </p>
              </div>
            </a>
          </div>

          <div class="card">
            <a href="">
              <span class="bgimg" style="background-position-y: -60px"></span>
              <div class="info">
                <h1>创建考试</h1>
                <p>
                  快速创建并发布在线考试<br />
                  支持三种试题组卷模式
                </p>
              </div>
            </a>
          </div>
          <div class="card">
            <a href="">
              <span class="bgimg" style="background-position-y: -120px"></span>
              <div class="info">
                <h1>创建考试</h1>
                <p>
                  快速创建并发布在线考试<br />
                  支持三种试题组卷模式
                </p>
              </div>
            </a>
          </div>
          <div class="card">
            <a href="">
              <span class="bgimg" style="background-position-y: -180px"></span>
              <div class="info">
                <h1>创建考试</h1>
                <p>
                  快速创建并发布在线考试<br />
                  支持三种试题组卷模式
                </p>
              </div>
            </a>
          </div>
          <div class="card">
            <a href="">
              <span class="bgimg" style="background-position-y: -240px"></span>
              <div class="info">
                <h1>创建考试</h1>
                <p>
                  快速创建并发布在线考试<br />
                  支持三种试题组卷模式
                </p>
              </div>
            </a>
          </div>
          <div class="card">
            <a href="">
              <span class="bgimg" style="background-position-y: 60px"></span>
              <div class="info">
                <h1>创建考试</h1>
                <p>
                  快速创建并发布在线考试<br />
                  支持三种试题组卷模式
                </p>
              </div>
            </a>
          </div>
        </div>
      </el-col>

      <el-col :span="6"
        ><div class="grid-content boxBbox-right">
          <h1>考生学员登录入口</h1>
          <div class="kszx-box-02">
            <div class="kszx-ewm">
              <img
                id="imgLoginBarCode"
                src="https://e.kaoshiyun.com.cn/Resource/temp/UserCenterQRCode//考生中心二维码33263794102020.png"
              />
              <p id="lCidInfo">系统ID：<strong>379410</strong></p>
            </div>
            <div class="kszx-button">
              <a id="btnUserLoginURL" href="javascript:" class="btn-style">
                <el-button type="primary" plain size="mini"
                  ><i class="el-icon-lx-copy"></i>
                  <span>复制登录链接</span></el-button
                >
              </a>
              <a
                id="btnDownUserBarCode"
                href="../../setting#miniapp"
                class="btn-style"
                target="_blank"
              >
                <el-button type="primary" plain size="mini"
                  ><i class="fa fa-wechat" aria-hidden="true"></i
                  ><span> 微信小程序</span></el-button
                ></a
              >
              <a href="../../setting" class="btn-style">
                <el-button type="primary" plain size="mini"
                  ><i class="icon-a_operate_copy"></i
                  ><span>考生中心设置</span></el-button
                ></a
              >
            </div>
          </div>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="30" type="flex" justify="center">
      <el-col :span="17"
        ><div class="grid-content box-purple">
          <div class="data-box-left">
            <div class="Statistics-box Statistics-pdstlye" title="已使用0.0%">
              <h1>实时在线人数</h1>
              <span id="onlineUserInfo"><em>0</em>/25</span>
              <div style="margin-top: 20px">
                <el-progress :percentage="0" :format="format"></el-progress>
              </div>
            </div>
            <div class="Statistics-box Statistics-pdstlye" title="已使用4.0%">
              <h1>考生账号<a title="查看" href="../../user">查看</a></h1>
              <span id="userAccountInfo"><em>1</em>/25</span>
              <div class="progress">
                <div style="margin-top: 20px">
                  <el-progress :percentage="4" :format="format"></el-progress>
                </div>
              </div>
            </div>
          </div>

          <div class="data-box-right">
            <div class="Statistics-box02 Statistics-pdstlye02">
              <h1>昨日参加量</h1>
              <span id="dayNum"><em>1</em> /人次</span>
            </div>
            <div class="Statistics-box02 Statistics-pdstlye02">
              <h1>近一周参加量</h1>
              <span id="weekNum"><em>1</em> /人次</span>
            </div>
            <div class="Statistics-box02 Statistics-pdstlye02">
              <h1>近一月参加量</h1>
              <span id="monthNum"><em>1</em> /人次</span>
            </div>
          </div>
        </div>
      </el-col>

      <el-col :span="6"
        ><div class="grid-content tablist">
          <el-tabs v-model="activeName">
            <el-tab-pane label="系统公告" name="first">
              <ul>
                <li
                  v-for="(item, index) in items"
                  :key="index"
                  @click="handleClick(item)"
                >
                  <div>
                    <span class="item-left"> {{ item.title }}</span>
                    <span class="item-right"> {{ item.date }}</span>
                  </div>
                </li>
              </ul>
            </el-tab-pane>
            <el-tab-pane label="快速入门" name="second">
              <ul>
                <li v-for="(item, index) in items" :key="index">
                  <el-link :underline="false" type="info">{{
                    item.title
                  }}</el-link>
                </li>
              </ul>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-col>
    </el-row>

    <el-row type="flex" justify="center">
      <el-col :span="23">
        <div class="grid-content jiaocheng">
          <h1>使用教程</h1>
          <div class="content2">
            <div class="ksy-ing-box">
              <a
                target="_blank"
                href="https://www.kaoshiyun.com.cn/help/912c7b.html"
              >
              </a>
              <div class="ksy-ing-box-title">
                <a
                  target="_blank"
                  href="https://www.kaoshiyun.com.cn/help/912c7b.html"
                >
                  <span>三个步骤快速创建考试</span> </a
                ><a target="_blank" href="">
                  <span class="fr"><i class="fa fa-chevron-right"></i></span>
                </a>
              </div>
              <div class="info02">
                <p>
                  1、填写考试信息、设置考生参加方式等<br />
                  2、选择试卷类型，出题组卷<br />
                  3、考场环境设置，防作弊设置，微信设置等
                </p>
              </div>
            </div>
            <div class="ksy-ing-box">
              <a
                target="_blank"
                href="https://www.kaoshiyun.com.cn/help/044422.html"
              >
              </a>
              <div class="ksy-ing-box-title">
                <a
                  target="_blank"
                  href="https://www.kaoshiyun.com.cn/help/044422.html"
                >
                  <span>如何快速批量录入试题</span> </a
                ><a target="_blank" href="">
                  <span class="fr"><i class="fa fa-chevron-right"></i></span>
                </a>
              </div>
              <div class="info02">
                <p>
                  1、支持Excel、Word、Txt模板导入<br />2、支持多种试题类型，包括基础题型和复杂题型<br />3、方便、快速、简洁，一键批量导入试题
                </p>
              </div>
            </div>

            <div class="ksy-ing-box">
              <a
                target="_blank"
                href="https://www.kaoshiyun.com.cn/help/d13226.html"
              >
              </a>
              <div class="ksy-ing-box-title">
                <a
                  target="_blank"
                  href="https://www.kaoshiyun.com.cn/help/d13226.html"
                >
                  <span>创建一套章节练习题库</span> </a
                ><a target="_blank" href="">
                  <span class="fr"><i class="fa fa-chevron-right"></i></span>
                </a>
              </div>
              <div class="info02">
                <p>
                  1、自定义知识章节，类似驾考宝典做题<br />2、通过练习学习知识，边做边查看答案解析<br />3、自动记录错题，支持错题重做和背题模式
                </p>
              </div>
            </div>
            <a target="_blank" href="https://www.kaoshiyun.com.cn/help">
              <div class="chevron-box">更多</div>
            </a>
          </div>
        </div>
      </el-col>
    </el-row>

    <el-row type="flex" justify="center">
      <el-col :span="23">
        <!-- 这个不知道什么用 -->
        <div class="grid-content bg-purple-dark">
          <div class="row no-gutters boxC-stely pdt20">
            <div id="divContainer" data-highcharts-chart="0">
              <div
                class="highcharts-container"
                id="highcharts-0"
                style="
                  position: relative;
                  overflow: hidden;
                  width: 1700px;
                  height: 280px;
                  text-align: left;
                  line-height: normal;
                  z-index: 0;
                  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
                  font-family: 'Lucida Grande', 'Lucida Sans Unicode', Verdana,
                    Arial, Helvetica, sans-serif;
                  font-size: 12px;
                "
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  version="1.1"
                  width="1700"
                  height="280"
                >
                  <desc>Created with Highcharts 3.0.2</desc>
                  <defs>
                    <clipPath id="highcharts-1">
                      <rect
                        fill="none"
                        x="0"
                        y="0"
                        width="1637"
                        height="219"
                      ></rect>
                    </clipPath>
                  </defs>
                  <rect
                    rx="5"
                    ry="5"
                    fill="#FFFFFF"
                    x="0"
                    y="0"
                    width="1700"
                    height="280"
                  ></rect>
                  <g class="highcharts-grid" zIndex="1">
                    <path
                      fill="none"
                      d="M 410121.75 10 L 410121.75 230"
                      stroke="#f0f0f0"
                      stroke-width="0.5"
                      zIndex="1"
                      opacity="1"
                    ></path>
                  </g>
                  <g class="highcharts-grid" zIndex="1">
                    <path
                      fill="none"
                      d="M 53 120.25 L 1690 120.25"
                      stroke="#e0e0e0"
                      stroke-width="0.5"
                      zIndex="1"
                      opacity="1"
                    ></path>
                  </g>
                  <g class="highcharts-axis" zIndex="2">
                    <path
                      fill="none"
                      d="M 410121.5 230 L 410121.5 235"
                      stroke="#C0D0E0"
                      stroke-width="1"
                      opacity="1"
                    ></path>
                    <path
                      fill="none"
                      d="M 53 229.5 L 1690 229.5"
                      stroke="#C0D0E0"
                      stroke-width="1"
                      zIndex="7"
                      visibility="visible"
                    ></path>
                  </g>
                  <g class="highcharts-axis" zIndex="2">
                    <text
                      x="28.03125"
                      y="120"
                      style="
                        font-family: 'Lucida Grande', 'Lucida Sans Unicode',
                          Verdana, Arial, Helvetica, sans-serif;
                        font-size: 12px;
                        color: #4d759e;
                        font-weight: bold;
                        fill: #4d759e;
                      "
                      zIndex="7"
                      text-anchor="middle"
                      transform="translate(0,0) rotate(270 28.03125 120)"
                      visibility="visible"
                    >
                      <tspan x="28.03125">参加人次</tspan>
                    </text>
                  </g>
                  <g class="highcharts-series-group" zIndex="3">
                    <g
                      class="highcharts-series"
                      visibility="visible"
                      zIndex="0.1"
                      transform="translate(53,10) scale(1 1)"
                      clip-path="url(#highcharts-1)"
                    ></g>
                    <g
                      class="highcharts-markers"
                      visibility="visible"
                      zIndex="0.1"
                      transform="translate(53,10) scale(1 1)"
                      clip-path="none"
                    >
                      <path
                        fill="#3399fe"
                        d="M 818.5 106 C 823.828 106 823.828 114 818.5 114 C 813.172 114 813.172 106 818.5 106 Z"
                      ></path>
                      <path
                        fill="none"
                        d="M 808.5 110 L 828.5 110"
                        class="highcharts-tracker highcharts-tracker"
                        stroke-linejoin="round"
                        visibility="visible"
                        stroke-opacity="0.0001"
                        stroke="rgb(192,192,192)"
                        stroke-width="22"
                        zIndex="2"
                        style=""
                      ></path>
                    </g>
                  </g>
                  <g
                    class="highcharts-legend"
                    zIndex="7"
                    transform="translate(1578,110)"
                  >
                    <g zIndex="1">
                      <g>
                        <g
                          class="highcharts-legend-item"
                          zIndex="1"
                          transform="translate(8,3)"
                        >
                          <path
                            fill="none"
                            d="M 0 11 L 16 11"
                            stroke="#3399fe"
                            stroke-width="2"
                          ></path>
                          <path
                            fill="#3399fe"
                            d="M 8 7 C 13.328 7 13.328 15 8 15 C 2.6719999999999997 15 2.6719999999999997 7 8 7 Z"
                          ></path>
                          <text
                            x="21"
                            y="15"
                            style="
                              font-family: 'Lucida Grande',
                                'Lucida Sans Unicode', Verdana, Arial, Helvetica,
                                sans-serif;
                              font-size: 12px;
                              cursor: pointer;
                              color: #274b6d;
                              fill: #274b6d;
                            "
                            text-anchor="start"
                            zIndex="2"
                          >
                            <tspan x="21">日参加量情况</tspan>
                          </text>
                        </g>
                      </g>
                    </g>
                  </g>
                  <g class="highcharts-axis-labels" zIndex="7">
                    <text
                      x="871.5"
                      y="244"
                      style="
                        font-family: 'Lucida Grande', 'Lucida Sans Unicode',
                          Verdana, Arial, Helvetica, sans-serif;
                        font-size: 11px;
                        width: 1617px;
                        color: #666;
                        cursor: default;
                        line-height: 14px;
                        fill: #666;
                      "
                      text-anchor="middle"
                      opacity="1"
                    >
                      <tspan x="871.5">03-24</tspan>
                    </text>
                  </g>
                  <g class="highcharts-axis-labels" zIndex="7">
                    <text
                      x="45"
                      y="124.09999999999388"
                      style="
                        font-family: 'Lucida Grande', 'Lucida Sans Unicode',
                          Verdana, Arial, Helvetica, sans-serif;
                        font-size: 11px;
                        width: 799px;
                        color: #666;
                        cursor: default;
                        line-height: 14px;
                        fill: #666;
                      "
                      text-anchor="end"
                      opacity="1"
                    >
                      <tspan x="45">1</tspan>
                    </text>
                  </g>
                  <g
                    class="highcharts-tooltip"
                    zIndex="8"
                    style="cursor: default; padding: 0; white-space: nowrap"
                    visibility="hidden"
                    transform="translate(0,0)"
                  >
                    <rect
                      rx="3"
                      ry="3"
                      fill="none"
                      x="0.5"
                      y="0.5"
                      width="16"
                      height="16"
                      fill-opacity="0.85"
                      isShadow="true"
                      stroke="black"
                      stroke-opacity="0.049999999999999996"
                      stroke-width="5"
                      transform="translate(1, 1)"
                    ></rect>
                    <rect
                      rx="3"
                      ry="3"
                      fill="none"
                      x="0.5"
                      y="0.5"
                      width="16"
                      height="16"
                      fill-opacity="0.85"
                      isShadow="true"
                      stroke="black"
                      stroke-opacity="0.09999999999999999"
                      stroke-width="3"
                      transform="translate(1, 1)"
                    ></rect>
                    <rect
                      rx="3"
                      ry="3"
                      fill="none"
                      x="0.5"
                      y="0.5"
                      width="16"
                      height="16"
                      fill-opacity="0.85"
                      isShadow="true"
                      stroke="black"
                      stroke-opacity="0.15"
                      stroke-width="1"
                      transform="translate(1, 1)"
                    ></rect>
                    <rect
                      rx="3"
                      ry="3"
                      fill="rgb(255,255,255)"
                      x="0.5"
                      y="0.5"
                      width="16"
                      height="16"
                      fill-opacity="0.85"
                    ></rect>
                    <text
                      x="8"
                      y="21"
                      style="
                        font-family: 'Lucida Grande', 'Lucida Sans Unicode',
                          Verdana, Arial, Helvetica, sans-serif;
                        font-size: 12px;
                        color: #333333;
                        fill: #333333;
                      "
                      zIndex="1"
                    ></text>
                  </g>
                  <text
                    x="1690"
                    y="275"
                    style="
                      font-family: 'Lucida Grande', 'Lucida Sans Unicode',
                        Verdana, Arial, Helvetica, sans-serif;
                      font-size: 9px;
                      cursor: pointer;
                      color: #909090;
                      fill: #909090;
                    "
                    text-anchor="end"
                    zIndex="8"
                  ></text>
                </svg>
              </div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
    <!-- <div class="xitong"  v-model:visible="visible"> -->
    <div class="xitong" v-show="visible" @click="handleshow">
      <div class="tanchuang" id="app2">
        <h1>系统公告</h1>
        <!-- <iframe
          :src="ifsrc"
          style="width: 100%; height: 100%"
        ></iframe> -->
      </div>
    </div>
  </div>
</template>

<script>
import Schart from "vue-schart";
import { reactive, ref } from "vue";
import { ElMessage, ElMessageBox } from "element-plus";
export default {
  name: "shouye",
  components: { Schart },
  setup() {
    const visible = ref(false);
    //  const ifsrc = ref('static/fangjia.html');
    const name = localStorage.getItem("ms_username");
    // const profile = localStorage.getItem("ms_userprofile");
    const items = [
      {
        title: "2022年春节放假通知",
        date: "01-27",
        src: "static/fangjia.html",
      },
      {
        title: "2022年春节放假通知",
        date: "01-27",
        src: "static/test.html",
      },
      {
        title: "2022年春节放假通知",
        date: "01-27",
        src: "static/fangjia.html",
      },
      {
        title: "2022年春节放假通知",
        date: "01-27",
        src: "static/fangjia.html",
      },
    ];
    const handlethis = () => {
      ElMessageBox.confirm("点击了按钮", "提示");
      console.log("点击了按钮");
    };
    const activeName = "first";
    const format = (percentage) => {
      // return percentage === 100 ? '满' : `${percentage}%`;
      return null;
    };
    const handleClick = (item) => {
      //   console.log(item);
      var dom = document.querySelector("#app2");
      var iframe = document.createElement("iframe");
      var reiframe = document.querySelector("iframe");
      //   console.log(reiframe);
      reiframe ? dom.removeChild(reiframe) : null;
      //   console.log(dom,iframe);

      iframe.src = item.src;
      iframe.style.width = "100%";
      iframe.style.height = "90%";

      dom.appendChild(iframe);
      //    ifsrc.value = item.src;
      visible.value = true;
    };
    const handleshow = () => {
      visible.value = false;
    };

    return {
      visible,
      activeName,
      name,
      items,
      format,
      handlethis,
      handleClick,
      handleshow,
    };
  },
};
</script>

<style scoped lang='scss'>
.xitong {
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  z-index: 3;
  background-color: #666666c7;

  .tanchuang {
    padding: 4px;
    border-radius: 5px;
    width: 60%;
    height: 600px;
    background-color: #fff;
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: -300px;
    margin-left: -30%;
    h1 {
      font-size: 15px;
      font-weight: 400;
      line-height: 38px;
      color: #5a5a5a;
      border-bottom: 1px solid #666666;
    }
  }
}
.card {
  width: 400px;
  // height: 120px;
  background-color: #fff;
  box-sizing: border-box;
  a {
    width: 90%;
    height: 100px;
    border: 1px solid #f1f3f8;
    margin: 2% 5%;
    padding: 20px 0px 20px 10px;
    cursor: pointer;
    display: inline-block;
    box-sizing: border-box;
  }
  .bgimg {
    float: left;
    width: 60px;
    height: 60px;
    background-image: url("src/assets/img/ico.png");
  }

  .info {
    float: left;
    padding-left: 9.6px;
    margin-top: 3.2px;
    h1 {
      font-size: 14px;
      line-height: 24px;
      color: #333333;
    }
    p {
      font-size: 12px;
      line-height: 16px;
      color: #9090a4;
      letter-spacing: 1px;
    }
  }
}
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
.tou {
  display: flex;
  justify-content: space-between;
  background: #ffffff;
  line-height: 50px;
}
.box-fast {
  background: #ffffff;
  display: flex;
  border-radius: 4px;
  min-height: 36px;
  justify-content: space-around;
  align-content: space-around;
  flex-wrap: wrap;
  padding: 20px 24px;
}

.boxBbox-right {
  background-color: #fff;
  height: 275px;
  box-sizing: border-box;
  padding-top: 15px;
  h1 {
    text-align: center;

    font-size: 14px;
  }
  .kszx-box-02 {
    margin: 4px auto;
    padding: 0px;
    width: 80%;
  }
  .kszx-ewm {
    float: left;
    border: 1px solid #f1f3f8;
    box-sizing: border-box;
    padding: 20px 10px;
    width: 50%;
    // width: 166px;
    // height: 199px;
    text-align: center;
    img {
      width: auto;
      height: auto;
      max-width: 100%;
      max-height: 100%;
    }
    p {
      font-size: 12px;
      line-height: 20px;
      margin-top: 5px;
      color: #666666;
    }
  }
  .kszx-button {
    float: left;
    width: 50%;
    text-align: center;
    margin-top: 30px;
    button {
      width: 121px;
      margin-bottom: 20px;
    }
  }
}
.box-purple {
  //   background: #d3dce6;
  background-color: #fff;
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-around;
  text-align: center;
  padding-bottom: 40px;
  h1 {
    color: #666666;
    font-size: 14px;
    margin-bottom: 40px;
  }
  span {
    text-align: center;
  }
  .data-box-left {
    display: flex;
    flex-wrap: nowrap;
    margin-top: 30px;
    .Statistics-box {
      box-sizing: border-box;
      padding: 10px 30px;
      width: 255px;
      em {
        color: #d93026;
        font-size: 20px;
        font-style: normal;
      }
    }
    :global(.el-progress__text) {
      display: none;
    }
  }
  .data-box-right {
    display: flex;
    flex-wrap: nowrap;
    margin-top: 30px;
    .Statistics-box02 {
      box-sizing: border-box;
      padding: 10px 20px;
      width: 241px;
      em {
        color: #333333;
        font-size: 20px;
        font-style: normal;
      }
    }
  }
}
.tablist {
  background: #fff;
  height: 100%;
  overflow: hidden;
  padding: 0 10px;
  li {
    cursor: pointer;
    margin-bottom: 3px;
    :hover {
      color: #9090a4 !important;
    }
    .item-left {
      float: left;
      color: #666;
      font-size: 12px;
    }
    .item-right {
      float: right;
      color: #666;
      font-size: 12px;
    }
  }
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.bg-purple-dark {
  background-color: #fff;
}
.jiaocheng {
  background-color: #fff;
  padding: 20px 30px;
  h1 {
    color: #666666;
    font-size: 14px;
    margin-bottom: 20px;
  }
  .content2 {
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-around;
    .ksy-ing-box {
      border: 1px solid #f1f3f8;
      width: 457px;
      box-sizing: border-box;
      padding: 10px 20px 15px 20px;
      margin-bottom: 20px;
      .ksy-ing-box-title {
        line-height: 20px;
        margin-bottom: 5px;
        span {
          font-size: 14px;
          color: #333333;
        }

        .fr {
          float: right;
        }
      }
      .info02 p {
        font-size: 12px;
        color: #9090a4;
        line-height: 20px;
      }
    }
    .chevron-box {
      position: absolute;
      box-sizing: border-box;
      bottom: 0px;
      left: 50%;
      margin-left: -30px;
      padding: 0px 10px;
      font-size: 14px;
      text-align: center;
      background-color: #d3d1d1;
      color: aliceblue;
      width: 60px;
      height: 20px;
      border-top-left-radius: 5px;
      border-top-right-radius: 5px;
    }
  }
}
</style>
