<template>
  <v-card :loading="loading" class="mx-auto my-12" max-width="400">
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      src="@/assets/job-position.jpg"
      height="210"
    ></v-img>

    <v-card-title>{{ jobPosition.title }}</v-card-title>
    <v-card-subtitle>{{ jobPosition.subtitle }}</v-card-subtitle>

    <v-card-text>
      <v-row align="center" class="mx-0">
        <v-rating
          :value="getRating()"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ms-4">{{ getRatingText() }}</div>
      </v-row>

      <div class="mt-6 ml-3 mr-3">
        <v-row
          v-for="description in formatDescription(jobPosition.description)"
          :key="description.name"
        >
          <requirement-rating-component v-bind:data="description" />
        </v-row>
      </div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>Recommended seniority level</v-card-title>

    <v-card-text>
      <v-chip-group
        v-model="jobPosition.seniority"
        active-class="indigo accent-1 black--text"
        column
      >
        <v-chip class="custom-chip chip-disabled" value="JUNIOR" label
          >Junior</v-chip
        >
        <v-chip class="custom-chip chip-disabled" value="MEDIOR" label
          >Medior</v-chip
        >
        <v-chip class="custom-chip chip-disabled" value="SENIOR" label
          >Senior</v-chip
        >
      </v-chip-group>
    </v-card-text>

    <v-card-actions>
      <v-btn class="ml-2" color="black lighten-2" outlined @click="view">
        View details
      </v-btn>
      <v-spacer />
      <v-btn class="mr-2" color="black lighten-2" outlined @click="view">
        View offers
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import RequirementRatingComponent from "../rating/RequirementRatingComponent.vue";

export default {
  name: "JobPositionCard",
  components: {
    RequirementRatingComponent,
  },
  data() {
    return {
      loading: false,
    };
  },
  props: {
    jobPosition: Object,
    maxRating: Number,
  },
  methods: {
    view: () => {
      console.log(view);
    },
    getIcon: function (val) {
      if (val == this.userProf) return this.iconUser;
      else return this.iconJob;
    },
    formatDescription: function (desc) {
      const list = [];
      desc.split("\n").forEach((el) => {
        if (el.length == 0) return;
        const name = el.split(" (")[0];
        const value = el.split(" (")[1].replace(")", "");
        list.push({ name, value });
      });
      if (list.length > 5) return list.splice(0, 5);
      else return list;
    },
    getRating: function () {
      if (this.maxRating != 0) {
        const percentage = (this.jobPosition.rating * 100) / this.maxRating
        return percentage / 20;
      }
      else return 0;
    },
    getRatingText: function () {
      const rating = this.getRating();
      if (rating >= 4.0) {
        return "Excellent match!"
      } else if (rating >= 2) {
        return "Decent match!"
      } else {
        return "Potentially useful!"
      }
    },
  },
};
</script>

<style scoped>
.custom-chip {
  flex: 1;
  justify-content: center;
}

.chip-disabled {
  pointer-events: none;
  user-select: none;
}
</style>