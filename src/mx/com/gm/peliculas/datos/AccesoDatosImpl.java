package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

public class AccesoDatosImpl implements AccesoDatos {
    
    public AccesoDatosImpl() {}

    @Override
    public boolean existe(String nombreArchivo) {
       boolean existe = false;
       
       Path archivo = Paths.get(nombreArchivo);
       
       if (Files.exists(archivo))
           existe = true;
       
       return existe;
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) {
        boolean existe = existe(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        
        if (existe) {
            Path archivo = Paths.get(nombreArchivo);
            try {
                if (Files.size(archivo) == 0)
                    System.out.println("El archivo esta vacio.");
                else {
                    BufferedReader br = Files.newBufferedReader(archivo);
                    String linea = br.readLine();
                    while (linea != null) {
                        peliculas.add(new Pelicula(linea));
                        linea = br.readLine();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println("El archivo no existe.");
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        boolean existe = existe(nombreArchivo);
        
        if (existe) {
            Path archivo = Paths.get(nombreArchivo);
            
            if (anexar == false) {
                try (BufferedWriter br = Files.newBufferedWriter(archivo,
                        Charset.defaultCharset(), StandardOpenOption.WRITE)){
                    br.write(pelicula.getNombre());
                    System.out.println("Pelicula agregada exitosamente.");
                    br.newLine();
                    
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            } else {
                try (BufferedWriter br = Files.newBufferedWriter(archivo,
                        Charset.defaultCharset(), StandardOpenOption.APPEND)){
                    br.write(pelicula.getNombre());
                    System.out.println("Pelicula anexada exitosamente.");
                    br.newLine();
                    
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String nombrePelicula) {
        boolean existe = existe(nombreArchivo);
        String peliculaBuscada = "";
        
        if (existe) {
            Path archivo = Paths.get(nombreArchivo);
            
            try {
                BufferedReader br = Files.newBufferedReader(archivo);
                
                String pelicula = br.readLine();
                
                while (pelicula != null) {
                    if (!pelicula.equals(nombrePelicula))
                        peliculaBuscada = "No se encontro la pelicula " + nombrePelicula;
                    else if (pelicula.equals(nombrePelicula))
                        peliculaBuscada = "Se encontro la pelicula " + nombrePelicula;
                    
                    pelicula = br.readLine();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println("El archivo no existe.");
        }
        return peliculaBuscada;
    }

    @Override
    public void crear(String nombreArchivo) {
        boolean existe = existe(nombreArchivo);
        
        if (existe) 
            System.out.println("El archivo ya existe.");
        else {
            Path archivo = Paths.get(nombreArchivo);
            try {
                Files.createFile(archivo);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            System.out.println("Se ha creado el archivo exitosamente.");
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        boolean existe = existe(nombreArchivo);
        
        if (existe) {
            Path archivo = Paths.get(nombreArchivo);
            try {
                Files.delete(archivo);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            System.out.println("Se ha eliminado el archivo exitosamente.");
        } else 
            System.out.println("El archivo no existe.");
    }
}
