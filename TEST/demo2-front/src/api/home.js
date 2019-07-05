import axios from './request'
import {
  BASE_URL
} from './config'
// 首页

// 图书管理页

export const reqBookInfo = params => {
  return axios.post(`${BASE_URL}/user/book/list?` + params).then(res => res.data)
}

export const reqBookcreate = params => {
  return axios.post(`${BASE_URL}/user/book/create`, params).then(res => res.data)
}

export const reqBookupdate = params => {
  return axios.post(`${BASE_URL}/user/book/update?`, params).then(res => res.data)
}

export const reqBookdel = params => {
  return axios.post(`${BASE_URL}/user/book/del?` + params).then(res => res.data)
}

export const reqBorrow = params => {
  return axios.post(`${BASE_URL}/user/book/borrow`, params).then(res => res.data)
}

export const reqRebook = params => {
  return axios.post(`${BASE_URL}/user/book/rebook`, params).then(res => res.data)
}

export const reqMyRecordList = params => {
  return axios.post(`${BASE_URL}/user/book/myRecordList?` + params).then(res => res.data)
}

export const reqRecordAllList = params => {
  return axios.post(`${BASE_URL}/user/book/recordAllList?` + params).then(res => res.data)
}
