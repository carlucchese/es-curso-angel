//  CREAR LAS TABLAS DE LA BASE DE DATOS DE PUBS
package jdbc_aplicacion;

public class GestionPubs {

  public static void crearTabla_Pub() {
    String sql = "CREATE TABLE IF NOT EXISTS pub (" +
        "cod_pub         VARCHAR(5)   NOT NULL," +
        "nombre          VARCHAR(60)  NOT NULL," +
        "licencia_fiscal VARCHAR(60)  NOT NULL," +
        "domicilio       VARCHAR(60)         ," +
        "fecha_apertura  DATE         NOT NULL," +
        "horario         VARCHAR(60)  NOT NULL," +
        "cod_localidad   INTEGER      NOT NULL ) ";

    if (GestionBD.SentenciaCrear(sql)) {
      System.out.println("se ha creado la tabla pub");
      // Crear la clave primaria de la tabla pub que es cod_pub
      sql = "ALTER TABLE pub add constraint pk_pub PRIMARY KEY (cod_pub)";
      if (GestionBD.SentenciaCrear(sql)) {
        System.out.println("Se ha creado la clave primaria");

      }

    }

  }

  // CREAR LA TABLA TITULAR

  public static void CrearTabla_titular() {
    String sql = " CREATE TABLE IF NOT EXISTS titular (" +
        "dni_titular     VARCHAR(8)   NOT NULL," +
        "nombre          VARCHAR(60)  NOT NULL," +
        "domicilio       VARCHAR(60)  ," +
        "cod_pub         VARCHAR(5)   NOT NULL );";

    if (GestionBD.SentenciaCrear(sql)) {
      System.out.println("se ha creado la tabla titular");
      // Crear la clave primaria de la tabla pub que es cod_pub
      sql = "ALTER TABLE titular add constraint pk_titular PRIMARY KEY (dni_titular)";
      if (GestionBD.SentenciaCrear(sql)) {
        System.out.println("Se ha creado la clave primaria de la tabla titular");

      }

    }

  }

  // TABLA EMPLEADO
  public static void crearTablaEmpleado() {
    String sql = "CREATE TABLE empleado (" +
        "dni_empleado    VARCHAR(8)   NOT NULL," +
        " nombre          VARCHAR(60)  NOT NULL," +
        "domicilio       VARCHAR(60)          ) ;";

    if (GestionBD.SentenciaCrear(sql)) {
      System.out.println("se ha creado la tabla empleado");
      // Crear la clave primaria de la tabla pub que es cod_pub
      sql = "ALTER TABLE empleado add constraint pk_empleado PRIMARY KEY (dni_empleado)";
      if (GestionBD.SentenciaCrear(sql)) {
        System.out.println("Se ha creado la clave primaria de la tabla empleado");

      }

    }

  }

  // TABLA LOCALIDAD
  public static void crearTablaLocalidad() {
    String sql = "CREATE TABLE IF NO EXIST localidad (" +
        "cod_localidad   INTEGER      NOT NULL," +
        "nombre          VARCHAR(60)  NOT NULL)";

    if (GestionBD.SentenciaCrear(sql)) {
      System.out.println("se ha creado la tabla localidad");
      // Crear la clave primaria de la tabla pub que es cod_pub
      sql = "ALTER TABLE localidad add constraint pk_codloc PRIMARY KEY (cod_localidad)";
      if (GestionBD.SentenciaCrear(sql)) {
        System.out.println("Se ha creado la clave primaria de la tabla localidad");

      }

    }

  }

  // TABLA PUB_EMPLEADO
  public static void crearTablapub_empleado() {
    String sql = "CREATE TABLE pub_empleado (" +
        " cod_pub         VARCHAR(5)   NOT NULL," +
        "dni_empleado    VARCHAR(8)   NOT NULL," +
        " funcion         VARCHAR(9)   NOT NULL )";

    if (GestionBD.SentenciaCrear(sql)) {
      System.out.println("se ha creado la tabla pub_empleado");
      // Crear la clave primaria de la tabla pub que es cod_pub
      // sql=" ALTER TABLE pub_empleado ADD CONSTRAINT pk_pub_empleado" + " PRIMARY
      // KEY (cod_pub, dni_empleado)";
      String sql1 = " ALTER TABLE pub_empleado ADD  FOREIGN KEY (cod_pub)" + " REFERENCES pub (cod_pub) ;";
      String sql2 = " ALTER TABLE pub_empleado ADD  FOREIGN KEY (dni_empleado)"
          + " REFERENCES empleado (dni_empleado) ;";

      if (GestionBD.SentenciaCrear(sql)) {
        System.out.println("Se ha creado la clave primaria de la tabla localidad");

      }

      if (GestionBD.SentenciaCrear(sql1)) {
        System.out.println("Se ha creado la clave primaria de la tabla localidad");

      }

      if (GestionBD.SentenciaCrear(sql2)) {
        System.out.println("Se ha creado la clave primaria de la tabla localidad");

      }

    }

  }

}
