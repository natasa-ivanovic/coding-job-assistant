import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import LoginView from "../views/auth/LoginView.vue";
import RegisterView from "../views/auth/RegisterView.vue";
import ResetPasswordView from "../views/auth/ResetPasswordView.vue";

import HomeAdminView from "../views/admin/HomeAdminView.vue";
import CompanyReviewListView from "../views/admin/CompanyReviewListView.vue";
import CVElementListView from "../views/admin/CVElementListView.vue";
import JobPositionAdminListView from "../views/admin/JobPositionListView.vue";
import CompanyAdminListView from "../views/admin/CompanyListView.vue";

import HomeJobSeekerView from "../views/jobseeker/HomeJobSeekerView.vue";
import AccountView from "../views/jobseeker/AccountView.vue";
import ResumeView from "../views/jobseeker/ResumeView.vue";
import JobPositionRequestView from "../views/jobseeker/JobPositionRequestView.vue";
import JobOfferRequestView from "../views/jobseeker/JobOfferRequestView.vue";
import JobOfferStatisticView from "../views/jobseeker/JobOfferStatisticView.vue";
import JobPositionListView from "../views/jobseeker/JobPositionListView.vue";
import JobOfferListView from "../views/jobseeker/JobOfferListView.vue";
import ClassroomView from "../views/classroom/ClassroomView.vue";
import CompanyListView from "../views/jobseeker/CompanyListView.vue";
import SplashScreen from "../views/SplashScreen.vue";

Vue.use(VueRouter);

const routes = [
  {
    component: SplashScreen,
    name: "SplashScreen",
    path: "/",
  },
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
    component: ResetPasswordView,
    name: "ResetPasswordView",
    path: "/reset-password/:key",
    props: true,
  },
  {
    component: HomeView,
    path: "/",
    beforeEnter: guardRouteLoggedIn,
    children: [
      // admin routes
      {
        component: HomeAdminView,
        name: "HomeAdminView",
        path: "/admin/home",
        beforeEnter: guardRouteAdmin,
      },
      {
        component: CompanyReviewListView,
        name: "CompanyReviewListView",
        path: "/admin/company-reviews",
        beforeEnter: guardRouteAdmin,
      },
      {
        component: CVElementListView,
        name: "CVElementListView",
        path: "/admin/cv-elements",
        beforeEnter: guardRouteAdmin,
      },
      {
        component: JobPositionAdminListView,
        name: "JobPositionAdminListView",
        path: "/admin/job-positions",
        beforeEnter: guardRouteAdmin,
      },
      {
        component: CompanyAdminListView,
        name: "CompanyAdminListView",
        path: "/admin/companies",
        beforeEnter: guardRouteAdmin,
      },
      // jobseeker routes
      {
        component: HomeJobSeekerView,
        name: "HomeJobSeekerView",
        path: "/home",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: AccountView,
        name: "AccountView",
        path: "/account",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: ResumeView,
        name: "ResumeView",
        path: "/resume",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: JobPositionRequestView,
        name: "JobPositionRequestView",
        path: "/job-position-requests",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: JobOfferRequestView,
        name: "JobOfferRequestView",
        path: "/job-offer-requests",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: JobPositionListView,
        name: "JobPositionListView",
        path: "/job-positions",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: JobOfferListView,
        name: "JobOfferListView",
        path: "/job-offers",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: JobOfferStatisticView,
        name: "JobOfferStatisticView",
        path: "/statistic/:id",
        props: true,
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: ClassroomView,
        name: "ClassroomView",
        path: "/classroom",
        beforeEnter: guardRouteJobSeeker,
      },
      {
        component: CompanyListView,
        name: "CompanyListView",
        path: "/companies",
        beforeEnter: guardRouteJobSeeker,
      },
    ],
  },
  {
    name: "Page404",
    path: "/*",
    beforeEnter: guardNotFound,
  },
];

function guardRouteLoggedIn(to, from, next) {
  let user = JSON.parse(localStorage.getItem("user"));
  if (!user || user["token"] === undefined) next("/login");
  else next(); // allow to enter the route
}

function guardRouteAdmin(to, from, next) {
  let user = JSON.parse(localStorage.getItem("user"));
  if (user["role"] === "ADMIN") next();
}

function guardRouteJobSeeker(to, from, next) {
  let user = JSON.parse(localStorage.getItem("user"));
  if (user["role"] === "USER") next();
}

function guardNotFound(to, from, next) {
  let user = JSON.parse(localStorage.getItem("user"));
  if (!user || user["token"] === undefined) next("/");
  else {
    if (user["role"] === "USER") next({ name: "HomeJobSeekerView" });
    else next({ name: "HomeAdminView" });
  }
}

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
