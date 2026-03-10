package com.tt1.test;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Servicio {
    private Repositorio repo = new Repositorio();
    private MailerStub mailer = new MailerStub();
    private List<String> nombresDeTareas = new java.util.ArrayList<>();
    public void crearTarea(String nombre, Date fechaLimite) {
        ToDo nuevaTarea = new ToDo();
        nuevaTarea.setNombre(nombre);
        nuevaTarea.setFecha(fechaLimite);
        nuevaTarea.setCompletado(false);

        repo.guardarNuevaTarea(nuevaTarea);
        nombresDeTareas.add(nombre);
    }
    public void agregarEmail(String email) {
        repo.guardarEmail(email);
    }
    public void marcarTareaComoFinalizada(String nombre) {
        repo.marcarCompletada(nombre);
    }
    public List<ToDo> consultarPendientes() {
        return nombresDeTareas.stream()
            .map(nombre -> repo.buscarPorNombre(nombre))
            .filter(t -> t != null && !t.getCompletado())
            .collect(java.util.stream.Collectors.toList());
    }
    private void comprobarAlertas() {
        Date hoy = new Date();

        List<ToDo> urgentes = nombresDeTareas.stream()
            .map(nombre -> repo.buscarPorNombre(nombre))
            .filter(t -> t != null && !t.getCompletado())
            .filter(t -> t.getFecha().before(hoy)).toList();
    }
}




