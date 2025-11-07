import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login'
import beforeLogin from '@/views/beforeLogin'
import Home from '@/views/home'
import Index from '@/views/index'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import forum from '@/views/modules/forum/list'
import category from '@/views/modules/category/list'
import informationcategory from '@/views/modules/informationcategory/list'
import materialcategory from '@/views/modules/materialcategory/list'
import commoditycategory from '@/views/modules/commoditycategory/list'
import experience from '@/views/modules/experience/list'
import publishExperience from '@/views/modules/experience/add-or-update'
import student from '@/views/modules/student/list'
import teacher from '@/views/modules/teacher/list'
import clerk from '@/views/modules/clerk/list'
import information from '@/views/modules/information/list'
import publishInformation from '@/views/modules/information/add-or-update'
import orders from '@/views/modules/orders/list'
import address from '@/views/modules/address/list'
import store from '@/views/modules/store/list'
import soldMaterial from '@/views/modules/material/soldList'
import materialOrder from '@/views/modules/material/material-order'
import material from '@/views/modules/material/list'
import publishMaterial from '@/views/modules/material/add-or-update'
import commodity from '@/views/modules/commodity/list'
import soldCommodity from '@/views/modules/commodity/soldList'
import commodityOrder from '@/views/modules/commodity/commodity-order'
import publishCommodity from '@/views/modules/commodity/add-or-update'
import config from '@/views/modules/config/list'


Vue.use(VueRouter)

const routes = [{
  path: '/index',
  name: '首页',
  component: Index,
  children: [{
    // 这里不设置值，是把main作为默认页面
    path: '/',
    name: '主页',
    component: Home,
    meta: {icon:'', title:'center'}
  }, {
    path: '/updatePassword',
    name: '修改密码',
    component: UpdatePassword,
    meta: {icon:'', title:'updatePassword'}
  }, {
    path: '/pay',
    name: '支付',
    component: pay,
    meta: {icon:'', title:'pay'}
  }, {
    path: '/center',
    name: '个人信息',
    component: center,
    meta: {icon:'', title:'center'}
  }
    ,{
      path: '/forum',
      name: '论坛管理',
      component: forum
    }
    ,{
      path: '/category',
      name: '分类',
      component: category
    },{
      path: '/informationcategory',
      name: '分类',
      component: informationcategory
    },{
      path: '/materialcategory',
      name: '分类',
      component: materialcategory
    },{
      path: '/commoditycategory',
      name: '分类',
      component: commoditycategory
    }
    ,{
      path: '/experience',
      name: '经验贴',
      component: experience
    }
    ,{
      path: '/publishExperience',
      name: '发布经验贴',
      component: publishExperience
    }
    ,{
      path: '/student',
      name: '考生',
      component: student
    }
    ,{
      path: '/teacher',
      name: '教师',
      component: teacher
    }
    ,{
      path: '/clerk',
      name: '客服管理',
      component: clerk
    }
    ,{
      path: '/information',
      name: '考研资讯',
      component: information
    },
    ,{
      path: '/publishInformation',
      name: '发布资讯',
      component: publishInformation
    }
    ,{
      path: '/orders/:status',
      name: '订单管理',
      component: orders
    }
    ,{
      path: '/store',
      name: '我的收藏管理',
      component: store
    }
    ,{
      path: '/material',
      name: '资料信息',
      component: material
    }
    ,{
      path: '/sellMaterial',
      name: '已卖资料',
      component: soldMaterial
    }
    ,{
      path: '/materialOrder',
      name: '资料订单',
      component: materialOrder
    }
    ,{
      path: '/publishMaterial',
      name: '发布资料',
      component: publishMaterial
    }
    ,{
      path: '/commodity',
      name: '商品信息',
      component: commodity
    }
    ,{
      path: '/sellCommodity',
      name: '已完成商品信息',
      component: soldCommodity
    }
    ,{
      path: '/commodityOrder',
      name: '被购商品',
      component: commodityOrder
    }
    ,{
      path: '/publishCommodity',
      name: '发布商品',
      component: publishCommodity
    }
    ,{
      path: '/address',
      name: '地址信息',
      component: address
    }
    ,{
      path: '/config',
      name: '轮播图管理',
      component: config
    }
  ]
},
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/beforeLogin',
    name: 'beforeLogin',
    component: beforeLogin,
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
