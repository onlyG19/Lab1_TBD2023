package cl.tbd.backend.models;

import lombok.Data;

@Data
public class CoordinadorRegisterResponse {
    private Boolean error;
    private String message;
    private Coordinador usuario;
}
