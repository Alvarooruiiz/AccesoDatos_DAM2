import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable{

    public static Scanner sc = new Scanner(System.in);

    public static int menu() {

        int opcion = 0;

        do {
            System.out.println(" -- MENU --");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar lista de contactos");
            System.out.println("3. Buscar contacto por nombre completo");
            System.out.println("0. Salir");
            opcion = EntradaTeclado.pedirEntero("Introduzca una opcion: ");
        } while ((opcion < 0) || (opcion > 3));

        return opcion;
    }


    public static void main(String[] args) {
        ArrayList<Contacto> lista= new ArrayList<>();
        int opcion;

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("contactos.obj"))){
            lista = (ArrayList<Contacto>) in.readObject();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        do{
            opcion=menu();
            switch (opcion){
                case 1->{
                    System.out.println("Introduzca el nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introduzca el apellido");
                    String apellido = sc.nextLine();
                    System.out.println("Introduzca el correo electrénico");
                    String correo = sc.nextLine();
                    System.out.println("Introduzca el numero de teléfono");
                    String numero = sc.nextLine();
                    System.out.println("Introduzca la descripción");
                    String descripcion = sc.nextLine();
                    Contacto a = new Contacto(nombre,apellido,correo,numero,descripcion);
                    lista.add(a);
                }
                case 2->{
                    System.out.println(lista);
                }
                case 3->{
                    buscarContacto(lista);
                }
            }
        }while(opcion!=0);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contactos.obj"))){
            out.writeObject(lista);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
    public static void buscarContacto(ArrayList<Contacto> l) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Buscar por nombre o telefono: ");
        String busqueda = sc.nextLine();
        boolean encontrado = false;

        for (Contacto contacto : l) {
            if (contacto.nombreCompleto().toLowerCase().contains(busqueda.toLowerCase())|| contacto.getNumeroTelef().contains(busqueda)) {
                System.out.println("Contacto encontrado:");
                System.out.println(contacto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron contactos con el nombre o teléfono especificado.");
        }
    }

}