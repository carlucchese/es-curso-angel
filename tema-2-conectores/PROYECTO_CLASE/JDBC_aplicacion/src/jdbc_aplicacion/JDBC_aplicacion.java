package jdbc_aplicacion;

import java.util.ArrayList;
import jdbc_aplicacion.clases.Localidad;
import jdbc_aplicacion.clases.Pub;

public class JDBC_aplicacion {

    public static void main(String[] args) {
        // Cargar driver
        if (GestionBD.CargarDriverJDBC()) {
            System.out.println("Se ha cargado el driver");
        }

        // Conectarno a la base de datos test
        GestionBD.ConectarBD("jdbc:mysql://127.0.0.1/estudiantes", "root", "1347");
        // Creamos la base de datos
        if (GestionBD.crearBaseDatos("pubs")) {
            System.out.println("Se ha creado la base de datos");
            // Cerramos la conexión con test y abrimos otra conexión con pubs
            GestionBD.cerrarConexion();
            GestionBD.ConectarBD("jdbc:mysql://localhost/pubs", "root", "1347");
            GestionPubs.crearTabla_Pub();
            GestionPubs.CrearTabla_titular();
            GestionPubs.crearTablaEmpleado();
            GestionPubs.crearTablaLocalidad();
            GestionPubs.crearTablapub_empleado();
        }

        GestionBD.cerrarConexion();

    }
    // cerrar conexión

}
