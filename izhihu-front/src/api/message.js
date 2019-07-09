import axios from './request'
import {
  BASE_URL
} from './config'
// 私信

export const reqMessList = params => { //
  return axios.post(`${BASE_URL}/message/list?` + params).then(res => res.data)
}
export const reqMessRead = params => { //
  return axios.post(`${BASE_URL}/message/read?` + params).then(res => res.data)
}
export const reqMessDel = params => { //
  return axios.post(`${BASE_URL}/message/del?` + params).then(res => res.data)
}
export const reqMessSend = params => { //
  return axios.post(`${BASE_URL}/message/send`, params).then(res => res.data)
}
export const reqSearchUser = params => { //
  return axios.post(`${BASE_URL}/user/search?` + params).then(res => res.data)
}
