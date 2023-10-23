package cl.tbd.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegistrationCoordinador {
    @JsonProperty("correo")
    private String email;
    private String nombre;
    private String apellido;
    @JsonProperty("contrasenia")
    private String password;
    @JsonProperty("institucion")
    private Long idInstitucion;
}
