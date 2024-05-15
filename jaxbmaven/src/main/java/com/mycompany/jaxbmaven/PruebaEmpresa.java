/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jaxbmaven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author dioni
 */
public class PruebaEmpresa {
    

 public static void crearEmpleados(String archivo){
     // Primero rellenamos los objetos Java y generamos un XML
 try{
  Writer w = null;
  ArrayList<Empleado> empleados= new ArrayList();
  //creamos dos empleados

  Empleado empleado1 = new Empleado();
  empleado1.setDni("12345678C");
  empleado1.setNombre("Carlos Pérez Ruíz");
  empleado1.setEdad(29);

  Empleado empleado2 = new Empleado();
  empleado2.setDni("87654321C");
  empleado2.setNombre("Claudia Ortiz Zaldo");
  empleado2.setEdad(31);

  Empresa empresa = new Empresa();
  empresa.setCif("A58818501");
  empresa.setNombre("TECNOMUR S.L.");
  empleados.add(empleado1);
  empleados.add(empleado2);
  empresa.setEmpleados(empleados);

  // Creamos el contexto e instanciamos el marshaller
  JAXBContext context = JAXBContext.newInstance(Empresa.class);
  Marshaller m = context.createMarshaller();
  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
  m.marshal(empresa, System.out);

  
  
   w = new FileWriter(archivo);
   m.marshal(empresa, w);
   w.close();
  } catch ( PropertyException exx)
   {  System.out.println("ERROR DE PROPIEDAD");
      System.out.println(exx.getMessage());
   
   }catch(JAXBException ja)
   {System.out.println("ERROR DE JAXB");
     System.out.println(ja.getMessage());
    
     ja.printStackTrace();
   
   
   }catch( IOException ioe)
   {System.out.println("ERROR DE FICHERO");
     System.out.println(ioe.getMessage());
   
   
   }
 
     
 } 
     
 
 public static void LeerEmpleados(String archivo) 
 {// Ahora leemos el XML e instanciamos las clases Java
  System.out.println("Salida desde el fichero XML: ");
  try{
      
      
 
         
      
   JAXBContext context = JAXBContext.newInstance(   Empresa.class );
   Unmarshaller unmarshaller = context.createUnmarshaller();
   Unmarshaller um = context.createUnmarshaller();
   if( um==null)
   { System.out.println("error unmarshaller es nulo");
   
   }
   Empresa empresa2 = (Empresa) um.unmarshal(new FileReader(archivo));
 

  for (int i = 0; i < empresa2.getEmpleados().toArray().length; i++) {
   System.out.println("Empleado " + (i + 1) + ": "
     + empresa2.getEmpleados().get(i).getNombre() + " con DNI "
     + empresa2.getEmpleados().get(i).getDni() + " y "
     + empresa2.getEmpleados().get(i).getEdad() + " años");
  }

 }catch(JAXBException jab)
 { 
   System.out.println("ERROR JABXB");
  // jab.printStackTrace();
 
 
 }catch(FileNotFoundException fne)
 {
    System.out.println("ERROR FILE");
  //fne.printStackTrace();
 
 
 }
}
 

     
}    
 

 
    
    

