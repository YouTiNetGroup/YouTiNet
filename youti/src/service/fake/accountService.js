export const FakeAccountService = {
  login: (account_id, password, privilege) => {
    if(account_id === "admin" && password === "admin") {
      return Promise.resolve({
        isSuccess: true,
        message: "",
        data: ""
      });
    } else {
      return Promise.resolve({
        isSuccess: false,
        message: "帐号或密码错误",
        data: null
      });
    }
  },
  createUser: (account_id, password, privilege) => {
    if(account_id === "admin" && password === "admin") {
      return Promise.resolve({
        isSuccess: true,
        message: "",
        data: ""
      });
    } else {
      return Promise.resolve({
        isSuccess: false,
        message: "帐号已注册",
        data: null
      });
    }
  },
  getUserInformation: (account_id) => {
    if(account_id === "admin") {
      return Promise.resolve({
        isSuccess: true,
        message: "成功",
        data: {
          account_id: "admin",
          password: "admin",
          name: "管理员",
          email: "1398128393@qq.com",
          phone: "15850633732",
          privilege: "admin"
        }
      });
    } else {
      return Promise.resolve({
        isSuccess: false,
        message: "帐号不存在",
        data: null
      });
    }
  },

  updateUserInformation: (userInfo) => {
    if(userInfo.account_id === "admin") {
      return Promise.resolve({
        isSuccess: true,
        message: "成功",
        data: {
          account_id: "admin",
          password: "admin",
          name: "管理员",
          email: "1398128393@qq.com",
          phone: "15850633732",
          privilege: "admin"
        }
      });
    } else {
      return Promise.resolve({
        isSuccess: false,
        message: "帐号不存在",
        data: null
      });
    }
  },
}