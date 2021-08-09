<template>
  <v-card>
    <v-card-title>Leave a review</v-card-title>
    <v-card-text>
      <v-form v-model="valid" ref="form">
        <v-row>
          <v-col>
            <v-text-field
              label="Job title"
              v-model="review.jobTitle"
            />
            </v-col>
        </v-row>
        <v-row>
          <v-col class="review-font">
            <v-textarea
              counter
              label="Text"
              :rules="[rules.required, rules.maxLength]"
              v-model="review.content"
            ></v-textarea>
          </v-col>
        </v-row>
        <v-row>
          <v-col class="review-font">
            <v-checkbox v-model="review.jobOffered" label="Job offered" />
          </v-col>
          <v-col class="review-font">
            <v-checkbox v-model="review.recommends" label="I recommend this company" />
          </v-col>
        </v-row>
        <v-row>
          <v-col class="review-font">
            <v-checkbox v-model="review.hired" label="Offer accepted" />
          </v-col>
          <v-col>
            <v-text-field
              label="Salary"
              suffix="€"
              v-model="review.salary"
              :disabled="!review.hired"
            />
          </v-col>
        </v-row>
        <v-row>
          <v-col class="review-font"> Interview complexity </v-col>
          <v-col class="review-font">
            <v-slider
              :min="1"
              :max="5"
              v-model="review.interviewComplexity"
              ticks="always"
              hide-details
              :tick-labels="[1, 2, 3, 4, 5]"
            />
          </v-col>
        </v-row>
        <v-row>
          <v-col class="review-font">Overall score</v-col>
          <v-col>
            <v-rating
              large
              v-model="review.rating"
              background-color="yellow darken-1"
              color="yellow darken-1"
            />
          </v-col>
        </v-row>
      </v-form>
    </v-card-text>
    <v-card-actions>
      <v-row align="center" justify="center">
        <v-col>
          <v-btn
            color="#8C9EFF"
            @click="addReview()"
            block
            class="description"
            style="font-size: 15px"
            :loading="loading"
            >Add review
          </v-btn>
        </v-col>
      </v-row>
    </v-card-actions>
  </v-card>
</template>
<script>
const apiURL = "/api/company-review";

export default {
  name: "CompanyReviewForm",
  data() {
    return {
      review: {
        rating: 5,
        jobTitle: "Backend developer",
        content: "Test description",
        salary: 1000,
        hired: true,
        jobOffered: true,
        recommends: true,
        interviewComplexity: 1,
        // FOR TESTING PURPOSES
        ratedUseful: 15,
        ratedNotUseful: 0,
      },
      rules: {
        required: (value) => !!value || "Field is required.",
        maxLength: (v) => v.length <= 254 || "Max 255 characters",
      },
      loading: false,
      valid: true,
    };
  },
  props: {
    companyId: Number,
  },
  methods: {
    addReview: function () {
      this.loading = true;
      this.$refs.form.validate();
      if (!this.valid) {
        this.loading = false;
        return;
      }
      this.review.companyId = this.companyId;
      this.axios({
        url: apiURL,
        method: "POST",
        data: this.review,
      })
        .then(() => {
          this.loading = false;
          alert(
            "Successfully sent review! Please wait for the admin to approve it."
          );
          this.resetForm();
          this.$emit("update:enabled", false);
        })
        .catch((error) => {
          this.loading = false;
          alert(error.response.data.message);
        });
    },
    resetForm: function () {
      this.review.rating = 5;
      // jako glupo al da se ne buni za required description
      this.review.content = " ";
      this.review.salary = 0;
      this.review.hired = false;
      this.review.jobOffered = false;
      this.review.recommend = false;
      this.review.interviewComplexity = 1;
      this.valid = true;
    },
  },
};
</script>

<style scoped>
.review-font {
  font-size: 16px;
  display: flex;
  align-items: center;
  text-align: left;
}
</style>
