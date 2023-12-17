package cl.tbd.backend.mongoRepository;


import cl.tbd.backend.models.Voluntario;

import java.util.List;

public interface VoluntarioMongoRepository {

    public List<Voluntario> findAll();

    public Voluntario crearVoluntario(Voluntario newVoluntario);
}
