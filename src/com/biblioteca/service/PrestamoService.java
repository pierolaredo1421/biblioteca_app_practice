package com.biblioteca.service;

import com.biblioteca.exception.PrestamoException;
import com.biblioteca.factory.PrestamoFactory;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.repository.PrestamoRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;

    public PrestamoService(PrestamoRepository prestamoRepository, LibroRepository libroRepository) {
        this.prestamoRepository = prestamoRepository;
        this.libroRepository = libroRepository;
    }

    public void crearPrestamo(Usuario usuario, List<Libro> libros, LocalDate fechaPrestamo, LocalDate fechaDevolucion) throws PrestamoException {
        if (usuario == null) {
            throw new PrestamoException("Usuario no puede ser nulo");
        }
        if (libros.isEmpty() || libros == null) {
            throw new PrestamoException("Tiene que haber como minimo un libro");
        }
        Prestamo prestamo = PrestamoFactory.prestar(usuario, libros, fechaPrestamo, fechaDevolucion);
        prestamoRepository.crearPrestamo(prestamo);
    }

    public Prestamo buscarPrestamo(int id) throws PrestamoException {
        return prestamoRepository.buscarPrestamo(id).orElseThrow(() -> new PrestamoException("ID incorrecto, prestamo no encontrado"));
    }

    public Collection<Prestamo> listarPrestamos() {
        return prestamoRepository.listarPrestamos();
    }

    public void devolverPrestamo(int idPrestamo) throws PrestamoException {
        Prestamo prestamo = prestamoRepository.buscarPrestamo(idPrestamo)
                .orElseThrow(() -> new PrestamoException("Préstamo no encontrado"));

        if (prestamo.getFechaDevolucion() != null) {
            throw new PrestamoException("El préstamo ya fue devuelto.");
        }

        for (Libro libro : prestamo.getLibros()) {
            if (!libro.devolver()) {
                throw new PrestamoException("El libro con ID " + libro.getId() + " ya estaba disponible.");
            }
            libroRepository.registrarLibro(libro);
        }

        prestamo.setFechaDevolucion(LocalDate.now().plusDays(7));
        // remplaza el préstamo con el ID asignando en el list de préstamos,
        // como sobrescribe el antiguo con el nuevo si el ID es el mismo, si es otro ID lo crea
        prestamoRepository.crearPrestamo(prestamo);
    }
}
