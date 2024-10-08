
package Modelo;

import java.sql.*;

/**
 *
 * @author rodri
 */
public class Conexion {
    
      //Variables para la cadena de conexión
    private static final String URL = "jdbc:oracle:thin:@192.168.56.99:1521:xe";
    private static final String USUARIO = "Doctores";
    private static final String CONTRASENA = "DOCS";
    //Creación del metodo de conexión que retorna la conexión
    public static Connection getConexion() {
        try {
            // Cargar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            // Obtener la conexión en una variable
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            // Retornamos la variable que tiene la conexión
            return conexion;
        } catch (SQLException e) {
            System.out.println("Este es el error" + e);
              return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("este es el error de la clase" + ex);
              return null;
        }
    } 
}
