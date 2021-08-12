<template>
  <v-container fill-height align="center" justify="center">
    <v-form v-model="valid" ref="form" style="flex: 1">
      <!-- <v-row>
        <v-col>
          <v-text-field
            v-model="user.username"
            :rules="[rules.email, rules.required]"
            readonly
            label="Username"
            prepend-icon="mdi-card-account-mail"
            type="text"
            class="description"
            :disabled="editing"
          />
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-text-field
            v-model="user.name"
            :rules="[rules.required]"
            label="Name"
            prepend-icon="mdi-card-account-details"
            type="text"
            class="description"
            :readonly="!editing"
          />
        </v-col>
        <v-col>
          <v-text-field
            v-model="user.surname"
            :rules="[rules.required]"
            label="Surname"
            prepend-icon="mdi-card-account-details-star"
            type="text"
            class="description"
            :readonly="!editing"
          />
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-slider
            v-model="user.education"
            prepend-icon="mdi-school"
            :max="4"
            tick-size="5"
            :tick-labels="educationLabels"
            class="description"
            :readonly="!editing"
          />
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-text-field
            v-model="user.salaryExpectation"
            :rules="[rules.required]"
            label="Salary expectation"
            prepend-icon="mdi-cash"
            suffix="€"
            type="number"
            class="description"
            :readonly="!editing"
          />
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-checkbox
            v-model="user.remoteWork"
            label="Remote work"
            prepend-icon="mdi-home-account"
            color="black"
            :readonly="!editing"
          />
        </v-col>
      </v-row>
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
      </v-row> -->
    </v-form>
  </v-container>
</template>
<script>
const apiURL = "/users/my-profile";

export default {
  name: "ResumeForm",
  data() {
    return {
        valid: true
    };
  },
  mounted: function () {
    this.getProfile();
  },
  methods: {
    getProfile: function () {
    //   this.axios({
    //     url: apiURL + "/resume",
    //     method: "GET",
    //   }).then((response) => {
    //     this.user = response.data;
    //     this.user.education = this.educationEnumToNumber(
    //       response.data.education
    //     );
    //     console.log(this.user.education);
    //   });
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
