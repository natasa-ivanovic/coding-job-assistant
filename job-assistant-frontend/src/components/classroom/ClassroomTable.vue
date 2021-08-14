<!--template>
  <v-data-table
    :headers="infoHeader"
    :items="info"
    :expanded.sync="expanded"
    item-key="id"
    show-expand
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar flat>
        <v-toolbar-title>Materials</v-toolbar-title>
      </v-toolbar>
    </template>
    <template v-slot:[`item.dateSuggested`]="{ item }">
      {{ new Date(item.dateSuggested).toDateString() }}
    </template>
    <template v-slot:[`item.studied`]="{ item }">
      <v-btn icon :disabled="item.checked" @click="check(item)">
        <v-icon>
          mdi-check-bold
        </v-icon>
      </v-btn>
    </template>
    <template v-slot:expanded-item="{ headers, item }">
      <td :colspan="headers.length">
        <v-data-table
          :headers="materialHeader"
          :items="item.statuses"
          item-key="name"
          class="elevation-0 mt-3 mb-3"
          hide-default-footer
        >
          <template v-slot:[`item.url`]="{ item }">
            <a>{{ item.url }}</a>
          </template>
        </v-data-table>
      </td>
    </template>
  </v-data-table>
</template-->

<template>
  <v-card>
    <v-layout justify-center align-center>
      <v-flex shrink>
        <div>
          <v-img
            mx-auto
            src="@/assets/bulb-cover.png"
            width="1413px"
            height="338px"
          ></v-img>
        </div>
      </v-flex>
    </v-layout>
    <v-card-title class="justify-center description mt-0 pt-0" style="font-size:55px"
      >Welcome to classroom!</v-card-title
    >
    <v-row>
      <v-row v-for="jo in info" :key="jo.id">
        <v-row class="ml-5 mb-0 description" style="font-size:30px">
            {{ jo.company }},
            {{ jo.position }}
            {{ jo.seniority }}
        </v-row>
        <v-row >
          <v-col
            style="flex: 1;"
            class="mt-0"
            sm="12"
            md="6"
            lg="4"
            v-for="suggestion in sortMaterials(jo.statuses)"
            :key="suggestion.id"
          >
            <interview-card v-bind:interviewSuggestion="suggestion" />
          </v-col>
        </v-row>
      </v-row>
    </v-row>
  </v-card>
</template>

<script>
const apiURL = "/api/interview-suggestion";
import InterviewCard from "./InterviewCard.vue";

export default {
  name: "ClassroomTable",
  components: {
    InterviewCard,
  },
  data() {
    return {
      info: [],
    };
  },
  mounted() {
    this.axios.get(apiURL).then((response) => {
      this.info = response.data;
    });
  },
  methods: {
    sortMaterials(materials) {
      return materials.slice().sort((a, b) => {
        return a['proficiencyValue'] - b['proficiencyValue'];
      })
    }
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
