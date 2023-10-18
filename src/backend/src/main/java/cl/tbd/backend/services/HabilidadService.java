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

import cl.tbd.backend.models.Habilidad;
import cl.tbd.backend.repositories.HabilidadRepository;

@RestController
@Service
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    // GET/READ
    @GetMapping("/habilidades")
    public List<Habilidad> getAllHabilidades() {
        return habilidadRepository.getAllHabilidades();
    }

    @GetMapping("/habilidad/{id}")
    public Habilidad getHabilidadById(@PathVariable Long id) {
        return habilidadRepository.getHabilidadById(id);
    }

    // CREATE
    @PostMapping("/habilidad")
    public void createHabilidad(@RequestBody Habilidad habilidad) {
        habilidadRepository.createHabilidad(habilidad);
    }

    // UPDATE
    @PutMapping("/habilidad/{id}")
    public void updateHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidad) {
        habilidad.setIdHabilidad(id);
        habilidadRepository.updateHabilidad(habilidad);
    }

    // DELETE
    @DeleteMapping("/habilidad/{id}")
    public void deleteHabilidad(@PathVariable Long id) {
        habilidadRepository.deleteHabilidad(id);
    }
}
