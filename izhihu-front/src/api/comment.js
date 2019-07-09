import axios from './request'
import {
  BASE_URL
} from './config'// 获得评论相关信息

export const reqGetArticleCom = params => { // 获得文章下评论
  return axios.post(`${BASE_URL}/comment/listByArticle?` + params).then(res => res.data)
}

export const reqRemark = params => { // 进行评论
  return axios.post(`${BASE_URL}/comment/remark`, params).then(res => res.data)
}

export const reqDelCom = params => { // 删除自己评论
  return axios.post(`${BASE_URL}/comment/delete`, params).then(res => res.data)
}
