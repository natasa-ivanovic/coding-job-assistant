<template>
  <v-row align="center" justify="center">
    <v-col cols="8">
      <v-card class="mt-5">
        <!-- <v-img
          style="height:200px;width:200px;"
          justify-center align-center
          src="https://image.freepik.com/free-vector/tiny-hr-manager-looking-candidate-job-interview-magnifier-computer-screen-flat-vector-illustration-career-employment_74855-8619.jpg"
        ></v-img> -->

        <v-card-title style="font-size:30px;">
          Proficiency Evaluation
        </v-card-title>
        <v-card-title v-if="programming">Programming languages</v-card-title>
        <v-card-title v-if="technology">Technology</v-card-title>
        <v-card-title v-if="knowledge">Knowledge</v-card-title>
        <v-card-title v-if="softSkill">Soft skills</v-card-title>
        <v-card-title v-if="language">Languages</v-card-title>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
const apiURL = "/api/job-offer-statistic/";

export default {
  name: "StatisticCard",
  data: () => ({
    programming: [],
    technology: [],
    knowledge: [],
    softSkill: [],
    language: [],
    date: null,
    jobOffer: Object,
  }),
  props: {
    id: Number,
    // private Long id;
    // private String subject;
    // private SkillProficiency userProficiency;
    // private SkillProficiency jobOfferProficiency;
  },
  mounted() {
    this.axios
      .get(apiURL + id)
      .then((response) => {
        this.programming = response.data.programmingDifference;
        this.technology = response.data.technologyDifferences;
        this.knowledge = response.data.knowledgeDifferences;
        this.softSkill = response.data.softSkillDifferences;
        this.language = response.data.languageDifferences;
        this.date = response.data.date;
      })
      .catch((error) => {
        alert(error);
      });
  },
  methods: {
    view: () => {
      console.log(view);
    },
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
