package Model;

import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ConfigBd.BD;
import Entidades.Persona;
import Entidades.Producto;
import Ventanas_productos.FrameEditarProducto;
import Ventanas_productos.FrameRegistrarProductos;
import Ventanas_productos.PanelProductos;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import Ventanas_personas.FrameMain;
import Ventanas_personas.PanelUsuarios;
import Ventanas_personas.Registrar;

/*El patron de diseño utilizado para desarollar este programa es el MVC (Modelo Vista Controlador).
Este es el modelo del cual heredaran las entidades, y este modelo le proporciona algunas funciones que necesitaran ambas
entidades, encargandose de la logica de obtener los datos y procesarlas y la bd que es una de las capas se encarga
de hacer la consulta con la base de datos.

En algunas ocaciones hice consultas sin consultarla con el modelo pero en el momento no encontre otra forma de 
resolver el problema.

Hice lo mejor que pude!!
*/

public class Model {
   
    //Funcion que obtiene los atributos publicos de cualquier entidad
    public String getFields(){
            Field[] fields = this.getClass().getFields();
            List<String> list = new ArrayList<String>();
            
            for(Field campo : fields){
               list.add(campo.getName());
            }
            
            String campos = String.join(" , ", list);
            return campos;
                    
    }
    
    //Funcion que recolecta los atributos publicos y se comunica con la bd para hacer las consultas
    public void agregarRegisto(String values, String nameTable){
        BD db = new BD();
        
        String campos = this.getFields();
        db.insertarRegistro(campos, values, nameTable);
    }
    
    public void logear(String user, String pass, JFrame login){
        BD db = new BD();
      
        boolean isLogin =  db.buscar(user, pass);
        if(isLogin) {
            login.setVisible(false);
             FrameMain main = new FrameMain();
            main.setVisible(isLogin);
        }
    }
    
    //Metodo que actualiza un registro en la tabla persona
    public void updatePersona(List<String> values, String id, Registrar Reg, PanelUsuarios Pan){
            //Pasarle los values en el mismo orden que estan en el modelo
            BD db = new BD();
            Field[] fields = this.getClass().getFields();
            String where = "";
            int cont = 0;
            int campos = fields.length - 1;
            
            for(Field campo : fields){
                if(cont == campos){
                    where += campo.getName() + "=" + "'" + values.get(cont)+ "'";
                }
                
                else {
                    where += campo.getName() + "=" + "'" + values.get(cont)+ "'" + ",";
                }

               cont++;
            }
        

           db.UpdateData(where, "Personas","Id_persona",id, Reg, Pan);
           
    }
    
    //Metodo que actualiza un registro en la tabla producto
     public void updateProducto(List<String> values, String id, FrameRegistrarProductos Reg, PanelProductos Pan){
            //Pasarle los values en el mismo orden que estan en el modelo
            BD db = new BD();
            Field[] fields = this.getClass().getFields();
            String where = "";
            int cont = 0;
            int campos = fields.length - 1;
            
            for(Field campo : fields){
                if(cont == campos){
                    where += campo.getName() + "=" + "'" + values.get(cont)+ "'";
                }
                
                else {
                    where += campo.getName() + "=" + "'" + values.get(cont)+ "'" + ",";
                }

               cont++;
            }
        

           db.UpdateDataProducto(where ,id, Reg, Pan);
           
    }
    
    
}
