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

import cl.tbd.backend.models.Tarea_Habilidad;
import cl.tbd.backend.repositories.Tarea_HabilidadRepository;

@RestController
@Service
public class Tarea_HabilidadService {
    private final Tarea_HabilidadRepository tarea_habilidadRepository;

    public Tarea_HabilidadService(Tarea_HabilidadRepository tarea_habilidadRepository) {
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }

    // GET/READ
    @GetMapping("/tarea_habilidades")
    public List<Tarea_Habilidad> getAllTareaHabilidades() {
        return tarea_habilidadRepository.getAllTareaHabilidades();
    }

    @GetMapping("/tarea_habilidad/{id}")
    public Tarea_Habilidad getTareaHabilidadById(@PathVariable Long id) {
        return tarea_habilidadRepository.getTareaHabilidadById(id);
    }

    @GetMapping("/tarea_habilidades/tarea/{id_tarea}")
    public List<Tarea_Habilidad> getAllTareaHabilidadesByTareaId(@PathVariable Long id_tarea) {
        return tarea_habilidadRepository.getAllTareaHabilidadesByTareaId(id_tarea);
    }

    @GetMapping("/tarea_habilidades/habilidad/{id_habilidad}")
    public List<Tarea_Habilidad> getAllTareaHabilidadesByHabilidadId(@PathVariable Long id_habilidad) {
        return tarea_habilidadRepository.getAllTareaHabilidadesbyHabilidadesId(id_habilidad);
    }

    // CREATE
    @PostMapping("/tarea_habilidad")
    public void createTareaHabilidad(@RequestBody Tarea_Habilidad tarea_habilidad) {
        tarea_habilidadRepository.createTareaHabilidad(tarea_habilidad);
    }

    // UPDATE
    @PutMapping("/tarea_habilidad/{id}")
    public void updateTareaHabilidad(@PathVariable Long id, @RequestBody Tarea_Habilidad tarea_habilidad) {
        tarea_habilidad.setIdTareaHabilidad(id);
        tarea_habilidadRepository.updateTareaHabilidad(tarea_habilidad);
    }

    // DELETE
    @DeleteMapping("/tarea_habilidad/{id}")
    public void deleteTareaHabilidad(@PathVariable Long id) {
        tarea_habilidadRepository.deleteTareaHabilidad(id);
    }
}
