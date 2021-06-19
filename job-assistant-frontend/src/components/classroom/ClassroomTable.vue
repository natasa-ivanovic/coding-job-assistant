<template>
  <v-data-table
    :headers="infoHeader"
    :items="info"
    :expanded.sync="expanded"
    item-key="id"
    show-expand
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar flat>
        <v-toolbar-title>Materials</v-toolbar-title>
      </v-toolbar>
    </template>
    <template v-slot:[`item.dateSuggested`]="{ item }">
      {{ new Date(item.dateSuggested).toDateString() }}
    </template>
    <template v-slot:[`item.studied`]="{ item }">
      <v-btn icon :disabled="item.checked" @click="check(item)">
        <v-icon>
          mdi-check-bold
        </v-icon>
      </v-btn>
    </template>
    <template v-slot:expanded-item="{ headers, item }">
      <td :colspan="headers.length">
        <v-data-table
          :headers="materialHeader"
          :items="item.interviewSuggestions"
          item-key="name"
          class="elevation-0"
          hide-default-footer
        >
          <template v-slot:[`item.url`]="{ item }">
            <a>{{ item.url }}</a>
          </template>
        </v-data-table>
      </td>
    </template>
  </v-data-table>
</template>

<script>
const apiURL = "/api/interview-suggestion";
const checkApiURL = "/api/interview-suggestion/check/";

export default {
  data() {
    return {
      expanded: [],
      singleExpand: false,
      //     private Long id;
      // private SkillProficiency proficiency;
      // private CVElement cvElement;
      // private String subject;
      // private String url;
      // private String description;
      infoHeader: [
        { text: "Date", value: "dateSuggested" },
        { text: "Position", value: "position" },
        { text: "Company", value: "company" },
        { text: "Seniority", value: "seniority" },
        { text: "Studied", value: "studied" },
      ],
      info: [],
      materialHeader: [
        { text: "CV Element", value: "cvElement" },
        { text: "Subject", value: "subject" },
        { text: "Your proficiency", value: "proficiency" },
        { text: "Description", value: "description" },
        { text: "Material URL", value: "url" },
      ],
    };
  },
  mounted() {
    this.axios.get(apiURL).then((response) => {
      this.info = response.data;
    });
  },
  methods: {
      check(item) {
          this.axios.post(checkApiURL + item.id)
          .then((response) => {
              item.checked = true;
              console.log(response);
              alert("You've successfully finished preparing for this job. Continue learning in order to mantain your streak.");
          })
      }
  }
};
</script>
