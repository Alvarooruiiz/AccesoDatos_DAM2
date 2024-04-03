package Actividad_5_4_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Ingrese el nombre del primer archivo ordenado: ");
            String archivo1 = br.readLine();
            System.out.print("Ingrese el nombre del segundo archivo ordenado: ");
            String archivo2 = br.readLine();

            List<String> contenidoArchivo1 = leerArchivo(archivo1);
            List<String> contenidoArchivo2 = leerArchivo(archivo2);

            List<String> contenidoCombinado = combinarYOrdenar(contenidoArchivo1, contenidoArchivo2);

            escribirArchivo("ordenado.txt", contenidoCombinado);

            System.out.println("Archivos ordenados y guardados en 'ordenado.txt'.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



    public static List<String> leerArchivo(String nombreArchivo){
        List<String> contenido = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while((linea = in.readLine()) != null){
                contenido.add(linea);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return contenido;
    }

    public static void escribirArchivo(String nombreArchivo, List<String> contenido){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo))){
            for(String linea : contenido){
                out.write(linea);
                out.newLine();
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public static List<String> combinarYOrdenar(List<String> contenido1, List<String> contenido2) {
        List<String> contenidoCombinado = new ArrayList<>(contenido1);
        contenidoCombinado.addAll(contenido2);
        Collections.sort(contenidoCombinado);
        return contenidoCombinado;
    }

}