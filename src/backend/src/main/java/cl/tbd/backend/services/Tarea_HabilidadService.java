package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Tarea_Habilidad;
import cl.tbd.backend.repositories.Tarea_HabilidadRepository;

@Service
public class Tarea_HabilidadService {
    private final Tarea_HabilidadRepository tarea_habilidadRepository;

    public Tarea_HabilidadService(Tarea_HabilidadRepository tarea_habilidadRepository) {
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }

    public List<Tarea_Habilidad> getAllTareaHabilidades() {
        return tarea_habilidadRepository.getAllTareaHabilidades();
    }

    public Tarea_Habilidad getTareaHabilidadById(Long id) {
        return tarea_habilidadRepository.getTareaHabilidadById(id);
    }

    public List<Tarea_Habilidad> getAllTareaHabilidadesByTareaId(Long id_tarea) {
        return tarea_habilidadRepository.getAllTareaHabilidadesByTareaId(id_tarea);
    }

    public List<Tarea_Habilidad> getAllTareaHabilidadesByHabilidadId(Long id_habilidad) {
        return tarea_habilidadRepository.getAllTareaHabilidadesbyHabilidadesId(id_habilidad);
    }

    public void createTareaHabilidad(Tarea_Habilidad tarea_habilidad) {
        tarea_habilidadRepository.createTareaHabilidad(tarea_habilidad);
    }

    public void updateTareaHabilidad(Long id, Tarea_Habilidad tarea_habilidad) {
        tarea_habilidad.setIdTareaHabilidad(id);
        tarea_habilidadRepository.updateTareaHabilidad(tarea_habilidad);
    }

    public void deleteTareaHabilidad(Long id) {
        tarea_habilidadRepository.deleteTareaHabilidad(id);
    }
}
