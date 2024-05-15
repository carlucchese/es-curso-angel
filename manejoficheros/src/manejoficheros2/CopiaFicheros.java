/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoficheros2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiaFicheros {
    
  
   public  void CopiaFicheros(){
      // Copiar ficheros
      File origen = new File("C:\\Users\\dioni\\OneDrive\\Documentos\\ACCESODATOS\\presencial\\modelo de ficheros\\archivo.txt");
      File destino =new File("C:\\Users\\dioni\\OneDrive\\Documentos\\ACCESODATOS\\presencial\\modelo de ficheros\\destino.txt");
      try {
         InputStream in = new FileInputStream(origen);
         OutputStream out = new FileOutputStream(destino);
         byte[] buf = new byte[1024];
         int len;
         while ((len = in.read(buf)) > 0) {
             System.out.println("copiamos");
             out.write(buf, 0, len);
        }
        in.close();
        out.close();
        System.out.println("el fichero se ha copiado con exito");
     } catch (IOException ioe) {
       ioe.printStackTrace();
     }
   }
}

    
    
    
    
    
    
    
   
            
            
            
