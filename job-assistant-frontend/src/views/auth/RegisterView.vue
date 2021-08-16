<template>
  <v-container
    fluid
    fill-height
    class="main-screen"
    style="justify-content: center;"
  >
    <div>
      <v-row>
        <v-col cols="12">
          <RegisterForm />
        </v-col>
      </v-row>
    </div>
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
.main-screen {
  background: rgb(238, 174, 209);
  background: radial-gradient(
    circle,
    rgba(238, 174, 209, 1) 14%,
    rgba(148, 187, 233, 1) 93%
  );
}
</style>
