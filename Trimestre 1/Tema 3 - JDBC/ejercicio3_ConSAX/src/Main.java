import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        File file = new File("C:\\Users\\alvar\\IdeaProjects\\ejercicio3_ConSAX\\videojuegos.xml");
        VersionesHandler handler = new VersionesHandler();

        saxParser.parse(file,handler);

        ArrayList<Videojuego> lista = handler.getListaVideojuegos();
        for(Videojuego v : lista){
            if (v.getEstado().equals("Activa")) {
                System.out.println("Titulo: " + v.getTitulo() + ", Semilla: " + v.getSemilla()
                        + ", Palabras clave: " + v.getPalabrasClave());
            }
        }


    }
}