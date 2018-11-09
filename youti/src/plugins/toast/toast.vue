<template>
  <div class="vux-toast">
    <div v-show="isShowMask && show" class="weui-mask_transparent" />
    <transition :name="currentTransition">
      <div v-show="show" class="weui-toast" :style="{width: width}" :class="toastClass">
        <i v-show="type !== 'text'" class="weui-icon-success-no-circle weui-icon_toast" />
        <p v-if="text" class="weui-toast__content" :style="style" v-html="text" />
        <p v-else class="weui-toast__content" :style="style">
          <slot />
        </p>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: "Toast",
  props: {
    value: {
      type: Boolean,
      default: false
    },
    time: {
      type: Number,
      default: 2000
    },
    type: {
      type: String,
      default: "success"
    },
    transition: {
      type: String,
      default: null
    },
    width: {
      type: String,
      default: "4.5em"
    },
    isShowMask: {
      type: Boolean,
      default: false
    },
    text: {
      type: String,
      default: null
    },
    position: {
      type: String,
      default: 'middle'
    }
  },
  data() {
    return {
      show: false
    };
  },
  computed: {
    currentTransition() {
      if (this.transition) {
        return this.transition;
      }
      if (this.position === "top") {
        return "vux-slide-from-top";
      }
      if (this.position === "bottom") {
        return "vux-slide-from-bottom";
      }
      return "vux-fade";
    },
    toastClass() {
      return {
        "weui-toast_forbidden": this.type === "warn",
        "weui-toast_cancel": this.type === "cancel",
        "weui-toast_success": this.type === "success",
        "weui-toast_text": this.type === "text",
        "vux-toast-top": this.position === "top",
        "vux-toast-bottom": this.position === "bottom",
        "vux-toast-middle": this.position === "middle"
      };
    },
    style() {
      if (this.type === "text" && this.width === "auto") {
        return { padding: "0.2rem" };
      }
    }
  },
  watch: {
    show(val) {
      if (val) {
        this.$emit("input", true);
        this.$emit("on-show");
        clearTimeout(this.timeout);
        this.timeout = setTimeout(() => {
          this.show = false;
          this.$emit("input", false);
          this.$emit("on-hide");
        }, this.time);
      }
    },
    value(val) {
      this.show = val;
    }
  },
  created() {
    if (this.value) {
      this.show = true;
    }
  }
};
</script>

<style lang="scss" scoped>
.weui-mask {
  position: fixed;
  z-index: 1000;
  top: 0;
  right: 0;
  left: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.6);
}
.weui-mask_transparent {
  position: fixed;
  z-index: 1000;
  top: 0;
  right: 0;
  left: 0;
  bottom: 0;
}

[class^="weui-icon-"],
[class*=" weui-icon-"] {
  display: inline-block;
  vertical-align: middle;
  font: normal normal normal 0.63rem/1 "weui";
  font-size: 0.5rem;
  text-rendering: auto;
  -webkit-font-smoothing: antialiased;
  &:before {
    // 平滑升级
    display: inline-block;
    margin-left: 0.2em;
    margin-right: 0.2em;
  }
}
.weui-icon-circle:before {
  content: "\EA01";
}
.weui-icon-download:before {
  content: "\EA02";
}
.weui-icon-info:before {
  content: "\EA03";
}
.weui-icon-safe-success:before {
  content: "\EA04";
}
.weui-icon-safe-warn:before {
  content: "\EA05";
}
.weui-icon-success:before {
  content: "\EA06";
}
.weui-icon-success-circle:before {
  content: "\EA07";
}
.weui-icon-success-no-circle:before {
  content: "\EA08";
}
.weui-icon-waiting:before {
  content: "\EA09";
}
.weui-icon-waiting-circle:before {
  content: "\EA0A";
}
.weui-icon-warn:before {
  content: "\EA0B";
}
.weui-icon-info-circle:before {
  content: "\EA0C";
}
.weui-icon-cancel:before {
  content: "\EA0D";
}
.weui-icon-search:before {
  content: "\EA0E";
}
.weui-icon-clear:before {
  content: "\EA0F";
}
.weui-icon-back:before {
  content: "\EA10";
}
.weui-icon-delete:before {
  content: "\EA11";
}

[class^="weui-icon_"]:before,
[class*=" weui-icon_"]:before {
  margin: 0;
}
.weui-icon-success {
  font-size: 1rem;
  color: #09bb07;
}
.weui-icon-waiting {
  font-size: 1rem;
  color: #10aeff;
}
.weui-icon-warn {
  font-size: 1rem;
  color: #f43530;
}
.weui-icon-info {
  font-size: 1rem;
  color: #10aeff;
}
.weui-icon-success-circle {
  font-size: 1rem;
  color: #09bb07;
}
.weui-icon-success-no-circle {
  font-size: 1rem;
  color: #09bb07;
}
.weui-icon-waiting-circle {
  font-size: 1rem;
  color: #10aeff;
}
.weui-icon-circle {
  font-size: 1rem;
  color: #c9c9c9;
}
.weui-icon-download {
  font-size: 1rem;
  color: #09bb07;
}
.weui-icon-info-circle {
  font-size: 1rem;
  color: #09bb07;
}
.weui-icon-safe-success {
  color: #09bb07;
}
.weui-icon-safe-warn {
  color: #ffbe00;
}
.weui-icon-cancel {
  font-size: 1rem;
  color: #f43530;
}
.weui-icon-search {
  font-size: 1rem;
  color: #b2b2b2;
}
.weui-icon-clear {
  font-size: 1rem;
  color: #b2b2b2;
}
.weui-icon-delete {
  &.weui-icon_gallery-delete {
    font-size: 1rem;
    color: #ffffff;
  }
}
.weui-icon_msg {
  font-size: 4.2rem;
  &.weui-icon-warn {
    color: #f76260;
  }
}
.weui-icon_msg-primary {
  font-size: 4.2rem;
  &.weui-icon-warn {
    color: #ffbe00;
  }
}

.weui-toast {
  position: fixed;
  z-index: 5001;
  width: 4.5em;
  min-height: 4.5em;
  top: 4rem;
  left: 50%;
  margin-left: -3.8em;
  background: rgba(17, 17, 17, 0.7);
  text-align: center;
  border-radius: 0.225rem;
  color: #ffffff;
}
.weui-icon_toast {
  margin: 0.6rem 0 0;
  display: block;
  &.weui-icon-success-no-circle {
    &:before {
      color: #ffffff;
      font-size: 2rem;
    }
  }
  &.weui-loading {
    margin: 1.35px 0 0;
    width: 1.71rem;
    height: 1.71rem;
    vertical-align: baseline;
  }
}
.weui-toast__content {
  margin: 0 0 0.675rem;
}
.weui-toast.vux-toast-top {
  top: 0.45rem;
}
.weui-toast.vux-toast-bottom {
  top: auto;
  bottom: 0.45rem;
  transform: translateX(-50%);
}
.weui-toast.vux-toast-middle {
  top: 50%;
  transform: translateX(-50%) translateY(-50%);
}
.vux-slide-from-top-enter,
.vux-slide-from-top-leave-active {
  opacity: 0;
  transform: translateX(-50%) translateY(-100%) !important;
}
.vux-slide-from-bottom-enter,
.vux-slide-from-bottom-leave-active {
  opacity: 0;
  transform: translateX(-50%) translateY(100%) !important;
}
.vux-slide-from-top-enter-active,
.vux-slide-from-top-leave-active,
.vux-slide-from-bottom-enter-active,
.vux-slide-from-bottom-leave-active {
  transition: all 400ms cubic-bezier(0.36, 0.66, 0.04, 1);
}
.weui-toast {
  transform: translateX(-50%);
  margin-left: 0 !important;
}
.weui-toast.weui-toast_forbidden {
  color: #f76260;
}
.weui-toast.weui-toast_forbidden .weui-toast__content {
  margin-top: 0.45rem;
}
.weui-toast.weui-toast_text {
  min-height: 0;
}
.weui-toast_text .weui-toast__content {
  margin: 0;
  padding-top: 0.45rem;
  padding-bottom: 0.45rem;
  border-radius: 0.675rem;
}
.weui-toast__content {
  font-size: 0.3rem;
  color: #ffffff;
}
.weui-loading_toast .weui-toast__content {
  margin-top: 0;
}
.weui-toast_success .weui-icon_toast:before {
  content: "\EA08";
}
.weui-toast_cancel .weui-icon_toast:before {
  content: "\EA0D";
}
.weui-toast_forbidden .weui-icon_toast.weui-icon-success-no-circle:before {
  content: "\EA0B";
  color: #f76260;
}
</style>