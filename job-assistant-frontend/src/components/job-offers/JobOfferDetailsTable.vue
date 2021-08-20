<template>
  <v-data-table
    :headers="headers"
    :items="importances"
    :items-per-page="4"
    class="mr-5 ml-5"
  >
    <template v-slot:[`item.cvElementName`]="{ item }">
      <b>{{ item["cvElementName"] }}</b>
    </template>
    <template v-slot:[`item.proficiency`]="{ item }">
      {{ formatProficiency(item["proficiency"]) }}
    </template>
    <template v-slot:[`item.importanceLevel`]="{ item }">
      <v-rating
        class="ml-0 pl-0"
        v-model="item['importanceLevel']"
        background-color="orange lighten-3"
        color="orange"
        small
        length="10"
      ></v-rating>
    </template>
    <template v-slot:[`item.optional`]="{ item }">
      <v-icon>{{ checkIfRequired(item) }}</v-icon>
    </template>
  </v-data-table>
</template>

<script>
export default {
  name: "JobOfferDetailsCard",
  props: {
    importances: Array,
  },
  data: () => ({
    headers: [
      { text: "Name", value: "cvElementName" },
      { text: "Proficiency", value: "proficiency" },
      { text: "Importance Level", value: "importanceLevel" },
      { text: "Required", value: "optional" },
    ],
  }),
  methods: {
    checkIfRequired(item) {
      if (item.optional == true) {
        return "mdi-close-thick";
      }
      return "mdi-check-bold";
    },
    formatProficiency(proficiency) {
      if (proficiency == "VERY_GOOD") {
        return "VERY GOOD";
      }
      return proficiency;
    },
  },
};
</script>
