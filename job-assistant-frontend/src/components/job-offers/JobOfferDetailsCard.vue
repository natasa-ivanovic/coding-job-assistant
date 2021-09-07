<template>
  <v-card width="1200px" height="800px">
    <v-layout justify-center align-center>
      <v-flex shrink>
        <v-img
          class="justify-center"
          height="250px"
          width="450px"
          src="@/assets/offer-details.jpg"
        ></v-img>
      </v-flex>
    </v-layout>
    <v-card-title style="font-size: 30px">{{jobOffer.positionName}}, {{jobOffer.companyName}}</v-card-title>
    <div class="mt-2 ml-6 mr-6 mb-4" style="text-align: justify">
      {{ jobOffer.description }}
    </div>
    <div>
      <v-tabs v-model="tab" centered slider-color="blue" class="mb-5">
        <v-tab v-if="programmingImportances">Programming languages</v-tab>
        <v-tab v-if="technologyImportances">Technologies</v-tab>
        <v-tab v-if="knowledgeImportances">Knowledge</v-tab>
        <v-tab v-if="softSkillImportances">Soft skills</v-tab>
        <v-tab v-if="languageImportances">Languages</v-tab>
      </v-tabs>
      <v-tabs-items v-model="tab">
        <v-tab-item>
          <div v-if="programmingImportances">
            <job-offer-details-table v-bind:importances="programmingImportances"/>
          </div>
        </v-tab-item>
        <v-tab-item>
          <div v-if="technologyImportances">
            <job-offer-details-table v-bind:importances="technologyImportances"/>
          </div>
        </v-tab-item>
        <v-tab-item>
          <div v-if="knowledgeImportances">
            <job-offer-details-table v-bind:importances="knowledgeImportances"/>
          </div>
        </v-tab-item>
        <v-tab-item>
          <div v-if="softSkillImportances">
            <job-offer-details-table v-bind:importances="softSkillImportances"/>
          </div>
        </v-tab-item>
        <v-tab-item>
          <div v-if="languageImportances">
            <job-offer-details-table v-bind:importances="languageImportances"/>
          </div>
        </v-tab-item>
      </v-tabs-items>
    </div>
  </v-card>
</template>

<script>
import RequirementRatingComponent from "../rating/RequirementRatingComponent.vue";
import JobOfferDetailsTable from "./JobOfferDetailsTable.vue";

export default {
  name: "JobOfferDetailsCard",
  components: {
    RequirementRatingComponent,
    JobOfferDetailsTable
  },
  data: () => ({
    loading: false,
    position: "",
    tab: 0,
    
  }),
  props: {
    programmingImportances: Array,
    technologyImportances: Array,
    knowledgeImportances: Array,
    softSkillImportances: Array,
    languageImportances: Array,
    jobOffer: Object,
    // importance ima ovo
    // private String cvElementName;
    // private CVElementType cvElementType;
    // private SkillProficiency proficiency;
    // private boolean optional;
    // private int importanceLevel;
  },
  methods: {
    getValue(proficiency) {
      switch (proficiency) {
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
    },
    getDescription(importance) {
      let name = importance["cvElementName"];
      let value = importance["proficiency"];
      let desc = { name, value };
      return desc;
    },
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
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
