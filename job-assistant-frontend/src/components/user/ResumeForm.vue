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

          <v-list-item-content style="flex: 2">
            <v-slider
              v-model="p.proficiency"
              :tick-labels="labels"
              min="1"
              max="5"
              ticks="always"
              tick-size="5"
              :readonly="!editing"
            >
            </v-slider>
          </v-list-item-content>
          <v-list-item-icon>
            <v-btn :disabled="!editing" icon @click="deleteItem(p.id)">
              <v-icon v-show="editing"> mdi-delete </v-icon>
            </v-btn>
          </v-list-item-icon>
        </v-list-item>
        <v-list-item v-if="editing">
          <v-list-item-avatar>
            <v-img :src="getPicture(newElement.elementType)"></v-img>
          </v-list-item-avatar>
          <v-list-item-content>
            <v-autocomplete
              v-model="newElement.elementType"
              placeholder="Type"
              :items="cvElementTypes"
            />
          </v-list-item-content>

          <v-list-item-content class="ml-2">
            <v-autocomplete
              v-model="newElement.elementName"
              placeholder="Element"
              :items="getElementsForType(newElement.elementType)"
              item-text="name"
              item-value="value"
              :rules="[rules.required]"
            />
          </v-list-item-content>

          <v-list-item-content class="ml-2">
            <v-autocomplete
              v-model="newElement.proficiency"
              placeholder="Proficiency"
              :items="possibleProficiencies"
              :rules="[rules.required]"
            >
            </v-autocomplete>
          </v-list-item-content>
          <v-list-item-icon>
            <v-btn icon @click="addItem(newElement)">
              <v-icon> mdi-check </v-icon>
            </v-btn>
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
const apiURL = "/api/users/my-profile/resume";
const apiCVElements = "/api/cv-elements/by-type";

export default {
  name: "ResumeForm",
  data() {
    return {
      valid: true,
      loading: false,
      editing: false,
      proficiencies: [],
      rules: {
        required: (value) => !!value || "Field is required.",
      },
      labels: ["Basic", "Good", "Very good", "Excellent", "Expert"],
      newElement: {
        elementType: "PROGRAMMING_LANGUAGE",
        elementName: "",
        id: 0,
        proficiency: 0,
      },
      cvElements: {},
      cvElementTypes: [
        {
          text: "Programming language",
          value: "PROGRAMMING_LANGUAGE",
        },
        {
          text: "Technology",
          value: "TECHNOLOGY",
        },
        {
          text: "Knowledge",
          value: "KNOWLEDGE",
        },
        {
          text: "Language",
          value: "LANGUAGE",
        },
        {
          text: "Soft skill",
          value: "SOFT_SKILL",
        },
      ],
      possibleProficiencies: [
        {
          text: "Basic",
          value: "1",
        },
        {
          text: "Good",
          value: "2",
        },
        {
          text: "Very good",
          value: "3",
        },
        {
          text: "Excellent",
          value: "4",
        },
        {
          text: "Expert",
          value: "5",
        },
      ],
    };
  },
  mounted: function () {
    this.getResume();
    this.getAllCvElements();
  },
  methods: {
    getResume: function () {
      this.axios({
        url: apiURL,
        method: "GET",
      }).then((response) => {
        this.proficiencies = response.data.proficiencies;
        this.proficiencies.forEach((p) => {
          p.proficiency = this.proficiencyEnumToNumber(p.proficiency);
        });
        this.proficiencies.sort(this.elementTypeSort);
      });
    },
    getAllCvElements: function () {
      this.axios({
        url: apiCVElements,
        method: "GET",
      }).then((response) => {
        this.cvElements = response.data;
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
    getElementsForType: function (type) {
      const elements = this.cvElements[type];
      const availableElements = elements.filter((el) => {
        let exists = false;
        this.proficiencies.forEach((p) => {
          if (p.elementName == el.name) exists = true;
        });
        return !exists;
      });
      return availableElements;
    },
    addItem: function (newItem) {
      this.$refs.form.validate();
      if (!this.valid) {
        return;
      }
      const itemId = this.cvElements[newItem.elementType].find(
        (el) => el.name == newItem.elementName
      ).id;
      const itemToAdd = Object.assign({}, newItem);
      itemToAdd.id = (itemId - 1) * 5 + parseInt(newItem.proficiency);
      // reset newItem
      this.newElement.elementType = "PROGRAMMING_LANGUAGE";
      this.newElement.elementName = "";
      this.newElement.proficiency = 0;
      this.proficiencies.push(itemToAdd);
      this.$refs.form.resetValidation();
    },
    deleteItem: function (id) {
      this.proficiencies = this.proficiencies.filter((item) => item.id != id);
    },
    startEditing: function () {
      this.profSnapshot = [];
      this.proficiencies.forEach((el) => {
        this.profSnapshot.push(Object.assign({}, el));
      });
      this.editing = true;
    },
    saveChanges: function () {
      let changedProf = Object.assign([], this.proficiencies);
      this.loading = true;
      this.axios({
        url: apiURL,
        method: "PUT",
        data: { proficiencies: changedProf },
      }).then(() => {
        this.proficiencies.sort(this.elementTypeSort);
        this.editing = false;
        this.loading = false;
      });
    },
    discardChanges: function () {
      this.proficiencies = Object.assign([], this.profSnapshot);
      this.profSnapshot = [];
      this.editing = false;
    },
    elementTypeEnumToNumber: function (enumValue) {
      switch (enumValue) {
        case "PROGRAMMING_LANGUAGE":
          return 0;
        case "TECHNOLOGY":
          return 1;
        case "KNOWLEDGE":
          return 2;
        case "LANGUAGE":
          return 3;
        case "SOFT_SKILL":
          return 4;
      }
    },
    elementTypeSort: function (e1, e2) {
      if (e1.elementType == e2.elementType) {
        return e1.elementName > e2.elementName ? 1 : -1;
      } else {
        return (this.elementTypeEnumToNumber(e1.elementType) >this.elementTypeEnumToNumber(e2.elementType)) ? 1 : -1;
      }
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
