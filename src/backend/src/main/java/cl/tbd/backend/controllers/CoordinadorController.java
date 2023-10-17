package cl.tbd.backend.controllers;

import cl.tbd.backend.models.Coordinador;
import cl.tbd.backend.models.Voluntario;
import cl.tbd.backend.services.CoordinadorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoordinadorController {

    private CoordinadorService coordinadorService;

    @Autowired
    public CoordinadorController(CoordinadorService coordinadorService){
        this.coordinadorService = coordinadorService;
    }

    // GET
    @GetMapping("/coordinadores")
    public List<Coordinador> getAllCordinadores(){
        return coordinadorService.getAllCoordinador();
    }

    @GetMapping("/coordinador/{id}")
    @ResponseBody
    public Coordinador getCoordinadorById(@PathVariable Long id) {
        return coordinadorService.getCoordinadorById(id);
    }

    // CREATE
    @PostMapping("/coordinador")
    @ResponseBody
    public void createCoordinador(@RequestBody Coordinador coordinador){
        coordinadorService.createCoordinador(coordinador);
    }

    // UPDATE
    @PutMapping("/coordinador/{id}")
    @ResponseBody
    public String updateCoordinador(@PathVariable Long id, @RequestBody Coordinador coordinador){
        return coordinadorService.updateCoordinador(id, coordinador);
    }
    // DELETE
    @DeleteMapping("/coordinador/{id}")
    @ResponseBody
    public String deleteCoordinador(@PathVariable Long id){
        return coordinadorService.deleteCoordinador(id);
    }





//---------------------
//  Se puede probar este metodo idealmente cuando se tenga el JWT implementado.
//---------------------
//    @PostMapping("/register")
//    public ResponseEntity<CoordinadorRegisterResponse> registerCoordinador(@RequestBody Registration registration){
//        Coordinador coordinador = coordinadorRepository.findOneByEmail(registration.getEmail());
//        CoordinadorRegisterResponse response = new CoordinadorRegisterResponse();
//        if(coordinador == null){
//            // Crear usuario
//            coordinador = new Coordinador();
//            coordinador.setCorreo_electronico(registration.getEmail());
//            coordinador.setNombre(registration.getNombre());
//            coordinador.setApellido(registration.getApellido());
//            coordinador.setPassword(new BCryptPasswordEncoder().encode(registration.getPassword()));
//            coordinador = coordinadorRepository.createCoordinador(coordinador);
//            // Contruir response
//            response.setError(false);
//            response.setMessage("El usuario se creó correctamente");
//            response.setUsuario(coordinador);
//        }
//        else{
//            response.setError(true);
//            response.setMessage("El usuario ya existe!");
//            response.setUsuario(null);
//        }
//        return ResponseEntity.ok(response);
//    }


}
