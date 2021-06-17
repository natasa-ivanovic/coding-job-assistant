<template>
  <v-app>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
  }),
};
</script>

<style>
@font-face {
  font-family: "Baloo2";
  src: local("Baloo2"),
   url(./fonts/Baloo2/Baloo2-Regular.ttf) format("truetype");
}
</style>
