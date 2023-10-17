package cl.tbd.backend.models;

import java.util.Date;


public class Emergencia {

    private Long id_emergencia;
    private String nombre_emergencia;
    private String descripcion_emergencia;
    private Date fecha_creacion_emergencia;
    private Long id_coordinador;
    private Long id_institucion;

    // Constructor Vacío
    public Emergencia(){

    }
    
    public Emergencia(Long id_emergencia, String nombre_emergencia, String descripcion_emergencia,
                      Date fecha_creacion_emergencia, Long id_coordinador, Long id_institucion) {
        this.id_emergencia = id_emergencia;
        this.nombre_emergencia = nombre_emergencia;
        this.descripcion_emergencia = descripcion_emergencia;
        this.fecha_creacion_emergencia = fecha_creacion_emergencia;
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
        return descripcion_emergencia;
    }

    public void setDescripcionEmergencia(String descripcion) {
        this.descripcion_emergencia = descripcion;
    }

    public Date getFechaCreacionEmergencia() {
        return fecha_creacion_emergencia;
    }

    public void setFechaCreacionEmergencia(Date fecha_hora_creacion) {
        this.fecha_creacion_emergencia = fecha_hora_creacion;
    }

    public Long getIdCoordinador() {
        return id_coordinador;
    }

    public void setIdCoordinador(Long id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public Long getIdInstitucion() {
        return id_institucion;
    }

    public void setIdInstitucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }
}
