import {
  request
} from '../assets/js/httpAxios'
import store from "src/store"
import { FakeTestPaperService } from "./fake/testPaperService.js";

const API = {
  getTestPapersByAccountId: {
    url: "/testPaper/getTestPapersByAccountId",
    useFake: true
  },
  modifyTestPaper: {
    url: "/testPaper/modifyTestPaper",
    useFake: true
  },
  exportTestPaper: {
    url: "/testPaper/exportTestPaper",
    useFake: true
  },
  deleteTestPaper: {
    url: "/testPaper/deleteTestPaper",
    useFake: true
  },
  autoGenerateTestPaper: {
    url: "/testPaper/autoGenerateTestPaper",
    useFake: true
  },
  manualGenerateTestPaper: {
    url: "/testPaper/manualGenerateTestPaper",
    useFake: true
  },
}

export const TestPaperService = {
  getUserTestPapers: async (account_id) => {
    let response = await getTestPapersByAccountId(account_id);
    if (!response || !response.isSuccess || !response.data) {
      return;
    }
    return response.data;
  },

  modifyUserTestPaper: async (testPaper) => {
    let response = await modifyTestPaper(testPaper);
    return response;
  },
  
  exportUserTestPaper: async (account_id, test_paper_id) => {
    let response = await exportTestPaper(account_id, test_paper_id);
    return response;
  },

  deleteUserTestPaper: async (account_id, test_paper_id) => {
    let response = await deleteTestPaper(account_id, test_paper_id);
    return response;
  },

  autoGenerateUserTestPaper: async (testPaper) => {
    let response = await autoGenerateTestPaper(testPaper);
    return response;
  },

  manualGenerateUserTestPaper: async (testPaper) => {
    let response = await manualGenerateTestPaper(testPaper);
    return response;
  },

  saveTestPaper: (testPaper) => {
    store.dispatch('testPaper/saveTestPaper', testPaper);
  },

  getTestPaper: () => {
    return JSON.parse(JSON.stringify(store.getters['testPaper/getTestPaper']));
  },
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

const modifyTestPaper = (testPaper) => {
  if (API.modifyTestPaper.useFake) {
    return FakeTestPaperService.modifyTestPaper(testPaper);
  } else {
    return request(API.modifyTestPaper.url, {
      testPaper
    }, 'POST');
  }
};

/**
 * 导出用户的试卷
 */
const exportTestPaper = (account_id, test_paper_id) => {
  if (API.exportTestPaper.useFake) {
    return FakeTestPaperService.exportTestPaper(account_id, test_paper_id);
  } else {
    return request(API.exportTestPaper.url, {
      account_id,
      test_paper_id
    }, 'POST');
  }
};

/**
 * 删除用户的试卷
 */
const deleteTestPaper = (account_id, test_paper_id) => {
  if (API.deleteTestPaper.useFake) {
    return FakeTestPaperService.deleteTestPaper(account_id, test_paper_id);
  } else {
    return request(API.deleteTestPaper.url, {
      account_id,
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