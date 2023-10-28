package hilosSockets;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
    	
        try (//Socket socket = new Socket("localhost", 2018);
             //BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             //PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Cliente conectado al servidor.");
            int opcion;

            do {
            	//Metemos el socket dentro del "do" para que se cree un nuevo socket cada vez que elijamos una opci�n del men�
            	Socket socket = new Socket("localhost", 2018);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("Men�:");
                System.out.println("1. Consultar pel�cula por ID");
                System.out.println("2. Consultar pel�cula por t�tulo");
                System.out.println("3. Consultar pel�cula por director");
                System.out.println("4. A�adir pel�cula");
                System.out.println("5. Salir de la aplicaci�n");
                System.out.print("\nSeleccione una opci�n: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva l�nea

                switch (opcion) {
                    case 1:
                        System.out.print("\nIngrese el ID de la pel�cula: ");
                        int id = scanner.nextInt();
                        writer.println(opcion);
                        writer.println(id);
                        List<Pelicula> peliculasPorID = ClienteHandler.leerPeliculas(reader);
                        ClienteHandler.mostrarPeliculas(peliculasPorID);
                        break;
                    case 2:
                        System.out.print("\nIngrese el t�tulo de la pel�cula: ");
                        String titulo = scanner.nextLine();
                        writer.println(opcion);
                        writer.println(titulo);
                        List<Pelicula> peliculasPorTitulo = ClienteHandler.leerPeliculas(reader);
                        ClienteHandler.mostrarPeliculas(peliculasPorTitulo);
                        break;
                    case 3:
                        System.out.print("\nIngrese el director de la pel�cula: ");
                        String director = scanner.nextLine();
                        writer.println(opcion);
                        writer.println(director);
                        List<Pelicula> peliculasPorDirector = ClienteHandler.leerPeliculas(reader);
                        ClienteHandler.mostrarPeliculas(peliculasPorDirector);
                        break;
                    case 4:
                        System.out.print("\nIngrese el ID de la pel�cula: ");
                        int idNueva = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese el t�tulo de la pel�cula: ");
                        String tituloNueva = scanner.nextLine();
                        System.out.print("Ingrese el director de la pel�cula: ");
                        String directorNueva = scanner.nextLine();
                        System.out.print("Ingrese el precio de la pel�cula: ");
                        double precioNueva = scanner.nextDouble();
                        writer.println(opcion);
                        writer.println(idNueva);
                        writer.println(tituloNueva);
                        writer.println(directorNueva);
                        writer.println(precioNueva);
                        System.out.println("Pel�cula a�adida exitosamente.");
                        break;
                    case 5:
                        System.out.println("Saliendo de la aplicaci�n.");
                        break;
                    default:
                        System.out.println("Opci�n no v�lida. Int�ntelo de nuevo.");
                        break;
                }

            } while (opcion != 5);
        } catch (IOException e) {
        	e.printStackTrace();
        }

        }
    }



