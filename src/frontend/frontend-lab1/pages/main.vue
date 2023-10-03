<template>
  <v-app>
    <!-- Barra de navegación vertical -->
    <v-navigation-drawer v-model="drawer" app color="primary" dark width="200">
      <!-- Agrega un contenedor para centrar verticalmente -->
      <div class="d-flex justify-center align-center my-4">
        <!-- Agrega la imagen de usuario -->
        <v-avatar size="150">
          <img src="../assets/perfil3.png" alt="Imagen de Usuario" />
        </v-avatar>
      </div>
      <!-- Agrega el nombre de usuario y el tipo de usuario -->
      <v-subheader>Nombre de Usuario</v-subheader>
      <v-subheader>Tipo de Usuario</v-subheader>
      <v-list>
        <!-- Opciones de navegación -->
        <v-list-item-group>
          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-home</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title to="/">Inicio</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-alert</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title to="/emergencias">Emergencias</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-account-group</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title to="/organiza">Organiza</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-email</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title to="/contacto">Contacto</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
    <!-- Contenido principal -->
    <v-main>
      <v-app-bar app color="primary" dark>
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title class="font-weight-bold"
          >Voluntariados</v-toolbar-title
        >
        <v-spacer></v-spacer>
        <!-- Botón de inicio de sesión -->
        <v-btn text to="/iniciar-sesion">Cerrar Sesión</v-btn>
      </v-app-bar>
      <v-container class="py-6 text-center">
        <h1 class="display-2 font-weight-bold mb-4">Únete a la Causa</h1>
        <p class="subtitle-1">
          Haz la diferencia en tu comunidad como voluntario
        </p>
        <v-btn color="primary" class="mt-4" to="/registrarse"
          >¡Planifica un voluntariado!</v-btn
        >
      </v-container>
    </v-main>
    <!-- Footer -->
    <v-footer app class="pa-2" dark>
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <h3 class="font-weight-bold text-sm mb-2">Más Información</h3>
            <ul>
              <li>
                <a class="text-sm" href="/sobre-nosotros">Sobre Nosotros</a>
              </li>
              <li>
                <a class="text-sm" href="/voluntariados-disponibles"
                  >Voluntariados Disponibles</a
                >
              </li>
              <li>
                <a class="text-sm" href="/historias-de-exito"
                  >Historias de Éxito</a
                >
              </li>
            </ul>
          </v-col>
          <v-col cols="12" sm="6">
            <h3 class="font-weight-bold text-sm mb-2">Contacto</h3>
            <p class="text-sm mb-1">
              Si tienes alguna pregunta, no dudes en contactarnos:
            </p>
            <ul>
              <li class="text-sm">Correo Electrónico: info@tuempresa.com</li>
              <li class="text-sm">Teléfono: (123) 456-7890</li>
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
      drawer: true, // Controla la apertura/cierre del cajón de navegación
    };
  },
};
</script>

<style scoped>
/* Estilos CSS para el footer y su contenido */
.v-footer {
  padding: 5px; /* Ajusta el espaciado interno del footer */
  font-size: 15px; /* Ajusta el tamaño de fuente del footer */
}

/* Estilos CSS para los títulos del footer */
.font-weight-bold {
  font-weight: bold; /* Aplica negrita a los títulos */
}

/* Estilos CSS para las listas del footer */
ul {
  list-style: none; /* Quita los marcadores de lista */
  padding: 0; /* Elimina el espaciado interno de las listas */
}

/* Estilos CSS para los elementos de la lista del footer */
li {
  margin-bottom: 5px; /* Ajusta el espaciado entre elementos de la lista */
}

/* Estilos CSS para el texto del footer */
.text-sm {
  font-size: 15px; /* Ajusta el tamaño de fuente del texto */
}
/* Estilos CSS para el footer */
.v-footer {
  height: 130px; /* Ajusta la altura del footer según tus preferencias */
}
</style>
