package com.digitalspace.api_empleados.controller;

import com.digitalspace.api_empleados.domain.DatosEmpleadoFront;
import com.digitalspace.api_empleados.domain.DatosRegistro;
import com.digitalspace.api_empleados.domain.UsuarioDto;
import com.digitalspace.api_empleados.domain.UsuarioEntity;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;
import com.digitalspace.api_empleados.repository.UsuarioRepository;
import com.digitalspace.api_empleados.service.EmpleadoService;
import com.digitalspace.api_empleados.service.RegistroService;
import com.digitalspace.api_empleados.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    private final RegistroService registroService;

    private final EmpleadoService empleadoService;

    public AuthController(UsuarioService usuarioRepository, RegistroService usuarioService, EmpleadoService empleadoService) {
        this.usuarioService = usuarioRepository;
        this.registroService = usuarioService;
        this.empleadoService = empleadoService;
    }

    @PostMapping("/login")
    public ResponseEntity<DatosEmpleadoFront> login(@RequestBody UsuarioDto usuarioDto) throws EmpleadoNoEncontradoException {

        Long UsuarioId = usuarioService.validarUsuario(usuarioDto);
        DatosEmpleadoFront datosEmpleadoFront = empleadoService.poblacionDatosEmpleadoFront(UsuarioId);
        return ResponseEntity.ok(datosEmpleadoFront);
    }


    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestBody DatosRegistro datosRegistro){
        registroService.registrarUsuarioEmpleado(datosRegistro);
        return ResponseEntity.ok("Usuario registrado");

    }

}
