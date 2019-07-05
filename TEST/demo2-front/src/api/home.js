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

// 图书管理页

export const reqBookInfo = params => { // 获得 书籍列表
  return axios.post(`${BASE_URL}/user/book/list?` + params).then(res => res.data)
}

export const reqBookcreate = params => { // 获得 书籍列表
  return axios.post(`${BASE_URL}/user/book/create?` + params).then(res => res.data)
}

export const reqBookupdate = params => { // 获得 书籍列表
  return axios.post(`${BASE_URL}/user/book/update?` + params).then(res => res.data)
}

export const reqBookdel = params => { // 获得 书籍列表
  return axios.post(`${BASE_URL}/user/book/del?` + params).then(res => res.data)
}
