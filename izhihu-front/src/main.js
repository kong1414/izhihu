import 'babel-polyfill'
import Vue from 'vue'
import store from './store'
import App from './App.vue'
import router from './router'
import md5 from 'js-md5'
import './plugins/element.js'
import '@/assets/styles/index.scss'
import '@/assets/iconfont/iconfont.css'
import VueQuillEditor from 'vue-quill-editor'
// require styles 引入样式
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'

Vue.config.productionTip = false
Vue.prototype.$md5 = md5
Vue.use(VueQuillEditor)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
