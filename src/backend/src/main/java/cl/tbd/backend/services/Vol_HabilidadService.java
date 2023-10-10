package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Vol_Habilidad;
import cl.tbd.backend.repositories.Vol_HabilidadRepository;

@Service
public class Vol_HabilidadService {
    private final Vol_HabilidadRepository vol_habilidadRepository;

    public Vol_HabilidadService(Vol_HabilidadRepository vol_habilidadRepository) {
        this.vol_habilidadRepository = vol_habilidadRepository;
    }

    public List<Vol_Habilidad> getAllVolHabilidades() {
        return vol_habilidadRepository.getAllVolHabilidades();
    }

    public Vol_Habilidad getVolHabilidadById(Long id) {
        return vol_habilidadRepository.getVolHabilidadById(id);
    }

    public List<Vol_Habilidad> getAllVolHabilidadesByVoluntarioId(Long id) {
        return vol_habilidadRepository.getAllVolHabilidadesByVoluntarioId(id);
    }

    public List<Vol_Habilidad> getAllVolHabilidadesByHabilidadId(Long id) {
        return vol_habilidadRepository.getAllVolHabilidadesByHabilidadId(id);
    }

    public void createVolHabilidad(Vol_Habilidad vol_Habilidad) {
        vol_habilidadRepository.createVolHabilidad(vol_Habilidad);
    }

    public void updateVolHabilidad(Long id, Vol_Habilidad vol_Habilidad) {
        vol_Habilidad.setIdVolHabilidad(id);
        vol_habilidadRepository.updateVolHabilidad(vol_Habilidad);
    }

    public void deleteVolHabilidad(Long id) {
        vol_habilidadRepository.deleteVolHabilidad(id);
    }
}
