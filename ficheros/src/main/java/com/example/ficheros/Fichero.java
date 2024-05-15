import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//
import java.io.File; // input output

public class LeerXML {
    public static void main(String[] args) {
        try {
            File archivoXML = new File("datos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            doc.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            NodeList listaPersonas = doc.getElementsByTagName("persona");
            System.out.println("Número de personas: " + listaPersonas.getLength());

            for (int temp = 0; temp < listaPersonas.getLength(); temp++) {
                Node nodo = listaPersonas.item(temp);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    System.out.println("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Apellido: " + elemento.getElementsByTagName("apellido").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}