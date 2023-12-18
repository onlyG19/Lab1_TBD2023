package cl.tbd.backend.servicesMongo;

import cl.tbd.backend.models.Voluntario;
import cl.tbd.backend.mongoRepository.VoluntarioMongoRepositoryImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Service
@RestController
@RequestMapping("/monguito/voluntario")
public class VoluntarioServiceMongo {


    @Autowired
    private VoluntarioMongoRepositoryImp voluntarioMongoRepositoryImp;


    @GetMapping("/all")
    public List<Voluntario> all(){
        return voluntarioMongoRepositoryImp.findAll();
    }

    @PostMapping("/crear")
    public Voluntario crearVoluntario(@RequestBody Voluntario newVoluntario){
        return voluntarioMongoRepositoryImp.crearVoluntario(newVoluntario);
    }

    @GetMapping("/habilidad/count")
    public long contarHabilidades(){
        return voluntarioMongoRepositoryImp.getTotalHabilidadesCount();
    }

    @DeleteMapping("/{nombre}/eliminar")
    public void eliminar(@PathVariable String nombre){
        voluntarioMongoRepositoryImp.eliminar(nombre);
    }

    @PutMapping("/actualizar")
    public Voluntario actualizar(@RequestBody Voluntario newVoluntario){
        return voluntarioMongoRepositoryImp.actualizar(newVoluntario);
    }
}
