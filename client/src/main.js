import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import './assets/css/icon.css'
import axios from 'axios'
// import axios from 'axios'


const app = createApp(App)
installElementPlus(app)
app
    // .use(axios)
    .use(store)
    .use(router)
    .mount('#app')

axios
    .get('http://localhost:8080/teacher/courList/1')
    .then((res) => {
        console.log(res)
    })

