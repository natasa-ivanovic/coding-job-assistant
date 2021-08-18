<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col>CV Elements</v-col>
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
          <v-data-table :headers="headers" :items="elements" :search="search">
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/job-position";

export default {
  name: "JobPositionListForm",
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
      elements: [],
    };
  },

  mounted() {
    this.getElements();
  },

  methods: {
    getElements() {
      this.axios
        .get(apiURL)
        .then((response) => {
          this.elements = response.data;
        })
        .catch((error) => {
          this.$root.snackbar.warning(error);
        });
    },
  },
};
</script>
