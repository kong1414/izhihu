import axios from './request'
import {
  BASE_URL
} from './config'

export const reqLogin = params => { // 登陆
  return axios.post(`${BASE_URL}/user/login`, params).then(res => res.data)
}

export const reqQueryAccount = params => { // 远程搜索登陆用户名
  return axios.post(`${BASE_URL}/user/queryList?` + params).then(res => res.data)
}
export const reqcheckName = params => { // 检查用户名重复
  return axios.post(`${BASE_URL}/user/checkName?` + params).then(res => res.data)
}

export const reqRegister = params => { // 注册
  return axios.post(`${BASE_URL}/user/register`, params).then(res => res.data)
}

// 用户修改自己的密码
export const reqUpdatePwd = params => { // 用户修改自己的密码
  return axios.post(`${BASE_URL}/user/updatePassword`, params).then(res => res.data)
}
