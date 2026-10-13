# Sistema de Gestión de Transporte Turístico

Programación II 
UTN FRA - Tecnicatura Universitaria en Programación.

# De qué se trata?

Es un programa de consola en Java para administrar los vehículos de una empresa de turismo. La empresa tiene colectivos turísticos, vans ejecutivas y lanchas.

Todos los vehículos tienen patente, marca, capacidad de pasajeros y año de fabricación. Además, cada uno tiene un dato propio:

- Colectivo: cantidad de pisos (1 o 2)
- Van: si tiene aire acondicionado
- Lancha: tipo de motor (NAFTA, DIESEL o ELECTRICO)

# Menú

1. Agregar vehículo
2. Mostrar todos los vehículos
3. Realizar servicios turísticos
4. Buscar vehículo por patente
5. Mostrar vehículos con capacidad mayor a un valor
6. Ordenar por año de fabricación (de más nuevo a más viejo)
7. Ordenar por capacidad (de mayor a menor)
8. Salir

En cualquier pregunta se puede escribir X para cancelar y volver al menú

# Qué usé

- Una clase abstracta `Vehiculo`, de la que heredan las tres clases de vehículos.
- Polimorfismo con el método `realizarServicio()`, que cada vehículo sobrescribe a su manera.
- Atributos privados con getters.
- Un `ArrayList` para guardar los vehículos, dentro de la clase `GestorTransporte`.
- `Comparable` para ordenar por año y un `Comparator` (`ComparadorPorCapacidad`) para ordenar por capacidad.
- Una excepción propia, `PatenteDuplicadaException`.
- `try-catch` para controlar cuando se ingresa texto en lugar de un número.

## Validaciones

El programa no deja cargar:

- patentes vacías, repetidas o con un largo distinto de 6 o 7 caracteres
- capacidad menor o igual a cero
- años menores a 1990 o mayores al actual
- una cantidad de pisos distinta de 1 o 2
- un motor que no sea NAFTA, DIESEL o ELECTRICO

Si un dato está mal, muestra el error y lo vuelve a pedir.

## Diagrama de clases

[Diagrama UML]
(SistemaGestionTransporteTuristico_UML_FINAL.png)

## Cómo ejecutarlo

Abrir el proyecto en NetBeans y ejecutar la clase `Main`.
Al iniciar se cargan tres vehículos de prueba (AB456CD, AD321GH y LAN002).

---

Gimena Díaz
