import {
  request
} from '../assets/js/httpAxios'

export const UploadService = {
  uploadSingleFile: async (formData) => {
    let response = await singleFile(formData);
    if (!response || response.hr != 0 || !response.data) {
      return;
    }
    return response;
  }
}

/**
 * 上传单个文件
 */
const singleFile = (formData) => request('/upload/singleFile', {
  formData: formData,
}, 'POST');