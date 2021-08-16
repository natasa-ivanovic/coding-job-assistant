<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
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
          <v-data-table :headers="headers" :items="offers" :search="search">
            <template v-slot:[`item.seniority`]="{ item }">
              {{
                item.seniority.charAt(0) + item.seniority.slice(1).toLowerCase()
              }}
            </template>
            <template v-slot:[`item.datePosted`]="{ item }">
              {{ new Date(item.datePosted).toDateString() }}
            </template>
            <template v-slot:[`item.medal`]="{ item }">
              <v-icon v-if="item.medal != 'NONE'" :color="getColor(item.medal)">
                mdi-medal
              </v-icon>
            </template>
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/job-offer";

export default {
  name: "ManageUsers",
  data() {
    return {
      search: "",
      headers: [
        { text: "Job position", value: "positionName" },
        { text: "Company", value: "companyName" },
        { text: "Seniority", value: "seniority" },
        { text: "Posted on", value: "datePosted" },
        { text: "Medal", value: "medal" },
      ],
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
