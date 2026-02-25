package com.mercedaws.taller.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private final String dni;
    private final String nombre;

    // Agregación: un cliente tiene vehículos (colección)
    private final List<Vehiculo> vehiculos = new ArrayList<>();

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) return;
        vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return Collections.unmodifiableList(vehiculos);
    }
}
