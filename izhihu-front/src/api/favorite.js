import axios from './request'
import {
  BASE_URL
} from './config'
// 收藏夹

export const reqHotFavorite = params => { // 发现页的热门收藏夹
  return axios.post(`${BASE_URL}/favorite/hotFavorite?` + params).then(res => res.data)
}

export const reqMyFavorite = params => { // 某用户的收藏夹
  return axios.post(`${BASE_URL}/favorite/myFavorite?` + params).then(res => res.data)
}

export const reqMyFavDetail = params => { // 我创建的收藏夹
  return axios.post(`${BASE_URL}/favorite/myFavoriteDetail?` + params).then(res => res.data)
}

export const reqMyAttFavorite = params => { // 我关注的收藏夹
  return axios.post(`${BASE_URL}/favorite/myAttFavorite?` + params).then(res => res.data)
}

export const reqCreateFav = params => { // 创建收藏夹
  return axios.post(`${BASE_URL}/favorite/create`, params).then(res => res.data)
}

export const reqUpdateFav = params => { // 更新编辑收藏夹
  return axios.post(`${BASE_URL}/favorite/update`, params).then(res => res.data)
}

export const reqDeleteFav = params => { // 删除收藏夹（有数据会提示报错）
  return axios.post(`${BASE_URL}/favorite/delete?` + params).then(res => res.data)
}

export const reqCollect = params => { // 把文章加入收藏夹
  return axios.post(`${BASE_URL}/favorite/collect`, params).then(res => res.data)
}

export const reqUnCollect = params => { // 把文章取消收藏
  return axios.post(`${BASE_URL}/favorite/unCollect`, params).then(res => res.data)
}

export const reqDetail = params => { // 收藏夹详情页的信息
  return axios.post(`${BASE_URL}/favorite/detail?` + params).then(res => res.data)
}
