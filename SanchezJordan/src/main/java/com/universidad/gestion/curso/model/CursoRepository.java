package com.universidad.gestion.curso.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoRepository {
    private final List<Curso> cursos = new ArrayList<>();
    private int currentId = 1;

    public Curso guardar(Curso curso) {
        if (curso.getId() == null || curso.getId().trim().isEmpty()) {
            curso.setId(String.valueOf(currentId++));
            cursos.add(curso);
        } else {

            for (int i = 0; i < cursos.size(); i++) {
                if (cursos.get(i).getId().equals(curso.getId())) {
                    cursos.set(i, curso);
                    break;
                }
            }
        }
        return curso;
    }

    public List<Curso> buscarTodos() {
        return new ArrayList<>(cursos);
    }

    public Optional<Curso> buscarPorId(String id) {
        return cursos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public boolean eliminarPorId(String id) {
        return cursos.removeIf(c -> c.getId().equals(id));
    }
}
