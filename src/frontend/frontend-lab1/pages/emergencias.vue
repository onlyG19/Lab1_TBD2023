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
        idCoord: 1
      }
    },
    methods: {
      getAllEmergencies() {
        // idCoord es temporal, la idea es cargar la id del usuario
        // esto a partir de cargar usuario usando local/sesion item
        axios.get(`http://localhost:8080/emergencias/coordinador/${this.idCoord}`) 
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
