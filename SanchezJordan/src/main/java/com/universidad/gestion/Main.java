package com.universidad.gestion;

import com.universidad.gestion.curso.controller.CursoController;
import com.universidad.gestion.curso.model.CursoRepository;
import com.universidad.gestion.curso.view.CursoView;

public class Main {
    public static void main(String[] args) {
        CursoRepository repository = new CursoRepository();
        CursoView view = new CursoView();
        CursoController controller = new CursoController(repository, view);

        controller.iniciar();
    }
}
