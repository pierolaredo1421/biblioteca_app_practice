package com.biblioteca.model;

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
        this.prestado = true;
    }

    public boolean devolver(){
        this.prestado = false;
        return false;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                ", isbn=" + isbn +
                '}';
    }
}
