package cl.tbd.backend.servicesMongo;

import cl.tbd.backend.models.Voluntario;
import cl.tbd.backend.mongoRepository.VoluntarioMongoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/monguito/voluntario")
public class VoluntarioServiceMongo {

    @Autowired
    private VoluntarioMongoRepositoryImp voluntarioMongoRepositoryImp;

    @GetMapping("/all")
    public List<Voluntario> obtenerTodos(){

        List<Voluntario> voluntarios =  voluntarioMongoRepositoryImp.findAll();
        for(Voluntario voluntario: voluntarios){
            System.out.println(voluntario.getNombreVoluntario());
        }
        return voluntarios;
    }

    @PostMapping("/crear")
    public Voluntario crearVoluntario(@RequestBody Voluntario newVoluntario){
        return voluntarioMongoRepositoryImp.crearVoluntario(newVoluntario);
    }

}
