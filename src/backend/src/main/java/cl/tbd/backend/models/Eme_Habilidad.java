package cl.tbd.backend.models;

public class Eme_Habilidad {

    private Long id_eme_habilidad;
    private Long id_emergencia;
    private Long id_habilidad;

    // Constructor vacío
    public Eme_Habilidad() {

    }

    public Eme_Habilidad(Long id_eme_habilidad, Long id_emergencia, Long id_habilidad) {
        this.id_eme_habilidad = id_eme_habilidad;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    public Eme_Habilidad(Long id_emergencia, Long id_habilidad) {
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    public Long getIdEmeHabilidad() {
        return id_eme_habilidad;
    }

    public void setIdEmeHabilidad(Long id_eme_habilidad) {
        this.id_eme_habilidad = id_eme_habilidad;
    }

    public Long getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Long getIdHabilidad() {
        return id_habilidad;
    }

    public void setIdHabilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
