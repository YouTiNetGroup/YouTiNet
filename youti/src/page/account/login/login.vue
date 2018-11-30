<template>
	<div class="register_container">
    <div class="main_container">
      <div class="head">
        <img class="logo" src="../../../assets/images/logo.jpg" />
        <div class="text">
          <div class="title">优题网</div>
          <div class="description">试卷智能生成与题库管理系统</div>
        </div>
      </div>
      <div class="body">
        <div class="account_container">
          <div class="account_icon">
            <svg id="account-icon">
              <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-login-account" />
            </svg>
          </div>
          帐号：<input class="account" v-model="userAccount" placeholder="请输入帐号" @keyup.enter="checkLogin" />
        </div>
        <div v-show="showAccountNullError" class="error_prompt">帐号不能为空!</div>
        <div class="password_container">
          <div class="lock_icon">
            <svg id="lock-icon">
              <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-login-lock" />
            </svg>
          </div>
          密码：<input class="password" v-model="password" type="password" placeholder="请输入密码" @keyup.enter="checkLogin" />
        </div>
        <div v-show="showPswNullError" class="error_prompt">密码不能为空!</div>
        <div class="login_text" @click="gotoRegister">没有帐号? 立即去注册！</div>
      </div>
      <div class="foot" @click="checkLogin">
        <div class="commit">登录</div>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import { AccountService } from "src/service/account";

export default {
  data() {
    return {
      userAccount: null,
      password: null,
      showAccountNullError: false,
      showPswNullError: false,
    };
  },

  watch: {
    userAccount() {
      if(this.userAccount) {
        this.showAccountNullError = false;
      }
    },
    password() {
      if(this.password) {
        this.showPswNullError = false;
      }
    }
  },

  methods: {
    gotoRegister() {
      this.$router.push("/register");
    },

    async checkLogin() {
      if(!this.userAccount) {
        this.showAccountNullError = true;
        return;
      }
      if(!this.password) {
        this.showPswNullError = true;
        return;
      }
      let response = await AccountService.userlogin({
        account_id: this.userAccount,
        password: this.password,
        privilege: "admin"
      });
      if(response && response.isSuccess) {
        this.$router.push("/page/home");
      } else {
        this.$toast.text(response.message);
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.register_container {
  width: 100%;
  height: 100%;
  background-image: url("../../../assets/images/background.jpg");
  background-size: 100% 100%;
  display: flex;
  justify-content: center;
  align-items: center;

  .main_container {
    display: flex;
    flex-direction: column;
    justify-content: center;

    .head {
      .logo {
        width: 1rem;
      }

      .text {
        display: inline-block;
        .title {
          font-size: 0.6rem;
          display: inline;
        }

        .description {
          font-size: 0.22rem;
        }
      }
    }

    .body {
      margin-top: 0.5rem;
      display: flex;
      flex-direction: column;
      align-items: center;

      .account_container {
        font-size: 0.2rem;
        display: flex;
        justify-content: space-between;
        align-items: center;

        .account_icon {
          width: 0.25rem;
          height: 0.25rem;
          background: #00bde5;
          margin-right: 0.1rem;

          svg {
            width: 100%;
            height: 100%;
          }
        }

        .account {
          width: 3rem;
          height: 0.35rem;
          padding: 0 0.06rem;
          font-size: 0.16rem;
          letter-spacing: 0.02rem;
        }
      }

      .password_container {
        margin-top: 0.2rem;
        font-size: 0.2rem;
        display: flex;
        justify-content: space-between;
        align-items: center;

        .lock_icon {
          width: 0.25rem;
          height: 0.25rem;
          background: #00bde5;
          margin-right: 0.1rem;

          svg {
            width: 100%;
            height: 100%;
          }
        }

        .password {
          width: 3rem;
          height: 0.35rem;
          padding: 0 0.06rem;
          font-size: 0.16rem;
          letter-spacing: 0.02rem;
        }
      }

      .error_prompt {
        font-size: 0.15rem;
        color: #e23c30;
      }
      
      .login_text {
        margin-top: 0.2rem;
        font-size: 0.22rem;
        color: #27c7a4;
        cursor: pointer;
      }
    }

    .foot {
      margin-top: 0.3rem;
      width: 4.2rem;
      height: 0.5rem;
      background-image: linear-gradient(-225deg, #00bde5 0%, rgb(77, 165, 236) 100%);
      border-radius: 0.1rem;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;

      .commit {
        font-size: 0.25rem;
      }
    }
  }
}
</style>
