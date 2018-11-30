export default {
  getSubject: function (subject_id) {
    switch(subject_id) {
      case 1: return "算法";
      case 2: return "编程语言";
      case 3: return "数据结构";
      case 4: return "计算机基础";
      case 5: return "数学和逻辑";
      case 6: return "软件开发";
      default: return "";
    }
  },

  getKnowledgePoint: function (knowledge_point_id) {
    switch(knowledge_point_id) {
      case 1: return "查找";
      case 2: return "排序";
      case 3: return "递归";
      case 4: return "贪心";
      case 5: return "复杂度";
      case 6: return "C/C++";
      case 7: return "Java";
      case 8: return "JavaScript";
      case 9: return "C#";
      case 10: return "Python";
      case 11: return "HTML/CSS";
      case 12: return "数组";
      case 13: return "字符串";
      case 14: return "链表";
      case 15: return "栈";
      case 16: return "队列";
      case 17: return "树";
      case 18: return "图";
      case 19: return "网络基础";
      case 20: return "正则表达式";
      case 21: return "数据库";
      case 22: return "操作系统";
      case 23: return "编译和体系结构";
      case 24: return "组合数学";
      case 25: return "概率统计";
      case 26: return "数量关系";
      case 27: return "判断推理";
      case 28: return "常识判断";
      case 29: return "软件工程";
      case 30: return "软件测试";
      case 31: return "面向对象";
      default: return "";
    }
  },

  getQuestionType: function (type_id) {
    switch(type_id) {
      case 1: return "单选题";
      case 2: return "不定项选择题";
      case 3: return "填空题";
      case 4: return "问答题";
      default: return "";
    }
  },

  getDifficultyDegree: function (difficulty_degree) {
    switch(difficulty_degree) {
      case "1": return "一星";
      case "2": return "二星";
      case "3": return "三星";
      case "4": return "四星";
      case "5": return "五星";
      default: return "";
    }
  }
};