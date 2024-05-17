package jdbc_aplicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {

    public static Connection conexion;
    public static Statement sentenciasql;

    public static boolean CargarDriverJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exc) {
            System.out.println("ERROR AL CARGAR EL DRIVER DE LA BASE DE DATOS");
            System.out.println(exc.getMessage());
            return false;
        }

        return true;

    }

    public static void ConectarBD(String url, String usuario, String contrasena) {
        try {

            GestionBD.conexion = DriverManager.getConnection(url, usuario, contrasena);
            sentenciasql = conexion.createStatement();
        } catch (SQLException sqle) {
            System.out.println("error al conectar con la base de datos");
            System.out.println(sqle.getMessage());
            conexion = null;
        }

    }

    public static void cerrarConexion() {
        if (GestionBD.conexion != null) {
            try {
                System.out.println("la conexión se ha realizado correctamente");
                GestionBD.conexion.close();
                GestionBD.sentenciasql.close();
            } catch (SQLException sqe) {
                System.out.println("error al cerrar conexión");
                System.out.println(sqe.getMessage());
            }
        }

    }

    public static boolean crearBaseDatos(String nombre) {
        if (conexion != null) {
            try {

                sentenciasql.execute("create database " + nombre);

            } catch (SQLException sqc) {
                System.out.println("ERROR AL CREAR BASE DE DATOS");
                System.out.println(sqc.getMessage());
                return false;

            }
            return true;

        }
        return false;

    }

    public static boolean SentenciaCrear(String sql) {
        if (conexion != null) {
            try {
                sentenciasql = conexion.createStatement();
                sentenciasql.execute(sql);

            } catch (SQLException sqc) {
                System.out.println("ERROR AL CREAR BASE DE DATOS");
                System.out.println(sqc.getMessage());
                return false;

            }
            return true;

        }
        return false;

    }

}
