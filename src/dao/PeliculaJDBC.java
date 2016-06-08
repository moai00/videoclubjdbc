/*
 * Clase para trabajar con la BBDD
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pelicula;

/**
 *
 * @author mport
 */
public class PeliculaJDBC {

    private Connection conexion;
    
    //funncion que inserta una pelicula en la bbdd
    
    public boolean insertarPelicula(Pelicula pelicula){
        conectar();
        if (conexion != null){
            try {
            String insert="insert into pelicula values (?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, pelicula.getCodigo());
            ps.setString(2, pelicula.getTitulo());
            ps.setInt(3, pelicula.getDuracion());
            ps.setString(4, pelicula.getGenero());
            ps.setInt(5, pelicula.getValoracion());
            ps.setBoolean(6, pelicula.isVisto());
            
            //ejecutar la consulta APPLY
            ps.executeUpdate();
            //liberamos recursos
            ps.close();
            return true;
            }catch(SQLException ex){
                System.out.println("Error al insertar " + ex.getMessage());
                return false;
            }
        }else{
            return false;
        }
        
    }

    //función para establecer la conexión con el servidor
    private void conectar() {
        try {
            //url de la bbdd
            String url = "jdbc:mysql://localhost:3306/videoclub";
            String usr = "root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, usr, password);
        } catch (SQLException ex) {
            //OJO de momento usamos souts para ver los mensajes de error
            System.out.println("Error al conectar" + ex.getMessage());
            conexion = null;
        }
    }

    // Funcion para cerrar la conexión
    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }

}
