/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jaxbmaven;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class Jaxbmaven {

    public static void main(String[] args)  {
      // Jaxb_uso.marshall();     
      // Jaxb_uso.unmarshall();
    //  PruebaEmpresa.crearEmpleados("src/empresa.xml");
      System.out.println("LEEMOS EL FICHERO XML EMPRESA Y LO PASAMOS A UN OBEJTO");
      PruebaEmpresa.LeerEmpleados("src/empresa.xml");
        
    }
    }
    

