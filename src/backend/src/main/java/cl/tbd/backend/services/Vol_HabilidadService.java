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

import cl.tbd.backend.models.Vol_Habilidad;
import cl.tbd.backend.repositories.Vol_HabilidadRepository;

@RestController
@Service
public class Vol_HabilidadService {
    private final Vol_HabilidadRepository vol_habilidadRepository;

    public Vol_HabilidadService(Vol_HabilidadRepository vol_habilidadRepository) {
        this.vol_habilidadRepository = vol_habilidadRepository;
    }

    // GET/READ
    @GetMapping("/vol_habilidades")
    public List<Vol_Habilidad> getAllVolHabilidades() {
        return vol_habilidadRepository.getAllVolHabilidades();
    }

    @GetMapping("/vol_habilidad/{id}")
    public Vol_Habilidad getVolHabilidadById(@PathVariable Long id) {
        return vol_habilidadRepository.getVolHabilidadById(id);
    }

    @GetMapping("/vol_habilidades/voluntario/{id_voluntario}")
    public List<Vol_Habilidad> getAllVolHabilidadesByVoluntarioId(@PathVariable Long id_voluntario) {
        return vol_habilidadRepository.getAllVolHabilidadesByVoluntarioId(id_voluntario);
    }

    @GetMapping("/vol_habilidades/habilidad/{id_habilidad}")
    public List<Vol_Habilidad> getAllVolHabilidadesByHabilidadId(@PathVariable Long id_habilidad) {
        return vol_habilidadRepository.getAllVolHabilidadesByHabilidadId(id_habilidad);
    }

    // CREATE
    @PostMapping("/vol_habilidad")
    public void createVolHabilidad(@RequestBody Vol_Habilidad vol_Habilidad) {
        vol_habilidadRepository.createVolHabilidad(vol_Habilidad);
    }

    // UPDATE
    @PutMapping("/vol_habilidad/{id}")
    public void updateVolHabilidad(@PathVariable Long id, @RequestBody Vol_Habilidad vol_Habilidad) {
        vol_Habilidad.setIdVolHabilidad(id);
        vol_habilidadRepository.updateVolHabilidad(vol_Habilidad);
    }

    // DELETE
    @DeleteMapping("/vol_habilidad/{id}")
    public void deleteVolHabilidad(@PathVariable Long id) {
        vol_habilidadRepository.deleteVolHabilidad(id);
    }
}
