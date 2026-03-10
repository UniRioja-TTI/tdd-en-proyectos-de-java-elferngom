package com.tt1.test;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Servicio {
    private Repositorio repo = new Repositorio();
    private MailerStub mailer = new MailerStub();
    public void crearTarea(String nombre, Date fechaLimite) {
        ToDo nuevaTarea = new ToDo();
        nuevaTarea.setNombre(nombre);
        nuevaTarea.setFecha(fechaLimite);
        nuevaTarea.setCompletado(false);

        repo.guardarNuevaTarea(nuevaTarea);
    }
    public void agregarEmail(String email) {
        repo.guardarEmail(email);
    }
    public void marcarTareaComoFinalizada(String nombre) {
        repo.marcarCompletada(nombre);
    }
    public List<ToDo> consultarPendientes() {
        return null;
    }
    private void comprobarAlertas() { throw new UnsupportedOperationException("Clase aún no implementada."); }
}




