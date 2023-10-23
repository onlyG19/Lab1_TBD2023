package cl.tbd.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class Registration {
    private String nombre;
    private String apellido;
    @JsonProperty("correo")
    private String email;
    @JsonProperty("contrasenia")
    private String password;
    private String direccion;
    private String telefono;
    @JsonProperty("nacimiento")
    private Date fecha_nacimiento;
    private Date disponibilidad;
}
