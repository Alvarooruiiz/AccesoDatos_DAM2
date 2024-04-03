import java.io.*;
import java.util.ArrayList;


public class Main  implements Serializable{
    private static String nombreArchivo = "C:\\Users\\alvar\\IdeaProjects\\eje1_alvaro_ruizEnriquez\\jugadores.txt";

    public static void main(String[] args) throws IOException {
        ListaJugadores lista = new ListaJugadores();
        int opcion;

        lista.cargarListaJugadores(nombreArchivo);
        do{
            opcion=menu();
            switch (opcion){
                case 1:{

                    String nombre= EntradaTeclado.pedirCadena("Introduzca el nombre del jugador: ");
                    String apodo= EntradaTeclado.pedirCadena("Introduzca el apodo del jugador: ");
                    String posicion= EntradaTeclado.pedirCadena("Introduzca la posicion del jugador: ");
                    Integer dorsal= EntradaTeclado.pedirEntero("Introduzca el dorsal del jugador: ");
                    String descripcion= EntradaTeclado.pedirCadena("Introduzca la descripcion del jugador: ");

                    Jugador j = new Jugador(nombre,apodo,posicion,dorsal,descripcion);
                    lista.addJugador(j);
                    break;
                }
                case 2:{
                    lista.mostrarLista();
                    break;
                }
                case 3:{
                    lista.buscarJugador();
                    break;
                }
            }
        }while(opcion!=0);


        lista.guardarListaJugadores(nombreArchivo);
    }

    public static int menu() {

        int opcion;

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