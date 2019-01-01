<template>
  <div class="my_test_paper">
    <div class="test_paper_list_container">
      <div v-for="(item, index) in currentTestPaperList" :key="index" class="test_paper_container">
        <img src="../../assets/images/test_paper.png" @click="gotoTestPaperDetail(index)" />
        <div class="test_paper_info">
          <div class="head">
            <div class="title" @click="gotoTestPaperDetail(index)" :title="item.title">{{ item.title }}</div>
            <div class="total_score">满分：{{ item.total_score }} 分</div>
          </div>
          <div class="body">
            <div class="subject_name">科目：{{ getSubject(item.subject_id) }}</div>
            <div class="difficulty_degree">难度：{{ item.difficulty_degree }}</div>
            <div class="school_year">学年：{{ item.school_year }}</div>
            <div class="semester">学期：第{{ item.semester }}学期</div>
          </div>
          <div class="foot">
            <div class="detail" @click="gotoTestPaperDetail(index)">
              <div>查看</div>
            </div>
            <div class="modify" @click="modifyTestPaper(index)">
              <div>修改</div>
            </div>
            <div class="export" @click="exportTestPaper(index)">
              <div>导出</div>
            </div>
            <div class="delete" @click="deleteTestPaper(index)">
              <div>删除</div>
            </div>
          </div>
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

<script>
import store from "src/store";
import domUtil from "src/assets/js/domUtils.js";
import common from "src/assets/js/common.js";
import { globalBus } from "src/service/globalBus";
import { AccountService } from "src/service/account.js";
import { TestPaperService } from "src/service/testPaper.js";
import { QuestionService } from "src/service/question.js";

export default {
  data() {
    return {
      pageSize: 5,
      total: 0,
      currentPage: 0,
      userInfo: null,
      testPaperList: [],
      currentTestPaperList: []
    };
  },
  mounted() {
    this.initData();
  },
  methods: {
    async initData() {
      this.currentTestPaperList = [];
      this.currentPage = 0;
      this.total = 0;
      this.userInfo = await AccountService.getUserInfo();
      this.testPaperList = await TestPaperService.getUserTestPapers(this.userInfo.account_id);
      if(this.testPaperList && this.testPaperList.length != 0) {
        this.total = this.testPaperList.length;
        this.currentPage = 1;
        this.currentTestPaperList = this.testPaperList.slice(0, this.pageSize);
      }
    },

    handleCurrentChange(val) {
      this.currentTestPaperList = this.testPaperList.slice((val-1)*this.pageSize, val*this.pageSize);
      domUtil.setScrollTop(0);
    },

    gotoTestPaperDetail(index) {
      let item = this.testPaperList[(this.currentPage-1) * this.pageSize + index];
      TestPaperService.saveTestPaper(item);
      this.$router.push({
        name: "testPaperDetail",
        params: {
          test_paper_id: item.test_paper_id
        }
      });
    },

    async modifyTestPaper(index) {
      let item = this.testPaperList[(this.currentPage-1) * this.pageSize + index];
      TestPaperService.saveTestPaper(item);
      let questions = await QuestionService.getTestPaperQuestions(item.test_paper_id);
      questions.forEach(question => {
        QuestionService.savePaperQuestion(question);
      });
      globalBus.$emit("paperQuestionChange");
      this.$router.push("/page/manualGeneration");
    },

    async exportTestPaper(index) {
      let item = this.testPaperList[(this.currentPage-1) * this.pageSize + index];
      let response = await TestPaperService.exportTestPaper(item.test_paper_id);
      if(response && response.isSuccess) {
        this.$toast.text("导出成功，可在本地F盘查看");
      } else {
        this.$toast.text(response.message);
      }
    },

    async deleteTestPaper(index) {
      this.$confirm('确定删除该试卷？').then(async () => {
        let item = this.testPaperList[(this.currentPage-1) * this.pageSize + index];
        let response = await TestPaperService.deleteTestPaper(item.test_paper_id);
        if(response && response.isSuccess) {
          this.$toast.text("删除成功")
        } else {
          this.$toast.text(response.message);
        }
        this.initData();
      }).catch(() => {
        return;
      });
    },

    getSubject(subject_id) {
      return common.getSubject(subject_id);
    },
  }
};
</script>

<style lang="scss" scoped>
.my_test_paper {
  display: flex;
  flex-direction: column;
  align-items: center;

  .test_paper_list_container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 0.3rem;

    .test_paper_container {
      width: 9rem;
      padding: 0.3rem 0;
      display: flex;
      align-items: center;
      border-bottom: 1px solid #dddddd;

      img {
        width: 1.2rem;
        cursor: pointer;
      }

      .test_paper_info {
        margin-left: 0.5rem;
        width: 7.5rem;
        font-size: 0.2rem;
        display: flex;
        flex-direction: column;
        justify-content: center;
        .head {
          display: flex;
          justify-content: space-between;
          align-items: center;
          .title {
            max-width: 6rem;
            font-weight: bold;
            letter-spacing: 0.02rem;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            cursor: pointer;
          }
          .total_score {
            flex: 0 0 auto;
            font-size: 0.15rem;
          }
        }
        .body {
          margin: 0.1rem 0;
          width: 100%;
          font-size: 0.15rem;
          display: flex;
          flex-wrap: wrap;
          justify-content: space-between;
          align-items: center;
          div {
            width: 50%;
            margin: 0.05rem 0;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
          }
        }
        .foot {
          width: 100%;
          display: flex;
          justify-content: flex-end;
          align-items: center;
          div {
            margin: 0.05rem;
            width: 0.6rem;
            height: 0.3rem;
            border-radius: 0.04rem;
            font-size: 0.15rem;
            cursor: pointer;
            display: flex;
            justify-content: center;
            align-items: center;
          }
          .detail {
            border: 1px solid #84bb5f;
            background-color: #f8f7f3;
            color: #54b148;
          }
          .modify {
            border: 1px solid #d4b269;
            background-color: #f8f7f3;
            color: #b89b5d;
          }
          .export {
            border: 1px solid #6c7ac7;
            background-color: #f8f7f3;
            color: #4244a3;
          }
          .delete {
            border: 1px solid #e4a581;
            background-color: #f8f7f3;
            color: #e46c3d;
          }
        }
      }
    }
  }
}
</style>
