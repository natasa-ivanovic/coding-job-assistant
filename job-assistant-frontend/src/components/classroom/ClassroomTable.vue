<template>
  <v-card>
    <v-layout justify-center align-center>
      <v-flex shrink>
        <div>
          <v-img
            mx-auto
            src="@/assets/bulb-cover.png"
            width="1413px"
            height="338px"
          ></v-img>
        </div>
      </v-flex>
    </v-layout>
    <v-card-title class="justify-center description mt-0 pt-0" style="font-size:55px"
      >Welcome to classroom!</v-card-title
    >
    <v-row class="ml-5 mr-5">
      <v-progress-linear
        indeterminate
        color="teal"
        :active="show"
      ></v-progress-linear>
    </v-row>
    <v-row v-if="info.length == 0 && !show">
      <v-col cols="12">
        <v-alert class="ml-3 mr-3" type="info">
          No classroom materials currently available! Please visit your Job Offer suggestions and click the Evaluate button to decide on what you should study next.
        <v-btn class="mt-3" color="white" outlined to="/job-offer-requests"
        >
        Take me there!
        </v-btn>
        </v-alert>
      </v-col>
    </v-row>
    <v-row v-else>
      <v-row v-for="jo in info" :key="jo.id">
        <v-row class="ml-5 mb-0 description" style="font-size:30px">
            {{ jo.company }},
            {{ jo.position }}
            {{ jo.seniority }}
        </v-row>
        <v-row >
          <v-col
            style="flex: 1;"
            class="mt-0"
            sm="12"
            md="6"
            lg="4"
            v-for="suggestion in sortMaterials(jo.statuses)"
            :key="suggestion.id"
          >
            <interview-card v-bind:interviewSuggestion="suggestion" @materialFinished="handleMaterialFinished"/>
          </v-col>
        </v-row>
      </v-row>
    </v-row>
  </v-card>
</template>

<script>
const apiURL = "/api/interview-suggestion";
import InterviewCard from "./InterviewCard.vue";

export default {
  name: "ClassroomTable",
  components: {
    InterviewCard,
  },
  data() {
    return {
      info: [],
      show: false,
    };
  },
  mounted() {
    this.getAllMaterials();
  },
  methods: {
    sortMaterials(materials) {
      return materials.slice().sort((a, b) => {
        return a['proficiencyValue'] - b['proficiencyValue'];
      })
    },
    getAllMaterials() {
        this.show = true;
        this.axios.get(apiURL).then((response) => {
        this.info = response.data;
        this.show = false;
      });
    },
    handleMaterialFinished() {
      this.info = [];
      this.getAllMaterials();
    }
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
