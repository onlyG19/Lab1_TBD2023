<template>
  <v-container>
    <v-row>
      <v-col
        v-for="(emergency, i) in emergencies"
        :key="i"
        cols="12"
      >
        <Emergency :emergencia="emergency"/>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
  import axios from 'axios'
  export default {
    data () {
      return {
        emergencies: '',
      }
    },
    methods: {
      getAllEmergencies() {
        axios.get(`http://localhost:8093/emergencias`)
          .then(response => {
            this.emergencies = response.data;
          })
          .catch(error => {
            console.log(error);
          })

      }
    },
    created() {
      this.getAllEmergencies()
    },
  }
</script>
