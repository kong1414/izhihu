import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   redirect: '/home/index'
    // },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login.vue')
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('./views/Home.vue'),
      children: [
        {
          path: '/home/index',
          name: 'index',
          component: () => import('./views/Index.vue')
        },
        {
          path: '/home/bookborrow',
          name: 'BookBorrow',
          component: () => import('./views/BookBorrow.vue')
        },
        {
          path: '/home/borrowhistory/',
          name: 'BorrowHistory',
          component: () => import('./views/BorrowHistoryCard.vue')
        },
        {
          path: '/home/bookmanage',
          name: 'bookmanage',
          component: () => import('./views/BookManage.vue')
        },
        {
          path: '/home/myborrow',
          name: 'myBorrow',
          component: () => import('./views/myBorrow.vue')
        }
      ]
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('./views/About.vue')
    }
  ]
})
