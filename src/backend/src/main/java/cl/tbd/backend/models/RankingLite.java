package cl.tbd.backend.models;


public class RankingLite {

    private Integer id_tarea;
    private Integer id_voluntario;
    private Integer total_puntos;
    private Integer lugar;
    private Boolean se_asigna;

    public RankingLite(Integer id_tarea, Integer id_voluntario, Integer total_puntos, Integer lugar, Boolean se_asigna) {
        this.id_tarea = id_tarea;
        this.id_voluntario = id_voluntario;
        this.total_puntos = total_puntos;
        this.lugar = lugar;
        this.se_asigna = se_asigna;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getTotal_puntos() {
        return total_puntos;
    }

    public void setTotal_puntos(Integer total_puntos) {
        this.total_puntos = total_puntos;
    }

    public Integer getLugar() {
        return lugar;
    }

    public void setLugar(Integer lugar) {
        this.lugar = lugar;
    }

    public Boolean getSe_asigna() {
        return se_asigna;
    }

    public void setSe_asigna(Boolean se_asigna) {
        this.se_asigna = se_asigna;
    }
}
