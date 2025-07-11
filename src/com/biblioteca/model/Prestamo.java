package com.biblioteca.model;

import java.time.LocalDate;
import java.util.List;

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

    public String getFechaPrestamoFormateada (){
        return fechaPrestamo != null ? fechaPrestamo.toString() : "";
    }

    public String getFechaDevolucionFormateada (){
        return fechaDevolucion != null ? fechaDevolucion.toString() : "";
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", usuario=" + usuario +
                ", libros=" + libros +
                ", fechaPrestamo=" + getFechaPrestamoFormateada() +
                ", fechaDevolucion=" + getFechaDevolucionFormateada() +
                '}';
    }
}
