<template>
  <v-container fill-height>
    <v-container>
      <v-card width="950px" height="750px" elevation="24">
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
          Register to start looking for a job!
        </v-row>
        <v-card-text>
        <v-row align="center" justify="center">
          <v-col>
            <v-form v-model="valid" ref="form">
              <v-row>
                <v-text-field
                  v-model="user.username"
                  :rules="[rules.email, rules.required]"
                  label="Email"
                  prepend-icon="mdi-email"
                  type="text"
                  style="font-size: 18px"
                  class="description"
                />
              </v-row>
              <v-row>
                <v-text-field
                  v-model="user.name"
                  :rules="[rules.required]"
                  label="Name"
                  prepend-icon="mdi-account"
                  type="text"
                  style="font-size: 18px"
                  class="description"
                />
              </v-row>
              <v-row>
                <v-text-field
                  v-model="user.surname"
                  :rules="[rules.required]"
                  label="Surname"
                  prepend-icon="mdi-account"
                  type="text"
                  style="font-size: 18px"
                  class="description"
                />
              </v-row>
              <v-row>
                <!-- <div class="example-custom-css"> -->
                <!-- <div class="input-container"> -->
                <v-text-field
                  id="custom-css-input"
                  v-model="user.password"
                  :rules="[rules.required]"
                  label="Password"
                  prepend-icon="mdi-lock"
                  style="font-size: 18px"
                  :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                  :type="showPassword ? 'text' : 'password'"
                  @click:append="showPassword = !showPassword"
                  class="description"
                />
                <!-- <password-meter :password="user.password" @score="onScore" /> -->
                <!-- </div> -->
                <!-- </div> -->
              </v-row>
              <v-row>
                <v-text-field
                  v-model="confirmPassword"
                  :rules="[rules.passwordMatch]"
                  label="Password"
                  prepend-icon="mdi-lock"
                  style="font-size: 18px"
                  :append-icon="showConfirmPassword ? 'mdi-eye' : 'mdi-eye-off'"
                  :type="showConfirmPassword ? 'text' : 'password'"
                  @click:append="showConfirmPassword = !showConfirmPassword"
                  class="description"
                />
              </v-row>
            </v-form>
            <v-row>
              <v-col class="mt-6">
                <v-btn
                  color="main-screen"
                  @click="register()"
                  block
                  class="description"
                  style="font-size: 15px"
                  :loading="loading"
                  ><b>Register</b></v-btn
                >
              </v-col>
            </v-row>
            <v-row align="center" justify="center">
              <router-link
                :to="{ name: 'LoginView' }"
                style="text-decoration: none;"
                ><p class="description" style="font-size: 20px">
                  Already have an account? Log in
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
import passwordMeter from "vue-simple-password-meter";
const apiURL = "/auth/register";

export default {
  name: "Register",
  components: { passwordMeter },
  data() {
    return {
      user: {
        username: "",
        name: "",
        surname: "",
        password: "",
      },
      rules: {
        required: (value) => !!value || "Field is required.",
        email: (value) => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
          return pattern.test(value) || "Invalid e-mail.";
        },
        required: (value) => !!value || "Field is required.",
        counter: (value) =>
          (value && value.length > 5) ||
          "Password must have a minimum of 6 characters",
        passwordMatch: () =>
          this.user.password == this.confirmPassword || "Passwords must match.",
      },
      confirmPassword: "",
      valid: true,
      error: false,
      showPassword: false,
      showConfirmPassword: false,
      loading: false,
    //   score: null
    };
  },
  methods: {
    register: function() {
      console.log("hajde");
      this.loading = true;
      this.$refs.form.validate();
      if (!this.valid) {
        this.loading = false;
        return;
      }
      if (this.user.password != this.confirmPassword) {
        this.loading = false;
        return;
      }
    //   if (this.score <= 2) {
    //     this.loading = false;
    //     alert("Your password is weak! Use numbers and special characters!");
    //     return;
    //   }
      this.axios
        .post(apiURL, this.user)
        .then(() => {
          this.loading = false;
          alert("You've successfully registered to your account");
          this.$refs.form.reset();
          console.log(response);
        })
        .catch((error) => {
          this.loading = false;
          alert(error.response.data.message);
          console.log(error.data);
        });
    },
    onScore({ score, strength }) {
      // console.log(score); // from 0 to 4
      // console.log(strength); // one of : 'risky', 'guessable', 'weak', 'safe' , 'secure'
      this.score = score;
      this.strength = strength;
    },
  },
};
</script>

<style scoped lang="scss">
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
// .row {
//   display: flex;
//   flex-wrap: wrap;
//   flex: 1 1 auto;
//   margin: 0px;
// }

// .wrap {
//   font-family: "Avenir", Helvetica, Arial, sans-serif;
//   -webkit-font-smoothing: antialiased;
//   -moz-osx-font-smoothing: grayscale;
//   color: #2c3e50;
//   //max-width: 400px;
//   margin: 40px auto;
// }

// .input {
//   border: 1px solid #ccc;
//   border-radius: 0.5rem;
//   width: 100%;
//   padding: 10px;
//   box-sizing: border-box;
// }

// .input-container {
//   position: relative;
//   display: flex;
//   align-items: center;
// }

// .example-custom-css {
//   .po-password-strength-bar {
//     border-radius: 2px;
//     transition: all 0.2s linear;
//     height: 30px;
//     width: 30px;
//     position: absolute;
//     //right: 50px;
//     margin-top: auto;
//     margin-bottom: 30px;
//   }

//   .po-password-strength-bar.risky {
//     background-color: #f95e68;
//   }

//   .po-password-strength-bar.guessable {
//     background-color: #fb964d;
//   }

//   .po-password-strength-bar.weak {
//     background-color: #fdd244;
//   }

//   .po-password-strength-bar.safe {
//     background-color: #b0dc53;
//   }

//   .po-password-strength-bar.secure {
//     background-color: #35cc62;
//   }
// }
</style>
