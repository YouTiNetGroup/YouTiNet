const state = {
  question: {
    question_id: null,
    type_id: null,
    content: "",
    answer: "",
    score: null,
    difficulty_degree: "",
    subject_id: null,
    knowledge_point_id: null
  }
}
const getters = {
  getQuestion: state => {
    return state.question
  }
}

const actions = {
  saveQuestion({
    commit
  }, question) {
    commit("SAVE_QUESTION", question);
  },

  clearAllQuestionState({
    commit
  }) {
    commit("CLEAR_ALL_QUESTION_STATE")
  }
}

const mutations = {
  SAVE_QUESTION: (state, question) => {
    state.question.question_id = question.question_id
    state.question.type_id = question.type_id
    state.question.content = question.content
    state.question.answer = question.answer
    state.question.score = question.score
    state.question.difficulty_degree = question.difficulty_degree
    state.question.subject_id = question.subject_id
    state.question.knowledge_point_id = question.knowledge_point_id
  },
  CLEAR_ALL_QUESTION_STATE: (state) => {
    state.question.question_id = null
    state.question.type_id = null
    state.question.content = ""
    state.question.answer = ""
    state.question.score = null
    state.question.difficulty_degree = ""
    state.question.subject_id = null
    state.question.knowledge_point_id = null
  }

}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
