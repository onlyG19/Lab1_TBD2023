package cl.tbd.backend.security;

import lombok.Data;

@Data
public class AuthCredentials {
    public String email;
    public String password;
}
