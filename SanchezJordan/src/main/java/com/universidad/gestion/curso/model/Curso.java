package com.universidad.gestion.curso.model;

public class Curso {
    private String id;
    private String nombre;
    private String profesor;
    private int creditos;

    public Curso(String id, String nombre, String profesor, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
        this.creditos = creditos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Profesor='" + profesor + '\'' +
                ", Creditos=" + creditos +
                '}';
    }
}
