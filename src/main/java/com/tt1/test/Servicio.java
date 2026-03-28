package com.tt1.test;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Clase principal de la capa de servicio
 * Coordina la lógica  entre el repositorio y el sistema de notificaciones
 */
public class Servicio {
    private Repositorio repo = new Repositorio();
    private MailerStub mailer = new MailerStub();
    private List<String> nombresDeTareas = new java.util.ArrayList<>();
    /**
     * Crea una nueva tarea con una fecha límite yla guarda en el repositorio
     * @param nombre El nombre de la tarea
     * @param fechaLimite La fecha limite para completar la tarea
     */
    public void crearTarea(String nombre, Date fechaLimite) {
        ToDo nuevaTarea = new ToDo();
        nuevaTarea.setNombre(nombre);
        nuevaTarea.setFecha(fechaLimite);
        nuevaTarea.setCompletado(false);
        repo.guardarNuevaTarea(nuevaTarea);
        nombresDeTareas.add(nombre);
    }
    /**
     * Registra un correo electrónico y lo guarda en el repositorio
     * @param email La dirección de correo a guardar
     */
    public void agregarEmail(String email) {
        repo.guardarEmail(email);
    }
    /**
     *Localiza una tarea por su nombre y la marca como finalizada
     * @param nombre El nombre de la tarea
     */
    public void marcarTareaComoFinalizada(String nombre) {
        repo.marcarCompletada(nombre);
    }
    /**
     * Devuelve todas las tareas que no han sido finalizadas
     * @return Una lista de tareas con estado pendiente
     */
    public List<ToDo> consultarPendientes() {
        return nombresDeTareas.stream()
            .map(nombre -> repo.buscarPorNombre(nombre))
            .filter(t -> t != null && !t.getCompletado())
            .collect(java.util.stream.Collectors.toList());
    }
    /**
     * Método interno para identificar tareas cuya fecha límite ha pasado
     */
    private void comprobarAlertas() {
        Date hoy = new Date();
        List<ToDo> urgentes = nombresDeTareas.stream()
            .map(nombre -> repo.buscarPorNombre(nombre))
            .filter(t -> t != null && !t.getCompletado())
            .filter(t -> t.getFecha().before(hoy)).toList();
    }
}




