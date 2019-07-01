import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('./views/Register.vue')
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('./views/Home'),
      children: [
        {
          path: '/home/index',
          menuName: '首页',
          component: () => import('./views/Index') // 首页
        },
        {
          path: '/home/usermanage',
          menuName: '用户管理',
          component: () => import('./views/systmagpager/UserManage') // 用户管理
        },
        {
          path: '/home/rolemanage',
          menuName: '角色管理',
          component: () => import('./views/systmagpager/RoleManage') // 角色管理
        },
        {
          path: '/home/aclmanage',
          menuName: '权限管理',
          component: () => import('./views/systmagpager/AclManage') // 权限管理
        },
        {
          path: '/home/dictionary',
          menuName: '数据字典',
          component: () => import('./views/systmagpager/Dictionary.vue') // 数据字典
        }
      ]
    }
  ]
})
