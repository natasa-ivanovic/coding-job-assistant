<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
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
          <v-card-text>
            <v-btn
              v-if="alert"
              class="success"
              block
              @click="requestSuggestions()"
              >Request recommendations</v-btn
            >
            <v-alert v-if="alert" type="info" class="mt-5">
              No job offer recommendations in recent memory! Please request a
              new set of recommendations.
            </v-alert>
            <v-row>
              <v-col
                cols="12"
                sm="12"
                md="4"
                v-for="jp in jobSuggestion['offerRatings']"
                :key="jp.id"
              >
                <job-offer-card v-bind:jobOffer="jp" />
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
      jobSuggestion: Object,
      alert: false,
  //     private Long id;
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
        this.jobSuggestion = response.data;
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
          this.jobSuggestion = response.date;
          console.log(this.jobSuggestion);
        })
        .catch((error) => {
          alert(error);
        });
    },
  },
};
</script>

<style scoped></style>
