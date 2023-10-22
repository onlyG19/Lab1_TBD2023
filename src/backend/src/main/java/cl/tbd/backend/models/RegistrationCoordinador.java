package cl.tbd.backend.models;

import lombok.Data;

@Data
public class RegistrationCoordinador {
    private String email;
    private String nombre;
    private String apellido;
    private String password;
}
