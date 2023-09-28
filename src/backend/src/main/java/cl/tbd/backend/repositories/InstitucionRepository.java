package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Institucion;

import java.util.List;

public interface InstitucionRepository {
    public List<Institucion> getAllInstituciones();
    public Institucion getInstitucionById(Long id);
}
