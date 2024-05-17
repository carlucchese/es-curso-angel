package jdbc_aplicacion;

import java.sql.Statement;
import java.sql.Connection;
import jdbc_aplicacion.clases.Pub;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc_aplicacion.clases.Localidad;


public class MantenimientoPub {

    public static void insertarPub(Connection conn, Pub p) {
        if (conn != null) {
            PreparedStatement pstm = null;
            //sentencia sql para insertar
            try {
                 String sql = "insert into pub(cod_pub,nombre,fecha_apertura,cod_localidad,horario,licencia_fiscal,domicilio) values (?,?,?,?,?,?,?)";
                 pstm = conn.prepareStatement(sql);
                 pstm.setString(1,p.getCod_pub());
                 pstm.setString(2,p.getNombre());
                 Date fecha = new java.sql.Date(p.getFapertura().getTime());
                 pstm.setDate(3, fecha);
                 
                 pstm.setInt(4, p.getLocalidad().getCod_localidad());
                 pstm.setString(5, p.getHorario());
                 pstm.setString(6, p.getLicencia_fiscal());
                 pstm.setString(7, p.getDomicilio());
                 pstm.executeUpdate();
                 
                 } catch (SQLException sql) {
                    System.out.println("ERROR al insertar pub");
                    System.out.println(sql.getMessage());

                }  finally
                  {
                  try{
                       pstm.close();
                    }catch(SQLException e)
                 {   
                   System.out.println(e.getMessage());
            
                }
            }
           }

         }
    
    
    public static java.util.Date establecerfecha(int dia, int mes, int anno) {
        DateFormat fechaformat = new SimpleDateFormat("dd/M/yy");
        try {
            // convierte un String en formato fecha en una fecha real
           java.util.Date fecha = fechaformat.parse(dia + "/" + mes + "/" + anno);
            return fecha;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
      
     public static void modificarPub(Connection conn, Pub p) 
     { if(conn!=null)
       {  PreparedStatement pstm = null;
          String sql="UPDATE pub SET nombre = ?, fecha_apertura = ?, cod_localidad =? ,horario=?, licencia_fiscal=? ,domicilio=? WHERE cod_pub = ? ";
          try{
                pstm = conn.prepareStatement(sql);
                pstm.setString(1,p.getNombre());
                Date fecha = new java.sql.Date(p.getFapertura().getTime());
                pstm.setDate(2,fecha);
                pstm.setInt(3,p.getLocalidad().getCod_localidad());
                pstm.setString(4,p.getHorario());
                pstm.setString(5,p.getLicencia_fiscal());
                pstm.setString(6, p.getDomicilio());
                pstm.setString(7, p.getCod_pub());
                pstm.executeUpdate();
              }  catch(SQLException sq)
              {      System.out.println("ERROR AL MODIFICAR LOS DATOS DEL PUB");
                     System.out.println(sq.getMessage());
                            
              }finally
               {
                 try{
                     pstm.close();
                    }catch(SQLException e)
                   {   
                    System.out.println(e.getMessage());
            
                   }
            }    
       }


     }
     public static void borrarPub(Connection con, Pub p)  
     { if(con!=null)
       { PreparedStatement pstm = null;
        try{
            String sql="delete from pub where cod_pub=?";
            pstm=con.prepareStatement(sql);
            pstm.setString(1,p.getCod_pub());
            pstm.executeUpdate();
           }catch(SQLException ex)
           { System.out.println("ERROR AL BORRAR EL PUB");
             System.out.println(ex.getMessage());      
           }finally
             {
              try{
                   pstm.close();
                }catch(SQLException e)
                {   
                 System.out.println(e.getMessage());
            
                }
            }
       }    
     
     }
     public static String obtenerNombLocalidad(Connection con, int cod_localidad) 
     {  PreparedStatement pstm=null;
        String nombre=null;
        if(con!=null)
        { try {  
              String sql="select * from Localidad where cod_localidad=?";
              pstm = con.prepareStatement(sql);
              pstm.setInt(1, cod_localidad);
              ResultSet rs =pstm.executeQuery();
              while(rs.next())
             {  
                return(rs.getString("nombre"));       
             }
            
            } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPub.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println(ex.getMessage());
         } finally {
            try{
            pstm.close();
            }catch(SQLException e)
             {   
                 System.out.println(e.getMessage());
            
             }
            }
        }
        return nombre;
        }
             
     public static void mostrarInformacionPub(Connection con, String cod_pub)
     {  PreparedStatement pstm= null;
        String sql="select * from pub where cod_pub=?";
        Pub p = null;
        try{
            
           pstm= con.prepareStatement(sql);
           pstm.setString(1, cod_pub);
           ResultSet rs=  pstm.executeQuery();
           while (rs.next())
           {   p = new Pub();
               p.setCod_pub(cod_pub);
               p.setNombre(rs.getString("nombre"));
               p.setDomicilio(rs.getString("domicilio"));
               int localidad=rs.getInt("cod_localidad");
               p.setLicencia_fiscal(rs.getString("licencia_fiscal"));
               String horario =rs.getString("horario");
               p.setHorario(Pub.tipo_horario.valueOf(horario));
               java.sql.Date fecha = rs.getDate("fecha_apertura");
               java.util.Date  utilDate = new java.util.Date(fecha.getTime());
               p.setFapertura(utilDate);
                   //Crear el objeto Localidad
                //Asignarlo al campo localidad del objeto pub
                Localidad l = new Localidad(localidad,obtenerNombLocalidad(con,localidad));
                p.setLocalidad(l);          
                System.out.println("------------------------------------------");
                System.out.println(p);
                     
           
           }
          }catch( SQLException sqle)
            { 
                 System.out.println("ERROR AL MOSTRAR INFORMACIÓN ");
                 System.out.println(sqle.getMessage());         
                   
            }finally
             {
              try{
                   pstm.close();
                }catch(SQLException e)
                {   
                 System.out.println(e.getMessage());
            
                }
            }
     }
     
     public static ArrayList<Pub>ObtenerPubs(Connection con, Statement stm)
     { ArrayList<Pub> lista=null;
       if(con!=null)
       {  String sql="select * from Pub";
          try {
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())
                { Pub p = new Pub();
                   p.setCod_pub(rs.getString("cod_pub"));
                   p.setNombre(rs.getString("nombre"));
                   p.setDomicilio(rs.getString("domicilio"));
                   int localidad=rs.getInt("cod_localidad");
                   p.setLicencia_fiscal(rs.getString("licencia_fiscal"));
                   String horario =rs.getString("horario");
                   p.setHorario(Pub.tipo_horario.valueOf(horario));
                  java.sql.Date fecha = rs.getDate("fecha_apertura");
                  java.util.Date  utilDate = new java.util.Date(fecha.getTime());
                  p.setFapertura(utilDate);
                   //Crear el objeto Localidad
                //Asignarlo al campo localidad del objeto pub
                Localidad l = new Localidad(localidad,obtenerNombLocalidad(con,localidad));
                p.setLocalidad(l);  
                if(lista==null)
                    lista= new ArrayList<Pub>();
                lista.add(p);
                
                }
              } 
                 catch (SQLException ex) 
              {
                System.out.println("error al listar pubs");
                System.out.println(ex.getMessage());
              }   
       
       }
     
       return lista;
     
     
     
     }
     
     
     }
     

     



