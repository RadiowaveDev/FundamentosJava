# Proyectos sobre Fundamentos de Java 21

Este repositorio demuestra la aplicación de conceptos clave de la programación en Java, desde los fundamentos de la sintaxis hasta la programación orientada a objetos, patrones de diseño y conectividad con bases de datos. [cite_start]Todos los proyectos están desarrollados utilizando **Java 21** [cite: 1] [cite_start]e **Intellij Idea**[cite: 1].

## 1. Calculadora Aritmética (Consola)

Un proyecto inicial para demostrar el manejo de la lógica de control y la entrada de datos en Java.

* **Objetivo:** Crear una calculadora que realiza las cuatro operaciones básicas (sumar, restar, multiplicar, dividir)
* **Características y Conceptos Aplicados:**
    * Ingreso de datos por consola
    * Uso de la palabra reservada `var` para la declaración de variables
    * Implementación de estructuras de control de flujo: `if-else`, `while` y `switch`
    * Definición y uso de métodos estáticos

## 2. Catálogo de Películas (Programación Orientada a Objetos)

Este proyecto aplica los pilares fundamentales de la Programación Orientada a Objetos (OOP) para gestionar un catálogo de películas

* **Objetivo:** Estructurar una aplicación de gestión de películas aplicando encapsulamiento, abstracción y herencia.
* **Arquitectura y Conceptos Aplicados:**
    * **Encapsulamiento:** Creación de la clase `Pelicula` con sus atributos y métodos para proteger el estado
    * **Abstracción:** Definición de la interfaz `IServicioPerliculas` que establece los métodos requeridos (listar, agregar, buscar películas)
    * **Herencia:**
        * `ServicioPeliculas`: Una clase que genera el objeto de películas
        * `ServicioPeliculasArchivo`: Una implementación especializada que guarda la información de las películas creadas en un archivo (`método FILE`)

## 3. Venta de Computadoras (OOP Avanzado)

Un proyecto enfocado en demostrar el uso avanzado de la herencia y el polimorfismo en un escenario de ensamblaje y venta de computadoras

* **Objetivo:** Modelar los componentes de una computadora y la computadora misma utilizando conceptos avanzados de OOP.
* **Conceptos Aplicados:**
    * **Herencia:** Creación de una jerarquía de clases donde `monitor`, `mouse` y `teclado` heredan de `Dispositivo entrada`
    * **Encapsulamiento:** Diseño de la clase `Computadora` con sus atributos y métodos específicos
    * **Polimorfismo:** Implementación de un ID autoincremental gestionado a través de polimorfismo en el constructor de la clase `Computadora`

## 4. Sistema de Estudiantes (Patrón DAO y JDBC)

Una aplicación multicapa que implementa un CRUD completo para la gestión de estudiantes, conectándose a una base de datos real.

* **Objetivo:** Demostrar la separación de responsabilidades y la persistencia de datos mediante el patrón DAO y JDBC.
* **Arquitectura y Tecnologías:**
    * **Patrón de Diseño DAO (Data Access Object):** Utilizado para aislar la lógica de acceso a datos de la lógica de negocio.
    * **Arquitectura por Capas:** El proyecto está estructurado en capas de dominio, conexión, datos y presentación.
    * **Base de Datos:** Conexión a **SQL Server** mediante **JDBC (Java Database Connectivity)**.
    * **Funcionalidad:** Implementación de operaciones CRUD completas para la entidad `Estudiante` (listar, agregar, modificar y eliminar).