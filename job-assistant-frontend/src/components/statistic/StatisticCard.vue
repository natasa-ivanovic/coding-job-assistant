<template>
  <v-row align="center" justify="center">
    <v-col cols="10">
      <v-card class="mt-5" height="600px" max-height="700px">
        <v-card-title style="font-size:30px;" class="description">
          Proficiency Evaluation
        </v-card-title>
        <div>
          <v-tabs v-model="tab" centered slider-color="blue" class="mb-5">
            <v-tab v-if="programming">Programming languages</v-tab>
            <v-tab v-if="technology">Technology</v-tab>
            <v-tab v-if="knowledge">Knowledge</v-tab>
            <v-tab v-if="softSkill">Soft skills</v-tab>
            <v-tab v-if="language">Languages</v-tab>
          </v-tabs>
          <v-tabs-items v-model="tab">
            <v-tab-item>
              <div v-if="programming">
                <statistic-slider
                  v-for="p in programming"
                  :key="p.id"
                  v-bind:difference="p"
                ></statistic-slider>
              </div>
            </v-tab-item>
            <v-tab-item>
              <div v-if="technology">
                <statistic-slider
                  v-for="p in technology"
                  :key="p.id"
                  v-bind:difference="p"
                ></statistic-slider>
              </div>
            </v-tab-item>
            <v-tab-item>
              <div v-if="technology">
                <statistic-slider
                  v-for="p in knowledge"
                  :key="p.id"
                  v-bind:difference="p"
                ></statistic-slider>
              </div>
            </v-tab-item>
            <v-tab-item>
              <div v-if="technology">
                <statistic-slider
                  v-for="p in softSkill"
                  :key="p.id"
                  v-bind:difference="p"
                ></statistic-slider>
              </div>
            </v-tab-item>
            <v-tab-item>
              <div v-if="language">
                <statistic-slider
                  v-for="p in language"
                  :key="p.id"
                  v-bind:difference="p"
                ></statistic-slider>
              </div>
            </v-tab-item>
          </v-tabs-items>
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
    tab: 0,
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
        // TODO proveriti jel ovo okej
        this.$root.snackbar.error(error);
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
