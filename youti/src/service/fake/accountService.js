export const FakeAccountService = {
  login: (account, password) => {
    if(account === "admin" && password === "admin") {
      return Promise.resolve({
        hr: 0,
        message: "",
        data: "eyJraWQiOiIwIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJuaWNrIjoi5Y-25a2QMStwcGUiLCJhcHBUeXBlIjoyLCJuYW1lIjoicHhfeWV6aSIsImV4cCI6MTUzMzQzMjQwMCwianRpIjoiMTIwMTcxNSJ9.N-C7Gz_RCNyXEgdQZ1r6uDzPHSJwLI0qpjxBqVr4rug"
      });
    } else {
      return Promise.resolve({
        hr: -1,
        message: "帐号或密码错误",
        data: null
      });
    }
  },
  createUser: (account, password) => {
    if(account === "admin" && password === "admin") {
      return Promise.resolve({
        hr: 0,
        message: "",
        data: "eyJraWQiOiIwIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJuaWNrIjoi5Y-25a2QMStwcGUiLCJhcHBUeXBlIjoyLCJuYW1lIjoicHhfeWV6aSIsImV4cCI6MTUzMzQzMjQwMCwianRpIjoiMTIwMTcxNSJ9.N-C7Gz_RCNyXEgdQZ1r6uDzPHSJwLI0qpjxBqVr4rug"
      });
    } else {
      return Promise.resolve({
        hr: -1,
        message: "帐号已注册",
        data: null
      });
    }
  },
  getUserInfomation: (account) => {
    if(account === "admin") {
      return Promise.resolve({
        hr: 0,
        message: "成功",
        data: {
          id: 1001,
          account: "admin",
          displayName: "管理员帐号",
          gender: "男",
          age: 20,
          userType: "系统管理员"
        }
      });
    } else {
      return Promise.resolve({
        hr: -1,
        message: "帐号不存在",
        data: null
      });
    }
  }
}