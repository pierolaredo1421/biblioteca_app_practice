package com.biblioteca.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Prestamo {
    private final int idPrestamo;
    private final Usuario usuario;
    private final List<Libro> libros;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(int idPrestamo, Usuario usuario, List<Libro> libros, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.usuario = usuario;
        this.libros = libros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return idPrestamo == prestamo.idPrestamo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPrestamo);
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getFechaPrestamoFormateada() {
        return fechaPrestamo != null ? fechaPrestamo.toString() : "";
    }

    public String getFechaDevolucionFormateada() {
        return fechaDevolucion != null ? fechaDevolucion.toString() : "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRÉSTAMO: ").append("\n")
                .append("Id: ").append(idPrestamo).append("\n")
                .append("Usuario: ").append(usuario).append("\n")
                .append("Libros: ").append(libros).append("\n")
                .append("Fecha de préstamo: ").append(getFechaPrestamoFormateada()).append("\n")
                .append("Fecha de devolución: ").append(getFechaDevolucion()).append("\n")
                .append("======================");
        return sb.toString();
    }
}
