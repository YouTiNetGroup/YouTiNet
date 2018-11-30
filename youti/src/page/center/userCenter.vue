<template>
    <div class="usercenter">
        <div class="breadcrumb">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>个人中心</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="content">
            <el-row :gutter="20">
                <el-col :span="4">
                    <el-menu active-text-color="#d23b3b"
                             :default-active="$route.path"
                             router>
                        <div class="menu_box">
                            <el-menu-item-group>
                                <template slot="title">个人中心</template>
                                <el-menu-item index="/page/userCenter/myTestPaper">我的试卷</el-menu-item>
                                <el-menu-item index="/page/userCenter/userInfo">个人信息</el-menu-item>
                                <el-menu-item index="/page/userCenter/editPwd">修改密码</el-menu-item>
                                <el-menu-item index="/page/userCenter/editInfo">修改信息</el-menu-item>
                            </el-menu-item-group>
                        </div>
                    </el-menu>
                </el-col>
                <el-col :span="20">
                    <transition name="fade" mode="out-in"><router-view></router-view></transition>
                </el-col>
            </el-row>
        </div>

    </div>
</template>

<script>
export default {
  data() {
    return {
    };
  },
};
</script>

<style lang="scss" scoped>
.usercenter {
  padding: 0.2rem 2.5rem;
  .breadcrumb {
    padding: 0.2rem;
    border-bottom: 1px solid #dddddd;
  }
  .content {
    margin-top: 0.3rem;
    .menu_box {
      margin-top: 0.2rem;
    }
  }
}
</style>
