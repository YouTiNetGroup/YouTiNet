<template>
  <div class="test_paper_detail">
    <div class="breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/page/userCenter/myTestPaper' }">我的试卷</el-breadcrumb-item>
        <el-breadcrumb-item>试卷详情</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content">
      <div class="test_paper_container">
        <div class="head">
          <div class="title">{{ testPaper.title }}</div>
          <div class="detail">
            <div class="common_deatil">
              <div class="school_year">学年：{{ testPaper.school_year }}</div>
              <div class="semester">学期：第{{ testPaper.semester }}学期</div>
              <div class="subject_name">科目：{{ testPaper.subject_name }}</div>
              <div class="total_score">满分：{{ testPaper.total_score }} 分</div>
            </div>
            <div class="student_detail">
              <div class="class">班级：<span>__________________</span></div>
              <div class="student_number">学号：<span>__________________</span></div>
              <div class="student_name">姓名：<span>__________________</span></div>
            </div>
          </div>
        </div>
        <div class="body">
          <div class="big_question_container" v-for="(bigQuestion, index) in questions" :key="index">
            <div class="big_question_type">{{ getBigQuestionNo(index) + bigQuestion.title }}</div>
            <div class="small_questions_container">
              <div class="question_container" v-for="(smallQuestion, index) in bigQuestion.items" :key="index">
                <div class="question_detail">
                  <div class="no">{{ index + 1 }} 、</div>
                  <div class="question" v-html="smallQuestion.content "></div>
                </div>
                <div class="score">({{ smallQuestion.score }}分)</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import store from "src/store"
import { TestPaperService } from "src/service/testPaper.js";
import { QuestionService } from "src/service/question.js";

export default {
  data() {
    return {
      testPaper: {},
      questions: [],
    };
  },

  components: {},

  mounted() {
    this.initData();
  },

  destroyed() {
    store.dispatch('testPaper/clearAllTestPaperState');
  },

  methods: {
    async initData() {
      this.testPaper = await TestPaperService.getTestPaper();
      this.questions = await QuestionService.getTestPaperQuestions(this.$route.params.test_paper_id);
      this.questions = QuestionService.groupQuestionByQuestionType(this.questions);
    },

    getBigQuestionNo(index) {
      switch(index) {
        case 0: return "一、";
        case 1: return "二、";
        case 2: return "三、";
        case 3: return "四、";
        default: return "";
      }
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
    
    .test_paper_container {
      background: #eeeeee;
      display: flex;
      flex-direction: column;
      font-size: 0.2rem;
      .head {
        margin-top: 0.3rem;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        .title {
          font-size: 0.3rem;
          font-weight: bold;
        }
        .detail {
          margin: 0.2rem;
          width: 100%;
          display: flex;
          flex-direction: column;
          align-items: center;
          .common_deatil {
            width: 89%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            div {
              text-align: center;
            }
          }
          .student_detail {
            margin-top: 0.15rem;
            width: 89%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            div {
              text-align: center;
            }
          }
        }
      }
      .body {
        margin: 0.1rem 0.5rem;
        display: flex;
        flex-direction: column;
        align-items: center;
        .big_question_container {
          margin: 0.1rem 0;
          width: 100%;
          display: flex;
          flex-direction: column;
          align-items: flex-start;
          .big_question_type {
            margin: 0.1rem 0.1rem 0 0.1rem;
            font-size: 0.25rem;
            font-weight: bold;
          }
          .small_questions_container {
            margin: 0.1rem 0;
            width: 100%;
            .question_container {
              margin: 0.1rem;
              font-size: 0.2rem;
              line-height: 0.25rem;
              display: flex;
              justify-content: space-between;
              align-items: flex-start;
              .question_detail {
                display: flex;
                align-items: flex-start;
                .no {
                  flex: 0 0 auto;
                }
                .question {
                  max-width: 9rem;
                  /deep/ .subject-des li {
                    list-style-type: upper-alpha;
                    list-style-position: inside;
                    margin: 10px 0;
                  }
                }
              }
              .score {
                margin-left: 0.2rem;
                flex: 0 0 auto;
              }
            }
          }
        }
      }
    }
  }
}
</style>
