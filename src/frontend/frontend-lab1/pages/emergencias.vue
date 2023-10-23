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
        idCoord: 0
      }
    },
    methods: {
      async getAllEmergencies() {
        const user = JSON.parse(sessionStorage.getItem("user")); // Obtén los datos del usuario de sessionStorage
        const token = localStorage.getItem("token");
        console.log(user.id_coordinador);
        
        if(user && token){
          this.idCoord = user.id_coordinador; // Usa la ID del usuario recuperado de sessionStorage
          await axios.get(`http://localhost:8080/emergencias/coordinador/${this.idCoord}`,{
            headers: {
            Authorization: `Bearer ${token}`,
            }
          })
          .then(response => {
            this.emergencies = response.data;
          })
          .catch(error => {
            console.log(error);
          });
        } else {
        console.log("No se encontró ningún usuario en sessionStorage.");
        }
        

      }
    },
    created() {
      this.getAllEmergencies()
    },
  }
</script>
