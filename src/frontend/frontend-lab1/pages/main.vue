<template>
  <v-app>
    <!-- Barra de navegación -->
    <v-app-bar app color="primary" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title class="font-weight-bold">Voluntariados</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text to="/">Inicio</v-btn>
      <v-btn text to="/acerca">Acerca</v-btn>
      <v-btn text to="/organiza">Organiza</v-btn>
      <v-btn text to="/contacto">Contacto</v-btn>
    </v-app-bar>

    <!-- Contenido principal -->
    <v-main>
      <v-container class="py-6 text-center">
        <h1 class="display-2 font-weight-bold mb-4">Únete a la Causa</h1>
        <p class="subtitle-1">Haz la diferencia en tu comunidad como voluntario</p>
        <v-btn color="primary" class="mt-4" to="/registrarse">¡Regístrate Ahora!</v-btn>
      </v-container>
    </v-main>

    <!-- Footer -->
    <v-footer app class="pa-2" dark>
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <h3 class="font-weight-bold">Más Información</h3>
            <ul>
              <li><a href="/sobre-nosotros">Sobre Nosotros</a></li>
              <li><a href="/voluntariados-disponibles">Voluntariados Disponibles</a></li>
              <li><a href="/historias-de-exito">Historias de Éxito</a></li>
            </ul>
          </v-col>
          <v-col cols="12" sm="6">
            <h3 class="font-weight-bold">Contacto</h3>
            <p>Si tienes alguna pregunta, no dudes en contactarnos:</p>
            <ul>
              <li>Correo Electrónico: info@tuempresa.com</li>
              <li>Teléfono: (123) 456-7890</li>
            </ul>
          </v-col>
        </v-row>
      </v-container>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      drawer: false, // Controla la apertura/cierre del cajón de navegación
    };
  },
};
</script>
