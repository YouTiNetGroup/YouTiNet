<template>
  <div class="home">
    <div class="breadcrumb">
      <el-breadcrumb>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content">
      <div class="my_test_paper" @mouseover="showMyTestPaperDesc" @mouseout="showMyTestPaperText" @click="gotoMyTestPaper">{{ myTestPaper }}</div>
			<div class="auto_generation" @mouseover="showAutoGenerationDesc" @mouseout="showAutoGenerationText" @click="gotoAutoGeneration">{{ autoGeneration }}</div>
			<div class="manual_generation" @mouseover="showManualGenerationDesc" @mouseout="showManualGenerationText" @click="gotoManualGeneration">{{ manualGeneration }}</div>
			<div class="quetion_bank" @mouseover="showQuestionBankDesc" @mouseout="showQuestionBankText" @click="gotoQuestionBank">{{ questionBank }}</div>
    </div>

    </div>
</template>

<script>
import { AccountService } from "src/service/account.js";

export default {
  data() {
    return {
      hasLogin: false,
      myTestPaper: "我的试卷",
      autoGeneration: "智能组卷",
      manualGeneration: "手动组卷",
      questionBank: "查看题库"
    };
  },

  components: {
  },

  async mounted() {
    this.hasLogin = await AccountService.hasLogin();
  },

  methods: {
    showMyTestPaperDesc() {
      this.myTestPaper = "包含您之前所生成的所有试卷，您可以查看、编辑或导出这些试卷"
    },
    showMyTestPaperText() {
      this.myTestPaper = "我的试卷"
    },
    showAutoGenerationDesc() {
      this.autoGeneration = "您可以根据提示，设置条件，来快速智能生成一份符合需求的试卷"
    },
    showAutoGenerationText() {
      this.autoGeneration = "智能组卷"
    },
    showManualGenerationDesc() {
      this.manualGeneration = "您可以在题库中选择您需要的试题，来定制一份您的专属试卷"
    },
    showManualGenerationText() {
      this.manualGeneration = "手动组卷"
    },
    showQuestionBankDesc() {
      this.questionBank = "在题库页，您可以查看系统内的所有试题，还可以搜索、筛选试题"
    },
    showQuestionBankText() {
      this.questionBank = "查看题库"
    },

    gotoMyTestPaper() {
      if (!this.hasLogin) {
        this.$toast.text("您还未登录，请先登录");
        return;
      }
      this.$router.push("/page/userCenter/myTestPaper");
    },

    gotoAutoGeneration() {
      if (!this.hasLogin) {
        this.$toast.text("您还未登录，请先登录");
        return;
      }
      this.$router.push("/page/autoGeneration");
    },

    gotoManualGeneration() {
      if (!this.hasLogin) {
        this.$toast.text("您还未登录，请先登录");
        return;
      }
      this.$router.push("/page/manualGeneration");
    },

    gotoQuestionBank() {
      if (!this.hasLogin) {
        this.$toast.text("您还未登录，请先登录");
        return;
      }
      this.$router.push("/page/questionBank");
    },
  }
};
</script>

<style lang="scss" scoped>
.home {
  padding: 0.2rem 2.5rem;
  .breadcrumb {
    padding: 0.2rem;
    border-bottom: 1px solid #dddddd;
  }
  .content {
    padding: 0.2rem 0.8rem;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;

    div {
      width: 4rem;
      height: 2.5rem;
      margin: 0.1rem;
      padding: 0 0.2rem;
      font-size: 0.45rem;
      letter-spacing: 0.1rem;
      border-radius: 0.2rem;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
    }

    div:hover {
      background: rgba(95, 104, 111, 0.85);
      font-size: 0.3rem;
      color: #ffffff;
    }

    .my_test_paper {
      background: linear-gradient(to bottom right,#85f0f0,#85b0f0);
      // background:  #9ad5e4;
    }

    .auto_generation {
      background: linear-gradient(to bottom left,#85f0f0,#85f09c);
      // background:  #4cf3c1;
    }

    .manual_generation {
      background: linear-gradient(to top right,#85f0f0,#85f09c);
      // background:  #4cf3c1;
    }

    .quetion_bank {
      background: linear-gradient(to top left,#85f0f0,#85b0f0);
      // background:  #9ad5e4;
    }
  }
}
</style>
