<template>
  <v-container fluid fill-height class="indigo accent-1">
    <v-container
      class="white">
      <v-row>
        <v-col no-gutters cols="12" md>
          <img src="../../assets/login.png" />
        </v-col>
        <v-col no-gutters cols="12" md>
          <RegisterForm />
        </v-col>
      </v-row>
    </v-container>
  </v-container>
</template>

<script>
import RegisterForm from "../../components/auth/RegisterForm.vue";
export default {
  name: "RegisterView",
  components: { RegisterForm },
};
</script>

<style scoped>
img {
  height: 100%;
  width: 100%;
}
</style>