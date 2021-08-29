
package dao;
import conexion.ConexionBD;
import java.sql.Date;
import modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;



/**
 *
 * @author tatiana
 */
public class ProductoDao {
    
    ConexionBD  conn; //objeto de la clase conexion

    public ProductoDao(ConexionBD conn) {
        this.conn = conn;
    }
    
    public boolean Insert(Producto prod){ //objeto de tipo producto     
    String sql= "insert into producto values(?,?,?,?,?);"; //SENTENCIA PREPARADA
    
    try{
        
    PreparedStatement ps = conn.Conectar().prepareCall(sql);
     
     ps.setInt(1,prod.getId());
     ps.setString(2, prod.getNombre_prod());
     ps.setInt(3, prod.getCodigo_prod());
     ps.setDate(4, prod.getCaducidad());
     ps.setString(5, prod.getProveedor());
     
     ps.executeUpdate();
      return true;  
    }
    catch(Exception e){
    
    return false;
    }
     
    }
    
    //metodo consultar 
    public List<Producto> selectAll() {
        String sql = "select * from Producto";

        try {
            PreparedStatement ps = conn.Conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            List<Producto> list = new LinkedList<>();
               Producto prod;
               
               while(rs.next()){
               prod = new Producto(rs.getInt("Id"));
               
               prod.setNombre_prod(rs.getString("nombre_prod"));
               prod.setCodigo_prod(rs.getInt("codigo_prod"));
               prod.setCaducidad(rs.getDate("caducidad"));
               prod.setProveedor(rs.getString("proveedor"));
               list.add(prod);
               
               }
               return list;
        } catch (Exception e){
            return null;
        }

    }
    
    
    
    
    
    
    
    
}
