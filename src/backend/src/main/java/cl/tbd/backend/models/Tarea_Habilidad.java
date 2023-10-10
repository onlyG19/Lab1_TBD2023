package cl.tbd.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea_Habilidad {
    @JsonProperty("id_tarea_habilidad")
    private Long id_tarea_habilidad;
    @JsonProperty("id_tarea")
    private Long id_tarea;
    @JsonProperty("id_habilidad")
    private Long id_habilidad;

    public Tarea_Habilidad() {

    }

    public Tarea_Habilidad(Long id_tarea_habilidad, Long id_tarea, Long id_habilidad) {
        this.id_tarea_habilidad = id_tarea_habilidad;
        this.id_tarea = id_tarea;
        this.id_habilidad = id_habilidad;
    }

    public Tarea_Habilidad(Long id_tarea, Long id_habilidad) {
        this.id_tarea = id_tarea;
        this.id_habilidad = id_habilidad;
    }

    public Long getIdTareaHabilidad() {
        return id_tarea_habilidad;
    }

    public void setIdTareaHabilidad(Long id_tarea_habilidad) {
        this.id_tarea_habilidad = id_tarea_habilidad;
    }

    public Long getIdTarea() {
        return id_tarea;
    }

    public void setIdTarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Long getIdHabilidad() {
        return id_habilidad;
    }

    public void setIdHabilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
