package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Institucion;

import java.util.List;

public interface InstitucionRepository {
    List<Institucion> getAllInstituciones();
    Institucion getInstitucionById(Long id);
    void createInstitucion(Institucion institucion);
    void updateInstitucion(Institucion institucion);
    void deleteInstitucion(Long id);
}
