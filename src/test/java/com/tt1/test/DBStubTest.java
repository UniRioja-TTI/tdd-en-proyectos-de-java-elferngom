package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DBStubTest {
    DBStub db;
    @BeforeEach
    void setUp() {
        db = new DBStub();
    }
    @AfterEach
    void tearDown() {
        db = null;
    }
    //Test unitario
    @Test
    void testCrearYLeer() {
        ToDo tarea = new ToDo();
        tarea.setNombre("tarea");
        db.crear(tarea);
        assertNotNull(db.leer("tarea"));
        assertEquals("tarea", db.leer("tarea").getNombre());
    }
}
