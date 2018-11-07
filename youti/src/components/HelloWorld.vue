<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <form>
      <input type="file" @change="getFile($event)">
      <button class="button button-primary button-pill button-small" @click="submit($event)">提交</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "HelloWorld",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      file: ""
    };
  },
  mounted() {
    this.$toast.text("欢迎登陆优题网！");
  },
  methods: {
    getFile: function(event) {
      this.file = event.target.files[0];
      console.log(this.file);
    },
    submit: function(event) {
      //组织元素发生默认的行为
      event.preventDefault();
      let formData = new FormData();
      formData.append("file", this.file);
      axios
        .post("http://localhost:8082/upload/singlefile", formData)
        .then(function(response) {
          alert(response.data);
          console.log(response);
          window.location.reload();
        })
        .catch(function(error) {
          alert("上传失败");
          console.log(error);
          window.location.reload();
        });
    }
  }
};
</script>

<style>
.hello {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

h1,
h2 {
  font-weight: normal;
}

.button-pill {
  border-radius: 200px;
}

.button-primary,
.button-primary-flat {
  background-color: #1b9af7;
  border-color: #1b9af7;
  color: #fff;
}

.button {
  color: #fff;
  background-color: #1b9af7;
  border-color: #eee;
  font-size: 16px;
  font-family: "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial,
    "Lucida Grande", sans-serif;
  text-decoration: none;
  text-align: center;
  line-height: 40px;
  height: 40px;
  padding: 0 40px;
  margin: 0;
  display: inline-block;
  appearance: none;
  cursor: pointer;
  border: none;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition-property: all;
  transition-property: all;
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
}

.button-small {
  font-size: 12px;
  height: 30px;
  line-height: 30px;
  padding: 0 30px;
}
</style>
