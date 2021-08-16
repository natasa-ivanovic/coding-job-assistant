<template>
  <v-container fill-height>
    <v-container>
      <v-card width="800px" height="500px" elevation="24">
        <v-card-title
          align="center"
          justify="center"
          class="description pt-15 justify-center"
          style="font-size: 50px"
        >
          <b>Welcome to POSO!</b>
        </v-card-title>
        <v-row
          align="center"
          justify="center"
          class="description"
          style="font-size: 30px"
        >
          Log in to start looking for a job!
        </v-row>
        <v-card-text>
        <v-row align="center" justify="center">
          <v-col>
            <v-form v-model="valid" ref="form">
              <v-row>
                <v-text-field
                  v-model="user.username"
                  :rules="[rules.email, rules.required]"
                  label="Username"
                  prepend-icon="mdi-account"
                  type="text"
                  class="description"
                  style="font-size: 18px"
                />
              </v-row>
              <v-row>
                <v-text-field
                  v-model="user.password"
                  :rules="[rules.required]"
                  label="Password"
                  prepend-icon="mdi-lock"
                  class="description"
                  style="font-size: 18px"
                  :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                  :type="showPassword ? 'text' : 'password'"
                  @click:append="showPassword = !showPassword"
                />
              </v-row>
            </v-form>
            <v-row>
              <v-col class="mt-6">
                <v-btn
                  color="main-screen"
                  @click="login()"
                  block
                  class="description"
                  style="font-size: 15px"
                  :loading="loading"
                  ><b>Log in</b></v-btn
                >
              </v-col>
            </v-row>
            <v-row align="center" justify="center">
              <router-link
                :to="{ name: 'RegisterView' }"
                style="text-decoration: none;"
                ><p class="description" style="font-size: 20px">
                  Don't have an account? Sign up
                </p></router-link
              >
            </v-row>
          </v-col>
        </v-row>
        </v-card-text>
      </v-card>
    </v-container>
  </v-container>
</template>
<script>
const apiURL = "/auth/login";

export default {
  name: "LoginForm",
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      rules: {
        required: (value) => !!value || "Field is required.",
        email: (value) => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
          return pattern.test(value) || "Invalid e-mail.";
        },
      },
      valid: true,
      error: false,
      showPassword: false,
      loading: false
    };
  },
  methods: {
    login: function() {
      this.loading = true;
      this.$refs.form.validate();
      if (!this.valid) {
        this.loading = false;
        return;
      }
      this.axios({
        url: apiURL,
        method: "POST",
        data: this.user,
      })
        .then((response) => {
          let loggedInUser = {
            id: response.data.id,
            token: response.data.accessToken,
            expiresIn: response.data.expiresIn,
            role: response.data.role,
            username: response.data.username,
            name: response.data.name,
            surname: response.data.surname,
          };
          localStorage.setItem("role", response.data.role);
          localStorage.setItem(
            "authKey",
            "Bearer " + response.data.accessToken
          );
          localStorage.setItem("user", JSON.stringify(loggedInUser));
          this.axios.defaults.headers["Authorization"] =
            "Bearer " + response.data.accessToken;
          this.loading = false;
          if (loggedInUser.role === "ADMIN") {
            this.$router.push({ name: "HomeAdminView" });
          }
          else {
            this.$router.push({ name: "HomeJobSeekerView" });
          }
        })
        .catch((error) => {
          this.loading = false;
          this.$root.snackbar.error(error.response.data.message);
        });
    },
  },
};
</script>

<style scoped>
.description {
  font-family: "Baloo2", Helvetica, Arial;
}

.main-screen {
  background: rgb(238, 174, 209);
  background: radial-gradient(
    circle,
    rgba(238, 174, 209, 1) 14%,
    rgba(148, 187, 233, 1) 93%
  );
}
</style>
