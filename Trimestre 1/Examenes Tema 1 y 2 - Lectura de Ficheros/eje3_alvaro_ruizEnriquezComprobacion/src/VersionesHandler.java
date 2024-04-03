import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class VersionesHandler extends DefaultHandler {
    private ArrayList<Videojuego>listaVideojuegos;
    private Videojuego videojuego;
    private StringBuilder buffer= new StringBuilder();
    public VersionesHandler() {
        super();
        listaVideojuegos = new ArrayList<>();
    }

    public ArrayList<Videojuego> getListaVideojuegos() {
        return listaVideojuegos;
    }

    public void setListaVideojuegos(ArrayList<Videojuego> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case "list":
                break;
            case "item":
                videojuego = new Videojuego();
                listaVideojuegos.add(videojuego);
                break;
            case "Titulo":
                buffer.delete(0,buffer.length());
                break;
            case "Semilla":
                buffer.delete(0, buffer.length());
                break;
            case "Estado":
                buffer.delete(0, buffer.length());
                break;
            case "Tipo_de_recolección":
                buffer.delete(0, buffer.length());
                break;
            case "Frecuencia_":
                buffer.delete(0, buffer.length());
                break;
            case "Profundidad":
                buffer.delete(0, buffer.length());
                break;
            case "Tamaño":
                buffer.delete(0, buffer.length());
                break;
            case "Palabras_clave":
                buffer.delete(0, buffer.length());
                break;
            case "Materia":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "Titulo":
                videojuego.setTitulo(buffer.toString());
                break;
            case "Semilla":
                videojuego.setSemilla(buffer.toString());
                break;
            case "Estado":
                videojuego.setEstado(buffer.toString());
                break;
            case "Tipo_de_recolección":
                videojuego.setTipoRecoleccion(buffer.toString());
                break;
            case "Frecuencia_":
                videojuego.setFrecuencia(buffer.toString());
                break;
            case "Profundidad":
                videojuego.setProfundidad(buffer.toString());
                break;
            case "Tamaño":
                videojuego.setTamanio(buffer.toString());
                break;
            case "Palabras_clave":
                videojuego.setPalabrasClave(buffer.toString());
                break;
            case "Materia":
                videojuego.setMateria(buffer.toString());
                break;
            case "item":
                break;
            case "list":
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start,length);
    }


}
