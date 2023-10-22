<template>
  <v-app-bar app color="primary" dark>
    <v-app-bar-nav-icon @click.prevent="toggleDrawer"></v-app-bar-nav-icon>
    <v-toolbar-title class="font-weight-bold">Voluntariados</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-btn text to="/login">Iniciar Sesión</v-btn>
    <v-btn text to="/">Cerrar Sesión</v-btn>
  </v-app-bar>
</template>

<script>
export default {
  methods: {
    toggleDrawer() {
      this.$emit("toggleDrawer");
    }
  }
}
</script>
