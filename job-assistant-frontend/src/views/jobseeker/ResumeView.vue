<<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col>My resume</v-col>
          </v-card-title>
          <v-card-text>
            <v-row> 
              <resume-form />
            </v-row>
          </v-card-text>
        </v-card>
        <v-card class="mt-4">
          <v-card-title>
            <v-col>My working experience</v-col>
          </v-card-title>
          <v-card-text>
            <v-row> 
              <experience-form />
            </v-row>
          </v-card-text>
        </v-card>
        <v-card class="mt-4">
          <v-card-title>
            <v-col>Important benefits</v-col>
          </v-card-title>
          <!-- <v-card-text>
            <v-row> 
              <experience-form />
            </v-row>
          </v-card-text> -->
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ResumeForm from '@/components/user/ResumeForm.vue'
import ExperienceForm from '@/components/user/ExperienceForm.vue'
export default {
  name: "AccountView",
  components: {
    ResumeForm,
    ExperienceForm
  }
};
</script>

<style scoped>
</style>