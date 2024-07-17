//package com.digitalspace.api_empleados.service;
//
//import com.digitalspace.api_empleados.domain.UsuarioEntity;
//import com.digitalspace.api_empleados.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//public class UsuarioService implements UserDetailsService {
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UsuarioEntity> usuarioEncontrado = usuarioRepository.findByUsername(username);
//        if (usuarioEncontrado.isEmpty()) {
//            throw new UsernameNotFoundException("Usuario no encontrado");
//        }
//        return usuarioEncontrado.get();
//
//
//    }
//}
