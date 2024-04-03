import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        File file = new File("C:\\Users\\alvar\\IdeaProjects\\LibreriaConSAX\\src\\Versiones.xml");
        VersionesHandler handler = new VersionesHandler();

        saxParser.parse(file,handler);

        ArrayList<Version> versiones = handler.getVeriones();
        for(Version v : versiones){
            System.out.println(v);
        }
    }
}