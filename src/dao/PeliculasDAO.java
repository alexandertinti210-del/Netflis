package dao;

import conexion.Conexion;
import java.sql.*;

public class PeliculasDAO {

    // 🔹 OPCIÓN 1
    public static void verPeliculas() {
        try {
            Connection con = Conexion.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Peliculas");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("cod_pelicula") + " - " +
                    rs.getString("nombre") + " - " +
                    rs.getString("genero")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 OPCIÓN 2
    public static void filtrargenero(String genero) {
        try {
            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM Peliculas WHERE genero = ?"
            );

            ps.setString(1, genero);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("cod_pelicula") + " - " +
                    rs.getString("nombre") + " - " +
                    rs.getString("genero")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 OPCIÓN 4
    public static void top5() {
        try {
            Connection con = Conexion.conectar();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT TOP 5 p.nombre, AVG(c.calificacion) AS promedio " +
                "FROM Peliculas p " +
                "JOIN Calificacion c ON p.Cod_pelicula = c.Cod_pelicula " +
                "GROUP BY p.nombre " +
                "ORDER BY promedio DESC"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getString("nombre") +
                    " - Promedio: " + rs.getDouble("promedio")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}