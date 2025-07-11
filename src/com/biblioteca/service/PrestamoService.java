package com.biblioteca.service;

import com.biblioteca.exception.PrestamoException;
import com.biblioteca.factory.PrestamoFactory;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.PrestamoRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class PrestamoService {
    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public void crearPrestamo(Usuario usuario, List<Libro> libros, LocalDate fechaPrestamo, LocalDate fechaDevolucion) throws PrestamoException {
        if (usuario == null) {
            throw new PrestamoException("Usuario no puede ser nulo");
        }
        if (libros.isEmpty() || libros == null) {
            throw new PrestamoException("Tiene que haber como minimo un libro");
        }
        Prestamo prestamo = PrestamoFactory.Prestar(usuario, libros, fechaPrestamo, fechaDevolucion);
        prestamoRepository.crearPrestamo(prestamo);
    }

    public Prestamo buscarPrestamo(int id) throws PrestamoException {
        return prestamoRepository.buscarPrestamo(id).orElseThrow(() -> new PrestamoException("ID incorrecto, prestamo no encontrado"));
    }

    public Collection<Prestamo> listarPrestamos() {
        return prestamoRepository.listarPrestamos();
    }
}
