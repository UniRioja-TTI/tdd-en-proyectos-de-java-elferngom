package com.tt1.test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private Set<String> emails = new HashSet<>();
    public void crear(ToDo tarea) {
        tareas.add(tarea);
    }
    public ToDo leer(String nombre) {
        return tareas.stream()
            .filter(t -> t.getNombre().equals(nombre))
            .findFirst()
            .orElse(null);
    }
    public void actualizar(ToDo tarea) {
        ToDo vieja = leer(tarea.getNombre());
        if (vieja != null) {
            tareas.remove(vieja);
            tareas.add(tarea);
        }
    }

    public void borrar(String nombre) {
        tareas.removeIf(t -> t.getNombre().equals(nombre));
    }

    public Set<String> obtenerEmails() {
        return emails;
    }
    public void guardarEmail(String email) {
        emails.add(email);
    }
}
