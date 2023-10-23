<template>
  <v-card>
    <v-card-title>
      {{ emergencia.nombre_emergencia }}  (Estado: {{ emergencia.estado_emergencia}})
    </v-card-title>
    <v-card-subtitle>
      {{ date }}
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
        date: ''
      }
    },
    methods: {
      cambiarEstadoEmergencia(){
        const token = localStorage.getItem("token");

        if(this.activoInactivo(this.emergencia.estado_emergencia)){
          this.emergencia.estado_emergencia = 'Inactivo';
          this.opcion = 'Activar';
        }else{
          this.emergencia.estado_emergencia = 'Activo';
          this.opcion = 'Desactivar';
        }
        let json={
          id_emergencia: this.emergencia.id_emergencia,
          nombre_emergencia: this.emergencia.nombre_emergencia,
          descripcion_emergencia: this.emergencia.descripcion_emergencia,
          fecha_creacion_emergencia: this.emergencia.fecha_creacion_emergencia,
          id_coordinador: this.emergencia.id_coordinador,
          id_institucion: this.emergencia.id_institucion,
          estado_emergencia: this.activoInactivo(this.emergencia.estado_emergencia)
        };
        axios.put(`http://localhost:8080/emergencia/${this.emergencia.id_emergencia}`, json, {
          headers: {
            'Content-Type':'application/json',
            Authorization: `Bearer ${token}`
          }
        }).catch(error => {
            console.log(error);
          });
      },
      activoInactivo(estado){
        if(estado === 'Inactivo') return false;
        if(estado === 'Activo') return true;
        if(estado) return 'Activo';
        return 'Inactivo';
      },
      getTareas () {
        const token = localStorage.getItem("token");
        axios.get(`http://localhost:8080/tareas/emergencia/${this.emergencia.id_emergencia}`,{
            headers: {
            Authorization: `Bearer ${token}`,
            }
          })
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
        const token = localStorage.getItem("token");
        axios.get(`http://localhost:8080/emergencia/numeroTareasActivas/${this.emergencia.id_emergencia}`,{
            headers: {
            Authorization: `Bearer ${token}`,
            }
          })// /emergencia/numeroTareasActivas/{id_emergencia}
          .then(response => {
            this.resumen_tareas = this.resumen_tareas + response.data;
          })
          .catch(error => {
            console.log(error);
          })
      }
    },
    created() {
      this.date = new Date(this.emergencia.fecha_creacion_emergencia)
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
