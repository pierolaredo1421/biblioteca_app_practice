package com.biblioteca.repository;

import com.biblioteca.model.Usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UsuarioRepository {
    private final Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getDni(), usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorDni(int dni) {
        return Optional.ofNullable(usuarios.get(dni));
    }

    public Collection<Usuario> listarUsuarios() {
        return usuarios.values();
    }

    public boolean eliminarUsuario(int dni) {
        return usuarios.remove(dni) != null;
    }
}
