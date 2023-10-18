package cl.tbd.backend.services;

import cl.tbd.backend.models.Institucion;
import cl.tbd.backend.repositories.InstitucionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    public InstitucionService(InstitucionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }

    // GET/READ
    @GetMapping("/instituciones")
    public List<Institucion> getAllInstituciones() {
        return institucionRepository.getAllInstituciones();
    }

    @GetMapping("/institucion/{id}")
    public Institucion getInstitucionById(@PathVariable Long id) {
        return institucionRepository.getInstitucionById(id);
    }

    // CREATE
    @PostMapping("/institucion")
    public void createInstitucion(@RequestBody Institucion institucion) {
        institucionRepository.createInstitucion(institucion);
    }

    // UPDATE
    @PutMapping("/institucion/{id}")
    public void updateInstitucion(@PathVariable Long id, @RequestBody Institucion institucion) {
        institucion.setIdInstitucion(id);
        institucionRepository.updateInstitucion(institucion);
    }

    // DELETE
    @DeleteMapping("/institucion/{id}")
    public void deleteInstitucion(@PathVariable Long id) {
        institucionRepository.deleteInstitucion(id);
    }
}
