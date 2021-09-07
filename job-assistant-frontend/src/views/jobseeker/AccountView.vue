<<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col>My account</v-col>
          </v-card-title>
          <v-card-text>
            <v-row> 
              <account-form />
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import AccountForm from '@/components/user/AccountForm.vue'
export default {
  name: "AccountView",
  components: {
    AccountForm
  }
};
</script>

<style scoped>
</style>