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
    // {
    //   path: '/home',
    //   name: 'home',
    //   component: () => import('./views/Home.vue')
    // },
    {
      path: '/home',
      name: 'home',
      component: () => import('./views/Home.vue'),
      children: [
        // {
        //   path: '/home/index',
        //   menuName: '首页',
        //   component: () => import('./views/Home.vue')
        // },
        {
          path: '/home/topic',
          menuName: 'topic',
          component: () => import('./views/topic/topic.vue')
        }
      ]
    }
  ]
})
