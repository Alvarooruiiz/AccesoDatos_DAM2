import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


@XmlRootElement
public class ListaJugadores {

    private ArrayList<Jugador> jugadores;

    public ListaJugadores() {
        jugadores= new ArrayList<>();
    }
    @XmlElementWrapper(name = "jugadores")
    @XmlElement(name = "jugador")
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
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



    public void cargarListaJugadores(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);

        // Comprueba si el archivo existe
        if (archivo.exists()) {
            BufferedReader in = new BufferedReader(new FileReader(nombreArchivo));
            String line;
            while ((line = in.readLine()) != null) {
                // Se separa el Sttring en un array teniendo como referencia para separar el ";"
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
        }
    }


    public void guardarListaJugadores(ListaJugadores jugadores, String nombreArchivo) {
        try {
            File file = new File(nombreArchivo);

            // Si el archivo no existe, se crea
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(ListaJugadores.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // Configuración para dar formato al XML
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Almacenar la lista de jugadores en el archivo XML
            jaxbMarshaller.marshal(jugadores, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ListaJugadores{" +
                "jugadores=" + jugadores +
                '}';
    }
}
