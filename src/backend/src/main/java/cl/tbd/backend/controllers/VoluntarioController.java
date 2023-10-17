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

import cl.tbd.backend.models.Voluntario;
import cl.tbd.backend.services.VoluntarioService;

@RestController
public class VoluntarioController {
    private final VoluntarioService voluntarioService;

    @Autowired
    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    // GET/READ
    @GetMapping("/voluntarios")
    public List<Voluntario> getAllVoluntarios() {
        return voluntarioService.getAllVoluntarios();
    }

    @GetMapping("/voluntario/{id}")
    public Voluntario getVoluntarioById(@PathVariable Long id) {
        return voluntarioService.getVoluntarioById(id);
    }

    // CREATE
    @PostMapping("/voluntario")
    public void createVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioService.createVoluntario(voluntario);
    }

    // UPDATE
    @PutMapping("/voluntario/{id}")
    public void updateVoluntario(@PathVariable Long id, @RequestBody Voluntario voluntario) {
        voluntarioService.updateVoluntario(id, voluntario);
    }

    // DELETE
    @DeleteMapping("/voluntario/{id}")
    public void deleteVoluntario(@PathVariable Long id) {
        voluntarioService.deleteVoluntario(id);
    }
}
