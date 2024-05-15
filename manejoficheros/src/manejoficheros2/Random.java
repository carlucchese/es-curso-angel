/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoficheros2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 ACCESO DIRECTO A FICHEROS
 */
public class Random {
    
    public Scanner sc = new Scanner(System.in);
    public  RandomAccessFile fichero = null;
    public String archivo;

    public void escribirRandomFichero() {
        int numero;
        try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile(this.archivo, "rw");
            mostrarFichero(); //muestra el contenido original del fichero
            System.out.print("Introduce un número entero para añadir al final del fichero: ");                    
            numero = sc.nextInt(); //se lee el entero a añadir en el fichero
            fichero.seek(fichero.length()); //nos situamos al final del fichero
            fichero.writeInt(numero);       //se escribe el entero
            mostrarFichero();//muestra el contenido del fichero después de añadir el número

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public  void mostrarFichero() {
        int n;
        try {
            fichero.seek(0); //nos situamos al principio
            while (true) {
                n = fichero.readInt();  //se lee  un entero del fichero                                           
                System.out.println(n);  //se muestra en pantalla
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
  
    
    
    
    
    
