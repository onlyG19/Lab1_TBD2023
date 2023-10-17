package cl.tbd.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {

    private Long id_tarea;

    private String descripcion_tarea;

    private Boolean estado_tarea;

    private Long id_emergencia;

    // Constructor Vacío
    public Tarea(){

    }

    public Tarea(Long id_tarea, String descripcion_tarea, Boolean estado_tarea, Long id_emergencia) {
        this.id_tarea = id_tarea;
        this.descripcion_tarea = descripcion_tarea;
        this.estado_tarea = estado_tarea;
        this.id_emergencia = id_emergencia;
    }

    public Long getIdTarea() {
        return id_tarea;
    }

    public void setIdTarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getDescripcionTarea() {
        return descripcion_tarea;
    }

    public void setDescripcionTarea(String descripcion_tarea) {
        this.descripcion_tarea = descripcion_tarea;
    }

    public Boolean getEstadoTarea() {
        return estado_tarea;
    }

    public void setEstadoTarea(Boolean estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public Long getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
}
