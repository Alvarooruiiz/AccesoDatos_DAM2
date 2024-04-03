package Actividad_5_4_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

public class main {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){

            System.out.print("Ingrese el nombre del archivo: ");
            String nombreArchivo = in.readLine();


            boolean archivoExiste = verificarExistenciaArchivo(nombreArchivo);

            // Preguntar al usuario si desea sobrescribir o agregar contenido
            char opcion;
            if (archivoExiste) {
                System.out.print("El archivo ya existe. ¿Desea sobrescribirlo (S) o agregar contenido (A)? ");
                opcion = in.readLine().toUpperCase().charAt(0);
            } else {
                opcion = 'S'; // Si el archivo no existe, se creará uno nuevo
            }

            if (opcion == 'S') {
                // Sobrescribir el archivo o crear uno nuevo
                BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));
                int numeroLinea = 1;

                while (true) {
                    System.out.print("Ingrese una oración (o 'fin' para terminar): ");
                    String oracion = in.readLine();
                    if (oracion.equalsIgnoreCase("fin")) {
                        break;
                    }
                    out.write(numeroLinea + ": " + oracion);
                    out.newLine();
                    numeroLinea++;
                }
                out.close();
                System.out.println("Contenido guardado en el archivo.");
            } else if (opcion == 'A') {
                // Agregar contenido al archivo existente
                BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo, true));
                BufferedReader archivoLectura = new BufferedReader(new FileReader(nombreArchivo));
                String linea;
                int numeroLinea = 1;

                while ((linea = archivoLectura.readLine()) != null) {
                    numeroLinea++;
                }

                while (true) {
                    System.out.print("Ingrese una oración (o 'fin' para terminar): ");
                    String oracion = in.readLine();
                    if (oracion.equalsIgnoreCase("fin")) {
                        break;
                    }
                    out.write(numeroLinea + ": " + oracion);
                    out.newLine();
                    numeroLinea++;
                }
                archivoLectura.close();
                out.close();
                System.out.println("Contenido agregado al archivo.");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean verificarExistenciaArchivo(String nombreArchivo) {
        try {
            BufferedReader archivoLectura = new BufferedReader(new FileReader(nombreArchivo));
            archivoLectura.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}