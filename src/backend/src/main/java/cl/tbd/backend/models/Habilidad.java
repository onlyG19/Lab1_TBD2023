package cl.tbd.backend.models;

public class Habilidad {
    private Long id_habilidad;
    private String nombre_habilidad;

    public Habilidad(Long id_habilidad, String nombre_habilidad) {
        this.id_habilidad = id_habilidad;
        this.nombre_habilidad = nombre_habilidad;
    }

    public Habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }

    public Long getIdHabilidad() {
        return id_habilidad;
    }

    public void setIdHabilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getName() {
        return nombre_habilidad;
    }

    public void setName(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }
}
