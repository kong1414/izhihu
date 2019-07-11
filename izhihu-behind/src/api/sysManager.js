import axios from './request'
import {
  BASE_URL
} from './config'

/* 用户模块接口 */
export const reqAddUser = params => { // 新增用户
  return axios.post(`${BASE_URL}/user/create`, params).then(res => res.data)
}
export const reqDelUser = params => { // 删除用户
  return axios.post(`${BASE_URL}/user/delete?` + params).then(res => res.data)
}
export const reqUpdateUser = params => { // 更新用户
  return axios.post(`${BASE_URL}/user/update?` + params).then(res => res.data)
}
export const reqResetUser = params => { // 更新用户
  return axios.post(`${BASE_URL}/user/reset?` + params).then(res => res.data)
}
export const reqUserList = params => { // 获取用户列表
  return axios.post(`${BASE_URL}/user/list?` + params).then(res => res.data)
}
/* 数据字典 */
export const reqDictionaryList = params => { // 获取数据字典(非系统内置)
  return axios.post(`${BASE_URL}/dictionary/list`, params).then(res => res.data)
}
export const reqDictionaryListTag = params => { // 获取数据字典
  return axios.post(`${BASE_URL}/dictionary/listByTag?` + params).then(res => res.data)
}
export const reqDictionarySave = params => { // 新增数据字典
  return axios.post(`${BASE_URL}/dictionary/save`, params).then(res => res.data)
}
export const reqDictionarysaveChildren = params => { // 新增字类型
  return axios.post(`${BASE_URL}/dictionary/saveChildren`, params).then(res => res.data)
}
export const reqDictionaryUpdate = params => { // 修改数据字典
  return axios.post(`${BASE_URL}/dictionary/update`, params).then(res => res.data)
}
export const reqBatchRemove = params => { // 删除数据字典
  return axios.post(`${BASE_URL}/dictionary/batchRemove`, params).then(res => res.data)
}
export const reqSaveChildren = params => { // 新增子节点
  return axios.post(`${BASE_URL}/dictionary/saveChildren`, params).then(res => res.data)
}
export const reqUpdateChildren = params => { // 修改子节点
  return axios.post(`${BASE_URL}/dictionary/updateChildren`, params).then(res => res.data)
}

// 管理接口

export const reqFindArticlev = params => { //
  return axios.post(`${BASE_URL}/sys/findArticle`, params).then(res => res.data)
}
export const reqFindQues = params => { //
  return axios.post(`${BASE_URL}/sys/findQues`, params).then(res => res.data)
}
export const reqFindComment = params => { //
  return axios.post(`${BASE_URL}/sys/findComment`, params).then(res => res.data)
}
export const reqFindTopic = params => { //
  return axios.post(`${BASE_URL}/sys/findTopic`, params).then(res => res.data)
}
export const reqFindFar = params => { //
  return axios.post(`${BASE_URL}/sys/findFar`, params).then(res => res.data)
}

export const reqDelArticle = params => { //
  return axios.post(`${BASE_URL}/sys/delArticle`, params).then(res => res.data)
}

export const reqDelQues = params => { //
  return axios.post(`${BASE_URL}/sys/delQues`, params).then(res => res.data)
}

export const reqDelComment = params => { //
  return axios.post(`${BASE_URL}/sys/delComment`, params).then(res => res.data)
}

export const reqDelTopic = params => { //
  return axios.post(`${BASE_URL}/sys/delTopic`, params).then(res => res.data)
}

export const reqIndexDataHeader = params => { //
  return axios.post(`${BASE_URL}/sys/indexDataHeader`, params).then(res => res.data)
}

export const reqArtAna = params => { //
  return axios.post(`${BASE_URL}/sys/artAna`, params).then(res => res.data)
}

export const reqFindUser = params => { //
  return axios.post(`${BASE_URL}/sys/findUser`, params).then(res => res.data)
}

export const reqBanUser = params => { // 用户封禁
  return axios.post(`${BASE_URL}/sys/banUser`, params).then(res => res.data)
}

export const reqUnBanUser = params => { // 用户解封
  return axios.post(`${BASE_URL}/sys/unBanUser`, params).then(res => res.data)
}