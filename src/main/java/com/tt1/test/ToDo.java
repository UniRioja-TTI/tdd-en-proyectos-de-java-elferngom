package com.tt1.test;

import java.util.Date;
/**
 * Clase que almacena la información básica sobre la tarea
 */
public class ToDo {
    private String nombre;
    private String descripcion;
    private Date fecha;
    private boolean completado;
    /**
     * Obtiene el nombre de la tarea
     * @return Una string con el nombre de la tarea
     */
    public String getNombre() { return nombre; }
    /**
     * Define el nombre de la tarea
     * @param nombre El nuevo nombre para la tarea
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
    /**
     * Obtienela descripción de la tarea
     * @return La descripcion de la tarea
     */
    public String getDescripcion() { return descripcion; }
    /**
     * Guarda una descripción para la tarea
     * @param descripcion Texto con la descripción de la tarea a realizar
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    /**
     * Recupera la fecha limite
     * @return Un Date  con el la fecha limite
     */
    public Date getFecha() { return fecha; }
    /**
     * Asigna una fecha de vencimiento
     * @param fecha La fecha limite
     */
    public void setFecha(Date fecha) { this.fecha = fecha; }
    /**
     * Indica si la tarea ya ha sido finalizada
     * @return {@code true} si la tarea está completada; {@code false} en caso contrario.
     */
    public boolean getCompletado() { return completado; }
    /**
     * Actualiza el estado de finalización de la tarea
     * @param completado Valor booleano que marca el nuevo estado
     */
    public void setCompletado(boolean completado) { this.completado = completado; }
}
