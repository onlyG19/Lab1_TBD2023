package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Voluntario;

public interface VoluntarioRepository {
    List<Voluntario> getAllVoluntarios();
    Voluntario getVoluntarioById(Long id);
    List<Voluntario> getAllVoluntariosByCoordinadorId(Long id_coordinador_asginado);
    void createVoluntario(Voluntario voluntario);
    void updateVoluntario(Voluntario voluntario);
    void deleteVoluntario(Long id);
}
