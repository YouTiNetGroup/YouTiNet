import {
  SAVE_USER_STATE
} from '../mutation-types'

const state = {
  userInfo: {
    ssnInfos: [],
    userId: null,
    token: '',
    address: '',
    displayName: '',
    email: '',
    gender: '',
    identityCard: '',
    password: '',
    phone: '',
    phoneValid: false,
    avatar: '',
    userName: '',
    userType: null,
    userSchools: []
  }
}
const getters = {
  userInfo: state => {
    return state.userInfo
  },
  ssnInfos: state => {
    return state.userInfo.ssnInfos
  },
  userId: state => {
    return state.userInfo.userId
  },
  displayName: state => {
    return state.userInfo.displayName
  },
  avatar: state => {
    return state.userInfo.avatar
  },
  userName: state => {
    return state.userInfo.userName
  },
  userType: state => {
    return state.userInfo.userType
  },
  gender: state => {
    return state.userInfo.gender
  },
  email: state => {
    return state.userInfo.email
  },
  phone: state => {
    return state.userInfo.phone
  },
  token: state => {
    return state.userInfo.token
  },
  password: state => {
    return state.userInfo.password
  },
  phoneValid: state => {
    return state.userInfo.phoneValid
  },
  userSchools: state => {
    return state.userInfo.userSchools
  }
}

const actions = {
  saveToken({
    commit
  }, token) {
    commit('SAVE_TOKEN', token)
  },
  saveUserState({
    commit
  }, userInfo) {
    commit('SAVE_USER_STATE', userInfo);
  },

  updateUserInfo({
    commit
  }, params) {
    if (!params) {
      return;
    }
    params.displayName = params.displayName.trim()
    commit("UPDATE_DISPLAY_NAME", params.displayName);
  },

  updateUserPhone({
    commit
  }, params) {
    commit("UPDATE_USER_PHONE", params);
  },

  clearAllUserState({
    commit
  }) {
    commit("CLEAR_ALL_USER_STATE")
  }
}

const mutations = {
  SAVE_TOKEN: (state, token) => {
    state.userInfo.token = token
  },
  [SAVE_USER_STATE](state, userInfo) {
    state.userInfo.userId = userInfo.id
    state.userInfo.address = userInfo.address
    state.userInfo.displayName = userInfo.displayName
    state.userInfo.email = userInfo.email
    state.userInfo.gender = userInfo.gender
    state.userInfo.identityCard = userInfo.identityCard
    state.userInfo.phone = userInfo.phone
    state.userInfo.phoneValid = userInfo.phoneValid
    state.userInfo.avatar = userInfo.photoUrl
    state.userInfo.userName = userInfo.name
    state.userInfo.userType = userInfo.userType
    state.userInfo.ssnInfos = userInfo.ssnInfos
    state.userInfo.userSchools = userInfo.userSchools
  },
  UPDATE_DISPLAY_NAME: (state, newName) => {
    state.userInfo.displayName = newName
  },
  UPDATE_USER_PHONE: (state, phoneInfo) => {
    state.userInfo.phoneValid = phoneInfo.phoneValid;
    state.userInfo.phone = phoneInfo.phone;
  },
  CLEAR_ALL_USER_STATE: (state) => {
    state.userInfo.token = ''
    state.userInfo.userId = null
    state.userInfo.address = ''
    state.userInfo.displayName = ''
    state.userInfo.email = ''
    state.userInfo.gender = ''
    state.userInfo.identityCard = ''
    state.userInfo.password = ''
    state.userInfo.phone = ''
    state.userInfo.phoneValid = false
    state.userInfo.avatar = ''
    state.userInfo.userName = ''
    state.userInfo.userType = null
    state.userInfo.userSchools = []
    state.userInfo.ssnInfos = []
  }

}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
