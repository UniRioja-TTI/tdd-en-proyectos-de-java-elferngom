package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TestServicio {
    private Servicio miServicio;
    @BeforeEach
    void setUp() {
        miServicio = new Servicio();
    }

    @AfterEach
    void tearDown() {
        miServicio = null;
    }
    //test de integracion
    @org.junit.jupiter.api.Test
    void crearTarea() {
        Date fecha = new Date();
        String nombre="tarea1";
        miServicio.crearTarea(nombre, fecha);
        assertTrue(miServicio.consultarPendientes().stream()
            .anyMatch(t -> t.getNombre().equals(nombre)), "No esta");
    }
    //test de integracion
    @org.junit.jupiter.api.Test
    void consultarPendientes() {
        miServicio.crearTarea("A", new Date());
        miServicio.crearTarea("B", new Date());
        miServicio.crearTarea("C", new Date());
        miServicio.marcarTareaComoFinalizada("B");
        List<ToDo> pendientes = miServicio.consultarPendientes();
        assertEquals(2, pendientes.size(), "2 tareas pendientes");
    }
    //Test de integración
    @Test
    void testIntegracionEmailsAlUnisono() {
        Servicio servicio = new Servicio();
        DBStub db = new DBStub();
        String emailTest = "test@test.es";
        servicio.agregarEmail(emailTest);
        Set<String> agenda = db.obtenerEmails();
        assertNotNull(agenda, "agenda no nula");
        assertTrue(agenda.contains(emailTest),
            "El email no llegó");
    }
}