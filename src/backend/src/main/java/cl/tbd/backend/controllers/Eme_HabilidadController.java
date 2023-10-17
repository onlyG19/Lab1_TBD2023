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

import cl.tbd.backend.models.Eme_Habilidad;
import cl.tbd.backend.services.Eme_HabilidadService;

@RestController
public class Eme_HabilidadController {
    private final Eme_HabilidadService eme_habilidadService;

    @Autowired
    public Eme_HabilidadController(Eme_HabilidadService eme_habilidadService) {
        this.eme_habilidadService = eme_habilidadService;
    }

    // GET/READ
    @GetMapping("/eme_habilidades")
    public List<Eme_Habilidad> getAllEmeHabilidades() {
        return eme_habilidadService.getAllEmeHabilidades();
    }

    @GetMapping("/eme_habilidad/{id}")
    public Eme_Habilidad getEmeHabilidadById(@PathVariable Long id) {
        return eme_habilidadService.getEmeHabilidadById(id);
    }

    @GetMapping("/eme_habilidad/emergencia/{id_emergencia}")
    public List<Eme_Habilidad> getAllEmeHabilidadesByEmergenciaId(@PathVariable Long id_emergencia) {
        return eme_habilidadService.getAllEmeHabilidadesByEmergenciaId(id_emergencia);
    }

    @GetMapping("/eme_habilidad/habilidad/{id_habilidad}")
    public List<Eme_Habilidad> getAllEmeHabilidadesByHabilidadId(@PathVariable Long id_habilidad) {
        return eme_habilidadService.getAllEmeHabilidadesByHabilidadesId(id_habilidad);
    }

    // CREATE
    @PostMapping("/eme_habilidad")
    public void createEmeHabilidad(@RequestBody Eme_Habilidad eme_habilidad) {
        eme_habilidadService.createEmeHabilidad(eme_habilidad);
    }

    // UPDATE
    @PutMapping("/eme_habilidad/{id}")
    public void updateEmeHabilidad(@PathVariable Long id, @RequestBody Eme_Habilidad eme_habilidad) {
        eme_habilidadService.updateEmeHabilidad(id, eme_habilidad);
    }

    // DELETE
    @DeleteMapping("/eme_habilidad/{id}")
    public void deleteEmeHabilidad(@PathVariable Long id) {
        eme_habilidadService.deleteEmeHabilidad(id);
    }
}
