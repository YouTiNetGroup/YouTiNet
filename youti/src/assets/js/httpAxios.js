import axios from 'axios';

axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';

export const request = (url = '', data = {}, method = 'POST') => {
  let config = {
    url: "http://localhost:8082" + url,
    data: data,
    method: method
  };
  if (method === 'POST') {
    return axios(config);
  } else {
    url = "http://localhost:8082" + url;
    return axios.get(url, {
      params: data
    });
  }
};
