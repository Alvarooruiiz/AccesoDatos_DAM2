package Actividad_5_4_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduzca el nombre del archivo");
        String nombreArchivo = sc.next();
        System.out.println("Introduzca el texto a buscar");
        String texto = sc.next();
        boolean existe = false;

        if (verificarExistenciaArchivo(nombreArchivo)){
            try(BufferedReader in = new BufferedReader(new FileReader(nombreArchivo))){
                String linea;
                int numLinea=1;

                while ((linea = in.readLine()) != null){
                    if(linea.contains(texto)){
                        System.out.println("Linea: " + numLinea + ": " + linea);
                    }
                    numLinea++;
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());;
            }
        }else System.out.println("El archivo no existe");


    }

    public static boolean verificarExistenciaArchivo(String nombreArchivo) {
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            archivo.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
