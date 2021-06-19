<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col>Job offer reviews</v-col>
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
          <v-data-table :headers="headers" :items="reviews" :search="search">
            <template v-slot:[`item.status`]="{ item }">
              {{
                item.status.charAt(0) + item.status.slice(1).toLowerCase()
              }}
            </template>
            <template v-slot:[`item.actions`]="{ item }">
              <v-btn
                icon
                small
                @click="approveReview(item)"
                :disabled="!(item.status == 'PENDING')"
              >
                <v-icon>mdi-check</v-icon>
              </v-btn>
              <v-btn
                icon
                small
                @click="declineReview(item)"
                :disabled="!(item.status == 'PENDING')"
              >
                <v-icon>mdi-close</v-icon>
              </v-btn>
            </template>
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/job-offer-review";

export default {
  name: "ManageUsers",
  components: {},
  data() {
    return {
      search: "",
      headers: [
        { text: "Job offer id", value: "offerId" },
        { text: "Job position", value: "offerName" },
        { text: "Company", value: "companyName" },
        { text: "Rating", value: "rating" },
        { text: "Poster name", value: "jobSeekerName" },
        { text: "Poster username", value: "jobSeekerUsername" },
        { text: "Status", value: "status" },
        { text: "Actions", value: "actions" },
      ],
      reviews: [],
    };
  },

  mounted() {
    this.getReviews();
  },

  methods: {
    getReviews() {
      this.axios
        .get(apiURL)
        .then((response) => {
          this.reviews = response.data;
        })
        .catch((error) => {
          alert(error);
        });
    },
    approveReview(item) {
      this.axios
        .post(apiURL + "/approve/" + item.id)
        .then((response) => {
            item.status = "APPROVED";
          alert("Successfully approved review!");
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
    },
    declineReview(item) {
      this.axios
        .post(apiURL + "/decline/" + item.id)
        .then((response) => {
            item.status = "DECLINED";
          alert("Successfully declined review!");
        })
        .catch((error) => {
          alert(error.response.data.message);
        });
    },
  },
};
</script>
