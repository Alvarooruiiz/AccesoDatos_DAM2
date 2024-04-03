import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MiGestorDeContactosXML extends DefaultHandler {

    private String nombre;
    private String apellidos;
    private String movil;
    private String trabajo;
    private String casa;

    private boolean isContacto = false;
    private boolean isNumero = false;

    public void startElement(String uri, String nombreLocal, String qName, Attributes atributos) throws SAXException {
        if (qName.equals("contacto")) {
            isContacto = true;
            nombre = "";
            apellidos = "";
            movil = "";
            trabajo = "";
            casa = "";
        } else if (qName.equals("movil") || qName.equals("trabajo") || qName.equals("casa")) {
            isNumero = true;
        }
    }

    public void characters(char ch[], int inicio, int longitud) throws SAXException {
        if (isContacto) {
            String contenido = new String(ch, inicio, longitud).trim();
            if (!contenido.isEmpty()) {
                if (nombre.isEmpty()) {
                    nombre = contenido;
                } else if (apellidos.isEmpty()) {
                    apellidos = contenido;
                } else if (isNumero) {
                    if (movil.isEmpty() && isNumero) {
                        movil = contenido;
                    } else if (trabajo.isEmpty() && isNumero) {
                        trabajo = contenido;
                    } else if (casa.isEmpty() && isNumero) {
                        casa = contenido;
                    }
                }
            }
        }
    }

    public void endElement(String uri, String nombreLocal, String qName) throws SAXException {
        if (qName.equals("contacto") && isContacto) {
            System.out.println("Nombre y Apellidos: " + nombre + " " + apellidos);
            System.out.print("Números de Teléfono: ");
            if (!movil.isEmpty()) {
                System.out.print("Móvil: " + movil + " ");
            }
            if (!trabajo.isEmpty()) {
                System.out.print("Trabajo: " + trabajo + " ");
            }
            if (!casa.isEmpty()) {
                System.out.print("Casa: " + casa);
            }
            System.out.println();
            isContacto = false;
        } else if (qName.equals("movil") || qName.equals("trabajo") || qName.equals("casa")) {
            isNumero = false;
        }
    }

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse("contactos.xml", new MiGestorDeContactosXML());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}