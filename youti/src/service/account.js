import {
  request
} from '../assets/js/httpAxios'
import store from "src/store"
import { FakeAccountService } from "./fake/accountService.js";

const API = {
  login: {
    url: "/account/login",
    useFake: false
  },
  register: {
    url: "/account/register",
    useFake: false
  },
  getUserInformation: {
    url: "/account/getUserInformation",
    useFake: false
  },
  updateUserInformation: {
    url: "/account/updateUserInformation",
    useFake: false
  },
  getAllUsers: {
    url: "/account/getAllUsers",
    useFake: false
  },
  deleteUserByAccountId: {
    url: "/account/deleteUserByAccountId",
    useFake: false
  },
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
    let response = (await login(params.account_id, params.password, params.privilege)).data;
    if (!response || !response.isSuccess) {
      return response;
    }
    store.dispatch("clearAll");
    return AccountService.saveUserInfo(params.account_id);
  },

  userRegister: async (params) => {
    let response = (await register(params.account_id, params.password, params.privilege)).data;
    if (!response || !response.isSuccess) {
      return response;
    }
    store.dispatch("clearAll");
    return AccountService.saveUserInfo(params.account_id);
  },

  saveUserInfo: async (account_id) => {
    let response = (await getUserInformation(account_id)).data;
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
    let response = (await updateUserInformation(userInfo)).data;
    if (!response || !response.isSuccess) {
      return response;
    }
    store.dispatch('auth/updateUserInfo', userInfo);
    return response;
  },

  getAllOfUsers: async () => {
    let response = (await getAllUsers()).data;
    if (!response || !response.isSuccess || !response.data) {
      return;
    }
    return response.data;
  },

  modifyUser: async (userInfo) => {
    let response = (await updateUserInformation(userInfo)).data;
    return response;
  },

  deleteUser: async (account_id) => {
    let response = (await deleteUserByAccountId(account_id)).data;
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
const register = (account_id, password, privilege) => {
  if (API.register.useFake) {
    return FakeAccountService.register(account_id, password, privilege);
  } else {
    return request(API.register.url, {
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

const getAllUsers = () => {
  if (API.getAllUsers.useFake) {
    return FakeAccountService.getAllUsers();
  } else {
    return request(API.getAllUsers.url, {}, 'GET');
  }
};

const deleteUserByAccountId = (account_id) => {
  if (API.deleteUserByAccountId.useFake) {
    return FakeAccountService.deleteUserByAccountId(account_id);
  } else {
    return request(API.deleteUserByAccountId.url, {
      account_id
    }, 'POST');
  }
};