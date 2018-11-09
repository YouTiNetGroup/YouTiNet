import Vue from 'vue'
import VueRouter  from 'vue-router'

import Login from 'src/page/account/login/login.vue'
import Register from 'src/page/account/register/register.vue'
import HelloWorld from 'src/page/home/home.vue'
import Upload from 'src/page/upload/upload.vue'

Vue.use(VueRouter )

export const router = new VueRouter({
  mode: 'history',
  routes: [
    {
			path: '/',
			redirect:'/login' //重定向
		},
		{
      path:'/login',//登陆
      name: 'login',
			component: Login
    },
    {
      path:'/register',//登陆
      name: 'register',
			component: Register
		},
    {
      path: '/home',
      name: 'home',
      component: HelloWorld
    },
    {
      path: '/upload',
      name: 'upload',
      component: Upload
    }
  ]
})
