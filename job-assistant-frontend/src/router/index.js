import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import LoginView from '../views/auth/LoginView.vue'
import HomeAdminView from '../views/admin/HomeAdminView.vue'
import HomeJobSeekerView from '../views/jobseeker/HomeJobSeekerView.vue'

Vue.use(VueRouter)

const routes = [
  {
    component: LoginView,
    name: "LoginView",
    path: "/login",
  },
  // popraviti ovo da bude ista ruta, samo da zavisi od role
  {
    component: HomeAdminView,
    name: "HomeAdminView",
    path: "/home-admin",
  },
  {
    component: HomeJobSeekerView,
    name: "HomeJobSeekerView",
    path: "/home-jobseeker",
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
