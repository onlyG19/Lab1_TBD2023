package cl.tbd.backend.models;

public class Coordinador {

    private Long id_coordinador;
    private String nombre_coordinador;
    private String apellido_coordinador;
    private Long id_institucion;
    private String password_coordinador;
    private String email_coordinador;

    // Constructor Vacío
    public Coordinador() {

    }

    public Coordinador(Long id_coordinador, String nombre, String apellido, String password,
                       String email, Long id_institucion) {
        this.id_coordinador = id_coordinador;
        this.nombre_coordinador = nombre;
        this.apellido_coordinador = apellido;
        this.id_institucion = id_institucion;
        this.password_coordinador = password;
        this.email_coordinador = email;
    }

    public Long getIdCoordinador() {
        return id_coordinador;
    }

    public void setIdCoordinador(Long id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNombreCoordinador() {
        return nombre_coordinador;
    }

    public void setNombreCoordinador(String nombre) {
        this.nombre_coordinador = nombre;
    }

    public String getApellidoCoordinador() {
        return apellido_coordinador;
    }

    public void setApellidoCoordinador(String apellido) {
        this.apellido_coordinador = apellido;
    }

    public String getPasswordCoordinador() {
        return password_coordinador;
    }

    public void setPasswordCoordinador(String password) {
        this.password_coordinador = password;
    }

    public String getEmailCoordinador() {
        return email_coordinador;
    }

    public void setEmailCoordinador(String email) {
        this.email_coordinador = email;
    }

    public Long getIdInstitucion() {
        return id_institucion;
    }

    public void setIdInstitucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }
}
