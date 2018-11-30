<template>
	<div class="backstage">
    <div class="backstage_side">
      <img src="../../assets/images/avatar_default.png" />
      <div class="user_name">{{ userInfo.name }}</div>
      <el-menu
        class="el-menu-vertical-demo"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        :default-active="$route.path"
        router>
        <el-menu-item index="/backstage/home">
          <i class="iconfont">&#xe7c6;</i>
          <span slot="title">首页</span>
        </el-menu-item>
        <el-menu-item index="/backstage/user">
          <i class="iconfont">&#xe7ae;</i>
          <span slot="title">用户管理</span>
        </el-menu-item>
        <el-menu-item index="/backstage/testPaper">
          <i class="iconfont">&#xe7b9;</i>
          <span slot="title">试卷管理</span>
        </el-menu-item>
        <el-menu-item index="/backstage/question">
          <i class="iconfont">&#xe782;</i>
          <span slot="title">题库管理</span>
        </el-menu-item>
        <el-menu-item index="/backstageLogin" @click="logout">
          <i class="iconfont">&#xe78c;</i>
          <span slot="title">注销</span>
        </el-menu-item>
      </el-menu>
    </div>
		<div class="backstage_body">
			<transition name="fade" mode="out-in"><router-view></router-view></transition>
		</div>
	</div>
</template>

<script type="text/javascript">
import { AccountService } from "src/service/account";

export default {
  data() {
    return {
      userInfo: {},
      hasLogin: false,
    };
  },

  async mounted() {
    this.hasLogin = await AccountService.hasLogin();
    if (this.hasLogin) {
      this.userInfo = await AccountService.getUserInfo();
    } else {
      this.$router.push("/backstageLogin");
    }
  },

  methods: {
    async logout() {
      await AccountService.logout();
    }
  },

  destroyed() {
    AccountService.logout();
  }
};
</script>

<style lang="scss" scoped>
@font-face {font-family: "iconfont";
  src: url('//at.alicdn.com/t/font_944456_69lm7c6fs5j.eot?t=1543580870219'); /* IE9*/
  src: url('//at.alicdn.com/t/font_944456_69lm7c6fs5j.eot?t=1543580870219#iefix') format('embedded-opentype'), /* IE6-IE8 */
  url('data:application/x-font-woff;charset=utf-8;base64,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') format('woff'),
  url('//at.alicdn.com/t/font_944456_69lm7c6fs5j.ttf?t=1543580870219') format('truetype'), /* chrome, firefox, opera, Safari, Android, iOS 4.2+*/
  url('//at.alicdn.com/t/font_944456_69lm7c6fs5j.svg?t=1543580870219#iconfont') format('svg'); /* iOS 4.1- */
}

.iconfont {
  font-family:"iconfont" !important;
  font-size:16px;
  font-style:normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.backstage {
  width: 100%;
  height: 100%;

  .backstage_side {
    position: fixed;
    top: 0;
    left: 0;
    width: 10%;
    height: 100%;
    background: #545c64;
    display: flex;
    flex-direction: column;
    align-items: center;
    img {
      margin-top: 0.5rem;
      width: 1rem;
    }
    .user_name {
      margin: 0.2rem;
      font-size: 0.22rem;
      color: #4ab2e2
    }
    .el-menu-vertical-demo {
      width: 101%;
      /deep/ .el-menu-item {
        font-size: 0.18rem;
        padding: 0 0.2rem !important;
        .iconfont {
          font-size: 0.25rem;
        }
      }
    }
  }

  .backstage_body {
    margin-left: 10%;
    width: 90%;
    height: 100%;
  }
}
</style>
