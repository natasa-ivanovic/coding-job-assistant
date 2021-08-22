<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-alert type="info"
          >Changing data on this page will trigger a rule re-compile, so try to
          make all your changes at once!</v-alert
        >
        <v-form ref="form">
          <v-card>
            <v-card-title> Company status configuration </v-card-title>
            <v-list>
              <v-list-item
                v-for="el in this.elements.companyStatusList"
                :key="el.id"
              >
                <v-list-item-title class="titleFlex"
                  >Requirements for {{ toPrettyText(el.companyMedal) }} medal
                </v-list-item-title>
                <v-text-field
                  v-model="el.totalReviews"
                  label="Total reviews required"
                  :readonly="!editing"
                  class="mr-4 elementFlex"
                />
                <v-text-field
                  v-model="el.totalHired"
                  label="Hired reviews required"
                  :readonly="!editing"
                  class="mr-4 elementFlex"
                />
                <v-text-field
                  v-model="el.averageRating"
                  label="Average rating required"
                  :readonly="!editing"
                  class="mr-4 elementFlex"
                />
                <v-text-field
                  v-model="el.ratedPositiveDifference"
                  label="Min positive/negative review ratio"
                  :readonly="!editing"
                  class="mr-4 differenceFlex"
                />
              </v-list-item>
            </v-list>
          </v-card>
          <v-card class="mt-5">
            <v-card-title> Job Offer status configuration </v-card-title>
            <v-list>
              <v-list-item
                v-for="el in this.elements.jobOfferStatusList"
                :key="el.id"
              >
                <v-list-item-title class="titleFlex"
                  >Requirements for {{ toPrettyText(el.offerMedal) }} medal
                </v-list-item-title>
                <v-text-field
                  v-model="el.companyMedal"
                  label="Required Company medal"
                  :readonly="!editing"
                  class="mr-4 elementFlex"
                />
                <v-text-field
                  v-model="el.totalFollowers"
                  label="Total followers required"
                  :readonly="!editing"
                  class="mr-4 elementFlex"
                />
                <v-text-field
                  v-model="el.daysSincePosted"
                  label="Maximum days since posted"
                  :readonly="!editing"
                  class="mr-4 elementFlex"
                />
              </v-list-item>
            </v-list>
          </v-card>
          <v-card class="mt-5">
            <v-card-title> Benefits configuration </v-card-title>
            <v-list>
              <v-list-item
                v-for="el in this.elements.benefitsList"
                :key="el.id"
              >
                <v-list-item-title class="titleFlex"
                  >{{ el.name }}
                </v-list-item-title>
                <v-text-field
                  v-model="el.description"
                  label="Benefit description"
                  :readonly="!editing"
                  class="mr-4 benefitDescriptionFlex"
                />
                <v-text-field
                  v-model="el.levelImportance"
                  label="Level of importance"
                  :readonly="!editing"
                  class="mr-4 elementFlex"
                />
              </v-list-item>
            </v-list>
          </v-card>
        </v-form>
        <div v-if="!editing">
          <v-row>
            <v-col class="pl-0 pr-0">
              <v-btn
                block
                color="info"
                class="mt-4 pl-0 pr-0"
                height="50px"
                @click="startEditing()"
              >
                Make changes
              </v-btn>
            </v-col>
          </v-row>
        </div>
        <div v-else>
          <v-row>
            <v-col class="pl-0">
              <v-btn
                block
                color="success"
                class="mt-4 pl-0"
                height="50px"
                @click="saveChanges()"
              >
                Save changes
              </v-btn>
            </v-col>
            <v-col class="pr-0">
              <v-btn
                block
                color="error"
                class="mt-4 pr-0"
                height="50px"
                @click="cancelEdit()"
              >
                Discard changes
              </v-btn>
            </v-col>
          </v-row>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/config";

export default {
  name: "ConfigListView",
  components: {},
  data() {
    return {
      elements: {},
      //   companyStatusList, jobOfferStatusList
      rules: {
        required: (value) => !!value || "Field is required.",
        positiveValue: (value) => value > 0 || "Value must be positive!",
      },
      valid: true,
      editing: false,
      elementsSnapshot: {},
      loading: false,
      benefitsList: [
        {
          id: 1,
          name: "Neki benefit",
          description: "Opisan opis",
          levelImportance: 10,
        },
        {
          id: 2,
          name: "Neki 2. benefit",
          description: "Opisan opis",
          levelImportance: 10,
        },
        {
          id: 3,
          name: "Neki benefit 3",
          description: "Opisan opiseeee",
          levelImportance: 20,
        },
        {
          id: 4,
          name: "Neki 4. benefit",
          description: "Opisan opisaaa",
          levelImportance: 15,
        },
      ],
    };
  },

  mounted() {
    this.getElements();
  },

  methods: {
    getElements() {
      this.axios
        .get(apiURL)
        .then((response) => {
          this.elements = response.data;
          this.elements.benefitsList = this.benefitsList;
        })
        .catch((error) => {
          this.$root.snackbar.warning(error);
        });
    },

    toPrettyText(text) {
      return text.substring(0, 1) + text.substring(1).toLowerCase();
    },

    startEditing() {
      this.editing = true;
      this.elementsSnapshot = Object.assign({}, this.elements);
    },

    cancelEdit() {
      this.elements = Object.assign({}, this.elementsSnapshot);
      this.elementsSnapshot = {};
      this.editing = false;
    },

    saveChanges() {
      this.$refs.form.validate();
      if (!this.valid) {
        return;
      }
      this.loading = true;
      console.log(this.loading);
      this.axios({
        url: apiURL,
        method: "PUT",
        data: this.elements,
      })
        .then(() => {
          this.$root.snackbar.success("Successfully edited configuration!");
          this.loading = false;
        })
        .catch((error) => {
          this.$root.snackbar.error(error.response.data.message);
          this.loading = false;
        });
    },
  },
};
</script>

<style scoped>
.titleFlex {
  flex: 2 1 30%;
}
.differenceFlex {
  flex: 1 1 20%;
}
.elementFlex {
  flex: 1 1 auto;
}
.benefitDescriptionFlex {
  flex: 3 1 50%;
}
</style>