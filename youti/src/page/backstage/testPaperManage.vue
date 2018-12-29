<template>
	<div class="test_paper_manage">
    <div class="search_amount">共 {{ filterTestPaperList.length }} 条结果</div>
    <div class="test_paper_manage_container">
      <div class="filter_container">
        <div class="filter_item">
          <div class="text">标题</div>
          <input class="input_box" v-model="title" />
        </div>
        <div class="filter_item">
          <div class="text">创建者</div>
          <input class="input_box" v-model="creator_id" />
        </div>
        <div class="filter_item">
          <div class="text">科目</div>
          <el-select class="select" v-model="subject_id" placeholder="科目" size="mini">
            <el-option
              v-for="subject_id in subjectIdOptions"
              :key="subject_id.value"
              :label="subject_id.value"
              :value="subject_id.index">
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
          <div class="text">学年</div>
          <el-select class="select" v-model="school_year" placeholder="学年" size="mini">
            <el-option
              v-for="school_year in schoolYearOptions"
              :key="school_year.value"
              :label="school_year.value"
              :value="school_year.value">
            </el-option>
          </el-select>
        </div>
        <div class="filter_item">
          <div class="text">学期</div>
          <el-select class="select" v-model="semester" placeholder="学期" size="mini">
            <el-option
              v-for="semester in semesterOptions"
              :key="semester.value"
              :label="semester.value"
              :value="semester.value">
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
      <div class="test_paper_id">ID</div>
      <div class="title">标题</div>
      <div class="creator_id">创建者</div>
      <div class="subject_id">科目</div>
      <div class="difficulty_degree">难度</div>
      <div class="school_year">学年</div>
      <div class="semester">学期</div>
      <div class="operation">操作</div>
    </div>
    <div class="body">
      <div class="test_paper_container" :class="index%2 == 0 ? 'deep_shadow' : 'shallow_shadow'" v-for="(item, index) in currentTestPaperList" :key="index">
        <div class="test_paper_info">
          <div :title="item.test_paper_id">{{ item.test_paper_id }}</div>
        </div>
        <div class="test_paper_info title">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.title">{{ item.title }}</div>
          <input v-else v-model="modify_title" />
        </div>
        <div class="test_paper_info">
          <div :title="item.creator_id">{{ item.creator_id }}</div>
        </div>
        <div class="test_paper_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="getSubject(item.subject_id)">{{ getSubject(item.subject_id) }}</div>
          <el-select v-else class="select" v-model="modify_subject_id" placeholder="科目" size="small">
            <el-option
              v-for="subject_id in subjectIdOptions"
              :key="subject_id.value"
              :label="subject_id.value"
              :value="subject_id.index">
            </el-option>
          </el-select>
        </div>
        <div class="test_paper_info">
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
        <div class="test_paper_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.school_year">{{ item.school_year }}</div>
          <el-select v-else class="select" v-model="modify_school_year" placeholder="学年" size="small">
            <el-option
              v-for="school_year in schoolYearOptions"
              :key="school_year.value"
              :label="school_year.value"
              :value="school_year.value">
            </el-option>
          </el-select>
        </div>
        <div class="test_paper_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.semester">{{ item.semester }}</div>
          <el-select v-else class="select" v-model="modify_semester" placeholder="学期" size="small">
            <el-option
              v-for="semester in semesterOptions"
              :key="semester.value"
              :label="semester.value"
              :value="semester.value">
            </el-option>
          </el-select>
        </div>
        <div class="test_paper_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" class="operation">
            <div class="detail" @click="gotoTestPaperDetail(index)">查看</div>
            <div class="modify" @click="modifyTestPaper(index)">修改</div>
            <div class="delete" @click="deleteTestPaper(index)">删除</div>
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
import { TestPaperService } from "src/service/testPaper.js";

export default {
  data() {
    return {
      title: null,
      creator_id: null,
      subject_id: null,
      difficulty_degree: null,
      school_year: null,
      semester: null,
      modify_title: null,
      modify_subject_id: null,
      modify_difficulty_degree: null,
      modify_school_year: null,
      modify_semester: null,
      modify: [],
      testPaperList: [],
      filterTestPaperList: [],
      pageSize: 10,
      total: 0,
      currentPage: 1,
      currentTestPaperList: [],
      subjectIdOptions: [
        { value: "算法", index: 1 }, { value: "编程语言", index: 2 }, { value: "数据结构", index: 3 }, { value: "计算机基础", index: 4 }, { value: "数学和逻辑", index: 5 }, { value: "软件开发", index: 6 }
      ],
      difficultyDegreeOptions: [
        { value: "一星", index: "1" }, { value: "二星", index: "2" }, { value: "三星", index: "3" }, { value: "四星", index: "4" }, { value: "五星", index: "5" }
      ],
      schoolYearOptions: [
        { value: "2018-2019" }, { value: "2017-2018" }, { value: "2016-2017" }, { value: "2015-2016" }, { value: "2014-2015" }
      ],
      semesterOptions: [
        { value: 1 }, { value: 2 }
      ],
    };
  },

  watch: {
    filterTestPaperList() {
      this.total = this.filterTestPaperList.length;
      this.currentPage = 1;
      this.currentTestPaperList = this.filterTestPaperList.slice(0, this.pageSize);
      this.currentTestPaperList = JSON.parse(JSON.stringify(this.currentTestPaperList));
      this.modify = [];
      for(let i = 0; i < this.filterTestPaperList.length; i++) {
        this.modify[i] = false;
      }
    }
  },

  mounted() {
    this.initData();
  },

  methods: {
    async initData() {
      this.testPaperList = await TestPaperService.getAllOfTestPaper();
      if(this.testPaperList && this.testPaperList.length) {
        this.filterTestPaperList = JSON.parse(JSON.stringify(this.testPaperList));
      }
    },

    handleCurrentChange(val) {
      this.currentTestPaperList = this.filterTestPaperList.slice((val-1)*this.pageSize, val*this.pageSize);
      domUtil.setScrollTop(0);
    },

    clickFilter() {
      let tempTestPaperList = [];
      this.filterTestPaperList = JSON.parse(JSON.stringify(this.testPaperList));
      if(this.title && this.filterTestPaperList.length) {
        tempTestPaperList = this.filterTestPaperList;
        this.filterTestPaperList = [];
        tempTestPaperList.forEach(testPaper => {
          if(testPaper.title.search(this.title) !== -1) {
            this.filterTestPaperList.push(testPaper);
          }
        });
      }
      if(this.creator_id && this.filterTestPaperList.length) {
        tempTestPaperList = this.filterTestPaperList;
        this.filterTestPaperList = [];
        tempTestPaperList.forEach(testPaper => {
          if(testPaper.creator_id.search(this.creator_id) !== -1) {
            this.filterTestPaperList.push(testPaper);
          }
        });
      }
      if(this.subject_id && this.filterTestPaperList.length) {
        tempTestPaperList = this.filterTestPaperList;
        this.filterTestPaperList = [];
        tempTestPaperList.forEach(testPaper => {
          if(testPaper.subject_id == this.subject_id) {
            this.filterTestPaperList.push(testPaper);
          }
        });
      }
      if(this.difficulty_degree && this.filterTestPaperList.length) {
        tempTestPaperList = this.filterTestPaperList;
        this.filterTestPaperList = [];
        tempTestPaperList.forEach(testPaper => {
          if(testPaper.difficulty_degree == this.difficulty_degree) {
            this.filterTestPaperList.push(testPaper);
          }
        });
      }
      if(this.school_year && this.filterTestPaperList.length) {
        tempTestPaperList = this.filterTestPaperList;
        this.filterTestPaperList = [];
        tempTestPaperList.forEach(testPaper => {
          if(testPaper.school_year == this.school_year) {
            this.filterTestPaperList.push(testPaper);
          }
        });
      }
      if(this.semester && this.filterTestPaperList.length) {
        tempTestPaperList = this.filterTestPaperList;
        this.filterTestPaperList = [];
        tempTestPaperList.forEach(testPaper => {
          if(testPaper.semester == this.semester) {
            this.filterTestPaperList.push(testPaper);
          }
        });
      }
      this.filterTestPaperList = JSON.parse(JSON.stringify(this.filterTestPaperList));
    },

    reset() {
      this.title = null;
      this.creator_id = null;
      this.subject_id = null;
      this.difficulty_degree = null;
      this.school_year = null;
      this.semester = null;
      this.clickFilter();
    },

    gotoTestPaperDetail(index) {
      let item = this.filterTestPaperList[(this.currentPage-1) * this.pageSize + index];
      TestPaperService.saveTestPaper(item);
      this.$router.push({
        name: "backTestPaperDetail",
        params: {
          test_paper_id: item.test_paper_id
        }
      });
    },

    modifyTestPaper(index) {
      this.modify[(this.currentPage-1) * this.pageSize + index] = true;
      this.modify = JSON.parse(JSON.stringify(this.modify));
      let item = this.testPaperList[(this.currentPage-1) * this.pageSize + index];
      this.modify_title = item.title;
      this.modify_subject_id = item.subject_id;
      this.modify_difficulty_degree = item.difficulty_degree;
      this.modify_school_year = item.school_year;
      this.modify_semester = item.semester;
    },

    async deleteTestPaper(index) {
      this.$confirm('确定删除该试卷？').then(async () => {
        let item = this.testPaperList[(this.currentPage-1) * this.pageSize + index];
        let response = await TestPaperService.deleteTestPaper(item.test_paper_id);
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
      if(this.modify_title === "") {
        this.$toast.text("标题不能为空");
        return;
      }
      let item = this.testPaperList[(this.currentPage-1) * this.pageSize + index];
      item.title = this.modify_title;
      item.subject_id = this.modify_subject_id;
      item.difficulty_degree = this.modify_difficulty_degree;
      item.school_year = this.modify_school_year;
      item.semester = this.modify_semester;
      let response = await TestPaperService.modifyTestPaper(item);
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

    getSubject(subject_id) {
      return common.getSubject(subject_id);
    },

    getDifficultyDegree(difficulty_degree) {
      return common.getDifficultyDegree(difficulty_degree);
    }
  }
};
</script>

<style lang="scss" scoped>
.test_paper_manage {
  margin: 0.5rem;
  font-size: 0.2rem;
  display: flex;
  flex-direction: column;

  .search_amount {
    margin: 0 0.3rem;
    font-size: 0.2rem;
  }

  .test_paper_manage_container {
    margin: 0.2rem;

    .filter_container {
      display: flex;
      justify-content: space-between;
      align-items: center;
      .filter_item {
        margin: 0 0.05rem;
        font-size: 0.2rem;
        width: 1.8rem;
        display: flex;
        align-items: center;
        .text {
          flex: 0 0 auto;
          margin-right: 0.05rem;
        }
        input {
          width: 1.3rem;
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
      width: 10%;
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
    .test_paper_container {
      padding: 0.1rem 0;
      width: 100%;
      display: flex;
      align-items: center;
      .test_paper_info {
        width: 10%;
        display: flex;
        justify-content: center;
        align-items: center;
        div {
          text-align: center;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;
        }
        input {
          border: 0;
          padding: 0 0.05rem;
          width: 80%;
          height: 0.3rem;
          font-size: 0.18rem;
        }
      }
      .title {
        width: 30% !important;
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
