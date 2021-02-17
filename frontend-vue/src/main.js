import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import router from './router'
import moment from 'moment'

require("./assets/main.css")

Vue.config.productionTip = false
Vue.prototype.$http = axios
Vue.prototype.moment = moment

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
