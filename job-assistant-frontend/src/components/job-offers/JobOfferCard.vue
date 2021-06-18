<template>
  <v-card :loading="loading" class="mx-auto my-12" max-width="374">
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      height="250"
      src="https://www.simplilearn.com/ice9/free_resources_article_thumb/How_to_Become_a_Back_End_Developer.jpg"
    ></v-img>

    <v-card-title>{{jobOffer.category}}</v-card-title>
    <v-card-subtitle>{{jobOffer.company}}</v-card-subtitle>

    <v-card-title>Pozicija</v-card-title>
    <v-card-subtitle>Kompanija</v-card-subtitle>

    <!-- <v-card-text>
      <v-row align="center" class="mx-0">
        <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ms-4">4.5 (413)</div>
      </v-row>

      <div class="my-4 text-subtitle-1">$ • Italian, Cafe</div>

      <div>
        Small plates, salads & sandwiches - an intimate setting with 12 indoor
        seats plus patio seating.
      </div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>Tonight's availability</v-card-title>

    <v-card-text>
      <v-chip-group
        v-model="selection"
        active-class="deep-purple accent-4 white--text"
        column
      >
        <v-chip>5:30PM</v-chip>

        <v-chip>7:30PM</v-chip>

        <v-chip>8:00PM</v-chip>

        <v-chip>9:00PM</v-chip>
      </v-chip-group>
    </v-card-text> -->

    <v-card-actions>
      <v-btn color="deep-purple lighten-2" text @click="view"> Details </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "JobOfferCard",
  data: () => ({
    loading: false,
    selection: 1,
  }),
  props: {
    jobOffer: Object,
    // job position title
    // company name
    // date posted
    // seniority
    // medal rank
  },
  methods: {
    view: () => {
      console.log(view);
    },
  },
};
</script>

<style scoped>
</style>