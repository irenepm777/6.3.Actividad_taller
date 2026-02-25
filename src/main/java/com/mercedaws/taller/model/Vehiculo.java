package com.mercedaws.taller.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Vehiculo {

    private final String matricula;
    private final String modelo;

    // Composición: el historial pertenece al vehículo (ciclo de vida ligado)
    private final List<Reparacion> historial = new ArrayList<>();

    protected Vehiculo(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public List<Reparacion> getHistorial() {
        return Collections.unmodifiableList(historial);
    }

    public void addReparacion(Reparacion reparacion) {
        if (reparacion == null) return;
        historial.add(reparacion);
    }
}
