/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoriaut8_2.conexiones;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import tutoriaut8_2.modelo.Cliente;

/**
 *
 * @author lucasjosemoraleschacon
 */
public interface DAO {
    
    //CRUD: Create, Read, Update, Delete

    ArrayList cargarClientes() throws SQLException;

    Connection conectar() throws SQLException;

    void desconectar(Connection con) throws SQLException;

    int eliminar(int id) throws SQLException;

    void insertar(Cliente c) throws SQLException;

    int modificar(Cliente c, int viejoId) throws SQLException;
    
}
