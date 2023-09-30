<template>
  <v-tabs
    fixed-tabs
    >
    <v-tab>Voluntarios</v-tab>
    <v-tab>Coordinadores</v-tab>
      <v-tab-item transition="fade-transition">
      <div class="container">
        <LogIn class="login-form" typeUser="voluntario"/>
        <CarouselsV />
        <a class="login-form">¿Deseas unirte?</a>
      </div>
      </v-tab-item>
      <v-tab-item transition="fade-transition">
      <div class="container">
        <CarouselsC />
        <LogIn class="login-form" typeUser="coordinador"/>
      </div>
      </v-tab-item>
  </v-tabs>
</template>

<style>

  .container{
  margin: 0 8em;
  display: grid;
  grid-template-columns: 5fr 6fr;
  align-items: center;
  }

  .login-form{
    padding: 0 2em;
  }
</style>
