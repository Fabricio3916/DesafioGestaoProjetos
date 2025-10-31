package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.config.TokenConfig;
import dev.matheuslf.desafio.inscritos.controller.request.UserRequest;
import dev.matheuslf.desafio.inscritos.controller.response.LoginResponse;
import dev.matheuslf.desafio.inscritos.controller.response.UserResponse;
import dev.matheuslf.desafio.inscritos.entity.User;
import dev.matheuslf.desafio.inscritos.mapper.UserMapper;
import dev.matheuslf.desafio.inscritos.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;
    private final AuthenticationManager authManager;
    private final TokenConfig tokenConfig;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest request) {
        User newUser = service.register(UserMapper.toUser(request));
        return ResponseEntity.ok(UserMapper.toResponse(newUser));
    }

    @PostMapping("/login")

    public ResponseEntity<LoginResponse> login(@Valid @RequestBody UserRequest request) {
        var authToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication auth = authManager.authenticate(authToken);
        User user = (User) auth.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
