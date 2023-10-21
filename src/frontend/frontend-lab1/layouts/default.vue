<template>
<v-app>
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
            <v-list-item to="/">
              <v-list-item-action>
                <v-icon>mdi-home</v-icon>
              </v-list-item-action>
              <v-list-item-content>
                <v-list-item-title>Inicio</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            <v-list-item to="/emergencias">
              <v-list-item-action >
                <v-icon>mdi-alert</v-icon>
              </v-list-item-action>
              <v-list-item-content>
                <v-list-item-title>Emergencias</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          <v-list-item to="organiza">
            <v-list-item-action>
              <v-icon>mdi-account-group</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title to="/organiza">Organiza</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item to="/contacto">
            <v-list-item-action>
              <v-icon>mdi-email</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>Contacto</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar app color="primary" dark>
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title class="font-weight-bold"
          >Voluntariados</v-toolbar-title
        >
        <v-spacer></v-spacer>
        <!-- Botón de inicio de sesión -->
        <v-btn text to="/login">Cerrar Sesión</v-btn>
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
