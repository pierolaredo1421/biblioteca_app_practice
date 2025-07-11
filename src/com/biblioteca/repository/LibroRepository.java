package com.biblioteca.repository;

import com.biblioteca.model.Libro;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibroRepository {
    private final Map<Integer, Libro> libros = new HashMap<Integer, Libro>();

    public void registrarLibro(Libro libro) {
        libros.put(libro.getId(), libro);
    }

    public Optional<Libro> obtenerLibro(int id) {
        return Optional.ofNullable(libros.get(id));
    }

    public Collection<Libro> listarLibros() {
        return libros.values();
    }

    public boolean eliminarLibro(int id) {
        return libros.remove(id) != null;
    }
}
