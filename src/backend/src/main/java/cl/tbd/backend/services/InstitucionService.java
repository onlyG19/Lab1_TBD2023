package cl.tbd.backend.services;

import cl.tbd.backend.models.Institucion;
import cl.tbd.backend.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/instituciones")
    public List<Institucion> getAllInstituciones(){
        return institucionRepository.getAllInstituciones();
    }

    @GetMapping("/institucion/{id}")
    public Institucion getInstitucionById(@PathVariable Long id) {
        return institucionRepository.getInstitucionById(id);
    }

    @PostMapping("/institucion")
    public void createInstitucion(@RequestBody Institucion institucion) {
        institucionRepository.createInstitucion(institucion);
    }

    @PutMapping("/institucion/{id}")
    public void updateInstitucion(@PathVariable Long id, @RequestBody Institucion institucion) {
        institucion.setIdInstitucion(id);
        institucionRepository.updateInstitucion(institucion);
    }

    @DeleteMapping("/institucion/{id}")
    public void deleteInstitucion(@PathVariable Long id) {
        institucionRepository.deleteInstitucion(id);
    }

}
