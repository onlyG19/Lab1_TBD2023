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

import cl.tbd.backend.models.Emergencia;
import cl.tbd.backend.repositories.EmergenciaRepository;

@RestController
@Service
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

    @GetMapping("/emergencia/numeroTareasActivas/{id_emergencia}")
    public int numeroTareasActivasEmergencia(@PathVariable Long id_emergencia) {
        return emergenciaRepository.numeroTareasActivasEmergencia(id_emergencia);
    }
}
