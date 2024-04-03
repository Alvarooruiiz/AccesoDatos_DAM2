package org.acdat.vista;

import org.acdat.jpa.AgenciaJPAEntity;
import org.acdat.negocio.Agencia;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class VistaAgencia {
    AgenciaJPAEntity agenciaJPA = new AgenciaJPAEntity();


    public void mostrarMenu() {
        System.out.println("Menú de CRUD de Agencias");
        System.out.println("1. Mostrar Agencias");
        System.out.println("2. Agregar Agencia");
        System.out.println("3. Actualizar Agencia");
        System.out.println("4. Eliminar Agencia");
        System.out.println("0. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }

    public void crudagencia() throws SQLException {
        String respuesta = "";

        while (true) {
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(agenciaJPA.mostrarAgencia());
                    break;
                case 2:
                    agregarAgencia();
                    break;
                case 3:
                    this.actualizarAgencia();
                    break;
                case 4:
                    this.eliminarAgenci();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
            System.out.println(respuesta);
        }
    }

    public String mostrarAgencias() throws SQLException {
        List<Agencia> respuesta;
        respuesta = agenciaJPA.mostrarAgencia();
        return respuesta.toString();
    }

    public void agregarAgencia() {
        Scanner scanner = new Scanner(System.in);
        Agencia agencia = new Agencia();

        System.out.print("Ingrese el nombre de la agencia: ");
        agencia.setNombre(scanner.nextLine());
        System.out.print("Ingrese la direccion de la agencia: ");
        agencia.setDireccion(scanner.nextLine());
        System.out.print("Ingrese el teléfono de la agencia: ");
        agencia.setTelefono(scanner.nextLine());

        try {
            if (agencia.agregarAgencia()) {
                System.out.println("agencia agregado correctamente");
            } else {
                System.out.println("Error al crear el agencia");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarAgencia() throws SQLException {
        System.out.println(this.mostrarAgencias());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del agencia que desea actualizar: ");
        int agenciaId = scanner.nextInt();
        scanner.nextLine();
        agenciaJPA.setId(agenciaId);
        if (agenciaJPA.existeAgencia(agenciaId)) {
            if (agenciaJPA.cargarAgencia(agenciaId)) {
                System.out.print("Ingrese el nuevo nombre de la agencia ("+ agenciaJPA.getNombre() +"): ");
                agenciaJPA.setNombre(scanner.nextLine());
                System.out.print("Ingrese la nueva direccion de la agencia("+ agenciaJPA.getDireccion() +"): ");
                agenciaJPA.setDireccion(scanner.nextLine());
                System.out.print("Ingrese el nuevo teléfono de la agencia("+ agenciaJPA.getTelefono() +"): ");
                agenciaJPA.setTelefono(scanner.nextLine());

            try {
                if (agenciaJPA.actualizarAgencia()) {
                        System.out.println("agencia actualizado correctamente");
                    } else {
                        System.out.println("Error al actualizar el agencia");
                    }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El agencia seleccionado " + agenciaId + " no existe");
        }
    }

    public void eliminarAgencia() throws SQLException {

        System.out.println(this.mostrarAgencias());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del agencia que desea actualizar: ");
        int agenciaId = scanner.nextInt();
        scanner.nextLine();
        agenciaJPA.setId(agenciaId);
        if (agenciaJPA.existeAgencia(agenciaId)) {
            try {
                if (agenciaJPA.eliminarAgencia(agenciaId)) {
                    System.out.println("agencia eliminado correctamente");
                } else {
                    System.out.println("Error al eliminar el agencia");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El agencia seleccionado " + agenciaId + " no existe");
        }
    }
}
