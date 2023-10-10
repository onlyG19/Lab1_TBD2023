package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Eme_Habilidad;

public interface Eme_HabilidadRepository {
    List<Eme_Habilidad> getAllEmeHabilidades();
    Eme_Habilidad getEmeHabilidadById(Long id);
    List<Eme_Habilidad> getAllEmeHabilidadesByEmergenciaId(Long id_emergencia);
    List<Eme_Habilidad> getAllEmeHabilidadesByHabilidadId(Long id_habilidad);
    void createEmeHabilidad(Eme_Habilidad eme_habilidad);
    void updateEmeHabilidad(Eme_Habilidad eme_habilidad);
    void deleteEmeHabilidad(Long id);
}
