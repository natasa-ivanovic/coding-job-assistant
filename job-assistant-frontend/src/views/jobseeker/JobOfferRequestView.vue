<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card class="mt-5">
          <v-card-title class="description ml-3" style="font-size:40px">
            <v-col>
              Job offers
            </v-col>
            <v-col>
              <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="Search"
                single-line
                hide-details
              ></v-text-field>
            </v-col>
          </v-card-title>
          <v-row class="ml-9 mr-9">
            <v-progress-linear
              indeterminate
              color="indigo accent-1"
              :active="show"
            ></v-progress-linear>
          </v-row>
          <v-card-text v-if="lastDate">
            <v-row>
              <v-alert
                icon="mdi-calendar"
                outlined
                color="black"
                dense
                class="ml-5 mr-5"
                style="width: 100%;"
              >
                Here are your suggestions from date:
                {{ new Date(lastDate).toDateString() }}.
              </v-alert>
            </v-row>
          </v-card-text>
          <v-row class="ml-7">
            <v-btn
              color="indigo accent-1"
              class="mx-2"
              @click="requestSuggestions()"
              :disabled="show"
              >Request recommendations</v-btn
            >
          </v-row>
          <v-card-text>
            <v-row v-if="alert">
              <v-col cols="12">
                <v-alert type="info" color="indigo accent-3" class="ml-2 mr-3">
                  No job offer recommendations in recent memory! Please request
                  a new set of recommendations.
                </v-alert>
              </v-col>
            </v-row>
            <v-row v-else>
              <v-col
                style="flex: 1;"
                sm="12"
                md="6"
                lg="4"
                v-for="jo in jobOffers"
                :key="jo.id"
              >
                <job-offer-suggestion-card v-bind:jobOfferRating="jo" />
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import JobOfferSuggestionCard from "../../components/job-offers/JobOfferSuggestionCard.vue";

const apiURL = "/api/job-offer-suggestion";

export default {
  components: {
    JobOfferSuggestionCard,
  },
  name: "JobOfferRequestView",
  data() {
    return {
      search: "",
      jobOffers: [],
      alert: false,
      lastDate: null,
      show: false,
    };
  },
  mounted() {
    this.show = true;
    this.axios
      .get(apiURL)
      .then((response) => {
        this.alert = false;
        console.log(response.data);
        this.jobOffers = response.data.offerRatings;
        this.lastDate = response.data.date;
        this.show = false;
      })
      .catch((error) => {
        this.show = false;
        this.alert = true;
        console.log(error);
      });
  },
  methods: {
    requestSuggestions() {
      this.show = true;
      this.axios
        .get(apiURL + "/request")
        .then((response) => {
          this.alert = false;
          this.jobOffers = response.data.offerRatings;
          this.lastDate = response.data.date;
          this.show = false;
        })
        .catch((error) => {
          this.show = false;
          this.$root.snackbar.error(error.response.data.message);
        });
    },
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
