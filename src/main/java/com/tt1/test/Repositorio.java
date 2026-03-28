package com.tt1.test;
/**
 * Clase que actua como una capa intermedia que abstrae el uso del simulador
 * de base de datos para el resto del sistema
 */
public class Repositorio {
    private DBStub db = new DBStub();
    /**
     *Busca una tarea en el sistema de almacenamiento filtrando por su nombre
     * @param nombre El nombre unico de la tarea
     * @return La tarea encontrada
     */
    public ToDo buscarPorNombre(String nombre) {
        return db.leer(nombre);
    }
    /**
     *Localiza una tarea por su nombre, cambia su estado a completado
     * @param nombre el nombre de la tarea que se desea marcar como terminada
     */
    public void marcarCompletada(String nombre) {
        ToDo tarea = db.leer(nombre);
        if (tarea != null) {
            tarea.setCompletado(true);
            db.actualizar(tarea);
        }
    }
    /**
     *Envia una nueva tarea al sistema para guardarla
     * @param tarea La nueva tarea
     */
    public void guardarNuevaTarea(ToDo tarea) {
        db.crear(tarea);
    }
    /**
     *Registra una dirección de correo electrónico
     * @param email La nueva dirección de correo
     */
    public void guardarEmail(String email) {
        db.guardarEmail(email);
    }
}
