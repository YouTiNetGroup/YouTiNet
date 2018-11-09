import objectAssign from 'object-assign'
import ToastComponent from './toast.vue'
import { mergeOptions } from '../plugin_helper'

let $vm
let watcher

const Toast = {}

Toast.install = function (vue, pluginOptions = {}) {
  const Toast = vue.extend(ToastComponent)

  if (!$vm) {
    $vm = new Toast({
      el: document.createElement('div')
    })
    document.body.appendChild($vm.$el)
  }

  const defaults = {}
  for (let i in $vm.$options.props) {
    if (i !== 'value') {
      defaults[i] = $vm.$options.props[i].default
    }
  }

  vue.prototype.$toast = {
    show(options = {}) {
      // destroy watcher
      watcher && watcher()
      if (typeof options === 'string') {
        mergeOptions($vm, objectAssign({}, pluginOptions, { text: options }))
      } else if (typeof options === 'object') {
        mergeOptions($vm, objectAssign({}, pluginOptions, options))
      }
      if (typeof options === 'object' && options.onShow || options.onHide) {
        watcher = $vm.$watch('show', (val) => {
          val && options.onShow && options.onShow($vm)
          val === false && options.onHide && options.onHide($vm)
        })
      }
      $vm.show = true
    },
    text(text, position = 'middle') {
      this.show({
        type: 'text',
        width: 'auto',
        position,
        text
      })
    },
    hide() {
      $vm.show = false
    },
    isVisible() {
      return $vm.show
    }
  }
}
export default Toast