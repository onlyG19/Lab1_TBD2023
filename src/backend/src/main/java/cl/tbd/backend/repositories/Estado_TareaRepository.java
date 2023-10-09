package cl.tbd.backend.repositories;

import java.util.List;

import cl.tbd.backend.models.Estado_Tarea;

public interface Estado_TareaRepository {
    List<Estado_Tarea> getAllEstado_Tareas();
    Estado_Tarea getEstado_TareaById(Long id);
    void createEstado_Tarea(Estado_Tarea estado_tarea);
    void updateEstado_Tarea(Estado_Tarea estado_tarea);
    void deleteEstado_Tarea(Long id);
}
