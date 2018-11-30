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
  getUserInformation: {
    url: "/account/getUserInformation",
    useFake: true
  },
  updateUserInformation: {
    url: "/account/updateUserInformation",
    useFake: true
  }
}

export const AccountService = {
  hasLogin: () => {
    let userInfo = store.getters["auth/getUserInfo"];
    return userInfo && userInfo.account_id;
  },
  logout: () => {
    store.dispatch("clearAll");
  },

  userlogin: async (params) => {
    let response = await login(params.account_id, params.password, params.privilege);
    if (!response || !response.isSuccess) {
      return response;
    }
    store.dispatch("clearAll");
    return AccountService.saveUserInfo(params.account_id);
  },

  userRegister: async (params) => {
    let response = await createUser(params.account_id, params.password, params.privilege);
    if (!response || !response.isSuccess) {
      return response;
    }
    store.dispatch("clearAll");
    return AccountService.saveUserInfo(params.account_id);
  },

  saveUserInfo: async (account_id) => {
    let response = await getUserInformation(account_id);
    if (!response || !response.isSuccess || !response.data) {
      return response;
    }
    store.dispatch('auth/saveUserInfo', response.data);
    return response;
  },

  getUserInfo: () => {
    return JSON.parse(JSON.stringify(store.getters["auth/getUserInfo"]));
  },

  updateUser: async (userInfo) => {
    let response = await updateUserInformation(userInfo);
    if (!response || !response.isSuccess) {
      return response;
    }
    store.dispatch('auth/updateUserInformation', userInfo);
    return response;
  },

}

/**
 * 登录
 */
const login = (account_id, password, privilege) => {
  if (API.login.useFake) {
    return FakeAccountService.login(account_id, password, privilege);
  } else {
    return request(API.login.url, {
      account_id,
      password,
      privilege
    }, 'POST');
  }
}

/**
 * 注册用户
 */
const createUser = (account_id, password, privilege) => {
  if (API.createUser.useFake) {
    return FakeAccountService.createUser(account_id, password, privilege);
  } else {
    return request(API.createUser.url, {
      account_id,
      password,
      privilege
    }, 'POST');
  }
}

/**
 * 获取用户信息
 */
const getUserInformation = (account_id) => {
  if (API.getUserInformation.useFake) {
    return FakeAccountService.getUserInformation(account_id);
  } else {
    return request(API.getUserInformation.url, {
      account_id
    }, 'GET');
  }
};

/**
 * 修改用户信息
 */
const updateUserInformation = (userInfo) => {
  if (API.updateUserInformation.useFake) {
    return FakeAccountService.updateUserInformation(userInfo);
  } else {
    return request(API.updateUserInformation.url, userInfo, 'POST');
  }
};