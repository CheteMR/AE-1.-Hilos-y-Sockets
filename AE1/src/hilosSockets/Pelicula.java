package hilosSockets;

public class Pelicula { 
	// Declaramos las variables privadas
    private int id;
    private String titulo;
    private String director;
    private double precio;

    public Pelicula(int id, String titulo, String director, double precio) {
    	// Constructor p�blico con cuatro par�metros (id, t�tulo, director y precio)
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.precio = precio;
    }
    
// A continuaci�n se crean los Getter para que nos devuelvan las pel�culas por ID, T�tulo, Director y Precio
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public double getPrecio() {
        return precio;
    }

   
}

