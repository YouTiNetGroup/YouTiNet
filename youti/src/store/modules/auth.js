const state = {
  userInfo: {
    account_id: "",
    password: "",
    name: "",
    email: "",
    phone: "",
    privilege: ""
  }
}
const getters = {
  getUserInfo: state => {
    return state.userInfo
  }
}

const actions = {
  saveUserInfo({
    commit
  }, userInfo) {
    commit('SAVE_USER_INFO', userInfo);
  },

  updateUserInfo({
    commit
  }, userInfo) {
    commit('SAVE_USER_INFO', userInfo);
  },

  clearAllUserState({
    commit
  }) {
    commit("CLEAR_ALL_USER_STATE")
  }
}

const mutations = {
  SAVE_USER_INFO: (state, userInfo) => {
    state.userInfo.account_id = userInfo.account_id
    state.userInfo.password = userInfo.password
    state.userInfo.name = userInfo.name
    state.userInfo.email = userInfo.email
    state.userInfo.phone = userInfo.phone
    state.userInfo.privilege = userInfo.privilege
  },

  CLEAR_ALL_USER_STATE: (state) => {
    state.userInfo.account_id = ""
    state.userInfo.password = ""
    state.userInfo.name = ""
    state.userInfo.email = ""
    state.userInfo.phone = ""
    state.userInfo.privilege = ""
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
