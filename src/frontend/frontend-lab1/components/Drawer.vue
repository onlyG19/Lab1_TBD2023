<template>
  <v-navigation-drawer v-model="localDrawer" app color="primary" dark width="200">
    <div class="d-flex justify-center align-center my-4">
      <v-avatar size="150">
        <img src="../assets/perfil2.png" alt="Imagen de Usuario" />
      </v-avatar>
    </div>
    <v-divider></v-divider>
    <div class="text-center my-2">
      <v-subheader>Tipo de Usuario: {{ userType }}</v-subheader>
      <v-divider></v-divider>
      <v-subheader>Nombre de Usuario: {{ userName }}</v-subheader>
    </div>
    <v-divider></v-divider>
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
        <v-list-item to="/ranking">
          <v-list-item-action >
            <v-icon>mdi-star</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Ranking</v-list-item-title>
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
</template>

<script>
export default {
  props: {
    drawer: Boolean
  },
  data() {
    return {
      localDrawer: this.drawer,
      userType: '',
      userName: ''
    };
  },
  watch: {
    drawer(newVal) {
      this.localDrawer = newVal;
    }
  },
  created() {
    this.loadUserData();
  },
  methods: {
    async loadUserData() {
      const user = JSON.parse(sessionStorage.getItem("user"));
      if (user) {
        if (user.id_coordinador) {
          this.userType = 'Coordinador';
          this.userName = `${user.nombre_coordinador} ${user.apellido_coordinador}`;
        } else if (user.id_voluntario) {
          this.userType = 'Voluntario';
          this.userName = `${user.nombre_voluntario} ${user.apellido_voluntario}`;
        } else {
          console.log('El tipo de usuario no se pudo determinar.');
        }
      } else {
        console.log('No se encontró ningún usuario en sessionStorage.');
      }
        
    },
  },
}
</script>
