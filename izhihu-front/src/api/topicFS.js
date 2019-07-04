import axios from './request'
import {
  BASE_URL
} from './config'
// 话题详情页的父子话题获取

export const reqGetFathTop = params => { // 获得父话题
  return axios.post(`${BASE_URL}/topic/topicFather?` + params).then(res => res.data)
}

export const reqGetSonTop = params => { // 获得子话题
  return axios.post(`${BASE_URL}/topic/topicChild?` + params).then(res => res.data)
}
