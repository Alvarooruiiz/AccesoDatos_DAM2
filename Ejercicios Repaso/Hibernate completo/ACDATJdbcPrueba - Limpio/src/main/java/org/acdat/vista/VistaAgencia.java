package org.acdat.vista;

import org.acdat.negocio.Agencia;

import java.sql.SQLException;
import java.util.Scanner;

public class VistaAgencia {

    private Agencia agencia;

    public VistaAgencia() {
        this.agencia = new Agencia();
    }

    public void crudAgencia() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de CRUD de Agencias");
            System.out.println("1. Mostrar Agencias");
            System.out.println("2. Agregar Agencia");
            System.out.println("3. Actualizar Agencia");
            System.out.println("4. Eliminar Agencia");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarAgencias();
                    break;
                case 2:
                    agregarAgencia();
                    break;
                case 3:
                    actualizarAgencia();
                    break;
                case 4:
                    eliminarAgencia();
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

    private void mostrarAgencias() {
        try {
            System.out.println("Listado de Agencias:");
            System.out.println(agencia.mostrarAgencias());
        } catch (SQLException e) {
            System.out.println("Error al mostrar las Agencias: " + e.getMessage());
        }
    }

    private void agregarAgencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la Agencia: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la dirección de la Agencia: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono de la Agencia: ");
        String telefono = scanner.nextLine();

        Agencia nuevaAgencia = new Agencia(0, nombre, direccion, telefono);

        try {
            if (nuevaAgencia.agregarAgencia()) {
                System.out.println("Agencia agregada correctamente.");
            } else {
                System.out.println("Error al agregar la Agencia.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar la Agencia: " + e.getMessage());
        }
    }

    private void actualizarAgencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la Agencia que desea actualizar: ");
        int idAgencia = scanner.nextInt();
        scanner.nextLine();

        Agencia agenciaExistente = new Agencia();
        agenciaExistente.setId(idAgencia);

        try {
            if (agenciaExistente.cargarAgencia()) {
                System.out.print("Ingrese el nuevo nombre de la Agencia: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la nueva dirección de la Agencia: ");
                String direccion = scanner.nextLine();
                System.out.print("Ingrese el nuevo teléfono de la Agencia: ");
                String telefono = scanner.nextLine();

                Agencia agenciaActualizada = new Agencia(idAgencia, nombre, direccion, telefono);

                if (agenciaActualizada.actualizarAgencia()) {
                    System.out.println("Agencia actualizada correctamente.");
                } else {
                    System.out.println("Error al actualizar la Agencia.");
                }
            } else {
                System.out.println("No se encontró la Agencia con ID: " + idAgencia);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Agencia: " + e.getMessage());
        }
    }

    private void eliminarAgencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la Agencia que desea eliminar: ");
        int idAgencia = scanner.nextInt();

        Agencia agenciaExistente = new Agencia();
        agenciaExistente.setId(idAgencia);

        try {
            if (agenciaExistente.cargarAgencia()) {
                if (agenciaExistente.eliminarAgencia()) {
                    System.out.println("Agencia eliminada correctamente.");
                } else {
                    System.out.println("Error al eliminar la Agencia.");
                }
            } else {
                System.out.println("No se encontró la Agencia con ID: " + idAgencia);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Agencia: " + e.getMessage());
        }
    }
}
