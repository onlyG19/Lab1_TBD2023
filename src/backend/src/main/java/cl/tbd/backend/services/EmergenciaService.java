package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import cl.tbd.backend.models.Emergencia;
import cl.tbd.backend.repositories.EmergenciaRepository;

@RestController
@Service
@CrossOrigin(origins = "http://localhost:3030/")
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;

    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    // GET
    @GetMapping("/emergencias")
    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.getAllEmergencias();
    }

    @GetMapping("/emergencia/{id}")
    public Emergencia getEmergenciaById(@PathVariable Long id) {
        return emergenciaRepository.getEmergenciaById(id);
    }

    @GetMapping("/emergencias/coordinador/{id_coordinador}")
    public List<Emergencia> getAllEmergenciasByCoordinadorId(@PathVariable Long id_coordinador) {
        return emergenciaRepository.getAllEmergenciasByCoordinadorId(id_coordinador);
    }

    @GetMapping("/emergencias/institucion/{id_institucion}")
    public List<Emergencia> getAllEmergenciasByInstitucionId(@PathVariable Long id_institucion) {
        return emergenciaRepository.getAllEmergenciasByInstitucionId(id_institucion);
    }

    @GetMapping("/emergencia/numeroTareasActivas/{id_emergencia}")
    public Long cantidadTareasActivasByEmergenciaId(@PathVariable Long id_emergencia){
        return emergenciaRepository.cantidadTareasActivasByEmergenciaId(id_emergencia);
    }

    // CREATE
    @PostMapping("/emergencia")
    public void createEmergencia(@RequestBody Emergencia emergencia) {
        emergenciaRepository.createEmergencia(emergencia);
    }

    // UPDATE
    @PutMapping("/emergencia/{id}")
    public void updateEmergencia(@PathVariable Long id, @RequestBody Emergencia emergencia) {
        emergencia.setIdEmergencia(id);
        emergenciaRepository.updateEmergencia(emergencia);
    }

    // DELETE
    @DeleteMapping("/emergencia/{id}")
    public void deleteEmergencia(@PathVariable Long id) {
        emergenciaRepository.deleteEmergencia(id);
    }
}
