package org.acdat.vista;

import org.acdat.negocio.Cliente;

import java.sql.SQLException;
import java.util.Scanner;

public class VistaCliente {

    private Cliente cliente;

    public VistaCliente() {
        this.cliente = new Cliente();
    }

    public void crudCliente() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de CRUD de Clientes");
            System.out.println("1. Mostrar Clientes");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
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

    private void mostrarClientes() {
        try {
            System.out.println("Listado de Clientes:");
            System.out.println(cliente.mostrarClientes());
        } catch (SQLException e) {
            System.out.println("Error al mostrar los Clientes: " + e.getMessage());
        }
    }

    private void agregarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el correo del Cliente: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el teléfono del Cliente: ");
        String telefono = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(0, nombre, correo, telefono);

        try {
            if (nuevoCliente.agregarCliente()) {
                System.out.println("Cliente agregado correctamente.");
            } else {
                System.out.println("Error al agregar el Cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar el Cliente: " + e.getMessage());
        }
    }

    private void actualizarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Cliente que desea actualizar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(idCliente);

        try {
            if (clienteExistente.cargarCliente()) {
                System.out.print("Ingrese el nuevo nombre del Cliente: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el nuevo correo del Cliente: ");
                String correo = scanner.nextLine();
                System.out.print("Ingrese el nuevo teléfono del Cliente: ");
                String telefono = scanner.nextLine();

                Cliente clienteActualizado = new Cliente(idCliente, nombre, correo, telefono);

                if (clienteActualizado.actualizarCliente()) {
                    System.out.println("Cliente actualizado correctamente.");
                } else {
                    System.out.println("Error al actualizar el Cliente.");
                }
            } else {
                System.out.println("No se encontró el Cliente con ID: " + idCliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Cliente: " + e.getMessage());
        }
    }

    private void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Cliente que desea eliminar: ");
        int idCliente = scanner.nextInt();

        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(idCliente);

        try {
            if (clienteExistente.cargarCliente()) {
                if (clienteExistente.eliminarCliente()) {
                    System.out.println("Cliente eliminado correctamente.");
                } else {
                    System.out.println("Error al eliminar el Cliente.");
                }
            } else {
                System.out.println("No se encontró el Cliente con ID: " + idCliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Cliente: " + e.getMessage());
        }
    }
}
