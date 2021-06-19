<template>
  <v-row class="mr-5 ml-5 mt-9">
    <v-col cols="2">
      <h3>{{ difference.subject }}</h3>
    </v-col>
    <v-col cols="9">
      <v-range-slider
        :tick-labels="labels"
        :value="[
          getValue(difference.userProficiency),
          getValue(difference.jobOfferProficiency),
        ]"
        min="0"
        max="5"
        ticks="always"
        tick-size="6"
        readonly
        thumb-label="always"
      >
        <template v-slot:thumb-label="props">
          <v-icon dark>
            {{ getIcon(props.value) }}
          </v-icon>
        </template>
      </v-range-slider>
    </v-col>
    <v-col cols="1">
      <v-btn :disabled="disableBtn" @click="improveSkill()" class="primary">Improve</v-btn>
    </v-col>
  </v-row>
</template>

<script>
const apiURL = "/api/interview-suggestion/";

export default {
  name: "StatisticCard",
  data: () => ({
    labels: [
      "NO EXPERIENCE",
      "BASIC",
      "GOOD",
      "VERY GOOD",
      "EXCELLENT",
      "EXPERT",
    ],
    disableBtn: false
  }),
  props: {
    difference: Object,
  },
  mounted() {
    this.improveSkillDisabled();
  },
  methods: {
    getIcon: function(val) {
      if (val == this.getValue(this.difference.userProficiency))
        return "mdi-account";
      else return "mdi-flag-checkered";
    },
    getValue: function(proficiency) {
      if (proficiency == "NONE") return 0;
      else if (proficiency == "BASIC") return 1;
      else if (proficiency == "GOOD") return 2;
      else if (proficiency == "VERY_GOOD") return 3;
      else if (proficiency == "EXCELLENT") return 4;
      else if (proficiency == "EXPERT") return 5;
    },
    improveSkillDisabled: function() {
      let user = this.getValue(this.difference.userProficiency);
      let job = this.getValue(this.difference.jobOfferProficiency);
      if (user < job)
        this.disableBtn = false;
      else
        this.disableBtn = true;
    },
    improveSkill: function() {
      this.axios.post(apiURL + this.difference.id)
      .then((response) => {
        this.disableBtn = true;
        console.log(response);
        alert("Your materials are ready! Check out the classroom!");
      })
      .catch((error) => {
        console.log(error.response.data);
      })
    }
  },
};
</script>
