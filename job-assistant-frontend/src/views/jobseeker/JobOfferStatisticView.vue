<template>
  <v-container fluid>
    <statistic-card v-bind:id="id"></statistic-card>
  </v-container>
</template>

<script>
import StatisticCard from "../../components/statistic/StatisticCard.vue";

export default {
  components: {
    StatisticCard,
  },
  name: "JobOfferStatisticView",
  props: {
    id: Number,
  },
  data() {
    return {};
  },
};
</script>

<style scoped></style>
