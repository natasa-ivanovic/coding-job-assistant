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
          indeterminate
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
    <v-card width="1700px" :elevation="24">
      <v-card-title
        class="description mt-3 justify-center"
        style="font-size:60px"
        >IT Career Adviser</v-card-title
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
          md="6"
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
          title: "Fill in your resume",
          subtitle: "Enter your skills and work experience",
          description:
            "First things first - enter your previous working experiences and fill in your resume! The more accurate you are about your knowledge, the better your matches will be!",
          image: require("@/assets/resume1.jpg"),
          step: 1,
        },
        {
          id: 2,
          title: "Find your dream job position",
          subtitle: "Start out in an adequate field",
          description:
            "Starting out can be tough - but it doesn't have to be! Our system will match your technical skills and knowledge with the best positions so you start out your career right!",
          image: require("@/assets/job-position.jpg"),
          step: 2,
        },
        {
          id: 3,
          title: "Find your dream job offer",
          subtitle: "Join a place where you belong",
          description:
            "We believe that there's a pair for everyone. That's why our system will find the most fitting job offers for the job positions you are best suited for, to make sure you feel at home!",
          image: require("@/assets/job-offer.jpg"),
          step: 3,
        },
        {
          id: 4,
          title: "Hone in your skills",
          subtitle: "We are all constantly learning",
          description:
            "In case there's a job offer you aren't quite ready for yet, our system will offer you help. This way you can get all the required resources to improve your knowledge and get your dream job!",
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
        this.value = 0;
        clearInterval(this.interval);
      }
      this.value += 10;
    }, 50);
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
