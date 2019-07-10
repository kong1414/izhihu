import 'babel-polyfill'
import Vue from 'vue'
import store from './store'
import App from './App.vue'
import router from './router'
import md5 from 'js-md5'
import './plugins/element.js'
import '@/assets/styles/index.scss'
import '@/assets/iconfont/iconfont.css'

import VCharts from 'v-charts'
Vue.use(VCharts)

Vue.config.productionTip = false
Vue.prototype.$md5 = md5

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
