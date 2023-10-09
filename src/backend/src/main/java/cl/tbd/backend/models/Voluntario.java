package cl.tbd.backend.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Voluntario {
    @JsonProperty("id_voluntario")
    private Long id_voluntario;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("fecha_de_nacimiento")
    private Date fecha_de_nacimiento;
    @JsonProperty("genero")
    private String genero;
    @JsonProperty("ranking")
    private Integer ranking;
    @JsonProperty("id_coordinador_asignado")
    private Long id_coordinador_asignado;

    public Voluntario() {
        
    }

    public Voluntario(Long id_voluntario, String nombre, String apellido, String email, String telefono, String direccion, Date fecha_de_nacimiento, String genero, Integer ranking, Long id_coordinador_asginado) {
        this.id_voluntario = id_voluntario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.genero = genero;
        this.ranking = ranking;
        this.id_coordinador_asignado = id_coordinador_asginado;
    }

    public Voluntario(String nombre, String apellido, String email, String telefono, String direccion, Date fecha_de_nacimiento, String genero, Integer ranking, Long id_coordinador_asginado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.genero = genero;
        this.ranking = ranking;
        this.id_coordinador_asignado = id_coordinador_asginado;
    }

    public Long getIdVoluntario() {
        return id_voluntario;
    }

    public void setIdVoluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public String getNombreVoluntario() {
        return nombre;
    }

    public void setNombreVoluntario(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoVoluntario() {
        return apellido;
    }

    public void setApellidoVoluntario(String apellido) {
        this.apellido = apellido;
    }

    public String getEmailVoluntario() {
        return email;
    }

    public void setEmailVoluntario(String email) {
        this.email = email;
    }

    public String getTelefonoVoluntario() {
        return telefono;
    }

    public void setTelefonoVoluntario(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionVoluntario() {
        return direccion;
    }

    public void setDireccionVoluntario(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaDeNacimientoVoluntario() {
        return fecha_de_nacimiento;
    }

    public void setFechaDeNacimientoVoluntario(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getGeneroVoluntario() {
        return genero;
    }

    public void setGeneroVoluntario(String genero) {
        this.genero = genero;
    }

    public Integer getRankingVoluntario() {
        return ranking;
    }

    public void setRankingVoluntario(Integer ranking) {
        this.ranking = ranking;
    }

    public Long getIdCoordinadorAsignado() {
        return id_coordinador_asignado;
    }

    public void setIdCoordinadorAsignado(Long id_coordinador_asignado) {
        this.id_coordinador_asignado = id_coordinador_asignado;
    }
}
