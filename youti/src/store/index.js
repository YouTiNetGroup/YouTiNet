import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import auth from './modules/auth'
import testPaper from './modules/testPaper'
import question from './modules/question'
import paperQuestion from './modules/paperQuestion'

Vue.use(Vuex)
const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
	modules: {
		auth,
		testPaper,
		question,
		paperQuestion
	},
	actions: {
		clearAll() {
			this.dispatch('auth/clearAllUserState');
			this.dispatch('testPaper/clearAllTestPaperState');
			this.dispatch('question/clearAllQuestionState');
			this.dispatch('paperQuestion/clearAllPaperQuestions');
		}
	},
	strict: debug,
	plugins: [createPersistedState()],
})
