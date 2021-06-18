import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/auth/LoginView.vue'
import RegisterView from '../views/auth/RegisterView.vue'
import HomeAdminView from '../views/admin/HomeAdminView.vue'
import HomeJobSeekerView from '../views/jobseeker/HomeJobSeekerView.vue'
import AccountView from '../views/jobseeker/AccountView.vue'
import JobPositionRequestView from '../views/jobseeker/JobPositionRequestView.vue'
import JobOfferRequestView from '../views/jobseeker/JobOfferRequestView.vue'
import JobOfferStatisticView from '../views/jobseeker/JobOfferStatisticView.vue'

Vue.use(VueRouter)

const routes = [
  {
    component: LoginView,
    name: "LoginView",
    path: "/login",
  },
  {
    component: RegisterView,
    name: "RegisterView",
    path: "/register",
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
      {
        component: AccountView,
        name: "AccountView",
        path: "/account",
        beforeEnter: guardRouteJobSeeker
      },
      {
        component: JobPositionRequestView,
        name: "JobPositionRequestView",
        path: "/job-position-request",
        beforeEnter: guardRouteJobSeeker
      },
      {
        component: JobOfferRequestView,
        name: "JobOfferRequestView",
        path: "/job-offer-request",
        beforeEnter: guardRouteJobSeeker
      },
      {
        component: JobOfferStatisticView,
        name: "JobOfferStatisticView",
        path: "/statistic/:id",
        props: true,
        beforeEnter: guardRouteJobSeeker
      }
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
