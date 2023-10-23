package cl.tbd.backend.security;

import cl.tbd.backend.models.Coordinador;
import cl.tbd.backend.repositories.CoordinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Coordinador coordinador = coordinadorRepository.getCoordinadorByEmail(email);
        if(coordinador == null){
            throw new UsernameNotFoundException("el usuario con email " + email + "no existe" );
        }
        return new UserDetailsImpl(coordinador);
    }
}
