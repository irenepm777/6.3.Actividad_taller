package com.mercedaws.taller.service;

import com.mercedaws.taller.model.Mecanico;
import com.mercedaws.taller.model.Reparacion;

public class Taller {

    // Dependencia puntual: el taller usa un mecánico para asignar una reparación
    public void asignarReparacion(Mecanico mecanico, Reparacion reparacion) {
        if (mecanico == null || reparacion == null) return;
        mecanico.reparar(reparacion);
    }
}
