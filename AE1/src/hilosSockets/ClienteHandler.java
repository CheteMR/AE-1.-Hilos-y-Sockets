package hilosSockets;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClienteHandler implements Runnable {
    private Socket clientSocket;
    private Servidor servidor;

    public ClienteHandler(Socket clientSocket, Servidor servidor) {
        this.clientSocket = clientSocket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
              int opcion = Integer.parseInt(reader.readLine());

            switch (opcion) {
                case 1:
                    int id = Integer.parseInt(reader.readLine());
                    List<Pelicula> peliculasPorID = servidor.consultarPeliculaPorID(id);
                    enviarPeliculas(writer, peliculasPorID);
                    break;
                case 2:
                    String titulo = reader.readLine();
                    List<Pelicula> peliculasPorTitulo = servidor.consultarPeliculaPorTitulo(titulo);
                    enviarPeliculas(writer, peliculasPorTitulo);
                    break;
                case 3:
                    String director = reader.readLine();
                    List<Pelicula> peliculasPorDirector = servidor.consultarPeliculaPorDirector(director);
                    enviarPeliculas(writer, peliculasPorDirector);
                    break;
                case 4:
                    int idNueva = Integer.parseInt(reader.readLine());
                    String tituloNueva = reader.readLine();
                    String directorNueva = reader.readLine();
                    double precioNueva = Double.parseDouble(reader.readLine());
                    Pelicula nuevaPelicula = new Pelicula(idNueva, tituloNueva, directorNueva, precioNueva);
                    servidor.agregarPelicula(nuevaPelicula);
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarPeliculas(PrintWriter writer, List<Pelicula> peliculas) {
        writer.println(peliculas.size());
        for (Pelicula pelicula : peliculas) {
            writer.println(pelicula.getId());
            writer.println(pelicula.getTitulo());
            writer.println(pelicula.getDirector());
            writer.println(pelicula.getPrecio());
        }
    }

    public static List<Pelicula> leerPeliculas(BufferedReader reader) throws IOException {
        int numPeliculas = Integer.parseInt(reader.readLine());
    	//String numPeliculas = Integer.parseInt(reader.readLine())
        List<Pelicula> peliculas = new ArrayList<>();
       

        for (int i = 0; i < numPeliculas; i++) {
            int id = Integer.parseInt(reader.readLine());
           String titulo = reader.readLine();
            String director = reader.readLine();
           double precio = Double.parseDouble(reader.readLine());
          peliculas.add(new Pelicula(id, titulo, director, precio));
            
        }

        return peliculas;
    }

    public static void mostrarPeliculas(List<Pelicula> peliculas) {
        if (peliculas.isEmpty()) {
            System.out.println("No se encontraron pel�culas.");
        } else {
            System.out.println("Peliculas encontradas:");
            for (Pelicula pelicula : peliculas) {
                System.out.println("ID: " + pelicula.getId());
                System.out.println("T�tulo: " + pelicula.getTitulo());
                System.out.println("Director: " + pelicula.getDirector());
                System.out.println("Precio: " + pelicula.getPrecio());
                System.out.println("---------------------------");
            }
        }
    }
}

