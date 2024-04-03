package org.example;

import org.example.DAO.AutorDAO;
import org.example.Negocio.Autor;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        crudAutores();
    }

    public static void mostrarMenu() {
        System.out.println("Menú de CRUD de Autores");
        System.out.println("1. Buscar Autores");
        System.out.println("2. Buscar Autores por Id");
        System.out.println("3. Gurardar Autores");
        System.out.println("4. Borrar Autor");
        System.out.println("5. Actualizar Autor");
        System.out.println("0. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }

    public static void crudAutores() {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);


        AutorDAO autorDAO = new AutorDAO();

        while(true){
            mostrarMenu();
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println(autorDAO.buscarAutores());
                    break;
                case 2:
                    System.out.println("Introduzca un id a buscar");
                    int id= sc.nextInt();
                    System.out.println(autorDAO.buscarAutorPorId(id));
                    break;
                case 3:
                    System.out.println("Introduzca el nombre del autor a guardar");
                    String nombre= sc2.nextLine();
                    System.out.println("Introduzca el pais del autor a guardar");
                    String pais = sc2.nextLine();
                    autorDAO.guardarAutor(nombre,pais);
                    System.out.println("Autor guardado");
                    break;
                case 4:
                    System.out.println("Introduzca el id del autor a eliminar");
                    int idDelete = sc.nextInt();
                    autorDAO.borrarAutor(idDelete);
                    System.out.println("Autor eliminado");
                    break;
                case 5:
                    System.out.println("Introduzca el id del autor a actualizar");
                    int idUpdate = sc.nextInt();
                    System.out.println("Introduzca el nombre del autor a actualizar");
                    String nombreUpdate= sc2.nextLine();
                    System.out.println("Introduzca el pais del autor a actualizar");
                    String paisUpdate = sc2.nextLine();
                    Autor autorActualizar = autorDAO.buscarAutorPorId(idUpdate);
                    if (autorActualizar != null) {
                        autorActualizar.setNombre(nombreUpdate);
                        autorActualizar.setPais(paisUpdate);
                        autorDAO.actualizarAutor(autorActualizar);
                        System.out.println("Autor actualizado correctamente.");
                    } else {
                        System.out.println("No se pudo encontrar el autor para actualizar.");
                    }

                case 0:
                    System.out.println("¡Se ha salido del programa!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
        }


    }


}
