package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Ranking;

public interface RankingRepository {
    List<Ranking> getAllRankings();
    Ranking getRankingById(Long id);
    List<Ranking> getAllRankingsByVoluntarioId(Long id_voluntario);
    void createRanking(Ranking ranking);
    void updateRanking(Ranking ranking);
    void deleteRanking(Long id);
}
