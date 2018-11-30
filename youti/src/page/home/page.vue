<template>
	<div class="page">
		<v-head class="page_head"></v-head>
		<div class="page_body">
			<transition name="fade" mode="out-in"><router-view :key="$route.path"></router-view></transition>
		</div>
	</div>
</template>

<script type="text/javascript">
import vHead from "./head";
import { AccountService } from "src/service/account";

export default {
  data() {
    return {
    };
  },
  components: {
    vHead
	},
	
	destroyed() {
    AccountService.logout();
  }
};
</script>

<style lang="scss" scoped>
.page {
	width: 100%;
	height: 100%;
	padding-top: 0.8rem;

	.page_head {
		z-index: 1000;
		position: fixed;
		top: 0;
		width: 100%;
		height: 0.8rem;
		background-color: #3d444c;
		border-bottom: 1px solid #cac8c8;
		color: #ffffff;
		display: flex;
		align-items: center;
	}

	.page_body {
		width: 100%;
		height: 100%;
	}
}
</style>
