package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Habilidad;
import cl.tbd.backend.repositories.HabilidadRepository;

@Service
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    public List<Habilidad> getAllHabilidades() {
        return habilidadRepository.getAllHabilidades();
    }

    public Habilidad getHabilidadById(Long id) {
        return habilidadRepository.getHabilidadById(id);
    }

    public void createHabilidad(Habilidad habilidad) {
        habilidadRepository.createHabilidad(habilidad);
    }

    public void updateHabilidad(Long id, Habilidad habilidad) {
        habilidad.setIdHabilidad(id);
        habilidadRepository.updateHabilidad(habilidad);
    }

    public void deleteHabilidad(Long id) {
        habilidadRepository.deleteHabilidad(id);
    }
}
