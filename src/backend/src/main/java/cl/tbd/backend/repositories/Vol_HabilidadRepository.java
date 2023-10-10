package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Vol_Habilidad;

public interface Vol_HabilidadRepository {
    List<Vol_Habilidad> getAllVolHabilidades();
    Vol_Habilidad getVolHabilidadById(Long id);
    List<Vol_Habilidad> getAllVolHabilidadesByVoluntarioId(Long id_voluntario);
    List<Vol_Habilidad> getAllVolHabilidadesByHabilidadId(Long id_habilidad);
    void createVolHabilidad(Vol_Habilidad vol_Habilidad);
    void updateVolHabilidad(Vol_Habilidad vol_Habilidad);
    void deleteVolHabilidad(Long id);
}
