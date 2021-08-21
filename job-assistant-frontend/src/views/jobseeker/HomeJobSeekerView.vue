<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <v-card elevation="0" class="blue-grey lighten-5">
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
        </v-card>
      </v-col>
    </v-row>
    <v-row v-if="offers.length" align="center" justify="center">
      <v-col cols="12">
        <v-card elevation="0" class="blue-grey lighten-5">
          <v-card-title class="justify-center description" style="font-size:40px"><b>Job offers that you're following</b></v-card-title>
          <v-row class="mt-0 pt-0">
            <v-col
              style="flex: 1;"
              sm="11"
              md="6"
              lg="3"
              v-for="o in offers"
              :key="o.id"
            >
              <job-offer-card v-bind:jobOffer="o" />
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SplashScreenCard from "@/components/splash-screen/SplashScreenCard.vue";
import JobOfferCard from "@/components/job-offers/JobOfferCard.vue";
const apiURL = "/api/job-offer/following"

export default {
  name: "HomeJobSeekerView",
  components: {
    SplashScreenCard,
    JobOfferCard
  },
  data() {
    return {
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
          link: "ResumeView"
        },
        {
          id: 2,
          title: "Find your dream job position",
          subtitle: "Start out in an adequate field",
          description:
            "Starting out can be tough - but it doesn't have to be! Our system will match your technical skills and knowledge with the best positions so you start out your career right!",
          image: require("@/assets/job-position.jpg"),
          step: 2,
          link: "JobPositionRequestView"
        },
        {
          id: 3,
          title: "Find your dream job offer",
          subtitle: "Join a place where you belong",
          description:
            "We believe that there's a pair for everyone. That's why our system will find the most fitting job offers for the job positions you are best suited for, to make sure you feel at home!",
          image: require("@/assets/job-offer.jpg"),
          step: 3,
          link: "JobOfferRequestView"
        },
        {
          id: 4,
          title: "Hone in your skills",
          subtitle: "We are all constantly learning",
          description:
            "In case there's a job offer you aren't quite ready for yet, our system will offer you help. This way you can get all the required resources to improve your knowledge and get your dream job!",
          image: require("@/assets/classroom.jpg"),
          step: 4,
          link: "ClassroomView"
        },
      ],
      offers: []
    };
  },
  mounted() {
    this.getOffers();
  },
  methods: {
    getOffers() {
      this.axios
        .get(apiURL)
        .then((response) => {
          this.offers = response.data;
        })
        .catch((error) => {
          console.log(error);
        })
    }
  }
};
</script>

<style scoped></style>
