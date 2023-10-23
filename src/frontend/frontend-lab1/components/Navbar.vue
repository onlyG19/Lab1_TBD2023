<template>
  <v-app-bar app color="primary" dark>
    <v-app-bar-nav-icon @click.prevent="toggleDrawer"></v-app-bar-nav-icon>
    <v-toolbar-title class="font-weight-bold">Voluntariados</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-btn text to="/login"><v-icon left>mdi-login</v-icon>Iniciar Sesión</v-btn>
    <v-btn text to="/" @click.stop="cerrarSesion"><v-icon left>mdi-logout</v-icon>Cerrar Sesión</v-btn>
  </v-app-bar>
</template>

<script>
export default {
  methods: {
    toggleDrawer() {
      this.$emit("toggleDrawer");
    },
    cerrarSesion() {
      if(process.client){
        localStorage.removeItem("token");
        sessionStorage.removeItem("user");
      }
      window.location.reload();
    }
  }
}
</script>
