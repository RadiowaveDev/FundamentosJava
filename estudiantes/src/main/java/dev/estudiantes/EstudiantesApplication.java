package dev.estudiantes;

import dev.estudiantes.modelo.Estudiante;
import dev.estudiantes.servicio.EstudianteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {
	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);
	static String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion ...");
		//levanta la fabrica de Spring y la inyeccion de dependencias necesarias
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada! ...");
	}

	@Override
	public void run(String... args){
		//logica de presentacion, interaccion por consola
		logger.info(nl+"Ejecutando metodo run de Spring ..."+nl);
		var scan = new Scanner(System.in);
		var salir=false;
		while(!salir){
			try{
				mostrarMenu();
				salir=ejecutarOperacion(scan,estudianteServicio);
				logger.info(nl);
			}catch (Exception e){
				System.out.println("Ocurrio un error "+e.getMessage());
			}
		}
	}

	public static void mostrarMenu(){
		logger.info("""
    			** Sistema de Estudiantes **
    			1. Listar estudiantes
    			2. Buscar estudiantes
    			3. Agregar estudiante
    			4. Modificar estudiante
    			5. Eliminar estudiantes
    			6. Salir
    			Elige una opcion:
    			""");
	}

	public boolean ejecutarOperacion(Scanner scan, EstudianteServicio estudianteServicio){
		var salir= false;
		var opcion = Integer.parseInt(scan.nextLine());
		switch(opcion){
			case 1->{
				logger.info("* Listar todos los estudiantes *"+nl);
				List<Estudiante> estudianteList = estudianteServicio.listarEstudiante();
				estudianteList.forEach((estudiante -> logger.info(estudiante.toString())));
			}
			case 2->{
				logger.info("* Busqueda por Id *"+nl);
				logger.info("Ingrese el Id del estudiante a buscar: ");
				var id = Integer.parseInt(scan.nextLine());
				Estudiante estudiante= estudianteServicio.buscarEstudiantePorId(id);
				if(estudiante != null){
					logger.info("Estudiante encontrado : "+estudiante+nl);
				}else{
					logger.info("No se encontro al estudiante con Id "+id+nl);
				}
			}
			case 3->{
				logger.info("* Agregar estudiante *"+nl);
				logger.info("Ingrese el nombre: ");
				var nombre = scan.nextLine();
				logger.info("Ingrese el apellido: ");
				var apellido = scan.nextLine();
				logger.info("Ingrese el telefono: ");
				var telefono = scan.nextLine();
				logger.info("Ingrese el email: ");
				var email = scan.nextLine();

				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado "+estudiante+nl);
			}
			case 4 ->{
				logger.info("* Modificar estudiante *"+nl);
				logger.info("Ingrese el id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(scan.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Ingrese el nombre: ");
					var nombre = scan.nextLine();
					logger.info("Ingrese el apellido: ");
					var apellido = scan.nextLine();
					logger.info("Ingrese el telefono: ");
					var telefono = scan.nextLine();
					logger.info("Ingrese el email: ");
					var email = scan.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante con id "+idEstudiante+" modificado con exito");
				}else{
					logger.info("Estudiante con id "+idEstudiante+" no encontrado"+nl);
				}
			}
			case 5 ->{
				logger.info("* Eliminar estudiante *"+nl);
				logger.info("Ingrese el id del estudiante a eliminar: ");
				var idEstudiante = Integer.parseInt(scan.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: "+estudiante+nl);
				}else{
					logger.info("Estudiante con id "+idEstudiante+" NO encontrado"+nl);
				}
			}
			case 6 ->{
				logger.info("Hasta luego ..."+nl);
				salir = true;
			}
			default -> logger.info("Opcion no reconocida: "+opcion+nl);
		}
		return salir;
	}
}
