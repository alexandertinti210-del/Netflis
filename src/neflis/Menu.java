package neflis;

import java.util.Scanner;
import dao.PeliculasDAO;


public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- NEFLIS ---");
            System.out.println("1. Ver peliculas");
            System.out.println("2. Buscar por genero");
            System.out.println("3. Calificar pelicula");
            System.out.println("4. Top 5 peliculas mejor calificadas");
            System.out.println("5. Salir");
            System.out.print("Escoje una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    PeliculasDAO.verPeliculas();
                    break;
                
                case 2:
                    System.out.println("Ingrese genero: ");
                    break;   
                
                case 3:
                    System.out.println("Falta hacerlo");
                    break;
                    
                case 4:
                    System.out.println("Falta hacerlo");
                    break;

                case 5:
                    System.out.println("Hasta Luego");
                    break;

                default:
                    System.out.println("Opcion Invalida");
            }

        } while (opcion != 5);
    }
}