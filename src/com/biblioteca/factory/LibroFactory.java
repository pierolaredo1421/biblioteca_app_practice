package com.biblioteca.factory;

import com.biblioteca.model.Libro;

public class LibroFactory {
    public static Libro crearLibro(int id, String titulo, String autor, int anio, int isbn){
        return new Libro(id, titulo, autor, anio, isbn);
    }
}
