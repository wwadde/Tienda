package com.digitalspace.api_empleados.service;


import com.digitalspace.api_empleados.domain.*;
import com.digitalspace.api_empleados.infra.config.security.JwtService;
import com.digitalspace.api_empleados.infra.errores.EmpleadoException;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;
import com.digitalspace.api_empleados.repository.EmpleadoRepository;
import com.digitalspace.api_empleados.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Function;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final Function<DatosRegistro, UsuarioEntity> dtoToUsuarioEntity;
    private final Function<DatosRegistro, EmpleadoEntity> dtoToEmpleadoEntity;



    @Transactional
    public AuthResponse registrarUsuarioEmpleado(DatosRegistro datos) throws EmpleadoException {

        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findByUsername(datos.getUsername());
        if (usuarioEntity.isPresent()){
            throw new EmpleadoException("Usuario ya existe");
        }

        UsuarioEntity usuario = dtoToUsuarioEntity.apply(datos);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        // Cargo por defecto
        usuario.setCargo(Cargo.EMPLEADO);
        usuarioRepository.save(usuario);

        EmpleadoEntity empleado = dtoToEmpleadoEntity.apply(datos);
        empleado.setUsuario(usuario);
        empleadoRepository.save(empleado);

        return AuthResponse.builder()
                .token("Usuario registrado")
                .build();


    }

    public AuthResponse login(UsuarioDto usuarioDto) {
        return null;
    }


    @Override
    public Long validarLogin(UsuarioDto dto) throws EmpleadoNoEncontradoException {

        UsuarioEntity usuario = usuarioRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Usuario no encontrado"));

        return usuario.getId();


    }


}
