import Vue from 'vue'
import VueRouter  from 'vue-router'

import Login from 'src/page/account/login/login.vue'
import HelloWorld from 'src/components/HelloWorld'

Vue.use(VueRouter )

export default new VueRouter({
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
      path: '/home',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
