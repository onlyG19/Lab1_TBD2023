package cl.tbd.backend.services;

import cl.tbd.backend.models.*;
import cl.tbd.backend.repositories.CoordinadorRepository;
import cl.tbd.backend.security.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class CoordinadorService {
    private final CoordinadorRepository coordinadorRepository;

    public CoordinadorService(CoordinadorRepository coordinadorRepository){
        this.coordinadorRepository = coordinadorRepository;

    }

    // GET
    @GetMapping("/coordinadores")
    public List<Coordinador> getAllCoordinador(){
        return coordinadorRepository.getAllCoordinador();
    }

    // CREATE
    @PostMapping("/coordinador")
    public void createCoordinador(@RequestBody Coordinador coordinador){
        coordinadorRepository.createCoordinador(coordinador);
    }

    @GetMapping("/coordinador/{id}")
    public Coordinador getCoordinadorById(@PathVariable Long id){
        return coordinadorRepository.getCoordinadorById(id);

    }

    public Coordinador findOneByEmail(String email){
        return coordinadorRepository.getCoordinadorByEmail(email);

    }

    // UPDATE
    @PutMapping("/coordinador/{id}")
    public String updateCoordinador(@PathVariable Long id, @RequestBody Coordinador coordinador){
        return coordinadorRepository.updateCoordinador(id,coordinador);
    }

    // DELETE
    @DeleteMapping("/coordinador/{id}")
    public String deleteCoordinador(@PathVariable Long id){
        return coordinadorRepository.deleteCoordinador(id);

    }


    @PostMapping("/coordinador/register")
    public ResponseEntity<CoordinadorRegisterResponse> registerUsuario(@RequestBody RegistrationCoordinador registration){
        Coordinador coordinador = coordinadorRepository.getCoordinadorByEmail(registration.getEmail());
        CoordinadorRegisterResponse response = new CoordinadorRegisterResponse();
        if(coordinador == null){
            // Se crea usuario
            coordinador = new Coordinador();
            coordinador.setEmailCoordinador(registration.getEmail());
            coordinador.setNombreCoordinador(registration.getNombre());
            coordinador.setApellidoCoordinador(registration.getApellido());
            coordinador.setPasswordCoordinador(new BCryptPasswordEncoder().encode(registration.getPassword()));
            coordinadorRepository.createCoordinador(coordinador);
            // Response
            response.setError(false);
            response.setMessage("El usuario se creo correctamente");
            response.setUsuario(coordinador);
            return ResponseEntity.ok(response);
        }
        else{
            response.setError(true);
            response.setMessage("El usuario ya existe!");
            response.setUsuario(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }


    }

    @PostMapping("/coordinador/login")
    public ResponseEntity<CoordinadorLoginResponse> loginUsuario(@RequestBody LoginRequest loginRequest){
        // Buscar el usuario por nombre de usuario en la base de datos
        Coordinador coordinador = coordinadorRepository.getCoordinadorByEmail(loginRequest.getEmail());
        CoordinadorLoginResponse response = new CoordinadorLoginResponse();

        if(coordinador != null &&
                new BCryptPasswordEncoder().matches(loginRequest.getPassword(), coordinador.getPasswordCoordinador())) {
            // El usuario existe y la contraseña coincide

            String token = TokenUtils.createToken(coordinador.getNombreCoordinador());

            // Configurar la respuesta con el token y otros datos necesarios
            response.setError(false);
            response.setMessage("Inicio de sesión exitoso");
            response.setToken(token);
            response.setUsuario(coordinador);
            return ResponseEntity.ok(response);

        } else {
            // El usuario no existe o la contraseña es incorrecta
            response.setError(true);
            response.setMessage("Credenciales de inicio de sesión no válidas");
            response.setToken(null);
            response.setUsuario(null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }



}
