/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoficheros2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//LECTURA DE FICHEROS
//Lectura de unfichero usando FileReader
public class Lectura {
    public void leerfichero1(String archivo)
    {int i;
    FileReader fichero = null;
    try {
        fichero = new FileReader(archivo);
        
        while ((i=fichero.read()) != -1)
                   System.out.print((char) i);
       

}   catch (FileNotFoundException e) {
     System.out.println("Se ha producido un error. El fichero no se encuentra");
      e.printStackTrace();
}catch (IOException ex)
{
    System.out.println(ex.getMessage());
}
    }
    
    
     //LECTURA DE UN FICHERO USANDO LA CLASE BufferedReader    

public void leerFichero2(String archivo)
{//Leer un fichero usando las clase
 File file = new File(archivo);
//Creamos el buffer
 BufferedReader reader;
 try {
//Envolvemos el archivo dentro de un file reader
reader = new BufferedReader(new FileReader(file));
String datos;
//Imprimimos los datos por consola
while ((datos = reader.readLine()) != null)
System.out.println(datos);
} catch (FileNotFoundException e) {
System.out.println("Se ha producido un error");
e.printStackTrace();
}catch(Exception ex)
{
 System.out.println(ex.getMessage());


}

}



}
            
            
    

