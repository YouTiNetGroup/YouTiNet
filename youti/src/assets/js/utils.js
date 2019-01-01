import md5 from "js-md5";

const upperCaseNumber = ['零', '一', '二', '三', '四', '五', '六', '七', '八', '九', '十'];
const maxNumber = 99

export const numberConvertToUppercase = (number) => {
  var num = Number(number);
  if (num > maxNumber) {
    throw "The number of " + num + "is greater than 99"
  }
  var length = String(num).length;
  if (length == 1) {
    return upperCaseNumber[num];
  } else if (length == 2) {
    if (num == 10) {
      return upperCaseNumber[num];
    } else if (num > 10 && num < 20) {
      return '十' + upperCaseNumber[String(num).charAt(1)];
    } else {
      return upperCaseNumber[String(num).charAt(0)] + '十' + upperCaseNumber[String(num).charAt(1)].replace('零', '');
    }
  }
  return num
}


/**
 * 计算数字签名
 * @param {Object} data JS对象，用于计算数字签名
 */
export const computeSign = (data) => {
  let result = doCompute(data) || "";

  if (result && result[result.length - 1] === '&') {
    result = result.substr(0, result.length - 1);
  }

  const key = 'l5d7j4xlq22pfwr3a0j7t17ki0scaz6q';
  return md5(result + key);
}

const doCompute = (data) => {
  let result = '';
  if (!data) {
    return result;
  }
  if (typeof data !== 'object') {
    return result;
  }

  let keys = Object.keys(data);
  keys.sort(function (a, b) {
    return a.toLowerCase().localeCompare(b.toLowerCase());
  });

  let signOfArr = "";
  keys.forEach(k => {
    let value = data[k] === null ? '' : data[k];
    if (value instanceof Array) {
      value.forEach(k => {
        signOfArr = signOfArr + doCompute(k);
      });
    } else {
      result = result + k + '=' + value + '&';
    }
  });

  result = result + signOfArr;

  return result;
}

/**
 * 验证手机号码的合法性
 */
export const checkPhoneIllegal = (phone) => {
  return /^1\d{10}$/gi.test(phone);
}




export const fireOnlineFresh = () => {
  if (window.addEventListener) {
    window.addEventListener('online', function () { window.location.reload() }, true)
  }
}

export const offOnlineFresh = () => {
  if (window.addEventListener) {
    window.removeEventListener('online', function () { window.location.reload() }, true)
  }
}

export const isEmptyArray = (array) => {
  if (array == null) {
    return true;
  }
  if (!Array.isArray(array)) {
    throw "Parameter is not an array!";
  }
  return array.length == 0;
}

export const isNotEmptyArray = (array) => {
  return !isEmptyArray(array);
}

var _ = require("lodash")
//check if an array contains a special item by property values 
export const includes = (array, item) => {
  for (let i = 0; i < array.length; i++) {
    let v = array[i];
    if (_.isEqual(v, item)) {
      return true;
    }
  }

  return false;
}

export const notIncludes = (array, item) => {
  return !includes(array, item);
}

export const computeRem = (size) => {
  const num = Number(size);
  var docEl = document.documentElement
  const rem = new Float32Array(docEl.style.fontSize.match(/\d+/))
  return num / rem;
}

export const convertRem2PX = (rem) => {
  const num = Number(rem);
  var docEl = document.documentElement;
  const px = new Float32Array(docEl.style.fontSize.match(/\d+/));
  return num * px;
}

const preventPageScroll = e => {
  return e.preventDefault();
}
export const pageScroll = {
  prevent: () => {
    document.addEventListener('touchmove', preventPageScroll, false);
  },
  recover: () => {
    document.removeEventListener('touchmove', preventPageScroll, false);
  }
}

export const timeStamp2Date = (timeStamp) => {
  let date = new Date(timeStamp);
  return date.toJSON().slice(0, 10);
}

export const getParameterByName = (name, search) => {
  if (!search) {
    search = window.location.search;
  }
  name = name.replace(/[[\]]/g, '\\$&');
  var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
    results = regex.exec(search);
  if (!results) return null;
  if (!results[2]) return '';
  return decodeURIComponent(results[2].replace(/\+/g, ' '));
}

export const browser = {

  versions: function () {

    var u = navigator.userAgent;

    return {
      trident: u.indexOf('Trident') > -1,

      presto: u.indexOf('Presto') > -1,

      webKit: u.indexOf('AppleWebKit') > -1,

      gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,

      mobile: !!u.match(/AppleWebKit.*Mobile.*/),

      ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),

      android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1,

      iPhone: u.indexOf('iPhone') > -1,

      iPad: u.indexOf('iPad') > -1,

      iPod: u.indexOf('iPod') > -1,

      symbianOS: u.indexOf('SymbianOS') > -1,

      windowsPhone: u.indexOf('Windows Phone') > -1,

      webApp: u.indexOf('Safari') == -1,

      souyue: u.indexOf('souyue') > -1,

      superapp: u.indexOf('superapp') > -1,

      weixin: u.toLowerCase().indexOf('micromessenger') > -1,

      Safari: u.indexOf('Safari') > -1,

      Chrome: /Chrome/.test(u) && /Google Inc/.test(navigator.vendor),

      IOSVerision: function () {
        var v = (navigator.appVersion).match(/OS (\d+)_(\d+)_?(\d+)?/)
        return [parseInt(v[1], 10), parseInt(v[2], 10), parseInt(v[3] || 0, 10)]
      }
    };
  }(),

  language: (navigator.browserLanguage || navigator.language).toLowerCase(),

  isIphoneX: function () {
    if (browser.versions.ios) {
      let width =
        window.innerWidth ||
        document.documentElement.clientWidth ||
        document.body.clientWidth;
      let height =
        window.innerHeight ||
        document.documentElement.clientHeight ||
        document.body.clientHeight;
      return width / height == 375 / 812;
    }
    return false;
  }
};