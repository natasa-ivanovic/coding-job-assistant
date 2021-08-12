<template>
<v-hover v-slot:default="{ hover }">
  <v-card elevation="8" class="mx-auto my-12" max-width="372" color="grey lighten-4">
    <!--template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template-->
    <v-img width="100%" height="100%" :src="generatePicture(interviewSuggestion.cvElement)">
		<v-expand-transition>
			<div v-if="hover" class="d-flex transition-fast-in-fast-out black darken-3 v-card--reveal display-2 white--text" style="height: 100%;"> 
				{{ generateSubject(interviewSuggestion.cvElement) }} 
			</div>
		</v-expand-transition>
    </v-img>

    <v-card-title>{{ interviewSuggestion.subject }}</v-card-title>

    <!--v-card-text>
      <v-row align="center" class="mx-0">
        <v-rating
          :value="jobOffer.offerRating"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ms-4">{{ getRatingText() }}</div>
      </v-row>
    </v-card-text>
    <div class="mt-6 ml-4 mr-4" style="text-align: justify">
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rutrum
      mi non dolor congue congue. Donec vestibulum nisi lectus.
    </div>
    <v-divider class="mx-4 mt-4 mb-4"></v-divider>
    <v-card-text>
      <v-row>
        <v-alert
          dense
          :icon="getIconForCategory(jobOffer.category)"
          :color="getColorForCategory(jobOffer.category)"
          style="width: 100%"
          class="ml-2 mr-2"
        >
          {{ jobOffer.category.split("_").join(" ") }}
        </v-alert>
      </v-row>
    </v-card-text>
    <div class="ml-4 mr-4" style="text-align: justify">
      <b>{{ statusDescription(jobOffer.category) }}</b>
    </div>
    <v-card-actions>
      <v-btn color="#1A237E" text @click="view"> Details </v-btn>
      <v-spacer></v-spacer>
      <v-btn color="#1A237E" text @click="showStatistic()"> Evaluate </v-btn>
    </v-card-actions>
    <v-card-actions>
      <v-btn v-if="!jobOffer.following" block class="primary" @click="follow()"
        >Follow</v-btn
      >
      <v-alert
        v-else
        outlined
        color="#1A237E"
        dense
        class="ml-2 mr-2 mb-0"
        style="width: 100%; height:35.99px; text-align:center"
      >
        <b>YOUR POSITION: {{ jobOffer.ranking }}</b>
      </v-alert>
    </v-card-actions-->
  </v-card>
</v-hover>
</template>

<script>
export default {
  name: "InterviewCard",
  data: () => ({}),
  props: {
    interviewSuggestion: Object,
  },
  methods: {
    generatePicture(elementType) {
      switch (elementType) {
        case "PROGRAMMING_LANGUAGE":
          return require("@/assets/icon-large-prog-lang.png");
        case "TECHNOLOGY":
          return require("@/assets/icon-large-technology.png");
        case "KNOWLEDGE":
          return require("@/assets/icon-large-knowledge.png");
        case "SOFT_SKILL":
          return require("@/assets/icon-large-soft-skill.png");
        case "LANGUAGE":
          return require("@/assets/icon-large-language.png");
      }
    },
    generateSubject(elementType) {
      switch (elementType) {
        case "PROGRAMMING_LANGUAGE":
          return "PROGRAMMING LANGUAGE";
        case "TECHNOLOGY":
          return "TECHNOLOGY";
        case "KNOWLEDGE":
          return "KNOWLEDGE";
        case "SOFT_SKILL":
          return "SOFT SKILL";
        case "LANGUAGE":
          return "LANGUAGE";
      }
    },
  },
};
</script>

<style scoped lang="scss">
.description {
  font-family: "Baloo2", Helvetica, Arial;
}

.v-card--reveal {
    align-items: center;
    bottom: 0;
    justify-content: center;
    opacity: 0.6;
    position: absolute;
    width: 100%;
}

</style>
