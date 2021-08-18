<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="10">
        <v-card>
          <v-card-title class="description ml-3" style="font-size:40px">
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
          <v-row class="ml-9 mr-9">
            <v-progress-linear
              indeterminate
              color="indigo accent-1"
              :active="show"
            ></v-progress-linear>
          </v-row>
          <v-card-text v-if="lastDate">
            <v-row>
              <v-alert
                icon="mdi-calendar"
                outlined
                color="black"
                dense
                class="ml-5 mr-5"
                style="width: 100%;"
              >
                Here are your suggestions from date:
                {{ new Date(lastDate).toDateString() }}.
              </v-alert>
            </v-row>
          </v-card-text>
          <v-row class="ml-7">
            <v-btn color="indigo accent-1" class="mx-2" @click="requestNewPrediction"
              >Request recommendations</v-btn
            >
          </v-row>
          <v-card-text>
            <v-row v-if="!loaded">
              <v-col cols="12">
                <v-alert class="ml-2 mr-3" color="indigo accent-3" type="info">
                  No job position recommendations in recent memory! Please
                  request a new set of recommendations.
                </v-alert>
              </v-col>
            </v-row>
            <v-row v-else>
              <v-col
                style="flex: 1;"
                sm="12"
                md="6"
                lg="4"
                v-for="jp in jobPositions"
                :key="jp.id"
              >
                <job-position-card
                  v-bind:jobPosition="jp"
                  v-bind:maxRating="maxRating"
                />
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
      jobPositions: [],
      show: false
    };
  },
  mounted() {
    this.getLastRequest();
  },
  computed: {
    maxRating: function() {
      const allRatings = [];
      this.jobPositions.forEach((jp) => allRatings.push(jp.rating));
      return Math.max(...allRatings);
    },
  },
  methods: {
    getLastRequest: function() {
      this.show = true;
      this.axios
        .get(lastURL)
        .then((response) => {
          this.jobPositions = response.data.positionRatings;
          this.lastDate = response.data.date;
          console.log(response.data.date);
          this.loaded = true;
          this.show = false;
        })
        .catch((error) => {
          this.loaded = false;
          this.show = false;
        });
    },
    requestNewPrediction: function() {
      this.show = true;
      this.axios
        .post(requestURL)
        .then((response) => {
          this.jobPositions = response.data.positionRatings;
          this.lastDate = response.data.date;
          console.log(response.data.date);
          this.loaded = true;
          this.show = false;
        })
        .catch((error) => {
          this.loaded = false;
          this.show = false;
        });
    },
  },
};
</script>

<style scoped></style>
