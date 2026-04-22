
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionSQL {

    public static Connection conectar() {
        Connection con = null;

        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Neflis;encrypt=true;trustServerCertificate=true;";
            String user = "sa";  // tu usuario
            String password = "1234"; // tu contraseña
            
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa a netflix");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return con;
    }
}