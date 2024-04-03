package org.acdat;

import org.acdat.vista.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menú Principal");
            System.out.println("1. Vista Vuelo");
            System.out.println("2. Vista Cliente");
            System.out.println("3. Vista Agencia");
            System.out.println("4. Vista Destino");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    VistaVuelo vistaVuelo = new VistaVuelo();
                    vistaVuelo.crudVuelo();
                    break;
                case 2:
                    VistaCliente vistaCliente = new VistaCliente();
                    vistaCliente.crudCliente();
                    break;
                case 3:
                    VistaAgencia vistaAgencia = new VistaAgencia();
                    vistaAgencia.crudAgencia();
                    break;
                case 4:
                    VistaDestino vistaDestino = new VistaDestino();
                    vistaDestino.crudDestino();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }
}
