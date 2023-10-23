package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Ranking;
import cl.tbd.backend.models.RankingLite;

@Repository
public class RankingRepositoryImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> getAllRankings() {
        String sql = "SELECT * FROM ranking";
        List<Ranking> listaRankings;

        try (Connection conn = sql2o.open()) {
            listaRankings = conn.createQuery(sql).executeAndFetch(Ranking.class);
            
            return listaRankings;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todos los Rankings", e);
        }
    }

    @Override
    public Ranking getRankingById(Long id_ranking) {
        String sql = "SELECT * FROM ranking WHERE id_ranking = :id_ranking";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id_ranking", id_ranking)
                    .executeAndFetchFirst(Ranking.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el Ranking por ID", e);
        }
    }

    @Override
    public List<Ranking> getAllRankingsByVoluntarioId(Long id_voluntario) {
        String sql = "SELECT * FROM ranking WHERE id_voluntario = :id_voluntario";
        List<Ranking> listaRankings;

        try (Connection conn = sql2o.open()) {
            listaRankings = conn.createQuery(sql)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetch(Ranking.class);

            return listaRankings;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los rankings del voluntario", e);
        }
    }

    @Override
    public List<Ranking> getAllRankingsByTareaId(Long id_tarea) {
        String sql = "SELECT * FROM ranking WHERE id_tarea = :id_tarea";
        List<Ranking> listaRankings;

        try (Connection conn = sql2o.open()) {
            listaRankings = conn.createQuery(sql)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Ranking.class);

            return listaRankings;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los rankings de la tarea", e);
        }
    }

    @Override
    public void createRanking(Ranking ranking) {
        String sql = "INSERT INTO ranking (id_voluntario, posicion_ranking, id_tarea, asignado_ranking) " +
                "VALUES (:id_voluntario, :posicion_ranking, :id_tarea, :asignado_ranking)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("id_voluntario", ranking.getIdVoluntario())
                    .addParameter("posicion_ranking", ranking.getPosicionRanking())
                    .addParameter("id_tarea", ranking.getIdTarea())
                    .addParameter("asignado_ranking", ranking.getAsignadoRanking())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            ranking.setIdRanking(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el ranking", e);
        }
    }

    @Override
    public void updateRanking(Ranking ranking) {
        String sql = "UPDATE ranking SET id_voluntario = :id_voluntario, posicion_ranking = :posicion_ranking, " +
                "id_tarea = :id_tarea, asignado_ranking = :asignado_ranking WHERE id_ranking = :id_ranking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql, true)
                    .addParameter("id_voluntario", ranking.getIdVoluntario())
                    .addParameter("posicion_ranking", ranking.getPosicionRanking())
                    .addParameter("id_tarea", ranking.getIdTarea())
                    .addParameter("asignado_ranking", ranking.getAsignadoRanking())
                    .addParameter("id_ranking", ranking.getIdRanking())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el ranking", e);
        }
    }

    @Override
    public void deleteRanking(Long id_ranking) {
        String sql = "DELETE FROM ranking WHERE id_ranking = :id_ranking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_ranking", id_ranking)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el ranking", e);
        }
    }

    @Override
    public List<RankingLite> rankingLite(int id_tarea, int c_voluntarios) {
        String sql = "SELECT * FROM calcular_ranking_lite(:id_tarea, :c_voluntarios)";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id_tarea", id_tarea)
                    .addParameter("c_voluntarios", c_voluntarios)
                    .executeAndFetch(RankingLite.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al mostrar el ranking", e);
        }
    }

    @Override
    public void rankingFull(int id_tarea, int c_voluntarios) {
        String sql = "SELECT calcular_ranking(:id_tarea, :c_voluntarios)";

        try (Connection conn = sql2o.open()) {
                conn.createQuery(sql)
                    .addParameter("id_tarea", id_tarea)
                    .addParameter("c_voluntarios", c_voluntarios)
                    .executeAndFetch(RankingLite.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al mostrar el ranking", e);
        }
    }
}
