<template>
  <v-row class="mr-5 ml-5 mt-5">
    <v-col cols="2">
      <h3>{{ difference.subject }}</h3>
    </v-col>
    <v-col cols="10">
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
  </v-row>
</template>

<script>
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
  }),
  props: {
    difference: Object,
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
  },
};
</script>
