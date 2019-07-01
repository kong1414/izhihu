import * as types from './mutation-types'

const mutations = {
  [types.SET_USER] (state, user) {
    state.user = user
  },
  [types.SET_USER_TOKEN] (state, token) {
    state.token = token
  }
}

export default mutations
