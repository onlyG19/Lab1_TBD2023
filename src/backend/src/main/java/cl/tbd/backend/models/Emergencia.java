package cl.tbd.backend.models;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emergencia {
    @JsonProperty("id_emergencia")
    private Long id_emergencia;
    @JsonProperty("nombre_emergencia")
    private String nombre_emergencia;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("fecha_hora_creacion")
    private Timestamp fecha_hora_creacion;
    @JsonProperty("id_coordinador")
    private Long id_coordinador;
    @JsonProperty("id_institucion")
    private Long id_institucion;

    public Emergencia() {
        
    }
    
    public Emergencia(Long id_emergencia, String nombre_emergencia, String descripcion, Timestamp fecha_hora_creacion, Long id_coordinador, Long id_institucion) {
        this.id_emergencia = id_emergencia;
        this.nombre_emergencia = nombre_emergencia;
        this.descripcion = descripcion;
        this.fecha_hora_creacion = fecha_hora_creacion;
        this.id_coordinador = id_coordinador;
        this.id_institucion = id_institucion;
    }

    public Emergencia(String nombre_emergencia, String descripcion, Timestamp fecha_hora_creacion, Long id_coordinador, Long id_institucion) {
        this.nombre_emergencia = nombre_emergencia;
        this.descripcion = descripcion;
        this.fecha_hora_creacion = fecha_hora_creacion;
        this.id_coordinador = id_coordinador;
        this.id_institucion = id_institucion;
    }

    public Long getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public String getNombreEmergencia() {
        return nombre_emergencia;
    }

    public void setNombreEmergencia(String nombre_emergencia) {
        this.nombre_emergencia = nombre_emergencia;
    }

    public String getDescripcionEmergencia() {
        return descripcion;
    }

    public void setDescripcionEmergencia(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaHoraCreacionEmergencia() {
        return fecha_hora_creacion;
    }

    public void setFechaHoraCreacionEmergencia(Timestamp fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }

    public Long getIdCoordinadorEmergencia() {
        return id_coordinador;
    }

    public void setIdCoordinadorEmergencia(Long id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public Long getIdInstitucionEmergencia() {
        return id_institucion;
    }

    public void setIdInstitucionEmergencia(Long id_institucion) {
        this.id_institucion = id_institucion;
    }
}
