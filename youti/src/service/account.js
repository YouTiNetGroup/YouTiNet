import {
  request
} from '../assets/js/httpAxios'
import store from "src/store"
import { FakeAccountService } from "./fake/accountService.js";

const API = {
  login: {
    url: "/account/login",
    useFake: true
  },
  createUser: {
    url: "/account/createUser",
    useFake: true
  },
  getUserInfomation: {
    url: "/account/getUserInfomation",
    useFake: true
  },
}

export const AccountService = {
  hasLogin: () => {
    let currentUser = store.getters["auth/userInfo"];
    return currentUser && currentUser.userId;
  },
  logout: () => {
    store.dispatch("clearAll");
  },

  userlogin: async (params) => {
    let loginResponse = await login(params.account, params.password);
    if (!loginResponse || loginResponse.hr != 0 || !loginResponse.data) {
      return;
    }

    store.dispatch("clearAll");

    store.dispatch('auth/saveToken', loginResponse.data);

    let userInfoResponse = await getUserInfomation(params.account);
    if (!userInfoResponse || userInfoResponse.hr != 0 || !userInfoResponse.data) {
      return;
    }

    store.dispatch('auth/saveUserState', userInfoResponse.data);
    return userInfoResponse;
  },

  userRegister: async (params) => {
    let response = await createUser(params.account, params.password);
    if (!response || response.hr != 0) {
      return;
    }
    if (response.data == null) {
      return;
    }
    store.dispatch('auth/saveToken', response.data);
    return response;
  },

  saveUserInfo: async (params) => {
    let response = await getUserInfomation(params.account)
    if (!response || response.hr != 0) {
      return response;
    }
    if (response.data == null) {
      return response;
    }
    store.dispatch('auth/saveUserState', response.data);
    return response;
  },

  getUserInfo: () => {
    return store.getters["auth/userInfo"];
  },

  updateUser: async (displayName, gender, age) => {
    let params = {
      displayName,
      gender,
      age
    };
    let response = await request("/account/update", params, 'POST');
    if (!response || response.hr != 0) {
      return;
    }
    store.dispatch('auth/updateUserInfo', params);
    return response;
  },

  resetPassword: (account, password, oldPassword) => request('/account/resetPassword', {
    account,
    password,
    oldPassword
  }, 'POST'),
}

/**
 * 登录
 */
const login = (account, password) => {
  if (API.login.useFake) {
    return FakeAccountService.login(account, password);
  } else {
    return request(API.login.url, {
      account,
      password
    }, 'POST');
  }
}

/**
 * 注册用户
 */
const createUser = (account, password) => {
  if (API.createUser.useFake) {
    return FakeAccountService.createUser(account, password);
  } else {
    return request(API.createUser.url, {
      account,
      password
    }, 'POST');
  }
}

/**
 * 获取用户信息
 */
const getUserInfomation = (account) => {
  if (API.getUserInfomation.useFake) {
    return FakeAccountService.getUserInfomation(account);
  } else {
    return request(API.getUserInfomation.url, {
      account
    }, 'POST')
  }
};