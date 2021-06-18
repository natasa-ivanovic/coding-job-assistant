import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import VueAxios  from 'vue-axios'
import Axios from 'axios'

Vue.config.productionTip = false


const role = Vue.observable({ role: localStorage.getItem('role') })

Object.defineProperty(Vue.prototype, '$role', {
  get () {
    return role.role;
  },
  set (value) {
    role.role = value;
  }
})

Vue.mixin({
  data: function() {
    return {
      get user() {
        return "Can't change me!";
      }
    }
  }
})


// axios config
Vue.use(VueAxios, Axios);

// interceptor ako zatreba
Vue.axios.interceptors.response.use(undefined, function (error) {
  if (error) {
    const originalRequest = error.config;
    if (error.response.status === 401 && !originalRequest._retry) {
        originalRequest._retry = true;
        localStorage.clear();
        return router.push('/login');
    }
    return Promise.reject(error);
  }
})

if (localStorage.getItem('authKey') != null) {
  Vue.axios.defaults.headers['Authorization'] = localStorage.getItem('authKey');
}

Vue.axios.defaults.baseURL = 'http://localhost:9006/';


new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
