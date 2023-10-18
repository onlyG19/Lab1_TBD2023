package cl.tbd.backend.services;

import cl.tbd.backend.models.Coordinador;
import cl.tbd.backend.repositories.CoordinadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class CoordinadorService {
    private final CoordinadorRepository coordinadorRepository;

    public CoordinadorService(CoordinadorRepository coordinadorRepository){
        this.coordinadorRepository = coordinadorRepository;

    }

    // GET
    @GetMapping("/coordinadores")
    public List<Coordinador> getAllCoordinador(){
        return coordinadorRepository.getAllCoordinador();
    }

    // CREATE
    @PostMapping("/coordinador")
    public void createCoordinador(@RequestBody Coordinador coordinador){
        coordinadorRepository.createCoordinador(coordinador);
    }

    @GetMapping("/coordinador/{id}")
    public Coordinador getCoordinadorById(@PathVariable Long id){
        return coordinadorRepository.getCoordinadorById(id);

    }

    public Coordinador findOneByEmail(String email){
        return coordinadorRepository.getCoordinadorByEmail(email);

    }

    // UPDATE
    @PutMapping("/coordinador/{id}")
    public String updateCoordinador(@PathVariable Long id, @RequestBody Coordinador coordinador){
        return coordinadorRepository.updateCoordinador(id,coordinador);
    }

    // DELETE
    @DeleteMapping("/coordinador/{id}")
    public String deleteCoordinador(@PathVariable Long id){
        return coordinadorRepository.deleteCoordinador(id);

    }



}
