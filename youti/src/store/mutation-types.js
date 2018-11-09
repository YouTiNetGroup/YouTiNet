//purchaseHistory module
export const SAVE_HISTORY = {
  type: 'SAVE_HISTORY',
  namespace: 'purchaseInfo/'
}

export const CLEAR_HISTORY_STATE = {
  type: 'CLEAR_HISTORY_STATE',
  namespace: 'purchaseInfo/'
}

// auth module 
export const SAVE_USER_STATE = 'SAVE_USER_STATE'
//quizInfo module
export const SAVE_QUIZ_LIST_INFO = 'SAVE_QUIZ_LIST_INFO'
export const SAVE_QUIZ_DETAIL = 'SAVE_QUIZ_DETAIL'
export const SET_STUDENT_ANSWER = 'SET_STUDENT_ANSWER'
export const SET_STUDENT_SCORE = 'SET_STUDENT_SCORE'
export const UPDATE_QUIZ_DETAIL = 'UPDATE_QUIZ_DETAIL'
export const RETEST = 'RETEST'
export const CLEAR_ALL_QUIZ = 'CLEAR_ALL_QUIZ'
export const CLEAR_QUIZ_BY_QUIZID = 'CLEAR_QUIZ_BY_QUIZID'
export const COLLECT_QUESTION = 'COLLECT_QUESTION'

// helpFeedIssues module 
export const SAVE_HELP_FEED_ISSUE = 'SAVE_HELP_FEED_ISSUE'

// courseDetail module
export const SAVE_COURSE_DETAIL = {
  type: 'SAVE_COURSE_DETAIL',
  namespace: 'courseDetail/'
}
export const UPDATE_COURSEWARE_STATE = {
  type: 'UPDATE_COURSEWARE_STATE',
  namespace: 'courseDetail/'
}
export const UPDATE_KNOWLEDGE_STATE = {
  type: 'UPDATE_KNOWLEDGE_STATE',
  namespace: 'courseDetail/'
}
export const UPDATE_QUIZ_IN_COURSE_DETAIL = {
  type: 'UPDATE_QUIZ_IN_COURSE_DETAIL',
  namespace: 'courseDetail/'
}

// behavior module

export const SAVE_PMT_ID = 'SAVE_PMT_ID'
export const SAVE_EXTRA = 'SAVE_EXTRA';
export const SAVE_BEHAVIOR_ITEM = 'SAVE_BEHAVIOR_ITEM'
export const CLOSE_TARGET_BEHAVIOR = 'CLOSE_TARGET_BEHAVIOR';
export const CLOSE_ALL_BEHAVIORS = 'CLOSE_ALL_BEHAVIORS';
export const ADD_BEHAVIORS_TO_UPLOAD_TASK = 'ADD_BEHAVIORS_TO_UPLOAD_TASK'
export const REMOVE_BEHAVIORS_FROM_UPLOAD_TASK = 'REMOVE_BEHAVIORS_FROM_UPLOAD_TASK'
export const REMOVE_BEHAVIOR_ITEMS = 'REMOVE_BEHAVIOR_ITEMS'
export const CLEAR_USER_BEHAVIOR = 'CLEAR_USER_BEHAVIOR'

//aplayer module
export const SAVE_RECOMMEND = {
  type: 'SAVE_RECOMMEND',
  namespace: 'aplayer/'
}