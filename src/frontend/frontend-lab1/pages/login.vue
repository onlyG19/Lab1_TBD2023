<template>
  <v-tabs
    fixed-tabs
    >
    <v-tab>Voluntarios</v-tab>
    <v-tab>Coordinadores</v-tab>
      <v-tab-item transition="fade-transition">
      <div class="form-container">
        <LogIn class="login-form" typeUser="voluntario"/>
        <CarouselsV />
        <a class="login-form">¿Deseas unirte?</a>
      </div>
      </v-tab-item>
      <v-tab-item transition="fade-transition">
      <div class="form-container">
        <CarouselsC />
        <LogIn class="login-form" typeUser="coordinador"/>
      </div>
      </v-tab-item>
  </v-tabs>
</template>

<script>
  export default{
    layout: 'log&reg',
  };
</script>

<style>

.form-container{
  margin: 3em 4em;
  display: grid;
  grid-template-columns: 1fr 1fr;
  align-items: center;
  }

  .login-form{
  padding: 0 2em;
  }
</style>
