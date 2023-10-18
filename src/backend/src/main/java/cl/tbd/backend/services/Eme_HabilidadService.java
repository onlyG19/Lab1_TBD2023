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

import cl.tbd.backend.models.Eme_Habilidad;
import cl.tbd.backend.repositories.Eme_HabilidadRepository;

@RestController
@Service
public class Eme_HabilidadService {
    private final Eme_HabilidadRepository eme_habilidadRepository;

    public Eme_HabilidadService(Eme_HabilidadRepository eme_habilidadRepository) {
        this.eme_habilidadRepository = eme_habilidadRepository;
    }

    // GET/READ
    @GetMapping("/eme_habilidades")
    public List<Eme_Habilidad> getAllEmeHabilidades() {
        return eme_habilidadRepository.getAllEmeHabilidades();
    }

    @GetMapping("/eme_habilidad/{id}")
    public Eme_Habilidad getEmeHabilidadById(@PathVariable Long id) {
        return eme_habilidadRepository.getEmeHabilidadById(id);
    }

    @GetMapping("/eme_habilidad/emergencia/{id_emergencia}")
    public List<Eme_Habilidad> getAllEmeHabilidadesByEmergenciaId(@PathVariable Long id_emergencia) {
        return eme_habilidadRepository.getAllEmeHabilidadesByEmergenciaId(id_emergencia);
    }

    @GetMapping("/eme_habilidad/habilidad/{id_habilidad}")
    public List<Eme_Habilidad> getAllEmeHabilidadesByHabilidadesId(@PathVariable Long id_habilidad) {
        return eme_habilidadRepository.getAllEmeHabilidadesByHabilidadId(id_habilidad);
    }

    // CREATE
    @PostMapping("/eme_habilidad")
    public void createEmeHabilidad(@RequestBody Eme_Habilidad eme_habilidad) {
        eme_habilidadRepository.createEmeHabilidad(eme_habilidad);
    }

    // UPDATE
    @PutMapping("/eme_habilidad/{id}")
    public void updateEmeHabilidad(@PathVariable Long id, @RequestBody  Eme_Habilidad eme_habilidad) {
        eme_habilidad.setIdEmeHabilidad(id);
        eme_habilidadRepository.updateEmeHabilidad(eme_habilidad);
    }

    // DELETE
    @DeleteMapping("/eme_habilidad/{id}")
    public void deleteEmeHabilidad(@PathVariable Long id) {
        eme_habilidadRepository.deleteEmeHabilidad(id);
    }
}
