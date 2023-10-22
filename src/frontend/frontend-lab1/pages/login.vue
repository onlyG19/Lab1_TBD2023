<template>
  <v-tabs
    fixed-tabs
    >
    <v-tab>Voluntarios</v-tab>
    <v-tab>Coordinadores</v-tab>
    <v-btn color="white" absolute top right variant="elevated" text to="/">Inicio</v-btn>
      <v-tab-item transition="fade-transition">
      <div class="form-container">
        <LogIn class="login-form" typeUser="voluntario"/>
        <Carousels :imgs="imgsVoluntario" />
        <nuxt-link to="/register" class="login-form">¿Deseas unirte?</nuxt-link>
      </div>
      </v-tab-item>
      <v-tab-item transition="fade-transition">
      <div class="form-container">
        <Carousels :imgs="imgsCoordinador" />
        <LogIn class="login-form" typeUser="coordinador"/>
      </div>
      </v-tab-item>
  </v-tabs>
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

.v-btn{
  background-color: rgb(22, 112, 181);
  margin-left: auto;
  margin-top: auto;
}
</style>
