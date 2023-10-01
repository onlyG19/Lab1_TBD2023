package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Habilidad;

public interface HabilidadRepository {
    List<Habilidad> getAllHabilidades();
    Habilidad getHabilidadById(Long id);
    void createHabilidad(Habilidad habilidad);
    void updateHabilidad(Habilidad habilidad);
    void deleteHabilidad(Long id);
}
