package com.tt1.test;

public class MailerStub {
    public boolean enviarCorreo(String email, String mensaje) {
        System.out.println("Enviando correo a: " + email + " - Mensaje: " + mensaje);
        return true;
    }
}
