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
    @Test
    void testCrear() {
        DBStub db = new DBStub();
        ToDo tarea = new ToDo();
        assertDoesNotThrow(() -> db.crear(tarea));
    }
}
