package com.biblioteca.factory;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PrestamoFactory {
    private static final AtomicInteger idPrestamo = new AtomicInteger(1);

    public static Prestamo Prestar(Usuario usuario, List<Libro> libros, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        int nuevoId = idPrestamo.getAndIncrement();
        return new Prestamo(nuevoId, usuario, libros, fechaPrestamo, fechaDevolucion);
    }
}
