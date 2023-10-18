package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.backend.models.Ranking;
import cl.tbd.backend.repositories.RankingRepository;

@RestController
@Service
public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    // GET/READ
    @GetMapping("/rankings")
    public List<Ranking> getAllRankings() {
        return rankingRepository.getAllRankings();
    }

    @GetMapping("/ranking/{id}")
    public Ranking getRankingById(@PathVariable Long id) {
        return rankingRepository.getRankingById(id);
    }

    @GetMapping("/rankings/voluntario/{id_voluntario}")
    public List<Ranking> getAllRankingsByVoluntarioId(@PathVariable Long id_voluntario) {
        return rankingRepository.getAllRankingsByVoluntarioId(id_voluntario);
    }

    @GetMapping("/rankings/tarea/{id_tarea}")
    public List<Ranking> getAllRankingsByTareaId(@PathVariable Long id_tarea) {
        return rankingRepository.getAllRankingsByTareaId(id_tarea);
    }

    // CREATE
    @PostMapping("/ranking")
    public void createRanking(@RequestBody Ranking ranking) {
        rankingRepository.createRanking(ranking);
    }

    // UPDATE
    @PutMapping("/ranking/{id}")
    public void updateRanking(@PathVariable Long id, @RequestBody Ranking ranking) {
        ranking.setIdRanking(id);
        rankingRepository.updateRanking(ranking);
    }

    // DELETE
    @DeleteMapping("/ranking/{id}")
    public void deleteRanking(@PathVariable Long id) {
        rankingRepository.deleteRanking(id);
    }
}
