<template>
  <v-container>
    <v-layout justify-center align-center>
      <v-flex shrink>
        <v-img
          src="../../assets/doggo.gif"
          style="width: 150px; height: 100px"
        ></v-img>
      </v-flex>
    </v-layout>
    <v-list>
      <v-list-item link>
        <v-list-item-content>
          <v-list-item-title class="title d-flex justify-center">{{
            user.name + " " + user.surname
          }}</v-list-item-title>
          <v-list-item-subtitle class="d-flex justify-center">{{
            user.username
          }}</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
    </v-list>
    <v-divider></v-divider>
    <!-- admin nav -->
    <v-list v-if="user.role === 'ADMIN'" nav dense>
      <v-list-item-group v-model="selectedItem" color="primary">
        <!-- <router-link :to="{ name: 'HomeAdminView' }" v-slot="{ navigate }">
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Home</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link> -->
        <router-link
          :to="{ name: 'CompanyReviewListView' }"
          v-slot="{ navigate }"
        >
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-message-draw</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Reviews</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        <v-divider></v-divider>
        <router-link
          :to="{ name: 'CVElementListView' }"
          v-slot="{ navigate }"
        >
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-application-edit</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>CV Elements</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        <router-link
          :to="{ name: 'JobPositionAdminListView' }"
          v-slot="{ navigate }"
        >
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-school</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Job Positions</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        <router-link
          :to="{ name: 'JobPositionAdminListView' }"
          v-slot="{ navigate }"
        >
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-briefcase</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Job Offers</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        <router-link
          :to="{ name: 'CompanyAdminListView' }"
          v-slot="{ navigate }"
        >
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-office-building</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Companies</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        <router-link
          :to="{ name: 'CompanyAdminListView' }"
          v-slot="{ navigate }"
        >
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-book-open-variant</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Interview materials</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        <v-divider></v-divider>
        <router-link
          :to="{ name: 'ConfigListView' }"
          v-slot="{ navigate }"
        >
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-cog</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Template configuration</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
      </v-list-item-group>
    </v-list>
    <!-- user nav -->
    <v-list v-if="user.role === 'USER'" nav dense>
      <v-list-item-group v-model="selectedItem" color="primary">
        <router-link :to="{ name: 'HomeJobSeekerView' }" v-slot="{ navigate }">
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Home</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        
        <v-list-group prepend-icon="mdi-account">
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-content>
                <v-list-item-title>My account</v-list-item-title>
              </v-list-item-content>
            </v-list-item-content>
          </template>

          
        <router-link :to="{ name: 'AccountView' }" v-slot="{ navigate }">
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-account-box</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Details</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>

        
        <router-link :to="{ name: 'ResumeView' }" v-slot="{ navigate }">
          <v-list-item @click="navigate">
            <v-list-item-icon>
              <v-icon>mdi-file-account</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>My resume</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
        </v-list-group>

        <v-divider></v-divider>

        <v-list-group prepend-icon="mdi-school">
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-content>
                <v-list-item-title>Job positions</v-list-item-title>
              </v-list-item-content>
            </v-list-item-content>
          </template>

          <router-link
            :to="{ name: 'JobPositionRequestView' }"
            v-slot="{ navigate }"
          >
            <v-list-item @click="navigate">
              <v-list-item-icon>
                <v-icon>mdi-check</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title>My recommendations</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </router-link>

          <!-- <router-link
            :to="{ name: 'JobPositionListView' }"
            v-slot="{ navigate }"
          >
            <v-list-item @click="navigate">
              <v-list-item-icon>
                <v-icon>mdi-list-status</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title>View all positions</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </router-link> -->
        </v-list-group>

        <v-list-group prepend-icon="mdi-briefcase">
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-content>
                <v-list-item-title>Job offers</v-list-item-title>
              </v-list-item-content>
            </v-list-item-content>
          </template>

          <router-link
            :to="{ name: 'JobOfferRequestView' }"
            v-slot="{ navigate }"
          >
            <v-list-item @click="navigate">
              <v-list-item-icon>
                <v-icon>mdi-check</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title>My recommendations</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </router-link>

          <router-link :to="{ name: 'JobOfferListView' }" v-slot="{ navigate }">
            <v-list-item @click="navigate">
              <v-list-item-icon>
                <v-icon>mdi-format-list-text</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title>View all offers</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </router-link>
        </v-list-group>
      </v-list-item-group>
      <router-link :to="{ name: 'CompanyListView' }" v-slot="{ navigate }">
        <v-list-item @click="navigate">
          <v-list-item-icon>
            <v-icon>mdi-office-building</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Companies</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </router-link>
      <v-divider></v-divider>
      <router-link :to="{ name: 'ClassroomView' }" v-slot="{ navigate }">
        <v-list-item @click="navigate">
          <v-list-item-icon>
            <v-icon>mdi-book-open-variant</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Classroom</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </router-link>
    </v-list>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    selectedItem: null,
    user: JSON.parse(localStorage["user"]),
  }),
};
</script>

<style scoped>
img {
  height: 50%;
  width: 100%;
}
</style>
