package org.acdat.vista;

import org.acdat.negocio.Vuelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VistaVuelo {

    private Vuelo vuelo;

    public VistaVuelo() {
        this.vuelo = new Vuelo();
    }

    public void crudVuelo() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de CRUD de Vuelos");
            System.out.println("1. Mostrar Vuelos");
            System.out.println("2. Agregar Vuelo");
            System.out.println("3. Actualizar Vuelo");
            System.out.println("4. Eliminar Vuelo");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarVuelos();
                    break;
                case 2:
                    agregarVuelo();
                    break;
                case 3:
                    actualizarVuelo();
                    break;
                case 4:
                    eliminarVuelo();
                    break;
                case 0:
                    System.out.println("Saliendo del menú.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }

    private void mostrarVuelos() {
        try {
            System.out.println("Listado de Vuelos:");
            System.out.println(vuelo.mostrarVuelos());
        } catch (SQLException e) {
            System.out.println("Error al mostrar los Vuelos: " + e.getMessage());
        }
    }

    private void agregarVuelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el origen del Vuelo: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese el destino del Vuelo: ");
        String destino = scanner.nextLine();
        System.out.print("Ingrese la fecha de salida del Vuelo (YYYY-MM-DD): ");
        String fechaSalidaStr = scanner.nextLine();
        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr, DateTimeFormatter.ISO_DATE);
        System.out.print("Ingrese la fecha de llegada del Vuelo (YYYY-MM-DD): ");
        String fechaLlegadaStr = scanner.nextLine();
        LocalDate fechaLlegada = LocalDate.parse(fechaLlegadaStr, DateTimeFormatter.ISO_DATE);
        System.out.print("Ingrese el costo del Vuelo: ");
        double costo = scanner.nextDouble();

        Vuelo nuevoVuelo = new Vuelo(0, origen, destino, fechaSalida, fechaLlegada, costo);

        try {
            if (nuevoVuelo.agregarVuelo()) {
                System.out.println("Vuelo agregado correctamente.");
            } else {
                System.out.println("Error al agregar el Vuelo.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar el Vuelo: " + e.getMessage());
        }
    }

    private void actualizarVuelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Vuelo que desea actualizar: ");
        int idVuelo = scanner.nextInt();
        scanner.nextLine();

        Vuelo vueloExistente = new Vuelo();
        vueloExistente.setId(idVuelo);

        try {
            if (vueloExistente.cargarVuelo()) {
                System.out.print("Ingrese el nuevo origen del Vuelo: ");
                String origen = scanner.nextLine();
                System.out.print("Ingrese el nuevo destino del Vuelo: ");
                String destino = scanner.nextLine();
                System.out.print("Ingrese la nueva fecha de salida del Vuelo (YYYY-MM-DD): ");
                String fechaSalidaStr = scanner.nextLine();
                LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr, DateTimeFormatter.ISO_DATE);
                System.out.print("Ingrese la nueva fecha de llegada del Vuelo (YYYY-MM-DD): ");
                String fechaLlegadaStr = scanner.nextLine();
                LocalDate fechaLlegada = LocalDate.parse(fechaLlegadaStr, DateTimeFormatter.ISO_DATE);
                System.out.print("Ingrese el nuevo costo del Vuelo: ");
                double costo = scanner.nextDouble();

                Vuelo vueloActualizado = new Vuelo(idVuelo, origen, destino, fechaSalida, fechaLlegada, costo);

                if (vueloActualizado.actualizarVuelo()) {
                    System.out.println("Vuelo actualizado correctamente.");
                } else {
                    System.out.println("Error al actualizar el Vuelo.");
                }
            } else {
                System.out.println("No se encontró el Vuelo con ID: " + idVuelo);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Vuelo: " + e.getMessage());
        }
    }

    private void eliminarVuelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Vuelo que desea eliminar: ");
        int idVuelo = scanner.nextInt();

        Vuelo vueloExistente = new Vuelo();
        vueloExistente.setId(idVuelo);

        try {
            if (vueloExistente.cargarVuelo()) {
                if (vueloExistente.eliminarVuelo()) {
                    System.out.println("Vuelo eliminado correctamente.");
                } else {
                    System.out.println("Error al eliminar el Vuelo.");
                }
            } else {
                System.out.println("No se encontró el Vuelo con ID: " + idVuelo);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Vuelo: " + e.getMessage());
        }
    }
}
