package cl.tbd.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vol_Habilidad {
    @JsonProperty("id_vol_habilidad")
    private Long id_vol_habilidad;
    @JsonProperty("id_voluntario")
    private Long id_voluntario;
    @JsonProperty("id_habilidad")
    private Long id_habilidad;

    public Vol_Habilidad() {

    }
    
    public Vol_Habilidad(Long id_vol_habilidad, Long id_voluntario, Long id_habilidad) {
        this.id_vol_habilidad = id_vol_habilidad;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    public Vol_Habilidad(Long id_voluntario, Long id_habilidad) {
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }
    
    public Long getIdVolHabilidad() {
        return this.id_vol_habilidad;
    }

    public void setIdVolHabilidad(Long id_vol_habilidad) {
        this.id_vol_habilidad = id_vol_habilidad;
    }

    public Long getIdVoluntario() {
        return this.id_voluntario;
    }

    public void setIdVoluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Long getIdHabilidad() {
        return this.id_habilidad;
    }

    public void setIdHabilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
