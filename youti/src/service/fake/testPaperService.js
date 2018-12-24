export const FakeTestPaperService = {
  getTestPapersByAccountId: (account_id) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: 
        [
          {
            test_paper_id: 10001,
            creator_id: "admin",
            title: "2018-2019学年第一学期编程语言课程期末试卷",
            subject_id: 2,
            total_score: 100,
            difficulty_degree: "1",
            school_year: "2018-2019",
            semester: 1
          },
          {
            test_paper_id: 10002,
            creator_id: "admin",
            title: "2018-2019学年第一学期数据结构课程期末试卷",
            subject_id: 3,
            total_score: 100,
            difficulty_degree: "3",
            school_year: "2018-2019",
            semester: 1
          },
          {
            test_paper_id: 10003,
            creator_id: "admin",
            title: "2017-2018学年第一学期算法课程期末试卷",
            subject_id: 1,
            total_score: 100,
            difficulty_degree: "5",
            school_year: "2017-2018",
            semester: 1
          },
        ]
    });
  },

  modifyTestPaper: (testPaper) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },

  exportTestPaperById: (test_paper_id) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },

  deleteTestPaperById: (test_paper_id) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },

  autoGenerateTestPaper: (testPaper) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },

  manualGenerateTestPaper: (testPaper) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },

  getAllTestPapers: () => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: 
        [
          {
            test_paper_id: 10001,
            creator_id: "admin",
            title: "2018-2019学年第一学期编程语言课程期末试卷",
            subject_id: 2,
            total_score: 100,
            difficulty_degree: "1",
            school_year: "2018-2019",
            semester: 1
          },
          {
            test_paper_id: 10002,
            creator_id: "admin",
            title: "2018-2019学年第一学期数据结构课程期末试卷",
            subject_id: 3,
            total_score: 100,
            difficulty_degree: "3",
            school_year: "2018-2019",
            semester: 1
          },
          {
            test_paper_id: 10003,
            creator_id: "admin",
            title: "2017-2018学年第一学期算法课程期末试卷",
            subject_id: 1,
            total_score: 100,
            difficulty_degree: "5",
            school_year: "2017-2018",
            semester: 1
          },
        ]
    });
  },

  modifyTestPaperInformation: (testPaper) => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: ""
    });
  },
}