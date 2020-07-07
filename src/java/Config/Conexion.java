
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AM BLANCO
 */
public class Conexion {

    private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "prueba";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private Connection con;

    public Conexion() {

        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR" + e);
        } catch (SQLException ex) {
            System.err.println("ERROR" + ex);
        }

    }

    public Connection getConexion() {
        return con;
    }

    public static void main(String[] args) {
        Conexion con = new Conexion();
    }

}
