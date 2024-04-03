package org.acdat.vista;

import org.acdat.negocio.Destino;

import java.sql.SQLException;
import java.util.Scanner;

public class VistaDestino {

    private Destino destino;

    public VistaDestino() {
        this.destino = new Destino();
    }

    public void crudDestino() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de CRUD de Destinos");
            System.out.println("1. Mostrar Destinos");
            System.out.println("2. Agregar Destino");
            System.out.println("3. Actualizar Destino");
            System.out.println("4. Eliminar Destino");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarDestinos();
                    break;
                case 2:
                    agregarDestino();
                    break;
                case 3:
                    actualizarDestino();
                    break;
                case 4:
                    eliminarDestino();
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

    private void mostrarDestinos() {
        try {
            System.out.println("Listado de Destinos:");
            System.out.println(destino.mostrarDestinos());
        } catch (SQLException e) {
            System.out.println("Error al mostrar los Destinos: " + e.getMessage());
        }
    }

    private void agregarDestino() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Destino: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del Destino: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el costo del Destino: ");
        double costo = scanner.nextDouble();

        Destino nuevoDestino = new Destino(0, nombre, descripcion, costo);

        try {
            if (nuevoDestino.agregarDestino()) {
                System.out.println("Destino agregado correctamente.");
            } else {
                System.out.println("Error al agregar el Destino.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar el Destino: " + e.getMessage());
        }
    }

    private void actualizarDestino() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Destino que desea actualizar: ");
        int idDestino = scanner.nextInt();
        scanner.nextLine();

        Destino destinoExistente = new Destino();
        destinoExistente.setId(idDestino);

        try {
            if (destinoExistente.cargarDestino()) {
                System.out.print("Ingrese el nuevo nombre del Destino: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la nueva descripción del Destino: ");
                String descripcion = scanner.nextLine();
                System.out.print("Ingrese el nuevo costo del Destino: ");
                double costo = scanner.nextDouble();

                Destino destinoActualizado = new Destino(idDestino, nombre, descripcion, costo);

                if (destinoActualizado.actualizarDestino()) {
                    System.out.println("Destino actualizado correctamente.");
                } else {
                    System.out.println("Error al actualizar el Destino.");
                }
            } else {
                System.out.println("No se encontró el Destino con ID: " + idDestino);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Destino: " + e.getMessage());
        }
    }

    private void eliminarDestino() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Destino que desea eliminar: ");
        int idDestino = scanner.nextInt();

        Destino destinoExistente = new Destino();
        destinoExistente.setId(idDestino);

        try {
            if (destinoExistente.cargarDestino()) {
                if (destinoExistente.eliminarDestino()) {
                    System.out.println("Destino eliminado correctamente.");
                } else {
                    System.out.println("Error al eliminar el Destino.");
                }
            } else {
                System.out.println("No se encontró el Destino con ID: " + idDestino);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Destino: " + e.getMessage());
        }
    }
}
