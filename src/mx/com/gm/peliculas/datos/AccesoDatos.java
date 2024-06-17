package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

/**
 * Contiene la operaciones a ejecutar en el archivo de peliculas.txt
 */
public interface AccesoDatos {

    /**
     * Returna true si el archivo ya existe, en caso contrario retornara false
     * Recibe el nombre de un archivo en tipo cadena 'String'. La implementacion
     * debe asegurarse de la conversion a una ruta de archivo.
     */
    public boolean existe(String nombreArchivo);
    
    /**
     * Devuelve una lista de objetos pelicula, la implementacion debe asegurarse
     * de que el archivo existe y contiene datos para listar.
     */
    public List<Pelicula> listar(String nombreArchivo);
    
    /**
     * Recibe un objeto pelicula y el archivo en donde se guardo, si se va a
     * escribir por primera vez el valor de anexo tiene que ser false. Si se va
     * a añadir informacion al archivo anexo debe ser true.
     */
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);
    
    /**
     * Recibe el nombre del archivo en donde se encuentra la pelicula, y tambien
     * recibira el nombre de la pelicula.
     * Devolvera el nombre de la pelicula en tipo de dato cadena.
     */
    public String buscar(String nombreArchivo, String nombrePelicula);
    
    /**
     * Crea un archivo
     */
    public void crear(String nombreArchivo);
    
    /**
     * Elimina un archivo
     */
    public void borrar(String nombreArchivo);
}
