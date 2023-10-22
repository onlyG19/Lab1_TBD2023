package cl.tbd.backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    private final static long ACCESS_TOKEN_VALIDITY_SECONDS = 2592000L; //30 DIAS


    public static String createToken(String nombre) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);
        return Jwts.builder()
                .setSubject(nombre) //
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }


    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String nombre = claims.getSubject(); // Obtén el nombre desde las reclamaciones
            return new UsernamePasswordAuthenticationToken(nombre, null, List.of());
        } catch (JwtException e) {
            return null;
        }
    }

}
