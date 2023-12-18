package cl.tbd.backend.mongoRepository;

public class TotalHabilidadesCountResult {

    private long totalHabilidades;

    public TotalHabilidadesCountResult() {
    }

    public TotalHabilidadesCountResult(long totalHabilidades) {
        this.totalHabilidades = totalHabilidades;
    }

    public long getTotalHabilidades() {
        return totalHabilidades;
    }

    public void setTotalHabilidades(long totalHabilidades) {
        this.totalHabilidades = totalHabilidades;
    }
}
