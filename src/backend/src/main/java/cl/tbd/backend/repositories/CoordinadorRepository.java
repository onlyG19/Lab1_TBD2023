package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Coordinador;

import java.util.List;


public interface CoordinadorRepository {
    void createCoordinador(Coordinador coordinador); //Create
    List<Coordinador> getAllCoordinador(); //Read
    Coordinador getCoordinadorById(Long id);
    Coordinador getCoordinadorByEmail(String email);
    String updateCoordinador(Long id, Coordinador coordinador); //Update
    String deleteCoordinador(Long id);
}
