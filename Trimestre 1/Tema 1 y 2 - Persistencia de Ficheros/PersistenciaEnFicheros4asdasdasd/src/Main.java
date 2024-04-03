import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.helpers.DefaultHandler;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public class miGestorDeContactosXML extends DefaultHandler {
        protected String contenido; 
    }
    public static void main(String[] args) {
        try{
            File archivoXML = new File("scratch.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);

            // Opcional: Si el archivo XML contiene elementos raíz, obtén el elemento raíz.
            doc.getDocumentElement().normalize();

            // Obtén la lista de nodos 'contacto'
            NodeList listaContactos = doc.getElementsByTagName("contacto");

            for (int i = 0; i < listaContactos.getLength(); i++) {
                Element contacto = (Element) listaContactos.item(i);
                String nombre = contacto.getSimpleName("nombre").item(0).getTextContent();
                String apellidos = contacto.getSimpleName("apellidos").item(0).getTextContent();
                String telefono = contacto.getSimpleName("telefono").item(0).getTextContent();

                System.out.println("Nombre: " + nombre);
                System.out.println("Apellidos: " + apellidos);
                System.out.println("Teléfono: " + telefono);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}