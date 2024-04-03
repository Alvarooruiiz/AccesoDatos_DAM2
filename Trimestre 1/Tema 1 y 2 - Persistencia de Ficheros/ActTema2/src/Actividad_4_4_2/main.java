package Actividad_4_4_2;

import java.io.FileInputStream;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        //Ruta de la imagen
        String archivo = "C:\\Users\\alvar\\OneDrive\\Documentos\\imagen.jpg";

        String formato = detectarFormatoImagen(archivo);
        System.out.println("El formato de la imagen es: " + formato);
    }

    public static String detectarFormatoImagen(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo)) {
            byte[] primerosBytes = new byte[8];
            fis.read(primerosBytes);

            String primerosBytesHex = bytesToHex(primerosBytes);

            // Define los encabezados hexadecimales de los formatos de imagen conocidos
            String[] encabezados = {
                    "424D",     // BMP
                    "47494638", // GIF
                    "00000100",  // ICO
                    "FFD8FF",  // JPEG
                    "89504E47", // PNG
                    // Agrega otros formatos de imagen según sea necesario
            };

            // Compara los primeros bytes con los encabezados conocidos
            for (int i = 0; i < encabezados.length; i++) {
                if (primerosBytesHex.startsWith(encabezados[i])) {
                    return obtenerNombreFormato(i);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return "Formato de archivo no reconocido";
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    public static String obtenerNombreFormato(int indice) {
        String[] nombresFormatos = {
                "BMP",
                "GIF",
                "ICO",
                "JPEG",
                "PNG",
        };
        return nombresFormatos[indice];
    }
}