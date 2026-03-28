package com.tt1.test;
import java.util.*;

/**
 * Clase que actúa como un simulador de base de datos
 * Permite gestionar una lista de tareas y un conjunto de correos electrónicos.
 */
public class DBStub {
    private static List<ToDo> tareas = new java.util.ArrayList<>();
    private static Set<String> emails = new java.util.HashSet<>();
    /**
     * Añade una nueva tarea a la lista
     * @param tarea El objeto que se desea registrar
     */
    public void crear(ToDo tarea) {
        tareas.add(tarea);
    }
    /**
     * Busca una tarea específica en el sistema a partir de su nombre
     * @param nombre El nombre de la tarea a buscar
     * @return La tarea encontrada a partir del nombre
     */
    public ToDo leer(String nombre) {
        return tareas.stream()
            .filter(t -> Objects.equals(nombre, t.getNombre()))
            .findFirst()
            .orElse(null);
    }
    /**
     * Actualiza la información de una tarea existente
     * @param tarea El objeto con los datos actualizados
     */
    public void actualizar(ToDo tarea) {
        ToDo vieja = leer(tarea.getNombre());
        if (vieja != null) {
            tareas.remove(vieja);
            tareas.add(tarea);
        }
    }
    /**
     * Elimina del sistema todas las tareas con ese nombre
     * @param nombre El nombre de la tarea que se desea borrar
     */
    public void borrar(String nombre) {
        tareas.removeIf(t -> t.getNombre().equals(nombre));
    }
    /**
     * Recupera el conjunto completo de correos electrónicos almacenados
     * @return Un set que contiene las direcciones de email registradas
     */
    public Set<String> obtenerEmails() {
        return emails;
    }
    /**
     * Registra una nueva dirección de correo electrónico en el sistema
     * @param email El string que representa el email a guardar
     */
    public void guardarEmail(String email) {
        emails.add(email);
    }
}
