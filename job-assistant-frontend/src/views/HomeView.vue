<template>
  <v-app>
    <v-navigation-drawer v-model="drawer" app>
      <navigation-bar></navigation-bar>
    </v-navigation-drawer>

    <v-app-bar app color="indigo accent-1">
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title class="description" style="font-size:25px">IT Career Adviser</v-toolbar-title>
      <v-spacer />
      <v-btn class="ml-3" icon @click="logout()"
        ><v-icon>mdi-logout</v-icon></v-btn
      >
    </v-app-bar>
    <v-main class="blue-grey lighten-5">
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
import NavigationBar from "../components/nav/NavigationBar.vue";

export default {
  name: "HomeView",
  components: {
    NavigationBar,
  },
  data: () => ({ drawer: true }),
  methods: {
    logout() {
      localStorage.clear();
      this.$router.push({ name: "LoginView" })
    }
  }
};
</script>

<style scoped>
.container {
  height: 100% !important;
}

.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
