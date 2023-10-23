package cl.tbd.backend.models;

import lombok.Data;

@Data
public class VoluntarioLoginResponse {
    private boolean error;
    private String message;
    private String token; // Token JWT generado para el usuario
    private Voluntario usuario;
}
