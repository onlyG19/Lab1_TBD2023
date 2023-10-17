package cl.tbd.backend.services;

import cl.tbd.backend.models.Coordinador;
import cl.tbd.backend.repositories.CoordinadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinadorService {
    private final CoordinadorRepository coordinadorRepository;

    public CoordinadorService(CoordinadorRepository coordinadorRepository){
        this.coordinadorRepository = coordinadorRepository;

    }

    public List<Coordinador> getAllCoordinador(){
        return coordinadorRepository.getAllCoordinador();
    }

    public void createCoordinador(Coordinador coordinador){
        coordinadorRepository.createCoordinador(coordinador);
    }

    public Coordinador getCoordinadorById(Long id){
        return coordinadorRepository.getCoordinadorById(id);

    }

    public Coordinador findOneByEmail(String email){
        return coordinadorRepository.getCoordinadorByEmail(email);

    }

    public String updateCoordinador(Long id, Coordinador coordinador){
        return coordinadorRepository.updateCoordinador(id,coordinador);
    }

    public String deleteCoordinador(Long id){
        return coordinadorRepository.deleteCoordinador(id);

    }



}
