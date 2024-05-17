package tutoriaut8_2.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tutoriaut8_2.modelo.Cliente;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateStringConverter;
import tutoriaut8_2.conexiones.DAOMySQL;

/**
 * FXML Controller class
 *
 * @author lucasjosemoraleschacon
 */
public class FXMLClienteController implements Initializable 
{
    public static final String ANSI_RED = "\u001B[31m";

    /** Campos de texto **/
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfDireccion;
    @FXML
    private TextField tfTelefono;
    
    /** CheckBox **/
    private CheckBox cbCoche;
    private CheckBox cbMoto;
    
    /** TABLEVIEW **/
    private ObservableList<Cliente> listaClientes;
    
    @FXML
    private TableView<Cliente> tvClientes;
    
    @FXML
    private TableColumn<Cliente, Integer> colId;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colDireccion;
    @FXML
    private TableColumn<Cliente, String> colTelefono;
    @FXML
    private TableColumn<Cliente, String> colFechaNac;
    
    /** Buttons **/
    @FXML
    private Button btnInsertar;
    @FXML
    private Button btnBorrarCliente;
    @FXML
    private Button btnBorrarTodos;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnModificarCliente;
    
    /** Labels **/
    @FXML
    private Label labelPrueba;
      
    /** DatePicker **/
    @FXML
    private DatePicker dpFecha;
    
    String fecha;
    DateTimeFormatter formatter;

    //Nos almacena la última fila seleccionada en la tabla
    int ultimaFilaSeleccionada=-1;
    
    /* BBDD */
    private static DAOMySQL cn;
    ArrayList<Cliente> listaAux;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //Label para mensajes
        labelPrueba.setText("");
        
        //Inicializar TableView
        listaClientes = FXCollections.observableArrayList();
        tvClientes.setItems(listaClientes);
        
        //Creación de las propiedades
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colDireccion.setCellValueFactory(new PropertyValueFactory("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        colFechaNac.setCellValueFactory(new PropertyValueFactory("fechaNac"));
        
        /* DATEPICKER */
        //Asignamos la fecha de hoy
        dpFecha.setValue(LocalDate.now());
        //Solo se puede elegir desde el calendario (no se puede escribir a mano)
        dpFecha.setEditable(false); 
        
        //Modifica el formato en el que se muestra la fecha
        formatter = DateTimeFormatter.ofPattern("dd/MM/yy");//Formato dd/MM/yy
        dpFecha.setConverter(new LocalDateStringConverter(formatter, null));
        
        /** BBDD - Cargar Clientes **/
        
        cn = DAOMySQL.getInstance();
       
        try
        { 
            listaAux = cn.cargarClientes();
            
            for (Cliente cl : listaAux) 
            {
                //Se añaden los Clientes rescatados de la BBDD en la ObservableList
                listaClientes.add(cl);
            }

        }  
        catch (SQLException e)
        {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error en la BBDD");
            alerta.setHeaderText("");
            alerta.setContentText(e.getMessage());
            
            alerta.showAndWait();
        }    
        
           
    }    

    @FXML
    private void insertarCliente(ActionEvent event) 
    {
        int id;
        String nombre, dir, tel;
        boolean coche, moto;
        
        id = Integer.parseInt(tfId.getText());
        
        nombre = tfNombre.getText();
        dir = tfDireccion.getText();
        tel = tfTelefono.getText();
        
        //Fecha nacimiento
        /* DatePicker */
        //Obtenemos el valor seleccionado en el DatePicker
        //LocalDate item = dpFecha.getValue();
        //Obtenemos el valor y lo almacenamos en un String
        fecha = dpFecha.getValue().format(formatter);
        
        Cliente c = new Cliente(id,nombre,dir,tel,fecha);

        /* BBDD */
        
        try
        {   
            cn.insertar(c);
            
            listaClientes.add(c);
            
            labelPrueba.setTextFill(Color.web("#0000FF"));
            labelPrueba.setText("Cliente insertado correctamente");
        }  
        catch (SQLException e)
        {
            /*Si hay un error al insertarlo en la BBDD, lo borramos de la lista
            listaClientes.remove(c);*/
            
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error en la BBDD");
            alerta.setHeaderText("");
            alerta.setContentText(e.getMessage());
            
            alerta.showAndWait();
        }    

    }

    @FXML
    private void borrarCliente(ActionEvent event) 
    {
        
        int i = tvClientes.getSelectionModel().getSelectedIndex();
        
        if (i != -1)
        {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Cliente");
            alert.setHeaderText(event.toString());
            alert.setContentText("¿Estás seguro de eliminar el cliente con ID=" + listaClientes.get(i).getId()
                    + "?");

            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK)
            {
                                
                /** BBDD **/
                try
                {
                    int x = cn.eliminar(listaClientes.get(i).getId());
                    
                    if ( x == 1)
                    {
                        //Se elimina el cliente de la lista (se llega aquí si todo ha ido bien)
                        listaClientes.remove(i);
                        
                        labelPrueba.setTextFill(Color.web("#FF0000"));
                        labelPrueba.setText("Cliente eliminado correctamente");
                        
                    }    

                }  
                catch (SQLException e)
                {
                    //Si hay un error al insertarlo en la BBDD, lo borramos de la lista
                    listaClientes.remove(i);

                    Alert alerta = new Alert(AlertType.ERROR);
                    alerta.setTitle("Error en la BBDD");
                    alerta.setHeaderText("");
                    alerta.setContentText(e.getMessage());

                    alerta.showAndWait();
                }    

            } 
            else 
            {
                // ... user chose CANCEL or closed the dialog
            }

        }    
    }

    @FXML
    private void borrarTodos(ActionEvent event) 
    {
        try
        {
            /** BBDD **/
            int x = cn.eliminarTodos();

            //Elimina todos los clientes de la TableView
            listaClientes.clear();

            labelPrueba.setTextFill(Color.web("#FFAAFF"));
            labelPrueba.setText("Se han eliminado " + x + " clientes correctamente");
   
        }    
        catch (SQLException e)
        {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error en la BBDD");
            alerta.setHeaderText("");
            alerta.setContentText(e.getMessage());

            alerta.showAndWait();
        }    

    }

    @FXML
    private void filaSeleccionada(MouseEvent event) 
    {
        //Obtener la fila seleccionada
        ultimaFilaSeleccionada = tvClientes.getSelectionModel().getSelectedIndex();
        
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Fila seleccionada");
        alerta.setHeaderText("");
        alerta.setContentText("Has seleccionado la fila " + ultimaFilaSeleccionada);
        
        alerta.showAndWait();
        
        /* Cargar la información en los campos */
        Cliente cAux = listaClientes.get(ultimaFilaSeleccionada);
        
        tfId.setText(Integer.toString(cAux.getId()));
        tfNombre.setText(cAux.getNombre());
        
        //DatePicker
        LocalDate fechaLocal = LocalDate.parse(cAux.getFechaNac(), formatter);
        dpFecha.setValue(fechaLocal);
        
        tfDireccion.setText(cAux.getDireccion());
        tfTelefono.setText(cAux.getTelefono());

    }

    @FXML
    private void limpiar(ActionEvent event)
    {

        tfId.clear();
        tfNombre.clear();
        
        //DatePicker
        dpFecha.setValue(LocalDate.now());
        
        tfDireccion.clear();
        tfTelefono.clear();

        labelPrueba.setText("");
        
    }

    @FXML
    private void modificarCliente(ActionEvent event) 
    {
        int id;
        String nombre, dir, tel;
        boolean coche, moto;
        
        if (ultimaFilaSeleccionada == -1)
        {
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Fila seleccionada");
            alerta.setHeaderText("");
            alerta.setContentText("No se ha seleccionado ninguna fila");
            
            alerta.showAndWait();

        }   
        else
        {
            id = Integer.parseInt(tfId.getText());
        
            nombre = tfNombre.getText();
            dir = tfDireccion.getText();
            tel = tfTelefono.getText();

            //Fecha nacimiento
            /* DatePicker */
            //Obtenemos el valor seleccionado en el DatePicker
            //LocalDate item = dpFecha.getValue();
            //Obtenemos el valor y lo almacenamos en un String
            fecha = dpFecha.getValue().format(formatter);

            Cliente c = new Cliente(id,nombre,dir,tel,fecha);
            
            /** BBDD **/
            try
            {
                int x = cn.modificar(c, listaClientes.get(ultimaFilaSeleccionada).getId());
                
                if ( x == 1)
                {
                    //JavaFX
                    listaClientes.remove(ultimaFilaSeleccionada);
                    listaClientes.add(c);

                    tvClientes.refresh();

                    labelPrueba.setTextFill(Color.web("#000FF0"));
                    labelPrueba.setText("Cliente modificado correctamente");
                }    

            }  
            catch (SQLException e)
            {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Error en la BBDD");
                alerta.setHeaderText("");
                alerta.setContentText(e.getMessage());

                alerta.showAndWait();
            } 
 
        }    
        
        
    }

    
    
}
