// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import axios from 'axios';
import toast from './plugins/toast/toast';
import "src/assets/style/main.css";

import 'element-ui/lib/theme-chalk/index.css';    // 默认主题

Vue.prototype.$axios = axios;
Vue.use(ElementUI);
Vue.use(toast);
Vue.use(VueRouter)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
