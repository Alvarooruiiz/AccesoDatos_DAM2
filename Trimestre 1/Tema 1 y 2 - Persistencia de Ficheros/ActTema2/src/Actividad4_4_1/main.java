package Actividad4_4_1;

import java.io.*;

public class main {
    public static void main(String[] args) {
        try {
            String nombreArchivoEntrada = "C:\\Users\\alvar\\OneDrive\\Documentos\\entrada.txt"; // Reemplaza con el nombre de tu archivo de entrada
            String nombreArchivoSalida = "C:\\Users\\alvar\\OneDrive\\Documentos\\datos.txt"; // Reemplaza con el nombre del archivo de salida

            BufferedReader in = new BufferedReader(new FileReader(nombreArchivoEntrada));
            BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivoSalida));

            char[] bloque = new char[128];
            int caracteresLeidos;

            while ((caracteresLeidos = in.read(bloque)) != -1) {
                out.write(bloque, 0, caracteresLeidos);
            }

            in.close();
            out.close();

            System.out.println("El archivo se ha dividido en bloques de 128 bytes y guardado en '" + nombreArchivoSalida + "'.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }
    }
}
