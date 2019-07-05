import axios from './request'
import {
  BASE_URL
} from './config'
// 获得文章、问题评论

export const reqGetTopicDet = params => { // 获得话题详情
  return axios.post(`${BASE_URL}/topic/topicDetial?` + params).then(res => res.data)
}

export const reqGetTopicArticle = params => { // 获得话题下文章
  return axios.post(`${BASE_URL}/topic/topicArticle?` + params).then(res => res.data)
}

export const reqGetArticleCom = params => { // 获得文章下评论
  return axios.post(`${BASE_URL}/comment/listByArticle?` + params).then(res => res.data)
}
