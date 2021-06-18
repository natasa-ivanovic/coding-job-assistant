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
            <v-row>
              <v-col cols="12" sm="12" md="4" v-for="jp in jobOffers" :key="jp.id">
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

const apiURL = "/api/job-offer-suggestion"

export default {
  components: {
    JobOfferCard,
  },
  name: "JobOfferRequestView",
  // private Long id;
	// private String position;
	// private String company;
	// private int rating;
	// private String description;
	// private String category;
	// private Long jobOfferId;
  data() {
    return {
      search: "",
      jobOffers: [
        {
          id: 1,
          rating: 69,
          description:
            "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
          category: "category",
          company: "company",
          position: "Frontend Developer",
          jobOfferId: "1",
          seniority: "JUNIOR",
        },
      ],
    };
  },
  mounted() {
    this.axios.get(apiURL)
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.log(error);
    })
  }
};
</script>

<style scoped>
</style>