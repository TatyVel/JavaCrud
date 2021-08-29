
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tatiana
 */
    public class ConexionBD {
  static String bd="BDproducto";
  static String user="root";
  static String pass = "tatyvel00";
  static String url="jdbc:mysql://localhost:3306/"+ bd;
  
  Connection conn = null;

    public ConexionBD() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);
        
        if(conn!= null){
            System.out.println("La conexion es exitosa");
        }

        }catch(Exception e){
        System.out.println("Error en la conexion a la base de datos"+e);
        
        }
    }
    
    public Connection Conectar(){
    return conn;
    }
    
     public void Desconectar() throws Exception{
     conn.close();
     }
    
    
  
  
    
}
