<template>
    <div>
        <div class="form">
            <el-form :model="formData" status-icon :rules="rules" ref="form" label-width="100px" label-position="right" size="small">
                <el-form-item label="帐号">
                    {{this.formData.account_id}}
                </el-form-item>
                <el-form-item label="用户名" prop="name">
                    <el-row>
                        <el-col :span="8">
                            <el-input v-model="formData.name"></el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-row>
                        <el-col :span="8">
                            <el-input v-model="formData.email"></el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
                <el-form-item label="电话" prop="phone">
                    <el-row>
                        <el-col :span="8">
                            <el-input v-model="formData.phone"></el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('form', formData)" plain>保存</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
import { AccountService } from "../../service/account";

export default {
  data() {
    var checkUserName = (rule, value, callback) => {
      if (!this.formData.username && !value) {
        callback(new Error("请输入用户名"));
      } else callback();
    };
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        callback(new Error("电话号码不可为空"));
      } else if (value.length !== 11) {
        callback(new Error("电话号码不是11位"));
      } else if (!this.isPoneAvailable(value)) {
        callback(new Error("电话号码不正确"));
      } else callback();
    };
    var checkEmail = (rule, value, callback) => {
      if (!value) {
        callback(new Error("请输入邮箱"));
      } else if (!(value.includes(".com") && value.includes("@"))) {
        callback(new Error("邮箱格式错误"));
      } else callback();
    };
    return {
      userInfo: null,
      formData: {
        account_id: "",
        name: "",
        email: "",
        phone: "",
      },
      rules: {
        name: [{ required: true, validator: checkUserName, trigger: "blur" }],
        email: [
          { type: "email", validator: checkEmail, trigger: ["blur", "change"] }
        ],
        phone: [{ required: true, validator: checkPhone, trigger: "blur" }],
      }
    };
  },
  created() {
    this.initData();
  },
  methods: {
    submitForm(formName, data) {
      this.$refs[formName].validate(async valid => {
        if (valid) {
          this.userInfo.name = data.name;
          this.userInfo.email = data.email;
          this.userInfo.phone = data.phone;
          let response = await AccountService.updateUser(this.userInfo);
          if (response) {
            this.$toast.text("信息修改成功");
          }
          this.initData();
        } else {
          return false;
        }
      });
    },
    initData() {
      this.userInfo = AccountService.getUserInfo();
      this.formData.account_id = this.userInfo.account_id;
      this.formData.name = this.userInfo.name;
      this.formData.email = this.userInfo.email;
      this.formData.phone = this.userInfo.phone;
    },

    isPoneAvailable(str) {
      var myreg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      if (!myreg.test(str)) {
        return false;
      } else {
        return true;
      }
    }
  }
};
</script>

<style lang="scss" scoped>
</style>
