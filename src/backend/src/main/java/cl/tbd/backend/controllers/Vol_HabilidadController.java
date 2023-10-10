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

import cl.tbd.backend.models.Vol_Habilidad;
import cl.tbd.backend.services.Vol_HabilidadService;

@RestController
public class Vol_HabilidadController {
    private final Vol_HabilidadService vol_habilidadService;

    @Autowired
    public Vol_HabilidadController(Vol_HabilidadService vol_habilidadService) {
        this.vol_habilidadService = vol_habilidadService;
    }

    @GetMapping("/vol_habilidades")
    public List<Vol_Habilidad> getAllVolHabilidades() {
        return vol_habilidadService.getAllVolHabilidades();
    }

    @GetMapping("/vol_habilidad/{id}")
    public Vol_Habilidad getVolHabilidadById(@PathVariable Long id) {
        return vol_habilidadService.getVolHabilidadById(id);
    }

    @GetMapping("/vol_habilidades/voluntario/{id_voluntario}")
    public List<Vol_Habilidad> getAllVolHabilidadesByVoluntarioId(@PathVariable Long id_voluntario) {
        return vol_habilidadService.getAllVolHabilidadesByVoluntarioId(id_voluntario);
    }

    @GetMapping("/vol_habilidades/habilidad/{id_habilidad}")
    public List<Vol_Habilidad> getAllVolHabilidadesByHabilidadId(@PathVariable Long id_habilidad) {
        return vol_habilidadService.getAllVolHabilidadesByHabilidadId(id_habilidad);
    }

    @PostMapping("/vol_habilidad")
    public void createVolHabilidad(@RequestBody Vol_Habilidad vol_habilidad) {
        vol_habilidadService.createVolHabilidad(vol_habilidad);
    }

    @PutMapping("/vol_habilidad/{id}")
    public void updateVolHabilidad(@PathVariable Long id, @RequestBody Vol_Habilidad vol_habilidad) {
        vol_habilidadService.updateVolHabilidad(id, vol_habilidad);
    }

    @DeleteMapping("/vol_habilidad/{id}")
    public void deleteVolHabilidad(@PathVariable Long id) {
        vol_habilidadService.deleteVolHabilidad(id);
    }
}
