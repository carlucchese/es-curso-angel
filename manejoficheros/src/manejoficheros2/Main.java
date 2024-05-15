/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manejoficheros2;

import java.io.File;

public class Main {

    public static void main(String[] args) {
            String archivo="c:\\Users\\dioni\\OneDrive\\Documentos\\ACCESODATOS\\presencial\\modelo de ficheros\\archivo.dat";
    //new listaarchivos().setVisible(true);
  /*  Alumno a = new Alumno();
    a.nombre="Arancha";
    a.apellido="Rincón";
    a.edad=49;

    Escritura esc= new Escritura();
    esc.escribir("c:\\Users\\dioni\\OneDrive\\Documentos\\ACCESODATOS\\presencial\\modelo de ficheros\\archivo.txt",a);
    //Vamos a leer un fichero
    System.out.println("vamos a leer el fichero");
    Lectura l = new Lectura();
    l.leerFichero2("c:\\Users\\dioni\\OneDrive\\Documentos\\ACCESODATOS\\presencial\\modelo de ficheros\\archivo.txt");
   */
  
  /*try {
     // Obtendremos el listado de los archivos de ese directorio
     File fichero=new File("C:\\Users\\dioni\\OneDrive\\Documentos\\ACCESODATOS");
     String[] listadeArchivos = fichero.list();
      // Filtraremos por los de extension .txt
      //listadeArchivos = fichero.list(new Filtrar(".pdf"));
      listadeArchivos = fichero.list();
      // Comprobamos el número de archivos en el listado
      int numarchivos = listadeArchivos.length ;
      // Si no hay ninguno lo avisamos por consola
      if (numarchivos < 1)
          System.out.println("No hay archivos que listar");
          // Y si hay, escribimos su nombre por consola.
          else
       {
              for(int conta = 0; conta < listadeArchivos.length; conta++)
              System.out.println(listadeArchivos[conta]);
     }
}
catch (Exception ex) {
System.out.println("Error al buscar en la ruta indicada"); }

 /*CopiaFicheros c = new CopiaFicheros();
 c.CopiaFicheros();*/
 // SumaNumeros s = new SumaNumeros();
//  s.sumaNumerosTeclado();
 
 /* Lectura l = new Lectura();
  l.leerfichero1(archivo);*/
 /*RandomEjemplo r= new RandomEjemplo();
 try{
 r.ejemploaleatorio(archivo);
 }catch(Exception e)
 {
  System.out.println(e.getMessage());
 
 }
 
 r.mostrarFichero(archivo);
    }*/
  /*  Random r = new Random();
    r.escribirRandomFichero(archivo);*/

  Random rd = new Random();
  rd.archivo=archivo;
  rd.escribirRandomFichero();
   
  
  
 
  
}
    
    
    
}