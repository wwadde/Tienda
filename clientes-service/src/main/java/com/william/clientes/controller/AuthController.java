package com.william.clientes.controller;

import com.william.clientes.domain.AuthResponse;
import com.william.clientes.domain.DatosRegistro;
import com.william.clientes.domain.UsuarioDto;
import com.william.clientes.domain.UsuarioEntity;
import com.william.clientes.infra.errores.ClienteException;
import com.william.clientes.infra.security.JwtService;
import com.william.clientes.infra.errores.ClienteNoEncontradoException;
import com.william.clientes.service.ClienteService;
import com.william.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ClienteService clienteService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UsuarioDto usuarioDto) throws ClienteNoEncontradoException {

        usuarioService.validarLogin(usuarioDto);

        Authentication authentication = new UsernamePasswordAuthenticationToken(usuarioDto.getUsername(), usuarioDto.getPassword());
        log.info(authentication.toString());
        try {

            var usuarioAutenticado = authenticationManager.authenticate(authentication);
            log.info(usuarioAutenticado.toString());

            var jwtoken = jwtService.generarToken((UsuarioEntity) usuarioAutenticado.getPrincipal());

            return ResponseEntity.ok(new AuthResponse(jwtoken));
        } catch (Exception e) {
            throw new ClienteNoEncontradoException("Usuario o contraseña incorrectos");
        }


    }

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registro(@RequestBody DatosRegistro datosRegistro) throws ClienteException {

        AuthResponse auth = usuarioService.registrarUsuarioEmpleado(datosRegistro);
        return ResponseEntity.ok(auth);
    }
}
