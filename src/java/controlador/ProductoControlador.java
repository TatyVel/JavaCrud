
package controlador;

import modelo.Producto;
import conexion.ConexionBD;
import dao.ProductoDao;
import java.util.List;
import java.util.Scanner;


public class ProductoControlador {
    
    public static void main(String[] args) {
        
             
        Scanner scan = new Scanner(System.in);
        
        Producto prod = new Producto(0);
        ConexionBD conn = new ConexionBD();
        ProductoDao Prodao = new ProductoDao(conn);
        
         
        
        System.out.println("-------------------------------------------");
        System.out.println("MENU");
        System.out.println("Ingrese las letras en mayuscula "
                + "\n A-Para insertar un registro "
                + "\n B-Para mostrar los registros ");
        
        
        String resp= (scan.next());
        
        switch(resp){
            
            case "A": //insertar
        System.out.println("Ingrese el Nombre del producto: ");
        prod.setNombre_prod(scan.next());
        
        System.out.println("Ingrese el codigo del producto: ");
        prod.setCodigo_prod(scan.nextInt()); 
        
        System.out.println("fecha: "+prod.getCaducidad());
        
 
        System.out.println("Ingrese el Proveedor: ");
        prod.setProveedor(scan.next()); 
        
        boolean respuesta = Prodao.Insert(prod);
        
    if (respuesta){
        System.out.println("se guardo el registro");
    }else{
        System.out.println("no se guardo, error");
    
    }
    
    break;
    
            case "B":  //metodo listar
                
       List<Producto> list = Prodao.selectAll();//tambien se puede mostrar de esta forma
        
        for(Producto prod1: list ){ 
        
           // prod1.getId();
            System.out.println("-----------------------");
            System.out.println("                       ");
            System.out.println("El id es: "+prod1.getId());
            System.out.println("nombre : " +prod1.getNombre_prod());
            System.out.println("El codigo es: " +prod1.getCodigo_prod());
            System.out.println("La fecha es: " +prod1.getCaducidad());
            System.out.println("el proveedor es: " +prod1.getProveedor());
            System.out.println("-----------------------");
            
        }
                
                
                break;
                
                default: System.out.println("Escriba las letras solicitadas");
                
        }
                
                
               
                
        
        
        
    
  
    
   


        
    }
}
