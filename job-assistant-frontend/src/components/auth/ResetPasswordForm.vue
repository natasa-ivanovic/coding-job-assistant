<template>
  <v-container>
    <v-row class="description" style="font-size: 50px" justify="center"
      >Reset your password
    </v-row>
    <v-form v-model="valid" ref="form">
      <v-row>
        <v-text-field
          id="custom-css-input"
          filled
          v-model="username"
          ref="username"
          label="Username"
          style="font-size: 18px"
          :rules="[rules.required, rules.email]"
          required
        />
      </v-row>
      <v-row>
        <v-text-field
          id="custom-css-input"
          filled
          v-model="password"
          ref="password"
          label="Password"
          style="font-size: 18px"
          :rules="[
            rules.required,
            rules.counter,
            rules.lowerCase,
            rules.upperCase,
            rules.digit,
            rules.specialCharacter,
          ]"
          :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
          :type="showPassword ? 'text' : 'password'"
          @click:append="showPassword = !showPassword"
          required
        />
      </v-row>
      <v-row>
        <v-text-field
          filled
          v-model="confirmPassword"
          label="Confirm password"
          style="font-size: 18px"
          :rules="[rules.required, rules.counter, rules.passwordMatch]"
          :append-icon="showConfirmPassword ? 'mdi-eye' : 'mdi-eye-off'"
          :type="showConfirmPassword ? 'text' : 'password'"
          @click:append="showConfirmPassword = !showConfirmPassword"
          required
        />
      </v-row>
      <v-row>
        <v-btn
          @click="resetPassword()"
          color="#8C9EFF"
          block
          class="description"
          style="font-size: 15px"
          :loading="loading"
        >
          <b>Reset password</b>
        </v-btn>
      </v-row>
    </v-form>
    <v-row justify="center" class="pt-5">
      <router-link :to="{ name: 'LoginView' }" style="text-decoration: none"
        ><p class="description" style="font-size: 20px">
          Back to Login
        </p></router-link
      >
    </v-row>
  </v-container>
</template>

<script>
import RequirementRatingComponent from "../rating/RequirementRatingComponent.vue";
const apiURL = "/auth/reset-password";

export default {
  components: { RequirementRatingComponent },
  name: "ResetPasswordForm",
  data() {
    return {
      username: "",
      password: "",
      confirmPassword: "",
      rules: {
        required: (value) => !!value || "Field is required.",
        passwordMatch: () =>
          this.password == this.confirmPassword || "Passwords must match.",
        email: (value) => {
          const pattern =
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
          return pattern.test(value) || "Invalid e-mail.";
        },
      },
      valid: true,
      error: false,
      score: null,
      strength: null,
      showConfirmPassword: false,
      showPassword: false,
      loading: false,
    };
  },
  methods: {
    resetPassword() {
      this.loading = true;
      let key = this.$route.params.key;
      this.$refs.form.validate();
      if (!this.valid) {
        this.loading = false;
        return;
      }
      if (this.password != this.confirmPassword) {
        this.loading = false;
        return;
      }
      let resetPassword = {
        username: this.username,
        password: this.password,
      };
      this.axios
        .post(apiURL + "/" + key, resetPassword)
        .then((response) => {
          this.loading = false;
          alert("You've successfully changed your password!");
          this.$refs.form.reset();
          console.log(response);
        })
        .catch((error) => {
          this.loading = false;
          alert("Invalid key or username!");
          console.log(error.data);
        });
    },
  },
};
</script>

<style lang="scss">
.description {
  font-family: "Baloo2", Helvetica, Arial;
}

.row {
  display: flex;
  flex-wrap: wrap;
  flex: 1 1 auto;
  margin: 0px;
}

.wrap {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  max-width: 400px;
  margin: 40px auto;
}

.input {
  border: 1px solid #ccc;
  border-radius: 0.5rem;
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
}
</style>
