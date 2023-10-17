package cl.tbd.backend.models;

import java.sql.Date;

public class Voluntario {

    private Long id_voluntario;

    private String nombre_voluntario;

    private String apellido_voluntario;

    private String telefono_voluntario;

    private String direccion_voluntario;

    private Date fecha_nacimiento_voluntario;

    private Date disponibilidad_voluntario;

    private String password_voluntario;

    private String email_voluntario;

    // Constructor vacío
    public Voluntario() {

    }

    public Voluntario(Long id_voluntario, String nombre_voluntario, String apellido_voluntario,
                      String telefono_voluntario, String direccion_voluntario, Date fecha_nacimiento_voluntario,
                      Date disponibilidad_voluntario, String password_voluntario, String email_voluntario) {
        this.id_voluntario = id_voluntario;
        this.nombre_voluntario = nombre_voluntario;
        this.apellido_voluntario = apellido_voluntario;
        this.telefono_voluntario = telefono_voluntario;
        this.direccion_voluntario = direccion_voluntario;
        this.fecha_nacimiento_voluntario = fecha_nacimiento_voluntario;
        this.disponibilidad_voluntario = disponibilidad_voluntario;
        this.password_voluntario = password_voluntario;
        this.email_voluntario = email_voluntario;
    }

    public Long getIdVoluntario() {
        return id_voluntario;
    }

    public void setIdVoluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public String getNombreVoluntario() {
        return nombre_voluntario;
    }

    public void setNombreVoluntario(String nombre_voluntario) {
        this.nombre_voluntario = nombre_voluntario;
    }

    public String getApellidoVoluntario() {
        return apellido_voluntario;
    }

    public void setApellidoVoluntario(String apellido_voluntario) {
        this.apellido_voluntario = apellido_voluntario;
    }

    public String getTelefonoVoluntario() {
        return telefono_voluntario;
    }

    public void setTelefonoVoluntario(String telefono_voluntario) {
        this.telefono_voluntario = telefono_voluntario;
    }

    public String getDireccionVoluntario() {
        return direccion_voluntario;
    }

    public void setDireccionVoluntario(String direccion_voluntario) {
        this.direccion_voluntario = direccion_voluntario;
    }

    public Date getFechaNacimientoVoluntario() {
        return fecha_nacimiento_voluntario;
    }

    public void setFechaNacimientoVoluntario(Date fecha_nacimiento_voluntario) {
        this.fecha_nacimiento_voluntario = fecha_nacimiento_voluntario;
    }

    public Date getDisponibilidadVoluntario() {
        return disponibilidad_voluntario;
    }

    public void setDisponibilidadVoluntario(Date disponibilidad_voluntario) {
        this.disponibilidad_voluntario = disponibilidad_voluntario;
    }

    public String getPasswordVoluntario() {
        return password_voluntario;
    }

    public void setPasswordVoluntario(String password_voluntario) {
        this.password_voluntario = password_voluntario;
    }

    public String getEmailVoluntario() {
        return email_voluntario;
    }

    public void setEmailVoluntario(String email_voluntario) {
        this.email_voluntario = email_voluntario;
    }
}
