package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class RepositorioTest {
    Repositorio repo;
    @BeforeEach
    void setUp() {
        DBStub.limpiarDatos();
        repo = new Repositorio();
    }

    @AfterEach
    void tearDown() {
        repo = null;
    }
    //Test unitario
    @Test
    void testGuardar() {
        ToDo tarea = new ToDo();
        String nombre = "tarea";
        tarea.setNombre(nombre);
        repo.guardarNuevaTarea(tarea);
        ToDo recupera = repo.buscarPorNombre(nombre);
        assertNotNull(recupera, "La tarea debería haberse guardado");
        assertEquals(nombre, recupera.getNombre(), "deberia ser igual");
    }
    //Test unitario
    @Test
    void testmarcartarea() {
        ToDo tarea = new ToDo();
        String nombre = "tarea";
        tarea.setNombre(nombre);
        repo.guardarNuevaTarea(tarea);
        repo.marcarCompletada(nombre);
        assertTrue(repo.buscarPorNombre(nombre).getCompletado(),
            "La tarea marcada como completada");
    }

}
