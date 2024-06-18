package mx.com.gm.peliculas.negocio;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos = new AccesoDatosImpl();

    public CatalogoPeliculasImpl() {}

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = preguntarAnexacion();
        datos.escribir(pelicula, nombreArchivo, anexar);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        List<Pelicula> peliculas = datos.listar(nombreArchivo);
        mostrarPeliculas(peliculas);
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        System.out.println(datos.buscar(nombreArchivo, buscar));

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        datos.crear(nombreArchivo);
    }

    
    private void mostrarPeliculas(List<Pelicula> peliculas) {
        ListIterator itrPeliculas = peliculas.listIterator();
        System.out.println("Peliculas:");
        while (itrPeliculas.hasNext()) {
            System.out.println(itrPeliculas.next());
        }
        System.out.println("");
    }
    
    private boolean preguntarAnexacion() throws InputMismatchException {
        Scanner entrada = new Scanner(System.in);
        boolean anexar = false;
        int opcion = 0;
        
        do {
            System.out.println("");
            System.out.println("¿Anexar?:");
            System.out.println("1. Si.");
            System.out.println("2. No.");
            
            System.out.print("Elije una opcion: ");
            try {
                opcion = entrada.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("");
                System.out.println("Valor no admitido.");
                System.out.println("Opcion automatica: 2.");
                break;
            }
        
            if (opcion == 1) {
                anexar = true;
                break;
            } else if (opcion == 2){
                break;
            } else if (opcion <= 0 || opcion > 2) {
                System.out.println("");
                System.out.println("Opcion no valida.");
                System.out.println("Intentelo de nuevamente.");
            }
        } while (opcion <= 0 || opcion > 2);
        
        return anexar;
    }
}
