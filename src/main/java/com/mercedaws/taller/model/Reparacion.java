package com.mercedaws.taller.model;

import java.time.LocalDate;

public class Reparacion {

    private final String codigo;
    private final String descripcion;
    private final double coste;
    private final LocalDate fecha;

    public Reparacion(String codigo, String descripcion, double coste, LocalDate fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.coste = coste;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCoste() {
        return coste;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
