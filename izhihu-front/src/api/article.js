import axios from './request'
import {
  BASE_URL
} from './config'
// 文章

export const reqCreateArticle = params => { // 写文章写想法
  return axios.post(`${BASE_URL}/article/create`, params).then(res => res.data)
}
