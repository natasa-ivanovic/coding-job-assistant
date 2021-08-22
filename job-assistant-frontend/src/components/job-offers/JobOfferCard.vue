<template>
  <v-hover v-slot:default="{ hover }">
    <v-card elevation="8" class="mx-auto my-12" max-width="374">
      <v-img width="100%" height="120" src="@/assets/job-offer.jpg">
        <v-expand-transition>
          <div
            v-if="hover"
            class="
              d-flex
              transition-fast-in-fast-out
              black
              darken-3
              v-card--reveal
              display-1
              white--text
            "
            style="height: 100%"
          >
            {{ jobOffer.companyName }}
          </div>
        </v-expand-transition>
      </v-img>
      <v-card-title
        >{{ jobOffer.positionName }}<v-spacer /><v-icon
          :color="getColor(jobOffer.medal)"
          size="50"
          >mdi-medal</v-icon
        ></v-card-title
      >
      <v-card-subtitle style="font-size: 15px" class="black--text"
        >{{ jobOffer.companyName }}
      </v-card-subtitle>

      <div class="mt-2 ml-4 mr-4" style="text-align: justify">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus
        rutrum mi non dolor congue congue. Donec vestibulum nisi lectus.
      </div>

      <v-card-text>
        <v-chip-group
          v-model="jobOffer.seniority"
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
        <v-dialog v-model="dialog" width="900px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="indigo accent-1" v-bind="attrs" v-on="on" width="49%">
              Details
            </v-btn>
          </template>
          <job-offer-details-card
            v-bind:programmingImportances="jobOffer.programmingImportances"
            v-bind:technologyImportances="jobOffer.technologyImportances"
            v-bind:knowledgeImportances="jobOffer.knowledgeImportances"
            v-bind:softSkillImportances="jobOffer.softSkillImportances"
            v-bind:languageImportances="jobOffer.languageImportances"
          />
        </v-dialog>
        <v-spacer />
        <v-btn color="indigo accent-1" width="49%">
          Company
        </v-btn>
      </v-card-actions>
      <v-card-actions>
        <v-dialog v-model="dialogLeaderboard" width="600px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="purple" text width="100%" v-bind="attrs" v-on="on">
              <v-icon class="pl-0 ml-0 pr-3">mdi-seal</v-icon> Go To
              Leaderboard<v-icon class="pr-0 mr-0 pl-3">mdi-seal</v-icon>
            </v-btn>
          </template>
          <job-offer-leaderboard v-bind:jobOfferId="jobOffer.id" />
        </v-dialog>
      </v-card-actions>
    </v-card>
  </v-hover>
</template>

<script>
import JobOfferDetailsCard from "@/components/job-offers/JobOfferDetailsCard.vue";
import JobOfferLeaderboard from "@/components/job-offers/JobOfferLeaderboard.vue";

export default {
  name: "JobOfferCard",
  data: () => ({
    loading: false,
    position: "",
    dialog: false,
    dialogLeaderboard: false
  }),
  components: {
    JobOfferDetailsCard,
    JobOfferLeaderboard,
  },
  props: {
    jobOffer: Object,
  },
  methods: {
    getColor(color) {
      switch (color) {
        case "BRONZE":
          return "#A55131";
        case "SILVER":
          return "grey";
        case "GOLD":
          return "yellow darken-2";
      }
      return "white";
    },
  },
};
</script>

<style scoped>
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

.custom-chip {
  flex: 1;
  justify-content: center;
}

.chip-disabled {
  pointer-events: none;
  user-select: none;
}
</style>
