package cl.tbd.backend.services;

import cl.tbd.backend.models.Institucion;
import cl.tbd.backend.repositories.InstitucionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    public InstitucionService(InstitucionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }

    public List<Institucion> getAllInstituciones() {
        return institucionRepository.getAllInstituciones();
    }

    public Institucion getInstitucionById(Long id) {
        return institucionRepository.getInstitucionById(id);
    }

    public void createInstitucion(Institucion institucion) {
        institucionRepository.createInstitucion(institucion);
    }

    public void updateInstitucion(Long id, Institucion institucion) {
        institucion.setIdInstitucion(id);
        institucionRepository.updateInstitucion(institucion);
    }

    public void deleteInstitucion(Long id) {
        institucionRepository.deleteInstitucion(id);
    }
}
