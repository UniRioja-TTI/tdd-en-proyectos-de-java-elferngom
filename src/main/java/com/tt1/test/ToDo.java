package com.tt1.test;

import java.util.Date;

public class ToDo {
    private String nombre;
    private String descripcion;
    private Date fecha;
    private boolean completado;
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public boolean getCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
}
