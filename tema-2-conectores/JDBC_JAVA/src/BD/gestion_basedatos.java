package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
//TRABAJAMOS CON LOS PAQUETES java.sql 

public class gestion_basedatos {

    public static Connection conexion;
   
    public static Statement stm;
    public static PreparedStatement pstm=null;

    //Registrar el driver de la base de datos
    public static boolean cargarDriverJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
            return false;
        }
        return true;
    }
  //Nos conectamos a una base de datos mysql
    public static boolean conectar_basedatos(String url, String usuario, String contrasena) {
        //Realizamos la conexión
        try { //conectamos
            gestion_basedatos.conexion = DriverManager.getConnection(url, usuario, contrasena);
            //creamos el objeto statement para enviar sentencias sql a la base de datos.
            stm = conexion.createStatement();
           
        } catch (SQLException ex1) {
            System.out.println(ex1.getMessage());
            return false;
        }

        return true;
    }

    public static ResultSet ejecutarSentencia(String sentenciasql) {
        try {
            ResultSet rset = stm.executeQuery(sentenciasql);
            return rset;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException sqe) {
            System.out.println("error al cerrar la conexión");
            System.out.println(sqe.getMessage());

        }

    }

    public static boolean crearTabla(String sql) {
        try {
            pstm=conexion.prepareStatement(sql);
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException sqle) {
            System.out.println("Error al crear la tabla: " + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return false;

    }
//Insertar datos en una tabla de la base de datos
    public static boolean insertarTablaEmpleado(String dni, String nombre, int edad, String puesto) {
        try {
            // Creamos el PreparedStatement si no estaba ya creado.

            pstm = conexion.prepareStatement("insert into empleado values (?,?,?,?)");
            pstm.setString(1, dni); // La edad, el primer interrogante, es un entero.
            pstm.setString(2, nombre); // El String nombre es el segundo interrogante
            pstm.setInt(3, edad); // Y el tercer interrogante, un String apellido.
            pstm.setString(4, puesto);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la conexión:" + e.toString());
            return false;
        } 
            
       

    }
//CREAR BASE DE DATOS  
    public static boolean crearBaseDeDatos(String nombreBasedatos) {
        try {
            
            stm.execute("create database " + nombreBasedatos);

        } catch (SQLException e) {
            System.out.println("Error en la conexión:" + e.toString());
            return false;
        }
      
        return true;

    }

    public static boolean Ejecutar(String sql) {
        try {
            
            stm.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error en la conexión:" + e.toString());
            return false;
        } 

        return true;
    }

}
