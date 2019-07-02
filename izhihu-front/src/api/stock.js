import axios from './request'
import {
  BASE_URL
} from './config'

/* 仓库模块接口 */

export const reqAddWarehouse = params => { // 新增仓库
  return axios.post(`${BASE_URL}/warehouse/create`, params).then(res => res.data)
}
export const reqDelWarehouse = params => { // 删除仓库
  return axios.post(`${BASE_URL}/warehouse/delete?` + params).then(res => res.data)
}
