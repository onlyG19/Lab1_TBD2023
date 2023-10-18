package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Tarea;

public interface TareaRepository {
    List<Tarea> getAllTareas();
    Tarea getTareaById(Long id);
    List<Tarea> getAllTareasByEmergenciaId(Long id_emergencia);
    void createTarea(Tarea tarea);
    void updateTarea(Tarea tarea);
    void deleteTarea(Long id);
}
