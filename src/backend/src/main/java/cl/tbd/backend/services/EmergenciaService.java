package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Emergencia;
import cl.tbd.backend.repositories.EmergenciaRepository;

@Service
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;

    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.getAllEmergencias();
    }

    public Emergencia getEmergenciaById(Long id) {
        return emergenciaRepository.getEmergenciaById(id);
    }

    public List<Emergencia> getAllEmergenciasByCoordinadorId(Long id_coordinador) {
        return emergenciaRepository.getAllEmergenciasByCoordinadorId(id_coordinador);
    }

    public List<Emergencia> getAllEmergenciasByInstitucionId(Long id_institucion) {
        return emergenciaRepository.getAllEmergenciasByInstitucionId(id_institucion);
    }

    public void createEmergencia(Emergencia emergencia) {
        emergenciaRepository.createEmergencia(emergencia);
    }

    public void updateEmergencia(Long id, Emergencia emergencia) {
        emergencia.setIdEmergencia(id);
        emergenciaRepository.updateEmergencia(emergencia);
    }

    public void deleteEmergencia(Long id) {
        emergenciaRepository.deleteEmergencia(id);
    }
}
