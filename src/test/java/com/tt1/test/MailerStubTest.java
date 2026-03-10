package com.tt1.test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    @Test
    void testEnviar() {
        MailerStub mailer = new MailerStub();
        assertDoesNotThrow(() -> mailer.enviarCorreo("test@test.com", "hola"));
    }
}
