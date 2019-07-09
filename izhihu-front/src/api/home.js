import axios from './request'
import {
  BASE_URL
} from './config'
// 首页

export const reqGetHostList = params => { // 获得 列出热榜
  return axios.post(`${BASE_URL}/hostList/getHotList`, params).then(res => res.data)
}

// 个人页
export const reqUserInfo = params => { // 获得个人资料
  return axios.post(`${BASE_URL}/user/people?` + params).then(res => res.data)
}

export const reqUpdateUserInfo = params => { // 更新个人资料
  return axios.post(`${BASE_URL}/user/updateUserInfo`, params).then(res => res.data)
}

export const reqRecommend = params => { // 首页的推荐内容
  return axios.post(`${BASE_URL}/article/recommend`, params).then(res => res.data)
}

export const reqAttContetn = params => { // 首页的关注内容 （！需要前端去重以及根据时间排序）
  return axios.post(`${BASE_URL}/article/attContetn?` + params).then(res => res.data)
}

export const reqTodayHot = params => { // 发现页的今日最热
  return axios.post(`${BASE_URL}/article/todayHot`, params).then(res => res.data)
}

export const reqMonthHot = params => { // 发现页的本月最热
  return axios.post(`${BASE_URL}/article/monthHot`, params).then(res => res.data)
}
