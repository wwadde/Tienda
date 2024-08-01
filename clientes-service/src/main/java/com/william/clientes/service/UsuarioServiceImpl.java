package com.william.clientes.service;


import com.william.clientes.domain.*;
import com.william.clientes.infra.errores.ClienteException;
import com.william.clientes.infra.security.JwtService;
import com.william.clientes.infra.errores.ClienteNoEncontradoException;
import com.william.clientes.repository.ClienteRepository;
import com.william.clientes.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final Function<DatosRegistro, UsuarioEntity> dtoToUsuarioEntity;
    private final Function<DatosRegistro, ClienteEntity> dtoToEmpleadoEntity;



    @Transactional
    public AuthResponse registrarUsuarioEmpleado(DatosRegistro datos) throws ClienteException {

        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findByUsername(datos.getUsername());
        if (usuarioEntity.isPresent()){
            throw new ClienteException("Usuario ya existe");
        }

        UsuarioEntity usuario = dtoToUsuarioEntity.apply(datos);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        // Rol por defecto
        usuario.setRol(Rol.DEFAULT);
        usuarioRepository.save(usuario);

        ClienteEntity empleado = dtoToEmpleadoEntity.apply(datos);
        empleado.setUsuario(usuario);
        clienteRepository.save(empleado);

        return AuthResponse.builder()
                .token("Usuario registrado")
                .build();


    }

    public AuthResponse login(UsuarioDto usuarioDto) {
        return null;
    }


    @Override
    public Long validarLogin(UsuarioDto dto) throws ClienteNoEncontradoException {

        UsuarioEntity usuario = usuarioRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new ClienteNoEncontradoException("Usuario no encontrado"));

        return usuario.getId();


    }


}
