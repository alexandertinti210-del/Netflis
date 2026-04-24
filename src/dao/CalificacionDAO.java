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

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Calificacion (Cod_Usuario, Cod_pelicula, Calificacion) VALUES (?, ?, ?)"
            );

            ps.setInt(1, idUsuario);
            ps.setInt(2, codPelicula);
            ps.setInt(3, calificacion);

            ps.executeUpdate();

            System.out.println(" Se ha registrado tu calificacion");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
