package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Emergencia;
import cl.tbd.backend.models.Voluntario;

public interface EmergenciaRepository {
    List<Emergencia> getAllEmergencias();
    Emergencia getEmergenciaById(Long id);
    List<Emergencia> getAllEmergenciasByCoordinadorId(Long id_coordinador);
    List<Emergencia> getAllEmergenciasByInstitucionId(Long id_institucion);
    void createEmergencia(Emergencia emergencia);
    void updateEmergencia(Emergencia emergencia);
    void deleteEmergencia(Long id);
    Long cantidadTareasActivasByEmergenciaId(Long id_emergencia);
    List<Voluntario> obtenerVoluntariosEmergenciaRadio(Long id_emergencia, float radio);
}
