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

import cl.tbd.backend.models.Estado_Tarea;
import cl.tbd.backend.services.Estado_TareaService;

@RestController
public class Estado_TareaController {
    private final Estado_TareaService estado_tareaService;

    @Autowired
    public Estado_TareaController(Estado_TareaService estado_tareaService) {
        this.estado_tareaService = estado_tareaService;
    }

    @GetMapping("/estado_tareas")
    public List<Estado_Tarea> getAllEstado_Tarea() {
        return estado_tareaService.getAllEstado_Tareas();
    }

    @GetMapping("/estado_tarea/{id}")
    public Estado_Tarea getEstado_TareaById(@PathVariable Long id) {
        return estado_tareaService.getEstado_TareaById(id);
    }

    @PostMapping("/estado_tarea")
    public void createEstado_Tarea(@RequestBody Estado_Tarea estado_tarea) {
        estado_tareaService.createEstado_Tarea(estado_tarea);
    }

    @PutMapping("/estado_tarea/{id}")
    public void updateEstado_Tarea(@PathVariable Long id, @RequestBody Estado_Tarea estado_tarea) {
        estado_tareaService.updateEstado_Tarea(id, estado_tarea);
    }

    @DeleteMapping("/estado_tarea/{id}")
    public void deleteEstado_Tarea(@PathVariable Long id) {
        estado_tareaService.deleteEstado_Tarea(id);
    }
}
