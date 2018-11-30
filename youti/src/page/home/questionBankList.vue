<template>
	<div class="question_bank_list">
    <div class="question_list_container">
      <div v-for="(item, index) in currentQuestionList" :key="index" class="question">
        <div class="head">
          <div class="subject">科目：{{ getSubject(item.subject_id) }}</div> | 
          <div class="knowledge_point">知识点：{{ getKnowledgePoint(item.knowledge_point_id) }}</div> | 
          <div class="question_type">题型：{{ getQuestionType(item.type_id) }}</div> | 
          <div class="difficulty_degree">难度：{{ getDifficultyDegree(item.difficulty_degree) }}</div>
        </div>
        <div class="body">
          <div class="question_content" v-html="item.content" @click="gotoQuestionDetail(index)"></div>
          <div class="score">({{ item.score }}分)</div>
        </div>
        <div class="foot">
          <div v-if="!addQuestion[(currentPage-1) * pageSize + index]" class="addQuestion" @click="addPaperQuestion(index)">选题</div>
          <div v-else class="deleteQuestion" @click="deletePaperQuestion(index)">取消</div>
        </div>
      </div>
    </div>
    
    <el-pagination
      @current-change="handleCurrentChange"
      :current-page.sync="currentPage"
      :page-size="pageSize"
      layout="total, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
	</div>
</template>

<script type="text/javascript">
import domUtil from "src/assets/js/domUtils.js";
import common from "src/assets/js/common.js";
import { QuestionService } from "src/service/question.js";
import { globalBus } from "src/service/globalBus";

export default {
  data() {
    return {
      pageSize: 10,
      total: 0,
      currentPage: 1,
      currentQuestionList: [],
      addQuestion: [],
      paperQuestions: [],
    };
  },
  
  props: {
    questionList: {
      type: Array,
      default: null
    }
  },

  watch: {
    questionList() {
      if(this.questionList) {
        this.total = this.questionList.length;
        this.currentPage = 1;
        this.currentQuestionList = this.questionList.slice(0, this.pageSize);
        this.initData();
      }
    }
  },

  mounted() {
  },

  methods: {
    async initData() {
      this.paperQuestions = await QuestionService.getAllPaperQuestions();
      if(this.paperQuestions.length) {
        for(let i = 0; i < this.questionList.length; i++) {
          this.addQuestion[i] = false;
          for(let j = 0; j < this.paperQuestions.length; j++) {
            if(this.questionList[i].question_id == this.paperQuestions[j].question_id) {
              this.addQuestion[i] = true;
              break;
            }
          }
        }
      }
      this.addQuestion = JSON.parse(JSON.stringify(this.addQuestion));
    },

    handleCurrentChange(val) {
      this.currentQuestionList = this.questionList.slice((val-1)*this.pageSize, val*this.pageSize);
      domUtil.setScrollTop(0);
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

    gotoQuestionDetail(index) {
      let item = this.questionList[(this.currentPage-1) * this.pageSize + index];
      QuestionService.saveQuestion(item);
      this.$router.push({
        name: "questionDetail",
        params: {
          question_id: item.question_id
        }
      });
    },

    addPaperQuestion(index) {
      let item = this.questionList[(this.currentPage-1) * this.pageSize + index];
      let result = QuestionService.savePaperQuestion(item);
      if(result) {
        this.$toast.text("已添加入试题篮，可前往“手动组卷”页面查看");
        this.addQuestion[(this.currentPage-1) * this.pageSize + index] = true;
        globalBus.$emit('paperQuestionChange');
      } else {
        this.$toast.text("添加失败，请重试");
      }
      this.initData();
    },

    deletePaperQuestion(index) {
      let item = this.questionList[(this.currentPage-1) * this.pageSize + index];
      let result = QuestionService.deletePaperQuestionById(item.question_id);
      if(result) {
        this.$toast.text("已从试题篮删除");
        this.addQuestion[(this.currentPage-1) * this.pageSize + index] = false;
        globalBus.$emit('paperQuestionChange');
      } else {
        this.$toast.text("删除失败，请重试");
      }
      this.initData();
    }
  }
};
</script>

<style lang="scss" scoped>
.question_bank_list {
  margin-top: 0.2rem;
  border-top: 1px solid #dddddd;
  display: flex;
  flex-direction: column;
  align-items: center;

  .question_list_container {
    margin-bottom: 0.2rem;
    display: flex;
    flex-direction: column;

    .question {
      width: 10rem;
      padding: 0.3rem 0.2rem;
      font-size: 0.2rem;
      display: flex;
      flex-direction: column;
      border-bottom: 1px solid #dddddd;

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

        .question_content {
          cursor: pointer;
          /deep/ .subject-des li {
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
        align-self: flex-end;
        margin-top: 0.2rem;
        div {
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
</style>