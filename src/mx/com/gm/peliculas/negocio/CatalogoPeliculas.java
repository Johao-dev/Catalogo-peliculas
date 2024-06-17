package mx.com.gm.peliculas.negocio;

/**
 * Contiene las operaciones necesarias de la aplicacion CatalogoPeliculas
 */
public interface CatalogoPeliculas {
    
    /**
     * Recibe como argumento dos cadenas, la priemra contendra el nombre de la
     * pelicula a agregar y la segunda sera el archivo correspondiente en donde
     * se agregara.
     */
    public void agregarPelicula(String nombrePelicula, String nombreArchivo);
    
    /**
     * LIstara todas las peliculas agregadas en el archivo que recibira como
     * parametro.
     */
    public void listarPeliculas(String nombreArchivo);

    /**
     * Buscara el nombre de la pelicula en el archivo correspondiente.
     */
    public void buscarPelicula(String nombreArchivo, String buscar);
    
    /**
     * Iniciara el archivo en SO.
     */
    public void iniciarArchivo(String nombreArchivo);
}
