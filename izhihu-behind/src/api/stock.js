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
export const reqUpdateWarehouse = params => { // 更新仓库
  return axios.post(`${BASE_URL}/warehouse/update`, params).then(res => res.data)
}
export const reqWarehouseList = params => { // 获取仓库列表
  return axios.post(`${BASE_URL}/warehouse/list?` + params).then(res => res.data)
}

/* 产品模块接口 */

export const reqAddProduct = params => { // 新增产品
  return axios.post(`${BASE_URL}/product/create`, params).then(res => res.data)
}
export const reqDelProduct = params => { // 删除产品
  return axios.post(`${BASE_URL}/product/delete?` + params).then(res => res.data)
}
export const reqUpdateProduct = params => { // 更新产品
  return axios.post(`${BASE_URL}/product/update`, params).then(res => res.data)
}
export const reqProductList = params => { // 获取产品列表
  return axios.post(`${BASE_URL}/product/list?` + params).then(res => res.data)
}
export const reqProductListByName = params => { // 获取产品列表，id和name
  return axios.post(`${BASE_URL}/product/listByName?` + params).then(res => res.data)
}

/* 库存模块接口 */

export const reqAddStock = params => { // 新增库存
  return axios.post(`${BASE_URL}/stock/create`, params).then(res => res.data)
}
export const reqDelStockById = params => { // 删除库存
  return axios.post(`${BASE_URL}/stock/deleteById?` + params).then(res => res.data)
}
export const reqUpdateStock = params => { // 更新库存
  return axios.post(`${BASE_URL}/stock/update`, params).then(res => res.data)
}
export const reqStockListByWarehouseId = params => { // 获取产品在库存中的详情
  return axios.post(`${BASE_URL}/stock/listByWarehouseId?` + params).then(res => res.data)
}

/* 入库模块接口 */

export const reqStockList = params => { // 获取入库信息表
  return axios.post(`${BASE_URL}/stocklist/list?` + params).then(res => res.data)
}
