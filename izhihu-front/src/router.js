import Vue from 'vue'
import Router from 'vue-router'
// import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/home/index'
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login-fork.vue')
    },
    // {
    //   path: '/home',
    //   name: 'home',
    //   component: () => import('./views/Home.vue')
    // },
    {
      path: '/home',
      name: 'home',
      component: () => import('./views/Home.vue'),
      redirect: '/home/index',
      children: [
        {
          path: '/home/index',
          menuName: 'index',
          component: () => import('./views/index/Index.vue')
        },
        {
          path: '/home/topic',
          menuName: 'topic',
          component: () => import('./views/topic/Topic.vue')
        }
      ]
    }
  ]
})
