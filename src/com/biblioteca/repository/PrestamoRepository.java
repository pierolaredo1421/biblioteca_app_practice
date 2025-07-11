package com.biblioteca.repository;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PrestamoRepository {
    private final Map<Integer, Prestamo> prestamos = new HashMap<Integer, Prestamo>();

    public void crearPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getIdPrestamo(), prestamo);
    }

    public Optional<Prestamo> buscarPrestamo(int idPrestamo) {
        return Optional.ofNullable(prestamos.get(idPrestamo));
    }

    public Collection<Prestamo> listarPrestamos() {
        return prestamos.values();
    }
}
