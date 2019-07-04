import axios from './request'
import {
  BASE_URL
} from './config'
// 问题

export const reqCreateQuestion = params => { // 写文章写想法
  return axios.post(`${BASE_URL}/question/create`, params).then(res => res.data)
}
