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
        repo = new Repositorio();
    }

    @AfterEach
    void tearDown() {
        repo = null;
    }
    @Test
    void testGuardar() {
        Repositorio repo = new Repositorio();
        assertDoesNotThrow(() -> repo.guardarNuevaTarea(new ToDo()));
    }

}
