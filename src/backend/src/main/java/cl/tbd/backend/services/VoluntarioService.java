package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.backend.models.Voluntario;
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
}
