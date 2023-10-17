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

import cl.tbd.backend.models.Habilidad;
import cl.tbd.backend.services.HabilidadService;

@RestController
public class HabilidadController {
    private final HabilidadService habilidadService;

    @Autowired
    public HabilidadController(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    // GET/READ
    @GetMapping("/habilidades")
    public List<Habilidad> getAllHabilidades() {
        return habilidadService.getAllHabilidades();
    }

    @GetMapping("/habilidad/{id}")
    public Habilidad getHabilidadById(@PathVariable Long id) {
        return habilidadService.getHabilidadById(id);
    }

    // CREATE
    @PostMapping("/habilidad")
    public void createHabilidad(@RequestBody Habilidad habilidad) {
        habilidadService.createHabilidad(habilidad);
    }

    // UPDATE
    @PutMapping("/habilidad/{id}")
    public void updateHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidad) {
        habilidadService.updateHabilidad(id, habilidad);
    }

    // DELETE
    @DeleteMapping("/habilidad/{id}")
    public void deleteHabilidad(@PathVariable Long id) {
        habilidadService.deleteHabilidad(id);
    }
}
