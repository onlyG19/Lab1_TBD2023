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

import cl.tbd.backend.models.Tarea_Habilidad;
import cl.tbd.backend.services.Tarea_HabilidadService;

@RestController
public class Tarea_HabilidadController {
    private final Tarea_HabilidadService tarea_habilidadService;

    @Autowired
    public Tarea_HabilidadController(Tarea_HabilidadService tarea_habilidadService) {
        this.tarea_habilidadService  = tarea_habilidadService;
    }

    // GET/READ
    @GetMapping("/tarea_habilidades")
    public List<Tarea_Habilidad> getAllTareaHabilidades() {
        return tarea_habilidadService.getAllTareaHabilidades();
    }

    @GetMapping("/tarea_habilidad/{id}")
    public Tarea_Habilidad getTareaHabilidadById(@PathVariable Long id) {
        return tarea_habilidadService.getTareaHabilidadById(id);
    }

    @GetMapping("/tarea_habilidades/tarea/{id_tarea}")
    public List<Tarea_Habilidad> getAllTareaHabilidadesByTareaId(@PathVariable Long id_tarea) {
        return tarea_habilidadService.getAllTareaHabilidadesByTareaId(id_tarea);
    }

    @GetMapping("/tarea_habilidades/habilidad/{id_habilidad}")
    public List<Tarea_Habilidad> getAllTareaHabilidadesByHabilidadId(@PathVariable Long id_habilidad) {
        return tarea_habilidadService.getAllTareaHabilidadesByHabilidadId(id_habilidad);
    }

    // CREATE
    @PostMapping("/tarea_habilidad")
    public void createTareaHabilidad(@RequestBody Tarea_Habilidad tarea_habilidad) {
        tarea_habilidadService.createTareaHabilidad(tarea_habilidad);
    }

    // UPDATE
    @PutMapping("/tarea_habilidad/{id}")
    public void updateTareaHabilidad(@PathVariable Long id, @RequestBody Tarea_Habilidad tarea_habilidad) {
        tarea_habilidadService.updateTareaHabilidad(id, tarea_habilidad);
    }

    // DELETE
    @DeleteMapping("/tarea_habilidad/{id}")
    public void deleteTareaHabilidad(@PathVariable Long id) {
        tarea_habilidadService.deleteTareaHabilidad(id);
    }
}
