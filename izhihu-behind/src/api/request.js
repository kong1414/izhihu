import axios from 'axios'
import {
  ERR_OK,
  ERR_USER_TOKEN
} from './config'
import {
  Message
} from 'element-ui'
import store from '../store'
import router from '../router'

// 封装axios请求
axios.defaults.timeout = 10000 // 响应时间
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8' // 配置请求头
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*' // 配置请求头

// 发送请求之前调用拦截器
axios.interceptors.request.use(config => {
  // 请求header加token
  if (!config.url.endsWith('login')) {
    if (store.getters.token) {
      config.headers.token = store.getters.token
    }
  }
  return config
}, error => {
  return Promise.reject(error)
})

// 请求成功经过拦截器
axios.interceptors.response.use(response => {
  if (response.data.resultCode !== ERR_OK) {
    Message({
      type: 'error',
      message: response.data.resultMessage,
      duration: 1500
    })
    if (response.data.resultCode === ERR_USER_TOKEN) {
      router.push({
        path: '/login'
      })
    }
  }
  return response
}, error => {
  return Promise.reject(error)
})

export default axios
