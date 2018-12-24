// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import { router } from './router/index'
import ElementUI from 'element-ui';
import axios from 'axios';
import toast from './plugins/toast/toast';
import svgIcon from './components/common/svgIcon' // svg组件
import "src/assets/style/main.css";
import './assets/js/rem'
import 'element-ui/lib/theme-chalk/index.css';    // 默认主题

Vue.prototype.$axios = axios;
Vue.use(ElementUI);
Vue.use(toast);
Vue.use(VueRouter);

//全局注册svg通用组件
Vue.component('svg-icon', svgIcon);


//webpack 自动导入所有的svg ，导入之后就可以用 svg use 全局导入 
const requireAll = requireContext => requireContext.keys().map(requireContext)
const req = require.context('./assets/icons', true, /\.svg$/)
requireAll(req)

export const vueInstance = new Vue({
  router,
  render: h => h(App)
}).$mount('#app');