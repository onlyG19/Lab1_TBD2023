package cl.tbd.backend.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {
    @JsonProperty("id_tarea")
    private Long id_tarea;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("fecha_asignacion")
    private Date fecha_asignacion;
    @JsonProperty("id_emergencia")
    private Long id_emergencia;
    @JsonProperty("id_estado_tarea")
    private Long id_estado_tarea;

    public Tarea() {

    }

    public Tarea(Long id_tarea, String descripcion, Date fecha_asignacion, Long id_emergencia, Long id_estado_tarea) {
        this.id_tarea = id_tarea;
        this.descripcion = descripcion;
        this.fecha_asignacion = fecha_asignacion;
        this.id_emergencia = id_emergencia;
        this.id_estado_tarea = id_estado_tarea;
    }

    public Tarea(String descripcion, Date fecha_asignacion, Long id_emergencia, Long id_estado_tarea) {
        this.descripcion = descripcion;
        this.fecha_asignacion = fecha_asignacion;
        this.id_emergencia = id_emergencia;
        this.id_estado_tarea = id_estado_tarea;
    }

    public Long getIdTarea() {
        return id_tarea;
    }

    public void setIdTarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAsignacion() {
        return fecha_asignacion;
    }

    public void setFechaAsignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public Long getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Long getIdEstadoTarea() {
        return id_estado_tarea;
    }

    public void setIdEstadoTarea(Long id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }
}
