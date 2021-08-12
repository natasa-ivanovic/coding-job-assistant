<template>
  <v-container fill-height align="center" justify="center">
    <v-form v-model="valid" ref="form" style="flex: 1">
      <v-list>
        <v-list-item v-for="p in proficiencies" :key="p.id">
          <v-list-item-avatar>
            <v-img :src="getPicture(p.elementType)"></v-img>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="p.elementName"></v-list-item-title>
          </v-list-item-content>

          <v-list-item-content>
            <v-slider
              v-model="p.proficiency"
              :tick-labels="labels"
              min="1"
              max="5"
              ticks="always"
              tick-size="5"
              :readonly="!editing"
              thumb-label="always"
            >
            </v-slider>
          </v-list-item-content>
          <v-list-item-icon>
            <v-btn icon @click="deleteItem(p.id)"> <v-icon> mdi-delete </v-icon> </v-btn>
          </v-list-item-icon>
        </v-list-item>
        <v-row v-if="!editing">
          <v-col>
            <v-btn
              color="#8C9EFF"
              @click="startEditing()"
              block
              class="description"
              style="font-size: 15px"
              :loading="loading"
              ><b>Edit details</b></v-btn
            >
          </v-col>
        </v-row>
        <v-row v-else>
          <v-col>
            <v-btn
              color="success"
              @click="saveChanges()"
              block
              class="description"
              style="font-size: 15px"
              :loading="loading"
              ><b>Save changes</b></v-btn
            >
          </v-col>
          <v-col>
            <v-btn
              color="error"
              @click="discardChanges()"
              block
              class="description"
              style="font-size: 15px"
              :loading="loading"
              ><b>Discard changes</b></v-btn
            >
          </v-col>
        </v-row>
      </v-list>
    </v-form>
  </v-container>
</template>
<script>
const apiURL = "/users/my-profile";

export default {
  name: "ResumeForm",
  data() {
    return {
      valid: true,
      loading: false,
      editing: false,
      proficiencies: [],
      labels: [
        "Basic",
        "Good",
        "Very good",
        "Excellent",
        "Expert",
      ],
    };
  },
  mounted: function () {
    this.getResume();
  },
  methods: {
    getResume: function () {
      this.axios({
        url: apiURL + "/resume",
        method: "GET",
      }).then((response) => {
        this.proficiencies = response.data.proficiencies;
        this.proficiencies.forEach((p) => {
          p.proficiency = this.proficiencyEnumToNumber(p.proficiency);
        });
      });
    },
    proficiencyEnumToNumber: function (enumValue) {
      switch (enumValue) {
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
    getPicture: function (type) {
      switch (type) {
        case "PROGRAMMING_LANGUAGE":
          return require("@/assets/icon-small-prog-lang.png");
        case "TECHNOLOGY":
          return require("@/assets/icon-small-technology.png");
        case "KNOWLEDGE":
          return require("@/assets/icon-small-knowledge.png");
        case "LANGUAGE":
          return require("@/assets/icon-small-language.png");
        case "SOFT_SKILL":
          return require("@/assets/icon-small-soft-skill.png");
      }
    },
    deleteItem: function (id) {
      this.proficiencies = this.proficiencies.filter((item) => item.id != id);
    },
    startEditing: function () {
      this.profSnapshot = Object.assign({}, this.proficiencies);
      this.editing = true;
    },
    saveChanges: function () {
      let changedProf = Object.assign({}, this.proficiencies);
      this.loading = true;
      this.axios({
        url: apiURL + "/resume",
        method: "PUT",
        data: changedProf,
      }).then(() => {
        this.editing = false;
        this.loading = false;
      });
    },
    discardChanges: function () {
      this.proficiencies = Object.assign({}, this.profSnapshot);
      this.profSnapshot = {};
      this.editing = false;
    },
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
  font-size: 18px;
}
</style>
