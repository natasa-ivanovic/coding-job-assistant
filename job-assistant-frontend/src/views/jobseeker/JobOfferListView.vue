<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="10">
        <v-card>
          <v-card-title>
            <v-col> Job offers </v-col>
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
		  <v-row>
              <v-col
                style="flex: 1;"
                sm="12"
                md="6"
                lg="4"
                v-for="jo in offers"
                :key="jo.id"
              >
                <job-offer-card v-bind:jobOffer="jo" />
              </v-col>
            </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/job-offer";
import JobOfferCard from "@/components/job-offers/JobOfferCard.vue";

export default {
  name: "JobOfferListView",
  components: {
	  JobOfferCard
  },
  data() {
    return {
      search: "",
      offers: [],
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
          this.$root.snackbar.error(error.response.data.message);
        });
    },

    getColor(color) {
      switch (color) {
        case "BRONZE":
          return "#A55131";
        case "SILVER":
          return "grey";
        case "GOLD":
          return "yellow darken-2";
      }
    },
  },
};
</script>
