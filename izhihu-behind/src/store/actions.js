import * as types from './mutation-types'

export const saveUser = function ({ commit, state }, user) {
  commit(types.SET_USER, user)
}

export const deleteUser = function ({ commit, state }) {
  commit(types.SET_USER, {})
}

export const saveToken = function ({ commit, state }, token) {
  commit(types.SET_USER_TOKEN, token)
}

export const deleteToken = function ({ commit, state }) {
  commit(types.SET_USER_TOKEN, '')
}
