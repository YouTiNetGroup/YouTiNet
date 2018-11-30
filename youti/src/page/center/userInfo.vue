<template>
    <div>
        <el-row>
            <div class="right_box">
                <div class="right_title">
                    <span>个人信息</span>
                </div>
                <div class="right_body" style="display: flex; margin: 0.2rem">
                    <div class="photo">
                        <img src="../../assets/images/avatar_default.png" style="width: 100%; height: 100%; position: absolute">
                    </div>
                    <div class="person_detail">
                        <div class="detail">
                            <span>{{this.name}}</span>
                        </div>
                        <div class="detail">
                            <p>邮箱：
                                <strong>{{this.email}}</strong>
                            </p>
                            <p>电话：
                                <strong>{{this.phone}}</strong>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </el-row>
    </div>
</template>

<script>
import {AccountService} from "../../service/account";

export default {
  data() {
    return {
      name: '',
      email: '',
      phone: '',
    };
  },
  created() {
    this.initData();
  },
  methods: {
    initData() {
      let items = AccountService.getUserInfo();
      this.name = items.name;
      this.email = items.email;
      this.phone = items.phone;
    }
  }
};
</script>

<style lang="scss" scoped>
.right_box {
  border: 1px solid #dddddd;
  margin-bottom: 0.3rem;
  .right_title {
    font-size: 0.15rem;
    border-bottom: #dddddd;
    background: #e2edfb;
    padding: 5px;
    padding-left: 0.2rem;
  }
  .right_body {
    display: flex;
    margin: 0.2rem;
    .photo {
      width: 1.2rem;
      height: 1.2rem;
      position: relative;
    }
    .person_detail {
      display: flex;
      flex-direction: column;
      margin-left: 0.2rem;
      .detail {
        font-size: 0.2rem;
        color: #333333;
        margin-bottom: 0.1rem;
      }
    }
    p {
      margin-bottom: 0.1rem;
      font-size: 0.12rem;
    }
  }
}
</style>
