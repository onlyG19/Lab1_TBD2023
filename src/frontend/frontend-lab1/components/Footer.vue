<template>
  <v-footer app inset absolute class="pa-2" dark>
    <v-container>
      <v-row>
        <v-col cols="12" sm="6" style="padding-bottom: 0;">
          <h3 class="font-weight-bold text-sm mb-2">Más Información</h3>
          <ul>
            <li class="li-footer">
              <a class="text-sm" href="/sobre-nosotros">Sobre Nosotros</a>
            </li>
            <li class="li-footer">
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
        <v-col cols="12" sm="6" style="padding-bottom: 0;">
          <h3 class="font-weight-bold text-sm mb-2">Contacto</h3>
          <p class="text-sm mb-1">
            Si tienes alguna pregunta, no dudes en contactarnos:
          </p>
          <ul>
            <li class="text-sm li-footer">Correo Electrónico: voluntasks@volunteam.cl</li>
            <li class="text-sm">Teléfono: (123) 456-7890</li>
          </ul>
        </v-col>
      </v-row>
    </v-container>
  </v-footer>
</template>

<style scoped>
/* Estilos CSS para los títulos del footer */
.font-weight-bold {
  font-weight: bold; /* Aplica negrita a los títulos */
}
/* Estilos CSS para las listas del footer */
ul {
  list-style: none; /* Quita los marcadores de lista */
  padding: 0; /* Elimina el espaciado interno de las listas */
}
/* Estilos CSS para el texto del footer */
.text-sm {
  font-size: 15px; /* Ajusta el tamaño de fuente del texto */
}
a {
  transition: color 0.3s; /* Transición suave de color en 0.3 segundos */
  text-decoration: none; /* Quita el subrayado de los enlaces */
}
/* Cambia el color a blanco al hacer hover sobre los enlaces de información */
a:hover {
  color: #fff; /* Cambia el color a blanco al hacer hover */
}
</style>
