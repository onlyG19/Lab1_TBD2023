package cl.tbd.backend.models;

public class Institucion {
    private Long id_institucion;
    private String nombre_institucion;

    // Constructor vacío
    public Institucion() {

    }

    public Institucion(Long id_institucion, String nombre_institucion) {
        this.id_institucion = id_institucion;
        this.nombre_institucion = nombre_institucion;
    }

    public Institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

    public Long getIdInstitucion() {
        return id_institucion;
    }

    public void setIdInstitucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }

    public String getName() {
        return nombre_institucion;
    }

    public void setName(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }
}
