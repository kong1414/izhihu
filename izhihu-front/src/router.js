import Vue from 'vue'
import Router from 'vue-router'
// import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   redirect: '/login'
    // },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login-fork.vue')
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('./views/Home.vue')
    }
  ]
})
