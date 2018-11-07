import axios from 'axios';
import store from 'src/store';
import {
  TOKEN_ERROR_TYPE
} from 'src/constant/common'
import {
  AccountService
} from "src/service/account";
import {
  router
} from 'src/router'
import {
  vueInstance
} from 'src/main'
import {
  HRESULT,
  APP_TYPE,
  CLIENT_TYPE,
  NET_TYPE
} from 'src/constant/common'
import NProgress from 'nprogress'

var buildConfig = require('../../../build/build.config.js')


axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.headers.common['User-Agent-QS'] = 'QSXT';

export const request = (url = '', data = {}, method = 'POST', version) => {
  if (version) {
    url = buildConfig.apiContext + version + url;
  } else {
    url = buildConfig.apiContext + buildConfig.apiVersion + url;
  }

  let config = {
    url: url,
    data: data,
    method: method
  };
  if (method === 'POST') {
    return axios(config);
  } else {
    return axios.get(url, {
      params: data
    });
  }
};

NProgress.configure({
  showSpinner: false
});

axios.interceptors.request.use(config => {
  if (!match(config.url, _noProgressFilter)) {
    NProgress.start()
  }
  return config
})

axios.interceptors.response.use(response => {
  if (!match(response.request.responseURL, _noProgressFilter)) {
    NProgress.done()
  }

  return response
})


// http request 拦截器
axios.interceptors.request.use(
  (config) => {
    if (config.url.indexOf('createAnonymous') == -1) {
      let token = store.getters['auth/token'];
      let anonymousToken = store.getters['device/anonymousToken']
      config.headers['Authorization-QS'] = token || anonymousToken;
    }

    let fingerprint = store.getters['device/fingerprint'];
    if (fingerprint) {
      config.headers['DeviceIdentifier-QS'] = fingerprint;
    }

    let deviceInfo = {
      netType: NET_TYPE.WIFI,
      appType: APP_TYPE.QSXT,
      clientType: CLIENT_TYPE.MSITE,
      deviceName: store.getters['device/deviceName'],
      osVersion: store.getters['device/os'],
      appVersion: store.getters['device/appVersion'],
      imei: "",
      mac: fingerprint,
      idfa: ""
    };

    config.headers['Device-Info-QS'] = JSON.stringify(deviceInfo);

    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

// http response 拦截器
axios.interceptors.response.use(
  (response) => {
    if (!match(response, _noToastFilter)) {
      if (!response.data) {
        vueInstance.$toast.text('服务器无响应');
      } else if (response.data.hr !== 0) {
        vueInstance.$toast.text(response.data.message);
      }
    }
    return response.data;
  },
  (error) => {
    if (error.response) {
      if (error.response.status === 401) {
        if (AccountService.hasLogin()) {
          showAlert(parseInt(error.response.headers['authorization-qs-code']));
          AccountService.logout();
          router.push('/login');
        } else {
          AccountService.logout();
        }

        return;
      }

      if (!match(error.response, _noToastFilter)) {
        switch (error.response.status) {
          case 404:
            vueInstance.$toast.text('服务器在开小差，请稍后重试~');
            return;
          case 504:
            vueInstance.$toast.text('请求超时，请稍后重试~');
            return;
          default:
            vueInstance.$toast.text('请求服务发生异常');
            return;
        }
      }
    } else {
      vueInstance.$toast.text('网络异常，请确认网络正常后重试');
    }
  }
);

const showAlert = (errorCode) => {
  switch (errorCode) {
    case TOKEN_ERROR_TYPE.E_AUTH_FAIL:
      alert('身份凭证校验失败，请重新登陆');
      break;
    case TOKEN_ERROR_TYPE.E_AUTH_EXPIRED:
      alert('您的账号信息已过期，请重新登陆');
      break;
    case TOKEN_ERROR_TYPE.E_AUTH_REPEATE_BROWSER:
      alert('您的账号刚刚在其他浏览器登陆，如果不是本人操作，请及时修改账号密码保证账号安全');
      break;
    case TOKEN_ERROR_TYPE.E_AUTH_REPEATE_CILENT:
      alert('您的账号刚刚在其他客户端登陆，如果不是本人操作，请及时修改账号密码保证账号安全');
      break;
    default:
      alert('您的账号刚刚在其他设备登陆，如果不是本人操作，请及时修改账号密码保证账号安全');
      break;
  }
}

const match = (value, filter) => {
  if (!filter || !filter.filterItems || 0 == filter.filterItems.length) {
    return false;
  }

  for (let i = 0; i < filter.filterItems.length; i++) {
    if (filter.match(value, filter.filterItems[i])) {
      return true;
    }
  }
  return false;
}

/**
 * 过滤器
 * 作用:决定是否在拦截响应时toast提示信息
 * filterItems:指定过滤项
 *      url: String 不需要toast的请求地址
 *      hr: Array 不需要toast的响应hr，若不指定则全部都不需要toast
 */
const _noToastFilter = {
  filterItems: [{
    url: 'getUserSchoolList',
    hr: [HRESULT.NO_DATA]
  },
  {
    url: '/account/bindIdentifyInfo',
    hr: [HRESULT.OK, HRESULT.BIND_FAILURE, HRESULT.BIND_MERGE]
  },
  {
    url: '/behavior',
    hr: []
  },
  {
    url: '/catalog/recommend',
    hr: []
  }
  ],
  match(response, filterItem) {
    if (!response.request || !response.request.responseURL) {
      return false;
    }
    if (response.request.responseURL.indexOf(filterItem.url) == -1) {
      return false;
    }

    if (!filterItem.hr || 0 == filterItem.hr.length) {
      return true;
    } else {
      for (let i = 0; i < filterItem.hr.length; ++i) {
        if (filterItem.hr[i] == response.data.hr) {
          return true;
        }
      }
    }
    return false;
  }
}

const _noProgressFilter = {
  filterItems: ['/account/createAnonymous', '/purchase/history', '/purchase/getOffers', '/behavior/', '/catalog/recommend', '/catalog/keyword'],
  match(url, filterItem) {
    if (!url) {
      return false;
    }
    if (url.indexOf(filterItem) == -1) {
      return false;
    } else {
      return true;
    }
  }
}
