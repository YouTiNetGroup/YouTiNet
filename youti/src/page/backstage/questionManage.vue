<template>
	<div class="question_manage">
    <div class="search_amount">共 {{ filterQuestionList.length }} 条结果</div>
    <div class="question_manage_container">
      <div class="filter_container">
        <div class="filter_item">
          <div class="text">科目</div>
          <el-select class="select" v-model="subject_id" placeholder="科目" size="mini"  @change="subjectChange">
            <el-option
              v-for="subject_id in subjectIdOptions"
              :key="subject_id.value"
              :label="subject_id.value"
              :value="subject_id.index">
            </el-option>
          </el-select>
        </div>
        <div class="filter_item">
          <div class="text">知识点</div>
          <el-select class="select" v-model="knowledge_point_id" placeholder="知识点" size="mini">
            <el-option
              v-for="knowledge_point_id in knowledgePointIdOptions"
              :key="knowledge_point_id.value"
              :label="knowledge_point_id.value"
              :value="knowledge_point_id.index">
            </el-option>
          </el-select>
        </div>
        <div class="filter_item">
          <div class="text">类型</div>
          <el-select class="select" v-model="type_id" placeholder="类型" size="mini">
            <el-option
              v-for="type_id in typeIdOptions"
              :key="type_id.value"
              :label="type_id.value"
              :value="type_id.index">
            </el-option>
          </el-select>
        </div>
        <div class="filter_item">
          <div class="text">难度</div>
          <el-select class="select" v-model="difficulty_degree" placeholder="难度" size="mini">
            <el-option
              v-for="difficulty_degree in difficultyDegreeOptions"
              :key="difficulty_degree.value"
              :label="difficulty_degree.value"
              :value="difficulty_degree.index">
            </el-option>
          </el-select>
        </div>
        <div class="filter_item">
          <div class="text">分值</div>
          <el-select class="select" v-model="score" placeholder="分值" size="mini">
            <el-option
              v-for="score in scoreOptions"
              :key="score.value"
              :label="score.value"
              :value="score.value">
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
    </div>
    <div class="head">
      <div class="question_id">ID</div>
      <div class="subject_id">科目</div>
      <div class="knowledge_point_id">知识点</div>
      <div class="type_id">类型</div>
      <div class="difficulty_degree">难度</div>
      <div class="score">分值</div>
      <div class="operation">操作</div>
    </div>
    <div class="body">
      <div class="question_container" :class="index%2 == 0 ? 'deep_shadow' : 'shallow_shadow'" v-for="(item, index) in currentQuestionList" :key="index">
        <div class="question_info">
          <div :title="item.question_id">{{ item.question_id }}</div>
        </div>
        <div class="question_info">
          <div :title="getSubject(item.subject_id)">{{ getSubject(item.subject_id) }}</div>
        </div>
        <div class="question_info">
          <div :title="getKnowledgePoint(item.knowledge_point_id)">{{ getKnowledgePoint(item.knowledge_point_id) }}</div>
        </div>
        <div class="question_info">
          <div :title="getQuestionType(item.type_id)">{{ getQuestionType(item.type_id) }}</div>
        </div>
        <div class="question_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="getDifficultyDegree(item.difficulty_degree)">{{ getDifficultyDegree(item.difficulty_degree) }}</div>
          <el-select v-else class="select" v-model="modify_difficulty_degree" placeholder="难度" size="small">
            <el-option
              v-for="difficulty_degree in difficultyDegreeOptions"
              :key="difficulty_degree.value"
              :label="difficulty_degree.value"
              :value="difficulty_degree.index">
            </el-option>
          </el-select>
        </div>
        <div class="question_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.score">{{ item.score }}</div>
          <el-select v-else class="select" v-model="modify_score" placeholder="难度" size="small">
            <el-option
              v-for="score in scoreOptions"
              :key="score.value"
              :label="score.value"
              :value="score.value">
            </el-option>
          </el-select>
        </div>
        <div class="question_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" class="operation">
            <div class="detail" @click="gotoQuestionDetail(index)">查看</div>
            <div class="modify" @click="modifyQuestion(index)">修改</div>
            <div class="delete" @click="deleteQuestion(index)">删除</div>
          </div>
          <div v-else class="operation">
            <div class="save" @click="save(index)">保存</div>
            <div class="cancle" @click="cancle(index)">取消</div>
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
	</div>
</template>

<script type="text/javascript">
import domUtil from "src/assets/js/domUtils.js";
import common from "src/assets/js/common.js";
import { QuestionService } from "src/service/question.js";

export default {
  data() {
    return {
      type_id: null,
      subject_id: null,
      knowledge_point_id: null,
      difficulty_degree: null,
      score: null,
      modify_difficulty_degree: null,
      modify_score: null,
      modify: [],
      questionList: [],
      filterQuestionList: [],
      pageSize: 10,
      total: 0,
      currentPage: 1,
      currentQuestionList: [],
      subjectIdOptions: [
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
      knowledgePointIdOptions: [],
      typeIdOptions: [
        { value: "单选题", index: 1 }, { value: "不定项选择题", index: 2 }, { value: "填空题", index: 3 }, { value: "问答题", index: 4 }
      ],
      difficultyDegreeOptions: [
        { value: "一星", index: "1" }, { value: "二星", index: "2" }, { value: "三星", index: "3" }, { value: "四星", index: "4" }, { value: "五星", index: "5" }
      ],
      scoreOptions: [
        { value: 1 }, { value: 2 }, { value: 3 }, { value: 4 }, { value: 5 }, { value: 6 }, { value: 7 }, { value: 8 }, { value: 9 }, { value: 10 }, { value: 11 }, { value: 12 }, { value: 13 }, { value: 14 }, { value: 15 },
      ],
    };
  },

  watch: {
    filterQuestionList() {
      this.total = this.filterQuestionList.length;
      this.currentPage = 1;
      this.currentQuestionList = this.filterQuestionList.slice(0, this.pageSize);
      this.currentQuestionList = JSON.parse(JSON.stringify(this.currentQuestionList));
      this.modify = [];
      for(let i = 0; i < this.filterQuestionList.length; i++) {
        this.modify[i] = false;
      }
    }
  },

  mounted() {
    this.initData();
  },

  methods: {
    async initData() {
      this.questionList = await QuestionService.getAllOfQuestions();
      if(this.questionList && this.questionList.length) {
        this.filterQuestionList = JSON.parse(JSON.stringify(this.questionList));
      }
    },

    subjectChange(value) {
      this.knowledge_point_id = null;
      this.subjectIdOptions.forEach(subject => {
        if(subject.index === value) {
          this.knowledgePointIdOptions = subject.item;
        }
      });
    },

    handleCurrentChange(val) {
      this.currentQuestionList = this.filterQuestionList.slice((val-1)*this.pageSize, val*this.pageSize);
      domUtil.setScrollTop(0);
    },

    clickFilter() {
      let tempQuestionList = [];
      this.filterQuestionList = JSON.parse(JSON.stringify(this.questionList));
      if(this.type_id && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.type_id == this.type_id) {
            this.filterQuestionList.push(question);
          }
        });
      }
      if(this.subject_id && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.subject_id == this.subject_id) {
            this.filterQuestionList.push(question);
          }
        });
      }
      if(this.knowledge_point_id && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.knowledge_point_id == this.knowledge_point_id) {
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
      if(this.score && this.filterQuestionList.length) {
        tempQuestionList = this.filterQuestionList;
        this.filterQuestionList = [];
        tempQuestionList.forEach(question => {
          if(question.score == this.score) {
            this.filterQuestionList.push(question);
          }
        });
      }
      this.filterQuestionList = JSON.parse(JSON.stringify(this.filterQuestionList));
    },

    reset() {
      this.type_id = null;
      this.subject_id = null;
      this.knowledge_point_id = null;
      this.difficulty_degree = null;
      this.score = null;
      this.knowledgePointIdOptions = null;
      this.clickFilter();
    },

    gotoQuestionDetail(index) {
      let item = this.filterQuestionList[(this.currentPage-1) * this.pageSize + index];
      QuestionService.saveQuestion(item);
      this.$router.push({
        name: "backQuestionDetail",
        params: {
          question_id: item.question_id
        }
      });
    },

    modifyQuestion(index) {
      this.modify[(this.currentPage-1) * this.pageSize + index] = true;
      this.modify = JSON.parse(JSON.stringify(this.modify));
      let item = this.questionList[(this.currentPage-1) * this.pageSize + index];
      this.modify_difficulty_degree = item.difficulty_degree;
      this.modify_score = item.score;
    },

    async deleteQuestion(index) {
      this.$confirm('确定删除该题目？').then(async () => {
        let item = this.questionList[(this.currentPage-1) * this.pageSize + index];
        let response = await QuestionService.deleteQuestion(item.question_id);
        if (response && response.isSuccess) {
          this.$toast.text("删除成功");
        } else {
          this.$toast.text("删除失败");
        }
        this.initData();
      }).catch(() => {
        return;
      });
    },

    async save(index) {
      let item = this.questionList[(this.currentPage-1) * this.pageSize + index];
      item.difficulty_degree = this.modify_difficulty_degree;
      item.score = this.modify_score;
      let response = await QuestionService.modifyQuestion(item);
      if (response && response.isSuccess) {
        this.$toast.text("修改成功");
      } else {
        this.$toast.text("修改失败");
      }
      this.initData();
      this.modify[(this.currentPage-1) * this.pageSize + index] = false;
      this.modify = JSON.parse(JSON.stringify(this.modify));
    },

    cancle(index) {
      this.modify[(this.currentPage-1) * this.pageSize + index] = false;
      this.modify = JSON.parse(JSON.stringify(this.modify));
    },

    getQuestionType(type_id) {
      return common.getQuestionType(type_id);
    },

    getSubject(subject_id) {
      return common.getSubject(subject_id);
    },

    getKnowledgePoint(knowledge_point_id) {
      return common.getKnowledgePoint(knowledge_point_id);
    },

    getDifficultyDegree(difficulty_degree) {
      return common.getDifficultyDegree(difficulty_degree);
    }
  }
};
</script>

<style lang="scss" scoped>
.question_manage {
  margin: 0.5rem;
  font-size: 0.2rem;
  display: flex;
  flex-direction: column;

  .search_amount {
    margin: 0 0.3rem;
    font-size: 0.2rem;
  }

  .question_manage_container {
    margin: 0.2rem;

    .filter_container {
      display: flex;
      justify-content: space-between;
      align-items: center;
      .filter_item {
        margin: 0 0.05rem;
        font-size: 0.2rem;
        width: 2.2rem;
        display: flex;
        align-items: center;
        .text {
          flex: 0 0 auto;
          margin-right: 0.05rem;
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
      .input_box {
        width: 1.5rem;
        height: 0.3rem;
        padding: 0 0.05rem;
        border: 1px solid #bbbbbb;
        outline: none;
        -webkit-appearance: none;
      }
    }
  }
  
  .head {
    width: 100%;
    display: flex;
    align-items: center;
    div {
      width: 14%;
      text-align: center;
    }
    .title {
      width: 30% !important;
    }
  }
  
  .body {
    margin: 0.2rem 0;
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    .question_container {
      padding: 0.1rem 0;
      width: 100%;
      display: flex;
      align-items: center;
      .question_info {
        width: 14%;
        display: flex;
        justify-content: center;
        align-items: center;
        div {
          text-align: center;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;
        }
      }
      .operation {
        font-size: 0.15rem;
        display: flex;
        justify-content: center;
        align-items: center;
        div {
          letter-spacing: 0.01rem;
          width: 0.45rem;
          height: 0.25rem;
          border-radius: 0.03rem;
          background: #7089ce;
          color: #fff;
          display: flex;
          justify-content: center;
          align-items: center;
          cursor: pointer;
        }
        .modify {
          margin-left: 0.05rem;
        }
        .delete {
          margin-left: 0.05rem;
        }
        .cancle {
          margin-left: 0.05rem;
        }
      }
    }
    .deep_shadow {
      background: #cccccc;
    }
    .shallow_shadow {
      background: #dddddd;
    }
  }
}
</style>
