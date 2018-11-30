<template>
  <div class="auto_generation">
    <div class="breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>智能组卷</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content">
      <div class="form_container">
        <div class="head">智能组卷</div>
        <div class="body">
          <div class="question_info">
            <div class="question_info_head">一、题型</div>
            <el-checkbox class="check_all" :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
            <el-checkbox-group v-model="checkedType" @change="handleCheckedTypeChange">
              <div class="question_box">
                <el-checkbox class="text" :label="1">单选题</el-checkbox>
                <div class="component">
                  <div class="count">数量：
                    <el-input-number v-model="questionCount[0]" size="mini" label="数量" :min="5" :max="10" @change="handleChange()"></el-input-number>
                  </div>
                  <div class="score">分值：
                    <el-input-number v-model="questionScore[0]" size="mini" label="分值" :min="1" :max="5" @change="handleChange()"></el-input-number>
                  </div>
                </div>
              </div>
              <div class="question_box">
                <el-checkbox class="text" :label="2">不定项选择题</el-checkbox>
                <div class="component">
                  <div class="count">数量：
                    <el-input-number v-model="questionCount[1]" size="mini" label="数量" :min="5" :max="10" @change="handleChange()"></el-input-number>
                  </div>
                  <div class="score">分值：
                    <el-input-number v-model="questionScore[1]" size="mini" label="分值" :min="1" :max="5" @change="handleChange()"></el-input-number>
                  </div>
                </div>
              </div>
              <div class="question_box">
                <el-checkbox class="text" :label="3">填空题</el-checkbox>
                <div class="component">
                  <div class="count">数量：
                    <el-input-number v-model="questionCount[2]" size="mini" label="数量" :min="5" :max="10" @change="handleChange()"></el-input-number>
                  </div>
                  <div class="score">分值：
                    <el-input-number v-model="questionScore[2]" size="mini" label="分值" :min="1" :max="5" @change="handleChange()"></el-input-number>
                  </div>
                </div>
              </div>
              <div class="question_box">
                <el-checkbox class="text" :label="4">问答题</el-checkbox>
                <div class="component">
                  <div class="count">数量：
                    <el-input-number v-model="questionCount[3]" size="mini" label="数量" :min="3" :max="10" @change="handleChange()"></el-input-number>
                  </div>
                  <div class="score">分值：
                    <el-input-number v-model="questionScore[3]" size="mini" label="分值" :min="5" :max="15" @change="handleChange()"></el-input-number>
                  </div>
                </div>
              </div>
            </el-checkbox-group>
          </div>
          <div class="test_paper_info">
            <div class="test_paper_info_head">二、试卷信息</div>
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
                <el-select v-model="form.difficulty_degree" placeholder="难度">
                  <el-option
                    v-for="difficulty_degree in difficultyDegreeOptions"
                    :key="difficulty_degree.id"
                    :label="difficulty_degree.value"
                    :value="difficulty_degree.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-form>
          </div>
        </div>
        <div class="bottom">
          <div class="total_score">总分：{{ total_score }}</div>
          <div class="generate_test_paper" @click="generateTestPaper('form')">生成试卷</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { AccountService } from "src/service/account.js";
import { TestPaperService } from "src/service/testPaper.js";

export default {
  data() {
    return {
      questionCount: [5, 5, 5, 5],
      questionScore: [2, 4, 4, 10],
      checkAll: false,
      checkedType: [],
      allTypes: [1, 2, 3, 4],
      isIndeterminate: false,
      total_score: 0,
      form: {},
      schoolYearOptions: [
        { value: "2018-2019" }, { value: "2017-2018" }, { value: "2016-2017" }, { value: "2015-2016" }, { value: "2014-2015" }
      ],
      semesterOptions: [
        { value: 1 }, { value: 2 }
      ],
      subjectOptions: [
        { value: "算法", id: 1 }, { value: "编程语言", id: 2 }, { value: "数据结构", id: 3 }, { value: "计算机基础", id: 4 }, { value: "数学和逻辑", id: 5 }, { value: "软件开发", id: 6 }
      ],
      difficultyDegreeOptions: [
        { value: "一星", id: "1" }, { value: "二星", id: "2" }, { value: "三星", id: "3" }, { value: "四星", id: "4" }, { value: "五星", id: "5" }
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
        difficulty_degree: [
          { required: true, message: '请选择难度', trigger: 'change' }
        ],
      }
    };
  },

  components: {},

  mounted() {
    this.initData();
  },

  methods: {
    initData() {
      this.computeTotalScore();
    },

    handleChange() {
      this.initData();
    },

    handleCheckAllChange(val) {
      this.checkedType = val ? this.allTypes : [];
      this.isIndeterminate = false;
      this.initData();
    },

    handleCheckedTypeChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.allTypes.length;
      this.isIndeterminate =
        checkedCount > 0 && checkedCount < this.allTypes.length;
      this.initData();
    },

    computeTotalScore() {
      this.total_score = 0;
      this.checkedType.forEach(type => {
        this.total_score += this.questionCount[type-1] * this.questionScore[type-1]
      });
    },

    async generateTestPaper(form) {
      if (this.total_score == 100) {
        this.$refs[form].validate(async (valid) => {
          if (valid) {
            let userInfo = await AccountService.getUserInfo();
            let testPaper = {};
            testPaper.creator_id = userInfo.account_id;
            testPaper.subject_id = this.form.subject;
            testPaper.title = this.form.title;
            testPaper.total_score = this.total_score;
            testPaper.difficulty_degree = this.form.difficulty_degree;
            testPaper.school_year = this.form.school_year;
            testPaper.semester = this.form.semester;
            let questionsInfo = [];
            this.checkedType.sort().forEach(type => {
              let question = {};
              question.type = type;
              question.count = this.questionCount[type-1];
              question.score = this.questionScore[type-1];
              questionsInfo.push(question);
            });
            testPaper.questionsInfo = questionsInfo;
            console.log(testPaper)
            let response = await TestPaperService.autoGenerateUserTestPaper(testPaper);
            if(response && response.isSuccess) {
              let that = this;
              var time = 3;
              var interval = setInterval(function() {
                that.$toast.text("生成试卷成功，" + time + "秒后将跳转到“我的试卷”页面");
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
    }
  }
};
</script>

<style lang="scss" scoped>
.auto_generation {
  padding: 0.2rem 2.5rem;
  .breadcrumb {
    padding: 0.2rem;
    border-bottom: 1px solid #dddddd;
  }
  .content {
    margin-top: 0.3rem;

    .form_container {
      margin-bottom: 0.2rem;
      display: flex;
      flex-direction: column;
      align-items: center;
      .head {
        font-size: 0.35rem;
        align-self: center;
      }
      .body {
        width: 100%;
        margin: 0.2rem;
        font-size: 0.2rem;
        display: flex;
        flex-direction: column;
        .question_info {
          display: flex;
          flex-direction: column;
          .question_info_head {
            margin: 0.2rem;
            font-size: 0.3rem;
          }
          .check_all {
            width: 0.5rem;
            margin: 0 0.3rem;
            color: #2185d6;
          }
          .question_box {
            font-size: 0.2rem;
            border: 1px solid #dddddd;
            border-radius: 0.1rem;
            margin: 0.2rem;
            padding: 0.2rem;
            display: flex;
            flex-direction: column;
            .text {
              color: #2185d6;
              width: 1rem;
              margin-bottom: 0.2rem;
              font-weight: bold;
            }
            .component {
              display: flex;
              .count {
                display: flex;
                margin-right: 0.5rem;
              }
              .score {
                display: flex;
              }
            }
          }
        }
        .test_paper_info {
          margin-top: 0.2rem;
          .test_paper_info_head {
            margin: 0.2rem;
            font-size: 0.3rem;
          }
          .form {
            font-size: 0.2rem;
            border: 1px solid #dddddd;
            border-radius: 0.1rem;
            margin: 0.2rem;
            padding: 0.2rem;
            display: flex;
            flex-direction: column;
          }
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
        .generate_test_paper {
          margin: 0 0.2rem;
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
      }
    }
  }
}
</style>
