package com.universidad.gestion.curso.view;

import com.universidad.gestion.curso.model.Curso;

import java.util.List;
import java.util.Scanner;

public class CursoView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- Gestión de Cursos ---");
        System.out.println("1. Agregar Curso");
        System.out.println("2. Ver todos los Cursos");
        System.out.println("3. Actualizar Curso");
        System.out.println("4. Eliminar Curso");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Curso obtenerDatosCurso() {
        System.out.print("Ingrese nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese nombre del profesor: ");
        String profesor = scanner.nextLine();
        System.out.print("Ingrese número de créditos: ");
        int creditos = Integer.parseInt(scanner.nextLine());
        return new Curso(null, nombre, profesor, creditos);
    }

    public String obtenerIdCurso() {
        System.out.print("Ingrese el ID del curso: ");
        return scanner.nextLine();
    }

    public void mostrarCursos(List<Curso> cursos) {
        if (cursos.isEmpty()) {
            System.out.println("No existen cursos registrados");
        } else {
            System.out.println("\n---Lista de Cursos---");
            cursos.forEach(System.out::println);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
