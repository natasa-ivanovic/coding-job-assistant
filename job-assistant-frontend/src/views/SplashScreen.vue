<template>
  <v-container
    v-if="loading"
    class="main-screen"
    fluid
    fill-height
    style="justify-content: center;"
  >
    <div>
      <v-row>
        <v-progress-circular
          :rotate="180"
          :size="200"
          :width="20"
          :value="value"
          color="pink"
        >
          <v-icon size="100">mdi-magnify</v-icon>
        </v-progress-circular>
      </v-row>
    </div>
  </v-container>
  <v-container
    v-else
    class="main-screen"
    fluid
    fill-height
    style="justify-content: center;"
  >
    <v-card width="1700px" height="850px" :elevation="24">
      <v-card-title
        class="description mt-3 justify-center"
        style="font-size:60px"
        >POSO</v-card-title
      >
      <v-card-title
        class="description mt-0 mb-0 pb-0 justify-center "
        style="font-size:30px"
        >Professional Offer Search Organization</v-card-title
      >
      <v-row class="mt-0 pt-0">
        <v-col
          style="flex: 1;"
          sm="11"
          md="5"
          lg="3"
          v-for="i in info"
          :key="i.id"
        >
          <splash-screen-card v-bind:info="i" />
        </v-col>
      </v-row>
      <v-row align="center" justify="center" class="mt-0 pt-0">
        <v-btn
          class="description main-screen"
          style="font-size: 15px; width: 280px"
          @click="register()"
          ><b>Get started</b></v-btn
        >
      </v-row>
      <v-row align="center" justify="center">
        <router-link :to="{ name: 'LoginView' }" style="text-decoration: none"
          ><p class="description" style="font-size: 20px">
            Already have an account? Sign in
          </p></router-link
        >
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
import SplashScreenCard from "../components/splash-screen/SplashScreenCard.vue";

export default {
  name: "WelcomeScreen",
  components: {
    SplashScreenCard,
  },
  data() {
    return {
      interval: {},
      value: 0,
      loading: true,
      info: [
        {
          id: 1,
          title: "Moze da popuni svoj cv",
          subtitle: "Neki kratak opis naslova",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis in libero ac nulla auctor mollis id id felis. Pellentesque rutrum quis velit eget elementum.",
          highlight: "Nesto jako kul",
          image: require("@/assets/resume1.jpg"),
          step: 1,
        },
        {
          id: 2,
          title: "Moze da odredi job position",
          subtitle: "Neki kratak opis naslova",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis in libero ac nulla auctor mollis id id felis. Pellentesque rutrum quis velit eget elementum.",
          highlight: "Nesto jako kul",
          image: require("@/assets/job-position.jpg"),
          step: 2,
        },
        {
          id: 3,
          title: "Moze da odredi job offer",
          subtitle: "Neki kratak opis naslova",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis in libero ac nulla auctor mollis id id felis. Pellentesque rutrum quis velit eget elementum.",
          highlight: "Nesto jako kul",
          image: require("@/assets/job-offer.jpg"),
          step: 3,
        },
        {
          id: 4,
          title: "Moze da uci u ucionici",
          subtitle: "Neki kratak opis naslova",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis in libero ac nulla auctor mollis id id felis. Pellentesque rutrum quis velit eget elementum.",
          highlight: "Nesto jako kul",
          image: require("@/assets/classroom.jpg"),
          step: 4,
        },
      ],
    };
  },
  beforeDestroy() {
    clearInterval(this.interval);
  },
  mounted() {
    this.interval = setInterval(() => {
      if (this.value === 100) {
        this.loading = false;
        return (this.value = 0);
      }
      this.value += 20;
    }, 1000);
  },
  methods: {
    register() {
      this.$router.push({ name: "RegisterView" });
    },
  },
};
</script>

<style scoped>
.main-screen {
  background: rgb(238, 174, 209);
  background: radial-gradient(
    circle,
    rgba(238, 174, 209, 1) 14%,
    rgba(148, 187, 233, 1) 93%
  );
}
.v-progress-circular {
  margin: 1rem;
}

.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
