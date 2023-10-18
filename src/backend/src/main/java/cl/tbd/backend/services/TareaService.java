package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.backend.models.Tarea;
import cl.tbd.backend.repositories.TareaRepository;

@RestController
@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // GET/READ
    @GetMapping("/tareas")
    public List<Tarea> getAllTareas() {
        return tareaRepository.getAllTareas();
    }

    @GetMapping("/tarea/{id}")
    public Tarea getTareaById(@PathVariable Long id) {
        return tareaRepository.getTareaById(id);
    }

    @GetMapping("/tareas/emergencia/{id_emergencia}")
    public List<Tarea> getAllTareasByEmergenciaId(@PathVariable Long id_emergencia) {
        return tareaRepository.getAllTareasByEmergenciaId(id_emergencia);
    }

    // CREATE
    @PostMapping("/tarea")
    public void createTarea(@RequestBody Tarea tarea) {
        tareaRepository.createTarea(tarea);
    }

    // UPDATE
    @PutMapping("/tarea/{id}")
    public void updateTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        tarea.setIdTarea(id);
        tareaRepository.updateTarea(tarea);
    }

    // DELETE
    @DeleteMapping("/tarea/{id}")
    public void deleteTarea(@PathVariable Long id) {
        tareaRepository.deleteTarea(id);
    }
}
