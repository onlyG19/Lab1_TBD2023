package cl.tbd.backend.models;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ranking {
    @JsonProperty("id_ranking")
    private Long id_ranking;
    @JsonProperty("puntuacion")
    private Integer puntuacion;
    @JsonProperty("fecha")
    private Timestamp fecha;
    @JsonProperty("id_voluntario")
    private Long id_voluntario;

    public Ranking() {

    }

    public Ranking(Long id_ranking, Integer puntuacion, Timestamp fecha, Long id_voluntario) {
        this.id_ranking = id_ranking;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.id_voluntario = id_voluntario;
    }

    public Ranking(Integer puntuacion, Timestamp fecha, Long id_voluntario) {
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.id_voluntario = id_voluntario;
    }

    public Long getIdRanking() {
        return id_ranking;
    }

    public void setIdRanking(Long id_ranking) {
        this.id_ranking = id_ranking;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Long getIdVoluntario() {
        return id_voluntario;
    }

    public void setIdVoluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    
}
