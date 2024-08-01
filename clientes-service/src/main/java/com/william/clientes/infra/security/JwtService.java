package com.william.clientes.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.william.clientes.domain.UsuarioEntity;
import com.william.clientes.infra.errores.TokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class JwtService {

    private final String apiSecret = "123456";

    public String generarToken(UsuarioEntity usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("WILLIAM WADDE")
                    .withSubject(usuario.getUsername())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);

        } catch (JWTCreationException exception){
            throw new TokenException("No se pudo generar el Token");
        }
    }

    public String verificarToken(String token) {
        if (token == null){
            throw new TokenException("No se ha recibido el token");
        }
        DecodedJWT verifier;
        try {

            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("WILLIAM WADDE")
                    .build()
                    .verify(token);
            return verifier.getSubject();

        } catch (JWTVerificationException exception) {
            throw new TokenException("Token inválido");
        }
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
