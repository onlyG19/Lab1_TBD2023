package cl.tbd.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.backend.models.Voluntario;
import cl.tbd.backend.repositories.VoluntarioRepository;

@Service
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.getAllVoluntarios();
    }

    public Voluntario getVoluntarioById(long id) {
        return voluntarioRepository.getVoluntarioById(id);
    }

    public void createVoluntario(Voluntario voluntario) {
        voluntarioRepository.createVoluntario(voluntario);
    }

    public void updateVoluntario(Long id, Voluntario voluntario) {
        voluntario.setIdVoluntario(id);
        voluntarioRepository.updateVoluntario(voluntario);
    }

    public void deleteVoluntario(Long id) {
        voluntarioRepository.deleteVoluntario(id);
    }
}
