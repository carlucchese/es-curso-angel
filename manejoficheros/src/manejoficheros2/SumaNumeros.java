/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoficheros2;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Utilizando la clase Scanner 
public class SumaNumeros {
    public void sumaNumerosTeclado()
    { ArrayList lista = new ArrayList();
        Scanner reader = new Scanner(System.in);
        int numero = 0;
        System.out.println("Introduce números. El cero para salir");
    do {
        try {
             numero = reader.nextInt();
             
             lista.add(numero);
       }    catch (Exception ex){
         System.out.println("¡Cuidado! Solo puedes insertar números. ");
        reader.next();
  }
} while (numero!=0);
    
    if(!lista.isEmpty())
    {int suma=0;
         for (int i=0; i< lista.size(); ++i)
         {
            suma+= (int) lista.get(i);      
         }
    
    
     System.out.println("La suma de numeros es " + suma);
    
    }
    
}
}