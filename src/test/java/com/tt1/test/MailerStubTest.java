package com.tt1.test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MailerStubTest {
    MailerStub mailer;
    @BeforeEach
    void setUp() {
        mailer = new MailerStub();
    }
    @AfterEach
    void tearDown() {
        mailer = null;
    }
    //Test unitario
    @Test
    void testEnviar() {
        String email = "test@test.com";
        String mensaje = "Hola";
        boolean resultado = mailer.enviarCorreo(email, mensaje);
        assertTrue(resultado, "Deberia devolver true");
    }
}
