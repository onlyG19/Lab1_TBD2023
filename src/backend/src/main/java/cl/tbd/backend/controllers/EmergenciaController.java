package cl.tbd.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.backend.models.Emergencia;
import cl.tbd.backend.services.EmergenciaService;

@RestController
public class EmergenciaController {
    private final EmergenciaService emergenciaService;

    @Autowired
    public EmergenciaController(EmergenciaService emergenciaService) {
        this.emergenciaService = emergenciaService;
    }

    // GET
    @GetMapping("/emergencias")
    public List<Emergencia> getAllEmergencias() {
        return emergenciaService.getAllEmergencias();
    }

    @GetMapping("/emergencia/{id}")
    public Emergencia getEmergenciaById(@PathVariable Long id) {
//        System.out.println(emergenciaService.getEmergenciaById(id).getFechaCreacionEmergencia());
        return emergenciaService.getEmergenciaById(id);
    }

    @GetMapping("/emergencias/coordinador/{id_coordinador}")
    public List<Emergencia> getAllEmergenciasByCoordinadorId(@PathVariable Long id_coordinador) {
        return emergenciaService.getAllEmergenciasByCoordinadorId(id_coordinador);
    }

    @GetMapping("/emergencias/institucion/{id_institucion}")
    public List<Emergencia> getAllEmergenciasByInstitucionId(@PathVariable Long id_institucion) {
        return emergenciaService.getAllEmergenciasByInstitucionId(id_institucion);
    }

    // CREATE
    @PostMapping("/emergencia")
    public void createEmergencia(@RequestBody Emergencia emergencia) {
        emergenciaService.createEmergencia(emergencia);
    }

    // UPDATE
    @PutMapping("/emergencia/{id}")
    public void updateEmergencia(@PathVariable Long id, @RequestBody Emergencia emergencia) {
        emergenciaService.updateEmergencia(id, emergencia);
    }

    // DELETE
    @DeleteMapping("/emergencia/{id}")
    public void deleteEmergencia(@PathVariable Long id) {
        emergenciaService.deleteEmergencia(id);
    }
}
