package dao;

import conexion.Conexion;
import java.sql.*;

public class PeliculasDAO {

    public static void verPeliculas() {
        try {
            Connection con = Conexion.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Peliculas");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("cod_pelicula") + "  -  " +
                    rs.getString("nombre") + "  -  " +
                    rs.getString("genero") + "  -  " +
                    rs.getString("duracion") + "  -  " +
                    rs.getString("clasificacion")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

