/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoficheros2;

import java.io.File;
import java.io.FilenameFilter;


public class Filtrar implements FilenameFilter {
    
    String extension;
   // Constructor
   public Filtrar(String extension)
    {
           this.extension = extension;
    }
    @Override
   public boolean accept(File dir, String name)
   {
       if(!this.extension.isBlank() && !this.extension.isEmpty())
       {
       
          return name.endsWith(this.extension);
       }
       return false;
   }


    
    
    
    
    
}
