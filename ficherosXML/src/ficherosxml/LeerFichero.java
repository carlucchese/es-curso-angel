/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosxml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author profesor
 */
public class LeerFichero {
    
   public static void leerFicheroXML(String archivo) 
   { File f = new File(archivo);
     if(f.exists())
      {try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(f);
            doc.getDocumentElement().normalize();
            if(doc.getChildNodes().getLength()>0)
            {  NodeList listahijos= doc.getChildNodes();
               for(int i=0; i<listahijos.getLength();++i)
                { Node nodo= listahijos.item(i);
                  mostrarHijos(nodo,0);
                            
                }           
            
            }

            
       }catch( ParserConfigurationException pce)
       {
         System.out.println(pce.getMessage());
       
       }catch( SAXException sax )
       {
           System.out.println(sax.getMessage());
           sax.printStackTrace();
        
       }catch(IOException ioe)
       { System.out.println(ioe.getMessage());
         ioe.printStackTrace();  
       }
    }
 }
   
    public static void mostrarHijos(Node n,int nivel)
    { if (n.getNodeType() == Node.ELEMENT_NODE) 
     {    Element eElement = (Element) n;
          ++nivel;
          //Nombre de la etiqueta
          String name =  eElement.getNodeName();  
          //Valor de la etiqueta
         // String contenido=eElement.getTextContent();         
          for(int z=0; z<nivel; ++z)
          { System.out.print(" ");
            System.out.print(" ");   
          }
       
         NamedNodeMap attributes = n.getAttributes();
         if (attributes.getLength()> 0)
         {   String listatributos="";
             for (int z =0; z<attributes.getLength();++z)
            {   
               Node item = attributes.item(z);
               String nombre= item.getNodeName();
               String valor = item.getNodeValue();
               listatributos += " " + nombre + "=" + valor;
                  
            }
             System.out.println("<" +name + listatributos +  ">");  
       
        } 
       else
          System.out.println("<" +name + ">"); 
         
       
      
       if(n.hasChildNodes())
       {   NodeList hijos2=  n.getChildNodes();
           for (int j=0; j<hijos2.getLength();++j)
           {   
             mostrarHijos(hijos2.item(j),nivel); 
              
           }   
         
       }
         
       for(int z=0; z<nivel; ++z)
       {  System.out.print(" ");
          System.out.print(" "); 
       }
          System.out.println("</" +name + ">"); 

   }
}
    
}


    
    
    
   

       
   
       
       
       
       
       
       
       
      
     
   
   
   
   
   
    

