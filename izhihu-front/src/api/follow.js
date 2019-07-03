import axios from './request'
import {
  BASE_URL
} from './config'
// 关注 点赞相关的

export const reqUnFollow = params => { // 取消关注
  return axios.post(`${BASE_URL}/follow/unFollow`, params).then(res => res.data)
}

export const reqInFollow = params => { // 关注
  return axios.post(`${BASE_URL}/follow/inFollow`, params).then(res => res.data)
}
