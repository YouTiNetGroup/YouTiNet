import Vue from 'vue';

export default {
  lockBodyScroll: function () {
    document.body.style.overflow = "hidden";
  },

  resetBodyScroll: function () {
    document.body.style.overflow = 'auto';
  },

  onBodyScroll: function (action) {
    window.addEventListener("scroll", action);
  },

  unBindScroll: function (action) {
    window.removeEventListener("scroll", action);
  },

  onWindowResize: function (listener) {
    window.addEventListener('resize', listener);
  },

  unBindResize: function (listener) {
    window.removeEventListener('resize', listener);
  },

  getScrollTop: function () {
    return document.documentElement.scrollTop || document.body.scrollTop;
  },

  setScrollTop: function (scrollTop) {
    document.body.scrollTop = scrollTop;
    document.documentElement.scrollTop = scrollTop;
  },
  getComputedStyle: !Vue.prototype.$isServer && document.defaultView.getComputedStyle.bind(document.defaultView)
};