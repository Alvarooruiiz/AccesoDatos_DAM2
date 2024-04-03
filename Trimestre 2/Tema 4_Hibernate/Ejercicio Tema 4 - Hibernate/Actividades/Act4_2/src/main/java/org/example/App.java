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
            System.out.println("Menú:");
            System.out.println("1. Mostrar lista de empleados");
            System.out.println("2. Mostrar lista de departamentos");
            System.out.println("3. Insertar empleado");
            System.out.println("4. Insertar departamento");
            System.out.println("5. Actualizar empleado");
            System.out.println("6. Actualizar departamento");
            System.out.println("7. Eliminar empleado");
            System.out.println("8. Eliminar departamento");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarEmpleados();
                    break;
                case 2:
                    mostrarDepartamentos();
                    break;
                case 3:
                    insertarEmpleado();
                    break;
                case 4:
                    insertarDepartamento();
                    break;
                case 5:
                    actualizarEmpleado();
                    break;
                case 6:
                    actualizarDepartamento();
                    break;
                case 7:
                    eliminarEmpleado();
                    break;
                case 8:
                    eliminarDepartamento();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarEmpleados() {
        List<EmpleadosEntity> empleados = EmpleadoDAO.obtenerEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de empleados:");
            for (EmpleadosEntity empleado : empleados) {
                System.out.printf("ID: %d, Nombre: %s, Puesto: %s, Departamento: %d%n",
                        empleado.getEmpno(), empleado.getNombre(), empleado.getPuesto(), empleado.getDepartamento().getDepno());
            }
        }
    }

    private static void mostrarDepartamentos() {
        List<DepartamentosEntity> departamentos = DepartamentoDAO.obtenerDepartamentos();
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            System.out.println("Lista de departamentos:");
            for (DepartamentosEntity departamento : departamentos) {
                System.out.printf("ID: %d, Nombre: %s, Ubicación: %s%n",
                        departamento.getDepno(), departamento.getNombre(), departamento.getUbicacion());
            }
        }
    }

    private static void insertarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el puesto del empleado: ");
        String puesto = scanner.nextLine();
        System.out.print("Ingrese el ID del departamento al que pertenece: ");
        int depno = scanner.nextInt();
        scanner.nextLine();

        EmpleadosEntity nuevoEmpleado = new EmpleadosEntity();
        nuevoEmpleado.setNombre(nombre);
        nuevoEmpleado.setPuesto(puesto);

        DepartamentosEntity departamento = new DepartamentosEntity();
        departamento.setDepno(depno);
        nuevoEmpleado.setDepartamento(departamento);

        EmpleadoDAO.insertarEmpleado(nuevoEmpleado);
        System.out.println("Empleado insertado correctamente.");
    }

    private static void insertarDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del departamento: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la ubicación del departamento: ");
        String ubicacion = scanner.nextLine();

        DepartamentosEntity nuevoDepartamento = new DepartamentosEntity();
        nuevoDepartamento.setNombre(nombre);
        nuevoDepartamento.setUbicacion(ubicacion);

        DepartamentoDAO.insertarDepartamento(nuevoDepartamento);
        System.out.println("Departamento insertado correctamente.");
    }

    private static void actualizarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        EmpleadosEntity empleado = EmpleadoDAO.obtenerEmpleadoPorId(id);
        if (empleado != null) {
            System.out.print("Ingrese el nuevo nombre del empleado: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo puesto del empleado: ");
            String puesto = scanner.nextLine();
            System.out.print("Ingrese el nuevo ID del departamento al que pertenece: ");
            int depno = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            empleado.setNombre(nombre);
            empleado.setPuesto(puesto);

            DepartamentosEntity departamento = new DepartamentosEntity();
            departamento.setDepno(depno);
            empleado.setDepartamento(departamento);

            EmpleadoDAO.actualizarEmpleado(empleado);
            System.out.println("Empleado actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún empleado con ese ID.");
        }
    }

    private static void actualizarDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del departamento a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        DepartamentosEntity departamento = DepartamentoDAO.obtenerDepartamentoPorId(id);
        if (departamento != null) {
            System.out.print("Ingrese el nuevo nombre del departamento: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva ubicación del departamento: ");
            String ubicacion = scanner.nextLine();

            departamento.setNombre(nombre);
            departamento.setUbicacion(ubicacion);

            DepartamentoDAO.actualizarDepartamento(departamento);
            System.out.println("Departamento actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún departamento con ese ID.");
        }
    }

    private static void eliminarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        EmpleadosEntity empleado = EmpleadoDAO.obtenerEmpleadoPorId(id);
        if (empleado != null) {
            System.out.println("Empleado a eliminar:");
            System.out.printf("ID: %d, Nombre: %s, Puesto: %s, Departamento: %d%n",
                    empleado.getEmpno(), empleado.getNombre(), empleado.getPuesto(), empleado.getDepartamento().getDepno());
            System.out.print("¿Está seguro de que desea eliminar este empleado? (S/N): ");
            String confirmacion = scanner.nextLine().trim().toUpperCase();

            if (confirmacion.equals("S")) {
                EmpleadoDAO.eliminarEmpleado(empleado);
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("Operación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún empleado con ese ID.");
        }
    }

    private static void eliminarDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del departamento a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        DepartamentosEntity departamento = DepartamentoDAO.obtenerDepartamentoPorId(id);
        if (departamento != null) {
            System.out.println("Departamento a eliminar:");
            System.out.printf("ID: %d, Nombre: %s, Ubicación: %s%n",
                    departamento.getDepno(), departamento.getNombre(), departamento.getUbicacion());
            System.out.print("¿Está seguro de que desea eliminar este departamento? (S/N): ");
            String confirmacion = scanner.nextLine().trim().toUpperCase();

            if (confirmacion.equals("S")) {
                DepartamentoDAO.eliminarDepartamento(departamento);
                System.out.println("Departamento eliminado correctamente.");
            } else {
                System.out.println("Operación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún departamento con ese ID.");
        }
    }
}
