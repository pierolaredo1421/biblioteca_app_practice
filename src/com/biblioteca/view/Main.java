package com.biblioteca.view;

import com.biblioteca.controller.BibliotecaController;
import com.biblioteca.exception.LibroException;
import com.biblioteca.exception.PrestamoException;
import com.biblioteca.exception.UsuarioException;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.repository.PrestamoRepository;
import com.biblioteca.repository.UsuarioRepository;
import com.biblioteca.service.LibroService;
import com.biblioteca.service.PrestamoService;
import com.biblioteca.service.UsuarioService;
import jdk.jshell.spi.ExecutionControl;

public class Main {
    public static void main(String[] args) throws PrestamoException, LibroException, UsuarioException {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        LibroRepository libroRepository = new LibroRepository();
        PrestamoRepository prestamoRepository = new PrestamoRepository();

        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        LibroService libroService = new LibroService(libroRepository);
        PrestamoService prestamoService = new PrestamoService(prestamoRepository, libroRepository);

        BibliotecaController bibliotecaController = new BibliotecaController(libroService, usuarioService, prestamoService);

        BibliotecaView bibliotecaView = new BibliotecaView(bibliotecaController);

        bibliotecaView.menuPrincipal();
    }
}
