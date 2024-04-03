import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class MainLectura {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Libreria.class);

        //Objeto que permite leer el XML
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Libreria libreria = (Libreria) unmarshaller.unmarshal(new File("C:\\Users\\alvar\\IdeaProjects\\Libreria\\src\\Libreria.xml"));

        System.out.println(libreria.getNombre());
        ArrayList<Libro> libros = libreria.getLibros();

        for (Libro l: libros) {
            System.out.println(l);
        }
    }
}
