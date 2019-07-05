import axios from './request'
import {
  BASE_URL
} from './config'
// 首页

// 图书管理页

export const reqBookInfo = params => {
  return axios.post(`${BASE_URL}/book/list?` + params).then(res => res.data)
}

export const reqBookcreate = params => {
  return axios.post(`${BASE_URL}/book/create`, params).then(res => res.data)
}

export const reqBookupdate = params => {
  return axios.post(`${BASE_URL}/book/update?`, params).then(res => res.data)
}

export const reqBookdel = params => {
  return axios.post(`${BASE_URL}/book/del?` + params).then(res => res.data)
}

export const reqBorrow = params => {
  return axios.post(`${BASE_URL}/book/borrow`, params).then(res => res.data)
}

export const reqRebook = params => {
  return axios.post(`${BASE_URL}/book/rebook`, params).then(res => res.data)
}

export const reqMyRecordList = params => {
  return axios.post(`${BASE_URL}/book/myRecordList?` + params).then(res => res.data)
}

export const reqRecordAllList = params => {
  return axios.post(`${BASE_URL}/book/recordAllList?` + params).then(res => res.data)
}
