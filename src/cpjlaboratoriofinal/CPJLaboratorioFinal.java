package cpjlaboratoriofinal;

import java.util.InputMismatchException;
import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {
    
    private static final Scanner entrada = new Scanner(System.in);
    
    private static void mostrarMenu() {
        System.out.println("Opciones:");
        System.out.println("1. Iniciar catalogo de peliculas.");
        System.out.println("2. Agregar peliculas.");
        System.out.println("3. Listas peliculas.");
        System.out.println("4. Buscar pelicula.");
        System.out.println("0. Salir.");
    }
    
    private static int elegirOpcion() {
        int opcionElegida = -1;
        
        do {
            System.out.print("Ingrese una opcion: ");
            try {
                opcionElegida = entrada.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Valor no admitido.");
                System.out.println("");
                break;
            }
            if (opcionElegida < 0 || opcionElegida > 4) {
                System.out.println("");
                System.out.println("Opcion no valida.");
                System.out.println("Intentelo nuevamente.");
                System.out.println("");
            }
        } while (opcionElegida < 0 || opcionElegida > 4);

        return opcionElegida;
    }

    private static String iniciarCatalogoPeliculas() {
        String nombreArchivo;
        
        do {
            System.out.print("Ingrese el nombre del archivo(añadir extension '.txt'): ");
            nombreArchivo = entrada.nextLine();
            
            if (nombreArchivo.isEmpty()) {
                System.out.println("");
                System.out.println("No se ha ingresado ningun nombre.");
                System.out.println("Intentelo nuevamente.");
                System.out.println("");
            }
            
        } while (nombreArchivo.isEmpty());
        
        return nombreArchivo;
    }
    
    private static String agregarPeliculas() {
        String nombrePelicula;
        
        do {
            System.out.print("Ingrese el nombre de la pelicula: ");
            nombrePelicula = entrada.nextLine();
            
            if (nombrePelicula.isEmpty()) {
                System.out.println("");
                System.out.println("No se ha ingresado ningun nombre.");
                System.out.println("Intentelo nuevamente.");
                System.out.println("");
            }
            
        } while (nombrePelicula.isEmpty());
        
        return nombrePelicula;
    }
    
    private static String buscarPelicula() {
        String peliculaBuscada;
        
        do {
            System.out.print("Ingrese el nombre de la pelicula a buscar: ");
            peliculaBuscada = entrada.nextLine();
            
            if (peliculaBuscada.isEmpty()) {
                System.out.println("");
                System.out.println("No se ha ingresado ningun nombre.");
                System.out.println("Intentelo nuevamente.");
                System.out.println("");
            }
            
        } while (peliculaBuscada.isEmpty());
        
        return peliculaBuscada;
    }
    
    public static void main(String[] args) {
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        String nombreArchivo = null;
        int opcionElegida;
        
        do {
            mostrarMenu();
            opcionElegida = elegirOpcion();
            entrada.nextLine();
            
            switch (opcionElegida) {
                case 1 -> {
                    nombreArchivo = iniciarCatalogoPeliculas();
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                }
                case 2 -> {
                    String nombrePelicula = agregarPeliculas();
                    catalogoPeliculas.agregarPelicula(nombrePelicula, nombreArchivo);
                }
                case 3 -> {
                    catalogoPeliculas.listarPeliculas(nombreArchivo);
                }
                case 4 -> {
                    String peliculaBuscada = buscarPelicula();
                    catalogoPeliculas.buscarPelicula(nombreArchivo, peliculaBuscada);
                }
                case 0 -> {
                    break;
                }
            }
        } while (opcionElegida != 0);
        
    }
}
