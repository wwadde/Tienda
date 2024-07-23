package com.digitalspace.api_empleados.service;


import com.digitalspace.api_empleados.domain.UsuarioDto;
import com.digitalspace.api_empleados.domain.UsuarioEntity;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;
import com.digitalspace.api_empleados.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Long validarUsuario(UsuarioDto dto) throws EmpleadoNoEncontradoException {

        UsuarioEntity usuario = usuarioRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Usuario no encontrado"));

        if (!(dto.getPassword().equals(usuario.getPassword()))) {
            throw new EmpleadoNoEncontradoException("Contraseña incorrecta");
        }

        return usuario.getId();


    }
}
