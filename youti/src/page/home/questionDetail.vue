<template>
  <div class="test_paper_detail">
    <div v-if="!isBackstage" class="breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/page/questionBank' }">查看题库</el-breadcrumb-item>
        <el-breadcrumb-item>题目详情</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content">
      <div class="question">
        <div class="head">
          <div class="subject">科目：{{ getSubject(question.subject_id) }}</div> | 
          <div class="knowledge_point">知识点：{{ getKnowledgePoint(question.knowledge_point_id) }}</div> | 
          <div class="question_type">题型：{{ getQuestionType(question.type_id) }}</div> | 
          <div class="difficulty_degree">难度：{{ getDifficultyDegree(question.difficulty_degree) }}</div>
        </div>
        <div class="body">
          <div class="question_content" v-html="question.content" @click="gotoQuestionDetail(index)"></div>
          <div class="score">({{ question.score }}分)</div>
        </div>
        <div class="foot">
          <div class="show_answer" @click="showAnswer = true">查看答案</div>
          <div v-if="showAnswer" class="answer" v-html="question.answer"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import common from "src/assets/js/common.js";
import { QuestionService } from "src/service/question.js";

export default {
  data() {
    return {
      isBackstage: false,
      question: {},
      showAnswer: false
    };
  },

  components: {},

  mounted() {
    this.initData();
  },

  methods: {
    async initData() {
      this.isBackstage = this.$route.name == "backQuestionDetail";
      this.question = await QuestionService.getQuestion();
    },

    getSubject(subject_id) {
      return common.getSubject(subject_id);
    },

    getKnowledgePoint(knowledge_point_id) {
      return common.getKnowledgePoint(knowledge_point_id);
    },

    getQuestionType(type_id) {
      return common.getQuestionType(type_id);
    },

    getDifficultyDegree(difficulty_degree) {
      return common.getDifficultyDegree(difficulty_degree);
    }
  }
};
</script>

<style lang="scss" scoped>
.test_paper_detail {
  padding: 0.2rem 2.5rem;
  .breadcrumb {
    padding: 0.2rem;
    border-bottom: 1px solid #dddddd;
  }
  .content {
    margin-top: 0.3rem;
    
    .question {
      width: 10rem;
      padding: 0.3rem 0.2rem;
      font-size: 0.2rem;
      display: flex;
      flex-direction: column;

      .head {
        color: #0493d3;
        display: flex;
        align-items: center;
        .subject {
          margin-right: 0.2rem;
        }
        .knowledge_point {
          margin: 0 0.2rem;
        }
        .question_type {
          margin: 0 0.2rem;
        }
        .difficulty_degree {
          margin: 0 0.2rem;
        }
      }

      .body {
        background: #eeeeee;
        margin-top: 0.3rem;
        display: flex;
        justify-content: space-between;
        align-items: flex-start;

        .question_content {
          /deep/ li {
            list-style-type: upper-alpha;
            list-style-position: inside;
            margin: 10px 0;
          }
        }

        .score {
          margin-left: 0.2rem;
          flex: 0 0 auto;
        }
      }

      .foot {
        margin-top: 0.3rem;
        padding-top: 0.3rem;
        border-top: 1px solid #dddddd;
        display: flex;
        flex-direction: column;
        .show_answer {
          width: 1.2rem;
          height: 0.5rem;
          border-radius: 0.04rem;
          font-size: 0.2rem;
          cursor: pointer;
          display: flex;
          justify-content: center;
          align-items: center;
          background: #0493d3;
          color: #ffffff;
        }
        .answer {
          margin-top: 0.5rem;
          background: #eeeeee
        }
      }
    }
  }
}
</style>
