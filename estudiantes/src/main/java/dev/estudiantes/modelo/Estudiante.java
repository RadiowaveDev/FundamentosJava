package dev.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//boilerplate - repetitivo
@Data
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor //constructor con todos los parametros
@ToString //sobrescribe el metodo toString
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Estudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

}
