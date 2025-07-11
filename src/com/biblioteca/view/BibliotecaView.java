package com.biblioteca.view;

import com.biblioteca.controller.BibliotecaController;
import com.biblioteca.exception.LibroException;
import com.biblioteca.exception.PrestamoException;
import com.biblioteca.exception.UsuarioException;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    private final BibliotecaController controller;
    private final Scanner scanner = new Scanner(System.in);

    public BibliotecaView(BibliotecaController controller) {
        this.controller = controller;
    }

    public void menuPrincipal() throws UsuarioException, LibroException, PrestamoException {
        int option;
        do {
            System.out.println("===== Biblioteca Universitaria =====");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Libros");
            System.out.println("3. Gestionar Prestamos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una option: ");
            option = scanner.nextInt();

            // switch
            switch (option) {
                case 1:
                    menuUsuarios();
                    break;
                case 2:
                    menuLibros();
                    break;
                case 3:
                    menuPrestamos();
                    break;
                case 0:
                    System.out.println("saliendo..."); break;
                default:
                    System.out.println("Opción no valida...");
            }
        } while (option != 0);
    }

    public void menuUsuarios() throws UsuarioException {
        int option;
        do {
            System.out.println("===== Usuarios =====");
            System.out.println("1. registrar");
            System.out.println("2. buscar");
            System.out.println("3. eliminar");
            System.out.println("4. listar");
            System.out.println("0. Salir");
            System.out.print("Seleccione una option: ");
            option = scanner.nextInt();

            // switch
            switch (option) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    buscarUsuario();
                    break;
                case 3:
                    eliminarUsuario();
                    break;
                case 4:
                    usuariosRegistrados();
                    break;
                case 0:
                    System.out.println("saliendo..."); break;
                default:
                    System.out.println("Opción no valida...");
            }

        } while (option != 0);
    }

    public void menuLibros() throws LibroException {
        int option;
        do {
            System.out.println("===== Libros =====");
            System.out.println("1. agregar");
            System.out.println("2. buscar");
            System.out.println("3. eliminar");
            System.out.println("4. listar");
            System.out.println("0. Salir");
            System.out.print("Seleccione una option: ");
            option = scanner.nextInt();

            // switch
            switch (option) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    buscarLibro();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    listarLibros();
                    break;
                case 0:
                    System.out.println("saliendo..."); break;
                default:
                    System.out.println("Opción no valida...");
            }

        } while (option != 0);
    }

    public void menuPrestamos() throws PrestamoException {
        int option;
        do {
            System.out.println("===== Prestamos =====");
            System.out.println("1. prestar");
            System.out.println("2. buscar");
            System.out.println("3. listar");
            System.out.println("4. devolver");
            System.out.println("0. Salir");
            System.out.print("Seleccione una option: ");
            option = scanner.nextInt();

            // switch
            switch (option) {
                case 1:
                    prestar();
                    break;
                case 2:
                    buscarPrestamos();
                    break;
                case 3:
                    listarPrestamos();
                    break;
                case 4:
                    devolverLibros();
                    break;
                case 0:
                    System.out.println("saliendo..."); break;
                default:
                    System.out.println("Opción no valida...");
            }
        } while (option != 0);
    }

    // MÉTODOS DE USUARIO
    public void registrarUsuario() {
        try {
            System.out.print("nombre: ");
            String nombre = scanner.next();
            System.out.print("dni: ");
            int dni = scanner.nextInt();
            Usuario usuario = new Usuario(dni, nombre);
            controller.registrarUsuario(usuario);
            System.out.println("usuario registrado correctamente!");
        } catch (UsuarioException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarUsuario() {
        try {
            System.out.print("id del usuario: ");
            int id = scanner.nextInt();
            Usuario usuario = controller.buscarUsuario(id);
            System.out.println(usuario);
        } catch (UsuarioException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarUsuario() {
        try {
            System.out.print("id del usuario: ");
            int id = scanner.nextInt();
            controller.eliminarUsuario(id);
            System.out.println("usuario eliminado correctamente!");
        } catch (UsuarioException e) {
            System.out.println(e.getMessage());
        }
    }

    public void usuariosRegistrados() {
        try {
            Collection<Usuario> usuarios = controller.usuariosRegistrados();
            System.out.println("Usuarios registrados: ");
            usuarios.forEach(System.out::println);
        } catch (UsuarioException e) {
            System.out.println(e.getMessage());
        }
    }

    // MÉTODOS DE LIBRO
    public void agregarLibro() {
        try {
            System.out.print("id del libro: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("titulo: ");
            String titulo = scanner.nextLine();
            System.out.print("autor: ");
            String autor = scanner.next();
            System.out.print("anio: ");
            int anio = scanner.nextInt();
            scanner.nextLine();
            System.out.print("isbn: ");
            int isbn = scanner.nextInt();
            scanner.nextLine();
            controller.agregarLibro(id, titulo, autor, anio, isbn);
            System.out.println("libro agregado correctamente!");
        } catch (LibroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarLibro() {
        try {
            System.out.print("id del libro: ");
            int id = scanner.nextInt();
            Libro libro = controller.buscarLibro(id);
            System.out.println(libro);
        } catch (LibroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarLibros() {
        try {
            Collection<Libro> libros = controller.listarLibros();
            System.out.println("Libros: ");
            libros.forEach(System.out::println);
        } catch (LibroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarLibro() {
        try {
            System.out.print("id del libro: ");
            int id = scanner.nextInt();
            controller.eliminarLibro(id);
            System.out.println("libro eliminado correctamente!");
        } catch (LibroException e) {
            System.out.println(e.getMessage());
        }
    }

    // MÉTODOS DE PRESTAMOS
    public void prestar() {
        char op;
        try {
            System.out.print("id del usuario: ");
            int idUsuario = scanner.nextInt();
            Usuario usuario = controller.buscarUsuario(idUsuario);
            List<Libro> libros = new ArrayList<>();
            do {
                System.out.print("id del libro: ");
                int id = scanner.nextInt();
                try {
                    Libro libro = controller.buscarLibro(id);
                    libros.add(libro);
                } catch (LibroException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("desea agregar otro libro adicional ? s/n: ");
                op = scanner.next().charAt(0);
            } while (op == 's' || op == 'S');
            if (libros.isEmpty()) {
                System.out.println("debe haber como mínimo un libro...");
                return;
            }
            LocalDate presta = LocalDate.now();
            controller.crearPrestamo(usuario, libros, presta, null);
            System.out.println("préstamo realizado correctamente!");
        } catch (PrestamoException | UsuarioException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarPrestamos() {
        try {
            System.out.print("id del préstamo: ");
            int id = scanner.nextInt();
            Prestamo prestamo = controller.buscarPrestamo(id);
            System.out.println(prestamo);
        } catch (PrestamoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarPrestamos() {
        try {
            Collection<Prestamo> prestamos = controller.listarPrestamos();
            prestamos.forEach(System.out::println);
        } catch (PrestamoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void devolverLibros() {
        try {
            System.out.print("id del préstamo: ");
            int id = scanner.nextInt();
            controller.devolverLibro(id);
            System.out.println("se ha devuelto correctamente los libros!");
        } catch (PrestamoException e) {
            System.out.println(e.getMessage());
        }
    }
}
