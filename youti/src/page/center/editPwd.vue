<template>
    <div>
        <el-form :model="pwdForm" status-icon :rules="rules" ref="pwdForm" label-width="100px" size="medium">
            <el-form-item label="原密码" prop="oldPass">
                <el-row>
                    <el-col :span="8">
                        <el-input type="password" v-model="pwdForm.oldPass" autocomplete="off"></el-input>
                    </el-col>
                </el-row>
            </el-form-item>
            <el-form-item label="新密码" prop="pass">
                <el-row>
                    <el-col :span="8">
                <el-input type="password" v-model="pwdForm.pass" autocomplete="off"></el-input>
                    </el-col>
                </el-row>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
                <el-row>
                    <el-col :span="8">
                <el-input type="password" v-model="pwdForm.checkPass" autocomplete="off"></el-input>
                    </el-col>
                </el-row>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('pwdForm')" plain>修改</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>

<script>
import { AccountService } from "../../service/account";

export default {
  data() {
    var validatePass0 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入原密码"));
      } else if (value !== this.userInfo.password) {
        callback(new Error("原密码错误"));
      } else callback();
    };
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入新密码"));
      } else {
        if (this.pwdForm.checkPass !== "") {
          this.$refs.pwdForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.pwdForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      userInfo: null,
      pwdForm: {
        oldPass: "",
        pass: "",
        checkPass: ""
      },
      rules: {
        oldPass: [
          { required: true, validator: validatePass0, trigger: "blur" }
        ],
        pass: [{ required: true, validator: validatePass, trigger: "blur" }],
        checkPass: [
          { required: true, validator: validatePass2, trigger: "blur" }
        ]
      }
    };
  },

  mounted() {
    this.initData();
  },

  methods: {
    async initData() {
      this.userInfo = await AccountService.getUserInfo();
    },
    submitForm(formName) {
      this.$refs[formName].validate(async valid => {
        if (valid) {
          this.userInfo.password = this.pwdForm.pass;
          let response = await AccountService.updateUser(this.userInfo);
          if (response) {
            this.$toast.text("修改成功");
          } else {
            this.$toast.text("修改失败");
          }
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style lang="scss" scoped>
</style>
