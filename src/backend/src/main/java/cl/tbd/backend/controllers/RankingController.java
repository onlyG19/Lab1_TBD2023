package cl.tbd.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.backend.models.Ranking;
import cl.tbd.backend.services.RankingService;

@RestController
public class RankingController {
    private final RankingService rankingService;

    @Autowired
    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/rankings")
    public List<Ranking> getAllRankings() {
        return rankingService.getAllRankings();
    }

    @GetMapping("/ranking/{id}")
    public Ranking getRankingById(@PathVariable Long id) {
        return rankingService.getRankingById(id);
    }

    @GetMapping("/rankings/voluntario/{id_voluntario}")
    public List<Ranking> getAllRankingsByVoluntarioId(@PathVariable Long id_voluntario) {
        return rankingService.getAllRankingsByVoluntarioId(id_voluntario);
    }

    @PostMapping("/ranking")
    public void createRanking(@RequestBody Ranking ranking) {
        rankingService.createRanking(ranking);
    }

    @PutMapping("/ranking/{id}")
    public void updateRanking(@PathVariable Long id, @RequestBody Ranking ranking) {
        rankingService.updateRanking(id, ranking);
    }

    @DeleteMapping("/ranking/{id}")
    public void deleteRanking(@PathVariable Long id) {
        rankingService.deleteRanking(id);
    }
}
