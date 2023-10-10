package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Tarea;
import cl.tbd.backend.repositories.TareaRepository;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getAllTareas() {
        return tareaRepository.getAllTareas();
    }

    public Tarea getTareaById(Long id) {
        return tareaRepository.getTareaById(id);
    }

    public List<Tarea> getAllTareasByEmergenciaId(Long id_emergencia) {
        return tareaRepository.getAllTareasByEmergenciaId(id_emergencia);
    }

    public List<Tarea> getAllTareasByEstadoTareaId(Long id_estado_tarea) {
        return tareaRepository.getAllTareasByEstadoTareaId(id_estado_tarea);
    }

    public void createTarea(Tarea tarea) {
        tareaRepository.createTarea(tarea);
    }

    public void updateTarea(Long id, Tarea tarea) {
        tarea.setIdTarea(id);
        tareaRepository.updateTarea(tarea);
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteTarea(id);
    }
}
