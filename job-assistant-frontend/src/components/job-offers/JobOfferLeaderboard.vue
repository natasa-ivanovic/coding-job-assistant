<template>
  <v-card width="600px" height="800px">
    <v-layout justify-center align-center>
      <v-flex shrink>
        <v-img
          class="justify-center"
          height="200px"
          width="200px"
          src="@/assets/cup.png"
        ></v-img>
      </v-flex>
    </v-layout>

    <v-card-title class="justify-center description" style="font-size: 40px"
      >Leaderboard</v-card-title
    >

    <v-row class="ml-9 mr-9">
      <v-progress-linear
        indeterminate
        color="indigo accent-1"
        :active="show"
      ></v-progress-linear>
    </v-row>

    <v-data-table
      :headers="headers"
      :items="followers"
      :items-per-page="4"
      class="mr-5 ml-5"
    >
      <template v-slot:[`item.user`]="{ item }">
        <v-icon
          v-if="checkUser(item)"
          size="30"
          >mdi-arrow-right-bold</v-icon
        >
        <p v-else class="mt-1 mb-0 pb-0">{{ item.rowNumber }}</p>
      </template>

      <template v-slot:[`item.rowNumber`]="{ item }">
        <v-icon
          v-if="item.rowNumber < 4"
          :color="getColor(item.rowNumber)"
          size="30"
          >mdi-medal</v-icon
        >
        <p v-else></p>
      </template>

      <template v-slot:[`item.continuousLearning`]="{ item }">
        <v-icon
          v-if="item.continuousLearning"
          size="30"
          color="green"
          >mdi-head-lightbulb</v-icon
        >
      </template>
    </v-data-table>
  </v-card>
</template>

<script>
const apiURL = "/api/job-offer/leaderboard/";

export default {
  name: "JobOfferLeaderboard",
  data: () => ({
    show: false,
    followers: [],
    headers: [
      { text: "", value: "user", align:"center"},
      { text: "Position", value: "rowNumber" },
      { text: "Name", value: "name" },
      { text: "Surname", value: "surname" },
      { text: "Daily learner", value: "continuousLearning", align:"center" },
    ],
  }),
  props: {
    jobOfferId: Number,
  },
  mounted() {
    this.getFollowers();
  },
  methods: {
    getFollowers() {
      this.show = true;
      this.axios
        .get(apiURL + this.jobOfferId)
        .then((response) => {
          console.log(response);
          this.followers = this.addRowNumbers(response.data);
          this.show = false;
        })
        .catch((error) => {
          this.$root.snackbar.error(error.response.data.message);
          this.show = false;
        });
    },
    addRowNumbers(users) {
      for (let i = 0; i < users.length; i++) {
        users[i].rowNumber = i + 1;
      }
      return users;
    },
    getColor(item) {
      switch (item) {
        case 1:
          return "yellow darken-2";
        case 2:
          return "grey";
        case 3:
          return "#A55131";
      }
    },
    checkUser: function(item) {
      let user = JSON.parse(localStorage.getItem("user"));
      return item.id == user.id ? true : false;
    },
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}

</style>
