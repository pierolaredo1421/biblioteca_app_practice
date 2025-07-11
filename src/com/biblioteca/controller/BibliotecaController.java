package com.biblioteca.controller;

import com.biblioteca.exception.LibroException;
import com.biblioteca.exception.PrestamoException;
import com.biblioteca.exception.UsuarioException;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.LibroService;
import com.biblioteca.service.PrestamoService;
import com.biblioteca.service.UsuarioService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class BibliotecaController {
    private final LibroService libroService;
    private final UsuarioService usuarioService;
    private final PrestamoService prestamoService;

    public BibliotecaController(LibroService libroService, UsuarioService usuarioService, PrestamoService prestamoService) {
        this.libroService = libroService;
        this.usuarioService = usuarioService;
        this.prestamoService = prestamoService;
    }

    // USUARIOS
    public void registrarUsuario(Usuario usuario) throws UsuarioException {
        usuarioService.registrarUsuario(usuario);
    }

    public Usuario buscarUsuario(int dni) throws UsuarioException {
        return usuarioService.buscarUsuario(dni);
    }

    public Collection<Usuario> usuariosRegistrados() throws UsuarioException {
        return usuarioService.listarUsuarios();
    }

    public void eliminarUsuario(int dni) throws UsuarioException {
        usuarioService.eliminarUsuario(dni);
    }

    // LIBROS
    public void agregarLibro(int id, String titulo, String autor, int anio, int isbn) throws LibroException {
        libroService.agregarLibro(id, titulo, autor, anio, isbn);
    }

    public Libro buscarLibro(int id) throws LibroException {
        return libroService.buscarLibro(id);
    }

    public Collection<Libro> listarLibros() throws LibroException {
        return libroService.listarLibros();
    }

    public void eliminarLibro(int id) throws LibroException {
        libroService.eliminarLibro(id);
    }

    // PRESTAMOS
    public void crearPrestamo(Usuario usuario, List<Libro> libros, LocalDate fechaPrestamo, LocalDate fechaDevolucion) throws PrestamoException {
        prestamoService.crearPrestamo(usuario, libros, fechaPrestamo, fechaDevolucion);
    }

    public Prestamo buscarPrestamo(int id) throws PrestamoException {
        return prestamoService.buscarPrestamo(id);
    }

    public Collection<Prestamo> listarPrestamos() throws PrestamoException {
        return prestamoService.listarPrestamos();
    }

    public void devolverLibro(int id) throws PrestamoException {
        prestamoService.devolverPrestamo(id);
    }
}
