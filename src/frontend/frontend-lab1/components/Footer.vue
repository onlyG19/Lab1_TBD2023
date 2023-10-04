<template>
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
</template>

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