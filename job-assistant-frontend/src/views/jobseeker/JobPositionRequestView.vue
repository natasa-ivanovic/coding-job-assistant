<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col> 
              Job positions
            </v-col>
            <v-col>
              <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="Search"
                single-line
                hide-details
              ></v-text-field>
            </v-col>
          </v-card-title>
          <v-card-text>
            <v-row>
              <v-col cols="12" sm="12" md="4" v-for="jp in jobPositions" :key="jp.id">
                <job-position-card v-bind:jobPosition="jp" />
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
import JobPositionCard from "../../components/job-positions/JobPositionCard.vue";

export default {
  components: {
    JobPositionCard,
  },
  name: "JobPositionRequestView",
  data() {
    return {
      search: "",
      jobPositions: [
        {
          id: 1,
          rating: 69,
          description:
            "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
          title: "Frontend Developer",
          subtitle: "JavaScript",
          seniority: "JUNIOR",
          jobPositionId: 2,
        },
        {
          id: 2,
          rating: 77,
          description:
            "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
          title: "Backend Developer",
          subtitle: "JavaScript",
          seniority: "JUNIOR",
          jobPositionId: 2,
        },
        {
          id: 3,
          rating: 77,
          description:
            "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
          title: "Backend Developer",
          subtitle: "JavaScript",
          seniority: "JUNIOR",
          jobPositionId: 2,
        },
        {
          id: 4,
          rating: 77,
          description:
            "Programming language - JavaScript (GOOD)\nTechnology - Vue (GOOD)\nKnowledge - REST (EXCELLENT)\n",
          title: "Backend Developer",
          subtitle: "JavaScript",
          seniority: "JUNIOR",
          jobPositionId: 2,
        },
      ],
    };
  },
};
</script>

<style scoped>
</style>