package Actividad_4_4_3;

import java.io.FileInputStream;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String archivo = "C:\\Users\\alvar\\OneDrive\\Documentos\\imagen.bmp"; // Reemplaza con la ruta de tu archivo BMP

        try {
            EncabezadoBMP encabezado = leerEncabezadoBMP(archivo);
            if (encabezado != null) {
                System.out.println("Tamaño del archivo: " + encabezado.tamano + " bytes");
                System.out.println("Ancho de la imagen: " + encabezado.ancho + " píxeles");
                System.out.println("Alto de la imagen: " + encabezado.alto + " píxeles");
                System.out.println("Imagen comprimida: " + encabezado.comprimida);
            } else {
                System.out.println("No se pudo leer el encabezado del archivo BMP.");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static EncabezadoBMP leerEncabezadoBMP(String archivo) throws IOException {
        try (FileInputStream fis = new FileInputStream(archivo)) {
            byte[] encabezadoBytes = new byte[54];
            fis.read(encabezadoBytes);

            // Extraer la información del encabezado BMP
            int tamano = bytesToInt(encabezadoBytes, 2, 4);
            int ancho = bytesToInt(encabezadoBytes, 18, 4);
            int alto = bytesToInt(encabezadoBytes, 22, 4);
            boolean comprimida = bytesToInt(encabezadoBytes, 30, 4) != 0;

            return new EncabezadoBMP(tamano, ancho, alto, comprimida);
        }
    }

    public static int bytesToInt(byte[] bytes, int offset, int length) {
        int result = 0;
        for (int i = 0; i < length; i++) {
            result |= (bytes[offset + i] & 0xFF) << (i * 8);
        }
        return result;
    }

}

