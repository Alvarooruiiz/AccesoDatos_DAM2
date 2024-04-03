import java.io.*;
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
        if(jugadores.isEmpty()){
            System.out.println("No hay jugadores aun");
        }else{
            for(Jugador j:jugadores){
                System.out.println(j);
            }
        }
    }

    public void buscarJugador() {
        System.out.print("Introduzca el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca el apodo: ");
        String apodo = sc.nextLine();
        System.out.print("Introduzca el dorsal: ");
        Integer dorsal = sc2.nextInt();
        boolean encontrado = false;

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApodo().equalsIgnoreCase(apodo) && jugador.getDorsal()==dorsal){
                System.out.println("Jugador encontrado:");
                System.out.println(jugador);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron jugadores con el nombre, apodo y dorsal introducido");
        }
    }

    public void cargarListaJugadores(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(nombreArchivo))) {

                String line;
                while ((line = in.readLine()) != null) {
                    String[] array = line.split(";");
                    if (array.length == 5) {
                        Jugador jugador = new Jugador();
                        jugador.setNombre(array[0]);
                        jugador.setApodo(array[1]);
                        jugador.setPuesto(array[2]);
                        jugador.setDorsal(Integer.parseInt(array[3]));
                        jugador.setDescripcion(array[4]);

                        jugadores.add(jugador);
                    }
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void guardarListaJugadores(String nombreArchivo) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Jugador jugador : jugadores) {
                String line =jugador.getNombre() + ";" + jugador.getApodo() + ";" +
                        jugador.getPuesto() + ";" + jugador.getDorsal() + ";"  + jugador.getDescripcion();
                out.write(line);
                out.newLine();
            }
        }
    }

    @Override
    public String toString() {
        return "ListaJugadores{" +
                "jugadores=" + jugadores +
                '}';
    }
}
