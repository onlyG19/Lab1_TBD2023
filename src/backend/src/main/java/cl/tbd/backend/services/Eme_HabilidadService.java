package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Eme_Habilidad;
import cl.tbd.backend.repositories.Eme_HabilidadRepository;

@Service
public class Eme_HabilidadService {
    private final Eme_HabilidadRepository eme_habilidadRepository;

    public Eme_HabilidadService(Eme_HabilidadRepository eme_habilidadRepository) {
        this.eme_habilidadRepository = eme_habilidadRepository;
    }

    public List<Eme_Habilidad> getAllEmeHabilidades() {
        return eme_habilidadRepository.getAllEmeHabilidades();
    }

    public Eme_Habilidad getEmeHabilidadById(Long id) {
        return eme_habilidadRepository.getEmeHabilidadById(id);
    }

    public List<Eme_Habilidad> getAllEmeHabilidadesByEmergenciaId(Long id_emergencia) {
        return eme_habilidadRepository.getAllEmeHabilidadesByEmergenciaId(id_emergencia);
    }

    public List<Eme_Habilidad> getAllEmeHabilidadesByHabilidadesId(Long id_habilidad) {
        return eme_habilidadRepository.getAllEmeHabilidadesByHabilidadId(id_habilidad);
    }

    public void createEmeHabilidad(Eme_Habilidad eme_habilidad) {
        eme_habilidadRepository.createEmeHabilidad(eme_habilidad);
    }

    public void updateEmeHabilidad(Long id, Eme_Habilidad eme_habilidad) {
        eme_habilidad.setIdEmeHabilidad(id);
        eme_habilidadRepository.updateEmeHabilidad(eme_habilidad);
    }

    public void deleteEmeHabilidad(Long id) {
        eme_habilidadRepository.deleteEmeHabilidad(id);
    }
}
