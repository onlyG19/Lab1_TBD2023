package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Tarea_Habilidad;

public interface Tarea_HabilidadRepository {
    List<Tarea_Habilidad> getAllTareaHabilidades();
    Tarea_Habilidad getTareaHabilidadById(Long id);
    List<Tarea_Habilidad> getAllTareaHabilidadesByTareaId(Long id_tarea);
    List<Tarea_Habilidad> getAllTareaHabilidadesbyHabilidadesId(Long id_habilidad);
    void createTareaHabilidad(Tarea_Habilidad tarea_habilidad);
    void updateTareaHabilidad(Tarea_Habilidad tarea_habilidad);
    void deleteTareaHabilidad(Long id);
}
