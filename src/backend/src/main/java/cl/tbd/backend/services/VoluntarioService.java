package cl.tbd.backend.services;

import java.util.List;

import cl.tbd.backend.models.*;
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

import cl.tbd.backend.repositories.VoluntarioRepository;

@RestController
@Service
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    // GET/READ
    @GetMapping("/voluntarios")
    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.getAllVoluntarios();
    }

    @GetMapping("/voluntario/{id}")
    public Voluntario getVoluntarioById(@PathVariable long id) {
        return voluntarioRepository.getVoluntarioById(id);
    }

    // CREATE
    @PostMapping("/voluntario")
    public void createVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioRepository.createVoluntario(voluntario);
    }

    // UPDATE
    @PutMapping("/voluntario/{id}")
    public void updateVoluntario(@PathVariable Long id, @RequestBody Voluntario voluntario) {
        voluntario.setIdVoluntario(id);
        voluntarioRepository.updateVoluntario(voluntario);
    }

    // DELETE
    @DeleteMapping("/voluntario/{id}")
    public void deleteVoluntario(@PathVariable Long id) {
        voluntarioRepository.deleteVoluntario(id);
    }

    @PostMapping("/voluntario/register")
    public ResponseEntity<VoluntarioRegisterResponse> register(@RequestBody Registration registration){
        Voluntario voluntario = voluntarioRepository.getVoluntarioByEmail(registration.getEmail());
        VoluntarioRegisterResponse response = new VoluntarioRegisterResponse();
        if(voluntario == null){
            // Crear usuario
            voluntario = new Voluntario();
            voluntario.setEmailVoluntario(registration.getEmail());
            voluntario.setNombreVoluntario(registration.getNombre());
            voluntario.setApellidoVoluntario(registration.getApellido());
            voluntario.setDireccionVoluntario(registration.getDireccion());
            voluntario.setTelefonoVoluntario(registration.getTelefono());
            voluntario.setFechaNacimientoVoluntario(registration.getFecha_nacimiento());
            voluntario.setDisponibilidadVoluntario(registration.getDisponibilidad());
            voluntario.setPasswordVoluntario(new BCryptPasswordEncoder().encode(registration.getPassword()));
            voluntarioRepository.createVoluntario(voluntario);
            // Contruir response
            response.setError(false);
            response.setMessage("El usuario se creó correctamente");
            response.setUsuario(voluntario);
        }
        else{
            response.setError(true);
            response.setMessage("El usuario ya existe!");
            response.setUsuario(null);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/voluntario/login")
    public ResponseEntity<VoluntarioLoginResponse> loginUsuario(@RequestBody LoginRequest loginRequest){
        // Buscar el usuario por nombre de usuario en la base de datos
        Voluntario voluntario = voluntarioRepository.getVoluntarioByEmail(loginRequest.getEmail());
        VoluntarioLoginResponse response = new VoluntarioLoginResponse();

        if(voluntario != null &&
                new BCryptPasswordEncoder().matches(loginRequest.getPassword(), voluntario.getPasswordVoluntario())) {
            // El usuario existe y la contraseña coincide

            String token = TokenUtils.createToken(voluntario.getNombreVoluntario());

            // Configurar la respuesta con el token y otros datos necesarios
            response.setError(false);
            response.setMessage("Inicio de sesión exitoso");
            response.setToken(token);
            response.setUsuario(voluntario);
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
