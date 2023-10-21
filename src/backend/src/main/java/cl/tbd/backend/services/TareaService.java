package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import cl.tbd.backend.models.Tarea;
import cl.tbd.backend.repositories.TareaRepository;

@RestController
@Service
@CrossOrigin(origins = "http://localhost:3030/")
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
