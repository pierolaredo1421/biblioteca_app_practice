package com.biblioteca.model;

public class Usuario {
    private final int dni;
    private String nombre;

    public Usuario(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append("DNI: ").append(dni).append("\n")
                .append("Nombre: ").append(nombre).append("\n")
                .append("======================");
        return sb.toString();
    }
}
