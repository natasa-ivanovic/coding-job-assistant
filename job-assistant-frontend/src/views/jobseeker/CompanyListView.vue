<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="11">
        <v-card>
          <v-card-text>
          <v-card-title class="description" style="font-size:40px; color:black"> Companies</v-card-title>
          <v-row class="ml-9 mr-9">
            <v-progress-linear
              indeterminate
              color="indigo accent-1"
              :active="show"
            ></v-progress-linear>
          </v-row>
          <v-row class="mt-0 pt-0">
            <v-col
              style="flex: 1;"
              sm="11"
              md="6"
              lg="3"
              v-for="c in companies"
              :key="c.id"
            >
              <company-card v-bind:company="c" />
            </v-col>
          </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/company";
import CompanyCard from "@/components/company/CompanyCard.vue";

export default {
  name: "CompanyListView",
  components: {
    CompanyCard,
  },
  data() {
    return {
      companies: [],
      show: false
    };
  },

  mounted() {
    this.getCompanies();
  },

  methods: {
    getCompanies() {
      this.show = true;
      this.axios
        .get(apiURL)
        .then((response) => {
          this.companies = response.data;
          this.show = false;
        })
        .catch((error) => {
          this.$root.snackbar.error(error.response.data.message);
          this.show = false;
        });
    },
  },
};
</script>
