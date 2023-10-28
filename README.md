# AE-1.-Hilos-y-Sockets
En este repositorio puedes consultar películas por Id, título, director y añadir películas. Esta elaborado con Hilos y Sockets

Como se aprecia en el primer pantallazo, todo fluye correctamente. Se selecciona la opción 1, para consultar película por ID, se ingresa el ID = 1 y nos devuelve la película sin problema con su ID, título, Director y precio.  

[![1.png](https://i.postimg.cc/1zGyvYy4/1.png)](https://postimg.cc/gw09JsXP)

Lo que no sabía era que los objetos Socket, BufferedReader y PrintWriter iban a dar una excepción (SocketException): Se ha anulado una conexión establecida por el software en su equipo host. Este error se produce la segunda vez que quiero consultar película por título por ejemplo. 

[![2.png](https://i.postimg.cc/CMPSr8pC/2.png)](https://postimg.cc/w3mC77v3)

La solución: Meter el objeto Socket, el Reader y el Write dentro del “do While” para que haga el bucle correctamente, y esté creando un nuevo Socket cada vez que se elija una opción del menú.

[![3.png](https://i.postimg.cc/k4wqm66m/3.png)](https://postimg.cc/gXwfy0HS)

En el siguiente pantallazo se ve como la segunda interacción no da error. Al tener los objetos fuera del “Do While” no se creaban nuevos sockets en bucle y no dejaba hacer la consulta una y otra vez.

[![4.png](https://i.postimg.cc/7hW45Fnt/4.png)](https://postimg.cc/tnWwfmfF)

# Resumen de la actividad: 

Se crea la clase “Película” que define las cuatro variables que se piden en la actividad 
el Id, el título, el director y el precio. Son variables privadas se hace el constructor de 
Película y a continuación se crean los getter. 

Se crea la clase “Servidor”, elaboró un  ArrayList añadiendo 10 películas con su Id, Título,  
director y precio. Dentro de esta clase hago los métodos consultarPeliculaPorID, por título, 
por director y agregarPelicula. Estos van a ser los métodos que busquen en el ArrayList y 
devuelvan una película que coincida con el ID que se ha metido, por ejemplo. 

Hay que comentar que el métODO agregarPelicula le he puesto synchronized para evitar 
concurrencia si varios hilos intentan agregar películas paralelamente.

Por otro lado, en el main se crea un objeto Servidor con el puerto 2018, aquí hago un bucle 
infinito While(true) para conectar con el cliente y creo un hilo para atender al cliente.

En la clase Cliente es donde he tenido el problema solucionandolo de tal forma que los 
objetos new Socket, BufferedReader y PrintWriter estuviesen dentro del “do while”
Se hace un switch para manejar cada opción del menú. 

Por último, la clase ClienteHandler que es el que se comunica con el cliente y el servidor
implementando la instancia Runnable




