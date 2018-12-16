<template>
  <div class="question_bank">
    <div class="breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>查看题库</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content">
      <div class="question_bank_amount">共 {{ filterQuestionList.length }} 条结果</div>
      <div class="question_bank_container">
        <div class="filter">
          <div class="subject">
            <div class="text">科目</div>
            <el-select class="select" v-model="subject" placeholder="科目" size="small" @change="subjectChange">
              <el-option
                v-for="subject in subjectOptions"
                :key="subject.value"
                :label="subject.value"
                :value="subject.index">
              </el-option>
            </el-select>
          </div>
          <div class="knowledge_point">
            <div class="text">知识点</div>
            <el-select class="select" v-model="knowledge_point" placeholder="知识点" size="small">
              <el-option
                v-for="knowledge_point in knowledgePointOptions"
                :key="knowledge_point.value"
                :label="knowledge_point.value"
                :value="knowledge_point.index">
              </el-option>
            </el-select>
          </div>
          <div class="question_type">
            <div class="text">题型</div>
            <el-select class="select" v-model="question_type" placeholder="题型" size="small">
              <el-option
                v-for="question_type in questionTypeOptions"
                :key="question_type.value"
                :label="question_type.value"
                :value="question_type.index">
              </el-option>
            </el-select>
          </div>
          <div class="difficulty_degree">
            <div class="text">难度</div>
            <el-select class="select" v-model="difficulty_degree" placeholder="难度" size="small">
              <el-option
                v-for="difficulty_degree in difficultyDegreeOptions"
                :key="difficulty_degree.value"
                :label="difficulty_degree.value"
                :value="difficulty_degree.index">
              </el-option>
            </el-select>
          </div>
          <div class="filter" @click="clickFilter">
            <div class="text">筛选</div>
          </div>
          <div class="reset" @click="reset">
            <div class="text">重置</div>
          </div>
        </div>
        <question-bank-list :questionList="filterQuestionList" />
      </div>
    </div>
  </div>
</template>

<script>
import QuestionBankList from "./questionBankList.vue";
import { QuestionService } from "src/service/question.js";

export default {
  data() {
    return {
      subject: null,
      knowledge_point: null,
      question_type: null,
      difficulty_degree: null,
      questionList: [],
      filterQuestionList: [],
      subjectOptions: [
        { value: "算法", index: 1, item: [
          { value: "查找", index: 1 }, { value: "排序", index: 2 }, { value: "递归", index: 3 }, { value: "贪心", index: 4 }, { value: "复杂度", index: 5 }
        ] }, 
        { value: "编程语言", index: 2, item: [
          { value: "C/C++", index: 6 }, { value: "Java", index: 7 }, { value: "JavaScript", index: 8 }, { value: "C#", index: 9 }, { value: "Python", index: 10 }, { value: "HTML/CSS", index: 11 }
        ] }, 
        { value: "数据结构", index: 3, item: [
          { value: "数组", index: 12 }, { value: "字符串", index: 13 }, { value: "链表", index: 14 }, { value: "栈", index: 15 }, { value: "队列", index: 16 }, { value: "树", index: 17 }, { value: "图", index: 18 }
        ] }, 
        { value: "计算机基础", index: 4, item: [
          { value: "网络基础", index: 19 }, { value: "正则表达式", index: 20 }, { value: "数据库", index: 21 }, { value: "操作系统", index: 22 }, { value: "编译和体系结构", index: 23 }
        ] }, 
        { value: "数学和逻辑", index: 5, item: [
          { value: "组合数学", index: 24 }, { value: "概率统计", index: 25 }, { value: "数量关系", index: 26 }, { value: "判断推理", index: 27 }, { value: "常识判断", index: 28 }
        ] }, 
        { value: "软件开发", index: 6, item: [
          { value: "软件工程", index: 29 }, { value: "软件测试", index: 30 }, { value: "面向对象", index: 31 }
        ] }, 
      ],
      knowledgePointOptions: [],
      questionTypeOptions: [
        { value: "单选题", index: 1 }, { value: "多选题", index: 2 }, { value: "填空题", index: 3 }, { value: "解答题", index: 4 }
      ],
      difficultyDegreeOptions: [
        { value: "一星", index: "1" }, { value: "二星", index: "2" }, { value: "三星", index: "3" }, { value: "四星", index: "4" }, { value: "五星", index: "5" }
      ],
    };
  },

  components: {
    QuestionBankList
  },

  mounted() {
    this.initData();
  },

  methods: {
    async initData() {
      this.questionList = await QuestionService.getAllOfQuestions();
      this.filterQuestionList = JSON.parse(JSON.stringify(this.questionList));
    },

    subjectChange(value) {
      this.knowledge_point = null;
      this.subjectOptions.forEach(subject => {
        if(subject.index === value) {
          this.knowledgePointOptions = subject.item;
        }
      });
    },

    clickFilter() {
      let tempQuestionList = [];
      this.filterQuestionList = JSON.parse(JSON.stringify(this.questionList));
      if(this.subject && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.subject_id == this.subject) {
            this.filterQuestionList.push(question);
          }
        });
      }
      if(this.knowledge_point && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.knowledge_point_id == this.knowledge_point) {
            this.filterQuestionList.push(question);
          }
        });
      }
      if(this.question_type && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.type_id == this.question_type) {
            this.filterQuestionList.push(question);
          }
        });
      }
      if(this.difficulty_degree && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.difficulty_degree == this.difficulty_degree) {
            this.filterQuestionList.push(question);
          }
        });
      }
      this.filterQuestionList = JSON.parse(JSON.stringify(this.filterQuestionList));
    },

    reset() {
      this.subject = null;
      this.knowledge_point = null;
      this.question_type = null;
      this.difficulty_degree = null;
      this.clickFilter();
    }
  }
};
</script>

<style lang="scss" scoped>
.question_bank {
  padding: 0.2rem 2.5rem;
  .breadcrumb {
    padding: 0.2rem;
    border-bottom: 1px solid #dddddd;
  }
  .content {
    margin-top: 0.3rem;

    .question_bank_amount {
      margin: 0 0.3rem;
      font-size: 0.2rem;
    }

    .question_bank_container {
      margin: 0.3rem;

      .filter {
        display: flex;
        justify-content: space-between;
        align-items: center;
        .subject {
          font-size: 0.2rem;
          width: 2.2rem;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .text {
            flex: 0 0 auto;
            margin-right: 0.1rem;
          }
        }
        .knowledge_point {
          font-size: 0.2rem;
          width: 2.2rem;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .text {
            flex: 0 0 auto;
            margin-right: 0.1rem;
          }
        }
        .question_type {
          font-size: 0.2rem;
          width: 2.2rem;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .text {
            flex: 0 0 auto;
            margin-right: 0.1rem;
          }
        }
        .difficulty_degree {
          font-size: 0.2rem;
          width: 2.2rem;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .text {
            flex: 0 0 auto;
            margin-right: 0.1rem;
          }
        }
        .filter {
          width: 0.5rem;
          height: 0.3rem;
          background-color: #55a7b6;
          color: #fff;
          border-radius: 0.06rem;;
          display: flex;
          justify-content: center;
          align-items: center;
          cursor: pointer;
        }
        .reset {
          width: 0.5rem;
          height: 0.3rem;
          background-color: #54b669;
          color: #fff;
          border-radius: 0.06rem;;
          display: flex;
          justify-content: center;
          align-items: center;
          cursor: pointer;
        }
        .text {
          font-size: 0.15rem;
        }
      }
    }
  }
}
</style>
