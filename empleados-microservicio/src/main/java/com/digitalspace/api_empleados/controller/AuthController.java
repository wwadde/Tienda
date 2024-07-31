package com.digitalspace.api_empleados.controller;

import com.digitalspace.api_empleados.domain.AuthResponse;
import com.digitalspace.api_empleados.domain.DatosRegistro;
import com.digitalspace.api_empleados.domain.UsuarioDto;
import com.digitalspace.api_empleados.domain.UsuarioEntity;
import com.digitalspace.api_empleados.infra.config.security.JwtService;
import com.digitalspace.api_empleados.infra.errores.EmpleadoException;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;
import com.digitalspace.api_empleados.service.EmpleadoService;
import com.digitalspace.api_empleados.service.UsuarioService;
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
    private final EmpleadoService empleadoService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UsuarioDto usuarioDto) throws EmpleadoNoEncontradoException {

        usuarioService.validarLogin(usuarioDto);

        Authentication authentication = new UsernamePasswordAuthenticationToken(usuarioDto.getUsername(), usuarioDto.getPassword());
        log.info(authentication.toString());
        try {

            var usuarioAutenticado = authenticationManager.authenticate(authentication);
            log.info(usuarioAutenticado.toString());

            var jwtoken = jwtService.generarToken((UsuarioEntity) usuarioAutenticado.getPrincipal());

            return ResponseEntity.ok(new AuthResponse(jwtoken));
        } catch (Exception e) {
            throw new EmpleadoNoEncontradoException("Usuario o contraseña incorrectos");
        }


    }

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registro(@RequestBody DatosRegistro datosRegistro) throws EmpleadoException {

        AuthResponse auth = usuarioService.registrarUsuarioEmpleado(datosRegistro);
        return ResponseEntity.ok(auth);
    }
}
