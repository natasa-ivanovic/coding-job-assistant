<template>
  <v-container fill-height align="center" justify="center">
    <v-form v-model="valid" ref="form" style="flex: 1">
      <v-list>
        <div v-for="e in experiences" :key="e.id">
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title v-text="e.positionName"></v-list-item-title>
            </v-list-item-content>
            <v-list-item-content style="flex: 2">
              <v-slider
                v-model="e.seniority"
                :tick-labels="labels"
                min="1"
                max="3"
                ticks="always"
                tick-size="3"
                :readonly="!editing"
              >
              </v-slider>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content style="flex: 4">
              <v-autocomplete
                v-model="e.cvElements"
                :items="cvElements"
                item-text="name"
                return-object
                multiple
                :readonly="!editing"
                :rules="[rules.nonEmptyArray]"
              >
                <template v-slot:item="data">
                  {{ data.item.name + " (" + data.item.group + ")" }}
                </template>
              </v-autocomplete>
            </v-list-item-content>
            <v-list-item-content class="ml-4 mr-2" style="flex: 1">
              <v-text-field
                v-model="e.months"
                placeholder="Months worked"
                type="number"
                suffix=" months"
                :readonly="!editing"
                :rules="[rules.required, rules.positiveNumber]"
              />
            </v-list-item-content>
            <v-list-item-icon>
              <v-btn :disabled="!editing" icon @click="deleteItem(e.id)">
                <v-icon v-show="editing"> mdi-delete </v-icon>
              </v-btn>
            </v-list-item-icon>
          </v-list-item>
          <v-divider class="ml-4 mr-4" />
        </div>

        <div v-if="editing">
          <v-list-item>
            <v-list-item-content>
              <v-autocomplete
                v-model="newElement.positionName"
                :items="jobPositions"
                placeholder="Job title"
                :rules="[rules.required]"
                item-text="title"
                item-value="title"
              />
            </v-list-item-content>
            <v-list-item-content style="flex: 2" class="ml-2">
              <v-slider
                v-model="newElement.seniority"
                :tick-labels="labels"
                min="1"
                max="3"
                ticks="always"
                tick-size="3"
                :readonly="!editing"
              >
              </v-slider>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content style="flex: 4">
              <v-autocomplete
                placeholder="Used skills"
                v-model="newElement.cvElements"
                :items="cvElements"
                item-text="name"
                return-object
                multiple
                :rules="[rules.nonEmptyArray]"
                :readonly="!editing"
              >
                <template v-slot:item="data">
                  {{ data.item.name + " (" + data.item.group + ")" }}
                </template>
              </v-autocomplete>
            </v-list-item-content>
            <v-list-item-content class="ml-4 mr-2" style="flex: 1">
              <v-text-field
                v-model="newElement.months"
                placeholder="Months worked"
                type="number"
                suffix=" months"
                :readonly="!editing"
                :rules="[rules.required, rules.positiveNumber]"
              />
            </v-list-item-content>
            <v-list-item-icon>
              <v-btn icon @click="addItem(newElement)">
                <v-icon v-show="editing"> mdi-check </v-icon>
              </v-btn>
            </v-list-item-icon>
          </v-list-item>
        </div>
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
const apiURL = "/api/users/my-profile/experience";
const apiCVElements = "/api/cv-elements/by-type";
const apiJobPosition = "/api/job-position";

export default {
  name: "ExperienceForm",
  data() {
    return {
      valid: true,
      loading: false,
      editing: false,
      experiences: [],
      rules: {
        required: (value) => !!value || "Field is required.",
        positiveNumber: (value) => value > 0 || "Months must be positive.",
        nonEmptyArray: (value) =>
          value.length > 0 || "You must select at least one skill.",
      },
      labels: ["Junior", "Medior", "Senior"],
      newElement: {
        id: 0,
        months: 0,
        seniority: 1,
        positionName: "",
        cvElements: [],
      },

      possibleSeniorities: [
        {
          text: "Junior",
          value: "1",
        },
        {
          text: "Medior",
          value: "2",
        },
        {
          text: "Senior",
          value: "3",
        },
      ],
      cvElements: [],
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
      jobPositions: [],
    };
  },
  mounted: function () {
    this.getExperience();
    this.getAllCvElements();
    this.getAllJobPositions();
  },
  methods: {
    getExperience: function () {
      this.axios({
        url: apiURL,
        method: "GET",
      }).then((response) => {
        this.experiences = response.data.workingExperience;
        this.experiences.forEach((e) => {
          e.seniority = this.seniorityEnumToNumber(e.seniority);
        });
      });
    },
    getAllCvElements: function () {
      this.axios({
        url: apiCVElements,
        method: "GET",
      }).then((response) => {
        const cvElementsByType = response.data;
        let newCvElements = [];
        const selectedTypes = [
          "PROGRAMMING_LANGUAGE",
          "TECHNOLOGY",
          "KNOWLEDGE",
        ];
        selectedTypes.forEach((type) => {
          const header = this.prettyHeader(type);
          newCvElements.push({ header });
          cvElementsByType[type].forEach((element) => {
            let item = { ...element, group: header };
            newCvElements.push(item);
          });
          newCvElements.push({ divider: true });
        });
        this.cvElements = newCvElements;
      });
    },
    getAllJobPositions: function () {
      this.axios({
        url: apiJobPosition,
        method: "GET",
      }).then((response) => {
        this.jobPositions = response.data;
      });
    },
    prettyHeader: function (header) {
      return (
        header.charAt(0) +
        header
          .substring(1, header.length + 1)
          .replace("_", " ")
          .toLowerCase()
      );
    },
    seniorityEnumToNumber: function (el) {
      switch (el) {
        case "JUNIOR":
          return 1;
        case "MEDIOR":
          return 2;
        case "SENIOR":
          return 3;
      }
    },
    addItem: function (newItem) {
      this.$refs.form.validate();
      if (!this.valid) {
        return;
      }
      let maxItemId = 1
      if (this.experiences.length != 0)
        maxItemId = this.experiences.reduce((cur, max) =>  cur.id > max.id ? cur : max).id;
      const itemToAdd = Object.assign({}, newItem);
      itemToAdd.id = maxItemId + 1;
      // reset newItem
      this.newElement.id = 0;
      this.newElement.seniority = 1;
      this.newElement.positionName= "";
      this.newElement.cvElements = [];
      this.experiences.push(itemToAdd);
      this.$refs.form.resetValidation();
    },
    deleteItem: function (id) {
      this.experiences = this.experiences.filter((item) => item.id != id);
    },
    startEditing: function () {
      this.snapshot = [];
      this.experiences.forEach((el) => {
        this.snapshot.push(Object.assign({}, el));
      });
      this.editing = true;
    },
    saveChanges: function () {
      let changedExp = Object.assign([], this.experiences);
      this.loading = true;
      this.axios({
        url: apiURL,
        method: "PUT",
        data: { workingExperience: changedExp },
      }).then(() => {
        this.editing = false;
        this.loading = false;
      });
    },
    discardChanges: function () {
      this.experiences = Object.assign([], this.snapshot);
      this.snapshot = [];
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
