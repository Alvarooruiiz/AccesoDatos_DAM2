import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public class miGestorDeContactosXML extends DefaultHandler {
        protected String contenido; 
    }
    public static void main(String[] args) {
        try{
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse("contactos.xml", new MiGestorContactosXML());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}