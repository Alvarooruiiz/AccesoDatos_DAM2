import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class Main implements Serializable{
    private static final String nombreArchivoCarga = "C:\\Users\\alvar\\IdeaProjects\\eje1_alvaro_ruizEnriquez\\jugadores.txt";
//    private static final String nombreArchivoCarga = "C:\\Users\\alvar\\IdeaProjects\\eje2_alvaro_ruizEnriquez\\jugadores.txt";
    private static final String nombreArchivoGuardado = "C:\\Users\\alvar\\IdeaProjects\\eje2_alvaro_ruizEnriquez\\jugadores.xml";

    public static void main(String[] args) throws IOException {
        ListaJugadores lista = new ListaJugadores();

        // Carga el txt creado en el ejercicio 1 por lo que la ruta que coge es la del propio ejercicio 1
        //   si se quiere comprobar sin utilizar dicho archivo, hay uno creado dentro del propio proyecto
        //   llamado jugadores.txt
        lista.cargarListaJugadores(nombreArchivoCarga);

//        lista.mostrarLista();

        // Guarda en xml
        lista.guardarListaJugadores(lista,nombreArchivoGuardado);
    }




}