# 6.3 – Sistema de Gestión de un Taller (MerceDAWs)

> *“Un repo para gobernarlos a todos,  
> un UML para encontrarlos,  
> un commit para traerlos a todos  
> y en el taller enlazarlos.”*

Proyecto de diseño y modelado de una aplicación para la gestión de un taller de vehículos.  
Aplicamos conceptos de **Programación Orientada a Objetos**, **UML**, **ingeniería directa** e **ingeniería inversa**



## Objetivo del proyecto

Diseñar, implementar y documentar la estructura de una aplicación para el taller *MerceDAWs*, modelando correctamente las entidades del dominio y las relaciones entre ellas, de acuerdo con el enunciado propuesto

El proyecto se divide en cuatro fases:
1. Diseño UML
2. Ingeniería directa
3. Interpretación del diseño
4. Ingeniería inversa


### Fase 1 – Diseño UML
El diseño del sistema lo he hecho con un diagrama de clases UML, utilizando **Mermaid**, incluido en el archivo `DESIGN.md`

En el diagrama se representan:
- Clases, atributos y métodos principales
- Relaciones de herencia, agregación, composición, realización y dependencia
- Visibilidad de atributos y métodos
- Multiplicidades coherentes con el dominio del problema


### Fase 2 – Ingeniería directa
A partir del diagrama UML, se ha generado el **esqueleto de clases en Java**, respetando fielmente la estructura definida en el diseño

En esta fase:
- No se implementa lógica interna compleja
- Se prioriza que las relaciones UML estén correctamente reflejadas en el código (herencia, colecciones, interfaces, dependencias)
- El código actúa como una traducción directa del plano de diseño


### Fase 3 – Interpretación y justificación del diseño

#### ¿Por qué se ha usado **composición** entre Vehiculo y Reparacion?

Se ha elegido **composición** porque una **Reparación no tiene sentido sin un Vehículo**, tal y como indica explícitamente el enunciado (“vínculo fuerte”)

Esto implica que:
- La reparación forma parte del ciclo de vida del vehículo
- Si un vehículo se elimina del sistema, su historial de reparaciones deja de existir como entidad independiente
- La relación es fuerte y estructural, por lo que se representa con rombo negro en UML


#### ¿Por qué he usado **agregación** entre Cliente y Vehiculo?
- Un cliente posee uno o varios vehículos
- Vehículos pueden existir conceptualmente independientemente del cliente (ej.: cambio de propietario)
- El ciclo de vida del vehículo no depende estrictamente del cliente
Por eso la relación se representa como un “tiene” sin dependencia total del ciclo de vida


#### ¿Qué ventaja tiene usar la interfaz Especialista?
La interfaz **Especialista** define un contrato común mediante el método `reparar()`

- Obliga a que cualquier clase que represente un especialista implemente el comportamiento mínimo esperado
- Facilita la extensibilidad del sistema (ej.: distintos tipos de mecánicos)
- Permite aplicar polimorfismo y desacoplar el diseño
La clase `Mecanico` implementa esta interfaz, cumpliendo el contrato definido


#### ¿Por qué Taller tiene una dependencia puntual con Mecanico?
La clase `Taller` **no posee** un mecánico como atributo, sino que **lo utiliza puntualmente** para asignar una reparación

Lo representamos con:
- Una dependencia UML (flecha discontinua)
- Un método que recibe al mecánico como parámetro

Este diseño también evita un acoplamiento innecesario entre clases


### Fase 4 – Ingeniería inversa
He añadido directamente en el código la clase `Factura`, sin modificar previamente el diagrama UML

Después he generado un nuevo diagrama UML automáticamente a partir del código fuente usando herramientas de ingeniería inversa para:
- Obtener documentación técnica a partir del código existente
- Comprobar la coherencia entre diseño y código



## Estructura del proyecto

6.3.Actividad_taller
|- src
|  |- main
|     |- java
|        |- com
|           |- mercedaws
|              |- taller
|                 |- model
|                 |- service
|- docs
|- DESIGN.md
|- README.md
|- .gitignore



## Conclusiones
- El UML no es decorativo.
- El diseño importa.
- Git bien usado ahorra sangre, sudor y lágrimas.
- Hacer todo el proyecto desde la terminal mola, te hace sentir más pro.

> *“Not all those who wander are lost,  
> but those who code without UML probably are.”*
