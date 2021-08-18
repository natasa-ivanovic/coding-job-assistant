<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col> Job positions </v-col>
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
          <v-data-table :headers="headers" :items="positions" :search="search">
            <template v-slot:[`item.actions`]="{ item }">
              <v-btn icon small @click="viewDetails(item)">
                <v-icon>mdi-menu</v-icon>
              </v-btn>
            </template>
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/job-position";

export default {
  name: "JobPositionListView",
  components: {
  },
  data() {
    return {
      search: "",
      headers: [
        { text: "Title", value: "title" },
        { text: "Details", value: "actions", align: "right" },
      ],
      positions: [],
    };
  },

  mounted() {
    this.getPositions();
  },

  methods: {
    getPositions() {
      this.axios
        .get(apiURL)
        .then((response) => {
          this.positions = response.data;
        })
        .catch((error) => {
          this.$root.snackbar.error(error.response.data.message);
        });
    },
    viewDetails(item) {

    }
  },
};
</script>
