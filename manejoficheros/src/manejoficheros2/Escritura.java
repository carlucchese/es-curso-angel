/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoficheros2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {
  
 public void escribir(String nombreArchivo, Alumno alumno) {
 System.out.println("Escribiendo información en el archivo");
 try {
 FileWriter fw = new FileWriter(nombreArchivo);
     try (BufferedWriter archivoEscritura = new BufferedWriter(fw)) {
         String almacenar = alumno.toString();
         archivoEscritura.write(almacenar);
         archivoEscritura.write("\n");
         archivoEscritura.write(almacenar);
         archivoEscritura.flush();
     }
 System.out.println("el archivo se ha creado");
 } catch (IOException e) 
   {
       e.getMessage();
   }catch (Exception e)
   {
   
    e.getMessage();
   }
     
 }
}
  