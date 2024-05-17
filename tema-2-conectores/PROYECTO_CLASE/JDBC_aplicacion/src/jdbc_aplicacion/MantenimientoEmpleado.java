
package jdbc_aplicacion;

import java.sql.Connection;
import java.util.ArrayList;
import jdbc_aplicacion.clases.Empleado;
import jdbc_aplicacion.clases.Pub;

public class MantenimientoEmpleado {
   public static void insertarEmpleado(Connection conn, Empleado e) 
   {  
    
   }
  
   public static void modificarEmpleado(Connection conn, Empleado e) 
   {
       
       
   }
   
   public static void borrarEmpleado(Connection con, Empleado e)  
   {
   
   }
   
   public static Empleado obtenerEmpleado(Connection con, String dni) 
   {
   
     return null;
   
   }
   
   public static ArrayList<Pub> obtenerPubsTrabajo(Connection con, Empleado e)
   { ArrayList<Pub>lista=null;
    return lista;
    
   
   }
   
   
    public static ArrayList<Empleado>ListarEmpleados()
    { ArrayList<Empleado> lista=null;
      return lista;
    
    
    
    }

}