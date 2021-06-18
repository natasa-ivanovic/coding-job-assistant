<template>
  <v-row align="center" justify="center">
    <v-col cols="10">
      <v-card class="mt-5">
        <v-card-title style="font-size:30px;">
          Proficiency Evaluation
        </v-card-title>
        <div v-if="programming">
          <v-card-title>Programming languages</v-card-title>
          <statistic-slider
            v-for="p in programming"
            :key="p.id"
            v-bind:difference="p"
          ></statistic-slider>
        </div>
        <v-divider class="mt-3"></v-divider>
        <div v-if="technology">
          <v-card-title>Technology</v-card-title>
          <statistic-slider
            v-for="p in technology"
            :key="p.id"
            v-bind:difference="p"
          ></statistic-slider>
        </div>
        <v-divider class="mt-3"></v-divider>
        <div v-if="technology">
          <v-card-title>Knowledge</v-card-title>
          <statistic-slider
            v-for="p in knowledge"
            :key="p.id"
            v-bind:difference="p"
          ></statistic-slider>
        </div>
        <v-divider class="mt-3"></v-divider>
        <div v-if="technology">
          <v-card-title>Soft skills</v-card-title>
          <statistic-slider
            v-for="p in softSkill"
            :key="p.id"
            v-bind:difference="p"
          ></statistic-slider>
        </div>
        <div v-if="technology">
          <v-card-title>Languages</v-card-title>
          <statistic-slider
            v-for="p in language"
            :key="p.id"
            v-bind:difference="p"
          ></statistic-slider>
        </div>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import StatisticSlider from "./StatisticSlider.vue";
const apiURL = "/api/job-offer-statistic/";

export default {
  name: "StatisticCard",
  components: { StatisticSlider },
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
      .get(apiURL + this.id)
      .then((response) => {
        this.programming = response.data.programmingDifferences;
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
  methods: {},
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
