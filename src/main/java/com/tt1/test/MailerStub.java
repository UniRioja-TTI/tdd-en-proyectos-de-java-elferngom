package com.tt1.test;
/**
 * Clase que simula un servicio de envío de correos electrónicos
 */
public class MailerStub {
    /**
     * Simula el envío imprimiendo el contenido en la consola
     * @param email   La dirección de correo
     * @param mensaje El mensaje que se desea enviar
     * @return {@code true} indicando que el proceso de envío se ha iniciado
     */
    public boolean enviarCorreo(String email, String mensaje) {
        System.out.println("Enviando correo a: " + email + " - Mensaje: " + mensaje);
        return true;
    }
}
