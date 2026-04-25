package dao;

import conexion.Conexion;
import java.sql.*;
import java.util.Scanner;

public class CalificacionDAO {

    public static void calificar() {
       Scanner sc = new Scanner(System.in);

        try {
            Connection con = Conexion.conectar();

            System.out.print("ID del usuario: ");
            int idUsuario = sc.nextInt();

            System.out.print("Codigo de la pelicula: ");
            int codPelicula = sc.nextInt();

            System.out.print("Ingresa una calificacion del 1 al 5: ");
            int calificacion = sc.nextInt();

          
            PreparedStatement check = con.prepareStatement(
                "SELECT * FROM Calificacion WHERE Cod_Usuario = ? AND Cod_pelicula = ?"
            );
            check.setInt(1, idUsuario);
            check.setInt(2, codPelicula);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                
                PreparedStatement update = con.prepareStatement(
                    "UPDATE Calificacion SET Calificacion = ? WHERE Cod_Usuario = ? AND Cod_pelicula = ?"
                );
                update.setInt(1, calificacion);
                update.setInt(2, idUsuario);
                update.setInt(3, codPelicula);
                update.executeUpdate();

                System.out.println(" Calificación actualizada correctamente");

            } else {
                
                PreparedStatement insert = con.prepareStatement(
                    "INSERT INTO Calificacion (Cod_Usuario, Cod_pelicula, Calificacion) VALUES (?, ?, ?)"
                );
                insert.setInt(1, idUsuario);
                insert.setInt(2, codPelicula);
                insert.setInt(3, calificacion);
                insert.executeUpdate();

                System.out.println(" Calificación registrada correctamente");
            }

            
            rs.close();
            check.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

