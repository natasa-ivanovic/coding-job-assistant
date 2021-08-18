<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col>Company reviews</v-col>
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
const apiURL = "/api/company-review";

export default {
  name: "CompanyReviewListForm",
  components: {},
  data() {
    return {
      search: "",
      headers: [
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
          this.$root.snackbar.warning(error);
        });
    },
    approveReview(item) {
      this.axios
        .post(apiURL + "/approve/" + item.id)
        .then((response) => {
            item.status = "APPROVED";
            this.$root.snackbar.success("Successfully approved review!");
        })
        .catch((error) => {
          this.$root.snackbar.error(error.response.data.message);
        });
    },
    declineReview(item) {
      this.axios
        .post(apiURL + "/decline/" + item.id)
        .then((response) => {
            item.status = "DECLINED";
            this.$root.snackbar.success("Successfully declined review!");
        })
        .catch((error) => {
          this.$root.snackbar.error(error.response.data.message);
        });
    },
  },
};
</script>
