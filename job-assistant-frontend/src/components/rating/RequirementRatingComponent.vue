<template>
  <v-row class="flexbox" v-if="data">
    <v-col class="rating-name pl-0 pb-0">
      {{ data.name }}
    </v-col>
    <v-col class="rating-value pl-0 pr-0 pb-0">
      <v-rating dense size="12" readonly :value="getValue()">
        <template v-slot:item="props">
          <v-icon small :color="data.value == '' ? 'white' : 'rgba(0, 0, 0, 0.54)'">
            {{
              props.isFilled ? "mdi-check-circle" : "mdi-check-circle-outline"
            }}
          </v-icon>
        </template>
      </v-rating>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "RequirementRatingComponent",
  data() {
    return {
      loading: false,
    };
  },
  props: {
    data: Object,
  },
  methods: {
    getValue: function () {
      if (this.data.value) {
        switch (this.data.value) {
          case "BASIC":
            return 1;
          case "GOOD":
            return 2;
          case "VERY_GOOD":
            return 3;
          case "EXCELLENT":
            return 4;
          case "EXPERT":
            return 5;
        }
      }
    },
  },
};
</script>

<style scoped>
.flexbox {
  flex: 1;
}

.rating-name {
  flex: 3;
}
.rating-value {
  flex: 1;
}

.chip-disabled {
  pointer-events: none;
  user-select: none;
}
</style>