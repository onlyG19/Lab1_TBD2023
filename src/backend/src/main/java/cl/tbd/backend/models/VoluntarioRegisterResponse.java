package cl.tbd.backend.models;

import lombok.Data;

@Data
public class VoluntarioRegisterResponse {
    private Boolean error;
    private String message;
    private Voluntario usuario;
}