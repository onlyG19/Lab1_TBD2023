package cl.tbd.backend.services;

import cl.tbd.backend.models.Institucion;
import cl.tbd.backend.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/instituciones")
    public List<Institucion> getAllInstituciones(){
        List<Institucion> listaInstituciones = institucionRepository.getAllInstituciones();
        return  listaInstituciones;
    }

    @GetMapping("/institucion/{id}")
    public Institucion getInstitucionById(@PathVariable Long id) {
        return institucionRepository.getInstitucionById(id);
    }
}
