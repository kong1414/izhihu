import axios from './request'
import {
  BASE_URL
} from './config'
// 关注 点赞相关的

export const reqUnFollow = params => { // 取消关注
  return axios.post(`${BASE_URL}/follow/unFollow`, params).then(res => res.data)
}

export const reqInFollow = params => { // 关注
  return axios.post(`${BASE_URL}/follow/inFollow`, params).then(res => res.data)
}

export const reqLike = params => { // 点赞 （userId contentId）
  return axios.post(`${BASE_URL}/follow/like`, params).then(res => res.data)
}

export const reqUnLike = params => { // 取消态度（取消点赞和不赞同） （userId contentId）
  return axios.post(`${BASE_URL}/follow/unLike`, params).then(res => res.data)
}

export const reqCancelLike = params => { // 不赞同 （userId contentId）
  return axios.post(`${BASE_URL}/follow/cancelLike`, params).then(res => res.data)
}

export const reqGetAttByUser = params => { // 通过userid 获得关注的内容 参数：userId Number(type）
  return axios.post(`${BASE_URL}/follow/getAttByUser`, params).then(res => res.data)
}
