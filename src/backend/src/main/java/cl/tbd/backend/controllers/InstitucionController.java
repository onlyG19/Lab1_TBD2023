package cl.tbd.backend.controllers;

import cl.tbd.backend.models.Institucion;
import cl.tbd.backend.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitucionController {

    private final InstitucionService institucionService;

    @Autowired
    public InstitucionController(InstitucionService institucionService) {
        this.institucionService = institucionService;
    }

    // GET/READ
    @GetMapping("/instituciones")
    public List<Institucion> getAllInstituciones() {
        return institucionService.getAllInstituciones();
    }

    @GetMapping("/institucion/{id}")
    public Institucion getInstitucionById(@PathVariable Long id) {
        return institucionService.getInstitucionById(id);
    }

    // CREATE
    @PostMapping("/institucion")
    public void createInstitucion(@RequestBody Institucion institucion) {
        institucionService.createInstitucion(institucion);
    }

    // UPDATE
    @PutMapping("/institucion/{id}")
    public void updateInstitucion(@PathVariable Long id, @RequestBody Institucion institucion) {
        institucionService.updateInstitucion(id,institucion);
    }

    // DELETE
    @DeleteMapping("/institucion/{id}")
    public void deleteInstitucion(@PathVariable Long id) {
        institucionService.deleteInstitucion(id);
    }
}