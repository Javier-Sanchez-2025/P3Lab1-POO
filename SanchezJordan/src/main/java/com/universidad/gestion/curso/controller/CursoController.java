package com.universidad.gestion.curso.controller;

import com.universidad.gestion.curso.excepciones.GestionCursosException;
import com.universidad.gestion.curso.excepciones.ValidacionCursoException;
import com.universidad.gestion.curso.model.Curso;
import com.universidad.gestion.curso.model.CursoRepository;
import com.universidad.gestion.curso.view.CursoView;

import java.util.Optional;

public class CursoController {
    private final CursoRepository cursoRepository;
    private final CursoView cursoView;

    public CursoController(CursoRepository cursoRepository, CursoView cursoView) {
        this.cursoRepository = cursoRepository;
        this.cursoView = cursoView;
    }

    public void iniciar() {
        while (true) {
            int opcion = cursoView.mostrarMenu();
            try {
                switch (opcion) {
                    case 1 -> agregarCurso();
                    case 2 -> verCursos();
                    case 3 -> actualizarCurso();
                    case 4 -> eliminarCurso();
                    case 5 -> {
                        cursoView.mostrarMensaje("Saliendo del sistema...");
                        return;
                    }
                    default -> cursoView.mostrarMensaje("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                cursoView.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    private void validarCurso(Curso curso) throws ValidacionCursoException {
        if (curso.getNombre() == null || curso.getNombre().trim().isEmpty()) {
            throw new ValidacionCursoException("El nombre del curso no puede estar vacío.");
        }
        if (curso.getCreditos() <= 0) {
            throw new ValidacionCursoException("Los créditos deben ser un número positivo.");
        }
    }

    private void agregarCurso() throws ValidacionCursoException {
        Curso curso = cursoView.obtenerDatosCurso();
        validarCurso(curso);
        cursoRepository.guardar(curso);
        cursoView.mostrarMensaje("Curso agregado exitosamente con ID: " + curso.getId());
    }

    private void verCursos() {
        cursoView.mostrarCursos(cursoRepository.buscarTodos());
    }

    private void actualizarCurso() throws GestionCursosException, ValidacionCursoException {
        String id = cursoView.obtenerIdCurso();
        Optional<Curso> cursoExistente = cursoRepository.buscarPorId(id);
        if (cursoExistente.isEmpty()) {
            throw new GestionCursosException("No se encontró un curso con el ID: " + id);
        }

        cursoView.mostrarMensaje("Ingrese los nuevos datos del curso (deje en blanco para no cambiar):");
        Curso datosNuevos = cursoView.obtenerDatosCurso();

        Curso cursoParaActualizar = cursoExistente.get();
        if (!datosNuevos.getNombre().isEmpty()) {
            cursoParaActualizar.setNombre(datosNuevos.getNombre());
        }
        if (!datosNuevos.getProfesor().isEmpty()) {
            cursoParaActualizar.setProfesor(datosNuevos.getProfesor());
        }
        if (datosNuevos.getCreditos() > 0) {
            cursoParaActualizar.setCreditos(datosNuevos.getCreditos());
        }

        validarCurso(cursoParaActualizar);
        cursoRepository.guardar(cursoParaActualizar);
        cursoView.mostrarMensaje("Curso actualizado correctamente.");
    }

    private void eliminarCurso() throws GestionCursosException {
        String id = cursoView.obtenerIdCurso();
        if (!cursoRepository.eliminarPorId(id)) {
            throw new GestionCursosException("No se pudo eliminar. No se encontró curso con ID: " + id);
        }
        cursoView.mostrarMensaje("Curso eliminado exitosamente.");
    }
}

