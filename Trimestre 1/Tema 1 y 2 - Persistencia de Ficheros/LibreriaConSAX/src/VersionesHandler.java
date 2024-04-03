
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class VersionesHandler extends DefaultHandler {

    private ArrayList<Version> veriones = new ArrayList<Version>();
    private Version version;
    private StringBuilder buffer= new StringBuilder();
    public VersionesHandler() {
        super();
    }

    public ArrayList<Version> getVeriones() {
        return veriones;
    }

    public void setVeriones(ArrayList<Version> veriones) {
        this.veriones = veriones;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case "versiones":
                break;
            case "version":
                version = new Version();
                veriones.add(version);
                version.setNumero(Double.parseDouble(attributes.getValue("numero")));
                break;
            case "nombre":
                buffer.delete(0,buffer.length());
                break;
            case "api":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "nombre":
                version.setNombre(buffer.toString());
                break;
            case "api":
                version.setApi(Integer.parseInt(buffer.toString()));
                break;
            case "version":
                break;
            case "versiones":
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start,length);
    }


}
