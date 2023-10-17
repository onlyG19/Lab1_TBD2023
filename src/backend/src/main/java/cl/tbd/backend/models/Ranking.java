package cl.tbd.backend.models;

public class Ranking {

    private Long id_ranking;

    private Long id_voluntario;

    private Integer posicion_ranking;

    private Long id_tarea;

    private Boolean asignado_ranking;

    // Constructor vacío
    public Ranking() {

    }

    public Ranking(Long id_ranking, Long id_voluntario, Integer posicion_ranking, Long id_tarea,
                   Boolean asignado_ranking) {
        this.id_ranking = id_ranking;
        this.id_voluntario = id_voluntario;
        this.posicion_ranking = posicion_ranking;
        this.id_tarea = id_tarea;
        this.asignado_ranking = asignado_ranking;
    }

    public Long getIdRanking() {
        return id_ranking;
    }

    public void setIdRanking(Long id_ranking) {
        this.id_ranking = id_ranking;
    }

    public Long getIdVoluntario() {
        return id_voluntario;
    }

    public void setIdVoluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getPosicionRanking() {
        return posicion_ranking;
    }

    public void setPosicionRanking(Integer posicion_ranking) {
        this.posicion_ranking = posicion_ranking;
    }

    public Long getIdTarea() {
        return id_tarea;
    }

    public void setIdTarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Boolean getAsignadoRanking() {
        return asignado_ranking;
    }

    public void setAsignadoRanking(Boolean asignado_ranking) {
        this.asignado_ranking = asignado_ranking;
    }
}
