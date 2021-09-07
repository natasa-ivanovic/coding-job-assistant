<template>
  <v-hover v-slot:default="{ hover }">
    <v-card elevation="8" class="mx-auto my-12" max-width="374" >
      <v-img width="100%" height="200" src="@/assets/company.jpg">
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
            {{ company.name }}
          </div>
        </v-expand-transition>
      </v-img>
      <v-card-title class="mb-0 pb-0"
        >{{ company.name }}<v-spacer /><v-icon
          :color="getColor(company.medal)"
          size="50"
          >mdi-medal</v-icon
        ></v-card-title
      >
      <v-card-text class="mt-0 pt-0">
        <v-icon small color="yellow darken-1">mdi-star</v-icon>
        {{ company.rating.toFixed(2) }}
      </v-card-text>
      <v-divider class="ml-4 mr-4"></v-divider>
      <div class="mt-2 ml-4 mr-4" style="text-align: justify">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus
        rutrum mi non dolor congue congue. Donec vestibulum nisi lectus.
      </div>

      <div class="mt-2 ml-4 mr-4" style="text-align: justify">
        <b>Currently active offers:</b> {{ company.offersNumber }}
      </div>

      <v-card-actions>
        <v-btn color="primary" block outlined @click="goToCompany()">
          Explore Company
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-hover>
</template>

<script>
export default {
  name: "CompanyCard",
  props: {
    company: Object,
  },
  data() {
    return {};
  },
  methods: {
    goToCompany() {
      this.$router.push({name: "CompanyDetailsView", params: {id: this.company.id}});
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
</style>
