import {
  request
} from '../assets/js/httpAxios'
import store from "src/store"
import { QUESTION_TYPE } from "src/constant/common.js"
import { FakeQuestionService } from "./fake/questionService.js";

const API = {
  getAllQuestions: {
    url: "/question/getAllQuestions",
    useFake: false
  },
  getQuestionByTestPaperId: {
    url: "/question/getQuestionByTestPaperId",
    useFake: false
  },
  addQuestion: {
    url: "/question/addQuestion",
    useFake: false
  },
  modifyQuestionInformation: {
    url: "/question/modifyQuestionInformation",
    useFake: false
  },
  deleteQuestionById: {
    url: "/question/deleteQuestionById",
    useFake: false
  },
}

export const QuestionService = {
  getAllOfQuestions: async () => {
    let response = (await getAllQuestions()).data;
    if (!response || !response.isSuccess || !response.data) {
      return;
    }
    return response.data;
  },

  getTestPaperQuestions: async (test_paper_id) => {
    let response = (await getQuestionByTestPaperId(test_paper_id)).data;
    if (!response || !response.isSuccess || !response.data) {
      return;
    }
    return response.data;
  },

  groupQuestionByQuestionType: (questions) => {
    let questionTab = QuestionService.initQuestionTabs();
    if(!questions || !questions.length) {
      return questionTab;
    }
    let allQuestions = JSON.parse(JSON.stringify(questions));
    for (let i = 0; i < questionTab.length; i++) {
      for(let j = 0; j < allQuestions.length; j++) {
        if(questionTab[i].type === allQuestions[j].type_id) {
          questionTab[i].total++;
          questionTab[i].items.push(allQuestions[j]);
        }
      }
    }
    for (let i = 0; i < questionTab.length; i++) {
      if(questionTab[i].total == 0) {
        questionTab.splice(i, 1);
        i--;
      }
    }
    return questionTab;
  },

  initQuestionTabs: () => {
    return [{
      title: "单选题",
      type: QUESTION_TYPE.SINGLE_CHOICE,
      items: [],
      total: 0
    },
    {
      title: "多选题",
      type: QUESTION_TYPE.MULTIPLE_CHOICE,
      items: [],
      total: 0
    }, {
      title: "填空题",
      type: QUESTION_TYPE.FILL_IN_BLANK,
      items: [],
      total: 0
    },
    {
      title: "解答题",
      type: QUESTION_TYPE.ESSAY_QUESTION,
      items: [],
      total: 0
    }
    ];
  },

  addNewQuestion: async (question) => {
    let response = (await addQuestion(question)).data;
    return response;
  },

  modifyQuestion: async (question) => {
    let response = (await modifyQuestionInformation(question)).data;
    return response;
  },

  deleteQuestion: async (question_id) => {
    let response = (await deleteQuestionById(question_id)).data;
    return response;
  },

  saveQuestion: (question) => {
    store.dispatch('question/saveQuestion', question);
  },

  getQuestion: () => {
    return JSON.parse(JSON.stringify(store.getters['question/getQuestion']));
  },

  savePaperQuestion: (paperQuestion) => {
    return store.dispatch('paperQuestion/savePaperQuestion', paperQuestion);
  },

  updatePaperQuestion: (paperQuestion) => {
    return store.dispatch('paperQuestion/updatePaperQuestion', paperQuestion);
  },

  deletePaperQuestionById: (question_id) => {
    return store.dispatch('paperQuestion/deletePaperQuestionById', question_id);
  },

  getPaperQuestionById: (question_id) => {
    return JSON.parse(JSON.stringify(store.getters['paperQuestion/getPaperQuestionById'](question_id)));
  },

  getAllPaperQuestions: () => {
    return JSON.parse(JSON.stringify(store.getters['paperQuestion/getAllPaperQuestions']));
  },

}

/**
 * 获取所有题目
 */
const getAllQuestions = () => {
  if (API.getAllQuestions.useFake) {
    return FakeQuestionService.getAllQuestions();
  } else {
    return request(API.getAllQuestions.url, {}, 'GET');
  }
};

/**
 * 获取试卷的题目
 */
const getQuestionByTestPaperId = (test_paper_id) => {
  if (API.getQuestionByTestPaperId.useFake) {
    return FakeQuestionService.getQuestionByTestPaperId(test_paper_id);
  } else {
    return request(API.getQuestionByTestPaperId.url, {
      test_paper_id
    }, 'GET');
  }
};

/**
 * 添加题目
 */
const addQuestion = (question) => {
  if (API.addQuestion.useFake) {
    return FakeQuestionService.addQuestion(question);
  } else {
    return request(API.addQuestion.url, question, 'POST');
  }
};

/**
 * 修改题目信息
 */
const modifyQuestionInformation = (question) => {
  if (API.modifyQuestionInformation.useFake) {
    return FakeQuestionService.modifyQuestionInformation(question);
  } else {
    return request(API.modifyQuestionInformation.url, question, 'POST');
  }
};

/**
 * 删除题目
 */
const deleteQuestionById = (question_id) => {
  if (API.deleteQuestionById.useFake) {
    return FakeQuestionService.deleteQuestionById(question_id);
  } else {
    return request(API.deleteQuestionById.url, {
      question_id
    }, 'POST');
  }
};