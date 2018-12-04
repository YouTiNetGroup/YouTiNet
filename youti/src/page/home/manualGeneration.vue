<template>
  <div class="manual_generation">
    <div class="breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>手动组卷</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content">
      <div v-if="allQuestions.length" class="question_list_container">试题篮
        <div v-if="bigQuestion.items.length" class="big_question_container" v-for="(bigQuestion, index) in paperQuestions" :key="index">
          <div class="big_question_type">{{ getBigQuestionNo(index) + bigQuestion.title }}</div>
          <div class="small_questions_container">
            <draggable v-model="bigQuestion.items">
              <div class="question_container" v-for="(smallQuestion, index) in bigQuestion.items" :key="index">
                <div class="head">
                  <div class="subject">科目：{{ getSubject(smallQuestion.subject_id) }}</div> | 
                  <div class="knowledge_point">知识点：{{ getKnowledgePoint(smallQuestion.knowledge_point_id) }}</div> | 
                  <div class="question_type">题型：{{ getQuestionType(smallQuestion.type_id) }}</div> | 
                  <div class="difficulty_degree">难度：{{ getDifficultyDegree(smallQuestion.difficulty_degree) }}</div>
                </div>
                <div class="body">
                  <div class="question_detail">
                    <div class="no">{{ index + 1 }} 、</div>
                    <div class="question" v-html="smallQuestion.content "></div>
                  </div>
                  <div class="score">({{ smallQuestion.score }}分)</div>
                </div>
                <div class="foot">
                  <div class="change_score">修改分值
                    <el-input-number class="counter" v-model="smallQuestion.score" @change="handleChange(smallQuestion)" 
                      :min="getMin(bigQuestion.type)" :max="getMax(bigQuestion.type)" size="mini" label="分值"></el-input-number>
                  </div>
                  <div class="delete_question" @click="deletePaperQuestion(smallQuestion)">删除</div>
                </div>
              </div>
            </draggable>
          </div>
        </div>
        <div class="test_paper_info">
          <el-form class="form" ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="试卷名" prop="title">
              <el-input v-model="form.title"></el-input>
            </el-form-item>
            <el-form-item label="学年" prop="school_year">
              <el-select v-model="form.school_year" placeholder="学年">
                <el-option
                  v-for="school_year in schoolYearOptions"
                  :key="school_year.value"
                  :label="school_year.value"
                  :value="school_year.value">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="学期" prop="semester">
              <el-select v-model="form.semester" placeholder="学期">
                <el-option
                  v-for="semester in semesterOptions"
                  :key="semester.value"
                  :label="semester.value"
                  :value="semester.value">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="科目" prop="subject">
              <el-select v-model="form.subject" placeholder="科目">
                <el-option
                  v-for="subject in subjectOptions"
                  :key="subject.id"
                  :label="subject.value"
                  :value="subject.id">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="难度" prop="difficulty_degree">
              <div class="difficulty_degree">{{ difficulty_degree }}</div>
            </el-form-item>
          </el-form>
        </div>
        <div class="bottom">
          <div class="total_score">总分：{{ total_score }}</div>
          <div class="button">
            <div class="generate_test_paper" @click="generateTestPaper('form')">{{ isModifyTestPaper ? "保存修改": "生成试卷" }}</div>
            <div class="clear_paper_questions" @click="clearPaperQuestions">{{ isModifyTestPaper ? "取消": "清空" }}</div>
          </div>
        </div>
      </div>
      <div v-else class="no_data">
        <div class="text">暂无试题，请先前往题库添加试题。</div>
        <div class="goto_question_bank" @click="gotoQuestionBank">立即前往</div>
      </div>
    </div>
  </div>
</template>

<script>
import store from "src/store"
import draggable from "vuedraggable";
import common from "src/assets/js/common.js";
import { globalBus } from "src/service/globalBus";
import { AccountService } from "src/service/account.js";
import { QuestionService } from "src/service/question.js";
import { TestPaperService } from "src/service/testPaper.js";

export default {
  data() {
    return {
      total_score: 0,
      modifyTestPaper: null,
      isModifyTestPaper: false,
      allQuestions: [],
      paperQuestions: [],
      form: {},
      difficulty_degree: 0,
      schoolYearOptions: [
        { value: "2018-2019" }, { value: "2017-2018" }, { value: "2016-2017" }, { value: "2015-2016" }, { value: "2014-2015" }
      ],
      semesterOptions: [
        { value: 1 }, { value: 2 }
      ],
      subjectOptions: [
        { value: "算法", id: 1 }, { value: "编程语言", id: 2 }, { value: "数据结构", id: 3 }, { value: "计算机基础", id: 4 }, { value: "数学和逻辑", id: 5 }, { value: "软件开发", id: 6 }
      ],
      rules: {
        title: [
          { type: 'string', required: true, message: '请输入试卷名', trigger: 'blur' },
        ],
        school_year: [
          { required: true, message: '请选择学年', trigger: 'change' }
        ],
        semester: [
          { required: true, message: '请选择学期', trigger: 'change' }
        ],
        subject: [
          { required: true, message: '请选择科目', trigger: 'change' }
        ],
      }
    };
  },

  components: {
    draggable
  },

  mounted() {
    this.initData();
  },

  methods: {
    initData() {
      this.modifyTestPaper = TestPaperService.getTestPaper();
      if(this.modifyTestPaper && this.modifyTestPaper.test_paper_id) {
        this.isModifyTestPaper = true;
        this.form.subject = this.modifyTestPaper.subject_id;
        this.form.title = this.modifyTestPaper.title;
        this.form.school_year = this.modifyTestPaper.school_year;
        this.form.semester = this.modifyTestPaper.semester;
      }
      this.allQuestions = QuestionService.getAllPaperQuestions();
      this.paperQuestions = QuestionService.groupQuestionByQuestionType(
        this.allQuestions
      );
      for (let i = 0; i < this.paperQuestions.length; i++) {
        if (this.paperQuestions[i].total == 0) {
          this.paperQuestions.splice(i--, 1);
        }
      }
      this.computeTotalScore();
      this.computeDifficultyDegree();
    },

    gotoQuestionBank() {
      this.$router.push("/page/questionBank");
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
    },

    getBigQuestionNo(index) {
      switch (index) {
        case 0:
          return "一、";
        case 1:
          return "二、";
        case 2:
          return "三、";
        case 3:
          return "四、";
        default:
          return "";
      }
    },

    getMin(type) {
      switch (type) {
        case 1:
          return 1;
        case 2:
          return 1;
        case 3:
          return 1;
        case 4:
          return 5;
        default:
          return 0;
      }
    },

    getMax(type) {
      switch (type) {
        case 1:
          return 5;
        case 2:
          return 5;
        case 3:
          return 5;
        case 4:
          return 15;
        default:
          return 0;
      }
    },

    handleChange(item) {
      QuestionService.updatePaperQuestion(item);
      this.initData();
    },

    deletePaperQuestion(item) {
      let result = QuestionService.deletePaperQuestionById(item.question_id);
      if (result) {
        this.$toast.text("已从试题篮删除");
        globalBus.$emit("paperQuestionChange");
      } else {
        this.$toast.text("删除失败，请重试");
      }
      this.initData();
    },

    computeTotalScore() {
      this.total_score = 0;
      this.paperQuestions.forEach(paperQuestion => {
        paperQuestion.items.forEach(question => {
          this.total_score += question.score;
        });
      });
    },

    computeDifficultyDegree() {
      this.difficulty_degree = 0;
      let difficulty_degree_array = [];
      for(let i = 0; i <= 5; i++) {
        difficulty_degree_array[i] = 0;
      }
      this.paperQuestions.forEach(paperQuestion => {
        paperQuestion.items.forEach(question => {
          difficulty_degree_array[question.difficulty_degree]++;
        });
      });
      this.difficulty_degree = difficulty_degree_array.indexOf(Math.max.apply(null,difficulty_degree_array));
    },

    async generateTestPaper(form) {
      if (this.total_score == 100) {
        this.$refs[form].validate(async (valid) => {
          if (valid) {
            let userInfo = await AccountService.getUserInfo();
            let testPaper = {};
            if (this.isModifyTestPaper) {
              testPaper.test_paper_id = this.modifyTestPaper.test_paper_id;
            }
            testPaper.creator_id = userInfo.account_id;
            testPaper.subject_id = this.form.subject;
            testPaper.title = this.form.title;
            testPaper.total_score = this.total_score;
            testPaper.difficulty_degree = this.difficulty_degree.toString();
            testPaper.school_year = this.form.school_year;
            testPaper.semester = this.form.semester;
            let questions = [];
            this.paperQuestions.forEach((bigQuestion, i) => {
              bigQuestion.items.forEach((smallQuestion, j) => {
                let question = {};
                if (this.isModifyTestPaper) {
                  question.test_paper_id = this.modifyTestPaper.test_paper_id;
                }
                question.question_id = smallQuestion.question_id;
                question.set_score = smallQuestion.score;
                question.question_number = i + 1;
                question.question_number_2 = j + 1;
                questions.push(question);
              });
            });
            testPaper.questions = questions;
            console.log(testPaper)
            let response;
            if (this.isModifyTestPaper) {
              response = await TestPaperService.modifyUserTestPaper(testPaper);
            } else {
              response = await TestPaperService.manualGenerateUserTestPaper(testPaper);
            }
            if(response && response.isSuccess) {
              store.dispatch('testPaper/clearAllTestPaperState');
              store.dispatch('paperQuestion/clearAllPaperQuestions');
              globalBus.$emit("paperQuestionChange");
              let that = this;
              var time = 3;
              var interval = setInterval(function() {
                if(that.isModifyTestPaper) {
                  that.$toast.text("试卷修改成功，" + time + "秒后将跳转到“我的试卷”页面");
                } else {
                  that.$toast.text("生成试卷成功，" + time + "秒后将跳转到“我的试卷”页面");
                }
                time -= 1;
                if(time === 0){
                  clearInterval(interval);
                  setTimeout(() => {
                    that.$router.push("/page/userCenter/myTestPaper");
                  }, 1000);
                }
              }, 1010);
            } else {
              this.$toast.text(response.message);
            }
          } else {
            return false;
          }
        });
      } else if (this.total_score < 100) {
        this.$toast.text("总分低于100，请添加题目或修改分值后重试");
      } else {
        this.$toast.text("总分高于100，请删减题目或修改分值后重试");
      }
    },

    clearPaperQuestions() {
      if(this.isModifyTestPaper) {
        this.$confirm('确定取消试卷修改？').then(() => {
          store.dispatch('testPaper/clearAllTestPaperState');
          store.dispatch('paperQuestion/clearAllPaperQuestions');
          globalBus.$emit("paperQuestionChange");
          this.$router.push("/page/userCenter/myTestPaper");
        }).catch(() => {
          return;
        });
      } else {
        this.$confirm('确定清空试题篮？').then(() => {
          store.dispatch('paperQuestion/clearAllPaperQuestions');
          globalBus.$emit("paperQuestionChange");
          this.initData();
        }).catch(() => {
          return;
        });
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.manual_generation {
  padding: 0.2rem 2.5rem;
  .breadcrumb {
    padding: 0.2rem;
    border-bottom: 1px solid #dddddd;
  }
  .content {
    margin-top: 0.3rem;

    .question_list_container {
      font-size: 0.35rem;
      margin-bottom: 0.2rem;
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
            margin: 0.4rem 0.2rem;
            font-size: 0.2rem;
            line-height: 0.25rem;
            border-bottom: 1px solid #dddddd;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: flex-start;
            cursor: pointer;

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
              width: 100%;
              background: #eeeeee;
              margin: 0.2rem 0;
              display: flex;
              justify-content: space-between;

              .question_detail {
                display: flex;
                align-items: flex-start;
                .no {
                  flex: 0 0 auto;
                }
                .question {
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

            .foot {
              width: 100%;
              margin-bottom: 0.3rem;
              display: flex;
              justify-content: space-between;
              align-items: center;
              .change_score {
                display: flex;
                align-items: center;
                .counter {
                  margin: 0.1rem;
                }
              }
              .delete_question {
                margin: 0 0.1rem;
                width: 0.8rem;
                height: 0.4rem;
                border-radius: 0.04rem;
                font-size: 0.2rem;
                cursor: pointer;
                display: flex;
                justify-content: center;
                align-items: center;
                background: #0493d3;
                color: #ffffff;
              }
            }
          }
        }
      }

      .test_paper_info {
        width: 95%;
        margin: 0 0.2rem 0.2rem 0.2rem;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        .form {
          width: 100%;
        }
        .difficulty_degree {
          margin-left: 0.2rem;
        }
      }

      .bottom {
        width: 100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .total_score {
          margin: 0 0.2rem;
          font-size: 0.3rem;
        }
        .button {
          margin: 0 0.2rem;
          display: flex;
          align-items: center;
          .generate_test_paper {
            margin-right: 0.2rem;
            width: 1.5rem;
            height: 0.5rem;
            border-radius: 0.04rem;
            font-size: 0.26rem;
            background: #0493d3;
            color: #ffffff;
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
          }
          .clear_paper_questions {
            width: 1rem;
            height: 0.5rem;
            border-radius: 0.04rem;
            font-size: 0.26rem;
            background: #0493d3;
            color: #ffffff;
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
          }
        }
      }
    }

    .no_data {
      margin-top: 1rem;
      width: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 0.3rem;
      color: #999;
      .goto_question_bank {
        margin-left: 0.2rem;
        color: #51c457;
        cursor: pointer;
      }
      .goto_question_bank:hover {
        color: #c4515b;
      }
    }
  }
}
</style>
