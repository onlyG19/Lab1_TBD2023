<template>
<v-app>
   <v-app-bar app color="primary" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title class="font-weight-bold">Voluntariados</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text to="/">Inicio</v-btn>
      <v-btn text to="/acerca">Acerca</v-btn>
      <v-btn text to="/organiza">Organiza</v-btn>
      <v-btn text to="/contacto">Contacto</v-btn>
    </v-app-bar>
    <v-main>
        <Nuxt />
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
export default {
  name: 'DefaultLayout',
  data () {
      return {
          drawer: false,
          title: 'Vuetify.js'
    }
  }
}
</script>
