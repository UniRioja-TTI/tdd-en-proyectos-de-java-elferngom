package com.tt1.test;

public class Repositorio {
    private DBStub db = new DBStub();
    public ToDo buscarPorNombre(String nombre) {
        return db.leer(nombre);
    }
    public void marcarCompletada(String nombre) {
        ToDo tarea = db.leer(nombre);
        if (tarea != null) {
            tarea.setCompletado(true);
            db.actualizar(tarea);
        }
    }
    public void guardarNuevaTarea(ToDo tarea) {
        db.crear(tarea);
    }
    public void guardarEmail(String email) {
        db.guardarEmail(email);
    }
}
