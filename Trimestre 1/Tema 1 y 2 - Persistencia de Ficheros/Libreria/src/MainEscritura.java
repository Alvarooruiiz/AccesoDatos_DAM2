import javax.xml.bind.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainEscritura {
    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Libreria.class);

        Marshaller marshaller = context.createMarshaller();

        Libreria l = new Libreria();
        l.setNombre("Mi libreria");

        ArrayList<Libro> libros = new ArrayList<>();
        Libro libro1 = new Libro("Don quijote","Sancho Panza", "123123123");
        Libro libro2 = new Libro("Don cipote","Santaa Panza", "231231");
        libros.add(libro1);
        libros.add(libro2);

        l.setLibros(libros);

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(l, System.out);
        marshaller.marshal(l,new FileWriter("C:\\Users\\alvar\\IdeaProjects\\Libreria\\src\\milibreria2.xml"));
    }
}
