package jdbc_java;

import BD.gestion_basedatos;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_JAVA {

    public static void main(String[] args) {

        System.out.println("CARGAR DRIVER DE LA BASE DE DATOS MYSQL");
        //CARGAR DRIVER DE LA BASE DE DATOS MYSQL
        //Descargar conector en la página: https://dev.mysql.com/downloads/connector/j/
        //Añadir en la librería - add jar/folder
        if (gestion_basedatos.cargarDriverJDBC()) {
            //CONECTAR CON LA BASE DE DATOS
            gestion_basedatos.conectar_basedatos("jdbc:mysql://localhost/test", "root", "");
            if (!(gestion_basedatos.conexion == null)) {  //CREACIÓN DE UNA BASE DE DATOS
                if (gestion_basedatos.crearBaseDeDatos("empresa")) {
                    System.out.println("Se ha creado la base de datos empresa");
                    //CREAMOS LA TABLA EMPLEADO en la base de datos empresa
                    gestion_basedatos.cerrarConexion();
                    gestion_basedatos.conectar_basedatos("jdbc:mysql://localhost/empresa", "root", "");
                    //Crear la tabla empresa

                    String sql = "CREATE TABLE `empleado` ("
                            + "  `dni` varchar(9) NOT NULL,"
                            + "  `nombre` varchar(200) NOT NULL,"
                            + "  `edad` int(11) NOT NULL,\n"
                            + "  `puesto` varchar(100) NOT NULL"
                            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
                    gestion_basedatos.crearTabla(sql);
                    //Insertamos datos en la tabla empleado
                    gestion_basedatos.insertarTablaEmpleado("34125678F", "Pedro Martínez", 56, "Programador");
                    //Realizamos una consulta a la base de datos.
                    ResultSet rs = gestion_basedatos.ejecutarSentencia("select * from empleado");
                    try {
                        while (rs.next()) {
                            System.out.println("dni: " + rs.getString("dni"));
                            System.out.println("Nombre: " + rs.getString("nombre"));
                            //.....
                        }
                    } catch (SQLException sqe) {
                    }

                }
            } else {
                System.out.println("ERROR AL CREAR LA BASE DE DATOS");
            }
       //Cerramos conexión
       if(gestion_basedatos.conexion!= null)
            gestion_basedatos.cerrarConexion();

    }

    else
    System.out.println (

"NO SE HA PODIDO CARGAR EL DRIVER JDBC");
      
            
    }
   
}
