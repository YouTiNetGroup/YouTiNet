<template>
  <svg :class="svgClass" aria-hidden="true">
    <use :xlink:href="iconName" />
  </svg>
</template>

<script>
export default {
  name: "SvgIcon",
  props: {
    iconClass: {
      type: String,
      required: true
    },
    className: {
      type: String,
      default: null,
      required: false
    }
  },
  computed: {
    iconName() {
      return `#${this.iconClass}`;
    },
    svgClass() {
      if (this.className) {
        return "svg_icon " + this.className;
      } else {
        return "svg_icon";
      }
    }
  }
};
</script>

<style scoped>
.svg_icon {
  width: 1em;
  height: 1em;
  fill: currentColor;
  overflow: hidden;
}
</style>
