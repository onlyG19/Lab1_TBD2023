<template>
  <div>
  <div class="centered-button">
    <v-btn color="white" text to="/">
      <v-icon left>mdi-home</v-icon>
      Ir a inicio
    </v-btn>
    <v-btn color="white" text to="/register">
      <v-icon left>mdi-home</v-icon>
      Registrarse
    </v-btn>
  </div>
  <v-tabs
    fixed-tabs
    >
    <v-tab>Voluntarios</v-tab>
    <v-tab>Coordinadores</v-tab>
      <v-tab-item transition="fade-transition">
      <div class="form-container">
        <LogIn class="login-form" typeUser="voluntario"/>
        <Carousels :imgs="imgsVoluntario" />
      </div>
      </v-tab-item>
      <v-tab-item transition="fade-transition">
      <div class="form-container">
        <Carousels :imgs="imgsCoordinador" />
        <LogIn class="login-form" typeUser="coordinador"/>
      </div>
      </v-tab-item>
  </v-tabs>
  </div>
</template>

<script>
  export default{
    layout: 'log&reg',
    data (){
      return {
        imgsCoordinador: [
          { src: require("../assets/loginCor.jpeg") },
          { src: require("../assets/loginVol.jpg") },
        ],
        imgsVoluntario: [
          { src: require("../assets/loginVol.jpeg") },
          { src: require("../assets/loginVol.jpg") }]
      }
    }
  };
</script>

<style scoped>

.form-container{
  margin: 3em 4em;
  display: grid;
  grid-template-columns: 1fr 1fr;
  align-items: center;
}

.login-form{
  padding: 0 2em;
}

.centered-button {
  text-align: center;
  margin: 2em auto; /* Centrar vertical y horizontalmente el botón */
  width: 50%; /* Establecer el ancho del botón al 50% del contenedor */
}

.v-btn {
  background-color: rgb(22, 112, 181);
  margin-top: 1em;
}
</style>
