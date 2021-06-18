<template>
  <v-card width="600px" height="600px">
    <v-card-title> Leave a review </v-card-title>
    <v-card-text>
      <v-form v-model="valid" ref="form">
        <v-row>
          <v-col class="review-font">Overall score</v-col>
          <v-col>
            <v-rating v-model="review.rating" />
          </v-col>
        </v-row>
        <v-row>
          <v-col class="review-font">
            <v-checkbox v-model="review.jobOffered" label="Job offered"/>
          </v-col>
          <v-col class="review-font">
            <v-checkbox v-model="review.recommend" label="Recommends company"/>
          </v-col>
        </v-row>
        <v-row >
          <v-col class="review-font">
            <v-checkbox v-model="review.hired" label="Offer accepted"/>
          </v-col>
          <v-col>
            <v-text-field single-line label="Salary" suffix="€" v-model="review.salary"  :disabled="!review.hired"/>
          </v-col>
        </v-row>
        <v-row >
          <v-col class="review-font">
            <v-textarea
              counter
              label="Text"
              :rules="[rules.required, rules.maxLength]"
              v-model="review.content"
            ></v-textarea>
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
const apiURL = "/api/job-offer-review";

export default {
  name: "OfferReviewForm",
  data() {
    return {
      review: {
        rating: 0,
        content: "",
        salary: 0,
        hired: false,
        jobOffered: false,
        recommend: false,
        interviewComplexity: 1
      },
      rules: {
        required: (value) => !!value || "Field is required.",
        maxLength: v => v.length <= 254 || 'Max 255 characters',
      },
      loading: false,
      valid: true,
    };
  },
  props: {
    offerId: Number,
  },
  methods: {
    addReview: function () {
      this.loading = true;
      this.$refs.form.validate();
      if (!this.valid) {
        this.loading = false;
        return;
      }
      this.review.offerId = this.offerId;
      this.axios({
        url: apiURL,
        method: "POST",
        data: this.review,
      })
        .then((response) => {
          this.loading = false;
        })
        .catch((error) => {
          this.loading = false;
        });
    },
  },
};
</script>

<style scoped>
.review-font {
  font-size: 18px;
  display: flex;
  align-items: center;
  text-align: left;
}
</style>
