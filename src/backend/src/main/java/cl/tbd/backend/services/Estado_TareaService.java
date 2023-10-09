package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Estado_Tarea;
import cl.tbd.backend.repositories.Estado_TareaRepository;

@Service
public class Estado_TareaService {
    private final Estado_TareaRepository estado_tareaRepository;

    public Estado_TareaService(Estado_TareaRepository estado_tareaRepository) {
        this.estado_tareaRepository = estado_tareaRepository;
    }

    public List<Estado_Tarea> getAllEstado_Tareas() {
        return estado_tareaRepository.getAllEstado_Tareas();
    }

    public Estado_Tarea getEstado_TareaById(Long id) {
        return estado_tareaRepository.getEstado_TareaById(id);
    }

    public void createEstado_Tarea(Estado_Tarea estado_tarea) {
        estado_tareaRepository.createEstado_Tarea(estado_tarea);
    }

    public void updateEstado_Tarea(Long id, Estado_Tarea estado_tarea) {
        estado_tarea.setIdEstado_Tarea(id);
        estado_tareaRepository.updateEstado_Tarea(estado_tarea);
    }

    public void deleteEstado_Tarea(Long id) {
        estado_tareaRepository.deleteEstado_Tarea(id);
    }
}
