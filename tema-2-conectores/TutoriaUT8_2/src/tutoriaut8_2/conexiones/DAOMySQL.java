/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoriaut8_2.conexiones;

/**
 *
 * @author Dell
 */
import java.sql.*;
import java.util.ArrayList;
import tutoriaut8_2.modelo.Cliente;

/**
 *
 * @author USUARIO
 */
public class DAOMySQL implements DAO, Cloneable {
    
    /* Singleton */
    private static final DAOMySQL INSTANCE = new DAOMySQL();

    private Connection conn;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet res;

    private DAOMySQL() 
    {
        
    }
    
    /* Singleton */
    public static DAOMySQL getInstance() 
    {
       return INSTANCE;
    }
    
    /* Singleton - Para evitar la clonación del objeto */
    public Object clone() throws CloneNotSupportedException 
    {
    	throw new CloneNotSupportedException(); 
    }

    /** BBDD **/
    
    @Override
    public Connection conectar() throws SQLException 
    {
        
        String url = "jdbc:mysql://uunerxcqwshpqek2:DRWyNZqyHKV1ohicbZU2@bwfkmrtycnrahk1ajtzw-mysql.services.clever-cloud.com:3306/bwfkmrtycnrahk1ajtzw";
        String user = "uunerxcqwshpqek2";
        String password = "DRWyNZqyHKV1ohicbZU2";

        conn = DriverManager.getConnection(url, user, password);

        return conn;

    }

    @Override
    public void desconectar(Connection con) throws SQLException 
    {
        con.close();

    }
    
    @Override
    public ArrayList cargarClientes() throws SQLException 
    {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        DAOMySQL cn = INSTANCE;
        conn = cn.conectar();

        st = conn.createStatement();
        res = st.executeQuery("Select * from Cliente");

        while (res.next()) 
        {
            Cliente c = new Cliente(res.getInt("Id"), res.getString("Nombre"), 
                    res.getString("Direccion"), res.getString("Telefono"), res.getString("FechaNac"));
            
            listaClientes.add(c);
        }
        
        res.close();
        st.close();
        cn.desconectar(conn);
        
        return listaClientes;

    }

   
    @Override
    public void insertar(Cliente c) throws SQLException 
    {

          DAOMySQL cn = INSTANCE;
          conn = cn.conectar();
          
          ps = conn.prepareStatement("INSERT INTO Cliente (Id, Nombre, Direccion, Telefono, FechaNac) VALUES (?,?,?,?,?);");
          
          ps.setInt(1, c.getId());
          ps.setString(2, c.getNombre());
          ps.setString(3, c.getDireccion());
          ps.setString (4, c.getTelefono());
          ps.setString(5, c.getFechaNac());
          
          ps.executeUpdate();
          
          ps.close();
          cn.desconectar(conn);

    }

   
    @Override
    public int modificar(Cliente c, int viejoId) throws SQLException {

        //DAOMySQL cn = new DAOMySQL();
        DAOMySQL cn = INSTANCE;
        conn = cn.conectar();

        ps = conn.prepareStatement("Update Cliente set Nombre = ? , Direccion = ? , Telefono = ? , FechaNac = ?, Id = ? where Id = ?;");
        
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getDireccion());
        ps.setString(3, c.getTelefono());
        ps.setString(4, c.getFechaNac());
        ps.setInt(5, c.getId());
        ps.setInt(6, viejoId);

        int modificados = ps.executeUpdate();

        ps.close();
        cn.desconectar(conn);
        
        return modificados;

    }

    
    @Override
    public int eliminar(int id) throws SQLException 
    {
        DAOMySQL cn = INSTANCE;
        conn = cn.conectar();
        st = conn.createStatement();
        
        int eliminados = st.executeUpdate("Delete from Cliente where id =  " + id + ";");

        
        st.close();
        cn.desconectar(conn);
        
        return eliminados;
    }
    
    public int eliminarTodos() throws SQLException 
    {
        DAOMySQL cn = INSTANCE;
        conn = cn.conectar();
        st = conn.createStatement();
        
        int eliminados = st.executeUpdate("Delete from Cliente;");

        st.close();
        cn.desconectar(conn);
        
        return eliminados;
    }     
    

}
