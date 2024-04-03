import java.io.*;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main  implements Serializable{
    public static void main(String[] args) {
        ListaJugadores lista = new ListaJugadores();
        int opcion;

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\Alvaro\\IdeaProjects\\eje1_alvaro_ruizEnriquez\\jugadores.obj"))){
            lista=(ListaJugadores) in.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        do{
            opcion=menu();
            switch (opcion){
                case 1->{

                    String nombre= EntradaTeclado.pedirCadena("Introduzca el nombre del jugador: ");
                    String apodo= EntradaTeclado.pedirCadena("Introduzca el apodo del jugador: ");
                    String posicion= EntradaTeclado.pedirCadena("Introduzca la posicion del jugador: ");
                    int dorsal= EntradaTeclado.pedirEntero("Introduzca el dorsal del jugador: ");
                    String descripcion= EntradaTeclado.pedirCadena("Introduzca la descripcion del jugador: ");

                    Jugador j = new Jugador(nombre,apodo,posicion,dorsal,descripcion);
                    lista.addJugador(j);
                }
                case 2->{
                    lista.mostrarLista();
                }
                case 3->{
                    lista.buscarJugador();
                }
            }
        }while(opcion!=0);


        try(ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("C:\\Users\\Alvaro\\IdeaProjects\\eje1_alvaro_ruizEnriquez\\jugadores.obj")))){
            out.writeObject(lista);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int menu() {

        int opcion = 0;

        do {
            System.out.println(" -- MENU --");
            System.out.println("1. Añadir jugador");
            System.out.println("2. Mostrar lista de jugadores");
            System.out.println("3. Buscar jugador por nombre, apodo y dorsal");
            System.out.println("0. Salir");
            opcion = EntradaTeclado.pedirEntero("Introduzca una opcion: ");
        } while ((opcion < 0) || (opcion > 3));

        return opcion;
    }
}