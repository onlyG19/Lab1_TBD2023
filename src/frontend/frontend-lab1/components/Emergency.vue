<template>
  <v-card>
    <v-card-title>
      {{ emergencia.nombre_emergencia }}  (Estado: {{ this.emergencia.estado_emergencia}})
    </v-card-title>
    <v-card-subtitle>
      {{ emergencia.fecha_creacion_emergencia }}
    </v-card-subtitle>
    <v-card-text>
      {{ emergencia.descripcion_emergencia}}
    </v-card-text>
    <v-card-actions>
      <v-row>
        <v-col cols="12">
          <v-btn @click="cambiarEstadoEmergencia" v-text="opcion"></v-btn>
        </v-col>
        <v-col cols="12">
          <v-list>
            <v-list-group>
              <template v-slot:activator>
                <v-list-item>
                  <v-list-item-content>
                    <v-list-item-title v-text="resumen_tareas"></v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </template>
              <v-list-item
                v-for="(tarea, i) in tareas"
                :key="i"
              >
                <v-list-item-content>
                  <v-list-item-title v-text="tarea.descripcion_tarea"></v-list-item-title>
                  <v-list-item-subtitle v-text="tarea.estado_tarea"></v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-list-group>
          </v-list>
        </v-col>
      </v-row>
    </v-card-actions>
  </v-card>
</template>

<script>
  import axios from 'axios'
  export default {
    props :{
      emergencia: {
        type: Object,
        required: true,
      }
    },
    data () {
      return {
        tareas: [],
        resumen_tareas: 'La cantidad de tareas activas es: ',
        opcion: '',
      }
    },
    methods: {
      cambiarEstadoEmergencia(){
        if(this.activoInactivo(this.emergencia.estado_emergencia)){
          this.emergencia.estado_emergencia = 'Inactivo';
          this.opcion = 'Activar';
        }else{
          this.emergencia.estado_emergencia = 'Activo';
          this.opcion = 'Desactivar';
        }
      },
      activoInactivo(estado){
        if(estado === 'Inactivo') return false;
        if(estado === 'Activo') return true;
        if(estado) return 'Activo';
        return 'Inactivo';
      },
      getTareas () {
        axios.get(`http://localhost:8080/tareas/emergencia/${this.emergencia.id_emergencia}`)
          .then(response => {
            this.tareas = response.data.map(tarea => {
              tarea.estado_tarea = this.activoInactivo(tarea.estado_tarea);
              return tarea;
            });
          })
          .catch(error => {
            console.log(error);
          })
      },
      cantidadTareasActivasEmergencia () {
        axios.get(`http://localhost:8080/emergencia/${this.emergencia.id_emergencia}/tareas/activas/cantidad`)
          .then(response => {
            this.resumen_tareas = this.resumen_tareas + response.data;
          })
          .catch(error => {
            console.log(error);
          })
      }
    },
    created() {
      this.emergencia.fecha_creacion_emergencia = new Date(this.emergencia.fecha_creacion_emergencia)
        .toLocaleDateString("es-CL",
          {weekday: 'long', year: 'numeric', month: 'long', day: 'numeric',
            hour: 'numeric', minute: 'numeric', second: 'numeric'});
      this.emergencia.estado_emergencia = this.activoInactivo(this.emergencia.estado_emergencia);
      this.getTareas();
      this.cantidadTareasActivasEmergencia();
      if(this.emergencia.estado_emergencia === 'Activo') this.opcion = 'Desactivar';
      else this.opcion = 'Activar';
    }
  }

</script>

<style scoped>

</style>
