package datos;

import dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import static conexion.conexion.getConnection;

//DAO:  Data Access Object
public class EstudianteDao {
    public List <Estudiante> listarEstudiantes(){
        List<Estudiante> estudianteList = new ArrayList<>();
        PreparedStatement st;
        ResultSet rs;
        Connection con = getConnection();
        String query = "SELECT * FROM estudiante ORDER BY id_estudiante";
        try{
            st=con.prepareStatement(query);
            rs=st.executeQuery();
            while(rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudianteList.add(estudiante);
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al seleccionar datos "+ e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion "+e.getMessage());
            }
        }
        return estudianteList;
    }

    public boolean findById(Estudiante estudiante){
        PreparedStatement st;
        ResultSet rs;
        Connection con = getConnection();
        String query = "SELECT * FROM estudiante WHERE id_estudiante= ?";
        try{
            st=con.prepareStatement(query);
            st.setInt(1,estudiante.getIdEstudiante());
            rs=st.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar al estudiante"+e.getMessage());
        }
        finally{
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion "+e.getMessage());
            }
        }
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String query = "INSERT INTO estudiante (nombre, apellido, telefono, email) " +
                "VALUES (?,?,?,?)";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al agregar estudiante "+e.getMessage());
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la base de datos");
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String query = "UPDATE estudiante SET nombre=?,apellido=?,telefono=?,email=? WHERE id_estudiante=?";
        try{
            ps=con.prepareStatement(query);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.setInt(5,estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al modificar el estudiante "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion "+e.getMessage());
            }
        }
        return false;
    }
    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String query = "DELETE FROM estudiante WHERE id_estudiante=?";
        try{
            ps=con.prepareStatement(query);
            ps.setInt(1,estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar el estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }
        }
        return false;
    }


    public static void main(String[] args) {
        var estudianteDao = new EstudianteDao();
        //Agregar estudiantes
        /*
        var nuevoEstudiante = new Estudiante("Carlos","Lara","55117788","Carlos@example.com");
        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
        if(agregado){
            System.out.println("Estudiante agregado: "+nuevoEstudiante);
        }else{
            System.out.println("No se agrego el estudiante "+nuevoEstudiante);
        }
        */
        //Modificar estudiante
        var modificaEstudiante = new Estudiante(5,"Ash","Kepchum","455789123","ash@exmaple.com");
        var modificado = estudianteDao.modificarEstudiante(modificaEstudiante);
        if(modificado){
            System.out.println("Estudiante modificado "+modificaEstudiante);
        }else{
            System.out.println("No se modifico el estudiante: "+modificaEstudiante);
        }

        //Eliminar estudiante
        var estudianteEliminar = new Estudiante(6);
        var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
        if(eliminado){
            System.out.println("Estudiante eliminado: "+estudianteEliminar);
        }else{
            System.out.println("No se elimino el estudiante "+estudianteEliminar);
        }

        //Listar estudiantes
        System.out.println("** Listado de Estudiantes **");
        List<Estudiante> estudianteList = estudianteDao.listarEstudiantes();
        estudianteList.forEach(System.out::println);

        //Buscar por Id
        /*
        var estudiante1 = new Estudiante(2);
        System.out.println("** Busqueda por Id **");
        var estudianteEncontrado = estudianteDao.findById(estudiante1);
        if(estudianteEncontrado){
            System.out.println("Estudiante encontrado: "+estudiante1);
        }else{
            System.out.println("Estudiante no encontrado "+estudiante1.getIdEstudiante());
        }
         */
    }
}
