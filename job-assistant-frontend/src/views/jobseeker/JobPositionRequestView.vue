<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="10">
        <v-card>
          <v-card-title>
            <v-col> 
              Job positions
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
          <v-row class="ml-7 mb-3" v-if="lastDate">
            Here are your suggestions from {{new Date(lastDate).toDateString()}}
          </v-row>
          <v-row class="ml-5">
            <v-btn color="primary" class="mx-2" @click="requestNewPrediction">Request recommendations</v-btn>
          </v-row>
          <v-card-text>
            <v-row v-if="!loaded">
              <v-col cols="12">
                <v-alert class="ml-3 mr-3" type="info">
                  No job position recommendations in recent memory! Please request a new set of recommendations.
                </v-alert>
              </v-col>
            </v-row>
            <v-row v-else>
              <v-col style="flex: 1;" sm="12" md="6" lg="4" v-for="jp in jobPositions" :key="jp.id">
                <job-position-card v-bind:jobPosition="jp" />
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
const requestURL = "/api/job-position-suggestion";
const lastURL = "/api/job-position-suggestion/last";

import JobPositionCard from "../../components/job-positions/JobPositionCard.vue";

export default {
  components: {
    JobPositionCard,
  },
  name: "JobPositionRequestView",
  data() {
    return {
      loaded: false,
      search: "",
      lastDate: null,
      jobPositions: [
        // {
        //   id: 1,
        //   rating: 69,
        //   description:
        //     "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
        //   title: "Frontend Developer",
        //   subtitle: "JavaScript",
        //   seniority: "JUNIOR",
        //   jobPositionId: 2,
        // },
        // {
        //   id: 2,
        //   rating: 77,
        //   description:
        //     "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
        //   title: "Backend Developer",
        //   subtitle: "JavaScript",
        //   seniority: "MEDIOR",
        //   jobPositionId: 2,
        // },
        // {
        //   id: 3,
        //   rating: 77,
        //   description:
        //     "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
        //   title: "Backend Developer",
        //   subtitle: "JavaScript",
        //   seniority: "SENIOR",
        //   jobPositionId: 2,
        // },
        // {
        //   id: 4,
        //   rating: 77,
        //   description:
        //     "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
        //   title: "Backend Developer",
        //   subtitle: "JavaScript",
        //   seniority: "JUNIOR",
        //   jobPositionId: 2,
        // },
      ],
    };
  },
  mounted() {
    this.getLastRequest();
  },
  methods: {
    getLastRequest: function () {
      this.axios
        .get(lastURL)
        .then((response) => {
          this.jobPositions = response.data.positionRatings;
          this.lastDate = response.data.date;
          console.log(response.data.date);
          this.loaded = true;
        })
        .catch((error) => {
          this.loaded = false;
        });
    },
    requestNewPrediction: function () {
      this.axios
        .post(requestURL)
        .then((response) => {
          this.jobPositions = response.data.positionRatings;
          this.lastDate = response.data.date;
          console.log(response.data.date);
          this.loaded = true;
        })
        .catch((error) => {
          this.loaded = false;
        });
    },
  },
};
</script>

<style scoped>
</style>