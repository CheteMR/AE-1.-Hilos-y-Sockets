package hilosSockets;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private List<Pelicula> peliculas;

    public Servidor() {
    	peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(1, "Scott Pilgrim contra el mundo", "Edgar Wright", 15.0));
        peliculas.add(new Pelicula(2, "Watchmen", "Zach Snyder", 12.0));
        peliculas.add(new Pelicula(3, "Sin City", "Frank Miller", 20.0));
        peliculas.add(new Pelicula(4, "Serenity", "Joss Whedon", 9.56));
        peliculas.add(new Pelicula(5, "Amanecer de los muertos", "Desconocido", 30.98));
        peliculas.add(new Pelicula(6, "El señor de los anillos", "Peter Jackson", 10.0));
        peliculas.add(new Pelicula(7, "Oldboy", "Park Chan-wook", 5.10));
        peliculas.add(new Pelicula(8, "Battle Royale", "Kinji Fukasaku", 50.45));
        peliculas.add(new Pelicula(9, "WARCRAFT: El Origen", "Duncan Jones", 65.0));
        peliculas.add(new Pelicula(10, "Escuadrón suicida", "David Ayer", 35.67));
    }

    public List<Pelicula> consultarPeliculaPorID(int id) {
        List<Pelicula> result = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                result.add(pelicula);
            }
        }
        return result;
    }

    public List<Pelicula> consultarPeliculaPorTitulo(String titulo) {
        List<Pelicula> result = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().equals(titulo)) {
                result.add(pelicula);
            }
        }
        return result;
    }

    public List<Pelicula> consultarPeliculaPorDirector(String director) {
        List<Pelicula> result = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDirector().equals(director)) {
                result.add(pelicula);
            }
        }
        return result;
    }

    public synchronized void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();

        try (ServerSocket serverSocket = new ServerSocket(2018)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");

            while (true) {
              Socket clientSocket = serverSocket.accept();
               System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                // Crea un hilo para atender al cliente
                Thread clientThread = new Thread(new ClienteHandler(clientSocket, servidor));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            
            
        }
    }

}






