%% UML — MerceDAWs (Sistema de Gestión de Taller)
%% Justificación de relaciones según enunciado y buenas prácticas



classDiagram
direction LR



%% Vehículos (herencia)
%% --------------------
class Vehiculo {
  %% Atributos comunes a todos los vehículos (enunciado): matrícula y modelo. Se definen como privados para encapsulación
  -String matricula
  -String modelo
}

class Coche
class Moto

%% Herencia (generalización):
%% Coche y Moto "son" Vehiculo. Evita duplicación y permite polimorfismo
Vehiculo <|-- Coche
Vehiculo <|-- Moto



%% Cliente (agregación con Vehiculo)
%% ---------------------------------
class Cliente {
  %% Datos típicos de cliente por meter alguna cosilla
  -String dni
  -String nombre

  %% Colección: Enunciado dice "uno o varios Vehiculos"
  %% En UML lo expresamos con multiplicidad 1..* en la relación y aquí con List<Vehiculo>
  -List~Vehiculo~ vehiculos

  %% Métodos min para gestionar colección de forma controlada
  +addVehiculo(Vehiculo v) void
  +getVehiculos() List~Vehiculo~
}

%% Agregación (rombo blanco):
%% Un Cliente "tiene" Vehículos, pero el vehículo puede existir conceptualmente sin el cliente (ej.: cambio de propietario, baja del cliente, ...)
%% Por eso NO es composición
%%
%% Multiplicidades:
%% - Cliente "1": cada cliente es una instancia única
%% - Vehiculo "1..*": el enunciado indica que posee uno o varios
Cliente "1" o-- "1..*" Vehiculo



%% Reparaciones (composición con Vehiculo)
%% ---------------------------------------
class Reparacion {
  %% Datos básicos de reparación
  -String codigo
  -String descripcion
  -double coste
  -LocalDate fecha
}

%% Composición (rombo negro):
%% Enunciado: "Una reparación no tiene sentido sin un vehículo (vínculo fuerte)"
%% Ciclo de vida dependiente: si el vehículo desaparece del sistema, su historial de reparaciones deja de tener entidad en este dominio
%%
%% Multiplicidades:
%% - Vehiculo "1": cada reparación pertenece a un vehículo
%% - Reparacion "0..*": un vehículo puede tener 0 reparaciones (vehículo nuevo) o muchas
Vehiculo "1" *-- "0..*" Reparacion



%% Mecánicos (interfaz + realización)
%% ----------------------------------
class Especialista {
  <<interface>>
  %% Interfaz obliga a implementar el comportamiento mínimo "reparar()"
  %% Ventaja: uniformidad, extensibilidad,  posibilidad de polimorfismo
  +reparar(Reparacion r) void
}

class Mecanico {
  %% Identificación interna del mecánico (ejemplo típico)
  -String idEmpleado
  -String nombre

  %% Implementación contrato Especialista
  +reparar(Reparacion r) void
}

%% Realización (interfaz):
%% Línea discontinua + triángulo vacío
%% !herencia: Mecanico NO "es" Especialista como clase, implementa contrato interfaz
Especialista <|.. Mecanico



%% Taller (dependencia puntual hacia Mecanico)
%% -------------------------------------------
class Taller {
  %% Dependencia puntual: el taller usa un mecánico para asignar una reparación
  %% No se modela como atributo fijo (no "tiene" un mecánico), sino quw lo usa en una operación
  +asignarReparacion(Mecanico m, Reparacion r) void
}

%% Dependencia (flecha discontinua):
%% Representa "usa" en tiempo de ejecución (parámetros / llamada de método),
%% Enunciado: "Taller usa (dependencia puntual) a un Mecanico"
Taller ..> Mecanico

%% Dependencia también hacia Reparacion porque la asigna/gestiona en ese proceso
Taller ..> Reparacion
