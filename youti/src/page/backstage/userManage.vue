<template>
	<div class="user_manage">
    <div class="search_amount">共 {{ filterUserList.length }} 条结果</div>
    <div class="user_manage_container">
      <div class="filter_container">
        <div class="account_id">
          <div class="text">帐号</div>
          <input class="input_box" v-model="account_id" />
        </div>
        <div class="name">
          <div class="text">姓名</div>
          <input class="input_box" v-model="name" />
        </div>
        <div class="email">
          <div class="text">邮箱</div>
          <input class="input_box" v-model="email" />
        </div>
        <div class="phone">
          <div class="text">电话</div>
          <input class="input_box" v-model.number="phone" />
        </div>
        <div class="privilege">
          <div class="text">权限</div>
          <el-select class="select" v-model="privilege" placeholder="权限" size="small">
            <el-option
              v-for="privilege in privilegeOptions"
              :key="privilege.value"
              :label="privilege.value"
              :value="privilege.index">
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
      <div class="account_id">帐号</div>
      <div class="name">姓名</div>
      <div class="email">邮箱</div>
      <div class="phone">电话</div>
      <div class="privilege">权限</div>
      <div class="operation">操作</div>
    </div>
    <div class="body">
      <div class="user_container" :class="index%2 == 0 ? 'deep_shadow' : 'shallow_shadow'" v-for="(item, index) in currentUserList" :key="index">
        <div class="user_info">
          <div :title="item.account_id">{{ item.account_id }}</div>
        </div>
        <div class="user_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.name">{{ item.name }}</div>
          <input v-else v-model="userName" />
        </div>
        <div class="user_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.email">{{ item.email }}</div>
          <input v-else v-model="userEmail" />
        </div>
        <div class="user_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.phone">{{ item.phone }}</div>
          <input v-else v-model="userPhone" />
        </div>
        <div class="user_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" :title="item.privilege">{{ item.privilege }}</div>
          <el-select v-else class="select" v-model="userPrivilege" placeholder="权限" size="small">
            <el-option
              v-for="privilege in privilegeOptions"
              :key="privilege.value"
              :label="privilege.value"
              :value="privilege.index">
            </el-option>
          </el-select>
        </div>
        <div class="user_info">
          <div v-if="!modify[(currentPage-1) * pageSize + index]" class="operation">
            <div class="modify" @click="modifyUser(index)">修改</div>
            <div class="delete" @click="deleteUser(index)">删除</div>
          </div>
          <div v-else  class="operation">
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
import { AccountService } from "src/service/account.js";

export default {
  data() {
    return {
      account_id: null,
      name: null,
      email: null,
      phone: null,
      privilege: null,
      userName: null,
      userEmail: null,
      userPhone: null,
      userPrivilege: null,
      modify: [],
      userList: [],
      filterUserList: [],
      pageSize: 10,
      total: 0,
      currentPage: 1,
      currentUserList: [],
      privilegeOptions: [
        { value: "user", index: "user" }, { value: "admin", index: "admin" }
      ]
    };
  },

  watch: {
    filterUserList() {
      this.total = this.filterUserList.length;
      this.currentPage = 1;
      this.currentUserList = this.filterUserList.slice(0, this.pageSize);
      this.currentUserList = JSON.parse(JSON.stringify(this.currentUserList));
      this.modify = [];
      for(let i = 0; i < this.filterUserList.length; i++) {
        this.modify[i] = false;
      }
    }
  },

  mounted() {
    this.initData();
  },

  methods: {
    async initData() {
      this.userList = await AccountService.getAllOfUsers();
      if(this.userList && this.userList.length) {
        this.filterUserList = JSON.parse(JSON.stringify(this.userList));
      }
    },

    handleCurrentChange(val) {
      this.currentUserList = this.filterUserList.slice((val-1)*this.pageSize, val*this.pageSize);
      domUtil.setScrollTop(0);
    },

    clickFilter() {
      let tempUserList = [];
      this.filterUserList = JSON.parse(JSON.stringify(this.userList));
      if(this.account_id && this.filterUserList.length) {
        tempUserList = this.filterUserList;
        this.filterUserList = [];
        tempUserList.forEach(user => {
          if(user.account_id.search(this.account_id) !== -1) {
            this.filterUserList.push(user);
          }
        });
      }
      if(this.name && this.filterUserList.length) {
        tempUserList = this.filterUserList;
        this.filterUserList = [];
        tempUserList.forEach(user => {
          if(user.name.search(this.name) !== -1) {
            this.filterUserList.push(user);
          }
        });
      }
      if(this.email && this.filterUserList.length) {
        tempUserList = this.filterUserList;
        this.filterUserList = [];
        tempUserList.forEach(user => {
          if(user.email.search(this.email) !== -1) {
            this.filterUserList.push(user);
          }
        });
      }
      if(this.phone && this.filterUserList.length) {
        tempUserList = this.filterUserList;
        this.filterUserList = [];
        tempUserList.forEach(user => {
          if(user.phone.search(this.phone) !== -1) {
            this.filterUserList.push(user);
          }
        });
      }
      if(this.privilege && this.filterUserList.length) {
        tempUserList = this.filterUserList;
        this.filterUserList = [];
        tempUserList.forEach(user => {
          if(user.privilege == this.privilege) {
            this.filterUserList.push(user);
          }
        });
      }
      this.filterUserList = JSON.parse(JSON.stringify(this.filterUserList));
    },

    reset() {
      this.account_id = null;
      this.name = null;
      this.email = null;
      this.phone = null;
      this.privilege = null;
      this.clickFilter();
    },

    modifyUser(index) {
      this.modify[(this.currentPage-1) * this.pageSize + index] = true;
      this.modify = JSON.parse(JSON.stringify(this.modify));
      let item = this.userList[(this.currentPage-1) * this.pageSize + index];
      this.userName = item.name;
      this.userEmail = item.email;
      this.userPhone = item.phone;
      this.userPrivilege = item.privilege;
    },

    deleteUser(index) {
      this.$confirm('确定删除该用户？').then(async () => {
        let item = this.userList[(this.currentPage-1) * this.pageSize + index];
        let response = await AccountService.deleteUser(item.account_id);
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
      if(this.userName === "") {
        this.$toast.text("姓名不能为空");
        return;
      }
      if(this.userEmail === "") {
        this.$toast.text("邮箱不能为空");
        return;
      }
      if(!(this.userEmail.includes(".com") && this.userEmail.includes("@"))) {
        this.$toast.text("邮箱格式错误");
        return;
      }
      if(this.userPhone === "") {
        this.$toast.text("电话不能为空");
        return;
      }
      if(!this.isPoneAvailable(this.userPhone)) {
        this.$toast.text("电话不正确");
        return;
      }
      let item = this.userList[(this.currentPage-1) * this.pageSize + index];
      item.name = this.userName;
      item.email = this.userEmail;
      item.phone = this.userPhone;
      item.privilege = this.userPrivilege;
      let response = await AccountService.modifyUser(item);
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
.user_manage {
  margin: 0.5rem;
  font-size: 0.2rem;
  display: flex;
  flex-direction: column;

  .search_amount {
    margin: 0 0.3rem;
    font-size: 0.2rem;
  }

  .user_manage_container {
    margin: 0.2rem;

    .filter_container {
      display: flex;
      justify-content: space-between;
      align-items: center;
      .account_id {
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
      .name {
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
      .email {
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
      .phone {
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
      .privilege {
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
      width: 16.5%;
      text-align: center;
    }
  }
  
  .body {
    margin: 0.2rem 0;
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    .user_container {
      padding: 0.1rem 0;
      width: 100%;
      display: flex;
      align-items: center;
      .user_info {
        width: 16.5%;
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
        .delete {
          margin-left: 0.1rem;
        }
        .cancle {
          margin-left: 0.1rem;
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
