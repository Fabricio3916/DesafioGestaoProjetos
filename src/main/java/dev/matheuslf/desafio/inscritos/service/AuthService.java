package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Usuário ou senha inválida"));
    }
}
