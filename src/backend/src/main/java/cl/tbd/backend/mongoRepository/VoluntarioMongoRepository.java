package cl.tbd.backend.mongoRepository;


import cl.tbd.backend.models.Voluntario;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface VoluntarioMongoRepository {

    public long getTotalHabilidadesCount();
}
