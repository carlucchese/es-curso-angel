/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jaxbmaven;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author dioni
 */
public class Jaxb_uso {
    
    public static void marshall()
    { System.out.println("Hello World!");
           try {
            Libro libro= new Libro("Odisea 2001",400);
            JAXBContext contexto = JAXBContext.newInstance(
                    libro.getClass() );
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
                marshaller.marshal(libro,new File("src/Libro.xml"));
              //   marshaller.marshal(libro,System.out);
        } catch (PropertyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
       
    } 
    public static void unmarshall()
    {
     try {  
            JAXBContext context = JAXBContext.newInstance( Libro.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Libro libro = (Libro)unmarshaller.unmarshal(new File("src/Libro.xml") );
           
            System.out.println(libro.getTitulo());
            System.out.println(libro.getPaginas());
 
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    }
    

