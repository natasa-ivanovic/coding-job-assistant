import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
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
  {
    component: HomeView,
    path: "/",
    beforeEnter: guardRouteLoggedIn,
    children: [
      {
        component: HomeAdminView,
        name: "HomeAdminView",
        path: "/home",
        beforeEnter: guardRouteAdmin
      },
      {
        component: HomeJobSeekerView,
        name: "HomeJobSeekerView",
        path: "/home",
        beforeEnter: guardRouteJobSeeker
      },
    ]
  }

]


function guardRouteLoggedIn(to, from, next) {
  let user = JSON.parse(localStorage.getItem("user"));
  if (!user || user["token"] === undefined) next("/login");
  else next(); // allow to enter the route
}

function guardRouteAdmin(to, from, next) {
    let user = JSON.parse(localStorage.getItem('user'));
    if(user['role'] === 'ADMIN')
        next();
}

function guardRouteJobSeeker(to, from, next) {
    let user = JSON.parse(localStorage.getItem('user'));
    if(user['role'] === 'USER')
        next();
}


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
