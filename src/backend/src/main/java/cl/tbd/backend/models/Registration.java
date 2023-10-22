package cl.tbd.backend.models;

import lombok.Data;

@Data
public class Registration {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
}
