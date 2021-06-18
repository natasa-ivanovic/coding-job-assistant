<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card class="mt-5">
          <v-card-title>
            <v-col class="description" style="font-size:40px">
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
          <v-card-text v-if="lastDate">
            <v-row>
              <v-alert icon="mdi-calendar" outlined  color="#546E7A" dense class="ml-6 mr-6" style="width: 100%;">
                Here are your suggestions from date: {{new Date(lastDate).toDateString()}}.
              </v-alert>
            </v-row>
          </v-card-text>
          <v-row  class="ml-5">
            <v-btn
              color="primary"
              class="mx-2"
              @click="requestSuggestions()"
              >Request recommendations</v-btn
            >
          </v-row>
          <v-card-text>
            <v-row v-if="alert">
              <v-col cols="12">
                <v-alert type="info" class="ml-3 mr-3">
                  No job offer recommendations in recent memory! Please request a
                  new set of recommendations.
                </v-alert>
              </v-col>
            </v-row>
            <v-row v-else>
              <v-col
                style="flex: 1;" sm="12" md="6" lg="4"
                v-for="jo in jobOffers"
                :key="jo.id"
              >
                <job-offer-card v-bind:jobOffer="jo" />
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import JobOfferCard from "../../components/job-offers/JobOfferCard.vue";

const apiURL = "/api/job-offer-suggestion";

export default {
  components: {
    JobOfferCard,
  },
  name: "JobOfferRequestView",
  data() {
    return {
      search: "",
      jobOffers: [],
      alert: false,
      lastDate: null,
  // private Long id;
	// private Timestamp date;
	// private List<JobOfferRatingDTO> offerRatings;
    };
  },
  mounted() {
    this.axios
      .get(apiURL)
      .then((response) => {
        this.alert = false;
        console.log(response.data);
        this.jobOffers = response.data.offerRatings;
        this.lastDate = response.data.date;
      })
      .catch((error) => {
        this.alert = true;
        console.log(error);
      });
  },
  methods: {
    requestSuggestions() {
      this.axios
        .get(apiURL + "/request")
        .then((response) => {
          this.alert = false;
          this.jobSuggestion = response.data;
          console.log(this.jobSuggestion);
        })
        .catch((error) => {
          alert(error);
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
