package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection conectar() {
        Connection con = null;

        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Neflis;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String pass = "1234"; // cambia esto

            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado a Neflis");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }
}
