package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Ranking;

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
    public Ranking getRankingById(Long id) {
        String sql = "SELECT * FROM ranking WHERE id_ranking = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
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
    public void createRanking(Ranking ranking) {
        String sql = "INSERT INTO ranking (id_voluntario, puntuacion, fecha) VALUES (:id_voluntario, :puntuacion, :fecha)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("id_voluntario", ranking.getIdVoluntario())
                    .addParameter("puntuacion", ranking.getPuntuacion())
                    .addParameter("fecha", ranking.getFecha())
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
        String sql = "UPDATE ranking SET id_voluntario = :id_voluntario, puntuacion = :puntuacion, fecha = :fecha WHERE id_ranking = :id_ranking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql, true)
                    .addParameter("id_voluntario", ranking.getIdVoluntario())
                    .addParameter("puntuacion", ranking.getPuntuacion())
                    .addParameter("fecha", ranking.getFecha())
                    .addParameter("id_ranking", ranking.getIdRanking())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el ranking", e);
        }
    }

    @Override
    public void deleteRanking(Long id) {
        String sql = "DELETE FROM ranking WHERE id_ranking = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el ranking", e);
        }
    }
}
