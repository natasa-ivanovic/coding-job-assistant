<template>
  <v-card
    elevation="8"
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      height="250"
      src="@/assets/job-offer.jpg"
    ></v-img>
    <v-card-title>{{ jobOfferRating.position }}</v-card-title>
    <v-card-subtitle style="font-size: 15px">{{
      jobOfferRating.company
    }}</v-card-subtitle>

    <!-- <v-card-text>
      <v-row align="center" class="mx-0">
        <v-rating
          :value="jobOffer.offerRating"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ms-4">{{ getRatingText() }}</div>
      </v-row>
    </v-card-text> -->
    <div class="mt-2 ml-4 mr-4" style="text-align: justify">
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rutrum
      mi non dolor congue congue. Donec vestibulum nisi lectus.
    </div>
    <v-divider class="mx-4 mt-4 mb-4"></v-divider>
    <v-card-text>
      <v-row>
        <v-alert
          dense
          :icon="getIconForCategory(jobOfferRating.category)"
          :color="getColorForCategory(jobOfferRating.category)"
          style="width: 100%"
          class="ml-2 mr-2"
        >
          {{ jobOfferRating.category.split("_").join(" ") }}
        </v-alert>
      </v-row>
    </v-card-text>
    <div class="ml-4 mr-4" style="text-align: justify">
      <b>{{ statusDescription(jobOfferRating.category) }}</b>
    </div>
    <v-card-actions>
      <v-dialog
        v-model="dialog"
        width="900px"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="#1A237E" text v-bind="attrs"
          v-on="on"> Details </v-btn>
        </template>
        <job-offer-details-card 
          v-bind:programmingImportances="jobOfferRating.jobOffer.programmingImportances"
          v-bind:technologyImportances="jobOfferRating.jobOffer.technologyImportances"
          v-bind:knowledgeImportances="jobOfferRating.jobOffer.knowledgeImportances"
          v-bind:softSkillImportances="jobOfferRating.jobOffer.softSkillImportances"
          v-bind:languageImportances="jobOfferRating.jobOffer.languageImportances"/>
      </v-dialog>
      <v-spacer></v-spacer>
      <v-btn color="#1A237E" text @click="showStatistic()"> Evaluate </v-btn>
    </v-card-actions>
    <v-card-actions v-if="!jobOfferRating.following">
      <v-btn  block class="primary" @click="follow()"
        >Follow</v-btn
      >
    </v-card-actions>
    <v-card-actions v-else>
          <v-btn width="48%" class="primary" @click="unfollow()">Unfollow</v-btn>
          <v-spacer></v-spacer>
          <v-btn width="48%" class="purple white--text">Leaderboard</v-btn>
    </v-card-actions>
  </v-card>

</template>

<script>
import JobOfferDetailsCard from "@/components/job-offers/JobOfferDetailsCard.vue";
const apiURL = "/api/job-offer/";

export default {
  name: "JobOfferSuggestionCard",
  data: () => ({
    loading: false,
    position: "",
    dialog: false
  }),
  components: {
    JobOfferDetailsCard
  },
  props: {
    jobOfferRating: Object,
    // private Long id;
    // private String position;
    // private String company;
    // private int rating;
    // private String description;
    // private String category;
    // private Long jobOfferId;
  },
  methods: {
    view: () => {
      console.log(view);
    },
    statusDescription(category) {
      if (category == "HOT_COMPANY")
        return "This offer is recommended because it's company has great reviews and many highly rated job offers.";
      else if (category == "IMPROVEMENT_NEEDED")
        return "You have some of the required skills for this job, but you are lacking in profficiency.";
      else if (category == "LOW_COMPETITION")
        return "This job doesn't have a lot of followers, so your chances of getting this job are increased.";
      else if (category == "BEST_MATCH")
        return "You have a high chance of getting this job based on the level of your skills.";
    },
    getColorForCategory(category) {
      if (category == "HOT_COMPANY") return "orange lighten-3";
      else if (category == "IMPROVEMENT_NEEDED") return "red lighten-3";
      else if (category == "LOW_COMPETITION") return "blue lighten-3";
      else if (category == "BEST_MATCH") return "green lighten-3";
    },
    getIconForCategory(category) {
      if (category == "HOT_COMPANY") return "mdi-fire";
      else if (category == "IMPROVEMENT_NEEDED") return "mdi-alert";
      else if (category == "LOW_COMPETITION") return "mdi-flag-checkered";
      else if (category == "BEST_MATCH") return "mdi-check";
    },
    // getRatingText() {
    //   if (this.jobOffer.offerRating >= 4.0) {
    //     return "Great reviews!";
    //   } else if (this.jobOffer.offerRating >= 3) {
    //     return "Average reviews!";
    //   } else if (this.jobOffer.offerRating != 0) {
    //     return "Bad reviews!";
    //   } else {
    //     return "No reviews so far!";
    //   }
    // },
    showStatistic() {
      this.$router.push({
        name: "JobOfferStatisticView",
        params: { id: this.jobOfferRating["jobOfferId"] },
      });
    },
    follow() {
      this.axios
        .post(apiURL + "follow/" + this.jobOffer.id)
        .then((response) => {
          this.jobOfferRating.ranking =  response.data;
          this.jobOfferRating.following = true;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    unfollow() {
      this.axios
        .post(apiURL + "unfollow/" + this.jobOfferRating.id)
        .then(() => {
          this.jobOfferRating.following = false;
        })
        .catch((error) => {
          console.log(error);
        })
    }
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
