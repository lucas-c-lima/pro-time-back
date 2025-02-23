package com.proj.protime.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.proj.protime.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secretKey;

    public String generateToken(Users user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey); //Gerar hash com secretKey para o token

            String token = JWT.create()
                    .withIssuer("Protime-API")
                    .withSubject(user.getUsername()) // para quem é o token
                    .withExpiresAt(genExpirationDate()) // token expira em 2 horas
                    .sign(algorithm);
            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey); //Gerar hash com secretKey para o token

            //Verifica se o token é válido
            return JWT.require(algorithm)
                    .withIssuer("Protime-API")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e) {
            throw new RuntimeException("Invalid token", e);
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
