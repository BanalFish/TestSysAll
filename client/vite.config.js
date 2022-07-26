import {
    defineConfig
} from 'vite';
// import { resolve } from "path"; // 主要用于alias文件路径别名
import vue from '@vitejs/plugin-vue'


export default defineConfig({
    base: './',
    plugins: [vue()],
    optimizeDeps: {
        include: ['schart.js']
    },
    // 打包配置
    build: {
        target: 'modules', // 设置最终构建的浏览器兼容目标。modules:支持原生 ES 模块的浏览器
        outDir: 'dist', // 指定输出路径
        assetsDir: 'assets', // 指定生成静态资源的存放路径
        sourcemap: false, // 构建后是否生成 source map 文件
        minify: 'terser' // 混淆器，terser构建后文件体积更小
    },

    // 本地运行配置，及反向代理配置
    server: {
        host: 'localhost', // 指定服务器主机名
        port: 3000, // 指定服务器端口
        open: true, // 在服务器启动时自动在浏览器中打开应用程序
        strictPort: false, // 设为 false 时，若端口已被占用则会尝试下一个可用端口,而不是直接退出
        https: false, // 是否开启 https
        cors: true, // 为开发服务器配置 CORS。默认启用并允许任何源
        proxy: { // 为开发服务器配置自定义代理规则
            '/api': {
                target: 'http://127.0.0.1:7002/', //代理接口
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, '')
            }
        }
    }
})
// export default defineConfig({
//     base: './',
//     plugins: [vue()],
//     optimizeDeps: {
//         include: ['schart.js']
//     },

//  //本地运行配置，以及反向代理配置
//  server: {
//     host: "localhost",
//     https: false,//是否启用 http 2
//     cors: true,//为开发服务器配置 CORS , 默认启用并允许任何源
//     open: true,//服务启动时自动在浏览器中打开应用
//     port: "3002",
//     strictPort: false, //设为true时端口被占用则直接退出，不会尝试下一个可用端口
//     force: true,//是否强制依赖预构建
//     hmr: false,//禁用或配置 HMR 连接
//     // 传递给 chockidar 的文件系统监视器选项
//     watch: {
//      ignored:["!**/node_modules/your-package-name/**"]
//     },
//     // 反向代理配置
//     proxy: { 
//      '/api': {
//       target: "https://baidu.com/",
//       changeOrigin: true,
//       rewrite: (path) => path.replace(/^\/api/, '')
//      }
//     }
//    },


// })