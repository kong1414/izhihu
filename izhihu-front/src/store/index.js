import 'babel-polyfill'
import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersistence from 'vuex-persist'
import * as actions from './actions'
import * as getters from './getters'
import state from './state'
import mutations from './mutations'
import createLogger from 'vuex/dist/logger'

const vuexLocal = new VuexPersistence({ // 配置
  storage: window.localStorage,
  reducer: state => ({
    user: state.user,
    token: state.token
  }),
  filter: mutation => (
    mutation.type === 'SET_USER' ||
    mutation.type === 'SET_USER_TOKEN'
  )
})

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  actions,
  getters,
  state,
  mutations,
  strict: debug,
  plugins: debug ? [createLogger(), vuexLocal.plugin] : [vuexLocal.plugin]
})
