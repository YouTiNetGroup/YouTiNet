import Vue from 'vue'
import VueRouter  from 'vue-router'
import Login from 'src/page/account/login/login.vue'
import Register from 'src/page/account/register/register.vue'
import Upload from 'src/page/upload/upload.vue'
import Page from 'src/page/home/page.vue'
import Home from 'src/page/home/home.vue'
import AutoGeneration from 'src/page/home/autoGeneration.vue'
import ManualGeneration from 'src/page/home/manualGeneration.vue'
import QuestionBank from 'src/page/home/questionBank.vue'
import QuestionDetail from 'src/page/home/questionDetail.vue'
import UserCenter from 'src/page/center/userCenter.vue'
import MyTestPaper from 'src/page/center/myTestPaper.vue'
import TestPaperDetail from 'src/page/center/testPaperDetail.vue'
import UserInfo from 'src/page/center/userInfo.vue'
import EditInfo from 'src/page/center/editInfo.vue'
import EditPwd from 'src/page/center/editPwd.vue'
import BackstageLogin from 'src/page/backstage/login.vue'
import Backstage from 'src/page/backstage/backstage.vue'
import BackstageHome from 'src/page/backstage/home.vue'
import UserManage from 'src/page/backstage/userManage.vue'
import TestPaperManage from 'src/page/backstage/testPaperManage.vue'
import QuestionManage from 'src/page/backstage/questionManage.vue'


Vue.use(VueRouter);

export const router = new VueRouter({
  routes: [
    {
			path: '/',
			redirect:'/page/home' //重定向
		},
		{
      path:'/login',//登陆
      name: 'login',
			component: Login
    },
    {
      path:'/register',//注册
      name: 'register',
			component: Register
    },
    {
      path:'/upload',//上传
      name: 'upload',
			component: Upload
    },
    {
      path: '/page',
      name: 'page',
      component: Page,
      redirect:'/page/home',
      children:[
        {
          path:'home',//主页
          name: 'home',
          component: Home
        },
        {
          path:'autoGeneration',//智能组卷
          name: 'autoGeneration',
          component: AutoGeneration
        },
        {
          path:'manualGeneration',//手动组卷
          name: 'manualGeneration',
          component: ManualGeneration
        },
        {
          path:'questionBank',//查看题库
          name: 'questionBank',
          component: QuestionBank
        },
        {
          path:'questionDetail/:question_id',//题目详情
          name: 'questionDetail',
          component: QuestionDetail
        },
        {
          path: 'testPaperDetail/:test_paper_id',//试卷详情
          name: 'testPaperDetail',
          component: TestPaperDetail
        },
        {
          path: 'userCenter',//个人中心
          name: 'userCenter',
          component: UserCenter,
          redirect: '/page/userCenter/userInfo',
          children:[
            {
              path: 'myTestPaper',//我的试卷
              name: 'myTestPaper',
              component: MyTestPaper
            },
            {
              path: 'userInfo',//用户信息
              name: 'userInfo',
              component: UserInfo
            },
            {
              path: 'editInfo',//修改信息
              name: 'editInfo',
              component: EditInfo
            },
            {
              path: 'editPwd',//修改密码
              name: 'editPwd',
              component: EditPwd
            },
          ]
        },
      ]
    },
    {
      path:'/backstageLogin',//后台登陆
      name: 'backstageLogin',
			component: BackstageLogin
    },
    {
      path: '/backstage',//后台
      name: 'backstage',
      component: Backstage,
      redirect:'/backstageLogin',
      children:[
        {
          path:'home',//主页
          name: 'backstageHome',
          component: BackstageHome
        },
        {
          path:'user',//用户管理
          name: 'userManage',
          component: UserManage
        },
        {
          path:'testPaper',//试卷管理
          name: 'testPaperManage',
          component: TestPaperManage
        },
        {
          path:'question',//题库管理
          name: 'questionManage',
          component: QuestionManage
        },
      ]
    }
  ]
})
