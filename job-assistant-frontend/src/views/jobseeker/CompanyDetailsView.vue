<template>
  <v-card elevation="8" class="mx-auto my-12" max-width="1200px">
    <v-layout justify-center align-center>
      <v-flex shrink>
        <v-img
          width="300px"
          height="300px"
          class="justify-center"
          src="@/assets/splash-classroom.jpg"
        >
        </v-img>
      </v-flex>
    </v-layout>
    <v-card-title
      class="justify-center description mb-5 pb-5"
      style="font-size:60px"
      >{{ company.name }}
    </v-card-title>
    <v-card-text
      class="ml-7 mr-16 pr-16"
      style="text-align: justify; color:black; font-size: 15px"
    >
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rutrum
      mi non dolor congue congue. Donec vestibulum nisi lectus. Lorem ipsum
      dolor sit amet, consectetur adipiscing elit. Phasellus rutrum mi non dolor
      congue congue. Donec vestibulum nisi lectus. Lorem ipsum dolor sit amet,
      consectetur adipiscing elit. Phasellus rutrum mi non dolor congue congue.
      Donec vestibulum nisi lectus. Lorem ipsum dolor sit amet, consectetur
      adipiscing elit. Phasellus rutrum mi non dolor congue congue. Donec
      vestibulum nisi lectus. Lorem ipsum dolor sit amet, consectetur adipiscing
      elit. Phasellus rutrum mi non dolor congue congue. Donec vestibulum nisi
      lectus.
    </v-card-text>
    <v-card-title v-if="company['benefits']" class="ml-7"
      >Benefits that we offer</v-card-title
    >
    <v-card-text
      v-if="company['benefits']"
      class="ml-7 mr-7"
      style="color:black"
    >
      <v-row v-for="b in company['benefits']" :key="b.id">
        <v-icon class="pr-5">mdi-star-shooting</v-icon> {{ b.name }}
      </v-row>
    </v-card-text>
    <v-card-actions class="ml-9 mr-9">
      <v-dialog v-model="dialog" width="900px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" v-bind="attrs" v-on="on" block outlined>
            Leave a review
          </v-btn>
        </template>
        <company-review-form v-bind:companyId="company['id']" />
      </v-dialog>
    </v-card-actions>
    <v-card-title v-if="company['offers']" class="ml-7 mb-0 pb-0"
      >Active job offers</v-card-title
    >
    <v-row v-if="company['offers']" class="ml-9 mr-9">
      <v-col
        style="flex: 1;"
        sm="12"
        md="6"
        lg="4"
        v-for="jo in company['offers']"
        :key="jo.id"
      >
        <job-offer-card v-bind:jobOffer="jo" v-bind:company="true" />
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import JobOfferCard from "@/components/job-offers/JobOfferCard.vue";
import CompanyReviewForm from "@/components/rating/CompanyReviewForm.vue";
const apiURL = "/api/company/details/";

export default {
  name: "CompanyDetailsView",
  components: {
    JobOfferCard,
    CompanyReviewForm,
  },
  props: {
    id: Number,
  },
  data() {
    return {
      company: Object,
      dialog: false,
    };
  },
  mounted() {
    this.getCompany();
  },
  methods: {
    getCompany() {
      this.axios
        .get(apiURL + this.id)
        .then((response) => {
          this.company = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
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
.v-card--reveal {
  align-items: center;
  bottom: 0;
  justify-content: center;
  opacity: 0.6;
  position: absolute;
  width: 100%;
}

.description {
  font-family: "Baloo2", Helvetica, Arial;
}
</style>
