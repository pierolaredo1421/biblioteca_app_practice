package com.biblioteca.service;

import com.biblioteca.exception.UsuarioException;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioRepository;

import java.util.Collection;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(Usuario usuario) throws UsuarioException {
        if (usuarioRepository.obtenerUsuarioPorDni(usuario.getDni()).isPresent()) {
            throw new UsuarioException("El usuario ya existe");
        }
        usuarioRepository.registrarUsuario(usuario);
    }

    public Usuario buscarUsuario(int dni) throws UsuarioException {
        return usuarioRepository.obtenerUsuarioPorDni(dni).orElseThrow(() -> new UsuarioException("No hay usuario con el dni " + dni));
    }

    public Collection<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    public void eliminarUsuario(int dni) throws UsuarioException {
        if (!usuarioRepository.eliminarUsuario(dni)) {
            throw new UsuarioException("No hay usuario con el dni " + dni);
        }
    }
}
