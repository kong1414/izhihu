import axios from './request'
import {
  BASE_URL
} from './config'
// 首页

export const reqGetHostList = params => { // 获得 列出热榜
  return axios.post(`${BASE_URL}/hostList/list`, params).then(res => res.data)
}

// 个人页

export const reqUserInfo = params => { // 获得 列出热榜
  return axios.post(`${BASE_URL}/user/people?` + params).then(res => res.data)
}