import {
  request
} from '../assets/js/httpAxios'
import store from "src/store"
import { QUESTION_TYPE } from "src/constant/common.js"
import { FakeQuestionService } from "./fake/questionService.js";

const API = {
  getAllQuestions: {
    url: "/question/getAllQuestions",
    useFake: true
  },
  getQuestionByTestPaperId: {
    url: "/question/getQuestionByTestPaperId",
    useFake: true
  },
}

export const QuestionService = {
  getAllOfQuestions: async () => {
    let response = await getAllQuestions();
    if (!response || !response.isSuccess || !response.data) {
      return;
    }
    return response.data;
  },

  getTestPaperQuestions: async (test_paper_id) => {
    let response = await getQuestionByTestPaperId(test_paper_id);
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
      title: "不定项选择题",
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
      title: "问答题",
      type: QUESTION_TYPE.ESSAY_QUESTION,
      items: [],
      total: 0
    }
    ];
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