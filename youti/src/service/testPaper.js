import {
  request
} from '../assets/js/httpAxios'
import store from "src/store"
import { FakeTestPaperService } from "./fake/testPaperService.js";

const API = {
  getTestPapersByAccountId: {
    url: "/testPaper/getTestPapersByAccountId",
    useFake: false
  },
  modifyTestPaperInformation: {
    url: "/testPaper/modifyTestPaperInformation",
    useFake: false
  },
  exportTestPaperById: {
    url: "/testPaper/exportTestPaperById",
    useFake: false
  },
  deleteTestPaperById: {
    url: "/testPaper/deleteTestPaperById",
    useFake: false
  },
  autoGenerateTestPaper: {
    url: "/testPaper/autoGenerateTestPaper",
    useFake: false
  },
  manualGenerateTestPaper: {
    url: "/testPaper/manualGenerateTestPaper",
    useFake: false
  },
  getAllTestPapers: {
    url: "/testPaper/getAllTestPapers",
    useFake: false
  },
}

export const TestPaperService = {
  getUserTestPapers: async (account_id) => {
    let response = (await getTestPapersByAccountId(account_id)).data;
    if (!response || !response.isSuccess || !response.data) {
      return;
    }
    return response.data;
  },

  modifyUserTestPaper: async (testPaper) => {
    let response = (await modifyTestPaperInformation(testPaper)).data;
    return response;
  },
  
  exportTestPaper: async (test_paper_id) => {
    let response = (await exportTestPaperById(test_paper_id)).data;
    return response;
  },

  deleteTestPaper: async (test_paper_id) => {
    let response = (await deleteTestPaperById(test_paper_id)).data;
    return response;
  },

  autoGenerateUserTestPaper: async (testPaper) => {
    let response = (await autoGenerateTestPaper(testPaper)).data;
    return response;
  },

  manualGenerateUserTestPaper: async (testPaper) => {
    let response = (await manualGenerateTestPaper(testPaper)).data;
    return response;
  },

  saveTestPaper: (testPaper) => {
    store.dispatch('testPaper/saveTestPaper', testPaper);
  },

  getTestPaper: () => {
    return JSON.parse(JSON.stringify(store.getters['testPaper/getTestPaper']));
  },

  getAllOfTestPaper: async () => {
    let response = (await getAllTestPapers()).data;
    if (!response || !response.isSuccess || !response.data) {
      return;
    }
    return response.data;
  },

  modifyTestPaper: async (testPaper) => {
    let response = (await modifyTestPaperInformation(testPaper)).data;
    return response;
  }
}

/**
 * 获取用户的试卷
 */
const getTestPapersByAccountId = (account_id) => {
  if (API.getTestPapersByAccountId.useFake) {
    return FakeTestPaperService.getTestPapersByAccountId(account_id);
  } else {
    return request(API.getTestPapersByAccountId.url, {
      account_id
    }, 'GET');
  }
};

/**
 * 修改试卷信息
 */
const modifyTestPaperInformation = (testPaper) => {
  if (API.modifyTestPaperInformation.useFake) {
    return FakeTestPaperService.modifyTestPaperInformation(testPaper);
  } else {
    return request(API.modifyTestPaperInformation.url, {
      testPaper
    }, 'POST');
  }
};

/**
 * 导出用户的试卷
 */
const exportTestPaperById = (test_paper_id) => {
  if (API.exportTestPaperById.useFake) {
    return FakeTestPaperService.exportTestPaperById(test_paper_id);
  } else {
    return request(API.exportTestPaperById.url, {
      test_paper_id
    }, 'POST');
  }
};

/**
 * 删除试卷
 */
const deleteTestPaperById = (test_paper_id) => {
  if (API.deleteTestPaperById.useFake) {
    return FakeTestPaperService.deleteTestPaperById(test_paper_id);
  } else {
    return request(API.deleteTestPaperById.url, {
      test_paper_id
    }, 'POST');
  }
};

const autoGenerateTestPaper = (testPaper) => {
  if (API.autoGenerateTestPaper.useFake) {
    return FakeTestPaperService.autoGenerateTestPaper(testPaper);
  } else {
    return request(API.autoGenerateTestPaper.url, {
      testPaper
    }, 'POST');
  }
};

const manualGenerateTestPaper = (testPaper) => {
  if (API.manualGenerateTestPaper.useFake) {
    return FakeTestPaperService.manualGenerateTestPaper(testPaper);
  } else {
    return request(API.manualGenerateTestPaper.url, {
      testPaper
    }, 'POST');
  }
};

const getAllTestPapers = () => {
  if (API.getAllTestPapers.useFake) {
    return FakeTestPaperService.getAllTestPapers();
  } else {
    return request(API.getAllTestPapers.url, {}, 'GET');
  }
};