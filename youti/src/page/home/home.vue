<template>
  <div class="home">
    <div class="head"></div>
    <div class="navigation"></div>
    <div class="body"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
    };
  },

  methods: {
  }
};
</script>

<style lang="scss" scoped>
.home {
  width: 100%;
  height: 100%;

  .head {
    z-index: 100;
    position: absolute;
    top: 0;
    width: 100%;
    height: 0.9rem;
    background-image: url("../../assets/images/background.jpg");
    background-size: 100% 1000%;
  }

  .navigation {
    position: absolute;
    left: 0;
    margin-top: 0.9rem;
    width: 2rem;
    height: 100%;
    background-color: #00bde5
  }

  .body {
    width: 100%;
    height: 100%;
    background-color: #f7f9fd;
  }
}
</style>
