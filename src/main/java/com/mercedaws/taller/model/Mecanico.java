package com.mercedaws.taller.model;

public class Mecanico implements Especialista {

    private final String idEmpleado;
    private final String nombre;

    public Mecanico(String idEmpleado, String nombre) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void reparar(Reparacion r) {
    }
}
