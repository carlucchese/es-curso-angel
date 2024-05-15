
package ficherosxml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author profesor
 */
public class CrearDocumentoXML {
    
    public static void crearDocumentoXML(String archivo) 
    { try{

          // Creo una instancia de DocumentBuilderFactory
     
          // Creo una instancia de DocumentBuilderFactory
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           // Creo un documentBuilder
           DocumentBuilder builder = factory.newDocumentBuilder();
           // Creo un DOMImplementation
           DOMImplementation implementation = builder.getDOMImplementation();
        
           // Creo un documento con un elemento raiz llamado concesionario
            Document documento = implementation.createDocument(null, "concesionario", null);
            documento.setXmlVersion("1.0");
            //Creamos los elementos usamos el método createElement de document.
            //elemento o etiqueta coches
            Element coches = documento.createElement("coches");
            //elemento o etiqueta coche
            Element coche= documento.createElement("coche");
            coche.setAttribute("id", "1");
            //Creamos la etiqueta matricula <matricula>9517gnj </matricula>
            Element matricula = documento.createElement("matricula");
            Text textMatricula = documento.createTextNode("9517gnj");
            matricula.appendChild(textMatricula);
           //<concesionario>
              // <coches>
              //     <coche>
              //        <matricula> 9517gnj </matricula>
              //        <marca> AUDI </marca>
              //        <precio>23000</precio>
              //        <color> rojo </color>
              //     </coche>
              //</coches>
              //</concesionario>
             coche.appendChild(matricula);
             //Etiqueta o elmento marca
             //<marca></marca>
              Element marca = documento.createElement("marca");
              Text textmarca = documento.createTextNode("AUDI");
              marca.appendChild(textmarca);
              coche.appendChild(marca);
              //Precio
              Element precio = documento.createElement("precio");
              Text textprecio=documento.createTextNode("23000");
              precio.appendChild(textprecio);
              coche.appendChild(precio);
              Element color = documento.createElement("color");
              Text textcolor = documento.createTextNode("rojo");
              color.appendChild(textcolor);
              coche.appendChild(color);
              coches.appendChild(coche);
              //Finalmente añadimos al documento la etiqueta coches
             documento.getDocumentElement().appendChild(coches);
             //Asocio un source (fuente) al documento
             Source source = new DOMSource(documento);
             Result result = new StreamResult(new File(archivo));
             //la clase transformer -genera el fichero archivo.xml
         
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
       }catch(ParserConfigurationException pce){
            System.out.println(pce.getCause());
     
      }catch(TransformerConfigurationException tce)
      {  System.out.println(tce.getMessage());
    
    
      }catch( TransformerException te)
      {  System.out.println(te.getMessage());

    }
             
            
            
            
        

           

           
 

    
    
    
    }
    
}
