📘 Proyecto Introductorio a Spring Boot – CRUD de Estudiantes
Este proyecto es una aplicación Spring Boot de consola que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad Estudiante.
El objetivo es mostrar la estructura básica de una aplicación con Spring Boot, Spring Data JPA y Lombok, utilizando un flujo de interacción simple mediante consola.

🧠 Descripción de las Clases Principales

🏫 Estudiante
Representa la entidad principal del sistema.
Anotada con @Entity y utilizando Lombok para simplificar código con anotaciones como @Data, @NoArgsConstructor y @AllArgsConstructor.

💾 EstudianteRepositorio
Interfaz que hereda de JpaRepository<Estudiante, Long>.
Permite el acceso directo a las operaciones CRUD básicas sin necesidad de implementación manual.

⚙️ EstudianteServicio
Contiene la lógica de negocio y los métodos para ejecutar las operaciones CRUD.

public List <Estudiante> listarEstudiantes()
public Estudiante buscarEstudiantePorId(int idEstudiante)
public void guardarEstudiante(Estudiante estudiante)
public void eliminarEstudiante(Estudiante estudiante)

🖥️ EstudiantesApplication

Clase principal que levanta el contexto de Spring Boot (@SpringBootApplication).
Implementa CommandLineRunner para ejecutar el método run() al iniciar la aplicación.
Dentro de este método, se permite al usuario interactuar desde consola para crear, listar, modificar o eliminar estudiantes.