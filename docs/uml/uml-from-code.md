classDiagram
direction LR

%% =========================
%% MODELO DE DOMINIO
%% =========================

class Vehiculo {
  -String matricula
  -String modelo
  -List~Reparacion~ historial
  +getMatricula() String
  +getModelo() String
  +getHistorial() List~Reparacion~
  +addReparacion(Reparacion) void
}

class Coche
class Moto

Vehiculo <|-- Coche
Vehiculo <|-- Moto

class Cliente {
  -String dni
  -String nombre
  -List~Vehiculo~ vehiculos
  +addVehiculo(Vehiculo) void
  +getVehiculos() List~Vehiculo~
}

Cliente "1" o-- "1..*" Vehiculo : posee

class Reparacion {
  -String codigo
  -String descripcion
  -double coste
  -LocalDate fecha
  +getCodigo() String
  +getDescripcion() String
  +getCoste() double
  +getFecha() LocalDate
}

Vehiculo "1" *-- "0..*" Reparacion : historial

class Factura {
  -String numero
  -LocalDate fechaEmision
  -double total
  +getNumero() String
  +getFechaEmision() LocalDate
  +getTotal() double
}

%% =========================
%% MECÁNICOS
%% =========================

class Especialista {
  <<interface>>
  +reparar(Reparacion) void
}

class Mecanico {
  -String idEmpleado
  -String nombre
  +reparar(Reparacion) void
}

Especialista <|.. Mecanico

%% =========================
%% SERVICIOS
%% =========================

class Taller {
  +asignarReparacion(Mecanico, Reparacion) void
}

Taller ..> Mecanico : usa
Taller ..> Reparacion : asigna
