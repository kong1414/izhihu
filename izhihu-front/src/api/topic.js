import axios from './request'
import {
  BASE_URL
} from './config'
// 话题

export const reqGetHotTopic = params => { // 获得发现页热门话题
  return axios.post(`${BASE_URL}/topic/hotTopic`, params).then(res => res.data)
}

export const reqGetAsideTopic = params => { // 获得话题页右侧话题
  return axios.post(`${BASE_URL}/topic/topicRandom?num=5`, params).then(res => res.data)
}

export const reqAttedTopic = params => { // 获得已关注的话题
  return axios.post(`${BASE_URL}/topic/attedTopic?` + params).then(res => res.data)
}

export const reqTopicDetial = params => { // 获得话题详情
  return axios.post(`${BASE_URL}/topic/topicDetial?` + params).then(res => res.data)
}
