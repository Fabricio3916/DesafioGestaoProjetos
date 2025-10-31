package dev.matheuslf.desafio.inscritos.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.matheuslf.desafio.inscritos.entity.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    @Value("${app.secret.key}")
    private String key;

    public String generateToken(User user) {

        Algorithm algorithm = Algorithm.HMAC256(key);

        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("userId", user.getId())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("Sistema Gestão de Projetos")
                .sign(algorithm);

    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);

            return Optional.of(JWTUserData.builder()
                    .id(jwt.getClaim("userID").asLong())
                    .username(jwt.getSubject())
                    .build());
        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }

    }

}
