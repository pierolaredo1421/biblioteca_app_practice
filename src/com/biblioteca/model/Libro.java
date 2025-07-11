package com.biblioteca.model;

import java.util.Objects;

public class Libro {
    private final int id;
    private String titulo;
    private String autor;
    private int anio;
    private int isbn;
    private boolean prestado;

    public Libro(int id, String titulo, String autor, int anio, int isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
        this.prestado = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id == libro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public int getIsbn() {
        return isbn;
    }

    public void prestar() {
        if (prestado) throw new IllegalStateException("El libro ya está prestado");
        prestado = true;
    }

    // si prestado es false retorna false, porque el libro no estaba prestado,
    // pero si prestado es true, lo pone false haciendo que se ponga disponible y
    // el método retorna true diciendo que true porque se devolvió con exito
    public boolean devolver() {
        if (!prestado) return false;
        prestado = false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append("Id: "). append(id).append('\n')
                .append("Titulo: "). append(titulo).append('\n')
                .append("Autor: "). append(autor).append('\n')
                .append("Anio: "). append(anio).append('\n')
                .append("ISBN: "). append(isbn).append('\n');
        return sb.toString();
    }
}
