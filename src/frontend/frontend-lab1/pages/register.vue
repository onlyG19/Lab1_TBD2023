<template>
  <div>
    <div class="centered-button">
      <v-btn color="white" text to="/">
        <v-icon left>mdi-home</v-icon>
        Ir a inicio
      </v-btn>
      <v-btn color="white" text to="/login">
        <v-icon left>mdi-login</v-icon>
        Loguearse
      </v-btn>
    </div>
    <v-tabs
      fixed-tabs
    >
      <v-tab>Voluntarios</v-tab>
      <v-tab>Coordinadores</v-tab>
      <v-tab-item transition="fade-transition">
        <fieldset class="form-register">
          <legend style="font-size: 1.5em; padding: 10px; color: #005a85">Registro de Voluntarios</legend>
          <RegisterVoluntario />
        </fieldset>
      </v-tab-item>
      <v-tab-item transition="fade-transition">
        <fieldset class="form-register">
          <legend style="font-size: 1.5em; padding: 10px; color: #005a85">Registro de Coodinadores</legend>
          <RegisterCoordinador />
        </fieldset>
      </v-tab-item>
    </v-tabs>
  </div>
</template>

<script>
  export default{
    layout: 'log&reg',
  };
</script>

<style scoped>
.form-register{
  width: 30%;
  margin: 30px auto;
  border-radius: 2%;
  border: 2px solid #0097DF;
  padding: 2em;
  margin-bottom: 5rem;
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
