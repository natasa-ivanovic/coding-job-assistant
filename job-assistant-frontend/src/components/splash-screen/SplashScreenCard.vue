<template>
  <v-card elevation="10" class="mx-auto my-12" max-width="370">
    <v-img
      height="250"
      :src="info.image"
    ></v-img>
    <v-card-title>{{ info.title }}</v-card-title>
    <v-card-subtitle style="font-size: 15px">{{
      info.subtitle
    }}</v-card-subtitle>

    <v-card-text>
      <v-row style="text-align: justify">
        {{ info.description }}
      </v-row>
    </v-card-text>
	<v-card-text class="pt-0 pb-0">
		<v-stepper :value="info.step" class="elevation-0">
    		<v-stepper-header elevation="0">
				<v-stepper-step step="1" class="pt-0 pb-0 pl-2 pr-2">
				</v-stepper-step>
				<v-stepper-step step="2" class="pt-0 pb-0 pl-2 pr-2">
				</v-stepper-step>
				<v-stepper-step step="3" class="pt-0 pb-0 pl-2 pr-2">
				</v-stepper-step>
				<v-stepper-step step="4" class="pt-0 pb-0 pl-2 pr-2">
				</v-stepper-step>
    		</v-stepper-header>
  		</v-stepper>
	</v-card-text>
  </v-card>
</template>

<script>
const apiURL = "/api/job-offer/follow/";

export default {
  name: "SplashScreenCard",
  data: () => ({}),
  props: {
    info: Object,
  },
  methods: {},
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}

.card-background {
  background: rgb(238, 174, 209);
  background: radial-gradient(
    circle,
    rgba(238, 174, 209, 1) 14%,
    rgba(148, 187, 233, 1) 93%
  );
}
</style>
