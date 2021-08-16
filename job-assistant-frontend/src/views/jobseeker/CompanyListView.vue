<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col> Companies </v-col>
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
          <v-data-table :headers="headers" :items="companies" :search="search">
            <template v-slot:[`item.seniority`]="{ item }">
              {{item.seniority.charAt(0) + item.seniority.slice(1).toLowerCase()}}
            </template>
            <template v-slot:[`item.datePosted`]="{ item }">
              {{new Date(item.datePosted).toDateString()}}
            </template>
            <template v-slot:[`item.rating`]="{ item }">
              <v-icon small color="yellow darken-1">mdi-star</v-icon>
              {{ item.rating.toFixed(2) }}
            </template>
            <template v-slot:[`item.medal`]="{ item }">
              <v-icon v-if="item.medal != 'NONE'" :color="getColor(item.medal)">
                mdi-medal
              </v-icon>
            </template>
            <template v-slot:[`item.review`]="{ item }">
              <v-btn icon small @click="onRateClicked(item)">
                <v-icon>mdi-message-draw</v-icon>
              </v-btn>
            </template>
            
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>

    <v-dialog v-model="reviewDialog" max-width="600px">
      <company-review-form v-bind:companyId="reviewedCompany" v-bind:enabled.sync="reviewDialog" />
    </v-dialog>
  </v-container>
</template>

<script>
const apiURL = "/api/company";
import CompanyReviewForm from "../../components/rating/CompanyReviewForm.vue";

export default {
  name: "ManageUsers",
  components: {
    CompanyReviewForm,
  },
  data() {
    return {
      search: "",
      headers: [
        { text: "Company name", value: "name" },
        { text: "Rating", value: "rating" },
        { text: "Medal", value: "medal" },
        { text: "Add review", value: "review" },
      ],
      reviewDialog: false,
      companies: [],
      reviewedCompany: 0,
    };
  },

  mounted() {
    this.getCompanies();
  },

  methods: {
    getCompanies() {
      this.axios
        .get(apiURL)
        .then((response) => {
          this.companies = response.data;
        })
        .catch((error) => {
          this.$root.snackbar.error(error.response.data.message);
        });
    },

    onRateClicked(item) {
      // rating
      this.reviewDialog = true;
      this.reviewedCompany = item.id;
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
