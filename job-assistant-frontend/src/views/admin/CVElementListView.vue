<template>
  <v-container fluid>
    <v-row align="center" justify="center">
      <v-col cols="8">
        <v-card>
          <v-card-title>
            <v-col>CV Elements</v-col>
            <v-col>
              <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="Search"
                single-line
                hide-details
              ></v-text-field>
            </v-col>
          </v-card-title>
          <v-data-table :headers="headers" :items="elements" :search="search">
            <template v-slot:top>
              <v-toolbar flat>
                <v-spacer></v-spacer>
                <v-dialog
                  v-model="dialog"
                  max-width="500px"
                  @click:outside="close()"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      color="primary"
                      dark
                      class="mb-2"
                      v-bind="attrs"
                      v-on="on"
                    >
                      New Item
                    </v-btn>
                  </template>
                  <v-form v-model="valid" ref="form">
                    <v-card>
                      <v-card-title>
                        <span class="text-h5">{{ formTitle }}</span>
                      </v-card-title>

                      <v-card-text>
                        <v-container>
                          <v-row>
                            <v-col cols="6">
                              <v-text-field
                                v-model="editedItem.name"
                                label="Element name"
                                :rules="[rules.required]"
                              ></v-text-field>
                            </v-col>
                            <v-col cols="6">
                              <v-autocomplete
                                v-model="editedItem.type"
                                :items="types"
                                item-text="text"
                                item-value="value"
                                label="Element name"
                                :rules="[rules.required]"
                              ></v-autocomplete>
                            </v-col>
                          </v-row>
                        </v-container>
                      </v-card-text>

                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="blue darken-1" text @click="close">
                          Cancel
                        </v-btn>
                        <v-btn color="blue darken-1" text @click="save">
                          Save
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-form>
                </v-dialog>
                <v-dialog v-model="dialogDelete" max-width="500px">
                  <v-card>
                    <v-card-title class="text-h5"
                      >Are you sure you want to delete this item?</v-card-title
                    >
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="blue darken-1" text @click="closeDelete"
                        >Cancel</v-btn
                      >
                      <v-btn
                        color="blue darken-1"
                        text
                        @click="deleteItemConfirm"
                        >OK</v-btn
                      >
                      <v-spacer></v-spacer>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-toolbar>
            </template>
            <template v-slot:[`item.actions`]="{ item }">
              <v-icon class="mr-2" @click="editItem(item)">
                mdi-pencil
              </v-icon>
              <v-icon @click="deleteItem(item)"> mdi-delete </v-icon>
            </template>
          </v-data-table>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const apiURL = "/api/cv-elements";

export default {
  name: "CVElementsListView",
  components: {},
  data() {
    return {
      dialog: false,
      dialogDelete: false,
      search: "",
      headers: [
        { text: "Id", value: "id" },
        { text: "Name", value: "name" },
        { text: "Type", value: "type" },
        { text: "Actions", value: "actions", align: "right" },
      ],
      elements: [],
      types: [
        { text: "Programming language", value: "PROGRAMMING_LANGUAGE" },
        { text: "Technology", value: "TECHNOLOGY" },
        { text: "Knowledge", value: "KNOWLEDGE" },
        { text: "Language", value: "LANGUAGE" },
        { text: "Soft skill", value: "SOFT_SKILL" },
      ],
      editedIndex: -1,
      editedItem: {
        name: "",
        type: "PROGRAMMING_LANGUAGE",
        id: 0,
      },
      defaultItem: {
        name: "",
        type: "PROGRAMMING_LANGUAGE",
        id: 0,
      },
      rules: {
        required: (value) => !!value || "Field is required.",
      },
      valid: true,
    };
  },

  mounted() {
    this.getElements();
  },

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "New CV Element" : "Edit CV Element";
    },
  },

  methods: {
    getElements() {
      this.axios
        .get(apiURL)
        .then((response) => {
          this.elements = response.data;
        })
        .catch((error) => {
          this.$root.snackbar.warning(error);
        });
    },
    editItem(item) {
      this.editedIndex = this.elements.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      this.editedIndex = this.elements.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm() {
      this.axios({
        url: apiURL + "/" + this.editedItem.id,
        method: "DELETE",
      })
        .then(() => {
          Object.assign(this.elements[this.editedIndex], this.editedItem);
          this.$root.snackbar.success("Successfully deleted item!");
          this.elements.splice(this.editedIndex, 1);
          this.closeDelete();
        })
        .catch((error) => {
          this.$root.snackbar.error("Could not delete! Item is in use.");
        });
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
        this.$refs.form.resetValidation();
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
        this.$refs.form.resetValidation();
      });
    },

    save() {
      this.$refs.form.validate();
      if (!this.valid) {
        this.loading = false;
        return;
      }
      console.log(this.editedItem);
      if (this.editedIndex > -1) {
        // editing
        this.axios({
          url: apiURL + "/" + this.editedItem.id,
          method: "PUT",
          data: this.editedItem,
        })
          .then(() => {
            Object.assign(this.elements[this.editedIndex], this.editedItem);
            this.$root.snackbar.success("Successfully edited item!");
            this.close();
          })
          .catch((error) => {
            this.$root.snackbar.error(error.response.data.message);
          });
      } else {
        // creating new
        this.axios({ url: apiURL, method: "POST", data: this.editedItem })
          .then((response) => {
            this.editedItem.id = response.data;
            this.elements.push(this.editedItem);
            this.$root.snackbar.success("Successfully added item!");
            this.close();
          })
          .catch((error) => {
            this.$root.snackbar.error(error.response.data.message);
          });
      }
    },
  },
};
</script>
