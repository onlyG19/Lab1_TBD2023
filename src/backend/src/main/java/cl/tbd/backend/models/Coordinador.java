package cl.tbd.backend.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Coordinador {

    @JsonProperty("id_coordinador")
    private Long id_coordinador;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("estado_salud")
    private String estado_salud;
    @JsonProperty("password")
    private String password;
    @JsonProperty("email")
    private String email;
    @JsonProperty("id_institucion")
    private Long id_institucion;
    @JsonProperty("created_at")
    private Date created_at;
    @JsonProperty("updated_at")
    private Date updated_at;



    public Coordinador() {
    }

    public Coordinador(Long id_coordinador, String nombre, String apellido, String estado_salud, String password, String email, Long id_institucion, Date created_at, Date updated_at) {
        this.id_coordinador = id_coordinador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado_salud = estado_salud;
        this.password = password;
        this.email = email;
        this.id_institucion = id_institucion;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Coordinador(String nombre, String apellido, String estado_salud, String password, String email, Long id_institucion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado_salud = estado_salud;
        this.password = password;
        this.email = email;
        this.id_institucion = id_institucion;
    }

    public Long getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(Long id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado_salud() {
        return estado_salud;
    }

    public void setEstado_salud(String estado_salud) {
        this.estado_salud = estado_salud;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }
}
