package org.example;

import org.example.Dao.DepartamentoDAO;
import org.example.Dao.EmpleadoDAO;
import org.example.Entity.DepartamentosEntity;
import org.example.Entity.EmpleadosEntity;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los empleados");
            System.out.println("2. Mostrar todos los departamentos");
            System.out.println("3. Crear empleado");
            System.out.println("4. Actualizar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Crear departamento");
            System.out.println("7. Actualizar departamento");
            System.out.println("8. Eliminar departamento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    mostrarEmpleados();
                    break;
                case 2:
                    mostrarDepartamentos();
                    break;
                case 3:
                    crearEmpleado();
                    break;
                case 4:
                    actualizarEmpleado();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                case 6:
                    crearDepartamento();
                    break;
                case 7:
                    actualizarDepartamento();
                    break;
                case 8:
                    eliminarDepartamento();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarEmpleados() {
        List<EmpleadosEntity> empleados = EmpleadoDAO.obtenerEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (EmpleadosEntity empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    private static void mostrarDepartamentos() {
        List<DepartamentosEntity> departamentos = DepartamentoDAO.obtenerDepartamentos();
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            for (DepartamentosEntity departamento : departamentos) {
                System.out.println(departamento);
            }
        }
    }

    private static void crearEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del nuevo empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el número de departamento del nuevo empleado: ");
        int depno = scanner.nextInt();
        EmpleadosEntity nuevoEmpleado = new EmpleadosEntity();
        nuevoEmpleado.setNombre(nombre);
        nuevoEmpleado.setDepno(depno);
        EmpleadoDAO.insertarEmpleado(nuevoEmpleado);
        System.out.println("Empleado creado con éxito.");
    }

    private static void actualizarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado que desea actualizar: ");
        int idEmpleado = scanner.nextInt();
        EmpleadosEntity empleado = EmpleadoDAO.obtenerEmpleadoPorId(idEmpleado);
        if (empleado != null) {
            System.out.println("Empleado encontrado:");
            System.out.println(empleado);
            System.out.print("Ingrese el nuevo nombre del empleado: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo número de departamento del empleado: ");
            int nuevoDepno = scanner.nextInt();
            empleado.setNombre(nuevoNombre);
            empleado.setDepno(nuevoDepno);
            EmpleadoDAO.actualizarEmpleado(empleado);
            System.out.println("Empleado actualizado con éxito.");
        } else {
            System.out.println("No se encontró ningún empleado con el ID proporcionado.");
        }
    }

    private static void eliminarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado que desea eliminar: ");
        int idEmpleado = scanner.nextInt();
        EmpleadosEntity empleado = EmpleadoDAO.obtenerEmpleadoPorId(idEmpleado);
        if (empleado != null) {
            System.out.println("Empleado a eliminar:");
            System.out.println(empleado);
            System.out.print("¿Está seguro de que desea eliminar este empleado? (S/N): ");
            String confirmacion = scanner.nextLine().trim().toUpperCase();
            if (confirmacion.equals("S")) {
                EmpleadoDAO.eliminarEmpleado(empleado);
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún empleado con el ID proporcionado.");
        }
    }

    private static void crearDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del nuevo departamento: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la ubicación del nuevo departamento: ");
        String ubicacion = scanner.nextLine();
        DepartamentosEntity nuevoDepartamento = new DepartamentosEntity();
        nuevoDepartamento.setNombre(nombre);
        nuevoDepartamento.setUbicacion(ubicacion);
        DepartamentoDAO.insertarDepartamento(nuevoDepartamento);
        System.out.println("Departamento creado con éxito.");
    }

    private static void actualizarDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del departamento que desea actualizar: ");
        int idDepartamento = scanner.nextInt();
        DepartamentosEntity departamento = DepartamentoDAO.obtenerDepartamentoPorId(idDepartamento);
        if (departamento != null) {
            System.out.println("Departamento encontrado:");
            System.out.println(departamento);
            System.out.print("Ingrese el nuevo nombre del departamento: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese la nueva ubicación del departamento: ");
            String nuevaUbicacion = scanner.nextLine();
            departamento.setNombre(nuevoNombre);
            departamento.setUbicacion(nuevaUbicacion);
            DepartamentoDAO.actualizarDepartamento(departamento);
            System.out.println("Departamento actualizado con éxito.");
        } else {
            System.out.println("No se encontró ningún departamento con el ID proporcionado.");
        }
    }

    private static void eliminarDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del departamento que desea eliminar: ");
        int idDepartamento = scanner.nextInt();
        DepartamentosEntity departamento = DepartamentoDAO.obtenerDepartamentoPorId(idDepartamento);
        if (departamento != null) {
            System.out.println("Departamento a eliminar:");
            System.out.println(departamento);
            System.out.print("¿Está seguro de que desea eliminar este departamento? (S/N): ");
            String confirmacion = scanner.nextLine().trim().toUpperCase();
            if (confirmacion.equals("S")) {
                DepartamentoDAO.eliminarDepartamento(departamento);
                System.out.println("Departamento eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún departamento con el ID proporcionado.");
        }
    }
}
