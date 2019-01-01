const state = {
  testPaper: {
    test_paper_id: null,
    creator_id: "",
    title: "",
    subject_id: null,
    total_score: null,
    difficulty_degree: null,
    school_year: "",
    semester: null
  }
}
const getters = {
  getTestPaper: state => {
    return state.testPaper
  }
}

const actions = {
  saveTestPaper({
    commit
  }, testPaper) {
    commit("SAVE_TEST_PAPER", testPaper);
  },

  clearAllTestPaperState({
    commit
  }) {
    commit("CLEAR_ALL_TEST_PAPER_STATE")
  }
}

const mutations = {
  SAVE_TEST_PAPER: (state, testPaper) => {
    state.testPaper.test_paper_id = testPaper.test_paper_id
    state.testPaper.creator_id = testPaper.creator_id
    state.testPaper.title = testPaper.title
    state.testPaper.subject_id = testPaper.subject_id
    state.testPaper.total_score = testPaper.total_score
    state.testPaper.difficulty_degree = testPaper.difficulty_degree
    state.testPaper.school_year = testPaper.school_year
    state.testPaper.semester = testPaper.semester
  },
  CLEAR_ALL_TEST_PAPER_STATE: (state) => {
    state.testPaper.test_paper_id = null
    state.testPaper.creator_id = ""
    state.testPaper.title = ""
    state.testPaper.subject_id = null
    state.testPaper.total_score = null
    state.testPaper.difficulty_degree = null
    state.testPaper.school_year = ""
    state.testPaper.semester = null
  }

}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
