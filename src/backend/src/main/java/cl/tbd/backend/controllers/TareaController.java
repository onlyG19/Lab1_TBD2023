package cl.tbd.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.backend.models.Tarea;
import cl.tbd.backend.services.TareaService;

@RestController
public class TareaController {
    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/tareas")
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/tarea/{id}")
    public Tarea getTareaById(@PathVariable Long id) {
        return tareaService.getTareaById(id);
    }

    @GetMapping("/tareas/emergencia/{id_emergencia}")
    public List<Tarea> getAllTareasByEmergenciaId(@PathVariable Long id_emergencia) {
        return tareaService.getAllTareasByEmergenciaId(id_emergencia);
    }

    @GetMapping("/tareas/estado_tarea/{id_estado_tarea}")
    public List<Tarea> getAllTareasByEstadoTareaId(@PathVariable Long id_estado_tarea) {
        return tareaService.getAllTareasByEstadoTareaId(id_estado_tarea);
    }

    @PostMapping("/tarea")
    public void createTarea(@RequestBody Tarea tarea) {
        tareaService.createTarea(tarea);
    }

    @PutMapping("/tarea/{id}")
    public void updateTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        tareaService.updateTarea(id, tarea);
    }

    @DeleteMapping("/tarea/{id}")
    public void deleteTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
    }
}
