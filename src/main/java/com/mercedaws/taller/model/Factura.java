package com.mercedaws.taller.model;

import java.time.LocalDate;

public class Factura {

    private final String numero;
    private final LocalDate fechaEmision;
    private final double total;

    public Factura(String numero, LocalDate fechaEmision, double total) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getTotal() {
        return total;
    }
}
