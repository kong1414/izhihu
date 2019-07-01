import axios from './request'
import {
  BASE_URL
} from './config'
// 话题

export const reqGetHotTopic = params => { // 获得发现页热门话题
  return axios.post(`${BASE_URL}/topic/hotTopic`, params).then(res => res.data)
}
