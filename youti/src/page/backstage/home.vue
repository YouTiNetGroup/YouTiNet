<template>
	<div class="home">
    <div class="container">
      <div class="head">欢迎光临
        <div class="title">优题网</div>  
      后台管理系统！
      </div>
      <div class="body">在这里，您可以进行用户管理、试卷管理、题库管理，对用户、试卷、题库进行查询、修改、删除操作</div>
      <div class="foot">*后台管理系统仅供管理员使用</div>
    </div>
	</div>
</template>

<script type="text/javascript">

export default {
  data() {
    return {};
  },
  components: {
  }
};
</script>

<style lang="scss" scoped>
.home {
  .container {
    margin: 1rem 1rem 0 1rem;
    padding: 0.5rem 0.5rem 0 0.5rem;
    display: flex;
    flex-direction: column;
    align-items: center;
    .head {
      font-size: 0.5rem;
      display: flex;
      .title {
        color: #4ab2e2;
      }
    }
    .body {
      margin: 1rem;
      font-size: 0.3rem;
    }
    .foot {
      margin-top: 0.9rem;
      font-size: 0.25rem;
      color: #888;
    }
  }
}
</style>
