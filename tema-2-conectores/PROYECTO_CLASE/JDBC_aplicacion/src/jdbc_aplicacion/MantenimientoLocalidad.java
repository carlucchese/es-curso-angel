
package jdbc_aplicacion;

import jdbc_aplicacion.clases.Localidad;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Statement;

public class MantenimientoLocalidad {
    
    public static void insertarLocalidad(Connection conn, Localidad l) {
        if (conn != null && l!=null) {
            

         }
    
    
    }
      
     public static void modificarLocalidad(Connection conn, Localidad l) 
     { 
        
     }
             
     public Localidad  mostrarNombreLocalidad(Connection con,String cod_localidad)
     {  Localidad l = null;
         return l;
     }
     
     public static ArrayList<Localidad>ObtenerTodasLocalidades(Connection con, Statement stm)
     { ArrayList<Localidad> list_localidad =null;
       //Tienes que pasar como parámetro: GestionBD.conexion y GestionBD.sentenciasql
       //GestionBD.conexion;
       // GestionBD.sentenciasql
       return list_localidad;
     
     
     
     }
     
     
    
    
    
    
    
    
}
