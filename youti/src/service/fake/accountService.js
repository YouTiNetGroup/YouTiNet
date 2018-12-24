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
  register: (account_id, password, privilege) => {
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
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },

  getAllUsers: () => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: 
        [
          {
            account_id: "admin",
            password: "admin",
            name: "管理员",
            email: "1398128393@qq.com",
            phone: "15850633732",
            privilege: "admin"
          },
          {
            account_id: "zxm",
            password: "zxm",
            name: "张兴明",
            email: "1398128393@qq.com",
            phone: "15850633732",
            privilege: "user"
          },
          {
            account_id: "syf",
            password: "syf",
            name: "孙云峰",
            email: "8765456@qq.com",
            phone: "13956789765",
            privilege: "user"
          },
          {
            account_id: "zpy",
            password: "zpy",
            name: "张鹏翼",
            email: "9876678@qq45663234.com",
            phone: "18887656767",
            privilege: "user"
          },
        ]
    });
  },

  // modifyUserInformation: (userInfo) => {
  //   return Promise.resolve({
  //     isSuccess: true,
  //     message: "成功",
  //     data: ""
  //   });
  // },

  deleteUserByAccountId: (account_id) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },
}