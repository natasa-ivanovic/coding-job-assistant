<template>
  <v-hover v-slot:default="{ hover }">
    <v-card
      elevation="8"
      class="mx-auto my-10 mt-0"
      width="500"
      color="grey lighten-4"
    >
      <v-img width="100%" height="140" src="@/assets/bulb.jpg">
        <v-expand-transition>
          <div
            v-if="hover"
            class="d-flex transition-fast-in-fast-out black darken-3 v-card--reveal display-1 white--text"
            style="height: 100%;"
          >
            {{ generateSubject(interviewSuggestion.cvElement) }}
          </div>
        </v-expand-transition>
      </v-img>
      <v-row>
        <v-col cols="7">
          <v-card-title class="mb-0 pb-0">{{
            interviewSuggestion.subject
          }}</v-card-title>
          <v-card-text class="mb-0 pb-0">
            Suggested:
            <b>{{
              new Date(interviewSuggestion.dateSuggested).toDateString()
            }}</b>
            <v-divider class="mt-3 pt-3"></v-divider>
          </v-card-text>
          <v-card-title class="mb-0 pb-0 mt-0 pt-0">Description</v-card-title>
          <v-card-text class="mb-0 pb-0">
            <p style="text-align:justify">
              {{ interviewSuggestion.description }}
            </p>
          </v-card-text>
        </v-col>
        <v-col>
          <v-flex xs12 offset-xs2>
            <v-spacer></v-spacer>
            <v-chip-group
              v-model="interviewSuggestion.proficiencyValue"
              active-class="deep-purple accent-4 white--text"
              column
              disabled
            >
              <v-chip label class="chip-style">
                <v-icon left>
                  mdi-battery-outline
                </v-icon>
                BASIC
              </v-chip>

              <v-chip label class="chip-style">
                <v-icon left>
                  mdi-battery-medium
                </v-icon>
                GOOD
              </v-chip>

              <v-chip label class="chip-style">
                <v-icon left>
                  mdi-battery-high
                </v-icon>
                VERY GOOD
              </v-chip>

              <v-chip label class="chip-style">
                <v-icon left>
                  mdi-battery-heart-variant
                </v-icon>
                EXCELLENT
              </v-chip>

              <v-chip label class="chip-style">
                <v-icon left>
                  mdi-battery
                </v-icon>
                EXPERT
              </v-chip>
            </v-chip-group>
          </v-flex>
        </v-col>
      </v-row>

      <v-card-actions class="mt-0 pt-0">
        <v-btn block class="primary"
          ><v-icon class="pr-3">mdi-link</v-icon>Get your materials</v-btn
        >
      </v-card-actions>
      <v-card-actions>
        <v-btn
          v-if="!interviewSuggestion.checked"
          :disabled="interviewSuggestion.forbiddenMaterial"
          block
          class="success"
          @click="finishMaterial(interviewSuggestion)"
          ><v-icon class="pr-3">mdi-check</v-icon>Complete</v-btn
        >
        <v-alert
          v-else
          outlined
          color="success"
          dense
          class="ml-0 mr-0 mb-0"
          style="width: 100%; height:35.99px; text-align:center"
        >
          <b>You successfully finished this!</b>
        </v-alert>
      </v-card-actions>
    </v-card>
  </v-hover>
</template>

<script>
const apiURL = "/api/interview-suggestion/check/";

export default {
  name: "InterviewCard",
  data: () => ({}),
  props: {
    interviewSuggestion: Object,
  },
  methods: {
    finishMaterial(item) {
      this.axios
        .post(apiURL + item.id)
        .then((response) => {
          item.checked = true;
          console.log(response);
          alert(
            "You've successfully finished these lessons. Continue learning in order to maintain your daily streak."
          );
          this.$emit("materialFinished");
        })
        .catch(() => {
          alert("You need to study materials with lower proficiency first!");
        });
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

p {
  color: black;
}

.chip-style {
  width: 118px !important;
  font-size: 13px;
  pointer-events: none;
  user-select: none;
}
</style>
