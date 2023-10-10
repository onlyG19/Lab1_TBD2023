package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Ranking;
import cl.tbd.backend.repositories.RankingRepository;

@Service
public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public List<Ranking> getAllRankings() {
        return rankingRepository.getAllRankings();
    }

    public Ranking getRankingById(Long id) {
        return rankingRepository.getRankingById(id);
    }

    public List<Ranking> getAllRankingsByVoluntarioId(Long id_voluntario) {
        return rankingRepository.getAllRankingsByVoluntarioId(id_voluntario);
    }

    public void createRanking(Ranking ranking) {
        rankingRepository.createRanking(ranking);
    }

    public void updateRanking(Long id, Ranking ranking) {
        ranking.setIdRanking(id);
        rankingRepository.updateRanking(ranking);
    }

    public void deleteRanking(Long id) {
        rankingRepository.deleteRanking(id);
    }
}
