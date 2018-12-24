const state = {
  paperQuestions: []
}

const getters = {
  getAllPaperQuestions: state => {
    return state.paperQuestions;
  },

  getPaperQuestionById: state => (question_id) => {
    let result = [];
    if (!state.paperQuestions) {
      return result;
    }
    for (let i = 0; i < state.paperQuestions.length; i++) {
      if (state.paperQuestions[i].question_id == question_id) {
        result.push(state.paperQuestions[i]);
      }
    }
    return result;
  },
}

const actions = {
  savePaperQuestion({
    commit
  }, paperQuestion) {
    commit("SAVE_PAPER_QUESTION", paperQuestion);
  },

  updatePaperQuestion({
    commit
  }, paperQuestion) {
    commit("UPDATE_PAPER_QUESTION", paperQuestion);
  },

  deletePaperQuestionById({
    commit
  }, question_id) {
    commit("DELETE_PAPER_QUESTION_BY_ID", question_id);
  },

  clearAllPaperQuestions({ commit }) {
    commit("CLEAR_ALL_PAPER_QUESTIONS")
  }
}

const mutations = {
  SAVE_PAPER_QUESTION: (state, paperQuestion) => {
    let i = 0;
    for (; i < state.paperQuestions.length; i++) {
      if(state.paperQuestions[i].question_id == paperQuestion.question_id) {
        break;
      }
    }
    if (i == state.paperQuestions.length) {
      state.paperQuestions.push(paperQuestion);
      return true;
    }
    return false;
  },

  UPDATE_PAPER_QUESTION: (state, paperQuestion) => {
    let i = 0;
    for (; i < state.paperQuestions.length; i++) {
      if (state.paperQuestions[i].question_id == paperQuestion.question_id) {
        state.paperQuestions.splice(i, 1, paperQuestion);
        return true;
      }
    }
    return false;
  },

  DELETE_PAPER_QUESTION_BY_ID: (state, question_id) => {
    let i = 0;
    for (; i < state.paperQuestions.length; i++) {
      if (state.paperQuestions[i].question_id == question_id) {
        state.paperQuestions.splice(i, 1);
        return true;
      }
    }
    return false;
  },

  CLEAR_ALL_PAPER_QUESTIONS: (state) => {
    state.paperQuestions = []
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}