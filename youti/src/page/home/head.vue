<template>
	<div class="header">
		<div class="logo_and_title" @click="gotoHome">
			<div class="logo">
				<img src="../../assets/images/logo.jpg" />
			</div>
			<div class="title">优题网</div>
		</div>
		<div class="menu">
			<div v-if="!hasLogin" class="login_or_register" @click="gotoLogin">登录/注册</div>
			<div class="my_test_paper" @click="gotoMyTestPaper">我的试卷</div>
			<div class="auto_generation" @click="gotoAutoGeneration">智能组卷</div>
      <el-badge :value="paperQuestions.length" :hidden="paperQuestions.length==0" class="item">
        <div class="manual_generation" @click="gotoManualGeneration">手动组卷</div>
      </el-badge>
			<div class="quetion_bank" @click="gotoQuestionBank">查看题库</div>
			<div class="user_container">
				<el-dropdown v-if="hasLogin" @command="handleCommand">
					<div class="user_info">
						<img :src="userImg"/>
						<span class="username">{{ userInfo.name || userInfo.account_id }}</span>
					</div>
					<el-dropdown-menu slot="dropdown">
						<el-dropdown-item command="userInfo">个人信息</el-dropdown-item>
						<el-dropdown-item command="my_test_paper">我的试卷</el-dropdown-item>
						<el-dropdown-item command="exit" divided>退出</el-dropdown-item>
					</el-dropdown-menu>
				</el-dropdown>
				<div v-else class="user_center" @click="gotoUserCenter">个人中心</div>
			</div>
		</div>
	</div>
</template>

<script type="text/javascript">
import { AccountService } from "src/service/account";
import { QuestionService } from "src/service/question.js";
import { globalBus } from "src/service/globalBus";

export default {
  data() {
    return {
      userImg: require("src/assets/images/logo.jpg"),
      userInfo: {},
      hasLogin: false,
      paperQuestions: [],
    };
  },

  created() {
    this.computeNum();
  },

  async mounted() {
    this.hasLogin = await AccountService.hasLogin();
    if (this.hasLogin) {
      this.userInfo = await AccountService.getUserInfo();
      this.paperQuestions = QuestionService.getAllPaperQuestions();
    }
  },

  methods: {
    computeNum() {
      globalBus.$on('paperQuestionChange', () => {
        this.paperQuestions = QuestionService.getAllPaperQuestions();
      });
    },

    gotoHome() {
      this.$router.push("/page/home");
    },

    gotoLogin() {
      this.$router.push("/login");
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

    gotoUserCenter() {
      if (!this.hasLogin) {
        this.$toast.text("您还未登录，请先登录");
        return;
      }
      this.$router.push("/page/userCenter");
    },

    async handleCommand(command) {
      if (command == "userInfo") {
        this.$router.push("/page/userCenter/userInfo");
      } else if (command == "my_test_paper") {
        this.$router.push("/page/userCenter/myTestPaper");
      } else if (command == "exit") {
        await AccountService.logout();
        this.$router.push("/page/home");
        window.location.reload();
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;

  .logo_and_title {
    display: flex;
    align-items: center;
    cursor: pointer;

    .logo {
      margin-left: 0.5rem;
      width: 0.8rem;
      height: 0.8rem;
      display: flex;
      align-items: center;

      img {
        width: 100%;
        height: 100%;
      }
    }

    .title {
      margin-left: 0.2rem;
      font-size: 0.4rem;
      font-weight: bold;
    }
  }

  .menu {
    margin-right: 0.5rem;
    display: flex;
    align-items: center;

    .login_or_register {
      font-size: 0.22rem;
      cursor: pointer;
    }

    .my_test_paper {
      margin-left: 0.3rem;
      font-size: 0.22rem;
      cursor: pointer;
    }

    .auto_generation {
      margin-left: 0.3rem;
      font-size: 0.22rem;
      cursor: pointer;
    }

    .manual_generation {
      margin-left: 0.3rem;
      font-size: 0.22rem;
      cursor: pointer;
    }

    .quetion_bank {
      margin-left: 0.3rem;
      font-size: 0.22rem;
      cursor: pointer;
    }

    .user_container {
      margin-left: 0.3rem;
      cursor: pointer;
      display: flex;
      align-items: center;

      .user_info {
        display: flex;
        align-items: center;

        img {
          width: 0.6rem;
          height: 0.6rem;
          border-radius: 50%;
        }

        .username {
          margin-left: 0.1rem;
          font-size: 0.22rem;
          color: #00bde5;
        }
      }

      .user_center {
        color: #ffffff;
        font-size: 0.22rem;
        cursor: pointer;
      }
    }
  }
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
