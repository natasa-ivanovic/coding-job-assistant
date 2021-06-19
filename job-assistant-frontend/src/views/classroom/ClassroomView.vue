<template>
  <v-container fluid>
    <v-row justify="center" class="mt-5">
      <v-col cols="8">
        <classroom-table></classroom-table>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ClassroomTable from "../../components/classroom/ClassroomTable.vue";

export default {
  components: {
    ClassroomTable,
  },
  name: "ClassroomView",
  data() {
    return {};
  },
};
</script>

<style scoped></style>
