package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

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

    @org.junit.jupiter.api.Test
    void crearTarea() {
        Date fecha = new Date();
        assertDoesNotThrow(() -> {
            miServicio.crearTarea("Hacer práctica TDD", fecha);
        }, "Debería permitir crear una tarea con datos válidos");
    }

    @org.junit.jupiter.api.Test
    void agregarEmail() {
        Servicio miServicio = new Servicio();
        assertDoesNotThrow(() -> {
            miServicio.agregarEmail("test@unirioja.es");
        }, "El método no debería lanzar una excepción al añadir un email válido");
    }

    @org.junit.jupiter.api.Test
    void marcarTareaComoFinalizada() {
        assertDoesNotThrow(() -> {
            miServicio.marcarTareaComoFinalizada("Hacer práctica TDD");
        }, "Debería poder marcar como finalizada una tarea existente");
    }

    @org.junit.jupiter.api.Test
    void consultarPendientes() {
        assertNotNull(miServicio.consultarPendientes(),
            "La lista de pendientes no debería ser nula");
    }

    @Test
    void testIntegracionEmailsAlUnisono() {
        Servicio servicio = new Servicio();
        DBStub db = new DBStub();
        String emailTest = "test-integracion@unirioja.es";
        servicio.agregarEmail(emailTest);
        java.util.Set<String> agenda = db.obtenerEmails();
        assertNotNull(agenda, "La agenda no debería ser nula");
        assertTrue(agenda.contains(emailTest),
            "La integración ha fallado: El email no llegó al DBStub");
    }
}