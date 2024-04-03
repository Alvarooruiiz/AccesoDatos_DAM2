import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaJugadores implements Serializable {
    public static Scanner sc = new Scanner(System.in);
    public static Scanner sc2 = new Scanner(System.in);
    private ArrayList<Jugador> jugadores;

    public ListaJugadores() {
        jugadores= new ArrayList<>();
    }

    public void addJugador(Jugador j){

        jugadores.add(j);
    }

    public void mostrarLista(){
        for(Jugador j:jugadores){
            System.out.println(j);
        }
    }

    public void buscarJugador() {
        System.out.print("Introduzca el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca el apodo: ");
        String apodo = sc.nextLine();
        System.out.print("Introduzca el dorsal: ");
        int dorsal = sc2.nextInt();
        boolean encontrado = false;

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().toLowerCase().contains(nombre.toLowerCase()) && jugador.getApodo().contains(apodo.toLowerCase()) && jugador.getDorsal()==dorsal) {
                System.out.println("Contacto encontrado:");
                System.out.println(jugador);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron contactos con el nombre o teléfono especificado.");
        }
    }

    @Override
    public String toString() {
        return "ListaJugadores{" +
                "jugadores=" + jugadores +
                '}';
    }
}
