<template>
<v-app>
  <img class="logo" src="~/assets/LOGO_VOLUNTARIADO.png" alt="Logo voluntariado" />
    <v-main>
        <Nuxt />
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'DefaultLayout',
  data () {
    return {
      title: 'Vuetify.js'
    }
  }
}
</script>

<style>
  .logo{
  width: 100%;
  position: relative;
  margin: auto;
  height: 10em;
  }
</style>
