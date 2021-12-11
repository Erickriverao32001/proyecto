package ConfigBd;

import Model.Model;
import Ventanas_productos.FrameEditarProducto;
import Ventanas_productos.FrameRegistrarProductos;
import Ventanas_productos.PanelProductos;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import Ventanas_personas.FrameMain;
import Ventanas_personas.PanelUsuarios;
import Ventanas_personas.Registrar;

public class BD {
    Connection cn;
    
    //Conexion con la base de datos
    public Connection conexion(){
        try{       
          Class.forName("com.mysql.jdbc.Driver");
          cn = DriverManager.getConnection("jdbc:mysql://localhost/crud_erick","root","Manuel22");
        }
      
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
        }
        
        return cn;
      
    }
    
    //Funcion que guarda los registros en la base de datos
    public void insertarRegistro(String campos, String values, String nameClase ){
        Connection cn = this.conexion();
        try {
               String query = "INSERT INTO " + nameClase + "(" + campos + ")" + "values ('" + values + "');"; 
               PreparedStatement p = cn.prepareStatement(query);
               JOptionPane.showMessageDialog(null, nameClase + " agregado con exito!!!");
               p.executeUpdate();              
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Funcion que ejecuta el boton de login y este intenra encontrar los datos que ingreso el usuario
    public boolean buscar(String username, String password){     
         Connection cn = this.conexion();
         boolean isLogin = false;
         try {
            String query = "SELECT * FROM personas WHERE Username = '"+ username+ "' and Password = '"+ password+"';";
             PreparedStatement p = cn.prepareStatement(query);
            ResultSet result = p.executeQuery();
            
            if(result.next()){
                JOptionPane.showMessageDialog(null, "Usuario logeado con exito");
                isLogin = true;
             }  
             else {
                 JOptionPane.showMessageDialog(null, "Usuario no identificado");
             }
            
        } 
         catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        
         return isLogin;
    }
    
    //Funcion que busca las personas guardadas en la base de datos
    public DefaultTableModel getPersonas(){
        Connection cn = this.conexion();
        ResultSet result = null;
        DefaultTableModel tb = new DefaultTableModel();
        
        try {
            PreparedStatement pd = cn.prepareStatement("SELECT * FROM personas ;");
            result = pd.executeQuery();
            tb.setColumnIdentifiers(new Object[]{"Id_persona","Nombre","Apellido","Telefono","Username"});
            
            while(result.next()){
                tb.addRow(new Object[]{
                    result.getString("Id_persona"),
                    result.getString("Nombre"),
                    result.getString("Apellido"),
                    result.getString("Telefono"),
                    result.getString("Username"),
                });
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return tb;
    } 
    
        //Funcion que busca los productos guardado en la base de datos
        public DefaultTableModel getProductos(){
            Connection cn = this.conexion();
            ResultSet result = null;
            DefaultTableModel tb = new DefaultTableModel();

            try {
                PreparedStatement pd = cn.prepareStatement("SELECT * FROM productos ;");
                result = pd.executeQuery();
                tb.setColumnIdentifiers(new Object[]{"Id_producto","NombreProducto","MarcaProducto","CategoriaProducto","PrecioProducto", "StockProducto"});

                while(result.next()){
                    tb.addRow(new Object[]{
                        result.getString("Id_producto"),
                        result.getString("NombreProducto"),
                        result.getString("MarcaProducto"),
                        result.getString("CategoriaProducto"),
                        result.getString("PrecioProducto"),
                        result.getString("StockProducto"),
                    });
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            return tb;
    } 
    
    //Funcion que obtiene un usuario segun el id que se le mande
    public Map getByUsuariosId(String nameTable, String campo, String id){
         Connection cn = this.conexion();
         String query = "SELECT * FROM " + nameTable + " where " + campo + " = " + id + ";";
         Map<String, String> data = new HashMap<String, String>();
         
         ResultSet result = null;
         try {
            PreparedStatement pd = cn.prepareStatement(query);
            result = pd.executeQuery();
            
            while(result.next()){
                 data.put("Nombre", result.getNString("Nombre"));
                 data.put("Apellido", result.getNString("Apellido"));
                 data.put("Username", result.getNString("Username"));
                 data.put("Telefono", result.getNString("Telefono"));
                 data.put("Password", result.getNString("Password"));
            }
         }
         catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
         
         return data;  
    }
    
    //Funcion que busca un producto dependiendo del id
    public Map getProductoById(String nameTable, String campo, String id){
         Connection cn = this.conexion();
         String query = "SELECT * FROM " + nameTable + " where " + campo + " = " + id + ";";
         Map<String, String> data = new HashMap<String, String>();
         
         ResultSet result = null;
         try {
            PreparedStatement pd = cn.prepareStatement(query);
            result = pd.executeQuery();
            
            while(result.next()){
                 data.put("NombreProducto", result.getNString("NombreProducto"));
                 data.put("MarcaProducto", result.getNString("MarcaProducto"));
                 data.put("CategoriaProducto", result.getNString("CategoriaProducto"));
                 data.put("PrecioProducto", result.getNString("PrecioProducto"));
                 data.put("StockProducto", result.getNString("StockProducto"));
            }
         }
         catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
         
         return data;  
    }
    
    //Funcion que elimina un registro de la base de datos
    public void eliminarRegistro(String nameTable, String id, String campo){
         Connection cn = this.conexion();
         String query = "DELETE  FROM " + nameTable + " where " + campo + " = " + id + ";";
         
         try {
            PreparedStatement pd = cn.prepareStatement(query);
            pd.executeUpdate();  
             JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Funcion que actualiza un usuario de la base de datos
    public void UpdateData(String where ,String nameTable, String campo, String id, Registrar Registro, PanelUsuarios PanelUsuarios){
        Connection cn = this.conexion();
        String query = "UPDATE " + nameTable + " SET " + where + " where " + campo + " = " + id;
        
        try {
            PreparedStatement pd = cn.prepareCall(query);
            pd.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Usuario actualizado con exito!");
            Registro.asignarReferencia(PanelUsuarios);  
        } 
        catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Funcion que actualiza un usuario de la base de datos
     public void UpdateDataProducto(String where , String id, FrameRegistrarProductos Frame, PanelProductos Panel){
        Connection cn = this.conexion();
        String query = "UPDATE  Productos SET " + where + " where Id_producto  = " + id;

        try {
            PreparedStatement pd = cn.prepareCall(query);
            pd.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Producto actualizado con exito!");
            Frame.asignarReferencia(Panel);
            Frame.recargarTabla();
        } 
        catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
        }
    }
}
