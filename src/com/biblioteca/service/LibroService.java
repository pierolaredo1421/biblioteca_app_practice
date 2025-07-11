package com.biblioteca.service;

import com.biblioteca.exception.LibroException;
import com.biblioteca.factory.LibroFactory;
import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;

import java.util.Collection;

public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void agregarLibro (int id, String titulo, String autor, int anio, int isbn) throws LibroException {
        if (libroRepository.obtenerLibro(id).isPresent()) {
            throw new LibroException("El libro ya esta registrado");
        }
        Libro libro = LibroFactory.crearLibro(id, titulo, autor, anio, isbn);
        libroRepository.registrarLibro(libro);
    }

    public Libro buscarLibro(int id) throws LibroException {
        return libroRepository.obtenerLibro(id).orElseThrow(() -> new LibroException("No se encontro el libro con el id: " + id));
    }

    public Collection<Libro> listarLibros() {
        return libroRepository.listarLibros();
    }

    public void eliminarLibro(int id) throws LibroException {
        if (!libroRepository.eliminarLibro(id)) {
            throw new LibroException("No se encontro el libro con el id: " + id);
        }
    }
}
